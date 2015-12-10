package com.bjsxt.dao;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.po.Student;

public interface StudentDao extends BaseDao<Student>{

	//获取登录的学生
	Student findLoginStudent(String sname, String pwd) throws Exception;

}
