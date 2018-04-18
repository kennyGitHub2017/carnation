package com.sinco.carnation.user.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nutz.json.Json;
import org.springframework.stereotype.Component;

/**
 * 菜单管理工具，V1.3版开始使用，卖家中心快捷菜单采用json管理，该工具使用解析json数据
 * 
 * @author thinker
 * 
 */
@Component
public class MenuTools {
	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<Map> generic_seller_quick_menu(String menu_json) {
		List<Map> list = new ArrayList<Map>();
		if (menu_json != null && !menu_json.equals("")) {
			list = Json.fromJson(List.class, menu_json);
		}
		return list;
	}
}
