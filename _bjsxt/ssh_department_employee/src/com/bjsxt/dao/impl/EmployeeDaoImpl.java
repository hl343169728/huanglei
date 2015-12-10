package com.bjsxt.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.po.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
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
	public void add(Employee e) {
		hibernateTemplate.save(e);
	}

	/**
	 * 删除方法
	 */
	public void del(Employee e) {
		hibernateTemplate.delete(e);
	}
	
	/**
	 * 更新方法
	 */
	public void update(Employee e) {
		hibernateTemplate.update(e);
	}

	/**
	 * 查找员工的所有信息的方法
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		return hibernateTemplate.find("from Employee");
	}

	/**
	 * 根据id查找指定的对象
	 */
	public Employee findById(Integer id) {
		return (Employee) hibernateTemplate.get(Employee.class, id);
	}
}
