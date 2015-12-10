package com.sxt.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Preparable;
import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.UserDao;
import com.sxt.manager.model.User;
import com.sxt.manager.utils.DBUtils;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public List<Map> findUserList(String currentPage, String pageSize)
			throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select user.* , employee.ename   from user , employee where user.empid = employee.id limit " +(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)+" , " +pageSize;
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
				Map map = new HashMap();
				map.put("id", rs.getInt("id"));
				map.put("uname", rs.getString("uname"));
				map.put("empname", rs.getString("employee.ename"));
				map.put("state", rs.getString("state"));
				list.add(map);
		}
		DBUtils.close(rs);
		DBUtils.close(ps);
		DBUtils.close(conn);
		return list;
	}

	/**
	 * 根据用户账号获取指定对象
	 */
	@Override
	public User findByName(String receiverName) throws Exception {
		
		List<User> userList = this.queryListForParams("select * from user where uname =?", new Object[]{receiverName});
		if(userList.size() > 0){
			return userList.get(0);
		}
		return null;
	}
}
