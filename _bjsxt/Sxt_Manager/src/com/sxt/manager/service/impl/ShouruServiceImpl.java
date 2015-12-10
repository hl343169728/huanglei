package com.sxt.manager.service.impl;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.ShouruDao;
import com.sxt.manager.dao.impl.ShouruDaoImpl;
import com.sxt.manager.model.Shouru;
import com.sxt.manager.service.ShouruService;

public class ShouruServiceImpl implements ShouruService{
	
	private ShouruDao srdao = new ShouruDaoImpl();

	/**
	 * 保存方法
	 */
	@Override
	public void save(Shouru shouru) throws Exception {
		this.srdao.save(shouru);
	}
	
	/**
	 * 获取收入的信息列表
	 */
	@Override
	public List<Map> getShouruList(String currentPage, String pageSize)
			throws Exception {
		return this.srdao.getShouruList(currentPage,pageSize);
	}

	/**
	 * 获取收入这张表的总记录数
	 */
	@Override
	public int getTotal() throws Exception {
		return this.srdao.getTotal();
	}

	/**
	 * 通过id 获取指定的对象
	 */
	@Override
	public Shouru findById(int id) throws Exception {
		return  this.srdao.findById(id);
	}

	@Override
	public String getClassName() throws Exception {
		return this.srdao.getClassName();
	}

	/**
	 * 更新当前的对象
	 */
	@Override
	public void update(Shouru sr) throws Exception {
		this.srdao.update(sr);
	}

	/**
	 * 删除方法
	 */
	@Override
	public void delete(int id) throws Exception {
		this.srdao.delete(id);
	}
}
