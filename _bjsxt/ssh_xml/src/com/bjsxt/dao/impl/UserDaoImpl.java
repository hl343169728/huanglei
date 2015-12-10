package com.bjsxt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.dao.UserDao;
import com.bjsxt.po.User;
import com.bjsxt.utils.PageInfo;

public class UserDaoImpl implements UserDao{
	
	private SessionFactory factory;
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * 保存方法
	 */
	public void save(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 删除方法
	 */
	public void del(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 更新方法
	 */
    public void update(User user) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}

    /**
     * 获取所有的信息
     */
	public PageInfo findAll(Integer pageNum,String name) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = " from User u where 1=1 ";
		//当姓名不为null且姓名不为空字符串的时候
		if(name!=null&&!"".equals(name)){
			hql += " and u.name like '%"+name+"%'";
		}
		//获取的记录总数
		Number count = (Number) session.createSQLQuery("select count(*) "+hql).uniqueResult();
		PageInfo pageInfo = new PageInfo(pageNum,count.intValue());
		Query query = session.createQuery(hql);
		//从第几条开始选取数据
		query.setFirstResult((pageInfo.getPageNum()-1)*10);
		//每页最多显示的数据个数
		query.setMaxResults(10);
		pageInfo.setList(query.list());
		transaction.commit();
		session.close();
		return pageInfo;
	}

	/**
	 * 根据id查找指定的对象 
	 */
	public User findById(int id) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class,id);
		transaction.commit();
		session.close();
		return user;
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		UserDao userDao = (UserDao) ac.getBean("userDao");
//		User user = new User();
//		user.setName("小高");
//		user.setPhone("123");
//		user.setAddress("北京");
//		userDao.save(user);
		
//		System.out.println(userDao.findById(1).getName());
		
// 		List<User> list = userDao.findAll();
// 		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//			User user = (User) iterator.next();
//			System.out.println("姓名："+user.getName()+",电话："+user.getPhone()+",地址："+user.getAddress());
//		}
		
//		User user = userDao.findById(1);
//		user.setName("小白");
//		userDao.update(user);
		
//		userDao.del(userDao.findById(1));
	}

}
