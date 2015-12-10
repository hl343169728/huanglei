package com.sxt.manager.model;

import java.sql.Date;

public class Employee {
	private  int  id; // 0
	private  String  ename;  // null
	private  String sex; 	 
	private  String birthday;
	private  String cardId; 		//身份证号码
	private  String address;  		//住址
	private  int orgId;				//当前用户所属机构id
	private  String   jobIds; 		//多个职位
	private  int baseSalary;  		//底薪
	private  int phoneComm;  		//话补 
	private  int busComm;   		//交通补助
	private  int baoxianComm;    	//保险补助
	private  String ruzhiTime;    	//入职日期
	private  String cizhiTime;   	//提出辞职的日期
	private  String lizhiTime;  	//真正离职日期
	private  String cizhiReason;  	//辞职原因
	private  String state="在职";  	//在职，休假，辞职
	
	
	public Employee() {
	}


	public Employee(int id, String ename, String sex ,String birthday, String cardId,
			String address, int orgId, String jobIds, int baseSalary,
			int phoneComm, int busComm, int baoxianComm, String ruzhiTime,
			String cizhiTime, String lizhiTime, String cizhiReason, String state) {
		super();
		this.id = id;
		this.ename = ename;
		this.sex = sex ; 
		this.birthday = birthday;
		this.cardId = cardId;
		this.address = address;
		this.orgId = orgId;
		this.jobIds = jobIds;
		this.baseSalary = baseSalary;
		this.phoneComm = phoneComm;
		this.busComm = busComm;
		this.baoxianComm = baoxianComm;
		this.ruzhiTime = ruzhiTime;
		this.cizhiTime = cizhiTime;
		this.lizhiTime = lizhiTime;
		this.cizhiReason = cizhiReason;
		this.state = state;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getOrgId() {
		return orgId;
	}


	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}


	public String getJobIds() {
		return jobIds;
	}


	public void setJobIds(String jobIds) {
		this.jobIds = jobIds;
	}


	public int getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}


	public int getPhoneComm() {
		return phoneComm;
	}


	public void setPhoneComm(int phoneComm) {
		this.phoneComm = phoneComm;
	}


	public int getBusComm() {
		return busComm;
	}


	public void setBusComm(int busComm) {
		this.busComm = busComm;
	}


	public int getBaoxianComm() {
		return baoxianComm;
	}


	public void setBaoxianComm(int baoxianComm) {
		this.baoxianComm = baoxianComm;
	}


	public String getRuzhiTime() {
		return ruzhiTime;
	}


	public void setRuzhiTime(String ruzhiTime) {
		this.ruzhiTime = ruzhiTime;
	}


	public String getCizhiTime() {
		return cizhiTime;
	}


	public void setCizhiTime(String cizhiTime) {
		this.cizhiTime = cizhiTime;
	}


	public String getLizhiTime() {
		return lizhiTime;
	}


	public void setLizhiTime(String lizhiTime) {
		this.lizhiTime = lizhiTime;
	}


	public String getCizhiReason() {
		return cizhiReason;
	}


	public void setCizhiReason(String cizhiReason) {
		this.cizhiReason = cizhiReason;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	
	
}