package com.bjsxt.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bjsxt.po.Department;
import com.bjsxt.service.DepartmentService;

@Component
@Scope("prototype")
public class DepartmentAction {
	@Resource
	private DepartmentService departmentService;
	private Integer id;
	private Department department;
	private List<Department> list;
	
	/**
	 * 获取所属部门的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		this.department = this.departmentService.findById(this.id);
		return "detail";
	}
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
}
