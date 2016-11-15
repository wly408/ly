package com.ly.gp.service.interfaces;

import java.util.List;

import com.ly.common.exception.BusException;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.searchModel.GpInfoSearchModel;


public interface IGpInfoDataSV {
	
	
	public void initGpInfo(List<GpInfo> infoList)throws BusException;
	
	
	public String queryList(GpInfoSearchModel infoSearchModel)throws BusException;
	
	public List<GpInfo> queryAllList()throws BusException;

	public GpInfo getGpInfByCode(String code)throws Exception;
	
}
