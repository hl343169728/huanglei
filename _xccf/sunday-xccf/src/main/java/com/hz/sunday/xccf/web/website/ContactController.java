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
 * 联系方式
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/contact")
public class ContactController extends BaseController {
	
	/** 联系方式页面*/
	private static final String CONTACT_PAGE = "/website/contact";
	
	@Autowired
	private MessageInfoBO messageInfoBO;

	/**
	 * 联系方式
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.CONTACT_TYPE);
		
		// 联系方式
		initContact(model);
		// 广告位
		initAdvert(model);

		return CONTACT_PAGE;
	}
	
	/**
	 * 初始化首页顶部广告位
	 * 
	 * @param model
	 */
	private void initAdvert(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.UP_ADVERT_IMAGE);
		List<MessageInfo> upAdvertList = messageInfoBO.getList(queryMap);
		model.addAttribute("upAdvertList", upAdvertList);	
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

}
