package com.ly.common.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {
	private static Timer timer = null;
	
	/**
	 * �����������ȶ���
	 * @param task
	 * @param period
	 * @throws Exception
	 */
	public static void scheduleNow(TimerTask task , long period) throws Exception{
		if(task == null){
			return;
		}
		
		if(timer == null){
			timer = new Timer();
		}
		timer.schedule(task, new Date() ,period);
	}
	
	/**
	 * ȡ������
	 * @param task
	 * @throws Exception
	 */
	public static void cancelTask(TimerTask task )throws Exception{
		if(timer == null || task == null){
			return;
		}
		
		//ȡ������
		task.cancel();
		timer.purge();
	}
}
