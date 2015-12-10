package com.bjsxt.utils;

import java.util.List;

public class PageInfo {
	private Integer pageNum;		//页号
	private Integer pageCount;  	//页数
	private Integer totalRecord;  	//总记录数
	private Integer pageBegin;		//起始页
	private Integer pageEnd;		//末尾页
	private Integer pageSize;  		//每页的记录数个数
	private  List  list; 
	
	public PageInfo() {
		super();
	}

	/**
	 * 带参数的构造方法
	 * @param pageNum  指:页号（pageNum）
	 * @param pageRecord  指:总记录数（pageRecord）
	 */
	public PageInfo(Integer pageNum, Integer pageRecord) {
		System.out.println(pageNum);
		//页号
		this.pageNum = (pageNum==null)?1:pageNum;
		//总记录数
		this.totalRecord = pageRecord;
		//总页数
		this.pageCount = (int) Math.ceil(pageRecord/ 10.0);//取大的
		//起始页
		System.out.println(pageNum);
	    this.pageBegin = (this.pageNum-5<=0)?1:(this.pageNum-5);
	    //末尾页
		this.pageEnd = (this.pageNum+4>=this.pageCount)?this.pageCount:(this.pageNum+4);
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(Integer pageBegin) {
		this.pageBegin = pageBegin;
	}
	public Integer getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
}
