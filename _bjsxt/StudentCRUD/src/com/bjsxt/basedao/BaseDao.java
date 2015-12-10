package com.bjsxt.basedao;

import java.util.List;

public interface BaseDao<Entity> {
	//保存方法
	void save(Entity entity) throws Exception;
	//更新方法
	void update(Entity entity) throws Exception ; 
	//删除方法
	void delete(int id) throws Exception ;
	//根据id查找指定的对象
	Entity findById(int id) throws Exception ; 
	//查询所有的数据
	List<Entity> findAll() throws Exception ;
}
