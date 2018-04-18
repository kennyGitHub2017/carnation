package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.carnation.order.service.OrderFormService;

/****
 * 云购币订单退款JOb 非云购币 专区
 * 
 * @author Administrator
 * 
 */
public class ReturnYgOrderJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderFormService orderFormService;

	public synchronized void cancelYgOrderJob() {
		try {
			orderFormService.returnYgOrderActualygPrice();
			this.returnIntegral();//积分退回
		} catch (Exception e) {
			logger.error("[returnYgOrderActualygPriceJob] error.", e);
		}
	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}
	
	/***
	 * 精品专区 积分支付 一半 退款
	 * 
	 */
	public void returnIntegral() {
		try {
			this.orderFormService.selectFailedIntegralOrder();
		} catch (Exception e) {
			logger.error("[returnIntegral] error.", e);
		}
	}
	
	

}
