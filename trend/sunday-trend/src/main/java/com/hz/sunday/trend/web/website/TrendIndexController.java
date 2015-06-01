package com.hz.sunday.trend.web.website;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;
import com.hz.sunday.trend.TrendConstants;
import com.hz.sunday.trend.bo.InformationBO;
import com.hz.sunday.trend.orm.Information;

/**
 * 首页
 * 
 * @author huanglei
 */
@Controller
public class TrendIndexController {
	
	private static final String WEB_INDEX = "/web/index";
	
	@Autowired
	private InformationBO informationBO;
	
	/**
	 * 加载网站首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model){
		model.addAttribute("columnValue", TrendConstants.INDEX_TYPE);
		
		// 初始化首页LOGO
		initLogo(model);
		// 初始化知名品牌
		initBrand(model);
		// 初始化店面形象
		initStoreFront(model);
		// 初始化联系方式
		initContact(model);
		// 初始化网站底部LOGO
		initFooterLogo(model);
		
		return WEB_INDEX;
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
	 * 加载店面形象
	 * 
	 * @param model
	 */
	private void initStoreFront(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.SHOP_TYPE);
		List<Information> shopList = informationBO.getList(queryMap);
		model.addAttribute("shopList", shopList);	
	}
	
	/**
	 * 加载知名品牌
	 * 
	 * @param model
	 */
	private void initBrand(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.BRAND_TYPE);
		List<Information> brandList = informationBO.getList(queryMap);
		model.addAttribute("brandList", brandList);	
	}

	/**
	 * 加载首页LOGO
	 * 
	 * @param model
	 */
	private void initLogo(Model model) {
		Map<String, Object> queryMap = Maps.newHashMap();
		queryMap.put("mType", TrendConstants.FIRST_LOGO);
		List<Information> logoList = informationBO.getList(queryMap);
		model.addAttribute("logoList", logoList);	
	}
}
