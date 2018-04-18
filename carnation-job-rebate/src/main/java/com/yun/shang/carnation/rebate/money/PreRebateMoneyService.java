package com.yun.shang.carnation.rebate.money;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.carnation.user.service.UserMoneyService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;

/**
 * 云豆预分润
 * 
 * @author xing.wen
 * 
 */
public class PreRebateMoneyService implements MoneyService {
	private static final Logger logger = LoggerFactory.getLogger(PreRebateMoneyService.class);
	private RebateRecordService rebateRecordService;
	// 账户余额服务
	private UserMoneyService userMoneyService;

	public UserMoneyService getUserMoneyService() {
		return userMoneyService;
	}

	public void setUserMoneyService(UserMoneyService userMoneyService) {
		this.userMoneyService = userMoneyService;
	}

	public RebateRecordService getRebateRecordService() {
		return rebateRecordService;
	}

	public void setRebateRecordService(RebateRecordService rebateRecordService) {
		this.rebateRecordService = rebateRecordService;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void addmoney(AddMoneyMO addMoneyMO) {
		BigDecimal userRefereeAmount = addMoneyMO.getUserRefereeAmount();
		long relateUserId = addMoneyMO.getRelateUserId();
		long orderId = addMoneyMO.getOrderId();
		String orderNo = addMoneyMO.getOrderNo();
		long orderUserId = addMoneyMO.getOrderUserId();
		long selleruserId = addMoneyMO.getSelleruserId();
		BigDecimal BVAmount = addMoneyMO.getBVAmount();
		String rebateType = addMoneyMO.getRebateType();
		MoneyUserTypeEnum userType = addMoneyMO.getUserType();
		String desc = RebateConstants.getRebateNameByType(rebateType);
		if (null != userRefereeAmount && userRefereeAmount.doubleValue() >= 0d) {
			// 添加分润记录
			RebateRecord record = new RebateRecord();
			record.setOrderId(orderId);
			record.setRebateCode(orderNo);
			record.setOrderUserId(orderUserId);
			record.setRebateAmount(userRefereeAmount);
			record.setRebateType(rebateType);
			record.setSellerUserId(selleruserId);
			record.setUserId(relateUserId);
			record.setCreateTime(new Date());
			record.setCodeAmount(BVAmount);
			record.setRebateStatus("0");
			record.setSendTime(new Date());
			record.setUserType(userType.toString());
			rebateRecordService.preSave(record);
			logger.debug("[rebate] success ,orderUserId=" + orderUserId + ",selleruserId=" + selleruserId
					+ ",orderId=" + orderId + ",BVAmount=" + BVAmount + ",rebateType=" + rebateType + ",desc="
					+ desc);
		}
	}
}
