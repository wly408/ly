package com.ly.back.framework.services.query.interfaces;

import java.util.List;

import com.ly.back.framework.mybatis.model.sys.SysQueryJs;

public interface ISysQueryJsSV {

	public List<SysQueryJs> getSysQueryJsList(String queryId);
}
