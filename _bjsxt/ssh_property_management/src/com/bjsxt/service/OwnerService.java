package com.bjsxt.service;

import java.util.List;

import com.bjsxt.po.Owner;

public interface OwnerService {

	//添加方法
	void add(Owner owner) throws Exception;

	//查找所有信息的方法
	List<Owner> findAll() throws Exception;

	//根据id查找指定的对象
	Owner findById(Integer id) throws Exception;

	//更新方法
	void update(Owner o) throws Exception;

	//删除方法
	void del(Integer id) throws Exception;
}
