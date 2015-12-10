package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.po.ChinaArea;

public interface ProvinceDao extends BaseDao<ChinaArea>{
	public List<ChinaArea> findProvince() throws Exception;
	public List<ChinaArea> findCity(String AreaCode) throws Exception;
	public List<ChinaArea> findTown(String AreaCode) throws Exception;
}
