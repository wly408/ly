package com.ly.gp.service.interfaces;

import java.util.List;

import com.ly.gp.mybatis.model.info.GpData;
import com.ly.gp.mybatis.model.info.GpInfo;

public interface IGpDetailDataSV {

	void collGpDetailJd(GpInfo gpInfo, String jd) throws Exception;
	
	
	void js(GpInfo gpInfo)throws Exception;
	
	void recordError(String code,String error)throws Exception;

	public List<GpData> getKLineGpData(String code,int dayCount);
}
