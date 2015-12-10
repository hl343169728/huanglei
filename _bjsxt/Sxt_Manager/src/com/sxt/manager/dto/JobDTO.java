package com.sxt.manager.dto;

import java.util.ArrayList;
import java.util.List;

public class JobDTO {
	private int id;
	private String jname;
	private int parentId;
	private String parentName ;
	private String state ;				//展开状态
	private String descript;
	private int leaf = 1;
	private int orgId;
	private String oname ;
	private List<JobDTO> children = new ArrayList<JobDTO>(); 
	private String employeeIds ;
	
	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobDTO(int id, String jname, int parentId, String parentName,
			String state, String descript, int leaf, int orgId, String oname,
			List<JobDTO> children, String employeeIds) {
		super();
		this.id = id;
		this.jname = jname;
		this.parentId = parentId;
		this.parentName = parentName;
		this.state = state;
		this.descript = descript;
		this.leaf = leaf;
		this.orgId = orgId;
		this.oname = oname;
		this.children = children;
		this.employeeIds = employeeIds;
	}


	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public List<JobDTO> getChildren() {
		return children;
	}
	public void setChildren(List<JobDTO> children) {
		this.children = children;
	}
	public String getEmployeeIds() {
		return employeeIds;
	}
	public void setEmployeeIds(String employeeIds) {
		this.employeeIds = employeeIds;
	}
	/**
	 * @return the oname
	 */
	public String getOname() {
		return oname;
	}
	/**
	 * @param oname the oname to set
	 */
	public void setOname(String oname) {
		this.oname = oname;
	}


	
	
	
}
