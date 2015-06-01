package com.hz.sunday.trend.orm;

import org.javafans.orm.entity.base.BaseAdminEntity;

/**
 * 在线留言实体
 * 
 * @author huanglei
 */
public class MessageInfo extends BaseAdminEntity {

	private static final long serialVersionUID = 1L;

	private String name;// 姓名
	private String sex;// 性别
	private String address;// 开店地址
	private String mobile;// 联系电话
	private String email;// 电子邮箱
	private String comment;// 留言内容

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
