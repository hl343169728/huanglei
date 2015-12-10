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
import com.sxt.manager.dao.StudentDao;
import com.sxt.manager.model.Student;
import com.sxt.manager.utils.DBUtils;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	/**
	 * 验证QQ是否存在
	 */
	@Override
	public boolean checkStudentQQ(String qq) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select id from student where qq=?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setString(1,qq);
		ResultSet rs = ps.executeQuery();
		boolean flag = false;
		if(rs.next()){
			int id = rs.getInt(1);
			if(id>0){
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 获取有意向的学员的列表信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getStudentList(String currentPage, String pageSize ,String flag)
			throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select * from student where type=? limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+pageSize;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		if("1".equals(flag)){
			ps.setString(1,"意向学员");
		}else if("2".equals(flag)){
			ps.setString(1,"不来了");
		}else {
			ps.setString(1,"正式学员");
		}
		ResultSet rs = ps.executeQuery();
		List  list = new ArrayList();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			Field[] fs = Student.class.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				map.put(fs[i].getName(),rs.getObject(fs[i].getName()));
			}
			list.add(map);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}
	
	/**
	 * 获取预备学员的信息列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getPreStudentList(String currentPage, String pageSize)
			throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select s.*,g.classNumber from student s,grade g where s.gradeId=g.id and s.type=? limit "+((Integer.parseInt(currentPage))-1)*Integer.parseInt(pageSize)+","+pageSize;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setString(1,"预备学员");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("classNumber",rs.getString("g.classNumber"));
			Field[] fs = Student.class.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				map.put(fs[i].getName(),rs.getObject(fs[i].getName()));
			}
			list.add(map);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 获取学员总记录数
	 */
	@Override
	public int getStudentTotal(String flag) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from student where type=?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		if("1".equals(flag)){
			ps.setString(1,"意向学员");
		}else{
			ps.setString(1,"不来了");
		}
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if(rs.next()){
			total = rs.getInt(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return total;
	}

	/**
	 * 获取预备学员的总数
	 */
	@Override
	public int getPreStudentTotal() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from student where type=?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setString(1,"预备学员");
		ResultSet rs = ps.executeQuery();
		int total = 0;
		if(rs.next()){
			total = rs.getInt(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return total;
	}

	/**
	 * 获取正式学员的总记录数
	 */
	@Override
	public int getRealStudentTotal(String flag) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from student where type=?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		if("4".equals(flag)){
			ps.setString(1,"正式学员");
		}
		ResultSet rs = ps.executeQuery();
		int total = 0;
		while(rs.next()){
			total = rs.getInt(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return total;
	}

	/**
	 * 获取学员的首付款
	 */
	@Override
	public double getPrePayFeeValue() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select g.prePayFee from student s ,grade g  where s.gradeId=g.id ";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		double prePayFee = 0;
		if(rs.next()){
			prePayFee = rs.getDouble(1);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return prePayFee;
	}

}
