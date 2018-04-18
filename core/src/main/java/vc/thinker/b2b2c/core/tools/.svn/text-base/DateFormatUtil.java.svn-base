package vc.thinker.b2b2c.core.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	public static String formatDisplayTime(String time, String pattern) {
		String display = "";
		int tMin = 60 * 1000;
		int tHour = 60 * tMin;
		int tDay = 24 * tHour;

		if (time != null) {
			try {
				Date tDate = new SimpleDateFormat(pattern).parse(time);

				Date today = new Date();
				SimpleDateFormat thisYearDf = new SimpleDateFormat("yyyy");
				SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd");
				Date thisYear = new Date(thisYearDf.parse(thisYearDf.format(today)).getTime());
				Date yesterday = new Date(todayDf.parse(todayDf.format(today)).getTime());
				Date beforeYes = new Date(yesterday.getTime() - tDay);
				if (tDate != null) {
					SimpleDateFormat halfDf = new SimpleDateFormat("MM月dd日");
					long dTime = today.getTime() - tDate.getTime();
					if (tDate.before(thisYear)) {
						display = new SimpleDateFormat("yyyy年MM月dd日").format(tDate);
					} else {
						if (dTime < tMin) {
							display = "刚刚";
						} else if (dTime < tHour) {
							display = (int) Math.ceil(dTime / tMin) + "分钟前";
						} else if (dTime < tDay && tDate.after(yesterday)) {
							display = (int) Math.ceil(dTime / tHour) + "小时前";
						} else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
							display = "昨天" + new SimpleDateFormat("HH:mm").format(tDate);
						} else {
							display = halfDf.format(tDate);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return display;
	}

	public static String formatDate(String dateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(CommUtil.formatDate(dateTime));
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		StringBuffer date = new StringBuffer();
		date.append(year).append(".").append(month > 9 ? month : "0" + month).append(".").append(day > 9 ? day : "0" + day);
		return date.toString();
	}

	public static String formatTime(String dateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(CommUtil.formatDate(dateTime, "yyyy-MM-dd HH:mm:ss"));
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		StringBuffer time = new StringBuffer();
		time.append(hour > 9 ? hour : "0" + hour).append(":").append(minute > 9 ? minute : "0" + minute);
		return time.toString();
	}
}
