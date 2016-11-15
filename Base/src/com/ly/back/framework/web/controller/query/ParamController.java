package com.ly.back.framework.web.controller.query;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.back.framework.mybatis.model.sys.SysQueryFormType;
import com.ly.back.framework.mybatis.model.sys.SysQueryParamQueryType;
import com.ly.back.framework.searchmodel.query.SysQueryParamSearchModel;
import com.ly.back.framework.services.query.interfaces.ISysQueryFormTypeSV;
import com.ly.back.framework.services.query.interfaces.ISysQueryParamQueryTypeSV;
import com.ly.back.framework.services.query.interfaces.ISysQueryParamSV;
import com.ly.common.util.AjaxResultUtil;
/**
 * 查询参数
 * @author ly
 *
 */
@Controller
@RequestMapping("/back/query/param")
public class ParamController {
	@Autowired
	private ISysQueryParamSV sysQueryParamSV;
	@Autowired
	private ISysQueryFormTypeSV sysQueryFormTypeSV;
	@Autowired
	private ISysQueryParamQueryTypeSV sysQueryParamQueryTypeSV;
	
	@RequestMapping("/param.html")
	public String param(String queryId, Model model) throws Exception {
		return "/content/back/framework/query/param";
	}
	@RequestMapping("/paramInput.html")
	public String paramInput(String queryId, Model model) throws Exception {
		return "/content/back/framework/query/param-input";
	}
	
	@RequestMapping("getParams.ajax")
	@ResponseBody
	public Map<String, Object> getParams(String queryId) {
		try {
			List<SysQueryParamSearchModel> data = sysQueryParamSV.getParams(queryId);
			return AjaxResultUtil.getJsonMap(data);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
	@RequestMapping("getQueryTypes.ajax")
	@ResponseBody
	public Map<String, Object> getQueryTypes() {
		try {
			List<SysQueryParamQueryType> data = sysQueryParamQueryTypeSV.getQueryTypes();
			return AjaxResultUtil.getJsonMap(data);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
	@RequestMapping("getFormTypes.ajax")
	@ResponseBody
	public Map<String, Object> getFormTypes() {
		try {
			List<SysQueryFormType> data = sysQueryFormTypeSV.getFormTypes();
			return AjaxResultUtil.getJsonMap(data);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
	
}
