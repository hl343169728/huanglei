package com.sxt.manager.dao;

import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Zhichu;

public interface ZhichuDao extends BaseDao<Zhichu>{

	//获取支出列表的信息
	List<Map> getgetZhichuList(String currentPage, String pageSize) throws Exception;

}
