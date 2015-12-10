package com.bjsxt.action;

import java.util.List;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.model.Employee;

public class EmployeeAction extends BaseAction{
	private int id;
	private Employee employee;
	private List<Employee> list;
	private EmployeeDao edao = new EmployeeDaoImpl();
	
	/**
	 * 保存方法
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception{
		this.edao.save(this.employee);
		return "list";
	}
	
	/**
	 * 获取员工的列表信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		this.list = this.edao.findAll();
		return "success";
	}
	
	/**
	 * 预修改的方法
	 * @return
	 * @throws Exception
	 */
	public String preUpdate() throws Exception{
		this.employee = this.edao.findById(this.id);
		return "update";
	}
	
	/**
	 * 真正的修改方法
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception{
		Employee e = this.edao.findById(this.id);
		e.setName(this.employee.getName());
		e.setAge(this.employee.getAge());
		e.setAddress(this.employee.getAddress());
		e.setPhone(this.employee.getPhone());
		this.edao.update(e);
		return "list";
	}
	
	/**
	 * 删除方法
	 * @return
	 * @throws Exception
	 */
	public String del() throws Exception{
		String[] ids = request.getParameterValues("ids");
		for (int i = 0; i < ids.length; i++) {
			this.edao.delete(Integer.parseInt(ids[i]));
		}
		this.edao.delete(this.id);
		return "list";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Employee> getList() {
		return list;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
}
