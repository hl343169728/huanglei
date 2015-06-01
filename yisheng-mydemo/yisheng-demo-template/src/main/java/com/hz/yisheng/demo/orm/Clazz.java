package com.hz.yisheng.demo.orm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @Description 班级表实体类
 * @author huanglei
 * @date 2015-2-9 下午2:19:25
 * @version 1.0
 * 
 */
public class Clazz implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id; // 班级ID
	private String name; // 班级名称
	private Set<Student> students = new HashSet<Student>();// 学生信息

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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String toString() {
		return "id=" + id + ",name=" + name;
	}

}
