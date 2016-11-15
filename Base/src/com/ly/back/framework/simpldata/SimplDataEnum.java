package com.ly.back.framework.simpldata;


public enum SimplDataEnum {
	
	
	SYS_QUERY_QUERY_TYPE("SYS_QUERY_QUERY_TYPE",
			"select ID AS VALUE,NAME AS NAME from sys_query_param_query_type","自定义查询-查询类型"),
	SYS_QUERY_FORM_TYPE("SYS_QUERY_FORM_TYPE",
			"select t.id as value,t.name as name ,t.remark as title from sys_query_form_type t","自定义查询-页面表单类型");
	
	
	
	private String type;
	private String name;
	private String sql;
	public static final String DIC_SELECT_START = "DIC_";//特殊处理，字典的以DIC_开头，后面为字典名
	
	
	
	public static String  getSql(String type){
		for (SimplDataEnum e : SimplDataEnum.values()){
			//字典
			if(type.startsWith(DIC_SELECT_START)){
				String key = type.split("_")[1];
				
				return "select * from sys_dic where dic='"+key+"'";
			}
			
			if(e.getType().equals(type)){
				return e.getSql();
			}
		}
		
		return "";
	}
	
	SimplDataEnum(String type,String sql,String name) {
		this.type = type;
		this.name = name;
		this.sql = sql;
	}



	protected String getSql() {
		return sql;
	}



	protected void setSql(String sql) {
		this.sql = sql;
	}



	protected String getType() {
		return type;
	}



	protected void setType(String type) {
		this.type = type;
	}



	protected String getName() {
		return name;
	}



	protected void setName(String name) {
		this.name = name;
	}
	

}
