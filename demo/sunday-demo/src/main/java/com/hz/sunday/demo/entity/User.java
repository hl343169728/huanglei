package com.hz.sunday.demo.entity;

import org.javafans.orm.entity.base.BaseAdminEntity;

/**
 * 用户实体
 * 
 * @author huanglei
 */
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
	/** LOGO*/
	private String logo;
	/** 省份*/
	private Long provinceId;
	/** 地区*/
	private Long districtId;
	/** 县市区*/
	private Long cityId;
	/** 经度*/
	private String longitude;
	/** 纬度*/
	private String latitude;

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
