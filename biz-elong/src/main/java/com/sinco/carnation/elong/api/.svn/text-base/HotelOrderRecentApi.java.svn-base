/**   
 * @(#)HotelOrderCancelApi.java	2016年11月21日	下午3:26:06	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.api;

import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.model.elong.RecentOrderedHotel;
import com.sinco.carnation.elong.model.h5.result.HotelOrderRecentResult;

/**
 * 获取最近预定日期
 * 
 * @author yuanming
 * 
 */

@Service
public class HotelOrderRecentApi extends BaseApi<RecentOrderedHotel, HotelOrderRecentResult> {

	@Override
	public String method() {
		return "hotel.order.recent";
	}

	@Override
	public boolean isRequiredSSL() {
		return true;
	}
}
