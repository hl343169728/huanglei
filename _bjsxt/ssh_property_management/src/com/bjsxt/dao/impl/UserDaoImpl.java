package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.po.User;

@Component
public class UserDaoImpl implements UserDao{
	@Resource
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	/**
	 * 添加方法
	 */
	public void add(User user) {
		hibernateTemplate.save(user);
	}
	
	/**
	 * 删除方法
	 */
	public void del(User user) {
		hibernateTemplate.delete(user);
	}
	
	/**
	 * 查询所有用户的信息
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return hibernateTemplate.find("from User");
	}
	
	/**
	 * 根据id查找指定的对象
	 */
	public User findById(int id) {
		return (User) hibernateTemplate.get(User.class, id);
	}
	
	/**
	 * 更新方法
	 */
	public void update(User user) {
		hibernateTemplate.update(user);
	}
	
}
