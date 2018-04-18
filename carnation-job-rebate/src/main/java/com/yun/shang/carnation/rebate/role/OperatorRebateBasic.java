package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.Map;

import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;

public abstract class OperatorRebateBasic extends RoleRebate {
	public SellerService sellerService;
	public StoreService storeService;
	// 运营商服务
	public OperatorService operatorService;

	/**
	 * seller's rebate as binding member, into YUN_BI
	 * 
	 * @param userid
	 */
	public abstract Map<String,AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount);

	/**
	 * seller's rebate as spending member, into YUN_BI
	 * 
	 * @param userid
	 */
	public abstract Map<String,AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount);
}
