package com.sxt.manager.model;

public class EmployeeJob {
	private int id;
	private int empId;
	private int jobId;
	
	
	public EmployeeJob() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeJob(int id, int empId, int jobId) {
		super();
		this.id = id;
		this.empId = empId;
		this.jobId = jobId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
}
