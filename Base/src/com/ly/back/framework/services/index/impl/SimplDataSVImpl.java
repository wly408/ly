package com.ly.back.framework.services.index.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ly.back.framework.services.index.interfaces.ISimplDataSV;
import com.ly.back.framework.simpldata.SimplData;
import com.ly.common.service.impl.BaseSV;

@Service
public class SimplDataSVImpl extends BaseSV implements ISimplDataSV{

	@Override
	public List<SimplData> getSimplDataListBySql(String sql) {
		return this.getJdbcDao().jdbcFindList(sql, null, SimplData.class);
		
	}

}
