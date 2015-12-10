package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.model.Employee;

public interface EmployeeService {
	
	//保存方法
	void save(Employee e) throws Exception;

	//获取总记录数
	int getTotal(String flag) throws Exception;

	//获取雇员的信息列表
	List<Map> getList(String currentPage, String pageSize , String flag) throws Exception;

	//通过id获取雇员
	Employee findById(int id) throws Exception;

	//更新
	void update(Employee emp) throws Exception;

	//通过orgId获取组织机构的名称
	String findOrgNameByOrgId(int orgId) throws Exception;

	//根据orgId获取雇员
	List<Employee> getEmployeeByOrgId(int parseInt) throws Exception;

	//获取职位数
	String getJobTree(String parameter) throws Exception;

	//根据jobIds获取职位名称
	String getJobNames(String jobIds) throws Exception;

	//更新雇员
	void updateEmployee(int id , Employee employee) throws Exception;

	//获取职位是班主任的雇员
	List<Employee> getTeacherNames() throws Exception;

	//获取财务报销人列表
	List<Employee> getBaoxiaoEmployee(int userId) throws Exception; 
	
	
}
