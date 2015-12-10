package com.sxt.manager.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.sxt.manager.dto.JobDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Job;
import com.sxt.manager.model.Org;
import com.sxt.manager.service.JobService;
import com.sxt.manager.service.OrgService;
import com.sxt.manager.service.impl.JobServiceImpl;
import com.sxt.manager.service.impl.OrgServiceImpl;


/**
 * 本类为职位控制类 
 * @author _oiYc
 *
 */
public class JobAction extends BaseAction{

	private JobDTO jobDTO ;
	private JobService jobService = new JobServiceImpl();
	private OrgService orgService = new OrgServiceImpl();
	private int parentId ;
	private int orgNodeId;			//org的id
	
	
	
	/**
	 * 获取职位信息列表 
	 * @return
	 * @throws Exception
	 */
	public String getJobList() throws Exception {
		
		if(!this.jobService.isCreateRootJob()){	//当没有任何职位时  默认时初始化总经理 
			this.jobService.addRootJob();
		} 
		Job root = this.jobService.findRootJob();
		JobDTO jobRoot = this.jobService.getJobDTOList(root);
		System.out.println(JSONArray.fromObject(jobRoot).toString());
		this.myWriter(JSONArray.fromObject(jobRoot).toString());
		return NONE;		
	}
	
	/**
	 * 保存新职位方法 
	 * @return
	 * @throws Exception
	 */
	public String saveJob() throws Exception {
		
		this.jobService.saveJob(this.parentId);
		return NONE;
	}
	
	
	/**
	 * 获取职位的树状结构
	 * @return
	 * @throws Exception
	 */
	public String getZTreeJob() throws Exception{
		
		int parent_id = this.jobService.findById(this.id).getPid();			//获得当前展示节点的父节点
		Job root = this.jobService.findRootJob();							//取得根节点
		ZtreeDTO ztreetDTO = this.jobService.getZTree(root , parent_id  ,id);	//传入参数 根节点 , 所属父节点 , 当前节点本身
		System.out.println(JSONArray.fromObject(ztreetDTO).toString());
		this.response.setContentType("text/html;charset=utf-8");
		this.response.getWriter().write(JSONArray.fromObject(ztreetDTO).toString());
		return NONE;
	}
	
	
	
	/**
	 * 获取组织机构的树状结构 
	 * @return
	 * @throws Exception
	 */
	public String getOrgTree() throws Exception{
		
		// 1获取根节点 
		Org root = this.orgService.getRootOrg();
		ZtreeDTO  ztreeDTO = this.orgService.getOrgDTOTree(root , this.orgNodeId);
		System.out.println(JSONArray.fromObject(ztreeDTO).toString());
		this.response.setContentType("text/html;charset=utf-8");
		this.response.getWriter().write(JSONArray.fromObject(ztreeDTO).toString());
		return NONE;
	}
	
	/**
	 * 预修改job对象
	 * @return
	 * @throws Exception
	 */
	public String preUpdateJob() throws Exception{
		
		Job job  = this.jobService.findById(this.id);		//	取得要修改的job
		this.jobDTO = this.jobService.changeJobDTO(job);
		return "UPDATE";
	}
	
	
	/**
	 * 修改职位信息方法
	 * @return
	 * @throws Exception
	 */
	public String updateJob() throws Exception {
	
		//调用重载的jobService方法进行详细更新
		this.jobService.updateJob(this.jobDTO.getId() , this.jobDTO.getJname() , this.jobDTO.getOrgId() ,this.jobDTO.getDescript() ,this.parentId);
		this.request.setAttribute("url", "/jsp/job/job_list.jsp");
		return "SUCCESSPAGE";
		
	}
	
	
	
	
	/**
	 * 删除职位
	 * @return
	 * @throws Exception
	 */
	public String deleteJob() throws Exception {
		
		Job job = this.jobService.findById(this.id);
		/**
		 * 如果我原来的父节点不是总节点
		 * 如果我原来的父节点 和现在的父节点一致 则不需要更新
		 * 如果我原来的父节点 和我现在的父节点一致 则把我原来的父节点取到 
		 * 判断除了我之外是否还有子节点 ,如果还有则不必设置 ,如果没有子节点 则设置我原来的父节点为 leaf = 1
		 */
		List<Job> oldparentList = this.jobService.findByParentId(job.getPid());
		if(job.getPid() != 999999 && oldparentList.size() == 1 && oldparentList.get(0).getId() == job.getId()){
			Job oldparent = this.jobService.findById(job.getPid());
			oldparent.setLeaf(1);
			this.jobService.updateJob(oldparent);
		}	
		
		/**
		 * 由于 职位表 与 员工表直接为多对多关联关系 则删除职位表的时候 先需要把其中间表所关联的员工信息删除
		 * 从而实现业务逻辑方法
		 */
		this.jobService.deleteJob(this.id);		
		return NONE;
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
	 * @return the orgNodeId
	 */
	public int getOrgNodeId() {
		return orgNodeId;
	}
	/**
	 * @param orgNodeId the orgNodeId to set
	 */
	public void setOrgNodeId(int orgNodeId) {
		this.orgNodeId = orgNodeId;
	}

	/**
	 * @return the jobDTO
	 */
	public JobDTO getJobDTO() {
		return jobDTO;
	}

	/**
	 * @param jobDTO the jobDTO to set
	 */
	public void setJobDTO(JobDTO jobDTO) {
		this.jobDTO = jobDTO;
	}
	

	
	
	
	
}
