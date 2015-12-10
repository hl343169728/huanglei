package com.sxt.manager.model;

import java.util.Date;

/**
 * 班级
 * @author ThinkPad
 *
 */
public class Banji {
	private int id;
	private String sn; //班级编号
	private Date startTime;
	private Date endTime;
	private String type;  //脱产班，业余班，基地班，周末班，网络班，远程同步班
	private double totalXuefei; //总学费
	private double fuqingXuefei;  //学期内付清学费
	private double shoufuXuefei;  //首付款
	private int teacherUserId; //班主任id

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTotalXuefei() {
		return totalXuefei;
	}

	public void setTotalXuefei(double totalXuefei) {
		this.totalXuefei = totalXuefei;
	}

	public double getFuqingXuefei() {
		return fuqingXuefei;
	}

	public void setFuqingXuefei(double fuqingXuefei) {
		this.fuqingXuefei = fuqingXuefei;
	}

	public double getShoufuXuefei() {
		return shoufuXuefei;
	}

	public void setShoufuXuefei(double shoufuXuefei) {
		this.shoufuXuefei = shoufuXuefei;
	}

	public int getTeacherUserId() {
		return teacherUserId;
	}

	public void setTeacherUserId(int teacherUserId) {
		this.teacherUserId = teacherUserId;
	}
	
	
	
}
