package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.HouseDao;
import com.bjsxt.po.House;

@Component
public class HouseDaoImpl implements HouseDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 添加方法
	 */
	public void add(House house) {
		hibernateTemplate.save(house);
	}
	
	/**
	 * 删除方法
	 */
	public void del(House house) {
		hibernateTemplate.delete(house);
	}
	
	/**
	 * 查找所有的房屋信息的方法
	 */
	@SuppressWarnings("unchecked")
	public List<House> findAll() {
		return hibernateTemplate.find("from House");
	}
	
	/**
	 * 根据id查找指定的对象的方法
	 */
	public House findById(Integer id) {
		return (House) hibernateTemplate.get(House.class, id);
	}
	
	/**
	 * 更新方法
	 */
	public void update(House house) {
		hibernateTemplate.update(house);
	}
}
