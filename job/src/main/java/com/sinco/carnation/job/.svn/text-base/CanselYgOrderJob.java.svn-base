package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sinco.carnation.order.service.OrderFormService;

/**
 * 取消在72小时内未完成现金支付的云购币订单
 * 
 * @author Administrator
 * 
 */
public class CanselYgOrderJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private OrderFormService orderFormService;

	public synchronized void executeJob() {
		try {
			orderFormService.return_ygOrder();
		} catch (Exception e) {
			logger.error("[CanselYgOrderJob] error.", e);
		}

	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

}
