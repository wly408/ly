package com.ly.common.util.json;

import net.sf.json.JsonConfig;

public class MyObjectJsonValueProcessor implements net.sf.json.processors.JsonValueProcessor{

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return " ";
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		System.out.println(" .fdajfldjs");
		return " ";
	}

}
