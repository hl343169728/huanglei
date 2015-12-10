package com.bjsxt.action;

import java.util.Map;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.po.User;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("unchecked")
public class UserAction extends BaseAction{
	private User user;
	private String uname;
	private String pwd;
	private int type;
	private int id;
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
		System.out.println(this.type);
		if(user != null){
			session.put("user",user);
			if(1 == type){
				return "welcomeTeacher";
			}else{
				return "welcomeStudent";
			}
		}else{
			request.put("error","用户名或密码不正确！！！");
			return "login";
		}
	}
	
	/**
	 * 用户注册保存的方法
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception{
		this.udao.save(this.user);
		return "success";
	}
	
	/**
	 * getter 和 setter方法
	 * @return
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	public UserDao getUdao() {
		return udao;
	}
	public void setUdao(UserDao udao) {
		this.udao = udao;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
