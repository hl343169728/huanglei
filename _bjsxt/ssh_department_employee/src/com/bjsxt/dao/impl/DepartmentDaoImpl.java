package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.po.Department;

@Component
public class DepartmentDaoImpl implements DepartmentDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 增加方法
	 */
	public void add(Department d) {
		hibernateTemplate.save(d);
	}

	/**
	 * 删除方法
	 */
	public void del(Department d) {
		hibernateTemplate.delete(d);
	}

	/**
	 * 更新方法
	 */
	public void update(Department d) {
		hibernateTemplate.update(d);
	}
	
	/**
	 * 查找出所有的部门信息的方法
	 */
	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		return hibernateTemplate.find("from Departmet");
	}

	/**
	 * 根据id查找出指定的对象
	 */
	public Department findById(int id) {
		return (Department) hibernateTemplate.get(Department.class, id);
	}
}
