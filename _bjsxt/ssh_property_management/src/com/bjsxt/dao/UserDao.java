package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.User;

public interface UserDao {
	//添加方法
	void add(User user);
	//删除方法
	void del(User user);
	//更新方法
	void update(User user);
	//查找所有的信息
	List<User>  findAll();
	//根据id查找指定的对象
	User findById(int id);
}
