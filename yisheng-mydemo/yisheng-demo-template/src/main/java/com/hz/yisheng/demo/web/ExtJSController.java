package com.hz.yisheng.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javafans.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ExtJS
 * 
 * @author huanglei
 * @date 2015年5月5日 下午5:21:56
 * @version V1.0
 */
@Controller
@RequestMapping(value = "/demo/extJS")
public class ExtJSController extends BaseController {

	private static final String LOGIN_PAGE = "/extjs/login";
	
	private static final String INDEX_PAGE = "/extjs/index";
	
	private static final String TREEPANEL_PAGE = "/extjs/treePanel";

	/**
	 * 登陆页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return LOGIN_PAGE;
	}
	
	/**
	 * 布局
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, HttpServletResponse response) {

		return INDEX_PAGE;
	}
	
	/**
	 * treePanel
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/treePanel")
	public String treePanel(HttpServletRequest request, HttpServletResponse response) {

		return TREEPANEL_PAGE;
	}

}
