package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.goods.service.ZeroGoodsService;

/**
 * 0元购活动时间到期
 * 
 * @author Administrator
 * 
 */
public class ZeroActJob {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ZeroGoodsService zeroGoodsService;

	public synchronized void ZeroAct() {
		try {
			logger.info("[ZeroActJob] begin");
			zeroGoodsService.ActTimeOut();
		} catch (Exception e) {
			logger.error("[ZeroActJob] error.", e);
		}

	}

	public ZeroGoodsService getZeroGoodsService() {
		return zeroGoodsService;
	}

	public void setZeroGoodsService(ZeroGoodsService zeroGoodsService) {
		this.zeroGoodsService = zeroGoodsService;
	}
}
