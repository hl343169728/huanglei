package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.po.House;

public interface HouseDao {
	void add(House house);
	void del(House house);
	void update(House house);
	List<House> findAll();
	House findById(Integer id);
}
