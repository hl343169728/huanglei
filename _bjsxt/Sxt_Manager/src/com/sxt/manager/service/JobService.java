package com.sxt.manager.service;

import java.util.List;

import com.sxt.manager.dto.JobDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Job;

public interface JobService {
	
	public Job findById(int id) throws Exception;
	
	
	/****************************************************************/
	/**
	 * 判断是否存在职位 
	 */
	public boolean isCreateRootJob() throws Exception ;

	/**
	 * 初始化职位
	 */
	public void addRootJob() throws Exception;

	/**
	 * 查找根职位
	 * @return
	 * @throws Exception
	 */
	public Job findRootJob() throws Exception;

	/**
	 * 获取职位树形结构 并转为VO对象
	 * @param root
	 * @return
	 */
	public JobDTO getJobDTOList(Job root) throws Exception;

	/**
	 * 根据父id查找指定的集合
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Job> findByParentId(int parentId) throws Exception;
	
	/**
	 * 更新职位 
	 * @param parent
	 * @throws Exception
	 */
	public void updateJob(Job job) throws Exception ;	
	
	/**
	 * 更新职位 (重载方法)
	 * @param parent
	 * @throws Exception
	 */
	public void updateJob(int id ,String jname , int orgId , String descript , int parentId) throws Exception ;

	/**
	 * 保存职位
	 * @param job
	 * @throws Exception
	 */
	public void saveJob(int parentId)throws Exception;
	
	
	/**
	 * 删除职位
	 * @param id
	 * @throws Exception
	 */
	public void deleteJob(int id) throws Exception;

	
	/**
	 * 获取职位树状结构
	 * @param root
	 * @param parentId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ZtreeDTO getZTree(Job root, int parentId, int id) throws Exception;

	
	/**
	 * 获取职位结构 (用于Employee 提供添加职位)
	 * 注: 此tree为复选框
	 * @param root
	 * @param jobNodeId
	 * @return
	 * @throws Exception
	 */
	public ZtreeDTO getJobDTOTree(Job root, String jobNodeIds) throws Exception;

	/**
	 * 更新所有employeeids字段
	 * @throws Exception
	 */
	public void updateJobEmployeeIds() throws Exception;

	/**
	 * 转换po对象为vo对象
	 * @param job
	 * @return
	 * @throws Exception
	 */
	public JobDTO changeJobDTO(Job job) throws Exception;
}
