package com.yun.shang.carnation.rebate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.orcl.OrclService;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserRelationService;
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
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * 购买商品返润；
 * 
 * @param sellerId
 *            卖家店铺ID
 * @param orderId
 *            订单ID
 * @return
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class JuanPiGoodRebateService extends RebateServiceBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private int status;
	private Proportion proportion;
	// 用户推荐关系
	private UserRelationService userRelationService;
	// 运营商服务
	private OperatorService operatorService;
	// 云币服务
	private MoneyService moneyService;
	// 分润记录
	private RebateRecordService rebateRecordService;
	// 商家服务
	public SellerService sellerService;
	// 店铺服务
	public StoreService storeService;
	// 运营商远程服务
	public OperatorRemoteService operatorRemoteService;
	public OrclUserBaseService orclUserBaseService;
	private UserAccountService userAccountService;
	private AreaServiceImpl areaServiceImpl;
	private OrclService orclService;

	@Override
	public boolean rebate(Long sellerId, Long orderId) {
		return this.buyGoodsRebate(sellerId, orderId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized boolean buyGoodsRebate(Long sellerId, Long orderId) {
		Map<String, AddMoneyMO> rebateMP = new HashMap<String, AddMoneyMO>();
		if (sellerId == null || orderId == null) {
			logger.error("[juanpi good rebate]  faile, sellerId or orderId is empty, orderId=" + orderId
					+ ",sellerId=" + sellerId);
			throw new RuntimeException("parameter is error.");
		}
		JuanpiOrder juanpiOrder = RebateTools.getJuanpiOrderInfo(orderId);
		if (null == juanpiOrder) {
			return true;
		}
		Long orderUserId = juanpiOrder.getUserId() == null || juanpiOrder.getUserId() <= 0 ? 0
				: juanpiOrder.getUserId();
		if (orderUserId == 0) {
			logger.warn("[juanpi good rebate] user  is 0 order_no=" + juanpiOrder.getOrderno());
			return true;
		}
		// 订单BV（利润值）
		BigDecimal orderAddAmount = RebateTools.getJuanpiOrderBvamout(orderId, status);
		if (0 == orderAddAmount.compareTo(new BigDecimal(0))
				|| -1 == orderAddAmount.compareTo(new BigDecimal(0))) {
			logger.warn("[juanpi good rebate]  bv amount is 0 order_no=" + juanpiOrder.getOrderno());
			return true;
		}
		// 订单编号
		String orderNo = "JP" + juanpiOrder.getOrderno();
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
		// 商家层面分润
		SellerRebateBaisc sellerRoleRebate = new SellerRebate(proportion, moneyService);
		Map<String, AddMoneyMO> sellerBindingRebateMP = sellerRoleRebate.bindingRebate(orderUserId, sellerId,
				orderId, orderNo, orderAddAmount);
		// 运营商分润
		OperatorRebateBasic operatorRevate = new DistrictOperatorRebate(proportion, moneyService);
		Map<String, AddMoneyMO> disOperBindingRebateMP = operatorRevate.bindingRebate(orderUserId, sellerId,
				orderId, orderNo, orderAddAmount);
		operatorRevate = new CityOperatorRebate(proportion, moneyService);
		Map<String, AddMoneyMO> cityBindingRebateMP = operatorRevate.bindingRebate(orderUserId, sellerId,
				orderId, orderNo, orderAddAmount);
		super.mergeMP(rebateMP, memberRebateMP);
		super.mergeMP(rebateMP, cnOperatorRebateMP);
		super.mergeMP(rebateMP, sellerBindingRebateMP);
		super.mergeMP(rebateMP, disOperBindingRebateMP);
		super.mergeMP(rebateMP, cityBindingRebateMP);
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

	public UserRelationService getUserRelationService() {
		return userRelationService;
	}

	public void setUserRelationService(UserRelationService userRelationService) {
		this.userRelationService = userRelationService;
	}

	public OperatorService getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(OperatorService operatorService) {
		this.operatorService = operatorService;
	}

	public RebateRecordService getRebateRecordService() {
		return rebateRecordService;
	}

	public void setRebateRecordService(RebateRecordService rebateRecordService) {
		this.rebateRecordService = rebateRecordService;
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

	public OrclUserBaseService getOrclUserBaseService() {
		return orclUserBaseService;
	}

	public void setOrclUserBaseService(OrclUserBaseService orclUserBaseService) {
		this.orclUserBaseService = orclUserBaseService;
	}

	public UserAccountService getUserAccountService() {
		return userAccountService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public AreaServiceImpl getAreaServiceImpl() {
		return areaServiceImpl;
	}

	public void setAreaServiceImpl(AreaServiceImpl areaServiceImpl) {
		this.areaServiceImpl = areaServiceImpl;
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

	public void setStatus(int status) {
		this.status = status;
	}
}
