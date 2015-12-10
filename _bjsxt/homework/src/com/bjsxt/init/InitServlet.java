package com.bjsxt.init;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet{
	
	/**
	 * 初始化方法
	 */
	@Override
	public void init() throws ServletException {
		Map<Integer,Object> userType = new HashMap<Integer,Object>();
		userType.put(1,"教师");
		userType.put(2,"学生");
		this.getServletContext().setAttribute("userType", userType);
	}
}
