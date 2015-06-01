package com.hz.sunday.trend.dao;

import java.util.List;
import java.util.Map;

import com.hz.sunday.trend.orm.OnlineService;

/**
 * 在线客服管理
 * 
 * @author huanglei
 */
public interface OnlineServiceMapper {

	/** 新增 */
	public void insert(OnlineService onlineService);

	/** 刪除 */
	public void deleteById(Long id);

	/** 更新 */
	public void update(OnlineService onlineService);

	/** 获取分页数据 */
	public List<OnlineService> list(Map<String, Object> sqlMap);

	/** 获取总记录数 */
	public Long count(Map<String, Object> sqlMap);

	/** 根据ID，获取信息 */
	public OnlineService getById(Long id);
}
