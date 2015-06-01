package com.hz.yisheng.demo.orm;

import org.directwebremoting.annotations.DataTransferObject;
import org.javafans.orm.entity.base.BaseAdminEntity;

/**
 * 用户实体
 * 
 * @author huanglei
 * @date 2015年4月29日 下午4:07:31
 * @version V1.0
 */
@DataTransferObject
public class User extends BaseAdminEntity {

	private static final long serialVersionUID = 1L;

	/** 用户名 */
	private String name;
	/** 地址 */
	private String address;
	/** 性别 */
	private Integer sex;
	/** 手机号 */
	private String mobile;
	/** 简介 */
	private String description;

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
