package com.bjsxt.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet_4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//System.out.println(this.getServletContext().getAttribute("a").toString());
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath("/WEB-INF");//取得项目发布的真实路径
		System.out.println(realPath);
		System.out.println("--------------------------");
		
		Set<String> set = context.getResourcePaths("/images");
		String contextPath = context.getContextPath();
		//System.out.println(contextPath);
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			response.getWriter().write(" <img src="+contextPath+string+" />");
		}
		InputStream is = context.getResourceAsStream("/File/test.txt");
		FileOutputStream fos = new FileOutputStream("d:\\1.txt");
		int temp = 0;
		while((temp=is.read())!=-1){
			fos.write(temp);
		}
	}
}
