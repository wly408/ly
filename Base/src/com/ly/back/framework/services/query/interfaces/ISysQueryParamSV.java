package com.ly.back.framework.services.query.interfaces;

import java.util.List;

import com.ly.back.framework.searchmodel.query.FieldBean;
import com.ly.back.framework.searchmodel.query.SysQueryParamSearchModel;

public interface ISysQueryParamSV {

	public List<SysQueryParamSearchModel> getParams(String queryId)throws Exception;

	public List<FieldBean> doSql(String sql)throws Exception;

}
