package com.sxt.manager.utils;

import java.util.List;

public class Pagination {

	/**
	 * 用户指定得出
	 */
	private int currentPage ; 			//　　 当前页
	private int pageSize ; 				//　　 每页显示的记录数量
	/**
	 * 数据库查询得出
	 */
	private int total ; 				//    总记录数 totalCount
	private List rows ;					// 　 本页的数据列表record
	/**
	 * 经过计算得出
	 */
	private int pageCount ; 			//　　 总页数																													
	private int startPageIndex ;		//    页码列表的开始索引
	private int endPageIndex ;			//	     页码列表的结束索引

	
	
	public Pagination() {
	}


	/**
	 * this PageView Constructor
	 * @param currentPage
	 * @param pageSize
	 * @param rows
	 * @param recordList
	 */
	public Pagination(int currentPage, int pageSize, int total, List rows) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.total = total;
		this.rows = rows;
	
		pageCount = (total + pageSize - 1)/ pageSize ;		//总页数
		
		  
		if(pageCount <= pageSize) {	// 总页码不大于NicConfiguration.getPageSize()
			startPageIndex = 1 ;		// 页码列表的开始索引
			endPageIndex = pageCount ;	// 页码列表的结束索引
		} else {	// 总页码大于NicConfiguration.getPageSize() 
			startPageIndex = currentPage - 4 ;
			endPageIndex = currentPage + 5 ;

			if(startPageIndex < 1 ){	// 前面的页码不足4个   
				startPageIndex = 1 ; 
				endPageIndex = pageSize ;
			} else if(endPageIndex > pageCount) {	// 后面的页码不足5个 
				startPageIndex =  endPageIndex - pageSize + 1; 
				endPageIndex = pageCount ;				
			}
			
		}
	}
	

	/**
	 * getters and setters
	 * @return
	 */

	
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartPageIndex() {
		return startPageIndex;
	}
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
}
