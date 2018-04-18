package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * 商家的分润
 * 
 * @author xing.wen
 * 
 */
public class SellerRebate extends SellerRebateBaisc {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public SellerRebate(Proportion proportion, MoneyService moneyService) {
		super.proportion = proportion;
		super.moneyService = moneyService;
	}

	@Override
	public Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype) {
		if (RebateType.BINDING_SELLER == rebatetype) {
			return this.bindingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
		} else {
			return this.spendingRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount);
		}
	}

	@Override
	public Map<String,AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		logger.debug("[rebate] spending seller rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		BigDecimal userRefereeAmount = null;
		BigDecimal currentSeller = proportion.getMemberSpendingSeller();
		BigDecimal sellerLevelFirst = proportion.getMemberSpendingSellerLevelFirst();
		BigDecimal sellerLevelSecond = proportion.getMemberSpendingSellerLevelSecond();
		BigDecimal sellerLevelThird = proportion.getMemberSpendingSellerLevelThird();
		logger.debug("[rebate] spending seller rebate porprotion,currentSeller=" + currentSeller
				+ ",sellerlevelfirst=" + sellerLevelFirst + ",sellerLevelSecond=" + sellerLevelSecond
				+ ",sellerLevelThird=" + sellerLevelThird);
		// 会员绑定商家的关系层 分润
		Map<Integer, Long> userRelationMp = RebateTools.getSellerBindingOperatorLevel(3, selleruserId);
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] spending seller rebate,current seller level=" + i + ", orderUserId="
						+ orderUserId + ", spendingSellerid=" + selleruserId);
				// 未满足三层推荐关系，利润分给平台；
				break;
			}
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_SPENDING_SELLER_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelFirst);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_SPENDING_SELLER_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelSecond);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_SPENDING_SELLER_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelThird);
					break;
				default:
					logger.warn("[rebate] spending seller rebate,current seller level not in (1,2,3), level="
							+ i + ", orderUserId=" + orderUserId + ", spendingSellerid=" + selleruserId);
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
			resultMP.put(orderNo+"_"+rebateType, addMoney);
		}
		return resultMP;
	}

	@Override
	public  Map<String,AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		logger.debug("[rebate] binding seller rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		BigDecimal userRefereeAmount = null;
		BigDecimal currentSeller = proportion.getMemberBindingSeller();
		BigDecimal sellerLevelFirst = proportion.getMemberBindingSellerLevelFirst();
		BigDecimal sellerLevelSecond = proportion.getMemberBindingSellerLevelSecond();
		BigDecimal sellerLevelThird = proportion.getMemberBindingSellerLevelThird();
		logger.debug("[rebate] binding seller rebate porprotion,currentSeller=" + currentSeller
				+ ",sellerlevelfirst=" + sellerLevelFirst + ",sellerLevelSecond=" + sellerLevelSecond
				+ ",sellerLevelThird=" + sellerLevelThird);
		SellerBO sellerBO = RebateTools.getMemberBindingSeller(orderUserId);
		if (null == sellerBO) {
			return resultMP;
		}
		// 会员的绑定商家 分润
		userRefereeAmount = proportion.multiply(BVAmount, currentSeller);
		AddMoneyMO addMoney = new AddMoneyMO();
		addMoney.setUserRefereeAmount(userRefereeAmount);
		addMoney.setRelateUserId(sellerBO.getUid());
		addMoney.setOrderId(orderId);
		addMoney.setOrderNo(orderNo);
		addMoney.setOrderUserId(orderUserId);
		addMoney.setSelleruserId(selleruserId);
		addMoney.setBVAmount(BVAmount);
		addMoney.setRebateType(RebateConstants.REBATE_BINDING_SELLER);
		addMoney.setUserType(MoneyUserTypeEnum.O2O);
		resultMP.put(orderNo+"_"+RebateConstants.REBATE_BINDING_SELLER, addMoney);
		// 会员绑定商家的关系层 分润
		Map<Integer, Long> userRelationMp = RebateTools.getSellerBindingOperatorLevel(3, sellerBO.getUid());
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] binding seller rebate,current seller level=" + i + ", orderUserId="
						+ orderUserId + ", bindingsellerid=" + sellerBO.getUid());
				// 未满足三层推荐关系，利润分给平台；
				break;
			}
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_BINDING_SELLER_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelFirst);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_BINDING_SELLER_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelSecond);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_BINDING_SELLER_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelThird);
					break;
				default:
					logger.warn("[rebate] binding seller rebate,current seller level not in (1,2,3,4), level="
							+ i + ", orderUserId=" + orderUserId + ", bindingsellerid=" + sellerBO.getUid());
					break;
			}
			if (StringUtils.isBlank(rebateType)) {
				continue;
			}
			addMoney = new AddMoneyMO();
			addMoney.setUserRefereeAmount(userRefereeAmount);
			addMoney.setRelateUserId(uid);
			addMoney.setOrderId(orderId);
			addMoney.setOrderNo(orderNo);
			addMoney.setOrderUserId(orderUserId);
			addMoney.setSelleruserId(selleruserId);
			addMoney.setBVAmount(BVAmount);
			addMoney.setRebateType(rebateType);
			addMoney.setUserType(MoneyUserTypeEnum.OPERATOR);
			resultMP.put(orderNo+"_"+rebateType, addMoney);
		}
		return resultMP;
	}
}
