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
 * 顶尖领袖团
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/leader")
public class LeaderController extends BaseController {
	
	/** 顶尖领导团*/
	private static final String WEBSITE_LEADER = "/website/leader";
	
	@Autowired
	private MessageInfoBO messageInfoBO;

	/**
	 * 顶尖领袖团
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.LEADER_TYPE);
		
		// 顶尖领袖团
		initLeader(model);
		// 联系方式
		initContact(model);

		return WEBSITE_LEADER;
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
	 * 初始化顶尖领袖团
	 * 
	 * @param model
	 */
	private void initLeader(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.LEADER_TYPE);
		List<MessageInfo> leaderList = messageInfoBO.getList(queryMap);
		model.addAttribute("leaderList", leaderList);		
	}

}
