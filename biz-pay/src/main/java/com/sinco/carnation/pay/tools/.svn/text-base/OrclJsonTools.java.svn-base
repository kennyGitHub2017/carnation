package com.sinco.carnation.pay.tools;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.sys.tools.JsonUtil;

public class OrclJsonTools {
	private static Logger logger = LoggerFactory.getLogger(OrclJsonTools.class);

	/**
	 * 返回Object对象
	 * 
	 * @param schema_name
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static Object handeljson(String result, Class calss) {
		JSONObject json1 = (JSONObject) JSONObject.parse(result);
		String issucces = json1.getString("result");
		JSONObject json00 = null;
		Object object = null;
		if ("success".equals(issucces)) {
			JSONArray jsonArr = json1.getJSONArray("data");
			if (!jsonArr.isEmpty() && jsonArr.getJSONObject(0) != null) {
				json00 = jsonArr.getJSONObject(0);
				object = JsonUtil.getObject4JsonString(json00.toString(), calss);
			}
			return object;
		} else {
			logger.info("结算系统查询失败:result===" + result);
			throw new RuntimeException("[orcl relult] error.");
		}
	}
}
