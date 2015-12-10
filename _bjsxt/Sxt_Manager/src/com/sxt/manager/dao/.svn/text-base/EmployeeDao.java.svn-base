package com.sxt.manager.dao;

import java.util.List;
import java.util.Map;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.User;

public interface EmployeeDao  extends BaseDao<Employee>{

	//获取雇员的信息列表
	public List<Map> getList(String currentPage ,String pageSize , String flag) throws Exception;

	//获取总记录数
	int getTotal(String flag) throws Exception;

	 //通过orgId获取用户列表
	public List<User> findByOrgId(int id) throws Exception;

	//获取职位是班主任的雇员的姓名
	public List<Employee> getTeacherName() throws Exception;

	//获取财务报销人列表
	public List<Employee> getBaoxiaoEmployee(int userId) throws Exception;

}
