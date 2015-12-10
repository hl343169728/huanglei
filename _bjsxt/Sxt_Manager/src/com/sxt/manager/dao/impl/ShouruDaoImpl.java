package com.sxt.manager.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.ShouruDao;
import com.sxt.manager.model.Shouru;
import com.sxt.manager.model.Student;
import com.sxt.manager.utils.DBUtils;

public class ShouruDaoImpl extends BaseDaoImpl<Shouru> implements ShouruDao{

	/**
	 * 获取收入的信息列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getShouruList(String currentPage, String pageSize)
			throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select sr.*,s.sname from shouru sr,student s where sr.studentId=s.id limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+Integer.parseInt(pageSize);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			//循环遍历出收入表的信息
			Field[] fs = Shouru.class.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				map.put(fs[i].getName(),rs.getObject(fs[i].getName()));
			}
			map.put("sname",rs.getString("s.sname"));
			list.add(map);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 获取班级的名称
	 */
	@Override
	public String getClassName() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "";
		return null;
	}

}
