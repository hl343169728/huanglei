package com.bjsxt.action;

import java.util.Map;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.po.User;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("unchecked")
public class UserAction extends BaseAction{
	private String uname ;
	private String pwd;
	private UserDao udao = new UserDaoImpl();
	private ActionContext ac = ActionContext.getContext();
	Map<String,Object> session = ac.getSession();
	Map<String,Object> request = (Map<String, Object>) ac.get("request");
	
	/**
	 * 用户登录的方法
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		User user = this.udao.findLoginUser(uname,pwd);
		if(user != null){//获取用户后，判断用户是否为空，如果当前用户不为空，跳转到欢迎"welcome"界面
			session.put("user",user);
			return "welcome";
		}else{//如果当前的用户为空，提醒用户“”
			request.put("error","用户名或密码不正确，请仔细核实后再登录！！！");
			return "login";
		}
	}
	
	/**
	 * getter和setter 方法
	 * @return
	 */
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
