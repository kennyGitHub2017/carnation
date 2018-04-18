/**   
 * @(#)DateUtil.java	2016年11月24日	上午11:33:32	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月24日 上午11:33:32   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class DateUtil {
	
	/**
	 * 
	 * 获取日期的前、后多少天的日期
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}
	
	
	/**
	 * 
	 * 获取日期的前后多少小时
	 *
	 * @param date
	 * @param minuts
	 * @return
	 */
	public static Date addOrMinusHours(java.util.Date date, int hours) {
		Date rtn = null;
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			cal.add(Calendar.HOUR, hours);
			rtn = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}
	
	/**
	 * 
	 * 获取日期的前后多少分钟
	 *
	 * @param date
	 * @param minuts
	 * @return
	 */
	public static Date addOrMinusMin(java.util.Date date, int minuts) {
		Date rtn = null;
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, minuts);
			rtn = cal.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtn;
	}
	
	/**
	 * 获取当前时间的格式字符串 yyyyMMddHHmmss
	 */
	public static String getCurrentDateStr(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

	/**
	 * 
	 * getCurrentLongDateStr(获取时间缀转为指定时间格式) TODO 获取时间缀转为指定时间格式
	 * 
	 * @Title: getCurrentLongDateStr
	 * @Description: 获取时间缀转为指定时间格式
	 * @param @param format
	 * @param @param time
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getCurrentLongDateStr(String format, Long time) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date(time));
	}

	/**
	 * 根据参数返回传入时间的字符串
	 * 
	 * @param format
	 *            yyyyMMddHHmmss
	 * @param date
	 * @return
	 */
	public static String getDateStrByParam(String format, Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * 将传入的时间字符串转换成long类型
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Long getDateParseStr(String dateStr, String format)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateStr).getTime();
	}

	/**
	 * 获取当前时间的long类型
	 * 
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Long getCurrParseStr(String format) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateFormat.format(new Date())).getTime();
	}

	/**
	 * 获取当前月最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("dd").format(cal.getTime());
	}

	/**
	 * 获取当前月最后一天(yyy-mm-dd)
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonthNew(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		return new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
	}

	/**
	 * 将传入的 yyyy-MM-dd 时间字符串转换成date
	 *
	 * @return
	 */
	public static Date getDateFormat(String str) {
		if (null == str || "" == str) {
			return new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}//

		return date;
	}

	/**
	 * 
	 * 将时间格式为:103059转化为:10:30:59 格式，仅用于活动展示时间中的时间处理 TODO(这里描述这个方法适用条件 – 可选)
	 * 
	 * @Title: ConvertIntegerTime
	 * @Description: TODO
	 * @param @param v
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String ConvertIntegerTime(Integer v) {
		String strV = v.toString();
		if (strV.length() < 6) {
			strV = "000000" + strV;
			strV = strV.substring(strV.length() - 6, strV.length());
		}
		return strV.substring(0, 2) + ":" + strV.substring(2, 4) + ":"
				+ strV.substring(4, 6);
	}

	/**
	 * 时间戳转化为Date Add by gaonaifeng 2016/4/8
	 * 
	 * @param v
	 * @return
	 */
	public static Date convertLongToDate(long v) {
		return new java.util.Date(v * 1000);
	}

	/**
	 * 时间戳转化为字符串 Add by gaonaifeng 2016/4/8
	 * 
	 * @param v
	 * @return
	 */
	public static String convertLongToString(long v) {
		Date d = convertLongToDate(v);
		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:s").format(d);
	}

	/**
	 * 时间戳转化为指定格式的字符串 Add by gaonaifeng 2016/4/8
	 * 
	 * @param v
	 * @param formart
	 * @return
	 */
	public static String convertLongToString(long v, String formart) {
		Date d = convertLongToDate(v);
		return new java.text.SimpleDateFormat(formart).format(d);
	}

	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 将传入的 yyyy-MM-dd 时间字符串转换成date
	 *
	 * @return
	 */
	public static Date getDateTimeFormat(String str) {
		if (null == str || "" == str) {
			return new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static Date getDateTimeFormat(String str, String format) {
		if (null == str || "" == str) {
			return new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 规范化日期，规范成yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String Date2DateString(Date date) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 
	 * Compare(这里用一句话描述这个方法的作用) TODO(这里描述这个方法适用条件 – 可选)
	 * 
	 * @Title: Compare
	 * @Description: TODO
	 * @param @param 小的日期
	 * @param @param 大的日期
	 * @param @return
	 * @return Boolean
	 * @throws
	 */
	public static Boolean Compare(Date small, Date large) {
		try {
			if (small.getTime() < large.getTime()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * Compare(这里用一句话描述这个方法的作用) TODO(这里描述这个方法适用条件 – 可选)
	 * 
	 * @Title: Compare
	 * @Description: TODO
	 * @param @param 小的日期
	 * @param @param 大的日期
	 * @param @return
	 * @return Boolean
	 * @throws
	 */
	public static Boolean Compare(String small, String large) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Date dt1 = df.parse(small);
			Date dt2 = df.parse(large);
			if (dt1.getTime() < dt2.getTime()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * 计算两个日期的差额天数
	 *
	 * @return
	 */
	public static long getDifferenceBetweenDay(Date largerDate, Date smallDate){
		return (largerDate.getTime()-smallDate.getTime())/(1000*60*60*24);
	}
	
	/**
	 * 
	 * 计算两个日期的差额分钟数
	 *
	 * @return
	 */
	public static Integer getDifferenceBetweenMinutes(Date largerDate, Date smallDate){
		return (int)(largerDate.getTime()-smallDate.getTime())/(1000*60);
	}
}
