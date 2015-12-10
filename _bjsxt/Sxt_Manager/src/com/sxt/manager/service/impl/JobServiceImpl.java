package com.sxt.manager.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.EmployeeJobDao;
import com.sxt.manager.dao.JobDao;
import com.sxt.manager.dao.OrgDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.EmployeeJobDaoImpl;
import com.sxt.manager.dao.impl.JobDaoImpl;
import com.sxt.manager.dao.impl.OrgDaoImpl;
import com.sxt.manager.dto.JobDTO;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.EmployeeJob;
import com.sxt.manager.model.Job;
import com.sxt.manager.model.Org;
import com.sxt.manager.service.JobService;

public class JobServiceImpl implements JobService{

	private JobDao jdao = new JobDaoImpl();
	private OrgDao odao = new OrgDaoImpl();
	private EmployeeJobDao ejdao = new EmployeeJobDaoImpl();
	private EmployeeDao edao = new EmployeeDaoImpl();
	
	/**
	 * 判断是否存在根职位
	 */
	@Override
	public boolean isCreateRootJob() throws Exception {
		return this.jdao.isCreateRootJob();
	}
	
	/**
	 *  添加根职位
	 */
	@Override
	public void addRootJob() throws Exception {
		this.jdao.addRootJob();
	}
	
	/**
	 * 查找根职位
	 */
	@Override
	public Job findRootJob() throws Exception {
		return this.jdao.findRootJob();
	}

	
	/**
	 * 根据父节点获取孩子节点
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<Job> findByParentId(int parentId) throws Exception {
		return this.jdao.findByParentId(parentId);
	}	
	
	
	/**
	 * 获取职位的树状结构 递归转成JobVO对象
	 */
	public JobDTO getJobDTOList(Job root) throws Exception {
		JobDTO jobDTO = new JobDTO();
		jobDTO.setId(root.getId());
		jobDTO.setJname(root.getJname());
		jobDTO.setDescript(root.getDescript());
		jobDTO.setState("open");
		jobDTO.setOrgId(root.getOrgId());
		String orgName = this.odao.findById(root.getOrgId()).getOname();
		jobDTO.setOname(orgName);	//获取组织机构名称
		jobDTO.setEmployeeIds(root.getEmployeeids());
		List<Job> orgList = this.jdao.findByParentId(root.getId());
		List<JobDTO> voList = new ArrayList<JobDTO>();
		for(Job job : orgList){
			voList.add(getJobDTOList(job));
		}
		jobDTO.setChildren(voList);
		return jobDTO;
	}

	/**
	 * 保存职位
	 */
	@Override
	public void saveJob(int parentId) throws Exception {
		
		Job job = new Job();
		job.setJname("新添职位名称");
		job.setPid(parentId);
		
		Job parent = this.jdao.findById(parentId);
		if(parent.getLeaf() == 1){	
			parent.setLeaf(0);
			this.jdao.update(parent);
		}		
		this.jdao.save(job);
	}
	
	/**
	 * 更新职位 
	 */	
	public void updateJob(Job job) throws Exception{
		this.jdao.update(job);
	}
	
	/**
	 * 更新职位 (重载方法)
	 */
	@Override
	public void updateJob(int id ,String jname , int orgId , String descript , int parentId) throws Exception {
		
		Job job = this.jdao.findById(id);
		
		Job oldParent = this.jdao.findById(job.getPid());
		List<Job> oldParentChildren = this.findByParentId(oldParent.getId());
		if(parentId != oldParent.getId() && oldParentChildren.size() == 1){
			oldParent.setLeaf(1);
			this.jdao.update(oldParent);
		}
		
		Job newParent = this.jdao.findById(parentId);	//获取新的父节点
		List<Job> newParentChildren =this.findByParentId(parentId);
		if(newParentChildren.size() == 0){
			newParent.setLeaf(0);
			this.jdao.update(newParent);
		}
	
		if(parentId != 0){		//表示当前要修改的父节点不是总节点的时候
			job.setPid(parentId);
		}	
		job.setJname(jname);
		job.setDescript(descript);
		job.setOrgId(orgId);
		this.jdao.update(job);
	}
	
	
	
	/**
	 * 根据id 查找职位
	 */
	@Override
	public Job findById(int id) throws Exception {
		return this.jdao.findById(id);
	}
	
	/**
	 * 获取职位的树状结构 转为ztree
	 */
	public ZtreeDTO getZTree(Job root, int parentId, int currentId) throws Exception {
		ZtreeDTO ztreeDTO = new ZtreeDTO();
		ztreeDTO.setId(root.getId());
		ztreeDTO.setName(root.getJname());
		if(parentId != 999999 && parentId == root.getId()){		//如果当前节点不为父节点  则设置为选中状态
			ztreeDTO.setChecked(true);			
		} else if (parentId == 999999){							//如果当前节点为父节点 则也要选中
			ztreeDTO.setChecked(true);
		}
		ztreeDTO.setOpen(true);
		List<Job> jobList = this.jdao.findByParentId(root.getId());		//获取子节点集合
		
		LinkedHashSet<ZtreeDTO> list = new LinkedHashSet<ZtreeDTO>();
		for(Job job : jobList){
			if(currentId == job.getId()){		//如果是当前节点  则不需要展示自己的树形结构
				 continue ;
			}
			if(parentId == 999999) {			//如果第一次我的父节点为0  则以后递归时候 父节点传入 对应子节点的父节点
				list.add(getZTree(job , job.getPid() , 0));		
			} else {							//如果第一次我的父加点不为0  则以后递归的时候传入 同一个父节点
				list.add(getZTree(job , parentId , currentId));			
			}	
		}
		ztreeDTO.setNodes(list);
		return ztreeDTO;
	}

	
	/**
	 * 
	 * 1 .员工表中有一个字段存储着职位集合 也需要进行更新操作 
	 * 2 .删除职位时需要注意 职位和员工关联 中间表信息需要删除
	 * 3 .进行删除职位
	 */
	@Override
	public void deleteJob(int id) throws Exception {
			// 1 根据jobid 查询 所关联的数据 更新Employee对象
			List<EmployeeJob> ejList = this.ejdao.queryListForParams("select * from employeejob where jobid=?", new Object[]{id});
			
			// 2循环删除
			for(EmployeeJob ej: ejList){
				Employee emp = this.edao.findById(ej.getEmpId());
				//循环去更新emp的JobIds
				if(emp.getJobIds().indexOf(",") != -1){
					String jobids1 = emp.getJobIds().replace(id+",", "");
					String jobids2 = emp.getJobIds().replace(","+id, "");
					if(!emp.getJobIds().equals(jobids1)){
						emp.setJobIds(jobids1);
						this.edao.update(emp);
					}
					if(!emp.getJobIds().equals(jobids2)){
						emp.setJobIds(jobids2);
						this.edao.update(emp);
					}				
				} else {
					String jobids3 = emp.getJobIds().replace(""+id, "");
					emp.setJobIds(jobids3);
					this.edao.update(emp);
				}

				//循环删除中间表数据
				this.ejdao.delete(ej.getId());
			}
			//删除职位
			this.jdao.delete(id);
	}


	/**
	 * 获取职位结构 (用于Employee 提供添加职位)
	 * 注: 此tree为复选框
	 * @param root
	 * @param jobNodeId
	 * @return
	 * @throws Exception
	 */
	@Override
	public ZtreeDTO	 getJobDTOTree(Job job, String jobNodeIds) throws Exception {
		ZtreeDTO  ztreeDTO  = new ZtreeDTO();
		ztreeDTO.setId(job.getId());   //root id
		ztreeDTO.setName(job.getJname());
		ztreeDTO.setOpen(true);
		if(jobNodeIds != null && (!"".equals(jobNodeIds))){
			String[] jobids = jobNodeIds.split(",");
			for(String jobid : jobids){
				if(job.getId() == Integer.parseInt(jobid))ztreeDTO.setChecked(true);
			}
		}
		List<Job> jobList = this.jdao.findByParentId(job.getId()); 
		LinkedHashSet<ZtreeDTO> ztreeList = new LinkedHashSet<ZtreeDTO>();
		for(Job jo : jobList){
			if(jobNodeIds == null){
				ztreeList.add(getJobDTOTree(jo , null));
			} else {
				ztreeList.add(getJobDTOTree(jo , jobNodeIds));
			}
		}
		ztreeDTO.setNodes(ztreeList);
		return ztreeDTO;
	}
	
	/**
	 * 更新所有employee字段
	 */
	@Override
	public void updateJobEmployeeIds() throws Exception {

		for(Job job : this.jdao.findAll()){
			List<EmployeeJob> ejList3 = this.ejdao.queryListForParams("select * from employeejob where jobid=?", new Object[]{job.getId()});
			String employeeids = "";
			for(EmployeeJob ej3 : ejList3) {
				employeeids += ej3.getEmpId()+ ",";
			}
			if(employeeids.length() != 0){
				job.setEmployeeids(employeeids.substring(0,employeeids.length()-1));
			} else{
				job.setEmployeeids("");
			}
			this.jdao.update(job);						
		}
	}

	/**
	 * 转换对象
	 */
	@Override
	public JobDTO changeJobDTO(Job job) throws Exception {
		JobDTO dto = new JobDTO();
		dto.setId(job.getId());
		dto.setJname(job.getJname());
		dto.setDescript(job.getDescript());
		dto.setLeaf(job.getLeaf());
		dto.setParentId(job.getPid());		//设置父节点id
		dto.setParentName(this.jdao.findById(job.getPid()).getJname());	//设置父节点名称
		dto.setOrgId(job.getOrgId());
		dto.setOname(this.odao.findById(job.getOrgId()).getOname());
		dto.setEmployeeIds(job.getEmployeeids());
		return dto;
	}











}
