package com.sxt.manager.service;

import java.util.List;
import java.util.Map;

import com.sxt.manager.dto.OrgDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Org;
import com.sxt.manager.model.User;

public interface OrgService {
	

	/**
	 * 增加一个机构
	 * @param org
	 */
	public  void  saveOrg(int parentId) throws Exception;
	/**
	 * 修改指定机构信息
	 * @param org
	 */
	public void updateOrg(Org org , int parentId) throws Exception;
	/**
	 * 删除机构
	 * @param id
	 */
	public void  deleteOrg(int id) throws Exception;
	/**
	 * 根据id查询指定机构
	 * @param id
	 * @return
	 */
	public Org findById(int id) throws Exception;
	
	/**
	 * 获取根节点
	 * @return
	 * @throws Exception
	 */
	public Org getRootOrg() throws Exception;
	/**
	 * 创建根节点并返回
	 * @throws Exception
	 */
	public Org createRootOrg() throws Exception;
	
	/**
	 * 根据根节点返回一个树形结构 (orgDTO)
	 * @param root
	 * @return
	 */
	public OrgDTO getRootOrgDTO(Org root) throws Exception;
	
	/**
	 * 根据根节点返回一个树形结构(ZtreeDTO)
	 * @param root
	 * @return
	 */
	public ZtreeDTO getZtreeOrgDTO(Org org , int parentId , int id , int orgId) throws Exception;
	
	/**
	 * 根据id获取所有的孩子（直接子节点） 
	 * @return
	 */
	public List<Org> findChildById(int id)  throws Exception;
	
	/**
	 * 获取所有叶子节点 leaf = 1 
	 * @return
	 */
	public List<Org> findByLeafOrg() throws Exception;
	
	public ZtreeDTO getOrgDTOTree(Org root, int orgNodeId) throws Exception;
	
	


	

	
	
	
	
}
