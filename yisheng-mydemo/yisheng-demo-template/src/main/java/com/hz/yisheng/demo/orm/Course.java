package com.hz.yisheng.demo.orm;

import java.io.Serializable;

/**
 * 
 * @Description 课程表实体
 * @author huanglei
 * @date 2015-2-9 下午1:57:23
 * @version 1.0
 * 
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;// 课程ID
	private String name; // 课程名

	public Course() {
	}

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

}
