//package com.hz.yisheng.demo.utils;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
///**
// * 
// * @Description 
// * 	1）其中SessionFactory是重量级的，创建和销毁都会消耗较大，他要读取配置文件信息，加载到缓存中，一般一个数据库一个，启动的时候加载一次就可以了。 
// *  2）Session对象是非线程安全的，是轻量级的，所以一个线程要创建一个Session对象，主要的增删改查接口都在Session对象中。 
// * @author huanglei   
// * @date 2015-2-9 下午2:48:29     
// * @version 1.0
// *
// */
//public class HibernateUtil {
//
//	public static SessionFactory sessionFactory = null;
//
//	static {
//		try {
//			sessionFactory = new Configuration().configure()
//					.buildSessionFactory();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	@SuppressWarnings("rawtypes")
//	public static final ThreadLocal session = new ThreadLocal();
//
//	@SuppressWarnings("unchecked")
//	public static Session currentSession() throws HibernateException {
//		Session s = (Session) session.get();
//		if (s == null) {
//			s = sessionFactory.openSession();
//			session.set(s);
//		}
//		return s;
//	}
//
//	@SuppressWarnings("unchecked")
//	public static void closeSession() throws HibernateException {
//		Session s = (Session) session.get();
//		if (s != null)
//			s.close();
//		session.set(null);
//	}
//}
