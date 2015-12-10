package com.bjsxt.po;

/**
 * 用户实体类  ，要与数据库中定义的字段保持一一对应
 * @author dell
 *
 */
public class User {
	private int id;
	private String uname;	//用户名
	private String pwd;		//用户密码
	
	public User() {
		super();
	}
	public User(int id, String uname, String pwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}
