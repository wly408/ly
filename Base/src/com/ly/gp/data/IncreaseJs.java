package com.ly.gp.data;

import java.util.List;

import com.ly.common.spring.SpringApplicationContextUtil;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.service.interfaces.IGpDetailDataSV;
import com.ly.gp.service.interfaces.IGpInfoDataSV;

public class IncreaseJs {
	
	public static final void allIncrease(){
		
		IGpDetailDataSV gpDetailDataSV = (IGpDetailDataSV)SpringApplicationContextUtil.getBean("gpDetailDataSV");
		IGpInfoDataSV gpInfoDataSV = (IGpInfoDataSV)SpringApplicationContextUtil.getBean("gpInfoDataSV");
		
		List<GpInfo> allList = gpInfoDataSV.queryAllList();
		
		
	}
	
}
