package com.hz.sunday.trend.web.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.dto.page.PageQueryUtils;
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

import com.hz.sunday.trend.TrendConstants;
import com.hz.sunday.trend.bo.InformationBO;
import com.hz.sunday.trend.orm.Information;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.constants.DialogMode;
import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 联系我们
 * 
 * @author huanglei
 */
@Controller
@RequestMapping("/admin/contact")
public class ContactInfoController extends BaseController {
	
	/** 联系我们编辑页*/
	private static final String CONTACT_PAGE = "/trend/contact-input";

	@Autowired
	private InformationBO informationBO;
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
		List<Information> list = informationBO.getList(param);
		Long count = informationBO.getCount(param);
		JsonPageUtils.renderJsonPage(count, list, response);
	}

	/**
	 * 跳转新增、编辑页面
	 * 
	 * @param id
	 * @param mode
	 * @param model
	 * @return
	 */
	@RequestMapping("/{mode}/dispatch")
	public String dispatch(@RequestParam(value = "id", required = false) Long id, @PathVariable String mode, Model model) {
		if (DialogMode.EDIT_MODE.equals(mode)) {
			Information info = informationBO.getSingleDetail(id);
			model.addAttribute("info", info);
			if (null != info) {
				List<Attachement> list = attachementBO.findBy(String.valueOf(id), TrendConstants.MSG_TYPE + info.getmType());
				model.addAttribute("attach", list);
				model.addAttribute("size", (null != list && list.size()>0)?list.size():0);
			}
		}
		return CONTACT_PAGE;
	}

	/**
	 * 保存
	 * 
	 * @param achmentFiles
	 * @param model
	 * @param info
	 * @return
	 */
	@RequestMapping("/save")
	public String save(@RequestParam(value = "files", required = false) CommonsMultipartFile achmentFiles, Model model, Information info) {
		try {
			if (info.getId() != null) {
				informationBO.update(info);
			} else {
				informationBO.insert(info);
			}
			// 对附件的操作
			if (achmentFiles != null) {
				List<Attachement> files = attachementBO.prepareAttachement(achmentFiles);
				if (files != null && files.size() > 0) {
					for (Attachement a : files) {
						a.setType(TrendConstants.MSG_TYPE + info.getmType());// 设置附件类型
						a.setObjId(String.valueOf(info.getId()));// 设置附件所属项目的id
					}
					attachementBO.batchIn(files);
				}
			}
			model.addAttribute("message", "success");// 保存成功
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "failed");// 保存失败
		}
		
		return CONTACT_PAGE;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping("/deleteById")
	public void deleteById(@RequestParam("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		try {
			informationBO.delete(id);
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
			attachementBO.deleteAll(id.toString(), TrendConstants.MSG_TYPE + TrendConstants.CONTACT_TYPE);
			AjaxUtils.renderText(response, "1");// 取消成功
		} catch (Exception e) {
			e.printStackTrace();
			AjaxUtils.renderText(response, "0");// 取消失败
		}
	}

}
