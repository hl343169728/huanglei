package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.Department;

public interface DepartmentDao {
	//添加方法
	void add(Department d);
	//删除方法
	void del(Department d);
	//更新方法
	void update(Department d);
	//获取部门的所有信息的方法
	List<Department> findAll();
	//根据id查找出指定的对象
	Department findById(int id);
}
