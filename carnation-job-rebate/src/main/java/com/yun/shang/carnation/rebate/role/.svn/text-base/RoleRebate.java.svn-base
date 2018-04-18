package com.yun.shang.carnation.rebate.role;

import java.math.BigDecimal;
import java.util.Map;

import com.yun.shang.carnation.rebate.constant.RebateType;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.porprotion.Proportion;

/**
 * role(member,seller,operator) rebate，base class
 * 
 * @author xing.wen
 * 
 */
public abstract class RoleRebate {
	// 配置比例
	protected Proportion proportion;
	// 云豆金额管理
	protected MoneyService moneyService;

	/**
	 * member's rebate, into YUN_BI
	 * 
	 * @param userid
	 */
	public abstract Map<String,AddMoneyMO> rebate(long orderUserId, long selleruserId, long orderId, String orderNo,
			BigDecimal BVAmount, RebateType rebatetype);
}
