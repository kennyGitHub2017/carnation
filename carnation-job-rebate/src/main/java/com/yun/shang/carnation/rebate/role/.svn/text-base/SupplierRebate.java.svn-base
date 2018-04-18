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

public class SupplierRebate extends SellerRebateBaisc {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public SupplierRebate(Proportion proportion, MoneyService moneyService) {
		super.proportion = proportion;
		super.moneyService = moneyService;
	}

	@Override
	public Map<String,AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		return null;
	}

	@Override
	public Map<String,AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount) {
		return null;
	}

	@Override
	public Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo, BigDecimal BVAmount,
			RebateType rebatetype) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		logger.debug("[rebate] supplier seller rebate parameter ,orderUserId=" + orderUserId
				+ ",selleruserId=" + selleruserId + ",orderId=" + orderId + ",BVAmount=" + BVAmount);
		BigDecimal userRefereeAmount = null;
		BigDecimal currentSeller = proportion.getMemberSpendingSupplier();
		BigDecimal sellerLevelFirst = proportion.getMemberSpendingSupplierFirst();
		BigDecimal sellerLevelSecond = proportion.getMemberSpendingSupplierSecond();
		BigDecimal sellerLevelThird = proportion.getMemberSpendingSupplierThird();
		logger.debug("[rebate] supplier seller rebate porprotion,currentSeller=" + currentSeller
				+ ",sellerlevelfirst=" + sellerLevelFirst + ",sellerLevelSecond=" + sellerLevelSecond
				+ ",sellerLevelThird=" + sellerLevelThird);
		// 供应商推荐关系
		Map<Integer, Long> userRelationMp = RebateTools.getSupplierBindingOperatorLevel(3, selleruserId);
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] supplier seller rebate,current seller level=" + i + ", orderUserId="
						+ orderUserId + ", spendingSellerid=" + selleruserId);
				// 未满足三层推荐关系，利润分给平台；
				break;
			}
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_SUPPLIER_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelFirst);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_SUPPLIER_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelSecond);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_SUPPLIER_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, sellerLevelThird);
					break;
				default:
					logger.warn("[rebate] supplier seller rebate,current seller level not in (1,2,3), level="
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
}
