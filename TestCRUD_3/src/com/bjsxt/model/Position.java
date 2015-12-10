package com.bjsxt.model;

public class Position {
	//主键
	private int id ;
	//岗位名称
	private String name;
	//岗位等级
	private String level;
	//岗位描述
	private String description;
	public Position() {
		super();
	}
	public Position(int id, String name, String level, String description) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.description = description;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
