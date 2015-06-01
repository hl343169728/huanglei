package com.hz.sunday.xccf.web.website;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.dto.page.PageQueryUtils;
import org.javafans.web.JSONUtils;
import org.javafans.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Maps;
import com.hz.sunday.xccf.bo.MessageInfoBO;
import com.hz.sunday.xccf.constants.ColumnType;
import com.hz.sunday.xccf.orm.MessageInfo;
import com.hz.yisheng.commondata.bo.AttachementBO;
import com.hz.yisheng.commondata.orm.Attachement;

/**
 * 新闻中心
 * 
 * @author huanglei
 * @date 2015年4月14日
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/xccf/news")
public class NewsController extends BaseController {
	
	/** 新闻页*/
	private static final String WEBSITE_NEWS = "/website/news";
	/** 新闻详情*/
	private static final String WEBSITE_NEWS_DETAIL = "/website/newsDetail";
	
	@Autowired
	private MessageInfoBO messageInfoBO;
	@Autowired
	private AttachementBO attachementBO;

	/**
	 * 新闻中心
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.NEWS_TYPE);
		
		// 新闻中心
		initNews(request, response, model);
		// 组织机构
		initStructure(model);
		// 联系方式
		initContact(model);
		// 论坛介绍
		initAbout(model);
		
		return WEBSITE_NEWS;
	}
	
	/**
	 * 初始化论坛介绍
	 * 
	 * @param model
	 */
	private void initAbout(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.ABOUT_TYPE);
		List<MessageInfo> aboutList = messageInfoBO.getList(queryMap);
		model.addAttribute("aboutList", aboutList);		
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
	 * 初始化组织机构
	 * 
	 * @param model
	 */
	private void initStructure(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mtype", ColumnType.STRUCTURE_TYPE);
		List<MessageInfo> structureList = messageInfoBO.getList(queryMap);
		List<MessageInfo> hostList = new ArrayList<MessageInfo>();
		List<MessageInfo> soleList = new ArrayList<MessageInfo>();
		List<MessageInfo> speciList = new ArrayList<MessageInfo>();
		if (null != structureList && structureList.size() > 0) {
			for (MessageInfo info : structureList) {
				if (null != info.getTitle() && info.getTitle().equals("1")) {
					hostList.add(info);
				} else if (null != info.getTitle() && info.getTitle().equals("2")) {
					soleList.add(info);
				} else {
					speciList.add(info);
				}
			}
		}
		model.addAttribute("hostList", hostList);
		model.addAttribute("soleList", soleList);
		model.addAttribute("speciList", speciList);
	}

	/**
	 * 初始化新闻中心
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	private void initNews(HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, Object> queryMap = PageQueryUtils.preparePage(request);
		queryMap.put("mtype", ColumnType.NEWS_TYPE);
		queryMap.put("menuType", ColumnType.NEWS_TYPE);
		Integer from = null;
		Integer pageSize = (Integer) queryMap.get("size");
		Integer rowStart = (Integer) queryMap.get("from");
		String resource = (String) queryMap.get("reource");
		if(null != pageSize && null != rowStart) {
			queryMap.put("pageSize", pageSize);
			queryMap.put("rowStart", rowStart);
			from = pageSize + rowStart;
		} else {
			from = (Integer) queryMap.get("pageSize");
		}
		List<MessageInfo> newsList = messageInfoBO.getList(queryMap);
		if (null != newsList && newsList.size() > 0) {
			if (null != resource) {
				for (MessageInfo info : newsList) {
					info.setFrom(from);
				}
			} else {
				model.addAttribute("from", from);
			}
			model.addAttribute("listSize", newsList.size()); 
		}
		model.addAttribute("newsList", newsList);
		if (null != resource) {
			JSONUtils.objToJSON(response, newsList);
		}
	}

	/**
	 * 新闻详情
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(@RequestParam("id") Long id,HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("columnValue", ColumnType.NEWS_TYPE);
		
		// 组织机构
		initStructure(model);
		// 联系方式
		initContact(model);
		// 论坛介绍
		initAbout(model);
		MessageInfo info = messageInfoBO.getSingleDetail(id);
		model.addAttribute("newsInfo", info);
		if (null != info) {
			String mtype = "messnoti" + info.getMtype();
			List<Attachement> list = attachementBO.findBy(String.valueOf(id), mtype);
			model.addAttribute("attList", list);
		}

		return WEBSITE_NEWS_DETAIL;
	}

}
