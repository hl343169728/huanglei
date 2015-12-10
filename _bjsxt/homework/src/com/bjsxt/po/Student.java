package com.bjsxt.po;

public class Student {
	private int id;
	private String sname;
	private String pwd;
	private int classId;
	public Student(int id, String sname, String pwd, int classId) {
		super();
		this.id = id;
		this.sname = sname;
		this.pwd = pwd;
		this.classId = classId;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
