package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Org;
import com.sxt.manager.model.User;

public interface UserService {

	
	public void update(User u) throws Exception;

	public User findById(int id) throws Exception;

	public User createAccount(int parseInt) throws Exception;

	public boolean exsitsAccount(int parseInt) throws Exception;

	public User loginUser(String username, String password) throws Exception;

	public List<Map> findUserList(String currentPage, String pageSize) throws Exception;

	public int getTotal() throws Exception;
	
	
	
}
