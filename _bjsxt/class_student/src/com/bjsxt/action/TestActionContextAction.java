package com.bjsxt.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestActionContextAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String execute() throws Exception {
		this.uname = "This is a dog!";
		ActionContext ac = ActionContext.getContext();
		System.out.println(ac);
		return "SUCCESS";
	}
}
