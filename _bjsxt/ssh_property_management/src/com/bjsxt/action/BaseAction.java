package com.bjsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * baseAction     
 */ 
public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = -3068675701440713082L;
	protected HttpServletRequest request  =  ServletActionContext.getRequest();
	protected HttpServletResponse  response  = ServletActionContext.getResponse(); 
	protected HttpSession   session  = request.getSession();
	
	/**
	 * 输出的方法
	 * @throws IOException 
	 */
	protected void myWriter(String json) throws IOException {
		this.response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = this.response.getWriter();
		pw.write(json);
		pw.close();
	}
}
