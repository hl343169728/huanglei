package com.bjsxt.dao.impl;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.dao.DepartmentDao;
import com.bjsxt.po.Department;

public class DepartmentDaoImplTest extends TestCase{
	public void testAdd(){
		Department d = new Department();
		d.setDname("销售部");
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		DepartmentDao departmentDao = (DepartmentDao) ac.getBean("departmentDaoImpl");
		departmentDao.add(d);
	}
}
