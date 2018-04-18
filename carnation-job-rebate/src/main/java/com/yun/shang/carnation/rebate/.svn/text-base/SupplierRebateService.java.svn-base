package com.yun.shang.carnation.rebate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.sinco.carnation.user.service.SellerService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;
import com.yun.shang.carnation.rebate.role.CityOperatorRebate;
import com.yun.shang.carnation.rebate.role.CnOperatorRebate;
import com.yun.shang.carnation.rebate.role.DistrictOperatorRebate;
import com.yun.shang.carnation.rebate.role.MemberRebate;
import com.yun.shang.carnation.rebate.role.OperatorRebateBasic;
import com.yun.shang.carnation.rebate.role.RoleRebate;
import com.yun.shang.carnation.rebate.role.SellerRebate;
import com.yun.shang.carnation.rebate.role.SellerRebateBaisc;
import com.yun.shang.carnation.rebate.role.SupplierRebate;
import com.yun.shang.carnation.rebate.tools.RebateTools;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SupplierRebateService extends RebateServiceBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Proportion proportion;
	// 云豆服务
	private MoneyService moneyService;
	// 商家服务
	public SellerService sellerService;
	// 店铺服务
	public StoreService storeService;
	// 运营商远程服务
	private OperatorRemoteService operatorRemoteService;
	// 用户服务
	private UserAccountService userAccountService;
	private OrclService orclService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean rebate(Long sellerId, Long orderId) {
		Map<String, AddMoneyMO> rebateMP = new HashMap<String, AddMoneyMO>();
		if (sellerId == null || orderId == null) {
			logger.error("[supplier rebate]  faile, sellerId or orderId is empty, orderId=" + orderId
					+ ",sellerId=" + sellerId);
			throw new RuntimeException("parameter is error.");
		}
		OrderForm orderForm = RebateTools.getShopOrderInfo(orderId);
		if (orderForm == null) {
			return true;
		}
		Long orderUserId = orderForm.getUserId() == null ? 0 : orderForm.getUserId();
		// 订单BV（利润值）
		BigDecimal orderAddAmount = RebateTools.getShopOrderBvamout(orderId);
		String orderNo = orderForm.getOrderId();
		// 会员层面分润
		RoleRebate roleRebate = new MemberRebate(proportion, userAccountService, moneyService,
				operatorRemoteService);
		Map<String,AddMoneyMO>  memberRebateMP =roleRebate.rebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount, null);
		// 推荐会员的CN关系
		OperatorRebateBasic cnOperatorRebateBasic = new CnOperatorRebate(proportion, operatorRemoteService,
				moneyService);
		Map<String,AddMoneyMO>  cnOperatorRebateMP =cnOperatorRebateBasic.rebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount, null);
		// 商家层面分润
		SellerRebateBaisc sellerRoleRebate = new SellerRebate(proportion, moneyService);
		Map<String,AddMoneyMO>  sellerBindingRebateMP =sellerRoleRebate.bindingRebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount);
		// 运营商分润
		OperatorRebateBasic operatorRevate = new DistrictOperatorRebate(proportion, moneyService);
		Map<String,AddMoneyMO>  disOperBindingRebateMP =operatorRevate.bindingRebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount);
		// 市级运营商
		operatorRevate = new CityOperatorRebate(proportion, moneyService);
		Map<String,AddMoneyMO>  cityBindingRebateMP =operatorRevate.bindingRebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount);
		// 供应商
		sellerRoleRebate = new SupplierRebate(proportion, moneyService);
		Map<String,AddMoneyMO>  supplierRebateMP =sellerRoleRebate.rebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount, null);
		super.mergeMP(rebateMP, memberRebateMP);
		super.mergeMP(rebateMP, cnOperatorRebateMP);
		super.mergeMP(rebateMP, sellerBindingRebateMP);
		super.mergeMP(rebateMP, disOperBindingRebateMP);
		super.mergeMP(rebateMP, cityBindingRebateMP);
		super.mergeMP(rebateMP, supplierRebateMP);
		super.rebateTODB(rebateMP);
		return true;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Proportion getProportion() {
		return proportion;
	}

	public void setProportion(Proportion proportion) {
		this.proportion = proportion;
	}

	public SellerService getSellerService() {
		return sellerService;
	}

	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
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

	public OrclService getOrclService() {
		return orclService;
	}

	public void setOrclService(OrclService orclService) {
		this.orclService = orclService;
	}

	public MoneyService getMoneyService() {
		return moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}
}
