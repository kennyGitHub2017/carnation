package com.sinco.carnation.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;

/**
 * 订单在已发货的状态下10天自动收货
 * 
 * @author yuanming.feng
 * @date 2017年3月13日
 * 
 */
public class OrdersAutoReceivingJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private OrderFormService orderFormService;

	@Value(value = "${order.auto.receiving.time}")
	int receivingTime;

	public synchronized void executeJob() {
		// 获取10天前的时间
		Date now = new Date();
		Calendar dateTime = Calendar.getInstance();
		dateTime.setTime(now);
		dateTime.set(Calendar.DATE, dateTime.get(Calendar.DATE) - receivingTime);
		Date tenDaysAgo = dateTime.getTime();
		logger.info("=================订单在已发货的状态下" + receivingTime + "自动收货 开始时间：" + now + "=================");
		// 获取超过10天的已发货订单列表
		List<OrderFormBO> orderForms = orderFormService.getOrderByDaysAgo(tenDaysAgo,
				OrderFormConstants.ORDER_STATUS_NO_TAKE_DELIVERY_OF_GOODS);
		for (OrderFormBO item : orderForms) {
			// 把超过10天的已发货订单修改为已收货。
			try {
				orderFormService.orderCofirmSaveCom(item.getUserId(), null, item);
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("修改为已发货状态。orderId：" + item.getId() + ",orderStatus:" + item.getOrderStatus());
		}
		logger.info("=================订单在已发货的状态下" + receivingTime + "天自动收货 结束时间：" + new Date()
				+ "=================");
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

}
