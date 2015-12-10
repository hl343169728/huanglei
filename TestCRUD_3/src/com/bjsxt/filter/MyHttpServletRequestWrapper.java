package com.bjsxt.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

	// private static String[] words = {"小","强","无","敌"};
	private String doFilter(String str) {
		String newstr = "";
		if (str != null) {
			newstr = str.replaceAll("小强", "");
		}
		return newstr;
	}

	public MyHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	// 重写父类的方法
	@Override
	public String getParameter(String param) {
		// 取得父类的getParamter
		String str = super.getParameter(param);
		return doFilter(str);
	}
}
