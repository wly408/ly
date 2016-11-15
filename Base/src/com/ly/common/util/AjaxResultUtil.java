package com.ly.common.util;

import java.util.HashMap;
import java.util.Map;

import com.ly.common.exception.BusException;
/**
 * 针对ajax请求的返回结果处理
 * @author ly
 *
 */
public final class AjaxResultUtil {
	
	private static final String RS_RS = "rs";
	
	private static final String RS_MSG = "msg";
	private static final String RS_DATA = "data";

	public final static Map<String,Object> getJsonMap(Object data){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(RS_RS, "1");
		map.put(RS_MSG, "操作成功");
		map.put(RS_DATA, data);
		return map;
	}
	public final static Map<String,Object> getJsonMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(RS_RS, "1");
		map.put(RS_MSG, "操作成功");
		return map;
	}
	public final static Map<String,Object> getJsonMap(String errorMsg){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(RS_RS, "0");
		map.put(RS_MSG, errorMsg);
		return map;
	}
	public final static Map<String,Object> getJsonMap(Exception e){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put(RS_RS, "0");
		if(e instanceof BusException){
			map.put(RS_MSG, e.getMessage());
		}else{
			map.put(RS_MSG, "系统异常");
		}
		
		return map;
	}
}
