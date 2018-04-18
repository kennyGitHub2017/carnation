package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.user.service.UserMoneyService;

/**
 * 预分润统计任务
 * 
 * @author Administrator
 * 
 */
public class RecordBalanceJob {
	private UserMoneyService userMoneyService;

	private static Logger logger = LoggerFactory.getLogger(RecordBalanceJob.class);

	public synchronized void updateRecordBalance() {
		synchronized (logger){
			boolean result = userMoneyService.updateRecordBalance();
			if (result) {
				logger.info("[updateRecordBalance] is success");
			} else {
				logger.info("[updateRecordBalance] is failure");
			}
		}
	}

	public UserMoneyService getUserMoneyService() {
		return userMoneyService;
	}

	public void setUserMoneyService(UserMoneyService userMoneyService) {
		this.userMoneyService = userMoneyService;
	}
}
