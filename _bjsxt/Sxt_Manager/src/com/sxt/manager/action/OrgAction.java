package com.sxt.manager.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.sxt.manager.dto.OrgDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Org;
import com.sxt.manager.service.OrgService;
import com.sxt.manager.service.impl.OrgServiceImpl;

public class OrgAction extends BaseAction{
	private int  parentId;		//父节点id(选中的父节点id)
	private int  orgId ;		//在修改员工信息的时候提供的orgId 
	
	/**
	 *  action 层 调用service 层
	 */
	private OrgService orgService = new OrgServiceImpl();
	/**
	 * 查询组织机构列表的方法 
	 * @return
	 * @throws Exception
	 */
	public String getOrgList() throws Exception {
		
		Org root = this.orgService.getRootOrg();		//获得根节点
		if(root == null){
			root = this.orgService.createRootOrg(); 
		} 
		OrgDTO rootDTO = this.orgService.getRootOrgDTO(root);
		this.myWriter(JSONArray.fromObject(rootDTO).toString());
		return NONE;
	}
	/**
	 * 新增节点的方法  
	 * @return
	 * @throws Exception
	 */
	public String saveOrg() throws Exception {
		this.orgService.saveOrg(this.parentId);
		return NONE ;
	}
	
	/**
	 * 预修改方法 
	 * @return
	 */
	public String preUpdateOrg() throws Exception {
		Org  org  = this.orgService.findById(this.id);
		this.request.setAttribute("org", org);
		Org parent = this.orgService.findById(org.getPid());
		this.request.setAttribute("parentName",parent.getOname());
		this.parentId = parent.getId();
		return "UPDATE";
	}
	/**
	 * 获取ztree数据 
	 * @return
	 * @throws Exception
	 */
	public String getOrgZtree() throws Exception{
		Org root = this.orgService.getRootOrg();		//获取根节点 
		ZtreeDTO ztreeDTO = this.orgService.getZtreeOrgDTO(root ,this.parentId,this.id ,this.orgId);
		this.myWriter(JSONArray.fromObject(ztreeDTO).toString());
		return NONE;
	}
	/**
	 * 修改方法
	 * 当你要修改的节点时总节点的时候, 前台传过来的parentId = 0 这时候不需要设置 ,所以需要加判断条件
	 * 当要修改的节点不是总节点的的时候  , parentId一定不等于0, 无论你是否修改当前节点的父机构
	 * @return
	 */
	public String updateOrg() throws Exception {
		Org org = this.orgService.findById(this.id);	//当前要修改的org对象 
		String oname = this.request.getParameter("oname");
		String principal = this.request.getParameter("principal");
		String descript = this.request.getParameter("descript");
		org.setOname(oname);
		org.setPrincipal(principal);
		org.setDescript(descript);
		this.orgService.updateOrg(org,this.parentId);
		this.request.setAttribute("url", "/jsp/org/org_list.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 删除方法
	 * @return
	 */
	public String deleteOrg() throws Exception {
		this.orgService.deleteOrg(this.id);
		this.request.setAttribute("url", "/jsp/org/org_list.jsp");
		return "SUCCESSPAGE";
	}
	
	
	/**
	 * 获取所有叶子节点 也就是LEAF = 1 
	 * @return
	 * @throws Exception
	 */
	public String getLeafOrg() throws Exception {
		List<Org> orglist = this.orgService.findByLeafOrg();
		this.myWriter(JSONArray.fromObject(orglist).toString());
		return NONE;
	}


	
	
	
	
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
	
	
	
}
