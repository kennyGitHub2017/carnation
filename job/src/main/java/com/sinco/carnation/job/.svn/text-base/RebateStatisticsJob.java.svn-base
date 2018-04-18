package com.sinco.carnation.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.rebate.service.RebateStatisService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.StatisticsService;

/**
 * 收益统计任务
 * 
 * @author Administrator
 * 
 */
public class RebateStatisticsJob {

	private StatisticsService statisticsService;

	private UserService userService;

	private RebateRecordService rebateRecordService;

	private ShopQrPayOrderService shopQrPayOrderService;

	private RebateStatisService rebateStatisService;

	private static  Logger logger = LoggerFactory.getLogger(RebateStatisticsJob.class);

	public synchronized void RebateStatistics() {
		synchronized(logger){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str = sdf.format(date);
			System.out.println(str);
			logger.info(str + " begin to statisticRebate [RebateStatistics]");
			rebateStatisService.statisticRebateByTime(null);
			logger.info("[RebateStatistics] end");
		}
	}

	public StatisticsService getStatisticsService() {
		return statisticsService;
	}

	public void setStatisticsService(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	public RebateRecordService getRebateRecordService() {
		return rebateRecordService;
	}

	public void setRebateRecordService(RebateRecordService rebateRecordService) {
		this.rebateRecordService = rebateRecordService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ShopQrPayOrderService getShopQrPayOrderService() {
		return shopQrPayOrderService;
	}

	public void setShopQrPayOrderService(ShopQrPayOrderService shopQrPayOrderService) {
		this.shopQrPayOrderService = shopQrPayOrderService;
	}

	public RebateStatisService getRebateStatisService() {
		return rebateStatisService;
	}

	public void setRebateStatisService(RebateStatisService rebateStatisService) {
		this.rebateStatisService = rebateStatisService;
	}

}
