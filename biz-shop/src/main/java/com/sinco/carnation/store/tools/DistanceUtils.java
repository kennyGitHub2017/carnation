package com.sinco.carnation.store.tools;

public class DistanceUtils {
	private static final double EARTH_RADIUS = 6378137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/** */
	/**
	 * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	 * 
	 * @param lng1
	 * @param lat1
	 * @param lng2
	 * @param lat2
	 * @return
	 */
	public static double GetDistance(double lng1, double lat1, double lng2, double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1)
				* Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double lat = 22.5362;
		double lon = 114.075;

		double lat1 = 22.73036100;
		double lon1 = 114.25510600;
		// TODO 自动生成方法存根
		double distance = GetDistance(lat, lon, lat1, lon1);
		System.out.println("Distance is:" + distance);
	}
}
