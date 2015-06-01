//package com.hz.yisheng.demo.hibernate;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.hz.yisheng.demo.orm.Clazz;
//import com.hz.yisheng.demo.orm.Student;
//import com.hz.yisheng.demo.utils.HibernateUtil;
//
//public class OneToManyTest {
//
//	/**
//	 * 新增
//	 * 
//	 * @throws Exception
//	 */
//	private static void insert() {
//		Student student1 = new Student();
//		student1.setName("小红");
//		Student student2 = new Student();
//		student2.setName("小兰");
//
//		Clazz clazz = new Clazz();
//		clazz.setName("小班");
//		// 既然设置的是双向关联，就同时更新对象的状态，解除关系的时候也一样，同时解除
//		student1.setClazz(clazz);
//		student2.setClazz(clazz);
//
//		clazz.getStudents().add(student1);
//		clazz.getStudents().add(student2);
//
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			session.save(clazz);
//			session.save(student1);
//			session.save(student2);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public static void main(String[] args) {
//		// 新增
//		insert();
//	}
//}
