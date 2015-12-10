package com.bjsxt.dao.impl;

import java.util.List;

import com.bjsxt.basedao.BaseDaoImpl;
import com.bjsxt.dao.UserDao;
import com.bjsxt.po.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	/**
	 * 获取登录的用户
	 */
	public User findLoginUser(String uname, String pwd) throws Exception {
		List<User> list = this.queryListForParams("select * from user where uname=? and pwd=?", new Object[]{uname,pwd});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
