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
import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.JobDao;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.User;
import com.sxt.manager.utils.DBUtils;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{

	
	/**
	 * 获取在职员工信息
	 */
	@Override
	public List<Map> getList(String currentPage ,String pageSize , String flag) throws Exception {
		Connection conn = DBUtils.createConn();
		
		String sql = "select employee.* , org.oname from employee , org where employee.orgId = org.id and state=? limit "+(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+","+Integer.parseInt(pageSize);
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		if("1".equals(flag)){
			ps.setString(1,"在职");
		} else {
			ps.setString(1, "辞职");
		}
		ResultSet rs = ps.executeQuery();
		List<Map> list = new ArrayList<Map>();
		
		while(rs.next()){
			Map<String, Object> map = new HashMap<String, Object>();
			Field[] fs = Employee.class.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				map.put(fs[i].getName(), rs.getObject(fs[i].getName()));
			}
			map.put("oname", rs.getString("org.oname"));
			list.add(map);
		}
		return list;
	}

	@Override
	public int getTotal(String flag) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql ="select count(*) from employee where state=?  ";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		if("1".equals(flag)){
			ps.setString(1,"在职");
		} else {
			ps.setString(1, "辞职"); 
		}		
		ResultSet rs = ps.executeQuery();
		int total = 0 ;
		if(rs.next()){
			total = rs.getInt(1);
		}
		return total;
	}

	
	/**
	 * 根据组织机构id 获得所有的 员工 
	 */
	@Override
	public List<User> findByOrgId(int orgId) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select u.* from employee e , user u where e.id = u.empid and e.orgid = ?" ; 
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, orgId);
		ResultSet rs = ps.executeQuery();
		List<User>  ulist = new ArrayList<User>();
		while(rs.next()){
				User u = new User();
				u.setId(rs.getInt("u.id"));
				u.setUname(rs.getString("u.uname"));
				ulist.add(u);
		}
		return ulist ;
	}

	/**
	 * 获取职位是班主任的雇员的姓名
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getTeacherName() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select e.* from employee e,job j where e.jobIds=j.id and j.jname=?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setString(1,"班主任");
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setId(rs.getInt("e.id"));
			employee.setEname(rs.getString("e.ename"));
			list.add(employee);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 
	 */
	@Override
	public List<Employee> getBaoxiaoEmployee(int userId) throws Exception {
		return null;
	}
}
