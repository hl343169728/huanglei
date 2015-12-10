package com.sxt.manager.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.dao.EmployeeDao;
import com.sxt.manager.dao.EmployeeJobDao;
import com.sxt.manager.dao.JobDao;
import com.sxt.manager.dao.OrgDao;
import com.sxt.manager.dao.impl.EmployeeDaoImpl;
import com.sxt.manager.dao.impl.EmployeeJobDaoImpl;
import com.sxt.manager.dao.impl.JobDaoImpl;
import com.sxt.manager.dao.impl.OrgDaoImpl;
import com.sxt.manager.dto.ZtreeDTO;
import com.sxt.manager.model.Employee;
import com.sxt.manager.model.EmployeeJob;
import com.sxt.manager.model.Job;
import com.sxt.manager.model.Org;
import com.sxt.manager.service.EmployeeService;
import com.sxt.manager.service.JobService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao edao = new EmployeeDaoImpl();
	private OrgDao      odao = new OrgDaoImpl();
	private JobDao      jdao = new JobDaoImpl();
	private JobService jobService = new JobServiceImpl();
	private EmployeeJobDao ejdao = new EmployeeJobDaoImpl();

	/**
	 * 保存方法
	 */
	@Override
	public void save(Employee e) throws Exception {
		
		this.edao.save(e);
		// 设置员工与职位的关联关系
		String[] jobids = e.getJobIds().split(",");
		if(!"".equals(e.getJobIds()) && e.getJobIds() != null){
			
			
			for(String jobid : jobids){
				// cardid 唯一 前台需要发ajax 校验
				Employee emp = this.edao.queryListForParams("select * from employee where cardid =?", new Object[]{e.getCardId()}).get(0);
				
				//循环保存中间表即可 
				EmployeeJob ej = new EmployeeJob();
				ej.setEmpId(emp.getId());
				ej.setJobId(Integer.parseInt(jobid));
				this.ejdao.save(ej);
			}			
		}
		
		//循环更新job表 
		for(String jobid : jobids){
			Job job = this.jdao.findById(Integer.parseInt(jobid));
			List<EmployeeJob> ejList = this.ejdao.queryListForParams("select * from employeejob where jobid=?", new Object[]{Integer.parseInt(jobid)});
			String employeeids = "";
			for(EmployeeJob ej : ejList) {
				employeeids +=  ej.getEmpId()+ ",";
			}
			job.setEmployeeids(employeeids.substring(0,employeeids.length()-1));
			this.jdao.update(job);
		}		
	}

	/**
	 * 查询在职员工列表信息并展示
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getList(String currentPage ,String pageSize , String flag) throws Exception {
		
		List<Map> result = new ArrayList<Map>();
		
		List<Map> list = this.edao.getList(currentPage , pageSize , flag);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Map map = (Map) iterator.next();
			String jobIds = (String) map.get("jobIds");
			map.put("jobNames" ,this.getJobNames(jobIds));
			result.add(map);
		}
		return result;
	}

	@Override
	public int getTotal(String flag) throws Exception {
		return this.edao.getTotal(flag);
	}
	
	/**
	 *  与修改方法
	 */
	@Override
	public Employee findById(int id) throws Exception {
		return this.edao.findById(id);
	}

	@Override
	public void update(Employee emp) throws Exception {
		this.edao.update(emp);
	}
	
	/**
	 * 根据orgid 查询机构名称
	 */
	@Override
	public String findOrgNameByOrgId(int orgId) throws Exception {
		List<Org> list = this.odao.queryListForParams("select * from org where id = ?", new Object[]{orgId});
		if(list.size()>0){
			return list.get(0).getOname();
		}
		return null;
	}
	
	/**
	 * 根据orgid 获取相应的员工列表
	 */
	@Override
	public List<Employee> getEmployeeByOrgId(int orgId) throws Exception {
		return this.edao.queryListForParams("select * from employee where orgId = ?", new Object[]{orgId});
	}

	/**
	 * 获得职位树
	 */
	@Override
	public String getJobTree(String jobNodeIds) throws Exception {
		Job root = this.jdao.findRootJob();
		ZtreeDTO  ztreeDTO = this.jobService.getJobDTOTree(root , jobNodeIds);
		return JSONArray.fromObject(ztreeDTO).toString();		
	}

	/**
	 * 根据jobids字符串获取指定的职位名称.
	 * @param jobIds
	 * @return
	 * @throws Exception
	 */
	public String getJobNames(String jobIds) throws Exception{
			String jobNames = "";
			if(jobIds != null && !"".equals(jobIds)){
				String[] ids = jobIds.split(",");
				for (int i = 0; i < ids.length; i++) {
					jobNames += this.jdao.findById(Integer.parseInt(ids[i])).getJname() + ",";
				}	
				return jobNames.substring(0, jobNames.length()-1);
			}
			return jobNames;
	}

	
	/**
	 * 更新方法 
	 */
	@Override
	public void updateEmployee(int id , Employee employee) throws Exception {
		Employee emp = this.findById(id);
		emp.setEname(employee.getEname());
		emp.setBirthday(employee.getBirthday());
		emp.setAddress(employee.getAddress());
		emp.setBusComm(employee.getBusComm());
		emp.setBaseSalary(employee.getBaseSalary());
		emp.setPhoneComm(employee.getPhoneComm());
		emp.setCardId(employee.getCardId());
		emp.setRuzhiTime(employee.getRuzhiTime());
		emp.setSex(employee.getSex());
		emp.setBaoxianComm(employee.getBaoxianComm());
		//组织机构的修改设置
		if(employee.getOrgId() != 0)
		emp.setOrgId(employee.getOrgId());
		//如果新设置职位不为null 或者不为""
		if(employee.getJobIds() != null && (!"".equals(employee.getJobIds()))){
			// 如果数据库里的职位和现在新的职位不一致 则更新
			if(!employee.getJobIds().equals(emp.getJobIds())){
				//循环删除e_j表关联关系
				List<EmployeeJob> ejList = this.ejdao.queryListForParams("select * from employeejob where empid=?", new Object[]{emp.getId()});
				for(EmployeeJob ej :ejList){
					this.ejdao.delete(ej.getId());
				}
				if("0".equals(employee.getJobIds())){
					emp.setJobIds(null);	
					
					// 如果什么也不选择 则所有的职位 需要重新设置employeeids
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
					
				} else {
					emp.setJobIds(employee.getJobIds());
					//重新建立关联关系 e_j表循环新增
					for(String jobid : employee.getJobIds().split(",")){
						EmployeeJob ej = new EmployeeJob();
						ej.setEmpId(emp.getId());
						ej.setJobId(Integer.parseInt(jobid));
						this.ejdao.save(ej);
					}
					
					//循环更新job表 
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
			}
		}		
		this.edao.update(emp);
	}

	/**
	 * 获取职位是班主任的所有雇员
	 */
	@Override
	public List<Employee> getTeacherNames() throws Exception {
		return this.edao.getTeacherName();
	}

	/**
	 * 获取财务报销人
	 */
	@Override
	public List<Employee> getBaoxiaoEmployee(int userId) throws Exception {
		return this.edao.getBaoxiaoEmployee(userId);
	}

}
