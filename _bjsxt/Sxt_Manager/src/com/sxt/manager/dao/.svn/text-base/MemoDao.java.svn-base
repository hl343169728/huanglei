package com.sxt.manager.dao;

import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Memo;

public interface MemoDao extends BaseDao<Memo>{

	//获取备忘录的总记录数
	int getMemoTotal(int userId, String flag) throws Exception;

	//获取备忘录的列表信息
	List<Memo> getMemoList(String currentPage, String pageSize, int userId,String flag) throws Exception;

}
