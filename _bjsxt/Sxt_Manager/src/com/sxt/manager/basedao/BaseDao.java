package com.sxt.manager.basedao;

import java.util.List;
import java.util.Map;

import com.sxt.manager.utils.QueryHelper;
/**
 * 本类是CRUD公共方法接口
 * @author oiYc_
 *
 * @param <T>
 */
public interface BaseDao<T> {
	
	/**
	 * 保存方法
	 * @param obj
	 * @throws Exception 
	 */
	void save(T obj) throws Exception;
	/**
	 * 更新方法
	 * @param obj
	 */
	void update(T obj)  throws Exception;
	/**
	 * 删除方法
	 * @param id
	 */
	void delete(int id)  throws Exception;
	/**
	 * 此方法用于根据id 查找指定对象
	 * @param id
	 * @return
	 */
	T findById(int id)  throws Exception;
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll()  throws Exception;

	
	/**
	 * 单表任意条件的查询 
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public  List<T> queryListForParams(String sql,Object[] params ) throws Exception;
	
	/**
	 * 单张表查询总记录数
	 * @return
	 * @throws Exception
	 */
	public int getTotal() throws Exception ;
	//public List<Map> queryPage(String currentPage , String pageSize , QueryHelper qh) throws Exception;
	
	//public int queryCount(QueryHelper qh) throws Exception;
}
