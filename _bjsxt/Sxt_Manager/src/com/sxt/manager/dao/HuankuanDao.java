package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.model.Huankuan;

public interface HuankuanDao {
	public  void  add(Huankuan hk);
	public  void  update(Huankuan hk);
	/**
	 * 删除某个hetong下所有的还款项
	 * @param hetongId
	 */
	public void delByHetongId(int hetongId);
	
	/**
	 * 将还款项的state="已还"
	 * @param hkId
	 */
	public  void  update2Huan(int hkId);
	
	public List<Huankuan>  findAllByBranch (int[] userIds);
	
}
