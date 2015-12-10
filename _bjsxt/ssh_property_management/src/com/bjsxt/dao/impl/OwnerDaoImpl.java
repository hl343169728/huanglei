package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.OwnerDao;
import com.bjsxt.po.Owner;

@Component
public class OwnerDaoImpl implements OwnerDao{
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
	public void add(Owner owner) {
		hibernateTemplate.save(owner);
	}
	
	/**
	 * 删除方法
	 */
	public void del(Owner owner) {
		hibernateTemplate.delete(owner);
	}
	
	/**
	 * 查找所有的业主信息的方法
	 */
	@SuppressWarnings("unchecked")
	public List<Owner> findAll() {
		return hibernateTemplate.find("from Owner");
	}
	
	/**
	 * 根据id获取指定的对象的方法
	 */
	public Owner findById(Integer id) {
		return (Owner) hibernateTemplate.get(Owner.class, id);
	}
	
	/**
	 * 更新方法
	 */
	public void update(Owner owner) {
		hibernateTemplate.update(owner);
	}
	
}
