package com.sinco.carnation.order.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.shop.dao.OrderFormDao;

/**
 * 
 * <p>
 * Title: OrderViewTools.java
 * </p>
 * 
 * <p>
 * Description: 前端订单处理工具类，用来查询订单信息显示在前端
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-22
 * 
 * @version 1.0.1
 */
@Component
public class OrderViewTools {
	@Autowired
	private OrderFormDao orderFormDao;

	public int query_user_order(String order_status, Long uid) {
		int status = -1;
		if (order_status.equals("order_submit")) {// 已经提交
			status = 10;
		}
		if (order_status.equals("order_pay")) {// 已经付款
			status = 20;
		}
		if (order_status.equals("order_shipping")) {// 已经发货
			status = 30;
		}
		if (order_status.equals("order_receive")) {// 已经收货
			status = 40;
		}
		if (order_status.equals("order_finish")) {// 已经完成
			status = 60;
		}
		if (order_status.equals("order_cancel")) {// 已经取消
			status = 0;
		}
		int count = this.orderFormDao.countByStatus(status, uid, null, null);
		return count;
	}

	@SuppressWarnings({"unused", "rawtypes"})
	public int query_store_order(String order_status, Long storeId) {
		if (storeId != null) {
			Map params = new HashMap();
			int status = -1;
			if (order_status.equals("order_submit")) {// 已经提交
				status = 10;
			}
			if (order_status.equals("order_pay")) {// 已经付款
				status = 20;
			}
			if (order_status.equals("order_shipping")) {// 已经发货
				status = 30;
			}
			if (order_status.equals("order_receive")) {// 已经收货
				status = 40;
			}
			if (order_status.equals("order_finish")) {// 已经完成
				status = 60;
			}
			if (order_status.equals("order_cancel")) {// 已经取消
				status = 0;
			}
			int count = this.orderFormDao.countByStatus(status, null, storeId, null);
			return count;
		} else
			return 0;
	}
}
