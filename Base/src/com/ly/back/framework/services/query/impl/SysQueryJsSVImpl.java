package com.ly.back.framework.services.query.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.back.framework.mybatis.mapper.sys.SysQueryJsMapper;
import com.ly.back.framework.mybatis.model.sys.SysQueryJs;
import com.ly.back.framework.mybatis.model.sys.SysQueryJsExample;
import com.ly.back.framework.services.query.interfaces.ISysQueryJsSV;
import com.ly.common.service.impl.BaseSV;
@Service
public class SysQueryJsSVImpl extends BaseSV implements ISysQueryJsSV{
	@Autowired
	private SysQueryJsMapper queryJsMapper;

	@Override
	public List<SysQueryJs> getSysQueryJsList(String queryId) {
		SysQueryJsExample example = new SysQueryJsExample();
		SysQueryJsExample.Criteria criteria = example.createCriteria();
		criteria.andQueryIdEqualTo(queryId);
		return queryJsMapper.selectByExample(example);
	}
}
