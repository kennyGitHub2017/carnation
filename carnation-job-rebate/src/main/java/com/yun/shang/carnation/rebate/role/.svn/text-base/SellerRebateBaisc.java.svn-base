package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.Map;

import com.yun.shang.carnation.rebate.mo.AddMoneyMO;

/**
 * seller's rebate
 * 
 * @author xing.wen
 * 
 */
public abstract class SellerRebateBaisc extends RoleRebate {
	/**
	 * seller's rebate as binding member, into YUN_BI
	 * 
	 * @param userid
	 */
	public abstract  Map<String,AddMoneyMO> bindingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount);

	/**
	 * seller's rebate as spending member, into YUN_BI
	 * 
	 * @param userid
	 */
	public abstract  Map<String,AddMoneyMO> spendingRebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount);
}
