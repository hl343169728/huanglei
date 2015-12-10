package com.sxt.manager.model;

/**
 * 职位
 * @author ThinkPad
 *
 */
public class Job {
	private int id;
	private String jname;
	private int pid;
	private String descript;
	private int leaf = 1;
	private int orgId;
	private String employeeids ;
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String jname, int pid, String descript, int leaf,
			int orgId, String employeeids) {
		super();
		this.id = id;
		this.jname = jname;
		this.pid = pid;
		this.descript = descript;
		this.leaf = leaf;
		this.orgId = orgId;
		this.employeeids = employeeids;
	}





	public String getEmployeeids() {
		return employeeids;
	}

	public void setEmployeeids(String employeeids) {
		this.employeeids = employeeids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}



	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getLeaf() {
		return leaf;
	}

	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	
	
}
