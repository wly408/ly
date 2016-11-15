package com.ly.gp.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ly.common.exception.BusException;
import com.ly.common.spring.SpringApplicationContextUtil;
import com.ly.common.util.StringUtils;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.service.interfaces.IGpInfoDataSV;

/**
 * 股票基本信息采集
 * @author ly
 *
 */
public class GpInfoCollector  {
	
	public static void coll() throws BusException{
		try {
			List<GpInfo> list = getGpInfoFromText();
			//将数据更新到数据库中
			IGpInfoDataSV gpInfoDataSV = (IGpInfoDataSV)SpringApplicationContextUtil.getBean("gpInfoDataSV");
			gpInfoDataSV.initGpInfo(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusException(e.getMessage());
		}
		
		
	}
	
	private static final List<GpInfo> getGpInfoFromText() throws Exception{
		List<GpInfo> gpInfoList = new ArrayList<GpInfo>();
		File file = new File("D:\\yanxin\\Base\\src\\com\\ly\\gp\\data\\gpinfo.txt");
		BufferedReader fileReader = null;
		try {
			//<li><a href="http://www.bestopview.com/superView.php?stockcode=600000" target="_blank">浦发银行(600000)</a></li>
			//<li><a target="_blank" href="http://quote.eastmoney.com/sh166105.html">信达增利(166105)</a></li>
			fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String row = null;
			while ((row = fileReader.readLine()) != null) {
				if(StringUtils.isBlank(row)){
					continue;
				}
				GpInfo gpInfo = new GpInfo();
				int liIndex = row.indexOf("<li>");
				if(liIndex<0){
					continue;
				}
				int liEndIndex = row.indexOf("\">");
				if(liEndIndex<0){
					continue;
				}
				row = row.substring(liEndIndex+"\">".length());
				
				int aEndIndex = row.indexOf("</a>");
				if(aEndIndex<0){
					continue;
				}
				row = row.substring(0, aEndIndex);//神宇股份(300563)
//				System.out.println(row);

//				
				String name = row.substring(0,row.indexOf("("));
//				
				String code = row.substring(row.indexOf("(")+1,row.length()-1);
				
				gpInfo.setCode(code);
				gpInfo.setName(name);
				if(code.startsWith("0")||code.startsWith("6")){
					gpInfoList.add(gpInfo);
				}
				
			}
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		return gpInfoList;
	}
	public static void main(String[] args) throws Exception {
		getGpInfoFromText();
	}
	

}
