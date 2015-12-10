package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	 * 保存方法
	 */
	public void save(User user) {
		hibernateTemplate.save(user);
	}

	/**
	 * 更新方法
	 */
	public void update(User user) {
		hibernateTemplate.update(user);
	}

	/**
	 * 删除方法
	 */
	public void del(User user) {
		hibernateTemplate.delete(user);
	}

	/**
	 * 获取所有的信息
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return hibernateTemplate.find("from User");
	}

	/**
	 * 根据id获取指定的对象
	 */
	public User findById(int id) {
		return (User) hibernateTemplate.get(User.class, id);
	}
	
	/**
	 * 验证用户名的存在与否
	 */
	@SuppressWarnings("unchecked")
	public List<User> checkName(String username) throws Exception {
		return hibernateTemplate.find("from User u where u.name=?",new Object[]{username});
	}
	
	/**
	 * 存款增加的方法
	 */
//	@Transactional
	public void addMoney(Integer userId, Integer money) {
		throw new NullPointerException();
//		User user = (User) hibernateTemplate.get(User.class,userId);
//		user.setMoney(user.getMoney()+money);
//		hibernateTemplate.update(user);
	}
	
	/**
	 * 存款减少的方法
	 */
//	@Transactional
	public void reduceMoney(Integer userId, Integer money) {
		User user = (User) hibernateTemplate.get(User.class,userId);
		user.setMoney(user.getMoney()-money);
		hibernateTemplate.update(user);
	}
	
	
	/**
	 * 主方法  测试
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		UserDao userDao = (UserDao) ac.getBean("userDao");
		User user = new User();
		user.setName("小白");
		userDao.save(user);
		
//		User user = userDao.findById(1);
//		user.setName("小三");
//		userDao.update(user);
//		System.out.println(user.getName());
	}
	
}
