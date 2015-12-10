package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.Owner;

public interface OwnerDao {
	//添加方法
	void add(Owner owner);
	//删除方法
	void del(Owner owner);
	//更新方法
	void update(Owner owner);
	//查找所有的业主信息的方法
	List<Owner> findAll();
	//根据id获取指定的对象
	Owner findById(Integer id);
}
