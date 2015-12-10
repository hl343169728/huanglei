package com.bjsxt.action;

import java.util.List;

import com.bjsxt.dao.StudentDao;
import com.bjsxt.dao.impl.StudentDaoImpl;
import com.bjsxt.po.Student;

public class StudentAction extends BaseAction{
	private String sname ;
	private String pwd;
	private Student student;
	private List<Student> list;
	private StudentDao sdao = new StudentDaoImpl();

	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		this.sdao.save(this.student);
		return "list";
	}
	
	/**
	 * 获取学生的列表信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.sdao.findAll();
		return "success";
	}
	/**
	 * getter和setter 方法
	 * @return
	 */
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
}
