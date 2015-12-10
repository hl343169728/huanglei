package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.Employee;

public interface EmployeeDao {
	//增加方法
	void add(Employee e);
	//删除方法
	void del(Employee e);
	//更新方法
	void update(Employee e);
	//查找员工的所有信息的方法
	List<Employee> findAll();
	//根据id查找指定的对象
	Employee findById(Integer id);
}
