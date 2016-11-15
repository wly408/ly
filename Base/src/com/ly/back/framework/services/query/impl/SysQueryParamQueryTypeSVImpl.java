package com.ly.back.framework.services.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryParamQueryTypeMapper;
import com.ly.back.framework.mybatis.model.sys.SysQueryParamQueryType;
import com.ly.back.framework.services.query.interfaces.ISysQueryParamQueryTypeSV;
import com.ly.common.service.impl.BaseSV;
@Service
public class SysQueryParamQueryTypeSVImpl  extends BaseSV implements ISysQueryParamQueryTypeSV{
	@Autowired
	private SysQueryParamQueryTypeMapper queryParamQueryTypeMapper;
	@Override
	public List<SysQueryParamQueryType> getQueryTypes() {
		// TODO Auto-generated method stub
		return queryParamQueryTypeMapper.selectByExample(null);
	}

}
