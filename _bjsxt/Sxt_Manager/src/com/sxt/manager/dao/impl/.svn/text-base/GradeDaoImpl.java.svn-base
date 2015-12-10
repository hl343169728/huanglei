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
import com.sxt.manager.dao.GradeDao;
import com.sxt.manager.model.Grade;
import com.sxt.manager.utils.DBUtils;

public class GradeDaoImpl extends BaseDaoImpl<Grade> implements GradeDao{

	/**
	 * 获取班级列表信息的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getGradeList(String currentPage, String pageSize) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select g.*,e.ename from grade g,employee e where e.id=g.teacherId limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+Integer.parseInt(pageSize);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList<Map>();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			Field[] fs = Grade.class.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				map.put(fs[i].getName(),rs.getObject(fs[i].getName()));
			}
			map.put("teacherName",rs.getString("e.ename"));
			list.add(map);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 获取学员可选的班级的名称
	 */
	@Override
	public List<Grade> getClassNames() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select * from grade";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<Grade> list = new ArrayList<Grade>();
		while(rs.next()){
			Grade grade = new Grade();
			grade.setId(rs.getInt("id"));
			grade.setClassNumber(rs.getString("classNumber"));
			list.add(grade);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

}
