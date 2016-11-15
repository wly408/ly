package com.ly.gp.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.common.util.AjaxResultUtil;
import com.ly.common.util.StringUtils;
import com.ly.echarts.bean.Option;
import com.ly.gp.data.GpDetailCollector;
import com.ly.gp.data.GpInfoCollector;
import com.ly.gp.data.GpInfoTranCollector;
import com.ly.gp.echarts.EchartsKUtil;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.searchModel.GpInfoSearchModel;
import com.ly.gp.service.interfaces.IGpInfoDataSV;

@Controller
@RequestMapping("/gp/info")
public class GpInfoController {
	@Autowired
	private IGpInfoDataSV gpInfoDataSV;
	

	/**
	 * 进入首页
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/gplist.html")
	public String home() throws Exception {
		
		return "/content/gp/gplist";
	}
	/**
	 * 采集数据
	 */
	@RequestMapping("colldata.ajax")
	@ResponseBody
	public Map<String, Object> collData(){
		try {
			GpInfoTranCollector.coll();
			return AjaxResultUtil.getJsonMap();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
	}
	@RequestMapping("/queryList.ajax")
	@ResponseBody
	public String queryList(GpInfoSearchModel infoSearchModel){
		if(infoSearchModel==null){
			infoSearchModel = new GpInfoSearchModel();
		}
		
		String rs =  gpInfoDataSV.queryList(infoSearchModel);
		return rs;
	}
	/**
	 * 采集数据
	 */
	@RequestMapping("collInfoData.ajax")
	@ResponseBody
	public Map<String, Object> collInfoData(){
		try {
			GpInfoCollector.coll();
			return AjaxResultUtil.getJsonMap();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
	}
	/**
	 * 采集交易数据
	 */
	@RequestMapping("collTranData.ajax")
	@ResponseBody
	public Map<String, Object> collTranData(){
		try {
			GpInfoCollector.coll();
			return AjaxResultUtil.getJsonMap();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
	}
	/**
	 * 采集每日明细数据
	 */
	@RequestMapping("collDetailData.ajax")
	@ResponseBody
	public Map<String, Object> collDetailData(){
		try {
			GpDetailCollector.coll();
			return AjaxResultUtil.getJsonMap();
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
	}
	@RequestMapping("getKLineData.ajax")
	@ResponseBody
	public Map<String, Object> getKLineData(String codes){
		try {
			List<Option> optionList = new ArrayList<Option>();
			if(!StringUtils.isBlank(codes)){
				String[] array = codes.split(",");
				
				for (int i = 0; i < array.length; i++) {
					Option option = EchartsKUtil.getOption(array[i], 90);
					optionList.add(option);
				}
			}else{
				List<GpInfo> list = gpInfoDataSV.queryAllList();
				for (GpInfo gpInfo : list) {
					Option option = EchartsKUtil.getOption(gpInfo.getCode(), 90);
					optionList.add(option);
				}
			}
			
			
			return AjaxResultUtil.getJsonMap(optionList);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResultUtil.getJsonMap(e);
		}
	}
	@RequestMapping("/kLine.html")
	public String kLineHtml(String codes, Model model) throws Exception {
		model.addAttribute("codes", codes);
		return "/content/gp/kLine";
	}
}
