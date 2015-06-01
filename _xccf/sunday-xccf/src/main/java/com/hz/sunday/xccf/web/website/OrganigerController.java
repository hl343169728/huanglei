package com.hz.sunday.xccf.web.website;

import java.util.ArrayList;
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
 * 总策划人
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/organiger")
public class OrganigerController extends BaseController {
	
	/** 总策划人*/
	private static final String WEBSITE_ORGANIGER = "/website/organiger";
	
	@Autowired
	private MessageInfoBO messageInfoBO;

	/**
	 * 总策划人
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.ORGANIGER_TYPE);
		
		// 总策划人
		initOrganiger(model);
		// 底部轮播图片
		initDownTurn(model);
		// 联系方式
		initContact(model);

		return WEBSITE_ORGANIGER;
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
	 * 初始化底部轮播图片
	 * 
	 * @param model
	 */
	private void initDownTurn(Model model) {
		Map<String,Object> turnMap = Maps.newHashMap();
		turnMap.put("mtype", ColumnType.DOWN_TURN_IMAGE);
		List<MessageInfo> imgList = messageInfoBO.getList(turnMap);
		List<MessageInfo> infoList = new ArrayList<MessageInfo>();
		List<MessageInfo> resultList = new ArrayList<MessageInfo>();
		for (MessageInfo info : imgList) {
			infoList.add(info);
			if (null != infoList && infoList.size()%3 == 0) {
				info.setInfoList(infoList);
				resultList.add(info);
				infoList = new ArrayList<MessageInfo>();
			}
		}
		model.addAttribute("resultList", resultList);		
	}

	/**
	 * 总策划人
	 * 
	 * @param model
	 */
	private void initOrganiger(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.ORGANIGER_TYPE);
		List<MessageInfo> organigerList = messageInfoBO.getList(queryMap);
		model.addAttribute("organigerList", organigerList);		
	}

}
