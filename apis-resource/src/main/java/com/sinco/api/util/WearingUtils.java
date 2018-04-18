package com.sinco.api.util;

/**
 * 穿戴设备数据工具类
 * 
 * @author king
 * 
 */
public class WearingUtils {

	public static int[][] source = { {90, 50, 50, 20, 40}, {90, 60, 50, 22, 40}, {90, 70, 50, 25, 40},
			{90, 80, 50, 29, 40}, {90, 90, 50, 33, 40}, {90, 100, 50, 37, 45}, {90, 110, 50, 40, 49},
			{90, 120, 50, 44, 54}, {90, 130, 50, 48, 58}, {90, 140, 50, 51, 63}, {90, 150, 50, 55, 67},
			{90, 160, 50, 59, 72}, {90, 170, 50, 62, 76}, {90, 180, 50, 66, 81}, {90, 190, 50, 70, 85},
			{90, 200, 50, 74, 90}};

	// 形体
	public final static String[][] boy = { {"5001", "心脑血管系统、神经系统"}, {"5002", "运动系统"},
			{"5003", "呼吸系统、免疫系统、内分泌系统"}, {"5004", "消化系统"}, {"5005", "泌尿系统、生殖系统"}, {"5006", "运动系统"}};

	// 症状
	public final static String[][] boy1 = { {"5001", "心脑血管系统、神经系统"}, {"5002", "运动系统"},
			{"5003", "呼吸系统、免疫系统、内分泌系统"}, {"5004", "消化系统"}, {"5005", "泌尿系统、生殖系统"}, {"5006", "运动系统"}};

	/**
	 * 根据身高获取步长
	 * 
	 * @param height
	 * @return
	 */
	public static int stepLength(int height) {
		for (int i = 0; i < source.length; i++) {
			if (i == source.length - 1) {
				return source[source.length - 1][3];
			}
			if (height >= source[i][1] && height < source[i + 1][1]) {
				return source[i][3];
			}
		}
		return 0;
	}

}
