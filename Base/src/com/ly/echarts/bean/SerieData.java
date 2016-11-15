package com.ly.echarts.bean;

public class SerieData {

	private String[] value;//数据
	private String name;//x轴名称
	private String key;//x轴key
	
	
	public SerieData() {
		
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

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}
	
	
}
