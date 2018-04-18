package com.yun.shang.carnation.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.yun.shang.carnation.rebate.RebateServiceBasic;

/**
 * 商品预分润
 * 
 * @ClassName: BuyGoodsRebateJob
 * @Description: 购买商品反润
 * @author 陈舟
 * @date 2015年11月10日
 * 
 */
public class PreOrderRebateJob {
	private static Logger logger = LoggerFactory.getLogger(PreOrderRebateJob.class);
	private RebateServiceBasic selfgoodRebateService;
	private RebateServiceBasic supplierRebateService;
	private OrderFormService orderFormService;
	private GroupOrderService groupOrderService;
	// 卷皮订单服务
	private JuanpiOrderService juanpiOrderService;
	// 卷皮订单分利润
	private RebateServiceBasic juanPiGoodRebateService;

	public synchronized void executeJob() {
		synchronized (logger) {
			try {
				logger.debug("[pre rebate] start.");
				// 商城订单预分润（云购币订单除外）
				shopOrderRebate();
				// 卷皮订单预分润
				juanpiOrderRebate();
			} catch (Exception e) {
				logger.error("[pre_rebate] order is error.", e);
				return;
			}
		}
	}

	private void juanpiOrderRebate() {
		List<JuanpiOrderBO> juanpiOrderList = juanpiOrderService.findRebateByJuanPiOrderStatus();
		if (CollectionUtils.isEmpty(juanpiOrderList)) {
			logger.info("[juanpi rebate]  juanpi order is empty.");
		}
		for (JuanpiOrder juanpiOrder : juanpiOrderList) {
			try {
				logger.debug("[juanpi rebate]shop start, orderno=" + juanpiOrder.getOrderno());
				this.juanPiGoodRebateService.rebate(Long.valueOf(0), juanpiOrder.getId());
				logger.debug("[juanpi rebate]shop end,excute success. orderno=" + juanpiOrder.getOrderno());
			} catch (Exception e) {
				logger.error("[juanpi rebate] order is error.", e);
				continue;
			}
		}
	}

	private void shopOrderRebate() {
		List<OrderFormBO> shoplist = orderFormService.findOrderCanPreRebateArray();
		if (CollectionUtils.isEmpty(shoplist)) {
			logger.info("[pre rebate] off shop order is empty.");
		}
		for (OrderFormBO model : shoplist) {
			try {
				int orderform = model.getOrderForm();
				switch (orderform) {
					case 0:
						logger.debug("[pre rebate] shop start, orderid=" + model.getOrderId());
						this.supplierRebateService.rebate(model.getSellerUserId(), model.getId());
						logger.debug("[pre rebate] shop end,excute success. orderid=" + model.getOrderId());
						break;
					case 1:
						logger.debug("[pre rebate] shop start, orderid=" + model.getOrderId());
						this.selfgoodRebateService.rebate(model.getSellerUserId(), model.getId());
						logger.debug("[pre rebate] shop end,excute success. orderid=" + model.getOrderId());
						break;
					default:
						logger.debug("[pre rebate] order form error, order form=" + orderform + ",order id="
								+ model.getOrderId());
						break;
				}
			} catch (Exception e) {
				logger.error("[shop order rebate] order is error.", e);
				continue;
			}
		}
	}

	public RebateServiceBasic getSelfgoodRebateService() {
		return selfgoodRebateService;
	}

	public void setSelfgoodRebateService(RebateServiceBasic selfgoodRebateService) {
		this.selfgoodRebateService = selfgoodRebateService;
	}

	public OrderFormService getOrderFormService() {
		return orderFormService;
	}

	public void setOrderFormService(OrderFormService orderFormService) {
		this.orderFormService = orderFormService;
	}

	public GroupOrderService getGroupOrderService() {
		return groupOrderService;
	}

	public void setGroupOrderService(GroupOrderService groupOrderService) {
		this.groupOrderService = groupOrderService;
	}

	public RebateServiceBasic getSupplierRebateService() {
		return supplierRebateService;
	}

	public void setSupplierRebateService(RebateServiceBasic supplierRebateService) {
		this.supplierRebateService = supplierRebateService;
	}

	public JuanpiOrderService getJuanpiOrderService() {
		return juanpiOrderService;
	}

	public void setJuanpiOrderService(JuanpiOrderService juanpiOrderService) {
		this.juanpiOrderService = juanpiOrderService;
	}

	public RebateServiceBasic getJuanPiGoodRebateService() {
		return juanPiGoodRebateService;
	}

	public void setJuanPiGoodRebateService(RebateServiceBasic juanPiGoodRebateService) {
		this.juanPiGoodRebateService = juanPiGoodRebateService;
	}
}
