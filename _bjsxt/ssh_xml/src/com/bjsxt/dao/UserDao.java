package com.bjsxt.dao;

import com.bjsxt.po.User;
import com.bjsxt.utils.PageInfo;

public interface UserDao {
	void save(User user);
	void del(User user);
	void update(User user);
	PageInfo  findAll(Integer pageNum,String name);
	User findById(int id);
}
