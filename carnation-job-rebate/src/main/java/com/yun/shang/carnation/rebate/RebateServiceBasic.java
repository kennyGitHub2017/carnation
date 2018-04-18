package com.yun.shang.carnation.rebate;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;

/**
 * 分润结算接口
 * 
 * @author xing.wen
 * 
 */
public abstract class RebateServiceBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private MoneyService rebateMoneyService;

	/**
	 * 分润结算
	 * 
	 * @return
	 */
	public abstract boolean rebate(Long sellerId, Long orderId);

	protected void mergeMP(Map<String, AddMoneyMO> resultMP,
			Map<String, AddMoneyMO> sourceMP2) {
		if (null == resultMP) {
			return;
		}
		if (null == sourceMP2) {
			return;
		}
		resultMP.putAll(sourceMP2);
	}

	protected void rebateTODB(Map<String, AddMoneyMO> dbMP) {
		if (null == dbMP) {
			return;
		}
		logger.info("[rebate] create to db, rebate arguments" + dbMP);
		Set<Entry<String, AddMoneyMO>> entrySet = dbMP.entrySet();
		for (Entry<String, AddMoneyMO> entry : entrySet) {
			AddMoneyMO addMoneyMO = entry.getValue();
			rebateMoneyService.addmoney(addMoneyMO);
		}
	}

	public MoneyService getRebateMoneyService() {
		return rebateMoneyService;
	}

	public void setRebateMoneyService(MoneyService rebateMoneyService) {
		this.rebateMoneyService = rebateMoneyService;
	}
}
