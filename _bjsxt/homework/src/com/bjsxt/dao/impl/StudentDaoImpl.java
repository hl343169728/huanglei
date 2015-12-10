package com.bjsxt.dao.impl;

import java.util.List;

import com.bjsxt.basedao.BaseDaoImpl;
import com.bjsxt.dao.StudentDao;
import com.bjsxt.po.Student;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	/**
	 * 获取登录的学生
	 */
	public Student findLoginStudent(String sname, String pwd) throws Exception {
		List<Student> list = this.queryListForParams("select * from student where sname=? and pwd=?", new Object[]{sname,pwd});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
