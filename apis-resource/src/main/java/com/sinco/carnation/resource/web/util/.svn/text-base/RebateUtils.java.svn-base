package com.sinco.carnation.resource.web.util;

import java.util.ArrayList;
import java.util.List;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.GoodsDocument;

import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.user.bo.RebateRecordBO;

public class RebateUtils {

	// 分润类型
	private final String[][] arrays = { {"101", "会员消费返润"}, {"102", "注册会员分润"}, {"103", "会员管理返润"},
			{"104", "注册店返润"}, {"105", "终端管理返润"}, {"106", "注册关联返润"}, {"107", "区级管理返润"}, {"108", "市级管理返润"},
			{"109", "注册店返润"}, {"110", "终端服务返润"}, {"111", "区级服务返润"}, {"112", "市级服务返润"}, {"201", "终端手续费返润"},
			{"202", "区级手续费返润"}, {"203", "市级手续费返润"}, {"204", "推荐人手续费返润"}};

	private static final List<RebateRecordBO> list = new ArrayList<RebateRecordBO>();

	public static String getName(Integer num) {
		String mesage = null;
		switch (num) {
			case 101:
				mesage = "会员消费返润";
				break;
			case 102:
				mesage = "注册会员分润";
				break;
			case 103:
				mesage = "会员管理返润";
				break;
			case 104:
				mesage = "注册店返润";
				break;
			case 105:
				mesage = "终端管理返润";
				break;
			case 106:
				mesage = "注册关联返润";
				break;
			case 107:
				mesage = "区级管理返润";
				break;
			case 108:
				mesage = "市级管理返润";
				break;
			case 109:
				mesage = "注册店返润";
				break;
			case 110:
				mesage = "终端服务返润";
				break;
			case 111:
				mesage = "区级服务返润";
				break;
			case 112:
				mesage = "市级服务返润";
				break;
			case 201:
				mesage = "终端手续费返润";
				break;
			case 202:
				mesage = "区级手续费返润";
				break;
			case 203:
				mesage = "市级手续费返润";
				break;
			case 204:
				mesage = "推荐人手续费返润";
				break;
		}
		return mesage;
	}

	public static List<GoodsDocument> repeatGoodsList(List<GoodsDocument> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getId().equals(list.get(i).getId())) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	public static List<StoreDocument> repeatStoreList(List<StoreDocument> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getId().equals(list.get(i).getId())) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	public List<RebateRecordBO> getRebateTypeList() {
		if (list != null && list.size() == 16) {
			return list;
		} else {
			for (int i = 0; i < arrays.length; i++) {
				RebateRecordBO rabate = new RebateRecordBO();
				rabate.setId(CommUtil.null2Long(arrays[i][0]));
				rabate.setRebateType(arrays[i][1]);
				list.add(rabate);
			}
		}
		return list;

	}
}
