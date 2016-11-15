package com.ly.gp.data;

import com.ly.common.exception.BusException;

/**
 * 股票基本信息采集
 * @author ly
 *
 */
public class GpInfoTranCollector  {
	public static boolean isStart = false;
	
	public static void coll() throws BusException{
		if(GpInfoTranCollector.isStart){
			throw new BusException("任务已经启动,不可重新启动！");
		}
		
		GpInfoDataThread dataThread = new GpInfoDataThread();
		dataThread.start();
		
		
	}
	private static class GpInfoDataThread extends Thread{

		@Override
		public void run() {
			GpInfoTranCollector.isStart = true;
			try{
				//开始采集
				//1.写入信息--一个事务
				//2.获取需要采集的数据
				//3.根据每个数据一个任务进行数据采集--一个事务
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				GpInfoTranCollector.isStart = false;
			}
		}	
	}
	

}
