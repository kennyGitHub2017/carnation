package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.carnation.integral.service.IntegralGoodsOrderService;

/***
 * 
 * 自动取消积分订单 退回积分
 * 
 * @author Administrator
 *
 */
public class IntegralOrderCancelJob {
	
	private static Logger logger = LoggerFactory.getLogger(IntegralOrderCancelJob.class);
	
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	
	public synchronized void integralOrderCance() {
		System.out.println("1");
		synchronized(logger){
			try {
				this.integralGoodsOrderService.IntegralOrderAutoCancel();
			} catch (Exception e) {
				logger.error("[IntegralOrderCancelJob] error.", e);
			}
		}
	}

	public IntegralGoodsOrderService getIntegralGoodsOrderService() {
		return integralGoodsOrderService;
	}

	public void setIntegralGoodsOrderService(IntegralGoodsOrderService integralGoodsOrderService) {
		this.integralGoodsOrderService = integralGoodsOrderService;
	}
	
	
}
