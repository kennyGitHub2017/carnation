package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * 当前会员绑定的CN运营商分润
 * 
 * @author xing.wen
 * 
 */
public class CnOperatorRebate extends OperatorRebateBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private OperatorRemoteService operatorRemoteService;

	public CnOperatorRebate(Proportion proportion, OperatorRemoteService operatorRemoteService,
			MoneyService moneyService) {
		this.operatorRemoteService = operatorRemoteService;
		this.proportion = proportion;
		super.moneyService = moneyService;
	}

	@Override
	public Map<String,AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		return this.rebate(orderUserId, selleruserId, orderId, orderNo, BVAmount, null);
	}

	@Override
	public Map<String,AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		return this.rebate(orderUserId, selleruserId, orderId, orderNo, BVAmount, null);
	}

	@Override
	public Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo, BigDecimal BVAmount,
			RebateType rebatetype) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		logger.debug("[rebate] cn operator rebate parameter ,userid=" + orderUserId + ",selleruserId="
				+ selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount + ",rebatetype"
				+ rebatetype);
		BigDecimal userRefereeAmount = null;
		BigDecimal memberLevelFirst = proportion.getMemberRecommendCNoperatorFirst();
		BigDecimal memberLevelSecond = proportion.getMemberRecommendCNoperatorSecond();
		BigDecimal memberLevelThird = proportion.getMemberRecommendCNoperatorThird();
		String cnName = RebateTools.getUserRecommendCnOperator(orderUserId);
		if (StringUtils.isBlank(cnName)) {
			logger.info(
					"[rebate] cn operator rebate ,current member hav'ot  recommend operator empty, user id="
							+ orderUserId);
			return resultMP;
		}
		// 用户关系层 分润
		Map<Integer, Long> userRelationMp = operatorRemoteService.getRemoteOperatorLevelByCode(cnName);
		if (null == userRelationMp) {
			logger.info("[rebate] cn operator rebate ,current member hav'ot empty, user id=" + orderUserId);
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] cn operator rebate,current member level=" + i + ", userid="
						+ orderUserId + ", spendingSellerid=" + selleruserId);
				break;
			}
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelFirst);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelSecond);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_MEMBER_RECOMMEND_CNOPERATOR_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelThird);
					break;
				default:
					logger.warn("[rebate] cn operator rebate,current member level not in (2,3,4), level=" + i
							+ ", orderUserId=" + orderUserId + ", spendingSellerid=" + selleruserId);
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
			addMoney.setUserType(MoneyUserTypeEnum.BUYER);
			resultMP.put(orderNo+"_"+rebateType, addMoney);
		}
		return resultMP;
	}
}
