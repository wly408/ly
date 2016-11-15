package com.ly.back.framework.services.index.interfaces;

import java.util.List;

import com.ly.back.framework.simpldata.SimplData;

public interface ISimplDataSV {

	public List<SimplData> getSimplDataListBySql(String sql);
}
