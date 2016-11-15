package com.ly.back.framework.services.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryFieldMapper;
import com.ly.back.framework.mybatis.model.sys.SysQueryField;
import com.ly.back.framework.mybatis.model.sys.SysQueryFieldExample;
import com.ly.back.framework.services.query.interfaces.ISysQueryFieldSV;
import com.ly.common.service.impl.BaseSV;
@Service("sysQueryFieldSV")
public class SysQueryFieldSVImpl extends BaseSV implements ISysQueryFieldSV {
	@Autowired
	private SysQueryFieldMapper filedMapper;
	
	@Override
	public List<SysQueryField> getFields(String queryId) throws Exception {
		SysQueryFieldExample example = new SysQueryFieldExample();
		SysQueryFieldExample.Criteria criteria = example.createCriteria();
		criteria.andQueryIdEqualTo(queryId);
		return filedMapper.selectByExample(example);
	}

}
