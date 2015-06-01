package com.hz.yisheng.demo.dao;

import java.util.List;
import java.util.Map;

import com.hz.yisheng.demo.orm.User;

/**
 * 用戶信息管理
 * 
 * @author huanglei
 * @date 2015年4月29日 下午4:12:28
 * @version V1.0
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
}
