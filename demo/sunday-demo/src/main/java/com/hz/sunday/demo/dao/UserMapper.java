package com.hz.sunday.demo.dao;

import java.util.List;
import java.util.Map;

import com.hz.sunday.demo.entity.User;

/**
 * 用戶信息管理
 * 
 * @author huanglei
 */
public interface UserMapper {

	/** 查询分页记录 */
	public List<User> findAll(Map<String, Object> queryParam);

	/** 查询记录条数 */
	public Long findCount(Map<String, Object> queryParam);

	/** 新增信息 */
	public void insert(User user);

	/** 根据ID，获取信息 */
	public User findById(Long id);

	/** 更新信息 */
	public void update(User user);

	/** 根据ID，删除信息 */
	public void deleteById(Long id);

	/** 批量获取信息 */
	public List<User> getUserByIds(List<Long> list);

	/** 取消附件*/
	public void cancel(User user);
}
