package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
