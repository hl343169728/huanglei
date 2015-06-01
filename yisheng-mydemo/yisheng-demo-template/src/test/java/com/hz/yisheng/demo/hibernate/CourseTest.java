//package com.hz.yisheng.demo.hibernate;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.hz.yisheng.demo.orm.Clazz;
//import com.hz.yisheng.demo.orm.Course;
//import com.hz.yisheng.demo.orm.Student;
//import com.hz.yisheng.demo.utils.HibernateUtil;
//
///**
// * 
// * @Description 课程表测试
// * @author huanglei
// * @date 2015-2-9 下午2:13:26
// * @version 1.0
// * 
// */
//public class CourseTest {
//
//	/**
//	 * 新增
//	 */
//	@SuppressWarnings("unused")
//	private static void insert() {
//		Course course = new Course();
//		course.setName("地理");
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			tx.begin();
//			session.save(course);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 删除
//	 */
//	@SuppressWarnings("unused")
//	private static void delete() {
//		Course course = new Course();
//		course.setId(3);
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			tx.begin();
//			session.delete(course);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 更新
//	 */
//	@SuppressWarnings("unused")
//	private static void update() {
//		Course course = new Course();
//		course.setId(5);
//		course.setName("英语");
//		Session session = HibernateUtil.currentSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			tx.begin();
//			session.update(course);
//			tx.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	/**
//	 * 获取列表
//	 */
//	@SuppressWarnings({ "rawtypes" })
//	private static void list() {
//		Session session = HibernateUtil.currentSession();
//		try {
//			// List list = session.createQuery("from Course order by id desc ").setFirstResult(0).setMaxResults(10).list();
//			
//			// 按参与名字绑定 
//			// Query query = session.createQuery("from Course where name=:name order by id desc");
//			// query.setString("name", "数学");
//			
//			// 按参数位置绑定 
//			// Query query = session.createQuery("from Course where name=? order by id desc");
//			// query.setString(0, "数学");
//			
//			// 拼字符串方式 
//			// String name = "数学";
//			// Query query = session.createQuery("from Course where name='" + name + "' order by id desc");
//			
//			// 投影查询：只能查出部分属性
//			// Query query = session.createQuery("select name from Course");
//			
//			// 聚合函数
//			Query query = session.createQuery("select count(*) from Course");
//			Long count = (Long) query.uniqueResult();
//			System.out.println("个数：" + count);
//			System.out.println("------------------");
//			query = session.createQuery("select max(name),min(name) from Course");
//			Object[] obj = (Object[]) query.uniqueResult();
//			System.out.println("obj[0]=" + obj[0] + ",obj[1]=" + obj[1]);
//			System.out.println("------------------");
//			
//			// 分组
//			query = session.createQuery("select name,count(*) from Course group by name");
//			Iterator iter = query.list().iterator();
//			while (iter.hasNext()) {
//				Object[] object = (Object[]) iter.next();
//				System.out.println("object[0]=" + object[0] + ",object[1]=" + object[1]);
//				System.out.println("------------------");
//			}
//			
//			// 内连接
//			query = session.createQuery("from Clazz a,Student b where a.id=b.clazz");
//			// 内连接
//			query = session.createQuery("from Clazz a join a.students");
//			// 外连接
//			query = session.createQuery("from Clazz a left join a.students");
//			// 外连接
//			query = session.createQuery("from Student a left join a.clazz");
//			Iterator iterator = query.list().iterator();
//			while (iterator.hasNext()) {
//				Object[] obje = (Object[]) iterator.next();
//				Student student = (Student) obje[0];
//				System.out.println("学生信息:" + student);
//				Clazz clazz = (Clazz) obje[1];
//				System.out.println("班级信息:" + clazz);
//			}
//			System.out.println("------------------");
//			
//			List list = query.list();
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}
//			System.out.println("------------------");
//			Course course = (Course) session.load(Course.class, 5);
//			System.out.println(course);
//			course = (Course) session.get(Course.class, 5);
//			System.out.println(course);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			HibernateUtil.closeSession();
//		}
//	}
//
//	public static void main(String[] args) {
//		// 新增
////		insert();
//		// 更新
////		update();
//		// 删除
////		delete();
//		// 获取列表
//		list();
//	}
//}
