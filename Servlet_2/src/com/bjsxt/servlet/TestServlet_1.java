package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet_1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//改变属性值
		String name = username + "1314520";
		String pwd = password + "1314520";
		
		request.setAttribute("param1",name);
		request.setAttribute("param2",pwd);
		
		//请求转发
		//request.getRequestDispatcher("TestServlet_2").forward(request, response);
		
		//重定向
		//response.sendRedirect("TestServlet_2");
		response.sendRedirect("TestServlet_2?username="+username+"&password="+password);
	}
}
