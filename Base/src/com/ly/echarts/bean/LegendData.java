package com.ly.echarts.bean;

public class LegendData {
	String name;
	String key;//y的字段名
	
	public LegendData() {
		
	}
	
	public LegendData(String key,String name ) {
		super();
		this.name = name;
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
