package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Banji;

public interface BanjiDao  extends BaseDao<Banji>{
	/**
	 * 获得该组织下的班级
	 * @param orgId
	 * @return
	 */
	public List<Banji>  findAll(int orgId);
	
	public List<Banji>  findAllByBranch (int[] userIds);
}
