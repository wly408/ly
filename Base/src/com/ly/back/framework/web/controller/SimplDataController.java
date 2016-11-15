package com.ly.back.framework.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.back.framework.services.index.interfaces.ISimplDataSV;
import com.ly.back.framework.simpldata.SimplData;
import com.ly.back.framework.simpldata.SimplDataEnum;
import com.ly.common.util.AjaxResultUtil;

@Controller
@RequestMapping("/back/simplData")
public class SimplDataController {

	@Autowired
	private ISimplDataSV simplDataSV;// 服务接口

	/**
	 * 获取菜单
	 */
	@RequestMapping("getSimplData.ajax")
	@ResponseBody
	public Map<String, Object> getSimplData(String type) {
	
		try {
			List<SimplData> list = simplDataSV.getSimplDataListBySql(SimplDataEnum.getSql(type));
			return AjaxResultUtil.getJsonMap(list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
}
