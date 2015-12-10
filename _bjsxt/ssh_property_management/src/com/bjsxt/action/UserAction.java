package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.po.User;
import com.bjsxt.service.UserService;

@Component
@Scope("prototype")
public class UserAction {
	@Resource
	private UserService userService;
	private Integer id;
	private User user;
	private List<User> list;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
