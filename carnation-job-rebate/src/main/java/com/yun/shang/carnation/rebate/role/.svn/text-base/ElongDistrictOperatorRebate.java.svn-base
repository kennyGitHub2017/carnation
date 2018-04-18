package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * 区级运营商分利润
 * 
 * @author xing.wen
 * 
 */
public class ElongDistrictOperatorRebate extends OperatorRebateBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ElongDistrictOperatorRebate(Proportion proportion, MoneyService moneyService) {
		super.proportion = proportion;
		super.moneyService = moneyService;
	}

	@Override
	public Map<String, AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId,
			String orderNo, BigDecimal BVAmount) {
		// 管理端分润与平台其他订单一致
		OperatorRebateBasic rebate = new DistrictOperatorRebate(proportion, moneyService);
		return rebate.bindingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
	}

	@Override
	public Map<String, AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId,
			String orderNo, BigDecimal BVAmount) {
		Map<String, AddMoneyMO> resultMP = new HashMap<String, AddMoneyMO>();
		logger.debug("[rebate] spending Operator rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		BigDecimal userRefereeAmount = null;
		BigDecimal currentOperator = proportion.getMemberSpendingSellerDistrictOpertor();
		BigDecimal operatorLevelFirst = proportion.getMemberSpendingSellerDistrictOpertorFirst();
		logger.debug("[rebate] spending district Operator rebate porprotion,currentOperator="
				+ currentOperator + ",operatorLevelFirst=" + operatorLevelFirst);
		// 商家隶属区域运营商关系
		Map<Integer, Long> userRelationMp = RebateTools.getElongDistrictOperatorLevelBySeller(1,
				orderId);
		if (null == userRelationMp) {
			return resultMP;
		}
		String rebateType = null;
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.warn(
						"[rebate] spending district operator rebate,current district operator  hav'ot city operator in code, sellerid="
								+ selleruserId);
				return resultMP;
			}
			long uid = userRelationMp.get(i);
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_SPENDING_DISTRICT_OPERATOR;
					userRefereeAmount = proportion.multiply(BVAmount, currentOperator);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_SPENDING_DISTRICT_OPERATOR_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, operatorLevelFirst);
					break;
				default:
					logger.warn("[rebate] spending district operator rebate,current level not in (1), level="
							+ i + ", orderUserId=" + orderUserId + ", spending sellerid=" + selleruserId);
					break;
			}
			if (StringUtils.isBlank(rebateType)) {
				continue;
			}
			AddMoneyMO addMoney = new AddMoneyMO();
			addMoney.setUserRefereeAmount(userRefereeAmount);
			addMoney.setRelateUserId(uid);
			addMoney.setOrderId(orderId);
			addMoney.setOrderNo(orderNo);
			addMoney.setOrderUserId(orderUserId);
			addMoney.setSelleruserId(selleruserId);
			addMoney.setBVAmount(BVAmount);
			addMoney.setRebateType(rebateType);
			addMoney.setUserType(MoneyUserTypeEnum.OPERATOR);
			resultMP.put(orderNo + "_" + rebateType, addMoney);
		}
		return resultMP;
	}

	@Override
	public Map<String, AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype) {
		if (RebateType.BINDING_SELLER_OPERTOR == rebatetype) {
			return this.bindingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
		}
		if (RebateType.SPENDING_SELLER_OPERTOR == rebatetype) {
			return this.spendingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
		}
		return null;
	}

}
