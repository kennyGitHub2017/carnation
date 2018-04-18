package com.sinco.carnation.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.o2o.service.GroupCaseService;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.sys.service.IntegralService;

public class GoodsJob {

	private static Logger logger = LoggerFactory.getLogger(GoodsJob.class);
	private IntegralService integralService;
	private PayoffLogService payoffLogService;
	private GroupCaseService groupCaseService;
	public synchronized void executeJob() {
		synchronized(logger){
			//自动结算
			this.automaticSettlement();
			//积分商城过期商品自动下架
			this.integralGoodsChangeShow();
			//刷新服务缓存
//			groupCaseService.refreshGroupCase();
		}
	}
	
	/** 自动结算 **/
	public void automaticSettlement(){
		logger.info("[automaticSettlement] begin");
		List<PayoffLogBO> list = payoffLogService.listByStatus("1");
		if (list == null) {
			return;
		}
		//提交结算
		for (PayoffLogBO bo : list) {
			if(bo != null){
				payoffLogService.submitSettlement(bo);
			}
		}
		logger.info("[automaticSettlement] end");
	}
	
	/**
	 * 积分商城过期商品自动下架
	 */
	public void integralGoodsChangeShow(){
		try {
			logger.info("[integralGoodsChangeShow] start");
			integralService.changeShow();
			logger.info("[integralGoodsChangeShow] end");
		} catch (Exception e) {
			logger.error("[integralGoodsChangeShow] can not changeShow", e);
		}
	}

	public IntegralService getIntegralService() {
		return integralService;
	}

	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}

	public Logger getLogger() {
		return logger;
	}

	@SuppressWarnings("static-access")
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public PayoffLogService getPayoffLogService() {
		return payoffLogService;
	}

	public void setPayoffLogService(PayoffLogService payoffLogService) {
		this.payoffLogService = payoffLogService;
	}

	public GroupCaseService getGroupCaseService() {
		return groupCaseService;
	}

	public void setGroupCaseService(GroupCaseService groupCaseService) {
		this.groupCaseService = groupCaseService;
	}

}
