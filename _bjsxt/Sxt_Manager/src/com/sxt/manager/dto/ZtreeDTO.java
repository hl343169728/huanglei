package com.sxt.manager.dto;

import java.util.LinkedHashSet;
import java.util.Set;

public class ZtreeDTO {

	private int id ; 
	private String name ; 
	private int  parentId ;
	private int leaf ; 
	private boolean open ;		// true false 
	private boolean checked ;	// true false 
	private Set<ZtreeDTO> nodes = new LinkedHashSet<ZtreeDTO>();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parentId
	 */

	/**
	 * @return the leaf
	 */
	public int getLeaf() {
		return leaf;
	}
	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	/**
	 * @param leaf the leaf to set
	 */
	public void setLeaf(int leaf) {
		this.leaf = leaf;
	}
	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the nodes
	 */
	public Set<ZtreeDTO> getNodes() {
		return nodes;
	}
	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(Set<ZtreeDTO> nodes) {
		this.nodes = nodes;
	}
	
	
	
	
}
