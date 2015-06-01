package com.hz.yisheng.demo.orm;

import java.io.Serializable;

/**
 * 
 * @Description 学生表实体类
 * @author huanglei
 * @date 2015-2-9 下午2:21:47
 * @version 1.0
 * 
 */
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	public Student() {
	}

	private int id;// 学生ID
	private String name; // 学生姓名
	private Clazz clazz;// 班级信息

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		return "id=" + id + ",name=" + name;
	}

}
