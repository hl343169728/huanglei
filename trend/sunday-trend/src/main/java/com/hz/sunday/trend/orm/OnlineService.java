package com.hz.sunday.trend.orm;

import org.javafans.orm.entity.base.BaseAdminEntity;

/**
 * 在线客服实体
 * 
 * @author huanglei
 */
public class OnlineService extends BaseAdminEntity {

	private static final long serialVersionUID = 1L;

	private String name;// 姓名
	private String address;// 地址
	private String mobile;// 电话
	private String comment;// 留言内容

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
