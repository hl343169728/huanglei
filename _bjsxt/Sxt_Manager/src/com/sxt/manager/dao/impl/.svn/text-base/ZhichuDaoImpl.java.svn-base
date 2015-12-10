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
import com.sxt.manager.dao.ZhichuDao;
import com.sxt.manager.model.Shouru;
import com.sxt.manager.model.Zhichu;
import com.sxt.manager.utils.DBUtils;

public class ZhichuDaoImpl extends BaseDaoImpl<Zhichu> implements ZhichuDao{

	/**
	 * 获取支出列表的信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getgetZhichuList(String currentPage, String pageSize)
			throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select z.*,s.sname from zhichu z ,student s where s.id = z.studentId limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+Integer.parseInt(pageSize);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			Field[] fs = Zhichu.class.getDeclaredFields();
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

}
