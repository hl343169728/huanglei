package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet_3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletConfig sc = this.getServletConfig();
		//返回名为aaa的参数的值
		String a = sc.getInitParameter("aaa");
		String b = sc.getInitParameter("bbb");
		System.out.println(a);
		System.out.println(b);
		//返回所属的servlet的名字
		String c = sc.getServletName();
		
		System.out.println("--------------------------------------");
		ServletContext context = this.getServletContext();
		
		context.setAttribute("a","1314520");
		//重定向
		response.sendRedirect("TestServlet_4");
	}
}
