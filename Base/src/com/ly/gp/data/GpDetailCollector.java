package com.ly.gp.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ly.common.exception.BusException;
import com.ly.common.spring.SpringApplicationContextUtil;
import com.ly.common.util.DateUtils;
import com.ly.common.util.StringUtils;
import com.ly.gp.mybatis.model.info.GpData;
import com.ly.gp.mybatis.model.info.GpInfo;
import com.ly.gp.service.interfaces.IGpDetailDataSV;
import com.ly.gp.service.interfaces.IGpInfoDataSV;

/**
 * 股票日数据采集
 * 
 * @author ly
 * 
 */
public class GpDetailCollector {

	public static boolean isStart = false;// 是否启动

	public static int threadEndCount = 0;// 线程完成数据

	public static final int threadCount = 10;// 总启动的线程数，当threadEndCount=threadCount，isStart为true

	public static void coll() throws BusException {
		if(isStart){
			throw new BusException("任务正在启动中,请稍后再试!");
		}
		isStart = true;
		IGpInfoDataSV gpInfoDataSV = (IGpInfoDataSV)SpringApplicationContextUtil.getBean("gpInfoDataSV");
		
		List<GpInfo> allList = gpInfoDataSV.queryAllList();
		Map<Integer,List<GpInfo>> map = new HashMap<Integer,List<GpInfo>>();
		for (int i = 0; i < allList.size(); i++) {
			Integer key = i%10;
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<GpInfo>());
			}
			map.get(key).add(allList.get(i));
		}
		for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			DeatailThread deatailThread = new DeatailThread(map.get(key));
			deatailThread.start();//任务启动
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//实时计算任务是否结束
		new EndThread().start();
	}
	private static class EndThread extends Thread{

		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(threadCount==threadEndCount){
					isStart = false;
					return;
				}
			}
		}
		
	}

	private static class DeatailThread extends Thread {

		
		private List<GpInfo> gpList = new ArrayList<GpInfo>();
		

		public DeatailThread(List<GpInfo> gpList) {
			super();
			this.gpList = gpList;
		}


		@Override
		public void run() {
			try {
				IGpDetailDataSV gpDetailDataSV = (IGpDetailDataSV)SpringApplicationContextUtil.getBean("gpDetailDataSV");
				for (int i = 0; i <gpList.size(); i++) {
					GpInfo gpInfo = gpList.get(i);
					try {
						
						getGpDataList(gpInfo);
						gpDetailDataSV.js(gpInfo);
					} catch (Exception e) {
						e.printStackTrace();
						gpDetailDataSV.recordError(gpInfo.getCode(), e.getMessage());
					}
					
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				threadEnd();
			}

		}

	}

	public static synchronized void threadEnd() {
		threadEndCount++;
	}
	public static List<GpData> getGpDataList(GpInfo gpInfo) throws Exception{
		List<GpData> list = new ArrayList<GpData>();
		IGpDetailDataSV gpDetailDataSV = (IGpDetailDataSV)SpringApplicationContextUtil.getBean("gpDetailDataSV");
		//获取需要采集的时间间断
		Date date = new Date();
		int season = DateUtils.getSeason(date);
		
		String endJd = DateUtils.formatDate(date, "yyyy")+season;
		String startJd = DateUtils.getLastYearJd(String.valueOf((Integer.valueOf(DateUtils.formatDate(date, "yyyy"))-1))+season);
		
		String collDates = gpInfo.getCollDates();
		if(StringUtils.isNotBlank(collDates)){
			String[] array = collDates.split(",");
			startJd = array[array.length-1];//最后一次采集的数据
			
			
		}
		if(!startJd.equals(endJd)){
			startJd = DateUtils.getNextYearJd(startJd);//排除第一个
		}
		
		
		System.out.println(DateUtils.formatDate(new Date(), "yyyyMMdd HH:mm:ss")
				+"采集数据:"+gpInfo.getName()+"("+gpInfo.getCode()+"),时间:"+startJd+"-"+endJd);
		
		List<String> jdList = DateUtils.getDiffYearJd(startJd, endJd);
		for (int i = 0; i < jdList.size(); i++) {
			String jd = jdList.get(i);//一个季度一个事务，然后一个季度的事务失败，则这个股票的采集一起失败
			gpDetailDataSV.collGpDetailJd(gpInfo,jd);
		}
		
		return list;
	}
	public static void main(String[] args) {
		Date date = new Date();
		int season = DateUtils.getSeason(date);
		
		String endJd = DateUtils.formatDate(date, "yyyy")+season;
		String startJd = DateUtils.getLastYearJd(String.valueOf((Integer.valueOf(DateUtils.formatDate(date, "yyyy"))-1))+season);
		
		String collDates = "20161,20162";
		if(StringUtils.isNotBlank(collDates)){
			String[] array = collDates.split(",");
			startJd = array[array.length-1];//最后一次采集的数据
			
			startJd = DateUtils.getNextYearJd(startJd);//排除第一个
			
		}
//		System.out.println(startJd);
//		if(!startJd.equals(endJd)){
//			startJd = DateUtils.getNextYearJd(startJd);//排除第一个
//		}
		
		System.out.println(DateUtils.formatDate(new Date(), "yyyyMMdd HH:mm:ss")
				+"采集数据:"+"),时间:"+startJd+"-"+endJd);
	}
	
}
