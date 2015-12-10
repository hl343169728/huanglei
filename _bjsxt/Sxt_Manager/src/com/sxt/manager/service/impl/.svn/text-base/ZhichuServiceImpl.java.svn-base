package com.sxt.manager.service.impl;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.ZhichuDao;
import com.sxt.manager.dao.impl.ZhichuDaoImpl;
import com.sxt.manager.model.Zhichu;
import com.sxt.manager.service.ZhichuService;

public class ZhichuServiceImpl implements ZhichuService{

	private ZhichuDao zdao = new ZhichuDaoImpl();

	/**
	 * 保存方法
	 */
	@Override
	public void save(Zhichu zhichu) throws Exception {
		this.zdao.save(zhichu);
	}

	/**
	 * 获取支出列表的总记录数
	 */
	@Override
	public int getTotal() throws Exception {
		return this.zdao.getTotal();
	}

	/**
	 * 获取支出列表的信息
	 */
	@Override
	public List<Map> getZhichuList(String currentPage, String pageSize)
			throws Exception {
		return this.zdao.getgetZhichuList(currentPage,pageSize);
	}

	/**
	 * 删除支出列表中要删除的信息
	 */
	@Override
	public void delete(int id) throws Exception {
		this.zdao.delete(id);
	}

	/**
	 * 根据id查找指定的对象
	 */
	@Override
	public Zhichu findById(int id) throws Exception {
		return this.zdao.findById(id);
	}

	/**
	 * 更新方法
	 */
	@Override
	public void update(Zhichu zc) throws Exception {
		this.zdao.update(zc);
	}
}
