package com.ly.back.framework.services.query.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryMapper;
import com.ly.back.framework.mybatis.model.sys.SysQuery;
import com.ly.back.framework.services.query.interfaces.ISysQuerySV;
import com.ly.common.exception.BusException;
import com.ly.common.service.impl.BaseSV;
import com.ly.common.util.EasyUiGirdUtil;
@Service
public class SysQuerySVImpl extends BaseSV implements ISysQuerySV{
	@Autowired
	private SysQueryMapper queryMapper;

	@Override
	public String queryList(String queryId, String queryJson,Integer page,Integer rows) throws Exception,BusException {
		SysQuery sysQuery = queryMapper.selectByPrimaryKey(queryId);
		String sql = this.getQuerySql(queryJson, sysQuery.getSql());
		
		int total = -1;
		List<Map<String, Object>> list = null;
		if(page!=null&&rows!=null){
			total = this.getJdbcDao().jdbcGetSize(sql, null);
			list = this.getJdbcDao().jdbcQueryForList(EasyUiGirdUtil.getPageSql(sql, page,
					rows), null);
		}else{
			list = this.getJdbcDao().jdbcQueryForList(sql, null);
		}
	
		
		
		
		
		
		
		return EasyUiGirdUtil
				.dataToGirdJson(total, rows==null?-1:rows, list);
	}
	private String getQuerySql(String queryJson,String sql){
		
		
		return sql;
	}
	@Override
	public SysQuery getQueryInfo(String queryId) {
		SysQuery sysQuery = queryMapper.selectByPrimaryKey(queryId);
		return sysQuery;
	}

}
