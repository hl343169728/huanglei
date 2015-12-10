package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FourServlet extends HttpServlet {
	
	int i=0;

	@Override
	public void init() throws ServletException {
		System.out.println("servelt被初始化了...");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		i++;
		//System.out.println(i);
		//testRequest(request, response);
		//testRequest_2(request, response);
		//getHeaders(request, response);
		important(request, response);
		//testResponse(request, response);
	}
	
	/**
	 * 获取客户端和服务器端的消息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("客户端ip地址："+request.getRemoteAddr());
		System.out.println("客户端端口："+request.getRemotePort());
		System.out.println("服务器端ip地址："+request.getLocalAddr());
		System.out.println("服务器端端口："+request.getLocalPort());
	}
	
	/**
	 * 获取请求行信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testRequest_2(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("请求方式："+request.getMethod());
		System.out.println("端口号到问号之间的内容："+request.getRequestURI());
		System.out.println("参数字符串：问号之后的内容："+request.getQueryString());
		System.out.println("所用的协议："+request.getScheme());
		System.out.println("Web应用的根目录："+request.getContextPath());
		System.out.println("获取问号之前的内容："+request.getRequestURL());
	}
	/**
	 * 获取请求头的信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getHeaders(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String headKey = (String)e.nextElement();
			System.out.println(headKey+":"+request.getHeader(headKey));
		}
	}
	
	/**
	 * getParameter() &  getParameterValues()
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void important(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		System.out.println("a="+a);
		System.out.println("b="+b);
		String[] c = request.getParameterValues("c");
		for (int i = 0; i < c.length; i++) {
			System.out.println("c"+i+"值为："+c[i]);
		}
	}
	
	/**
	 * response() 方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void testResponse(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//只要你想往回写出内容，就必须加上这行代码
		response.setContentType("text/html;charset=utf-8");
		//输出内容
		PrintWriter out = response.getWriter();
		out.write("第一种方式：写出字符串");
		System.out.println("\n");
		out.write("第二种方式：写出字符串");
		//response.getOutputStream().write(100);
	}
	
	@Override
	public void destroy() {
		System.out.println("servelt被卸载了...");
	}
	
}
