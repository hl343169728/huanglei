package com.sxt.manager.dao;

import java.util.List;

import com.sxt.manager.basedao.BaseDao;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.Job;

public interface JobDao extends BaseDao<Job> {

	
	public boolean isCreateRootJob() throws Exception;
	
	public void addRootJob() throws Exception;
	
	public Job findRootJob() throws Exception;
	
	
	public List<Job> findByParentId(int parentId) throws Exception;
	
	/**
	 * 返回job下面所有的员工。如果没有员工，则返回null
	 * @param jobId
	 * @return
	 */
	public List<Employee>  findEmployeeInJob(int jobId);
	
	
	/**
	 * 获得职位的父职位。如果没有返回null
	 * @param orgId
	 * @return
	 */
	public Job  findParentJob(int jobId);
	
	/**
	 * 获得职位下的一级子职位。如果没有返回null
	 * @param orgId
	 * @return
	 */
	public List<Job>  findChildren(int orgId);

	/**
	 * 获得职位下的所有子职位(子职位，孙职位等等)。如果没有返回null
	 * @param orgId
	 * @return
	 */
	public List<Job>  findAllChildren(int orgId);
	
	/**
	 * 获得该雇员的所有职位
	 * @param empId
	 * @return
	 */
	public List<Job>  findAllByEmpId(int empId);



	







	
	
}