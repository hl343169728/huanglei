package com.sxt.manager.dao;

import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Student;

public interface StudentDao  extends BaseDao<Student>{

	//验证QQ是否存在
	boolean checkStudentQQ(String qq) throws Exception;

	//获取有意向的学员的列表信息
	List<Map> getStudentList(String currentPage, String pageSize ,String flag) throws Exception;

	//获取学员总记录数
	int getStudentTotal(String flag) throws Exception;

	//获取预备学学员的信息列表
	List<Map> getPreStudentList(String currentPage, String pageSize) throws Exception;

	//获取预备学学员的总数
	int getPreStudentTotal() throws Exception;

	//获取正式学员的总记录数
	int getRealStudentTotal(String flag) throws Exception;

	//获取学员的首付款
	double getPrePayFeeValue() throws Exception;
	
}
