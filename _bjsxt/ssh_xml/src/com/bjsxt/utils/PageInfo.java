package com.bjsxt.utils;

import java.util.List;

public class PageInfo {
	private Integer pageNum;	//页号
	private Integer pageCount;	//页数
	private Integer totalRecord;//总记录数
	private Integer pageBegin;	//起始页
	private Integer pageEnd;	//末尾页
	private List list;
	
	/**
	 * 带参数的构造方法
	 * @param number
	 * @param total
	 */
	public PageInfo(Integer number,Integer total) {
		//页号
		this.pageNum = (number==null)?1:number;
		//总记录数
		this.totalRecord = total;
		//总页数
		this.pageCount = (int) Math.ceil(total/10.0);
		//起始页
		this.pageBegin = (this.pageNum-10<=0)?1:(this.pageNum-10);
		//末尾页
		this.pageEnd = (this.pageNum+9>=this.pageCount)?this.pageCount:(this.pageNum+9);
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
