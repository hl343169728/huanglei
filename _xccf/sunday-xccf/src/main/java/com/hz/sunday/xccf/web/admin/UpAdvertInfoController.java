package com.hz.sunday.xccf.web.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.javafans.common.utils.io.FileUtils;
import org.javafans.dto.page.PageQueryUtils;
import org.javafans.resources.ResourceConfig;
import org.javafans.web.AjaxUtils;
import org.javafans.web.JsonPageUtils;
import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.hz.sunday.xccf.bo.MessageInfoBO;
import com.hz.sunday.xccf.constants.ColumnType;
import com.hz.sunday.xccf.orm.MessageInfo;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.constants.DialogMode;
import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 首页顶部广告位管理
 * 
 * @author huanglei
 * @date 2015年4月28日 下午1:35:22
 * @version V1.0
 */
@Controller
@RequestMapping("/admin/upAdvert")
public class UpAdvertInfoController extends BaseController {
	
	/** 广告位页面*/
	private static final String ADVERT_PAGE = "/xccf/advert/upAdvertDlg";

	@Autowired
	private MessageInfoBO messageInfoBO;
	@Autowired
	private AttachementBO attachementBO;

	/**
	 * 信息列表
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> param = PageQueryUtils.preparePage(request);
		List<MessageInfo> list = messageInfoBO.getList(param);
		Long count = messageInfoBO.getCount(param);
		JsonPageUtils.renderJsonPage(count, list, response);
	}

	/**
	 * 跳转新增/编辑页面
	 * 
	 * @param id
	 * @param mode
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/{mode}/dispatch")
	public String dispatch(
			@RequestParam(value = "id", required = false) Long id,
			@PathVariable String mode, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if (DialogMode.EDIT_MODE.equals(mode)) {
			MessageInfo info = messageInfoBO.getSingleDetail(id);
			model.addAttribute("messnoti", info);
			if (null != info) {
				String mtype = "messnoti" + info.getMtype();
				List<Attachement> list = attachementBO.findBy(String.valueOf(id), mtype);
				model.addAttribute("mnattach", list);
				model.addAttribute("size", list.size());
			}
		}
		return ADVERT_PAGE;
	}

	/**
	 * 保存
	 * 
	 * @param achmentFiles
	 * @param model
	 * @param request
	 * @param response
	 * @param msgInfo
	 * @return
	 */
	@RequestMapping("/save")
	public String save(
			@RequestParam(value = "files", required = false) CommonsMultipartFile achmentFiles,
			Model model, HttpServletRequest request,
			HttpServletResponse response, MessageInfo msgInfo) {
		try {
			if (msgInfo.getId() != null) {
				messageInfoBO.update(msgInfo);// 更新
				if (achmentFiles != null && !achmentFiles.isEmpty()) {
					Attachement att = attachementBO.findAttachementBy(msgInfo.getId().toString(),"messnoti" + msgInfo.getMtype());
					if (null != att) {
						FileItem item = achmentFiles.getFileItem();
						String filePath = FileUtils.saveFile(item.getInputStream(), ResourceConfig.getSysConfig("fileUploadPath"), item.getName(), item.getContentType());
						attachementBO.updatePath(filePath, msgInfo.getId().toString(), "messnoti" + msgInfo.getMtype());
					} else {
						// 对附件的操作
						if (achmentFiles != null) {
							List<Attachement> files = attachementBO.prepareAttachement(achmentFiles);
							if (files != null && files.size() > 0) {
								for (Attachement a : files) {
									a.setType("messnoti" + msgInfo.getMtype());// 设置附件类型
									a.setObjId(String.valueOf(msgInfo.getId()));// 设置附件所属项目的id
								}
								attachementBO.batchIn(files);
							}
						}
					}
				}
			} else {
				messageInfoBO.insert(msgInfo);// 新增
				// 对附件的操作
				if (achmentFiles != null) {
					List<Attachement> files = attachementBO.prepareAttachement(achmentFiles);
					if (files != null && files.size() > 0) {
						for (Attachement a : files) {
							a.setType("messnoti" + msgInfo.getMtype());// 设置附件类型
							a.setObjId(String.valueOf(msgInfo.getId()));// 设置附件所属项目的id
						}
						attachementBO.batchIn(files);
					}
				}
			}
			model.addAttribute("message", "success");// 保存成功
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "failed");// 保存失败
		}
		return ADVERT_PAGE;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteById")
	public void deleteById(@RequestParam("id") Long id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			messageInfoBO.delete(id);
			AjaxUtils.renderText(response, "1");// 删除成功
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, "0");// 删除失败
		}
	}
	
	/**
	 * 取消附件
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/cancel")
	public void cancel(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		try {
			attachementBO.deleteAll(id.toString(), "messnoti" + ColumnType.UP_ADVERT_IMAGE);
			AjaxUtils.renderText(response, "1");// 取消成功
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, "0");// 取消失败
		}
	}

}
