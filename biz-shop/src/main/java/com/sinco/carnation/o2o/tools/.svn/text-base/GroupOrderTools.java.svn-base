package com.sinco.carnation.o2o.tools;

import java.util.HashMap;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.stereotype.Component;

@Component
public class GroupOrderTools {
	/**
	 * 解析订单商品信息json数据
	 * 
	 * @param order_id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map queryGoodsInfo(String json) {
		Map map = new HashMap();
		if (json != null && !json.equals("")) {
			map = Json.fromJson(HashMap.class, json);
		}
		return map;
	}
}
