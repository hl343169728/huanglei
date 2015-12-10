package com.bjsxt.dao;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.po.User;

public interface UserDao extends BaseDao<User>{

	//获取登录的用户
	User findLoginUser(String uname, String pwd) throws Exception;

}
