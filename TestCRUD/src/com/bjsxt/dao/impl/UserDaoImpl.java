package com.bjsxt.dao.impl;

import com.bjsxt.basedao.impl.BaseDaoImpl;
import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;


public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
public class UserDaoImpl implements UserDao{
	public void save(Object obj) throws Exception {
		User user = (User)obj;
		Connection conn = DBUtils.getConn();
		String sql = " insert into user values(null,?,?,?)";
		PreparedStatement ps = DBUtils.getState(conn,sql);
		ps.setString(1,user.getName());
		ps.setInt(2,user.getAge());
		ps.setString(3,user.getDescription());
		ps.executeUpdate();
		DBUtils.close(ps);
		DBUtils.close(conn);
	}
	public void delete(int id) throws Exception {
		
	}
	public List<Object> findAll() throws Exception {
		return null;
	}
	public Object findById(int id) throws Exception {
		return null;
	}
	public void update(Object obj) throws Exception {
	}
}
*/
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++