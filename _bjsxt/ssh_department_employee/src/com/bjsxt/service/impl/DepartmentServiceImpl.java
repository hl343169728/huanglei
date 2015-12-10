package com.bjsxt.service.impl;

import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.po.Department;
import com.bjsxt.po.Employee;
import com.bjsxt.service.DepartmentService;

@Component
public class DepartmentServiceImpl implements DepartmentService{
	@Resource
	private DepartmentDao dao;
	public DepartmentDao getDao() {
		return dao;
	}
	public void setDao(DepartmentDao dao) {
		this.dao = dao;
	}
	
	/**
	 * 根据id查找指定的对象
	 */
	public Department findById(Integer id) throws Exception {
		Department d = this.dao.findById(id);
		Set<Employee> employees = d.getEmployees();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getEname());
		}
		return d;
	}
}
