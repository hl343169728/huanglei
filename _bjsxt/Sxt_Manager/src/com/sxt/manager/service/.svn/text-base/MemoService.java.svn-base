package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Memo;

public interface MemoService {

	//保存备忘录的方法
	void save(Memo memo) throws Exception;

	//获取备忘录的列表信息
	List<Map> getMemoList(String currentPage, String pageSize,int userId, String flag) throws Exception;

	//获取备忘录的总记录数
	int getMemoTotal(int userId, String flag) throws Exception;

	//通过id查找指定的Memo对象
	Memo findById(int id) throws Exception;

	//通过id删除指定行的列表信息
	void delete(int id) throws Exception;

	//更新当前的对象
	void update(Memo m) throws Exception;

}
