package com.ly.echarts.bean;


public class Option {
	private Title title;//标题
	private Legend legend;//y轴
	private XAxi[] xAxis;//x轴
	private Serie[] series;
	
	
	
	public SerieData[] getSerieDataByKey(String key){

		if(series!=null){
			for (int i = 0; i < series.length; i++) {
				if(key.equals(series[i].getKey())){
					return series[i].getData();
				}
			}
		}
		return null;
	}
	
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public XAxi[] getxAxis() {
		return xAxis;
	}
	public void setxAxis(XAxi[] xAxis) {
		this.xAxis = xAxis;
	}
	public Serie[] getSeries() {
		return series;
	}
	public void setSeries(Serie[] series) {
		this.series = series;
	}


	
	
}
