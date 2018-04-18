package com.sinco.carnation.resource.web.util;

import java.util.List;

import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.store.tools.DistanceUtils;

/**
 * 距离工具类
 * 
 * @author james
 * 
 */
public class MyDistanceUtil {

	/**
	 * 设置服务距离
	 * 
	 * @param list
	 * @param storeLon
	 * @param storeLat
	 */
	public static void setDistance(List<GroupGoodsBO> list, Double storeLon, Double storeLat) {
		for (GroupGoodsBO groupGoodsBO : list) {
			if (groupGoodsBO.getStoreLat() != null && groupGoodsBO.getStoreLon() != null) {
				groupGoodsBO.setDistance(DistanceUtils.GetDistance(storeLon, storeLat, groupGoodsBO
						.getStoreLon().doubleValue(), groupGoodsBO.getStoreLat().doubleValue()));
			}
		}
	}
}
