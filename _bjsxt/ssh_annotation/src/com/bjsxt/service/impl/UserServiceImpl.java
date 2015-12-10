package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao = new UserDaoImpl();
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 简单的用户间的转账业务
	 */
//	@Transactional
	public void transferMoney(Integer targetId, Integer resourceId,
			Integer money) throws Exception {
		this.userDao.reduceMoney(resourceId, money);
		this.userDao.addMoney(targetId, money);
		System.out.println("日志记录，发生转账了......");
	}

}
