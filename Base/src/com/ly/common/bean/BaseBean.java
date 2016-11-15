package com.ly.common.bean;

import java.io.Serializable;

import com.ly.common.util.StringUtils;

public abstract class BaseBean implements Serializable{
	
	public String DB_KEY = "";//数据库主键
	
	public String DB_FIELD = "";//数据库字段

	private int rows = 10;//分页条数
	private int page = 1;//当前页
	private String userId;
	private static final long serialVersionUID = 1L;
	public BaseBean(){
		
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		String pageSizeTemp = "10";
		rows = StringUtils.isBlank(pageSizeTemp)?rows:Integer.valueOf(pageSizeTemp);
		return rows;
	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPage() {
		String currentPageTemp = "1";
		page = StringUtils.isBlank(currentPageTemp)?page:Integer.valueOf(currentPageTemp);
		return page;
	}
//	public void setCurrentPage(int currentPage) {
//		this.currentPage = currentPage;
//	}
	
	
	
	

}
