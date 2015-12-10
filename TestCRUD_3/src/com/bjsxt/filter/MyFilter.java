package com.bjsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		MyHttpServletRequestWrapper myReq = new MyHttpServletRequestWrapper(req);
		HttpServletResponse resp = (HttpServletResponse)response;
		myReq.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		System.out.println("拦截请求之前...");
		chain.doFilter(myReq, resp);
		System.out.println("拦截请求之后...");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("被初始化了！");
	}
}
