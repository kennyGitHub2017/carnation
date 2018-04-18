package com.yun.shang.carnation.rebate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.role.CnOperatorRebate;
import com.yun.shang.carnation.rebate.role.ElongCityOperatorRebate;
import com.yun.shang.carnation.rebate.role.ElongDistrictOperatorRebate;
import com.yun.shang.carnation.rebate.role.MemberRebate;
import com.yun.shang.carnation.rebate.role.OperatorRebateBasic;
import com.yun.shang.carnation.rebate.role.RoleRebate;
import com.yun.shang.carnation.rebate.role.SellerRebate;
import com.yun.shang.carnation.rebate.role.SellerRebateBaisc;
import com.yun.shang.carnation.rebate.tools.RebateTools;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ElongOrderRebateService extends RebateServiceBasic {
	private Proportion proportion;
	// 云豆服务
	private MoneyService moneyService;
	// 运营商远程服务
	private OperatorRemoteService operatorRemoteService;
	private UserAccountService userAccountService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean rebate(Long sellerId, Long orderId) {
		Map<String, AddMoneyMO> rebateMP = new HashMap<String, AddMoneyMO>();
		ElongOrder elongOrder = RebateTools.getElongOrderInfo(orderId);
		if (null == elongOrder) {
			return true;
		}
		Long orderUserId = elongOrder.getUserId() == null ? 0 : elongOrder.getUserId();
		// 订单BV（利润值）
		BigDecimal orderAddAmount = RebateTools.getElongOrderBVamout(orderId);
		String orderNo = String.valueOf(elongOrder.getOrderId());
		// 会员层面分润
		RoleRebate roleRebate = new MemberRebate(proportion, userAccountService, moneyService,
				operatorRemoteService);
		Map<String, AddMoneyMO> memberRebateMP = roleRebate.rebate(orderUserId, sellerId, orderId, orderNo,
				orderAddAmount, null);
		// 推荐会员的CN关系
		OperatorRebateBasic cnOperatorRebateBasic = new CnOperatorRebate(proportion, operatorRemoteService,
				moneyService);
		Map<String, AddMoneyMO> cnOperatorRebateMP = cnOperatorRebateBasic.rebate(orderUserId, sellerId,
				orderId, orderNo, orderAddAmount, null);
		// 绑定商家层面分润
		SellerRebateBaisc sellerRoleRebate = new SellerRebate(proportion, moneyService);
		Map<String, AddMoneyMO> sellerBindingRebateMP = sellerRoleRebate.bindingRebate(orderUserId, sellerId,
				orderId, orderNo, orderAddAmount);
		// 艺龙酒店区域区级运营商分润
		OperatorRebateBasic elongDistrictOperatorRebate = new ElongDistrictOperatorRebate(proportion,
				moneyService);
		Map<String, AddMoneyMO> elongdisOperBindingRebateMP = elongDistrictOperatorRebate
				.bindingRebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount);
		Map<String, AddMoneyMO> elongdisSpendingRebateMP = elongDistrictOperatorRebate.spendingRebate(orderUserId,
				sellerId, orderId, orderNo, orderAddAmount);
		// 艺龙酒店区域市级运营商分润
		OperatorRebateBasic elongCityOperatorRebate = new ElongCityOperatorRebate(proportion, moneyService);
		Map<String, AddMoneyMO> elongcityBindingRebateMP = elongCityOperatorRebate.bindingRebate(orderUserId,
				sellerId, orderId, orderNo, orderAddAmount);
		Map<String, AddMoneyMO> elongcitySpendingRebateMP = elongCityOperatorRebate.spendingRebate(orderUserId,
				sellerId, orderId, orderNo, orderAddAmount);
		super.mergeMP(rebateMP, memberRebateMP);
		super.mergeMP(rebateMP, cnOperatorRebateMP);
		super.mergeMP(rebateMP, sellerBindingRebateMP);
		super.mergeMP(rebateMP, elongdisOperBindingRebateMP);
		super.mergeMP(rebateMP, elongcityBindingRebateMP);
		super.mergeMP(rebateMP, elongdisSpendingRebateMP);
		super.mergeMP(rebateMP, elongcitySpendingRebateMP);
		super.rebateTODB(rebateMP);
		return true;
	}

	public Proportion getProportion() {
		return proportion;
	}

	public void setProportion(Proportion proportion) {
		this.proportion = proportion;
	}

	public MoneyService getMoneyService() {
		return moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

	public OperatorRemoteService getOperatorRemoteService() {
		return operatorRemoteService;
	}

	public void setOperatorRemoteService(OperatorRemoteService operatorRemoteService) {
		this.operatorRemoteService = operatorRemoteService;
	}

	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
}
