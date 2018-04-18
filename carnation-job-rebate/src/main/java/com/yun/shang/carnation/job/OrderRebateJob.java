package com.yun.shang.carnation.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.service.ElongOrderService;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.yun.shang.carnation.rebate.ElongOrderRebateService;
import com.yun.shang.carnation.rebate.RebateServiceBasic;

/**
 * 商品返润
 * 
 * @ClassName: BuyGoodsRebateJob
 * @Description: 购买商品反润
 * @author 陈舟
 * @date 2015年11月10日
 * 
 */
public class OrderRebateJob {
	private static Logger logger = LoggerFactory.getLogger(OrderRebateJob.class);
	private RebateServiceBasic o2ORebateService;
	private RebateServiceBasic selfgoodRebateService;
	private RebateServiceBasic supplierRebateService;
	private RebateServiceBasic yunGouCnRebateService;
	private RebateServiceBasic yunGouYSRebateService;
	private RebateServiceBasic uplineRebateService;
	private RebateServiceBasic couponRebateService;
	private RebateServiceBasic cashCouponRebateService;
	// 卷皮订单分利润
	private RebateServiceBasic juanPiGoodRebateService;
	private OrderFormService orderFormService;
	private GroupOrderService groupOrderService;
	// 艺龙酒店分润
	private ElongOrderService elongOrderService;
	private ElongOrderRebateService elongOrderRebateService;
	// 卷皮订单服务
	private JuanpiOrderService juanpiOrderService;

	/**
	 * 购买商品反润
	 */
	public synchronized void executeJob() {
		synchronized (logger) {
			// 020线上服务分润
			o2oOnlineRebate();
			// o2o线下刷卡分润
			o2oUplineRebate();
			// 精品专区分润
			yunGouShopRebate();
			// 商城订单分润
			shopOrderRebate();
			// 艺龙酒店分润
			elongOrderRebate();
			// 卷皮订单分利润
			juanpiOrderRebate();
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
				logger.error("[juanpi rebate] is error.", e);
			}
		}
	}

	private void elongOrderRebate() {
		try {
			List<ElongOrder> elongOrderList = elongOrderService.findRebateByElongOrderStatus();
			if (CollectionUtils.isEmpty(elongOrderList)) {
				logger.info("[elong rebate]  elong o2o order is empty.");
			}
			for (ElongOrder elongOrder : elongOrderList) {
				try {
					logger.debug("[elong rebate] elong o2o start, orderid=" + elongOrder.getOrderId());
					this.elongOrderRebateService.rebate(Long.valueOf(0), elongOrder.getOrderId());
					logger.debug("[elong rebate] elong o2o  end,excute success. orderid="
							+ elongOrder.getOrderId());
				} catch (Exception e) {
					logger.error("[elong rebate] elong o2o upline order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[elong rebate]  elong o2o upline order is error.", e);
		}
	}

	/**
	 * 代金券
	 */
//	private void o2oCashCoupon() {
//		try {
//			// o2o分润 线下刷卡服务
//			List<GroupOrder> groupOrderes = groupOrderService.findGroupOrderPayByCashCoupon();
//			if (CollectionUtils.isEmpty(groupOrderes)) {
//				logger.info("[rebate] upline group o2o order is empty.");
//			}
//			for (GroupOrder groupOrder : groupOrderes) {
//				logger.debug("[rebate] group o2o start, orderid=" + groupOrder.getOrderId());
//				this.cashCouponRebateService.rebate(groupOrder.getSellerUserId(), groupOrder.getId());
//				logger.debug("[rebate] group o2o  end,excute success. orderid=" + groupOrder.getOrderId());
//			}
//		} catch (Exception e) {
//			logger.error("[rebate] o2o upline order is   error.", e);
//		}
//	}

	/**
	 * 套餐券
	 */
//	private void o2oCoupon() {
//		try {
//			// o2o分润 线下刷卡服务
//			List<GroupOrder> groupOrderes = groupOrderService.findGroupOrderPayByCouPon();
//			if (CollectionUtils.isEmpty(groupOrderes)) {
//				logger.info("[rebate] upline group o2o order is empty.");
//			}
//			for (GroupOrder groupOrder : groupOrderes) {
//				logger.debug("[rebate] group o2o start, orderid=" + groupOrder.getOrderId());
//				this.couponRebateService.rebate(groupOrder.getSellerUserId(), groupOrder.getId());
//				logger.debug("[rebate] group o2o  end,excute success. orderid=" + groupOrder.getOrderId());
//			}
//		} catch (Exception e) {
//			logger.error("[rebate] o2o upline order is error.", e);
//		}
//	}

	private void o2oUplineRebate() {
		try {
			// o2o分润 线下刷卡服务
			List<GroupOrder> groupOrderes = groupOrderService.findGroupOrderCanPayUpline();
			if (CollectionUtils.isEmpty(groupOrderes)) {
				logger.info("[rebate] upline group o2o order is empty.");
			}
			for (GroupOrder groupOrder : groupOrderes) {
				try {
					logger.debug("[rebate] group o2o start, orderid=" + groupOrder.getOrderId());
					this.uplineRebateService.rebate(groupOrder.getSellerUserId(), groupOrder.getId());
					logger.debug(
							"[rebate] group o2o  end,excute success. orderid=" + groupOrder.getOrderId());
				} catch (Exception e) {
					logger.error("[rebate] o2o upline order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] o2o upline order is error.", e);
		}
	}

	private void o2oOnlineRebate() {
		try {
			// o2o分润 线上服务
			List<GroupOrder> groupOrderes = groupOrderService.findGroupOrderCanPayOff();
			if (CollectionUtils.isEmpty(groupOrderes)) {
				logger.info("[rebate] off group o2o order is empty.");
			}
			for (GroupOrder groupOrder : groupOrderes) {
				try {
					logger.debug("[rebate] group o2o start, orderid=" + groupOrder.getOrderId());
					this.o2ORebateService.rebate(groupOrder.getSellerUserId(), groupOrder.getId());
					logger.debug(
							"[rebate] group o2o  end,excute success. orderid=" + groupOrder.getOrderId());
				} catch (Exception e) {
					logger.error("[rebate] o2o online order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] o2o online order is error.", e);
		}
	}

	private void yunGouShopRebate() {
		// cn会员购买精品专区商品
		yunGouCNRebate();
		// 普通会员购买精品专区商品
		yunGouYSRebate();
	}

	private void yunGouYSRebate() {
		try {
			// 精品专区订单查询
			List<OrderFormBO> yunShoplist = orderFormService.findYunGouYSOrderRebateArray();
			if (CollectionUtils.isEmpty(yunShoplist)) {
				logger.info("[rebate] YUN_GOU_BI shop order is empty.");
			}
			for (OrderFormBO model : yunShoplist) {
				try {
					yunGouYSRebateService.rebate(model.getSellerUserId(), model.getId());
				} catch (Exception e) {
					logger.error("[rebate] yun order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] yun order is error.", e);
		}
	}

	private void yunGouCNRebate() {
		try {
			// 精品专区订单查询
			List<OrderFormBO> yunShoplist = orderFormService.findYunGouCNOrderRebateArray();
			if (CollectionUtils.isEmpty(yunShoplist)) {
				logger.info("[rebate] YUN_GOU_BI shop order is empty.");
			}
			for (OrderFormBO model : yunShoplist) {
				try {
					yunGouCnRebateService.rebate(model.getSellerUserId(), model.getId());
				} catch (Exception e) {
					logger.error("[rebate] yun order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] yun order is error.", e);
		}
	}

	private void shopOrderRebate() {
		try {
			logger.debug("[rebate] start.");
			// 商城订单分润（云购币订单除外）
			List<OrderFormBO> shoplist = orderFormService.findOrderCanPayOffV2();
			if (CollectionUtils.isEmpty(shoplist)) {
				logger.info("[rebate] off shop order is empty.");
			}
			for (OrderFormBO model : shoplist) {
				try {
					int orderform = model.getOrderForm();
					switch (orderform) {
						case 0:
							logger.debug("[rebate] shop start, orderid=" + model.getOrderId());
							this.supplierRebateService.rebate(model.getSellerUserId(), model.getId());
							logger.debug("[rebate] shop end,excute success. orderid=" + model.getOrderId());
							break;
						case 1:
							logger.debug("[rebate] shop start, orderid=" + model.getOrderId());
							this.selfgoodRebateService.rebate(model.getSellerUserId(), model.getId());
							logger.debug("[rebate] shop end,excute success. orderid=" + model.getOrderId());
							break;
						default:
							logger.debug("[rebate] order form error, order form=" + orderform + ",order id="
									+ model.getOrderId());
							break;
					}
				} catch (Exception e) {
					logger.error("[rebate] shop order is error.", e);
				}
			}
		} catch (Exception e) {
			logger.error("[rebate] shop order is error.", e);
		}
	}

	public RebateServiceBasic getO2ORebateService() {
		return o2ORebateService;
	}

	public void setO2ORebateService(RebateServiceBasic o2oRebateService) {
		o2ORebateService = o2oRebateService;
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

	public RebateServiceBasic getYunGouCnRebateService() {
		return yunGouCnRebateService;
	}

	public void setYunGouCnRebateService(RebateServiceBasic yunGouCnRebateService) {
		this.yunGouCnRebateService = yunGouCnRebateService;
	}

	public RebateServiceBasic getUplineRebateService() {
		return uplineRebateService;
	}

	public void setUplineRebateService(RebateServiceBasic uplineRebateService) {
		this.uplineRebateService = uplineRebateService;
	}

	public RebateServiceBasic getCouponRebateService() {
		return couponRebateService;
	}

	public void setCouponRebateService(RebateServiceBasic couponRebateService) {
		this.couponRebateService = couponRebateService;
	}

	public RebateServiceBasic getCashCouponRebateService() {
		return cashCouponRebateService;
	}

	public void setCashCouponRebateService(RebateServiceBasic cashCouponRebateService) {
		this.cashCouponRebateService = cashCouponRebateService;
	}

	public ElongOrderService getElongOrderService() {
		return elongOrderService;
	}

	public void setElongOrderService(ElongOrderService elongOrderService) {
		this.elongOrderService = elongOrderService;
	}

	public ElongOrderRebateService getElongOrderRebateService() {
		return elongOrderRebateService;
	}

	public void setElongOrderRebateService(ElongOrderRebateService elongOrderRebateService) {
		this.elongOrderRebateService = elongOrderRebateService;
	}

	public RebateServiceBasic getYunGouYSRebateService() {
		return yunGouYSRebateService;
	}

	public void setYunGouYSRebateService(RebateServiceBasic yunGouYSRebateService) {
		this.yunGouYSRebateService = yunGouYSRebateService;
	}

	public RebateServiceBasic getJuanPiGoodRebateService() {
		return juanPiGoodRebateService;
	}

	public void setJuanPiGoodRebateService(RebateServiceBasic juanPiGoodRebateService) {
		this.juanPiGoodRebateService = juanPiGoodRebateService;
	}

	public JuanpiOrderService getJuanpiOrderService() {
		return juanpiOrderService;
	}

	public void setJuanpiOrderService(JuanpiOrderService juanpiOrderService) {
		this.juanpiOrderService = juanpiOrderService;
	}
}
