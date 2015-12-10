package com.bjsxt.dao;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.model.User;


public interface UserDao extends BaseDao<User> {

}

//++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
public interface UserDao{
	
	//保存方法
	void save(Object obj) throws Exception;
	//更新方法
	void update(Object obj) throws Exception;
	//删除方法
	void delete(int id) throws Exception;
	//根据id获取对应的对象
	Object findById(int id) throws Exception;
	//获取所有
	List<Object> findAll() throws Exception;
}
*/
//+++++++++++++++++++++++++++++++++++++++++++++++++++++