package com.sxt.manager.service;

import java.util.Date;
import java.util.List;

import com.sxt.manager.model.Hetong;

public interface HetongService {

	
	
	public void add(int studentId,int userId,double huankuanTotal,
			int cardFlag,int danbaorenProtocoolFlag,
			int danbaorencarFlag,int danbaorenHukouFlag,int danbaorenBankFlag,String descrpt,
			double hk1Jine,Date hk1Time,
			double hk2Jine,Date hk2Time,
			double hk3Jine,Date hk3Time,
			double hk4Jine,Date hk4Time,
			double hk5Jine,Date hk5Time,
			double hk6Jine,Date hk6Time,
			double hk7Jine,Date hk7Time,
			double hk8Jine,Date hk8Time,
			double hk9Jine,Date hk9Time,
			double hk10Jine,Date hk10Time,
			double hk11Jine,Date hk11Time,
			double hk12Jine,Date hk12Time
			
	);
	
	/**
	 * 获得本用户录入的所有合同
	 * @param userId
	 * @return
	 */
	public List<Hetong>  findMyAll(int userId);
	
	
	public void update(int hetongId,int studentId,int userId,double huankuanTotal,
			int cardFlag,int danbaorenProtocoolFlag,
			int danbaorencarFlag,int danbaorenHukouFlag,int danbaorenBankFlag,String descrpt,
			double hk1Jine,Date hk1Time,
			double hk2Jine,Date hk2Time,
			double hk3Jine,Date hk3Time,
			double hk4Jine,Date hk4Time,
			double hk5Jine,Date hk5Time,
			double hk6Jine,Date hk6Time,
			double hk7Jine,Date hk7Time,
			double hk8Jine,Date hk8Time,
			double hk9Jine,Date hk9Time,
			double hk10Jine,Date hk10Time,
			double hk11Jine,Date hk11Time,
			double hk12Jine,Date hk12Time
			
	);
	
	public void delById(int id);
	
	
	
}
