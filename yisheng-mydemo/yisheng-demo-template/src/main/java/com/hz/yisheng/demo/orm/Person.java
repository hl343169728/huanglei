package com.hz.yisheng.demo.orm;

import java.io.Serializable;

/**
 * 
 * @Description 人员信息表实体类
 * @author huanglei   
 * @date 2015-2-9 下午3:54:41     
 * @version 1.0
 *
 */
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id; // 人员ID
	private String name; // 姓名
	private int age; // 年龄
	private String sex; // 性别

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
