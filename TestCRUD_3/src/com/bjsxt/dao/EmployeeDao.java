package com.bjsxt.dao;

import java.util.List;
import java.util.Map;

import com.bjsxt.basedao.BaseDao;
import com.bjsxt.model.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	
	@SuppressWarnings("rawtypes")
	List<Map> findEmpList() throws Exception;
	
	Employee findNameAndPassword(String username,String password) throws Exception;
}
