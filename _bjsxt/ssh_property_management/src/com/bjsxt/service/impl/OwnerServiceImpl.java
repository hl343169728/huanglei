package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.OwnerDao;
import com.bjsxt.po.Owner;
import com.bjsxt.service.OwnerService;

@Component
public class OwnerServiceImpl implements OwnerService{
	@Resource
	private OwnerDao ownerDao;
	public OwnerDao getOwnerDao() {
		return ownerDao;
	}
	public void setOwnerDao(OwnerDao ownerDao) {
		this.ownerDao = ownerDao;
	}
	
	/**
	 * 添加方法
	 */
	public void add(Owner owner) throws Exception {
		this.ownerDao.add(owner);
	}
	
	/**
	 * 查找所有信息的方法
	 */
	public List<Owner> findAll() throws Exception {
		return this.ownerDao.findAll();
	}
	
	/**
	 * 根据id查找指定的对象
	 */
	public Owner findById(Integer id) throws Exception {
		return this.ownerDao.findById(id);
	}
	
	/**
	 * 更新方法
	 */
	public void update(Owner o) throws Exception {
		this.ownerDao.update(o);
	}
	
	/**
	 * 删除方法
	 */
	public void del(Integer id) throws Exception {
		Owner owner = this.ownerDao.findById(id);
		this.ownerDao.del(owner);
	}
	
	
}
