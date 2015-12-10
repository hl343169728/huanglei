package com.sxt.manager.service.impl;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dao.StudentDao;
import com.sxt.manager.dao.impl.StudentDaoImpl;
import com.sxt.manager.model.Student;
import com.sxt.manager.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao sdao = new StudentDaoImpl();

	/**
	 * 保存方法
	 */
	@Override
	public void save(Student student) throws Exception {
		this.sdao.save(student);
	}
	
	/**
	 * 验证QQ是否存在
	 */
	@Override
	public boolean checkStudentQQ(String qq) throws Exception {
		return this.sdao.checkStudentQQ(qq);
	}
	
	/**
	 * 获取有意向的人员的列表信息
	 */
	@Override
	public List<Map> getStudentList(String currentPage, String pageSize ,String flag)
			throws Exception {
		return this.sdao.getStudentList(currentPage,pageSize,flag);
	}
	
	/**
	 * 获取总记录数
	 */
	@Override
	public int getStudentTotal(String flag) throws Exception {
		return this.sdao.getStudentTotal(flag);
	}
	
	/**
	 * 根据id查找指定的学员
	 */
	@Override
	public Student findById(int stuId)throws Exception {
		return this.sdao.findById(stuId);
	}
	
	/**
	 * 更新方法
	 */
	@Override
	public void update(Student stu) throws Exception {
		this.sdao.update(stu);
	}

	/**
	 * 获取学员的姓名
	 */
	@Override
	public String getStudentName(int id) throws Exception {
		List<Student> sList = this.sdao.queryListForParams("select * from student where id=?", new Object[]{id});
		if(sList.size()>0){
			return sList.get(0).getSname();
		}
		return null;
	}

	/**
	 * 获取指定的对象
	 */
	@Override
	public Student getStudentById(int id) throws Exception {
		List<Student> sList = this.sdao.queryListForParams("select * from student where id=?", new Object[]{id});
		if(sList.size()>0){
			return sList.get(0);
		}
		return null;
	}

	/**
	 * 获取预备学员的信息列表
	 */
	@Override
	public List<Map> getPreStudentList(String currentPage, String pageSize)
			throws Exception {
		return this.sdao.getPreStudentList(currentPage,pageSize);
	}

	/**
	 * 获取预备学员的总记录数
	 */
	@Override
	public int getPreStudentTotal() throws Exception {
		return this.sdao.getPreStudentTotal();
	}

	/**
	 * 获取正好学员的总记录数
	 */
	@Override
	public int getRealStudentTotal(String flag) throws Exception {
		return this.sdao.getRealStudentTotal(flag);
	}

	/**
	 * 获取学员队额首付款
	 */
	@Override
	public double getPrePayFeeValue() throws Exception {
		return this.sdao.getPrePayFeeValue();
	}
	
	/**
	 * 通过gradeId获取学员的姓名
	 */
	@Override
	public List<Student> getStudentNamesByGradeId(int gradeId) throws Exception {
		return this.sdao.queryListForParams("select * from student where gradeId=?",new Object[]{gradeId});
	}

}
