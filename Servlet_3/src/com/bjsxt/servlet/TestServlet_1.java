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
		//System.out.println(username+","+password);
		
		String name = username+"1234567";
		String pwd = password+"1234567";
		request.setAttribute("n",name);
		request.setAttribute("p",pwd);
		
		//请求转发     地址栏不改变
		//request.getRequestDispatcher("TestServlet_2").forward(request, response);
		//重定向  地址栏发生改变
		//response.sendRedirect("TestServlet_2");
		response.sendRedirect("TestServlet_2?username="+username+"&password="+password);
	}
}
