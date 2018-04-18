package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.yun.shang.carnation.rebate.constant.JobConstant;
import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.tools.RebateTools;

public class MemberRebate extends RoleRebate {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// 用户的基本信息
	protected UserAccountService userAccountService;
	// 运营商远程服务
	private OperatorRemoteService operatorRemoteService;
	private static final int level = 3;

	public MemberRebate(Proportion proportion, UserAccountService userAccountService,
			MoneyService moneyService, OperatorRemoteService operatorRemoteService) {
		super.proportion = proportion;
		this.userAccountService = userAccountService;
		super.moneyService = moneyService;
		this.operatorRemoteService = operatorRemoteService;
	}

	@Override
	public Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo, BigDecimal BVAmount,
			RebateType rebatetype) {
		logger.debug(
				"[rebate] member rebate parameter ,userid=" + orderUserId + ",selleruserId=" + selleruserId
						+ ",orderId=" + orderId + ",BVAmount=" + BVAmount + ",rebatetype" + rebatetype);
		UserAccount userAccount = RebateTools.getAccount(orderUserId, "8");
		if (null != userAccount && StringUtils.isNotBlank(userAccount.getLoginName())
				&& userAccount.getLoginName().startsWith(JobConstant.OTHER_REBATE_ACCOUNT_START)) {
		    return cnMemberRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount, rebatetype);
		} else {
			// 普通会员
			return ordinaryRebate(orderUserId, selleruserId, orderId, orderNo, BVAmount, rebatetype);
		}
	}

	public  Map<String,AddMoneyMO>  cnMemberRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		UserAccount cnUserAccount = RebateTools.getAccount(orderUserId, "8");
		Map<Integer, Long> userRelationMp = operatorRemoteService
				.getNETParentLevelByCode(cnUserAccount.getLoginName());
		BigDecimal userRefereeAmount = null;
		BigDecimal memberLevelFirst = proportion.getMemberLevelFirst();
		BigDecimal memberLevelSecond = proportion.getMemberLevelSecond();
		BigDecimal memberLevelThird = proportion.getMemberLevelThird();
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if(userRelationMp==null || userRelationMp.get(i)==null){
				break;
			}
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] member rebate,current member level=" + i + ", userid=" + orderUserId
						+ ", spendingSellerid=" + selleruserId);
				break;
			}
			
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 1:
					rebateType = RebateConstants.REBATE_MEMBER_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelFirst);
					break;
				case 2:
					rebateType = RebateConstants.REBATE_MEMBER_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelSecond);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_MEMBER_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelThird);
					break;
				default:
					logger.warn("[rebate] member rebate,current member level not in (2,3,4), level=" + i
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

	/**
	 * 普通会员分利润
	 * 
	 * @param orderUserId
	 * @param selleruserId
	 * @param orderId
	 * @param orderNo
	 * @param BVAmount
	 * @param rebatetype
	 */
	private  Map<String,AddMoneyMO>  ordinaryRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype) {
		Map<String,AddMoneyMO> resultMP = new HashMap<String,AddMoneyMO>();
		BigDecimal userRefereeAmount = null;
		BigDecimal memberLevelFirst = proportion.getMemberLevelFirst();
		BigDecimal memberLevelSecond = proportion.getMemberLevelSecond();
		BigDecimal memberLevelThird = proportion.getMemberLevelThird();
		// 用户关系层 分润
		Map<Integer, Long> userRelationMp = RebateTools.getUserRecommendByLevel(level, orderUserId);
		if (null == userRelationMp) {
			return resultMP;
		}
		for (int i = 1; i <= userRelationMp.size(); i++) {
			if (!userRelationMp.containsKey(i)) {
				logger.info("[rebate] member rebate,current member level=" + i + ", userid=" + orderUserId
						+ ", spendingSellerid=" + selleruserId);
				break;
			}
			long uid = userRelationMp.get(i);
			String rebateType = null;
			switch (i) {
				case 2:
					rebateType = RebateConstants.REBATE_MEMBER_FIRST;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelFirst);
					break;
				case 3:
					rebateType = RebateConstants.REBATE_MEMBER_SECOND;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelSecond);
					break;
				case 4:
					rebateType = RebateConstants.REBATE_MEMBER_THIRD;
					userRefereeAmount = proportion.multiply(BVAmount, memberLevelThird);
					break;
				default:
					logger.warn("[rebate] member rebate,current member level not in (2,3,4), level=" + i
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
