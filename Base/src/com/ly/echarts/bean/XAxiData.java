package com.ly.echarts.bean;

public class XAxiData {

	private String key;//x轴字段值
	private String value;//echarts的中文名
	private String xAxisColumnName;//字段名
	
	
	
	public String getxAxisColumnName() {
		return xAxisColumnName;
	}
	public void setxAxisColumnName(String xAxisColumnName) {
		this.xAxisColumnName = xAxisColumnName;
	}
	public XAxiData() {
		
	}
	public XAxiData(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
