package com.bjsxt.model;

public class Employee {

	// 主键
	private int id;
	// 雇员姓名
	private String name;
	// 密码
	private String password;
	// 薪水
	private String salary;
	// 联系方式
	private String tell;
	// 出生日期
	private String birthday;
	// 入职日期
	private String hiredate;
	// 此字段用于关联position表的主键
	private String p_id;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String password, String salary,
			String tell, String birthday, String hiredate, String pId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.salary = salary;
		this.tell = tell;
		this.birthday = birthday;
		this.hiredate = hiredate;
		p_id = pId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTell() {
		return tell;
	}

	public void setTell(String tell) {
		this.tell = tell;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String pId) {
		p_id = pId;
	}
}
