package com.hz.sunday.trend.dao;

import java.util.List;
import java.util.Map;

import com.hz.sunday.trend.orm.MessageInfo;

/**
 * 在线留言管理
 * 
 * @author huanglei
 */
public interface MessageInfoMapper {

	/** 新增 */
	public void insert(MessageInfo messageInfo);

	/** 刪除 */
	public void deleteById(Long id);

	/** 更新 */
	public void update(MessageInfo messageInfo);

	/** 获取分页数据 */
	public List<MessageInfo> list(Map<String, Object> sqlMap);

	/** 获取总记录数 */
	public Long count(Map<String, Object> sqlMap);

	/** 根据ID，获取信息 */
	public MessageInfo getById(Long id);
}
