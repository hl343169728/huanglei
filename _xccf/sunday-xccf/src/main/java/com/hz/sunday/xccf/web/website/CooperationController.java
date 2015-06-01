package com.hz.sunday.xccf.web.website;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.hz.sunday.xccf.bo.MessageInfoBO;
import com.hz.sunday.xccf.constants.ColumnType;
import com.hz.sunday.xccf.orm.MessageInfo;

/**
 * 合作媒体
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/cooperation")
public class CooperationController extends BaseController {
	
	/** 论坛介绍页面*/
	private static final String COOPERATION_PAGE = "/website/cooperation";
	
	@Autowired
	private MessageInfoBO messageInfoBO;

	/**
	 * 合作媒体
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.COOPERATION_TYPE);
		
		// 合作媒体
		initCooperation(model);
		// 联系方式
		initContact(model);

		return COOPERATION_PAGE;
	}
	
	/**
	 * 初始化联系方式
	 * 
	 * @param model
	 */
	private void initContact(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.CONTACT_TYPE);
		List<MessageInfo> contactList = messageInfoBO.getList(queryMap);
		model.addAttribute("contactList", contactList);	
	}
	
	/**
	 * 初始化合作媒体
	 * 
	 * @param model
	 */
	private void initCooperation(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.COOPERATION_TYPE);
		List<MessageInfo> cooperationList = messageInfoBO.getList(queryMap);
		model.addAttribute("cooperationList", cooperationList);		
	}

}
