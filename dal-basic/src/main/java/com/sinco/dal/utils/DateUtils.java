/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sinco.dal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author ThinkGem
 * @version 2013-3-15
 */
public class DateUtils extends com.sinco.common.utils.DateUtils {

	public static String dateFormatAll = "yyyy年MM月dd日HH时mm分ss秒";
	public static String dateFormat = "yyyy年MM月dd日";
	public static String date_Format = "yyyyMMdd";
	public static String dateFormat2 = "yyyy-MM-dd";
	public static String dateFormat3 = "yyyy-MM-dd HH:mm:ss";

	public static String formatLongDate(Long date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormatAll);
		return sdf.format(new Date(date));
	}

	public static Date getTodayNextMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static Date getNextMonth(int count, Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, count);
//		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static Date getNextMonth2(int count, Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, count);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	public static Date getNextDay(int count, Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, count);
		return calendar.getTime();
	}

	public static void main(String[] args) throws ParseException {
//		Date nowDate = new Date();
//		nowDate = DateUtils.getYearMonthDay(nowDate);
		Date planTime = new Date();
		String planTimeStr = "2015-04-16";
		planTime = DateUtils.parseDateStrictly(planTimeStr, "yyyy-MM-dd");
		Date m1 = DateUtils.getNextDay2(3, planTime);
		System.out.println(m1);
//		Date m1 = DateUtils.getNextDay2(30, planTime);
//		Date m2 = DateUtils.getNextDay2(60, planTime);
//		Date m3 = DateUtils.getNextDay2(90, planTime);
//		if (nowDate.before(m1)){
//			System.out.println(6);
//		}else if (nowDate.before(m2)){
//			System.out.println(7);
//		}else if (nowDate.before(m3)){
//			System.out.println(8);
//		}else if (m3.before(nowDate)){
//			System.out.println(9);
//		}else{
//			System.out.println(9);
//		}
	}

	public static Date getNextDay2(int count, Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, count + 1);
		return calendar.getTime();
	}

	public static Date getDateBankRule(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

		if (dayOfMonth == 29 || dayOfMonth == 30 || dayOfMonth == 31) {
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 1);;
		}
		return calendar.getTime();
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		if (null == date) {
			return "";
		}
		String formatDate = null;
		try {
			if (pattern != null && pattern.length > 0) {
				formatDate = DateFormatUtils.format(date, pattern[0].toString());
			} else {
				formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
			}
		} catch (Exception ex) {

		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/***
	 * 获取时分秒为00:00:00的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getYearMonthDay(Date date) {
		String dateStr = formatDate(date, "yyyy-MM-dd");
		return parseDate(dateStr);
	}

	/***
	 * 获取两个时间的相差月
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDifMonth(Date start, Date end) {
		if (null == start || null == end) {
			return -1;
		}
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(start);
		c2.setTime(end);
		int n = 0;
		if (c1.after(c2)) {
			while (!c2.after(c1)) {
				n++;
				c2.add(Calendar.MONTH, 1);
			}
		} else {
			while (!c1.after(c2)) {
				n++;
				c1.add(Calendar.MONTH, 1);
			}
		}
		n--;
		if (n < 0) {
			n = 0;
		}
		return n;
	}

	public static int getOverdueLevel(Date start, Date end) {
		if (null == start || null == end) {
			return -1;
		}
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(start);
		c2.setTime(end);
		int n = 0;
		if (c1.after(c2)) {
			while (!c2.after(c1)) {
				n++;
				c2.add(Calendar.DATE, 30);
			}
		} else {
			while (!c1.after(c2)) {
				n++;
				c1.add(Calendar.DATE, 30);
			}
		}
		n--;
		if (n < 0) {
			n = 0;
		}
		return n;
	}

	/**
	 * 
	 * @Title: GetDateMargin
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param beginDate
	 * @param @param endDate
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @author Tang
	 * @date 2015年3月14日 下午12:08:19
	 * @throws
	 */
	public static long getDateMargin(Date beginDate, Date endDate) {
		long margin = 0;

		margin = endDate.getTime() - beginDate.getTime();

		margin = margin / (1000 * 60 * 60 * 24);

		return margin;
	}

	/*
	* 毫秒转化
	*/
	public static String formatTime(Long ms) {
		if (ms == null) {
			return "刚刚";
		}
		int ss = 1000;
		int mi = ss * 60;
		int hh = mi * 60;
		int dd = hh * 24;

		long day = ms / dd;
		long hour = (ms - day * dd) / hh;
		long minute = (ms - day * dd - hour * hh) / mi;
		long second = (ms - day * dd - hour * hh - minute * mi) / ss;
//		long milliSecond = ms - day * dd - hour * hh - minute * mi - second
//				* ss;

		StringBuffer dateStr = new StringBuffer();
		if (day > 0) {
			dateStr.append(day).append("天前");
		} else if (hour > 0) {
			dateStr.append(hour).append("小时前");
		} else if (minute > 0) {
			dateStr.append(minute).append("分钟前");
		} else if (second > 0) {
			dateStr.append(second).append("秒前");
		}
		if (StringUtils.isEmpty(dateStr)) {
			dateStr.append("刚刚");
		}
//		String strDay = day < 10 ? "0" + day : "" + day; // 天
//		String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
//		String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
//		String strSecond = second < 10 ? "0" + second : "" + second;// 秒
//		String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : ""
//				+ milliSecond;// 毫秒
//		strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : ""
//				+ strMilliSecond;

		return dateStr.toString();
	}

}
