package com.ly.common.util;

import java.io.Serializable;
import java.util.List;

public class EasyUiGirdResult implements Serializable{


	private static final long serialVersionUID = 1L;

	private int page = 1;

	private int total;
	
	private List<?> rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	

}
