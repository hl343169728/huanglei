package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.HouseDao;
import com.bjsxt.po.House;
import com.bjsxt.service.HouseService;

@Component
public class HouseServiceImpl implements HouseService{
	@Resource
	private HouseDao houseDao;
	public HouseDao getHouseDao() {
		return houseDao;
	}
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	
	/**
	 * 获取所有的房屋的编号
	 */
	public List<House> findAll() throws Exception {
		return this.houseDao.findAll();
	}
}
