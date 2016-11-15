package com.ly.echarts.bean;


public class Serie {
	
	private String name;
	private String type;
	private SerieData[] data ;//数据
	private String key;//Y字段名
	
	public Serie() {
		
	}
	
	public Serie(String name, String type, SerieData[] data, String key) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SerieData[] getData() {
		return data;
	}
	public void setData(SerieData[] data) {
		this.data = data;
	}


	
}
