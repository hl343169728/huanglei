package com.bjsxt.po;

public class Teacher {
	private int id;
	private String tname;
	private String pwd;
	
	public Teacher() {
		super();
	}
	public Teacher(int id, String tname, String pwd) {
		super();
		this.id = id;
		this.tname = tname;
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
