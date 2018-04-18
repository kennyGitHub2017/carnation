package com.sinco.biz.utils;

import java.util.ArrayList;
import java.util.List;

import com.sinco.common.utils.HashidUtils;

public class MyStringUtils {

	public static List<Long> stringToLongListImgIds(String data, String splitStr) {
		List<Long> list = new ArrayList<Long>();
		String[] arry = data.split(splitStr);
		if (arry.length > 0) {
			for (String str : arry) {
				try {
					list.add(HashidUtils.decode(str));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return list;
	}

}
