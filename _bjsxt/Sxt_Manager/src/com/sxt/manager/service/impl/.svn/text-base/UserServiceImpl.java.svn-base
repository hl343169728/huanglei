package com.sxt.manager.service.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.UserDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.UserDaoImpl;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.User;
import com.sxt.manager.service.UserService;
import com.sxt.manager.utils.CommonsUtil;
import com.sxt.manager.utils.DBUtils;

public class UserServiceImpl implements UserService{

	
	private UserDao udao = new UserDaoImpl();
	private EmployeeDao edao = new EmployeeDaoImpl();
	
	/**
	 * 根据empid 创建一个用户账号
	 * 这个返回的user对象是没有id的 
	 */
	@Override
	public User createAccount(int empId) throws Exception {
		Employee emp = this.edao.findById(empId);
		User u = new User(); 
		u.setUname(emp.getEname()+ emp.getBirthday().replaceAll("-", ""));
		u.setPwd(emp.getCardId().substring(emp.getCardId().length()-6));
		u.setEmpId(empId);
		u.setCreateTime(CommonsUtil.FormateDate(new Date()));
		this.udao.save(u);
		return u;
	}
	
	/**
	 * 判断此empid是否生成过user对象
	 */
	@Override
	public boolean exsitsAccount(int empId) throws Exception {
		
		List<User> userlist = this.udao.queryListForParams("select * from user where empid = ?", new Object[]{empId});
		if(userlist.size()> 0){
			return true ;
		}
		return false;
	}

	
	
	/**
	 *   用户登录的方法  
	 */
	@Override
	public User loginUser(String username, String password) throws Exception {
		List<User> userList  = this.udao.queryListForParams("select * from user where uname= ? and pwd = ? and state='有效'", new Object[]{username , password});
		if(userList.size()>0){
			return userList.get(0);
		}
		return null;
	}

	
	@Override
	public User findById(int id) throws Exception {
		return this.udao.findById(id);
	}

	

	@Override
	public void update(User u) throws Exception {
		this.udao.update(u);
	}

	
	/**
	 * 查询user 列表信息 
	 */
	@Override
	public List<Map> findUserList(String currentPage, String pageSize)
			throws Exception {
		return this.udao.findUserList(currentPage , pageSize);
	}

	/**
	 * 总记录数
	 */
	@Override
	public int getTotal() throws Exception {
		return this.udao.getTotal();
	}


	






}
