package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.basedao.BaseDaoImpl;
import com.bjsxt.dao.ProvinceDao;
import com.bjsxt.po.ChinaArea;
import com.bjsxt.utils.DBUtils;

public class ProvinceDaoImpl extends BaseDaoImpl<ChinaArea> implements ProvinceDao{
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	/**
	 * 查找省份
	 */
	public List<ChinaArea> findProvince() throws Exception {
		List<ChinaArea> list = null;
		conn = DBUtils.createConn();
		String sql = "select * from chinaarea where AreaCode like '__0000'";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		list = new ArrayList<ChinaArea>();
		while(rs.next()){
			ChinaArea ca = new ChinaArea();
			ca.setAreaCode(rs.getInt("AreaCode"));
			ca.setAreaName(rs.getString("AreaName"));
			list.add(ca);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}
	
	/**
	 * 查找城市区域
	 */
	public List<ChinaArea> findCity(String AreaCode) throws Exception {
		String areaCode = AreaCode.substring(0,2);
		conn = DBUtils.createConn();
		String sql = "select * from chinaarea where AreaCode like '"+areaCode+"__00'";
		System.out.println(sql);
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		List<ChinaArea> list = new ArrayList<ChinaArea>();
		while(rs.next()){
			ChinaArea ca = new ChinaArea();
			ca.setAreaCode(rs.getInt("AreaCode"));
			ca.setAreaName(rs.getString("AreaName"));
			list.add(ca);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}
	
	/**
	 * 查找出县镇
	 */
	public List<ChinaArea> findTown(String AreaCode) throws Exception {
		String areaCode = AreaCode.substring(0,4);
		conn = DBUtils.createConn();
		String sql = "select * from chinaarea where AreaCode like '"+areaCode+"__'";
		System.out.println(sql);
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		List<ChinaArea> list = new ArrayList<ChinaArea>();
		while(rs.next()){
			ChinaArea ca = new ChinaArea();
			ca.setAreaCode(rs.getInt("AreaCode"));
			ca.setAreaName(rs.getString("AreaName"));
			list.add(ca);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}
	
//	public static void main(String[] args) {
//		String str = "123456".substring(0,2);
//		System.out.println(str);
//	}
}
