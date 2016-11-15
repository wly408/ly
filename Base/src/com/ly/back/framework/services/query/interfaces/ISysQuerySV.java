package com.ly.back.framework.services.query.interfaces;

import com.ly.back.framework.mybatis.model.sys.SysQuery;
import com.ly.common.exception.BusException;

public interface ISysQuerySV {

	public String queryList(String queryId, String queryJson,Integer page,Integer rows)throws Exception,BusException;

	public SysQuery getQueryInfo(String queryId);

}
