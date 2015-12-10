package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.po.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.utils.PageInfo;

@Component
public class StudentServiceImpl implements StudentService{
	@Resource
	private StudentDao studentDao ;
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	/**
	 * 添加方法
	 */
	public void add(Student s) throws Exception {
		this.studentDao.add(s);
	}
	
	/**
	 * 删除方法
	 */
	public void del(Integer id) throws Exception {
		Student s = this.studentDao.findById(id);
		this.studentDao.del(s);
	}
	
	/**
	 * 查询所有学员的信息
	 */
	public List<Student> findAll() throws Exception {
		return this.studentDao.findAll();
	}
	
	/**
	 * 根据id查找指定的对象
	 */
	public Student findById(Integer id) {
		return this.studentDao.findById(id);
	}
	
	/**
	 * 更新方法
	 */
	public void update(Student s) throws Exception {
		this.studentDao.update(s);
	}
	
	/**
	 * 查询学员的信息及实现分页查询
	 */
	public PageInfo findAll(Integer pageNum, String sname) throws Exception {
		return this.studentDao.findAll(pageNum, sname);
	}
}
