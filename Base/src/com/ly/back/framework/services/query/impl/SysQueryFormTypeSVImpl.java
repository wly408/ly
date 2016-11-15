package com.ly.back.framework.services.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryFormTypeMapper;
import com.ly.back.framework.mybatis.model.sys.SysQueryFormType;
import com.ly.back.framework.services.query.interfaces.ISysQueryFormTypeSV;
import com.ly.common.service.impl.BaseSV;
@Service
public class SysQueryFormTypeSVImpl extends BaseSV implements ISysQueryFormTypeSV {
	@Autowired
	private SysQueryFormTypeMapper queryFormTypeMapper;
	
	@Override
	public List<SysQueryFormType> getFormTypes() {
		
		return queryFormTypeMapper.selectByExample(null);
	}

}
