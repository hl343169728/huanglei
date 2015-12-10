package com.bjsxt.service;

import java.util.List;

import com.bjsxt.po.Student;
import com.bjsxt.utils.PageInfo;

public interface StudentService {

	//添加方法
	void add(Student s) throws Exception;
	//查询学员所有信息的方法
	List<Student> findAll() throws Exception;
	//预修改的方法
	Student findById(Integer id);
	//真正的修改方法
	void update(Student s) throws Exception;
	//删除方法
	void del(Integer id) throws Exception;
	//查询学员的信息及实现分页
	PageInfo findAll(Integer pageNum, String sname) throws Exception;

}
