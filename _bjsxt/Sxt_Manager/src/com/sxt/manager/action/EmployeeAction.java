package com.sxt.manager.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.sxt.manager.model.Employee;
import com.sxt.manager.model.User;
import com.sxt.manager.service.EmployeeService;
import com.sxt.manager.service.impl.EmployeeServiceImpl;


public class EmployeeAction extends BaseAction {
	//属性驱动
	private Employee employee ;		// orgid
	//service层
	private EmployeeService employeeService = new EmployeeServiceImpl();
	private User loginUser = (User) this.session.getAttribute("loginUser");
	
	/**
	 * 保存的方法
	 */
	public String saveEmployee() throws Exception{
		this.employeeService.save(this.employee);
		this.request.setAttribute("url", "/jsp/employee/employee_add.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 显示列表信息
	 */
	@SuppressWarnings("unchecked")
	public String getEmployeeList() throws Exception {
		String currentPage = request.getParameter("page");		//当前页
		String pageSize    = request.getParameter("rows");		//每页显示的记录数
		//取得flag标识 如果为1 证明是查询onList列表 ,  为2 outList
		String flag  = request.getParameter("flag");
		//1 获取分页结果数据 , 以及总记录数
		List<Map> list = this.employeeService.getList(currentPage,pageSize ,flag);
		int total = this.employeeService.getTotal(flag);
		//2 传输数据
		//写出指定的json格式的数据： {'total': 20 , rows:[{id:1,ename:'张三'},{id:2.ename:'李四'}] }
		String json = "{\"total\":"+total+" , \"rows\":"+ JSONArray.fromObject(list).toString()+" }";
		this.myWriter(json);
		return NONE;
	}
	
	/**
	 * 预修改方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdateEmployee() throws Exception {
		this.employee = this.employeeService.findById(this.id);
		String orgName = this.employeeService.findOrgNameByOrgId(this.employee.getOrgId());
		this.request.setAttribute("orgName",orgName);
		//获得职位名称
		this.request.setAttribute("jobNames", this.employeeService.getJobNames(this.employee.getJobIds()));
		return "UPDATE";
	}
	
	/**
	 * 修改方法
	 * @return
	 * @throws Exception
	 */
	
	public String updateEmployee() throws Exception{
		this.employeeService.updateEmployee(this.id , this.employee);
		this.request.setAttribute("url", "/jsp/employee/employee_onlist.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 申请离职的方法
	 * @return
	 * @throws Exception
	 */
	public String preLeave() throws Exception {
		this.employee = this.employeeService.findById(this.id);
		return "LEAVE";
	}
	
	/**
	 * 离职方法 
	 * @return
	 * @throws Exception
	 */
	public String leave() throws Exception{
		Employee emp = this.employeeService.findById(this.id);
		emp.setLizhiTime(this.employee.getLizhiTime());
		emp.setCizhiTime(this.employee.getCizhiTime());
		emp.setCizhiReason(this.employee.getCizhiReason());
		emp.setState("辞职");
		this.employeeService.update(emp);
		this.request.setAttribute("url", "/jsp/employee/employee_onlist.jsp");
		return "SUCCESSPAGE";
	}
	
	/**
	 * 根据orgId取得相应的员工列表
	 * @return
	 * @throws Exception
	 */
	public String getEmployeeByOrgId() throws Exception{	
		String orgId = this.request.getParameter("orgId");
		List<Employee> emplist = this.employeeService.getEmployeeByOrgId(Integer.parseInt(orgId));
		this.myWriter(JSONArray.fromObject(emplist).toString());
		return NONE;
	}
	
	//获得职位树方法：
	/**
	 * 获得职位tree结构
	 * @return
	 * @throws Exception
	 */
	public String getJobTree() throws Exception {
		String jobjson = this.employeeService.getJobTree(this.request.getParameter("jobNodeIds"));
		this.myWriter(jobjson);
		return NONE;
	}
	
	/**
	 * 获取职位是班主任的雇员姓名
	 * @return
	 * @throws Exception
	 */
	public String getTeacherName() throws Exception{
		List<Employee> eList = this.employeeService.getTeacherNames();
		this.myWriter(JSONArray.fromObject(eList).toString());
		return NONE;
	}
	
	/**
	 * 获取财务报销人
	 * @return
	 * @throws Exception
	 */
	public String getBaoxiaoEmployee() throws Exception{
		List<Employee> eList = this.employeeService.getBaoxiaoEmployee(this.loginUser.getId());
		this.myWriter(JSONArray.fromObject(eList).toString());
		return NONE;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
