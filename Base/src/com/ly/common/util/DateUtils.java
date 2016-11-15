package com.ly.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 时间工具自定义标签函数用
 * 
 * @author fangll
 * 
 */
public class DateUtils {

	private static Log logger = LogFactory.getLog(DateUtils.class);

	/**
	 * getTime
	 * 
	 * @return
	 */
	public static Date getTime() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * legal holiday such as lundar 0101-0107 solar 0501-0507,1001-1007
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	/*
	 * public static boolean isHoliday(Date date) throws Exception { String str
	 * = DateUtils.formatDate(date, "MMdd"); GregorianCalendar cal =
	 * DateUtils.dateConvCalendar(date); String lunarStr =
	 * LunarCalendar.solarToLundar( cal.get(Calendar.YEAR),
	 * cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE));
	 * logger.debug("\r\n\t " + cal.get(Calendar.YEAR) +
	 * (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.DATE));
	 * logger.debug(lunarStr); lunarStr = lunarStr.substring(0,4);
	 * ArrayList<String> chunjie = new ArrayList<String>(); ArrayList<String>
	 * list = new ArrayList<String>(); list.add("0101"); list.add("0102");
	 * list.add("0103"); //元旦1-3 for (int i = 1; i <= 7; i++) { list.add("050" +
	 * i); //五一 list.add("100" + i); //十一 chunjie.add("010" + i); //农历春节 } if
	 * (list.indexOf(str) != -1 || chunjie.indexOf(lunarStr) != -1) { return
	 * true; } else { return false; } }
	 */

	/**
	 * get day of week such as (1,2...7)
	 * 
	 * @param date
	 * @return
	 */
	public static int dayOfWeek(Date date) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int x = aCalendar.get(Calendar.DAY_OF_WEEK);
		switch (x) {
		case Calendar.MONDAY:
			x = 1;
			break;
		case Calendar.TUESDAY:
			x = 2;
			break;
		case Calendar.WEDNESDAY:
			x = 3;
			break;
		case Calendar.THURSDAY:
			x = 4;
			break;
		case Calendar.FRIDAY:
			x = 5;
			break;
		case Calendar.SATURDAY:
			x = 6;
			break;
		case Calendar.SUNDAY:
			x = 7;
			break;
		}
		return x;
	}

	/**
	 * get all date(Date) list between begin date and end date
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param dateFormat
	 * @return
	 * @throws Exception
	 */
	public static ArrayList getDateList(Object beginDate, Object endDate,
			String dateFormat) throws Exception {
		ArrayList list = new ArrayList();
		int count = DateUtils.getDiffDays(beginDate, endDate, dateFormat);
		Date date;
		if (count > 0) {
			date = DateUtils.objectConvDate(beginDate, dateFormat);
		} else {
			date = DateUtils.objectConvDate(endDate, dateFormat);
		}
		for (int i = 0; i < count + 1; i++) {
			list.add(date);
			logger.debug(DateUtils.formatDate(date, dateFormat));
			date = DateUtils.addDay(date, 1);
		}
		return list;
	}

	public static Date addMinute(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.MINUTE, num);
		return cal.getTime();
	}

	public static Date addHour(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.HOUR, num);
		return cal.getTime();
	}

	public static Date addDay(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.DATE, num);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.MONTH, num);
		return cal.getTime();
	}

	public static Date addYear(Date date, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.YEAR, num);
		return cal.getTime();
	}

	/**
	 * object conver to date
	 * 
	 * @param date
	 *            can be String,Date,GregorianCalendar
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static Date objectConvDate(Object date, String format) {
		Date dateA = new Date();
		if (date instanceof String) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				dateA = sdf.parse((String) date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (date instanceof Date) {
			dateA = (Date) date;
		} else if (date instanceof GregorianCalendar) {
			dateA = ((GregorianCalendar) date).getTime();
		} else {
			throw new java.lang.IllegalArgumentException("无效的参数");
		}
		return dateA;
	}

	/**
	 * java.util.Date Convert java.util.GregorianCalendar
	 * 
	 * @param date
	 *            java.util.Date
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar dateConvCalendar(Date date) {
		GregorianCalendar cal = new GregorianCalendar(date.getYear() + 1900,
				date.getMonth(), date.getDate(), date.getHours(),
				date.getMinutes(), date.getSeconds());
		return cal;
	}

	/**
	 * get today before or after day
	 * 
	 * @param count
	 *            >0 after day,<0 berfor day
	 * @return
	 */
	public static GregorianCalendar getCurAfterDayCal(int count) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.DATE, count);
		return cal;
	}

	/**
	 * format Calendar
	 * 
	 * @param cal
	 *            GregorianCalendar,Date
	 * @param dateFormat
	 *            日期格式:缺省为E yyyy年MM月dd日常用格式yyyyMMdd HH:mm:ss
	 * @return
	 * @throws Exception
	 */
	public static String formatDate(Object date, String dateFormat) {
		if (date == null)
			return "";
		GregorianCalendar cal = DateUtils.dateConvCalendar(DateUtils
				.objectConvDate(date, dateFormat));
		String str = dateFormat == null ? "E yyyy年MM月dd日" : dateFormat;
		SimpleDateFormat format = new SimpleDateFormat(str);
		String curdate = format.format(cal.getTime());
		return curdate;
	}

	/**
	 * get day between date1 and date2
	 * 
	 * @param beginDate
	 *            can be String,Date,GregorianCalendar type
	 * @param endDate
	 *            can be String,Date,GregorianCalendar type
	 * @param format
	 *            if String must be set date format
	 * @return
	 * @throws Exception
	 */
	public static int getDiffDays(Object beginDate, Object endDate,
			String format) throws Exception {
		Object[] objs = new Object[2];
		objs[0] = beginDate;
		objs[1] = endDate;
		Date[] tmpDate = new Date[2];
		for (int i = 0; i < objs.length; i++) {
			tmpDate[i] = DateUtils.objectConvDate(objs[i], format);
			logger.debug(tmpDate[i]);
		}
		long lBeginTime = tmpDate[0].getTime();
		long lEndTime = tmpDate[1].getTime();
		int iDay = (int) ((lEndTime - lBeginTime) / 86400000);
		return iDay;
	}

	/**
	 * 
	 * 功能描述：
	 * 
	 * @author 余根宁
	 *         <p>
	 *         创建日期 ：May 30, 2011 3:42:59 PM
	 *         </p>
	 * 
	 * @param dateStr
	 * @return
	 * 
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	public static Date parseDate(String dateStr) {
		Date date = null;
		if (StringUtils.isBlank(dateStr)) {
			return null;
		}
		String tmpStr = dateStr.replaceAll("-", "");
		tmpStr = tmpStr.replaceAll("/", "");
		tmpStr = tmpStr.replaceAll(" ", "");
		String format = "";
		if (StringUtils.isBlank(tmpStr)) {
			return null;
		}

		if (tmpStr.length() == 4) {
			format = "yyyy";
		} else if (tmpStr.length() == 6) {
			format = "yyyyMM";
		} else if (tmpStr.length() == 8) {
			format = "yyyyMMdd";
		} else if (tmpStr.length() == 14) {
			format = "yyyyMMddHHmmss";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		try {
			return formatter.parse(tmpStr);
		} catch (ParseException err) {
			err.printStackTrace();
			return null;
		}

	}

	/**
	 * 功能描述：根据日期字符串创建的Timestamp对象,使用的日期格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @author 吴宇振 2012-2-22
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @return Timestamp对象。
	 */
	public static Timestamp parseTimestamp(String dateStr) {
		return parseTimestamp(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能描述：根据指定的日期格式和日期字符串创建的Timestamp对象
	 * 
	 * @author 吴宇振 2012-2-22
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @pramm dateFormat 日期格式
	 * @return Timestamp对象。
	 */
	public static Timestamp parseTimestamp(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			Date date = sdf.parse(dateStr);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * 功能描述：根据指定的日期格式和日期字符串创建的Date对象
	 * 
	 * @author 吴宇振 2012-2-27
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param dateFormat
	 *            日期格式
	 * @return
	 */
	public static Date parseDate(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	public static Date lastMonthDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static int getCurrentMonthDay() {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static final int getSeason(Date date) {
		int season = 4;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int mon = calendar.get(Calendar.MONTH);

		switch (mon) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 2;
			break;

		default:
			break;
		}

		return season;
	}
	/**
	 * 获取上一个季度
	 * @param yearJd季度 如：20151
	 * @return
	 */
	public static final String getLastYearJd(String yearJd){
		int season = Integer.valueOf(yearJd.substring(4));
		if(1==season){
			return (Integer.valueOf(yearJd.substring(0,4))-1)+"4";
		}
		return yearJd.substring(0,4)+Integer.valueOf(season-1);
	}
	/**
	 * 获取下一个季度
	 * @param yearJd
	 * @return
	 */
	public static final String getNextYearJd(String yearJd){
		int season = Integer.valueOf(yearJd.substring(4));
		if(4==season){
			return (Integer.valueOf(yearJd.substring(0,4))+1)+"1";
		}
		return yearJd.substring(0,4)+Integer.valueOf(season+1);
	}
	/**
	 * 获取两个季度之前的季度，包括开始和结束
	 * @param startJd
	 * @param endJd
	 * @return
	 */
	public static final List<String> getDiffYearJd(String startJd,String endJd){
		List<String> list = new ArrayList<String>();
		if(startJd.equals(endJd)){
			list.add(startJd);
			return list;
		}
		//不相等
		String startYear = startJd.substring(0,4);
		String endYear = endJd.substring(0,4);
		String jdStart = startJd.substring(4);
		String jdEnd = endJd.substring(4);
		//年相等的时候
		if(startYear.equals(endYear)){
			for (int i = Integer.valueOf(jdStart); i <=Integer.valueOf(jdEnd); i++) {
				list.add(startYear+i);
			}
			return list;
		}
		//年不相等的时候：1.开始年份的采集
		for (int i =  Integer.valueOf(jdStart); i <=4; i++) {
			list.add(startYear+i);
		}
		//年不相等的时候：1.中间年份的采集
		for (int i = (Integer.valueOf(startYear)+1); i < Integer.valueOf(endYear); i++) {
			for (int j = 1; j <=4; j++) {
				list.add(String.valueOf(i)+j);
			}
		}
		//年不相等的时候：1.最后年份的采集
		for (int i =  1; i <=Integer.valueOf(jdEnd); i++) {
			list.add(endYear+i);
		}
		return list;
		
		
		
		
		
		
	}

	public static void main(String args[]) {
		System.out.println(DateUtils.formatDate(lastMonthDate(new Date()),
				"yyyyMMdd HH:mm:ss"));
	}
}
