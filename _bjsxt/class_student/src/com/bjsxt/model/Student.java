package com.bjsxt.model;

/**
 * 学生实体类
 */
public class Student {
	private int    id;			//主键id
	private String sname;		//姓名
	private String phone;		//联系方法
	private int    age;			//年龄
	private String imagePath;	//图片路径
	private int    srow;		//学生行号
	private int    scol;		//学生列号
	private int    cid;			//班级的id
	
	public Student() {
		super();
	}
	public Student(int id, String sname, String phone, int age,
			String imagePath, int srow, int scol, int cid) {
		super();
		this.id = id;
		this.sname = sname;
		this.phone = phone;
		this.age = age;
		this.imagePath = imagePath;
		this.srow = srow;
		this.scol = scol;
		this.cid = cid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getSrow() {
		return srow;
	}
	public void setSrow(int srow) {
		this.srow = srow;
	}
	public int getScol() {
		return scol;
	}
	public void setScol(int scol) {
		this.scol = scol;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
}
