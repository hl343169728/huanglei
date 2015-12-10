package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.model.Hetong;

public interface HetongDao {
	public void add(Hetong hetong);
	public void update(Hetong hetong);
	
	public List<Hetong>  findMyAll(int userId);
	
	public Hetong  findById4update(int hetongId);
	
	public void delById(int id);
	
	public List<Hetong>  findAllByBranch (int[] userIds);
	
	/**
	 * 将合同状态 ="正在还款"
	 * @param hetongId
	 */
	public void update2huan(int hetongId);
	
	/**
	 * 将合同state="还款完毕"
	 * @param hetongId
	 */
	public void update2over(int hetongId);
}
