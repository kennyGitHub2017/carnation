package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinco.carnation.juanpi.service.SynJuanpiDataService;

/**
 * 卷皮数据定时同步到本地数据库
 * 
 * @author Tivan
 * 
 */
public class JuanpiDataSynJob {
	protected static final Logger LOGGER = LoggerFactory.getLogger(JuanpiDataSynJob.class);
	@Autowired
	private SynJuanpiDataService synJuanpiDataService;
	@SuppressWarnings("unused")
	private String isDebug;

	public void setSynJuanpiDataService(SynJuanpiDataService synJuanpiDataService) {
		this.synJuanpiDataService = synJuanpiDataService;
	}

	public void setIsDebug(String isDebug) {
		this.isDebug = isDebug;
	}

	/**
	 * 同步卷皮商品
	 */
	public void goodsSyn() {
		synJuanpiDataService.synJuanpiGoods();
	}

	/**
	 * 同步卷皮订单
	 */
	public void orderSyn() {
		// 每3分钟同步一次，仅同步120分钟内的订单数据
		synJuanpiDataService.synJuanpiOrder();
	}
	
	public void orderSyn2(){
		//每20分钟同步一次，仅同步2天内的订单数据
		synJuanpiDataService.synJuanpiOrder2(3);
	}
	
	public void orderFix() {
		// 分30分钟同步一次，仅同步数据库订单商品1,2的订单
		synJuanpiDataService.fixJuanpiOrder();
	}

}
