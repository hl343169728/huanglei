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

import com.hz.sunday.trend.bo.InformationBO;
import com.hz.sunday.trend.orm.Information;
import com.hz.yisheng.commondata.constants.DialogMode;

/**
 * 业务咨询
 * 
 * @author huanglei
 */
@Controller
@RequestMapping("/admin/consult")
public class ConsultInfoController extends BaseController {
	
	/** 业务咨询编辑页*/
	private static final String CONSULT_PAGE = "/trend/consult-input";

	@Autowired
	private InformationBO informationBO;

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
			model.addAttribute("info", informationBO.getSingleDetail(id));
		}
		
		return CONSULT_PAGE;
	}

	/**
	 * 保存
	 * 
	 * @param model
	 * @param info
	 * @return
	 */
	@RequestMapping("/save")
	public String save( Model model, Information info) {
		try {
			if (info.getId() != null) {
				informationBO.update(info);
			} else {
				informationBO.insert(info);
			}
			model.addAttribute("message", "success");// 保存成功
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "failed");// 保存失败
		}
		
		return CONSULT_PAGE;
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
	
}
