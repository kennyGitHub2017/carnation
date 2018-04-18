package com.sinco.carnation.elong.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	public static <T> String entity2Json(T t){
		try {
			return JSON.toJSONStringWithDateFormat(t, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 
	  * jsonToObjectNew(json字符串转对象，字符和实体对象长度可以不一样)
	  * @Title: jsonToObjectNew
	  * @param @param jsonVal
	  * @param @param clazz
	  * @param @return
	  * @return Object
	  * @throws
	 */
	public static <T> T jsonToObject(String jsonVal,Class<T> clazz){
	
		try {
			return com.alibaba.fastjson.JSONObject.parseObject(jsonVal, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 
	  * jsonToListNew(字符串转换为集合)
	  * @Title: jsonToListNew
	  * @param @param jsonVal
	  * @param @param clazz
	  * @param @return
	  * @return List<T>
	  * @throws
	 */
	public static <T> List<T> jsonToList(String jsonVal,Class<T> clazz){
		
		try {
			return JSONObject.parseArray(jsonVal, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
