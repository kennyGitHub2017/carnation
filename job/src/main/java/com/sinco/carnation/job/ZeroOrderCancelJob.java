package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.order.service.OrderFormService;

@Component
public class ZeroOrderCancelJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderFormService orderFormService;

	/**
	 * 0元购 超过3分钟的订单设置成取消状态
	 */
	public synchronized void cancelZeroActOrderCancel() {
		try {
			logger.info("[cancelZeroActOrderCancel] begin");
			orderFormService.cancelZeroOrder();
		} catch (Exception e) {
			logger.error("[cancelZeroActOrderCancel] is un success + " + e);
		}
	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}
}
