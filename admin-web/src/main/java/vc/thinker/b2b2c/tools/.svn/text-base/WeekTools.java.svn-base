package vc.thinker.b2b2c.tools;

import org.springframework.stereotype.Component;

@Component
public class WeekTools {

	public String weekDay(String weekNumber) {
		String[] sourceStrArray = weekNumber.split(",");
		String week = "";
		for (int i = 0; i < sourceStrArray.length; i++, week += ",") {
			if (sourceStrArray[i].equals("1")) {
				week += "星期一";
			} else if (sourceStrArray[i].equals("2")) {
				week += "星期二";
			} else if (sourceStrArray[i].equals("3")) {
				week += "星期三";
			} else if (sourceStrArray[i].equals("4")) {
				week += "星期四";
			} else if (sourceStrArray[i].equals("5")) {
				week += "星期五";
			} else if (sourceStrArray[i].equals("6")) {
				week += "星期六";
			} else if (sourceStrArray[i].equals("0")) {
				week += "星期天";
			}
		}
		return week;
	}
}
