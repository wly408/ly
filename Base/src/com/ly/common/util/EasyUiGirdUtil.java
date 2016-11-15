package com.ly.common.util;

import java.util.List;

import net.sf.json.JSONObject;

public class EasyUiGirdUtil {
	
	public static final String dataToGirdJson(int total,int page,List<?> datas){
		EasyUiGirdResult result = new EasyUiGirdResult();
		result.setTotal(total);
		result.setPage(page);
		result.setRows(datas);
		JSONObject object = JSONObject.fromObject(result);
		return object.toString();
	}
	public static final String getPageSql(String sql,int currentPage, int pageSize){

		currentPage = currentPage==0?1:currentPage;
		int heiRownum = currentPage* pageSize;
		int lowRownum = heiRownum- pageSize+ 1;
		StringBuffer strExeSql = new StringBuffer();
		strExeSql.append("SELECT * FROM (SELECT A.*, rownum rn FROM  (");
		strExeSql.append(sql + ") A ");
//		if(paramMap!=null){
//			strExeSql.append(" WHERE rownum<=:heiRownum )  ");
//			strExeSql.append(" WHERE rn>=:lowRownum");
//			paramMap.put("heiRownum", String.valueOf(heiRownum));
//			paramMap.put("lowRownum", String.valueOf(lowRownum));
//		}else{
			strExeSql.append("WHERE rownum <=" + heiRownum + ")  ");
			strExeSql.append(" WHERE rn >=" + lowRownum);
//		}
		return strExeSql.toString();
	}
	

}
