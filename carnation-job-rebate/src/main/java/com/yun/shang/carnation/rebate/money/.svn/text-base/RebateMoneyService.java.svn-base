package com.yun.shang.carnation.rebate.money;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.carnation.user.service.UserMoneyService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * 云豆分润
 * 
 * @author xing.wen
 * 
 */
public class RebateMoneyService implements MoneyService {
	private static final Logger logger = LoggerFactory
			.getLogger(RebateTools.class);
	// 账户余额服务
	private UserMoneyService userMoneyService;
	// 分润历史记录服务
	private RebateRecordService rebateRecordService;
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
			try {
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
				record.setRebateStatus("1");
				record.setSendTime(new Date());
				record.setUserType(userType.toString());
				rebateRecordService.saveAlreadyRecord(record);
				if (userRefereeAmount.doubleValue() > 0d) {
					boolean result = userMoneyService.addMoneyV2ByUserType(
							relateUserId, userRefereeAmount.doubleValue(),
							null, UserContants.PD_OP_TYPE_REBATE, desc,
							userType);
					if (!result) {
						logger.error("add user money error. order_id="
								+ orderNo + ",rebateType=" + rebateType
								+ ",user_id=" + relateUserId + ",amount="
								+ userRefereeAmount.doubleValue()
								+ ",user_type=" + userType);
						throw new RuntimeException(
								"add user money error. order_id=" + orderNo
										+ ",rebateType=" + rebateType
										+ ",user_id=" + relateUserId
										+ ",amount="
										+ userRefereeAmount.doubleValue()
										+ ",user_type=" + userType);
					}
				}
				logger.info("[rebate] success ,orderUserId=" + orderUserId
						+ ",selleruserId=" + selleruserId + ",orderId="
						+ orderId + ",BVAmount=" + BVAmount + ",rebateType="
						+ rebateType + ",desc=" + desc);
			} catch (Exception e) {
				logger.error("[rebate] error. order_id=" + orderNo, e);
				throw new RuntimeException("add rebate money error. order_id="
						+ orderNo, e);
			}
		}
	}

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

}
