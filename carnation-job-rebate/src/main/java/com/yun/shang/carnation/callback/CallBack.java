package com.yun.shang.carnation.callback;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.model.RebateRecord;

public class CallBack {
	private static final Logger logger = LoggerFactory.getLogger(CallBack.class);
	private RebateRecordService rebateRecordService;
	private UserMoneyDao userMoneyDao;
	private PredepositLogDao predepositLogDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void excute(String code) {
		List<RebateRecord> rebateRecordArray = rebateRecordService.findOneRecordeByCode(code);
		boolean isOrderNoExecute = false;
		for (RebateRecord rebateRecord : rebateRecordArray) {
			Date rebateRecordAddTime = rebateRecord.getCreateTime();
			BigDecimal rebateAmount = rebateRecord.getCodeAmount();
			// 得到返利润的用户ID
			long rebateUserid = rebateRecord.getUserId();
			List<PredepositLogBO> predepositLogBOArray = predepositLogDao.findByUid(rebateUserid);
			for (PredepositLogBO predepositLogBO : predepositLogBOArray) {
				Date logAddTime = predepositLogBO.getAddTime();
				BigDecimal amount = predepositLogBO.getPdLogAmount();
				if (rebateRecordAddTime.compareTo(logAddTime) == 0 && rebateAmount.compareTo(amount) == 0) {
					// 删除记录
					int i = predepositLogDao.delete(predepositLogBO.getId());
					if (i == 1) {
						Long userCode = predepositLogBO.getUserCode();
						switch (userCode.intValue()) {
							// 个人
							case 0:
								int subtractMoney = userMoneyDao.subtractMoneyV2(rebateUserid, amount,
										UserContant.ACCOUNT_TYPE_RESOURCE);
								 
								if (subtractMoney <= 0) {
									logger.warn("[rebat call back] not execute.uid=" + rebateUserid
											+ "predeposit_log_id=" + predepositLogBO.getId() + ",order_no="
											+ rebateRecord.getRebateCode());
									
								}
								isOrderNoExecute = true;
								break;
							// 供应商
							case 1:
								subtractMoney = userMoneyDao.subtractMoneyV2(rebateUserid, amount,
										UserContant.ACCOUNT_TYPE_SUPPLIER);
								if (subtractMoney <= 0) {
									// 未减金额
									logger.warn("[rebat call back] not execute.uid=" + rebateUserid
											+ "predeposit_log_id=" + predepositLogBO.getId() + ",order_no="
											+ rebateRecord.getRebateCode());
								}
								isOrderNoExecute = true;
								break;
							// 商户
							case 2:
								subtractMoney = userMoneyDao.subtractMoneyV2(rebateUserid, amount,
										UserContant.ACCOUNT_TYPE_MERCHANT);
								if (subtractMoney <= 0) {
									// 未减金额
									logger.warn("[rebat call back] not execute.uid=" + rebateUserid
											+ "predeposit_log_id=" + predepositLogBO.getId() + ",order_no="
											+ rebateRecord.getRebateCode());
								}
								isOrderNoExecute = true;
								break;
							// 运营商
							case 3:
								subtractMoney = userMoneyDao.subtractMoneyV2(rebateUserid, amount,
										UserContant.ACCOUNT_TYPE_YY);
								if (subtractMoney <= 0) {
									// 未减金额
									logger.warn("[rebat call back] not execute.uid=" + rebateUserid
											+ "predeposit_log_id=" + predepositLogBO.getId() + ",order_no="
											+ rebateRecord.getRebateCode());
								}
								isOrderNoExecute = true;
								break;
							default:
								break;
						}
					}
				}
			}
			// 未处理订单
			if (isOrderNoExecute) {
				logger.warn("[rebat call back] not execute.order_no=" + rebateRecord.getRebateCode());
			}
		}
	}

	public RebateRecordService getRebateRecordService() {
		return rebateRecordService;
	}

	public void setRebateRecordService(RebateRecordService rebateRecordService) {
		this.rebateRecordService = rebateRecordService;
	}

	public UserMoneyDao getUserMoneyDao() {
		return userMoneyDao;
	}

	public void setUserMoneyDao(UserMoneyDao userMoneyDao) {
		this.userMoneyDao = userMoneyDao;
	}

	public PredepositLogDao getPredepositLogDao() {
		return predepositLogDao;
	}

	public void setPredepositLogDao(PredepositLogDao predepositLogDao) {
		this.predepositLogDao = predepositLogDao;
	}
}
