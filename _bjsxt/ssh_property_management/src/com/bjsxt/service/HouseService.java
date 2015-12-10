package com.bjsxt.service;

import java.util.List;

import com.bjsxt.po.House;

public interface HouseService {

	//获取所有的房屋编号
	List<House> findAll() throws Exception;

}
