package com.yun.shang.carnation.rebate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.sys.service.UserAccountService;
import com.yun.shang.carnation.rebate.mo.AddMoneyMO;
import com.yun.shang.carnation.rebate.money.MoneyService;
import com.yun.shang.carnation.rebate.role.YunOrderRebate;
import com.yun.shang.carnation.rebate.tools.RebateTools;

/**
 * CN会员精选专区购买分润
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class YunGouCNRebateService extends RebateServiceBasic {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private CnPayBaseService cnPayBaseService;
	private UserAccountService accountService;
	private MoneyService moneyService;
	private OrderFormService orderFormService;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public boolean rebate(Long sellerId, Long orderId) {
		Map<String, AddMoneyMO> rebateMP = new HashMap<String, AddMoneyMO>();
		OrderForm orderForm = RebateTools.getShopOrderInfo(orderId);
		if (orderForm == null) {
			logger.warn("[rebate] this order number is not in db.order id = " + orderId);
			return true;
		}
		Long orderUserId = orderForm.getUserId() == null ? 0 : orderForm.getUserId();
		BigDecimal orderAddAmount = orderForm.getCommissionAmount();
		String orderNo = orderForm.getOrderId();
		YunOrderRebate yunOrderRebate = new YunOrderRebate(cnPayBaseService, accountService, moneyService,
				orderFormService);
		Map<String,AddMoneyMO>  yunRebateMP =yunOrderRebate.rebate(orderUserId, sellerId, orderId, orderNo, orderAddAmount, null);
		super.mergeMP(rebateMP, yunRebateMP);
		super.rebateTODB(rebateMP);
		return true;
	}

	public CnPayBaseService getCnPayBaseService() {
		return cnPayBaseService;
	}

	public void setCnPayBaseService(CnPayBaseService cnPayBaseService) {
		this.cnPayBaseService = cnPayBaseService;
	}

	public UserAccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	public MoneyService getMoneyService() {
		return moneyService;
	}

	public void setMoneyService(MoneyService moneyService) {
		this.moneyService = moneyService;
	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}
}
