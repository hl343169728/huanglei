package com.sxt.manager.service.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.OrgDao;
import com.sxt.manager.dao.UserDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.OrgDaoImpl;
import com.sxt.manager.dao.impl.UserDaoImpl;
import com.sxt.manager.dto.OrgDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Org;
import com.sxt.manager.service.OrgService;

public class OrgServiceImpl implements OrgService{

	private OrgDao odao = new OrgDaoImpl();
	private EmployeeDao edao = new EmployeeDaoImpl();
	private UserDao udao = new UserDaoImpl();
	/**
	 * 获得根节点
	 */
	@Override
	public Org getRootOrg() throws Exception {
		List<Org>  list = this.odao.queryListForParams("select * from org where pid=? ",new Object[]{999999} );
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}	
	
	/**
	 * 创建根节点 
	 */
	@Override
	public Org createRootOrg() throws Exception {
		Org root = new Org();
		root.setPid(999999);		// pid = 999999
		root.setLeaf(0);			// leaf = 0  
		root.setOname("初始化根节点名称");
		this.odao.save(root);
		return getRootOrg();
	}
	
	
	/**
	 * 根据根节点 返回树形结构
	 */
	@Override
	public OrgDTO getRootOrgDTO(Org org) throws Exception {
		
		OrgDTO orgDTO = new OrgDTO();    
		orgDTO.setId(org.getId());
		orgDTO.setOname(org.getOname());
		orgDTO.setDescript(org.getDescript());   
		orgDTO.setLeaf(org.getLeaf());
		orgDTO.setPid(org.getPid());
		orgDTO.setPrincipal(org.getPrincipal());
		orgDTO.setState("open");
		//根据id 查询所有的 子节点 返回集合 
		List<Org> orgList = this.odao.queryListForParams("select * from org where pid = ?", new Object[]{org.getId()});
		HashSet<OrgDTO> dtoSet = new LinkedHashSet<OrgDTO>();
		for (int i = 0; i < orgList.size(); i++) {
			dtoSet.add(getRootOrgDTO(orgList.get(i)));
		}
		orgDTO.setChildren(dtoSet);
		return orgDTO;
	}

	
	@Override
	public ZtreeDTO getZtreeOrgDTO(Org org , int parentId , int id , int orgId) throws Exception {
		
		ZtreeDTO ztreeDTO = new ZtreeDTO();
		ztreeDTO.setId(org.getId());
		ztreeDTO.setName(org.getOname());
		ztreeDTO.setLeaf(org.getLeaf());
		ztreeDTO.setParentId(org.getPid());
		ztreeDTO.setOpen(true);
		
		if(org.getId() == parentId){
			ztreeDTO.setChecked(true);
		}
		if(org.getId() == orgId){			//选中当前的机构(员工信息列表修改的时候使用)
			ztreeDTO.setChecked(true);
		}
		//根据id 查询所有的 子节点 返回集合 
		List<Org> ztreeList = this.odao.queryListForParams("select * from org where pid = ?", new Object[]{org.getId()});
		HashSet<ZtreeDTO> dtoSet = new LinkedHashSet<ZtreeDTO>();
		for (int i = 0; i < ztreeList.size(); i++) {
			if(ztreeList.get(i).getId() == id){	//如果遍历到当前我要修改的节点 直接跳过继续下面的节点 
				continue;
			}
			dtoSet.add(getZtreeOrgDTO(ztreeList.get(i),parentId , id , orgId));
		}
		ztreeDTO.setNodes(dtoSet);
		return ztreeDTO;
	}
	
	
	/**
	 * 根据id 获取指定的对象
	 */
	@Override
	public Org findById(int id) throws Exception {
		return this.odao.findById(id);
	}

	//保存方法
	@Override
	public void saveOrg(int parentId) throws Exception {
	
		Org org = new  Org() ;
		org.setOname("新组织机构");
		org.setPid(parentId);
		Org parent  = this.odao.findById(parentId);
		//如果我是叶子节点 ,由于我新添加了子节点,所以我的leaf修改为 0 
		if(parent.getLeaf() == 1){	
			parent.setLeaf(0);
			this.odao.update(parent);
		}
		this.odao.save(org);
	}
	
	/**
	 * 根据id查询直接子节点 
	 */
	@Override
	public List<Org> findChildById(int id) throws Exception {
		return this.odao.queryListForParams("select * from org where pid = ?", new Object[]{id});
	}

	/**
	 * 修改org的方法
	 */
	@Override
	public void updateOrg(Org org , int parentId) throws Exception {
		
		Org oldParent = this.odao.findById(org.getPid()); 	//获取没有修改之前的父节点
		List<Org> oldParentChildren = this.findChildById(oldParent.getId());
		if(parentId != oldParent.getId() && oldParentChildren.size() == 1){
			oldParent.setLeaf(1);
			this.odao.update(oldParent);
		}
		
		Org newParent = this.odao.findById(parentId);	//获取新的父节点
		List<Org> newParentChildren = this.findChildById(parentId);
		if(newParentChildren.size() == 0){
			newParent.setLeaf(0);
			this.odao.update(newParent);
		}
	
		if(parentId != 0){		//表示当前要修改的父节点不是总节点的时候
			org.setPid(parentId);
		}		
		this.odao.update(org);
	}
	
	/**
	 * 根据id删除org对象
	 */
	@Override
	public void deleteOrg(int id) throws Exception {
		Org org = this.odao.findById(id);
		Org oldParent = this.odao.findById(org.getPid());
		
		if(this.findChildById(oldParent.getId()).size() == 1){
			oldParent.setLeaf(1);
			this.odao.update(oldParent);
		}
		this.odao.delete(id);
	}

	/**
	 * 获取所有的叶子节点
	 * @throws Exception 
	 */
	@Override
	public List<Org> findByLeafOrg() throws Exception {
		return this.odao.queryListForParams("select * from org where leaf =?", new Object[]{1});
	}

	
	/**
	 * 获得tree结构
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public ZtreeDTO getOrgDTOTree(Org org , int currentNodeId) throws Exception {		//currentId  分公司1部门2
		ZtreeDTO  ztreeDTO  = new ZtreeDTO();
		ztreeDTO.setId(org.getId());   //root id
		ztreeDTO.setName(org.getOname());
		ztreeDTO.setOpen(true);
		if(currentNodeId != 0){
			if(org.getId() == currentNodeId)ztreeDTO.setChecked(true);
		}
		List<Org> orgList =  this.odao.queryListForParams("select * from org where pid = ?", new Object[]{org.getId()});
		HashSet<ZtreeDTO> ztreeList = new LinkedHashSet<ZtreeDTO>();
		for(Org or : orgList){
			if(currentNodeId == 0){
				ztreeList.add(getOrgDTOTree(or , 0));
			} else {
				ztreeList.add(getOrgDTOTree(or , currentNodeId));
			}
		}
		ztreeDTO.setNodes(ztreeList);
		
		return ztreeDTO;
	}
	






}
