package com.sinco.carnation.sys.tools;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param pojoCalss
	 * @return
	 */
	@SuppressWarnings({"unused", "unchecked", "rawtypes"})
	public static Object getObject4JsonString(String jsonString, Class pojoCalss) {
		Object pojo;
		JSONObject jsonObject = JSONObject.parseObject(jsonString);
		pojo = JSONObject.parseObject(jsonString, pojoCalss);
		return pojo;
	}

	/**
	 * 从json HASH表达式中获取一个map，改map支持嵌套功能
	 * 
	 * @param jsonString
	 * @return
	 */
	/*public static Map getMap4Json(String jsonString){
	    JSONObject jsonObject = JSONObject.parseObject( jsonString );
	    Iterator keyIter = jsonObject.keys();
	    String key;
	    Object value;
	    Map valueMap = new HashMap();
	    while( keyIter.hasNext())
	    {
	        key = (String)keyIter.next();
	        value = jsonObject.get(key);
	        valueMap.put(key, value);
	    }
	    return valueMap;
	}*/

	/**
	 * 从json数组中得到相应java数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Object[] getObjectArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		return jsonArray.toArray();
	}

	/**
	 * 从json对象集合表达式中得到一个java对象列表
	 * 
	 * @param jsonString
	 * @param pojoClass
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static List getList4Json(String jsonString, Class pojoClass) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		JSONObject jsonObject;
		Object pojoValue;
		List list = new ArrayList();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toJavaObject(jsonObject, pojoClass);
			list.add(pojoValue);
		}
		return list;
	}

	/**
	 * 从json数组中解析出java字符串数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static String[] getStringArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		String[] stringArray = new String[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			stringArray[i] = jsonArray.getString(i);
		}
		return stringArray;
	}

	/**
	 * 从json数组中解析出javaLong型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Long[] getLongArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		Long[] longArray = new Long[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			longArray[i] = jsonArray.getLong(i);
		}
		return longArray;
	}

	/**
	 * 从json数组中解析出java Integer型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Integer[] getIntegerArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		Integer[] integerArray = new Integer[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			integerArray[i] = jsonArray.getInteger(i);
		}
		return integerArray;
	}

	/**
	 * 从json数组中解析出java Integer型对象数组
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Double[] getDoubleArray4Json(String jsonString) {
		JSONArray jsonArray = JSONArray.parseArray(jsonString);
		Double[] doubleArray = new Double[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			doubleArray[i] = jsonArray.getDouble(i);
		}
		return doubleArray;
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param javaObj
	 * @return
	 */
	public static String getJsonString4JavaPOJO(Object javaObj) {
		JSONObject json;
		json = (JSONObject) JSONObject.toJSON(javaObj);
		return json.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成方法存根
	}
	
	

}
