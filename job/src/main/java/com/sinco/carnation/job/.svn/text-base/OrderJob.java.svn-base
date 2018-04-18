package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.order.service.OrderFormService;

public class OrderJob {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private OrderFormService orderFormService;
	@SuppressWarnings("unused")
	private EvaluateService evaluateService;
	
	public synchronized void executeJob() {
		Long second = 259200L;
		this.orderCancel(second);// 取消订单
	}

	/** 取消订单 **/
	public synchronized void orderCancel(Long second) {
		//普通订单 精选专区 状态为10的订单自动取消
		try {
			orderFormService.cancelNotPayingOrderForm(second);
		} catch (Exception e) {
			logger.error("[orderCancel] orderForm" + e);
		}
	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

}
