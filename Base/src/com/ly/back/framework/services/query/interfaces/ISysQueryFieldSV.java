package com.ly.back.framework.services.query.interfaces;

import java.util.List;

import com.ly.back.framework.mybatis.model.sys.SysQueryField;

public interface ISysQueryFieldSV {

	public List<SysQueryField> getFields(String queryId)throws Exception;

}
