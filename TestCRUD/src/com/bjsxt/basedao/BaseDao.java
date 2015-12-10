package com.bjsxt.basedao;

import java.util.List;

/**
 *所有的方法
 * @param <Entity>
 */
public interface BaseDao<Entity> {
	//保存方法
	void save(Entity obj) throws Exception;
	//更新方法
	void update(Entity obj) throws Exception;
	//删除方法
	void delete(int id) throws Exception;
	//根据id获取对应的对象
	Entity findById(int id) throws Exception;
	//获取所有的数据
	List<Entity> findAll() throws Exception;
}
