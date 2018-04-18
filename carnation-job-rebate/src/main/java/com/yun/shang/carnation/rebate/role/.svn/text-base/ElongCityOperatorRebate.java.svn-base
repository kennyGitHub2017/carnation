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

public class ElongCityOperatorRebate extends OperatorRebateBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ElongCityOperatorRebate(Proportion proportion, MoneyService moneyService) {
		super.proportion = proportion;
		super.moneyService = moneyService;
	}
	@Override
	public Map<String, AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId,
			String orderNo, BigDecimal BVAmount) {
		// 管理端分润与平台其他订单一致
		OperatorRebateBasic rebate = new CityOperatorRebate(proportion, moneyService);
		return rebate.bindingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
	}

	@Override
	public Map<String, AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId,
			String orderNo, BigDecimal BVAmount) {
		Map<String, AddMoneyMO> resultMP = new HashMap<String, AddMoneyMO>();
		logger.debug("[rebate] spending city operator rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		BigDecimal userRefereeAmount = null;
		BigDecimal currentOperator = proportion.getMemberSpendingSellerCityOpertor();
		BigDecimal operatorLevelFirst = proportion.getMemberSpendingSellerCityOpertorFirst();
		logger.debug("[rebate] spending city Operator rebate porprotion,currentOperator=" + currentOperator
				+ ",operatorLevelFirst=" + operatorLevelFirst);
		// 用户推荐关系表
		Map<Integer, Long> userRelationMp = RebateTools.getElongCityOperatorLevelByArea(1, orderId);
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.warn(
						"[rebate] binding city operator rebate,current district operator  hav'ot city operator in code, sellerid="
								+ selleruserId);
				return resultMP;
			}
			String rebateType = null;
			long uid = userRelationMp.get(i);
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_SPENDING_CITY_OPERATOR;
					userRefereeAmount = proportion.multiply(BVAmount, currentOperator);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_SPENDING_CITY_OPERATOR_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, operatorLevelFirst);
					break;
				default:
					logger.warn("[rebate] binding district operator rebate,current level not in (1), level="
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
