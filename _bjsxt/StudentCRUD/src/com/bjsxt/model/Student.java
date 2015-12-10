package com.bjsxt.model;

public class Student {
	//编号
	private int id;
	//姓名
	private String name;
	//学号
	private int cardId;
	//生日
	private String birthday;
	//性别
	private String sex;
	//爱好
	private String favorite;
	//毕业院校
	private String university;
	//民族
	private String nationality;
	//星座
	private String constellation;
	//无参数构造
	public Student() {
		super();
	}
	public Student(int id, String name, int cardId, String birthday,
			String sex, String favorite, String university, String nationality,
			String constellation) {
		super();
		this.id = id;
		this.name = name;
		this.cardId = cardId;
		this.birthday = birthday;
		this.sex = sex;
		this.favorite = favorite;
		this.university = university;
		this.nationality = nationality;
		this.constellation = constellation;
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
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
}
