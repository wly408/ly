package com.ly.back.framework.searchmodel.query;

import com.ly.back.framework.mybatis.model.sys.SysQueryParam;

public class SysQueryParamSearchModel extends SysQueryParam {
	
	private String formTypeName;
	
	private String queryTypeName;
	
	private String queryTypeCode;

	public String getFormTypeName() {
		return formTypeName;
	}

	public void setFormTypeName(String formTypeName) {
		this.formTypeName = formTypeName;
	}

	public String getQueryTypeName() {
		return queryTypeName;
	}

	public void setQueryTypeName(String queryTypeName) {
		this.queryTypeName = queryTypeName;
	}

	public String getQueryTypeCode() {
		return queryTypeCode;
	}

	public void setQueryTypeCode(String queryTypeCode) {
		this.queryTypeCode = queryTypeCode;
	}
	
	

}
