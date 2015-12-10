package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Student;

public interface StudentService {

	//保存方法
	public void save(Student student) throws Exception;

	//验证用户的QQ是否存在
	public boolean checkStudentQQ(String qq) throws Exception;

	//获取有意向的人员的列表信息
	public List<Map> getStudentList(String currentPage, String pageSize ,String flag) throws Exception;

	//根据id查找指定的学员
	public Student  findById(int stuId) throws Exception;

	//获取记录总数
	public int getStudentTotal(String flag) throws Exception;

	//更新方法
	public void update(Student stu) throws Exception;

	//获取学员的姓名
	public String getStudentName(int id) throws Exception;

	//获取对象
	public Student getStudentById(int id) throws Exception;

	//获取预备学员的信息列表
	public List<Map> getPreStudentList(String currentPage, String pageSize) throws Exception;

	//获取预备学员的总记录数
	public int getPreStudentTotal() throws Exception;

	//获取正式学员的总记录数
	public int getRealStudentTotal(String flag) throws Exception;

	//获取学员的首付款
	public double getPrePayFeeValue() throws Exception;

	//通过gradeId获取Student的姓名（sname）
	public List<Student> getStudentNamesByGradeId(int gradeId) throws Exception;
}
