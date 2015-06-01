package com.hz.sunday.trend.dao;

import java.util.List;
import java.util.Map;

import com.hz.sunday.trend.orm.Information;

/**
 * 相关信息发布管理
 * 
 * @author huanglei
 */
public interface InformationMapper {

	/** 新增 */
	public void insert(Information info);

	/** 编辑 */
	public void update(Information info);

	/** 删除 */
	public void delete(Long id);

	/** 根据条件查询符合条件的信息条数 */
	public Long getCount(Map<String, Object> param);

	/** 根据条件，查询符合条件的信息，返回的是一个集合 */
	public List<Information> getList(Map<String, Object> param);

	/** 根户id，获取一条详情 */
	public Information getSingleDetail(Long id);

	/** 根据信息类型获取 */
	public List<Information> getByMtype(int mType);
}
