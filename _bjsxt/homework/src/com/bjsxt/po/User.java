package com.bjsxt.po;

/**
 * 用户实体类
 * @author dell
 *
 */
public class User {
	private int id;
	private String uname;	//用户名
	private String pwd;		//密码
	private int type;		//用户类型
	
	public User() {
		super();
	}
	public User(int id, String uname, String pwd, int type) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.type = type;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
