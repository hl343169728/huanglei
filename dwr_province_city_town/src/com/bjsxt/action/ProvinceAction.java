package com.bjsxt.action;

import java.util.List;

import com.bjsxt.dao.ProvinceDao;
import com.bjsxt.dao.impl.ProvinceDaoImpl;
import com.bjsxt.po.ChinaArea;

public class ProvinceAction {
	
	private ProvinceDao provinceDao = new ProvinceDaoImpl();
	
	/**
	 * 获取省份
	 * @return
	 * @throws Exception
	 */
	public List<ChinaArea> findProvince() throws Exception{
		List<ChinaArea> list = this.provinceDao.findProvince();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAreaName());
		}
		return list;
	}
	
	/**
	 * 获取城市区域
	 * @param AreaCode
	 * @return
	 * @throws Exception
	 */
	public List<ChinaArea> findCity(String AreaCode) throws Exception{
		List<ChinaArea> list = this.provinceDao.findCity(AreaCode);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAreaName());
		}
		return list;
	}
	
	/**
	 * 获取县镇
	 * @param AreaCode
	 * @return
	 * @throws Exception
	 */
	public List<ChinaArea> findTown(String AreaCode) throws Exception{
		List<ChinaArea> list = this.provinceDao.findTown(AreaCode);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAreaName());
		}
		return list;
	}
}
