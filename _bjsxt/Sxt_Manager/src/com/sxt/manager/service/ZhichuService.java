package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Zhichu;

public interface ZhichuService {

	//保存方法
	void save(Zhichu zhichu) throws Exception;

	//获取支出的列表信息
	List<Map> getZhichuList(String currentPage, String pageSize) throws Exception;

	//获取支出列表的总记录数
	int getTotal() throws Exception;

	//删除支出列表中要删除的信息
	void delete(int id) throws Exception;

	//根据id查找指定的对象
	Zhichu findById(int id) throws Exception;

	//更新方法
	void update(Zhichu zc) throws Exception;

}
