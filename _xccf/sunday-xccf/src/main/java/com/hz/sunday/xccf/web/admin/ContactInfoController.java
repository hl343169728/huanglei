package com.hz.sunday.xccf.web.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.dto.page.PageQueryUtils;
import org.javafans.web.JsonPageUtils;
import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hz.sunday.xccf.bo.MessageInfoBO;
import com.hz.sunday.xccf.orm.MessageInfo;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.constants.DialogMode;

/**
 * 联系方式管理
 * 
 * @author huanglei
 * @date 2015年4月28日 上午9:36:38
 * @version V1.0
 */
@Controller
@RequestMapping("/admin/contact")
public class ContactInfoController extends BaseController {
	
	/** 联系方式编辑页*/
	private static final String CONTACT_PAGE = "/xccf/contact/contactDlg";

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
	public String dispatch(@RequestParam(value = "id", required = false) Long id, @PathVariable String mode, Model model, HttpServletRequest request, HttpServletResponse response) {
		if (DialogMode.EDIT_MODE.equals(mode)) {
			model.addAttribute("messnoti", messageInfoBO.getSingleDetail(id));
		}
		return CONTACT_PAGE;
	}

	/**
	 * 保存
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param msgInfo
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request, HttpServletResponse response, MessageInfo msgInfo) {
		try {
			if (msgInfo.getId() != null) {
				messageInfoBO.update(msgInfo);// 更新
			} else {
				messageInfoBO.insert(msgInfo);// 新增
			}
			model.addAttribute("message", "success");// 保存成功
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "failed");// 保存失败
		}
		return CONTACT_PAGE;
	}

}
