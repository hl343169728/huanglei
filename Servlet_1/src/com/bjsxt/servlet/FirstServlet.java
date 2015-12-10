package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println("我的第一个服务器运行程序......");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<style>");
		resp.getWriter().write(".red{color:red}");
		resp.getWriter().write("</style>");
		resp.getWriter().write("<script>");
		resp.getWriter().write("<function test(){alert('Hello world!!')}>");
		resp.getWriter().write("</script>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<form action='two' method='post'>");
		resp.getWriter().write("<input type='text' name='username' value=''><br/>");
		resp.getWriter().write("<input type='password' name='password' value=''><br/>");
		resp.getWriter().write("<input type='submit' value='提交'> ");
		resp.getWriter().write("</form>");
		resp.getWriter().write("<span class='red'>我是中国人</span>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
	}
}
