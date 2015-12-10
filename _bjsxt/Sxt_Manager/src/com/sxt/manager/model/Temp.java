package com.sxt.manager.model;

public class Temp {

	private int id ; 
	private String name ;
	//private int age ; 
	private String sex ; 
	private String birthday ;
	private String r_id;
	
	public Temp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Temp(int id, String name,  String sex, String birthday, //int age,
			String rId) {
		super();
		this.id = id;
		this.name = name;
		//this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		r_id = rId;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
/*	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}*/
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the r_id
	 */
	public String getR_id() {
		return r_id;
	}
	/**
	 * @param rId the r_id to set
	 */
	public void setR_id(String rId) {
		r_id = rId;
	}
	
	
	
}
