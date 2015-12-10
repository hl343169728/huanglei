package com.bjsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String number;		//门牌编号
	private String  state;		//房屋状态
	private String  bname;		//楼宇名字
	private String  unitNum;	//单元号
	private Integer floor;		//所属楼层
	private String  type;		//所属户型
	private Integer area;		//房屋面积
	private String  remark;		//备注
	
	@ManyToOne
	private Owner owner;
	
	public House() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getUnitNum() {
		return unitNum;
	}
	public void setUnitNum(String unitNum) {
		this.unitNum = unitNum;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}
