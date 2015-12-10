package com.sxt.manager.dto;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.json.JSONArray;

public class OrgDTO {

	
	private  int id;
	private  String oname;
	private  int pid;			//parentId
	private  String descript;
	private int leaf = 1;   	//默认值：1: 表示是叶子节点     0：表示不是叶子节点
	private String principal;	//该机构负责人
	private String state  ;		//设置展开的状态 open  closed
	private Set<OrgDTO> children  = new LinkedHashSet<OrgDTO>();	//各种孩子

	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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


	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}


	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}


	/**
	 * @return the descript
	 */
	public String getDescript() {
		return descript;
	}


	/**
	 * @param descript the descript to set
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}


	/**
	 * @return the leaf
	 */
	public int getLeaf() {
		return leaf;
	}


	
	
	/**
	 * @param leaf the leaf to set
	 */
	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}


	/**
	 * @return the principal
	 */
	public String getPrincipal() {
		return principal;
	}


	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(String principal) {
		this.principal = principal;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the children
	 */
	public Set<OrgDTO> getChildren() {
		return children;
	}


	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<OrgDTO> children) {
		this.children = children;
	}


	public static void main(String[] args) {
		
		
		OrgDTO o1 = new OrgDTO();		//总公司
		o1.setId(1);
		o1.setState("open");
		o1.setOname("总公司");

		OrgDTO o2 = new OrgDTO();		//cs公司
		o2.setState("open");
		o2.setOname("cs公司");
		o2.setPid(1);
		OrgDTO o3 = new OrgDTO();		//bj公司
		o3.setState("open");
		o3.setOname("bj公司");
		o3.setPid(1);
		
		Set<OrgDTO> children = new HashSet<OrgDTO>();
		children.add(o2);
		children.add(o3);
		o1.setChildren(children);
		
		
		System.out.println(JSONArray.fromObject(o1));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
