package com.ly.back.framework.web.controller.query;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.back.framework.mybatis.model.sys.SysQuery;
import com.ly.back.framework.mybatis.model.sys.SysQueryField;
import com.ly.back.framework.mybatis.model.sys.SysQueryJs;
import com.ly.back.framework.searchmodel.query.FieldBean;
import com.ly.back.framework.services.query.interfaces.ISysQueryFieldSV;
import com.ly.back.framework.services.query.interfaces.ISysQueryJsSV;
import com.ly.back.framework.services.query.interfaces.ISysQueryParamSV;
import com.ly.back.framework.services.query.interfaces.ISysQuerySV;
import com.ly.common.exception.BusException;
import com.ly.common.util.AjaxResultUtil;
import com.ly.common.util.StringUtils;

/**
 * 自定义查询
 * @author ly
 *
 */
@Controller
@RequestMapping("/back/query")
public class QueryController {
	@Autowired
	private ISysQueryParamSV sysQueryParamSV;
	@Autowired
	private ISysQuerySV sysQuerySV;
	@Autowired
	private ISysQueryFieldSV sysQueryFieldSV;
	@Autowired
	private ISysQueryJsSV sysQueryJsSV;
	/**
	 * 进入自定义查询列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.html")
	public String list(String queryId, Model model) throws Exception {
		model.addAttribute("queryId", queryId);
		model.addAttribute("queryId", queryId);
		//外部引用的JS
		List<SysQueryJs> jsList = sysQueryJsSV.getSysQueryJsList(queryId);
		
		model.addAttribute("jsList", jsList);
		return "/content/back/framework/query/list";
	}
	@RequestMapping("/js.html")
	public String js(String queryId, Model model) throws Exception {
		if(StringUtils.isNotBlank(queryId)){
			model.addAttribute("queryId", queryId);
			//外部引用的JS
			List<SysQueryJs> jsList = sysQueryJsSV.getSysQueryJsList(queryId);
			
			model.addAttribute("jsList", jsList);
		}
		return "/content/back/framework/query/js";
	}
	@RequestMapping("/input.html")
	public String input(String queryId, Model model) throws Exception {
		
		
		return "/content/back/framework/query/input";
	}
	@RequestMapping("/info.html")
	public String info(String queryId, Model model) throws Exception {
		
		
		return "/content/back/framework/query/info";
	}
	@RequestMapping("/field.html")
	public String field(String queryId, Model model) throws Exception {
		
		
		return "/content/back/framework/query/field";
	}
	@RequestMapping("/param.html")
	public String param(String queryId, Model model) throws Exception {
		
		
		return "/content/back/framework/query/param";
	}
	@RequestMapping("/queryList.ajax")
	@ResponseBody
	public String queryList(String queryId, String queryJson,Integer page,Integer rows) throws Exception{
		String rs = sysQuerySV.queryList(queryId,queryJson,page,rows);
		return rs;
	}
//	@RequestMapping("getParams.ajax")
//	@ResponseBody
//	public Map<String, Object> getParams(String queryId) {
//		try {
//			List<SysQueryParam> list = sysQueryParamSV.getParams(queryId);
//			return AjaxResultUtil.getJsonMap(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return AjaxResultUtil.getJsonMap(e);
//		}
//		
//	}
	@RequestMapping(value="doSql.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doSql(@RequestBody SysQuery sysQuery) {
		try {
			
			List<FieldBean> list = sysQueryParamSV.doSql(sysQuery.getSql());
			return AjaxResultUtil.getJsonMap(list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(new BusException(e.getMessage()));
		}
		
	}
	
	@RequestMapping("getFields.ajax")
	@ResponseBody
	public Map<String, Object> getFields(String queryId) {
		try {
			List<SysQueryField> list = sysQueryFieldSV.getFields(queryId);
			return AjaxResultUtil.getJsonMap(list);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
	@RequestMapping("getQueryInfo.ajax")
	@ResponseBody
	public Map<String, Object> getQueryInfo(String queryId) {
		try {
			SysQuery query = sysQuerySV.getQueryInfo(queryId);
			return AjaxResultUtil.getJsonMap(query);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
		
	}
}
