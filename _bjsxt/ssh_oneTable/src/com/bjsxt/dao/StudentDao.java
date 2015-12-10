package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.Student;
import com.bjsxt.utils.PageInfo;

public interface StudentDao {
	//添加方法
	void add(Student s);
	//删除方法
	void del(Student s);
	//更新方法
	void update(Student s);
	//查询所有信息的方法
	List<Student> findAll();
	//根据id查找指定的对象的方法
	Student findById(int id);
	
	public PageInfo findAll(Integer pageNum,String sname);
}
