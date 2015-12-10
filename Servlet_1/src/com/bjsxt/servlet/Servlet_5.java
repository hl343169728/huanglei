package com.bjsxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//testRequest(request, response);
		//testRequest_2(request, response);
		//getHeaders(request, response);
		//important(request, response);
		testResponse(request, response);
	}
	
	/**
	 * 客户端和服务器端的信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("客户端的ip地址："+request.getRemoteAddr());
		System.out.println("客户端的端口号："+request.getRemotePort());
		System.out.println("服务器端的ip地址："+request.getLocalAddr());
		System.out.println("服务器端的端口号："+request.getLocalPort());
	}
	/**
	 * 获取请求行信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testRequest_2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("请求方法："+request.getMethod());
		System.out.println("端口号到问号之间的内容："+request.getRequestURI());
		System.out.println("问号之后的内容："+request.getQueryString());
		System.out.println("问号之前的内容："+request.getRequestURL());
		System.out.println("遵循的协议："+request.getScheme());
		System.out.println("web应用的根目录："+request.getContextPath());//  /Servlet
	}
	/**
	 * 请求头信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getHeaders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String headKey = (String) e.nextElement();
			System.out.println(headKey  + "    "+request.getHeader(headKey));
		}
	}
	/**
	 * request.getParameter(String name);  
	 * request.getParameterValues(String name); 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void important(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		System.out.println("a="+a+",b="+b);
		String[] c = request.getParameterValues("c");
		for (int i = 0; i < c.length; i++) {
			System.out.println("c="+c[i]);
		}
	}
	/**
	 * response() 的用法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testResponse(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("字符串内容");
	}
}
