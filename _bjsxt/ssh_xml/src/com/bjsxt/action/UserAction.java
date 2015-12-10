package com.bjsxt.action;

import java.util.List;

import com.bjsxt.dao.UserDao;
import com.bjsxt.po.User;
import com.bjsxt.utils.PageInfo;

public class UserAction {
	private UserDao userDao;
	private User user;
	private Integer id;
	private List<User> list;
	private Integer pageNum;	//页号
	private String name;		//用户名
	private PageInfo pageInfo;
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		this.userDao.save(this.user);
		return "list";
	}
	
	/**
	 * 获取用户的列表的信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.pageInfo = this.userDao.findAll(pageNum,name);
		return "list";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.user = this.userDao.findById(this.id);
		return "update";
	}
	
	/**
	 * 修改的方法
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		User u = this.userDao.findById(this.id);
		u.setName(this.user.getName());
		u.setPhone(this.user.getPhone());
		u.setAddress(this.user.getAddress());
		this.userDao.update(u);
		return "list";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception{
		User u = this.userDao.findById(this.id);
		this.userDao.del(u);
		return "list";
	}
	
	/**
	 * getter和setter方法
	 * @return
	 */
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}
