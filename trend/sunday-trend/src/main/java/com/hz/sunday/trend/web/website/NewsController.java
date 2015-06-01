package com.hz.sunday.trend.web.website;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Maps;
import com.hz.sunday.trend.TrendConstants;
import com.hz.sunday.trend.bo.InformationBO;
import com.hz.sunday.trend.orm.Information;

/**
 * 新闻动态
 * 
 * @author huanglei
 */
@Controller
@RequestMapping(value = "/trend/news")
public class NewsController {
	
	private static final String WEB_NEWS = "/web/news";
	
	private static final String WEB_NEWS_DETAIL = "/web/newsDetail";
	
	@Autowired
	private InformationBO informationBO;
	
	/**
	 * 加载新闻动态
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model){
		model.addAttribute("columnValue", TrendConstants.NEWS_TYPE);
		// 初始化新闻动态
		initNews(model);
		// 初始化次级页面LOGO
		initLogo(model);
		// 初始化最新公告
		initNotice(model);
		// 初始化联系方式
		initContact(model);
		// 初始化业务咨询
		initConsult(model);
		// 初始化网站底部LOGO
		initFooterLogo(model);
		
		return WEB_NEWS;
	}
	
	/**
	 * 新闻详情
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		model.addAttribute("columnValue", TrendConstants.NEWS_TYPE);
		
		// 初始化次级页面LOGO
		initLogo(model);
		// 初始化最新公告
		initNotice(model);
		// 初始化联系方式
		initContact(model);
		// 初始化业务咨询
		initConsult(model);
		// 初始化网站底部LOGO
		initFooterLogo(model);

		Information info = informationBO.getSingleDetail(id);
		model.addAttribute("info", info);

		return WEB_NEWS_DETAIL;
	}
	
	/**
	 * 加载网站底部LOGO
	 * 
	 * @param model
	 */
	private void initFooterLogo(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.FOOTER_LOGO);
		List<Information> footerList = informationBO.getList(queryMap);
		model.addAttribute("footerList", footerList);	
	}
	
	/**
	 * 加载业务咨询
	 * 
	 * @param model
	 */
	private void initConsult(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.BUSINESS_CONSULT);
		List<Information> consultList = informationBO.getList(queryMap);
		model.addAttribute("consultList", consultList);	
	}
	
	/**
	 * 加载联系方式
	 * 
	 * @param model
	 */
	private void initContact(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.CONTACT_TYPE);
		List<Information> contactList = informationBO.getList(queryMap);
		model.addAttribute("contactList", contactList);	
	}
	
	/**
	 * 加载网站公告
	 * 
	 * @param model
	 */
	private void initNotice(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.NOTICE_TYPE);
		List<Information> noticeList = informationBO.getList(queryMap);
		model.addAttribute("noticeList", noticeList);	
	}
	
	/**
	 * 加载次级页面LOGO
	 * 
	 * @param model
	 */
	private void initLogo(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.SECOND_LOGO);
		List<Information> logoList = informationBO.getList(queryMap);
		model.addAttribute("logoList", logoList);	
	}


	/**
	 * 加载新闻动态
	 * 
	 * @param model
	 */
	private void initNews(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.NEWS_TYPE);
		List<Information> newsList = informationBO.getList(queryMap);
		model.addAttribute("newsList", newsList);	
	}
}
