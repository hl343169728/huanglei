package com.sxt.manager.model;

public class Memo {
	private int id;
	private String content;		    //备忘录内容
	private String startTime;		//开始时间
	private String endTime;			//结束时间
	private String state;			//状态：新创建（现在时间小于开始时间）、有效（现在时间在开始时间与结束时间之间）、过期（现在现价大于结束时间）
	private int userId;				//用户的id
	
	public Memo() {
		super();
	}
	public Memo(int id, String content, String startTime, String endTime,
			String state, int userId) {
		super();
		this.id = id;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
		this.userId = userId;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
