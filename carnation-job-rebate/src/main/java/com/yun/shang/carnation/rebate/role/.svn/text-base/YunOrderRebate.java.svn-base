package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.sys.bo.orcl.CnWirteOrderBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;

public class YunOrderRebate extends RoleRebate {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CnPayBaseService cnPayBaseService;
	private UserAccountService accountService;
	private OrderFormService orderFormService;

	public YunOrderRebate(CnPayBaseService cnPayBaseService, UserAccountService accountService,
			MoneyService moneyService, OrderFormService orderFormService) {
		this.cnPayBaseService = cnPayBaseService;
		this.accountService = accountService;
		super.moneyService = moneyService;
		this.orderFormService = orderFormService;
	}

	@Override
	public Map<String, AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype) {
		Map<String, AddMoneyMO> resultMP = new HashMap<String, AddMoneyMO>();

		logger.debug("[rebate] supplier seller rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		UserAccount userAccount = accountService.findByUid(orderUserId, "8");
		if (null == userAccount) {
			logger.error("[rebate] order user is not cn role, user id =" + orderUserId);
			logger.error("[rebate] order user is not cn role, order number=" + orderNo);
			return null;
		}
		if (StringUtils.isBlank(userAccount.getLoginName())) {
			return null;
		}
		ShopBonusRepeatLog bonusRepeatLog = orderFormService.getBonusLogsByOrderId(orderNo, 0);
		if (null == bonusRepeatLog) {
			logger.error("[rebate] bonusRepeatLog pay no is empty. order_no=" + orderNo);
			return null;
		}

		String returnTracNo = bonusRepeatLog.getReturnTracNo();
		if (StringUtils.isBlank(returnTracNo)) {
			logger.error("[rebate] zhixiao pay no is empty. order_no=" + orderNo);
		}
		String paynoes[] = returnTracNo.split("\\|");
		String payNO = paynoes[0];
		try {
			if (0 < BVAmount.doubleValue()) {
				CnWirteOrderBO cnWirteOrderBO = cnPayBaseService.shopPy(userAccount.getLoginName(),
						BVAmount.doubleValue(), orderNo, payNO);
				if (!"100.0".equals(cnWirteOrderBO.getRETURN_STATUS())) {
					logger.error("[rebate] YUN_GOU_BI system result error. result="
							+ cnWirteOrderBO.getORDER_STATUS());
					logger.error(
							"[rebate] shop order send to YUN_GOU_BI system error. order number=" + orderNo);
					return null;
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] YUN_GOU_BI to zhixiao  error. CN=" + userAccount.getLoginName() + ",bv="
					+ BVAmount.doubleValue() + ",orderNo=" + orderNo + ",payNO=" + payNO);
			return null;
		}

		AddMoneyMO addMoney = new AddMoneyMO();
		addMoney.setUserRefereeAmount(new BigDecimal(0));
		addMoney.setRelateUserId(orderUserId);
		addMoney.setOrderId(orderId);
		addMoney.setOrderNo(orderNo);
		addMoney.setOrderUserId(orderUserId);
		addMoney.setSelleruserId(selleruserId);
		addMoney.setBVAmount(BVAmount);
		addMoney.setRebateType(RebateConstants.REBATE_YUN_GOU_BI);
		addMoney.setUserType(MoneyUserTypeEnum.BUYER);
		resultMP.put(orderNo + "_" + RebateConstants.REBATE_YUN_GOU_BI, addMoney);
		return resultMP;
	}
}
