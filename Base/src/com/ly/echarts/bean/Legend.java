package com.ly.echarts.bean;

public class Legend {

	private LegendData[] data;


	public Legend() {
		
	}
	
	public Legend(LegendData[] data) {
		super();
		this.data = data;
	}

	public LegendData[] getData() {
		return data;
	}

	public void setData(LegendData[] data) {
		this.data = data;
	}

	
	
	
}
