package com.bjsxt.po;

public class Homework {
	private int id;
	private String title;
	private String content;
	private String filePath;
	private String time;
	
	public Homework() {
		super();
	}
	public Homework(int id, String title, String content, String filePath,
			String time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filePath = filePath;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
