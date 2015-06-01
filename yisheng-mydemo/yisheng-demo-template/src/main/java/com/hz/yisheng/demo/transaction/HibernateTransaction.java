//package com.hz.yisheng.demo.transaction;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import com.hz.yisheng.demo.orm.Course;
//
///**
// * 
// * @Description Hibernate事务 
// * @author huanglei   
// * @date 2015-2-9 下午3:20:26     
// * @version 1.0
// *
// */
//public class HibernateTransaction {
//
//	public static void main(String[] args) {
//		Course course = new Course();
//		course.setName("地理");
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = new Configuration().configure().buildSessionFactory().openSession();
//			// 开始事务
//			tx = session.beginTransaction();
//			session.save(course);
//			// 提交事务
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// 回滚事务
//			tx.rollback();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
//}
