package com.bjsxt.model;

/**
 * 班级实体类
 */
public class Clz {
	
	private Long id;// id
	private String cname; // 班级名称
	private String address; // 班级地址
	private String teacher; // 班级的老师
	private int crow; // 班级的行数
	private int ccol; // 班级的列数

	public Clz() {
		super();
	}

	public Clz(Long id, String cname, String address, String teacher, int crow, int ccol) {
		super();
		this.id = id;
		this.cname = cname;
		this.address = address;
		this.teacher = teacher;
		this.crow = crow;
		this.ccol = ccol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getCrow() {
		return crow;
	}

	public void setCrow(int crow) {
		this.crow = crow;
	}

	public int getCcol() {
		return ccol;
	}

	public void setCcol(int ccol) {
		this.ccol = ccol;
	}
}
