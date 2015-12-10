package com.bjsxt.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.po.Student;
import com.bjsxt.utils.PageInfo;

@Component
public class StudentDaoImpl implements StudentDao{
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
	public void add(Student s) {
		hibernateTemplate.save(s);
	}

	/**
	 * 删除方法
	 */
	public void del(Student s) {
		hibernateTemplate.delete(s);
	}

	/**
	 * 查询所有信息的方法
	 */
	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		return hibernateTemplate.find("from Student");
	}

	/**
	 * 根据id查找指定对象的方法
	 */
	public Student findById(int id) {
		return (Student) hibernateTemplate.get(Student.class, id);
	}

	/**
	 * 更新方法
	 */
	public void update(Student s) {
		hibernateTemplate.update(s);
	}
	
	/**
	 * 查询学员信息及分页的实现
	 */
	public PageInfo findAll(final Integer pageNum,final String sname) {
		return (PageInfo) hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = " from Student s where 1=1 ";
				if(sname!=null && !"".equals(sname)){
					hql += " and s.sname like '%"+sname+"%'";
				}
				Number count = (Number) session.createQuery("select count(*)"+hql).uniqueResult();
				PageInfo pageInfo = new PageInfo(pageNum,count.intValue());
				Query query = session.createQuery(hql);
				query.setFirstResult((pageInfo.getPageNum()-1)*10);
				query.setMaxResults(10);
				pageInfo.setList(query.list());
				return pageInfo;
			}
		});
	}
}
