package com.sinco.carnation.order.tools;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeTools {
	/** 距离现在的时间秒数  **/
	public static Long getTimeSeconds(Date date) {
		Date a = date;
		Date b = new Date();
		Long interval = (b.getTime() - a.getTime()) / 1000;
		return interval;
	}
	
	/** 秒转换成 天 时 分 秒
	 * @param input
	 * @return time.get("day")+"天"+time.get("hour")+"时"+time.get("minute")+"分"+time.get("second")+"秒"
	 */
	public static Map<String,Integer>  secondConvertTime(Long input){
		 Map<String,Integer> result = new HashMap<>();
		if(input == null){
			input = 0L;
		}
		 int day=(int)(input/(60*60*24));//换成天
		 int hour=(int)((input-(60*60*24*day))/3600);//总秒数-换算成天的秒数=剩余的秒数    剩余的秒数换算为小时
		 int minute=(int)((input-60*60*24*day-3600*hour)/60);//总秒数-换算成天的秒数-换算成小时的秒数=剩余的秒数    剩余的秒数换算为分
		 int second=(int)(input-60*60*24*day-3600*hour-60*minute);//总秒数-换算成天的秒数-换算成小时的秒数-换算为分的秒数=剩余的秒数   
		 result.put("day", day);
		 result.put("hour", hour);
		 result.put("minute", minute);
		 result.put("second", second);
		 return result;
	}
	
	/** 天 时 分 秒 转换成秒**/
	public static Long timeConvertSecond(int day , int hour , int minute , int second){
		Long result = (long)(60*60*24*day+3600*hour+60*minute+second);
		return result;
	}
}
