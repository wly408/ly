package com.ly.gp.echarts;

import java.util.List;

import com.ly.common.spring.SpringApplicationContextUtil;
import com.ly.echarts.bean.Legend;
import com.ly.echarts.bean.LegendData;
import com.ly.echarts.bean.Option;
import com.ly.echarts.bean.Serie;
import com.ly.echarts.bean.SerieData;
import com.ly.echarts.bean.Title;
import com.ly.echarts.bean.XAxi;
import com.ly.echarts.bean.XAxiData;
import com.ly.gp.mybatis.model.info.GpData;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.service.interfaces.IGpDetailDataSV;
import com.ly.gp.service.interfaces.IGpInfoDataSV;

public class EchartsKUtil {

	public static Option getOption(String code,int dayCount) throws Exception{
		Option option = new Option();
		
		//获取数据
		IGpInfoDataSV gpInfoDataSV = (IGpInfoDataSV)SpringApplicationContextUtil.getBean("gpInfoDataSV");
		IGpDetailDataSV gpDetailDataSV = (IGpDetailDataSV)SpringApplicationContextUtil.getBean("gpDetailDataSV");
		GpInfo gpInfo = gpInfoDataSV.getGpInfByCode(code);
		List<GpData> dataList = gpDetailDataSV.getKLineGpData(code, 25);
		Title title = new Title();
		title.setText(gpInfo.getName()+"["+code+"]");
		option.setTitle(title);
		Legend legend = new Legend();
		LegendData[] legendData = new LegendData[6];
		
		//data: ['日K', 'MA5', 'MA10', 'MA20', 'MA30','MA60']
		legendData[0] = new LegendData("", "日K");
		legendData[1] = new LegendData("", "MA5");
		legendData[2] = new LegendData("", "MA10");
		legendData[3] = new LegendData("", "MA20");
		legendData[4] = new LegendData("", "MA30");
		legendData[5] = new LegendData("", "MA60");
	
		legend.setData(legendData);
		option.setLegend(legend);
		
		//x轴数据,是日期
		XAxi[] xAxis = new XAxi[1];
		xAxis[0] = new XAxi();
		XAxiData[] axiData = new XAxiData[dataList.size()];
		
		for (int i = 0; i < axiData.length; i++) {
			axiData[i] = new XAxiData();
			axiData[i].setValue(dataList.get(i).getMarketDate());
		}
		xAxis[0].setData(axiData);
		option.setxAxis(xAxis);
		
		Serie[] series = new Serie[legendData.length];
		
		for (int i = 0; i < series.length; i++) {
			series[i] = new Serie();
			series[i].setName(legendData[i].getName());
			//日K: 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)
			if(i==0){
				SerieData[] serieDatas = new SerieData[dataList.size()];
				for (int j = 0; j < serieDatas.length; j++) {
					GpData gpData = dataList.get(j);
					serieDatas[j] = new SerieData();
					String[] values = new String[4];
					values[0]= gpData.getOpenPrice().toString();
					values[1]= gpData.getFinalPrice().toString();
					values[2]= gpData.getLowPrice().toString();
					values[3]= gpData.getHightPrice().toString();
					
					serieDatas[j].setValue(values);
				}
				series[i].setData(serieDatas);
			}else{
				SerieData[] serieDatas = new SerieData[dataList.size()];
				int ma = Integer.valueOf(legendData[i].getName().substring(2));
				
					for (int j = 0; j < serieDatas.length; j++) {
						GpData gpData = dataList.get(j);
						serieDatas[j] = new SerieData();
						String[] values = new String[1];
						if(ma==5){
							values[0]= gpData.getVar5()==null?"":gpData.getVar5().toString();
						}else if(ma==10){
							values[0]= gpData.getVar10()==null?"":gpData.getVar10().toString();
						}else if(ma==20){
							values[0]= gpData.getVar20()==null?"":gpData.getVar20().toString();
						}else if(ma==30){
							values[0]= gpData.getVar30()==null?"":gpData.getVar30().toString();
						}else if(ma==60){
							values[0]= gpData.getVar60()==null?"":gpData.getVar60().toString();
						}
						
						serieDatas[j].setValue(values);
					}
					series[i].setData(serieDatas);
				
				
			}
			
			
		}
		option.setSeries(series);
		
		
		return option;
	}
}
