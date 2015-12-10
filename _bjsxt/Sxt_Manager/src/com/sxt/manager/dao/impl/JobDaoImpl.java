package com.sxt.manager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxt.manager.basedao.BaseDaoImpl;
import com.sxt.manager.dao.JobDao;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.Job;
import com.sxt.manager.utils.DBUtils;

public class JobDaoImpl extends BaseDaoImpl<Job> implements JobDao{

	
	
	@Override
	public boolean isCreateRootJob() throws Exception {

		Connection conn = DBUtils.createConn();
		String sql = "select count(*) from job";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		int root = 0;
		if(rs.next()){
			root = rs.getInt(1);
		} 
		if(root == 0){
			return false;
		} else {
			return true ;
		}
	}
	@Override
	public void addRootJob() throws Exception {
		Job job = new Job();
		job.setJname("总经理");
		job.setLeaf(0);
		job.setPid(999999);
		this.save(job);		
	}
	@Override
	public Job findRootJob() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select * from job where pid = 999999";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ResultSet rs = ps.executeQuery();
		Job root = new Job();
		if(rs.next()){
			root.setId(rs.getInt("id"));
			root.setJname(rs.getString("jname"));
			root.setLeaf(rs.getInt("leaf"));
			root.setPid(rs.getInt("pid"));
			root.setOrgId(rs.getInt("orgid"));
			root.setDescript(rs.getString("descript"));
		}
		return root; 
	}	
	
	/**
	 * 根据父节点id 查找所有的子节点
	 */
	@Override
	public List<Job> findByParentId(int parentId) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select * from job where pid = ?";
		PreparedStatement ps = DBUtils.getStat(conn, sql);
		ps.setInt(1, parentId);
		ResultSet rs = ps.executeQuery();	
		List<Job> jobList = new ArrayList<Job>();
		while(rs.next()){
			Job job = new Job();
			job.setId(rs.getInt("id"));
			job.setJname(rs.getString("jname"));
			job.setLeaf(rs.getInt("leaf"));
			job.setPid(rs.getInt("pid"));
			job.setOrgId(rs.getInt("orgid"));
			job.setDescript(rs.getString("descript"));
			jobList.add(job);
		}
		return jobList;
	}
	@Override
	public List<Job> findAllByEmpId(int empId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Job> findAllChildren(int orgId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Job> findChildren(int orgId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Employee> findEmployeeInJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Job findParentJob(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}


}
