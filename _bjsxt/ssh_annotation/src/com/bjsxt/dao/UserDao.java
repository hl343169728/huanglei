package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.User;

public interface UserDao {
	//保存方法
	void save(User user);
	//删除方法
	void del(User user);
	//更新方法
	void update(User user);
	//获取所有的用户信息
	List<User> findAll();
	//根据id查找出对应的对象
	User findById(int id);
	//判断当前的用户时候存在
	List<User> checkName(String username) throws Exception;
	//存款增加的方法
	void addMoney(Integer userId,Integer money);
	//存款较少的方法
	void reduceMoney(Integer userId,Integer money);
}
