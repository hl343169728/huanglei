package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjsxt.basedao.impl.BaseDaoImpl;
import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.model.Employee;
import com.bjsxt.utils.DBUtils;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao{
	
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> findEmpList() throws Exception{
		//获取连接
		Connection conn = DBUtils.getConn();
		//加上别名后，取得属性，就是别名.属性
		String sql = "select e.*,p.name from employee e,position p where e.p_id=p.id";
		//执行操作
		PreparedStatement ps = DBUtils.getState(conn, sql);
		//把操作的结果放在一个结果集中
		ResultSet rs = ps.executeQuery();
		List<Map> list = new ArrayList<Map>();
		while(rs.next()){
			Map<String ,Object> m = new HashMap<String ,Object>();
			m.put("empName",rs.getString("e.name"));
			m.put("salary",rs.getString("salary"));
			m.put("tell",rs.getString("tell"));
			m.put("birthday",rs.getString("birthday"));
			m.put("hiredate",rs.getString("hiredate"));
			m.put("password",rs.getString("password"));
			m.put("posName",rs.getString("p.name"));
			m.put("id",rs.getInt("id"));
			list.add(m);
		}
		//释放资源
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list; 
	}
	
	/**
	 * 
	 */
	public Employee findNameAndPassword(String username, String password) throws Exception {
		//获取连接
		Connection conn = DBUtils.getConn();
		//SQL语句
		String sql = "select * from Employee where name=? and password=?";
		//执行SQL语句
		PreparedStatement ps = DBUtils.getState(conn, sql);
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();	
		if(rs.next()){
			//创建一个实例
			Employee e = new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setPassword(rs.getString("password"));
			e.setSalary(rs.getString("salary"));
			e.setTell(rs.getString("tell"));
			e.setBirthday(rs.getString("birthday"));
			e.setHiredate(rs.getString("hiredate"));
			e.setP_id(rs.getString("p_id"));
			return e;
		}else {
			return null;
		}
	}
}
