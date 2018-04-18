package com.sinco.carnation.job.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.dao.GoodsCartDao;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.o2o.dao.GroupInfoDao;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.dao.CouponInfoDao;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.bo.IntegralGoodsCartBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.dao.EvaluateDao;
import com.sinco.carnation.shop.dao.IntegralGoodsCartDao;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.shop.dao.OrderLogDao;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.IntegralGoodsCart;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.store.dao.PayoffLogDao;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.dao.StorePointDao;
import com.sinco.carnation.store.dao.StoreStatDao;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.tools.StatTools;
import com.sinco.carnation.sys.dao.SysConfigDao;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.dao.SellerDao;

@Service
@Transactional
public class JobService {

	@Autowired
	private SysConfigDao sysConfigDAO;
	@Autowired
	private PayoffLogDao payoffLogDAO;

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	/*
	 * @ TODO
	 */
	@Autowired
	GoodsDao goodsDao;
	@Autowired
	EvaluateDao evaluateDAO;
	@Autowired
	SellerDao sellerDao;
	@Autowired
	OrderLogDao orderLogDao;
	@Autowired
	StoreDao storeDAO;
	@Autowired
	SysConfigService sysConfigService;
	@Autowired
	private StorePointDao storePointDAO;
	@Autowired
	private GoodsClassDao goodsClassDAO;
	@Autowired
	private GoodsCartDao goodsCartDAO;
	@Autowired
	private IntegralGoodsCartDao integralGoodsCartDAO;
	@Autowired
	private OrderFormDao orderFormDAO;
	@Autowired
	private CouponInfoDao couponInfoDAO;
	@Autowired
	private StoreStatDao storeStatDAO;
	@Autowired
	private StatTools statTools;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GroupInfoDao groupInfoDao;
	@Autowired
	private GroupInfoService groupInfoService;

	/**
	 * 系统零时定时任务控制器，每天00:00:01秒执行 此处已添加事务，不可使用try catch捕获异常，否则事务回滚将失效
	 * 
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public void runTimerByDay() {
//		SysConfig sysConfig = this.sysConfigService.getSysConfig();
		// 处理超过1天未登录用户并且未提交订单的购物车信息
		Calendar cal = Calendar.getInstance();
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		List<GoodsCartBO> cart_list = this.goodsCartDAO.findGoodsCartHasNotUserByTime(cal.getTime(), 0);
		if (CollectionUtils.isNotEmpty(cart_list)) {
			for (GoodsCart gc : cart_list) {
				this.goodsCartDAO.remove(gc.getId());
			}
		}
		// 处理超过7天已经登录用户未提交订单的购物车信息
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -7);
		cart_list = this.goodsCartDAO.findGoodsCartHasUserByTime(cal.getTime(), 0);
		for (GoodsCart gc : cart_list) {
			this.goodsCartDAO.remove(gc.getId());
		}
		// 处理超过7天用户未提交订单的积分商品购物车
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -7);
		List<IntegralGoodsCartBO> ig_cart_list = this.integralGoodsCartDAO.findHasNotOrderByTime(cal
				.getTime());
		for (IntegralGoodsCart igc : ig_cart_list) {
			this.integralGoodsCartDAO.remove(igc.getId());
		}
		// 系统处理最近结算日期
//		int payoff_count = sysConfig.getPayoffCount();
//		Calendar a = Calendar.getInstance();
//		a.set(Calendar.DATE, 1);
//		a.roll(Calendar.DATE, -1);
//		int allDate = a.get(Calendar.DATE);// 当月总天数
//		String selected = "";
//		if (payoff_count == 1) {
//			selected = CommUtil.null2String(allDate);
//		} else if (payoff_count == 2) {
//			if (allDate == 31) {
//				selected = "15,31";
//			}
//			if (allDate == 30) {
//				selected = "15,30";
//			}
//			if (allDate == 29) {
//				selected = "14,29";
//			}
//			if (allDate == 28) {
//				selected = "14,28";
//			}
//		} else if (payoff_count == 3) {
//			if (allDate == 31) {
//				selected = "10,20,31";
//			}
//			if (allDate == 30) {
//				selected = "10,20,30";
//			}
//			if (allDate == 29) {
//				selected = "10,20,29";
//			}
//			if (allDate == 28) {
//				selected = "10,20,28";
//			}
//		} else if (payoff_count == 4) {
//			if (allDate == 31) {
//				selected = "7,14,21,31";
//			}
//			if (allDate == 30) {
//				selected = "7,14,21,30";
//			}
//			if (allDate == 29) {
//				selected = "7,14,21,29";
//			}
//			if (allDate == 28) {
//				selected = "7,14,21,28";
//			}
//		}
//		Date payoff_data = new Date();
//		int now_date = payoff_data.getDate();
//		String str[] = selected.split(",");
//		for (String payoff_date : str) {
//			if (CommUtil.null2Int(payoff_date) >= now_date) {
//				payoff_data.setDate(CommUtil.null2Int(payoff_date));
//				payoff_data.setHours(0);
//				payoff_data.setMinutes(00);
//				payoff_data.setSeconds(01);
//				break;
//			}
//		}
//		String ms = "";
//		for (int i = 0; i < str.length; i++) {
//			if (i + 1 == str.length) {
//				ms = ms + str[i] + "日";
//			} else {
//				ms = ms + str[i] + "日、";
//			}
//		}
//		ms = "今天是" + DateFormat.getDateInstance(DateFormat.FULL).format(new Date()) + "，本月的结算日期为" + ms + "，请于结算日申请结算。";
//		sysConfig.setPayoffMagDefault(ms);
//		sysConfig.setPayoffDate(payoff_data);
//		this.sysConfigDAO.update(sysConfig);
//		List<PayoffLogBO> payofflogs_1 = this.payoffLogDAO.selectPayoffLogNearest(1, null);// 查询所有可结算账单，设置为未结算账单，可以防止上次结算日没有结算的账单在结算日之后的日期结算
//		for (PayoffLog temp : payofflogs_1) {
//			temp.setStatus(0);
//			this.payoffLogDAO.update(temp);
//		}
//		List<PayoffLogBO> payofflogs = this.payoffLogDAO.selectPayoffLogNearest(1, sysConfig.getPayoffDate());// 结算日之前的所有未结算账单
//		for (PayoffLog obj : payofflogs) {
//			OrderForm of = this.orderFormDAO.get(CommUtil.null2Long(obj.getoId()));
//			Date Payoff_date = this.sysConfigService.getSysConfig().getPayoffDate();
//			Date now = new Date();
//			now.setHours(0);
//			now.setMinutes(0);
//			now.setSeconds(0);
//			Date next = new Date();
//			next.setDate(next.getDate() + 1);
//			next.setHours(0);
//			next.setMinutes(0);
//			next.setSeconds(0);
//			boolean payoff = false;// 当天是否为结算日期
//			if (Payoff_date.after(now) && Payoff_date.before(next)) {
//				payoff = true;
//			}
//			if (of.getOrderCat() == 2) {
//				if (of.getOrderStatus() == 20 && payoff) {// 团购消费码订单
//					obj.setStatus(1);// 设置当天可结算的账单
//				}
//			}
//			if (of.getOrderCat() == 0) {
//				if (of.getOrderStatus() >= 40 && payoff) {// 账单对应订单已经评价完成或者不可评价时
//					obj.setStatus(1);// 设置当天可结算的账单
//				}
//				if (obj.getPayoffType() == -1) {// 账单为退款账单，系统自动判定该退款账单为申请状态
//					if (of.getOrderStatus() >= 40 && payoff) {// 账单对应订单已经评价完成或者不可评价时
//						obj.setStatus(3);
//						obj.setApplyTime(new Date());
//					}
//				}
//			}
//			this.payoffLogDAO.update(obj);
//		}
		// 处理已经过期的优惠券
		List<CouponInfoBO> couponInfos = this.couponInfoDAO.findHasIsOver(0, new Date());
		for (CouponInfo couponInfo : couponInfos) {
			couponInfo.setStatus(-1);
			couponInfoDAO.update(couponInfo);
		}

	}

	/**
	 * 系统半小时定时任务控制器，每半小时运行一次 此处已添加事务，不可使用try catch捕获异常，否则事务回滚将失效
	 * 自动收货 统计店铺评分 统计商品评分
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void runTimerByHalfhour() throws Exception {
		// 统计信息
		SysConfig sc = this.sysConfigService.getSysConfig();
//		List<StoreStatBO> stats = this.storeStatDAO.findAll();
//		StoreStat stat = null;
//		if (stats.size() > 0) {
//			stat = stats.get(0);
//		} else {
//			stat = new StoreStat();
//		}
//		stat.setAddTime(new Date());
		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.MINUTE, 30);
//		stat.setNextTime(cal.getTime());
//		stat.setWeekComplaint(this.statTools.query_complaint(-7));
//		stat.setWeekGoods(this.statTools.query_goods(-7));
//		stat.setWeekOrder(this.statTools.query_order(-7));
//		stat.setWeekStore(this.statTools.query_store(-7));
//		stat.setWeekUser(this.statTools.query_user(-7));
////		stat.setWeekLiveUser(this.statTools.query_live_user(-7));
////		stat.setWeekZtc(this.statTools.query_ztc(-7));
////		stat.setWeekDelivery(this.statTools.query_delivery(-7));
////		stat.setWeekInformation(this.statTools.query_information(-7));
////		stat.setWeekInvitation(this.statTools.query_invitation(-7));
////		stat.setWeekCircle(this.statTools.query_circle(-7));
//		stat.setAllGoods(this.statTools.query_all_goods());
//		stat.setAllStore(this.statTools.query_all_store());
//		stat.setAllUser(this.statTools.query_all_user());
//		stat.setStoreAudit(this.statTools.query_audit_store());
//		stat.setOrderAmount(this.statTools.query_all_amount());
//		stat.setNotPayoffNum(this.statTools.query_payoff());
//		stat.setNotRefund(this.statTools.query_refund());
////		stat.setNotGrouplifeRefund(this.statTools.query_grouplife_refund());
//		stat.setAllSaleAmount(CommUtil.null2Int(sc.getPayoffAllSale()));
//		stat.setAllCommissionAmount(CommUtil.null2Int(sc.getPayoffAllCommission()));
//		stat.setAllPayoffAmount(CommUtil.null2Int(sc.getPayoffAllAmount()));
//		stat.setAllPayoffAmountReality(CommUtil.null2Int(sc.getPayoffAllAmountReality()));
//		stat.setAllUserBalance(this.statTools.query_all_user_balance());
////		stat.setZtcAuditCount(this.statTools.query_ztc_audit());
////		stat.setDeliveryAuditCount(this.statTools.query_delivery_audit());
////		stat.setInformationAuditCount(this.statTools.query_information_audit());
//		stat.setSelfGoods(this.statTools.query_self_goods());
//		stat.setSelfStorageGoods(this.statTools.query_self_storage_goods());
//		stat.setSelfOrderShipping(this.statTools.query_self_order_shipping());
//		stat.setSelfOrderPay(this.statTools.query_self_order_pay());
//		stat.setSelfOrderEvaluate(this.statTools.query_self_order_evaluate());
//		stat.setSelfAllOrder(this.statTools.query_self_all_order());
//		stat.setSelfReturnApply(this.statTools.query_self_return_apply());
////		stat.setSelfGrouplifeRefund(this.statTools.query_self_groupinfo_return_apply());
//		stat.setGoodsAudit(this.statTools.query_goods_audit());
//		stat.setSelfGoodsConsult(this.statTools.query_self_consult());
////		stat.setSelfActivityGoods(this.statTools.query_self_activity_goods());
////		stat.setSelfGroupGoods(this.statTools.query_self_group_goods());
////		stat.setSelfGroupLife(this.statTools.query_self_group_life());
////		stat.setSelfFreeGoods(this.statTools.query_self_free_goods());
//		if (stats.size() > 0) {
//			this.storeStatDAO.update(stat);
//		} else
//			this.storeStatDAO.save(stat);
////		// 删除验证码信息
////		cal.setTime(new Date());
////		cal.add(Calendar.MINUTE, -30);
////		Map params = new HashMap();
////		params.put("time", cal.getTime());
////		List<Serializable> mvcs = this.mobileVerifyCodeDAO.query(
////				"select obj.id from VerifyCode obj where obj.addTime<=:time",
////				params, -1, -1);
////		for (Serializable id : mvcs) {
////			this.mobileVerifyCodeDAO.remove((Long) id);
////		}

		// 统计店铺的评分信息
		List<GoodsClassBO> gcs = this.goodsClassDAO.findParnetIsNull();
		for (GoodsClass gc : gcs) {
			double description_evaluate = 0;
			double service_evaluate = 0;
			double ship_evaluate = 0;
			// 只查询正常营业且主营类目一致的店铺评分
			List<StorePoint> sp_list = this.storePointDAO.selectPointByStoreGcAndStatus(gc.getId(), 15);
			for (StorePoint sp : sp_list) {
				description_evaluate = CommUtil.add(description_evaluate, sp.getDescriptionEvaluate());
				service_evaluate = CommUtil.add(service_evaluate, sp.getServiceEvaluate());
				ship_evaluate = CommUtil.add(ship_evaluate, sp.getShipEvaluate());
			}
			gc.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil.div(description_evaluate, sp_list.size())));
			gc.setServiceEvaluate(BigDecimal.valueOf(CommUtil.div(service_evaluate, sp_list.size())));
			gc.setShipEvaluate(BigDecimal.valueOf(CommUtil.div(ship_evaluate, sp_list.size())));
			this.goodsClassDAO.update(gc);
		}
		// 检测默认自动收货的订单信息
		int auto_order_confirm = sc.getAutoOrderConfirm();
		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -auto_order_confirm);
		List<OrderFormBO> confirm_ofs = this.orderFormDAO.selectOrderFormByStatusAndShipTime(cal.getTime(),
				30);
		for (OrderForm of : confirm_ofs) {
			OrderFormBO ofTemp = orderFormService.fetch(of.getId());
			orderFormService.orderCofirmSaveCom(null, null, ofTemp);;
//			cal.setTime(of.getShipTime());
//			cal.add(Calendar.DAY_OF_YEAR, auto_order_confirm + of.getOrderConfirmDelay());// 计算最初发货日期、系统默认收货时长、延长收货时间综合计算后，是否已经在自动收货时间段
//			if (cal.getTime().before(new Date())) {
//				of.setOrderStatus(40);// 自动确认收货
//				this.orderFormDAO.update(of);
//
//				Store store = this.storeDAO.get(CommUtil.null2Long(of.getStoreId()));
//				OrderLog ofl = new OrderLog();
//				ofl.setAddTime(new Date());
//				ofl.setLogInfo("确认收货");
////				ofl.setLogUser(SecurityUserHolder.getCurrentUser());
//				ofl.setOfId(of.getId());
//				this.orderLogDao.save(ofl);
////				if (sc.getEmailEnable() && of.getOrderForm() == 0) {
////					this.send_email(of, "email_toseller_order_receive_ok_notify");
////				}
////				if (sc.isSmsEnbale() && of.getOrder_form() == 0) {
////					this.send_sms(of, store.getUser().getMobile(), "sms_toseller_order_receive_ok_notify");
////				}
////				if (of.getPayment().getMark().equals("payafter")) {// 如果买家支付方式为货到付款，买家确认收货时更新商品库存
////					this.update_goods_inventory(of);// 更新商品库存
////				}
//				// 自动生成结算日志
//				if (of.getOrderForm() == 0) {// 商家订单生成结算日志,这里查询的是所有订单信息，不需要区分主订单及从订单信息
//					PayoffLog plog = new PayoffLog();
//					Seller seller = sellerDao.findByStore(store.getId());
//					plog.setPlSn("pl" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + seller.getUid());
//					plog.setPlInfo("订单到期自动收货");
//					plog.setAddTime(new Date());
//					plog.setSellerId(seller.getUid());
//					plog.setoId(CommUtil.null2String(of.getId()));
//					plog.setOrderId(of.getOrderId().toString());
//					plog.setCommissionAmount(of.getCommissionAmount());// 该订单总佣金费用
//					plog.setGoodsInfo(of.getGoodsInfo());
//					plog.setOrderTotalPrice(of.getGoodsAmount());// 该订单总商品金额
//					plog.setTotalAmount(BigDecimal.valueOf(CommUtil.subtract(of.getGoodsAmount(), of.getCommissionAmount())));// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
//					this.payoffLogDAO.save(plog);
//					store.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.add(of.getGoodsAmount(), store.getStoreSaleAmount())));// 店铺本次结算总销售金额
//					store.setStoreCommissionAmount(BigDecimal.valueOf(CommUtil.add(of.getCommissionAmount(), store.getStoreCommissionAmount())));// 店铺本次结算总佣金
//					store.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.add(plog.getTotalAmount(), store.getStorePayoffAmount())));// 店铺本次结算总佣金
//					this.storeDAO.update(store);
//					// 增加系统总销售金额、总佣金
//					sc.setPayoffAllSale(BigDecimal.valueOf(CommUtil.add(of.getGoodsAmount(), sc.getPayoffAllSale())));
//					sc.setPayoffAllCommission(BigDecimal.valueOf(CommUtil.add(of.getCommissionAmount(), sc.getPayoffAllCommission())));
//					this.sysConfigDAO.update(sc);
//				}
//			}
		}
//		// 到达设定时间，系统自动关闭订单相互评价功能
//		int auto_order_evaluate = sc.getAuto_order_evaluate();
//		cal = Calendar.getInstance();
//		params.clear();
//		cal.add(Calendar.DAY_OF_YEAR, -auto_order_evaluate);
//		params.put("auto_order_evaluate", cal.getTime());
//		params.put("order_status_40", 40);
//		List<OrderForm> confirm_evaluate_ofs = this.orderFormDAO
//				.query("select obj from OrderForm obj where obj.confirmTime<=:auto_order_evaluate and obj.order_status=:order_status_40 order by addTime asc",
//						params, -1, -1);
//		for (OrderForm order : confirm_evaluate_ofs) {
//			order.setOrder_status(65);
//			this.orderFormDAO.update(order);
//
//			User user = this.userDAO
//					.get(CommUtil.null2Long(order.getUser_id()));
//			// 增加消费金额
//			user.setUser_goods_fee(BigDecimal.valueOf(CommUtil.add(
//					user.getUser_goods_fee(), order.getTotalPrice())));
//			this.userDAO.update(user);
//		}
//		// 申请退货后到达设定时间，未能输入退货物流单号和物流公司
//		int auto_order_return = sc.getAuto_order_return();
//		cal = Calendar.getInstance();
//		params.clear();
//		cal.add(Calendar.DAY_OF_YEAR, -auto_order_return);
//		params.put("return_shipTime", cal.getTime());
//		params.put("order_status", 40);
//		List<OrderForm> confirm_return_ofs = this.orderFormDAO
//				.query("select obj from OrderForm obj where obj.return_shipTime<=:return_shipTime and obj.order_status>=:order_status",
//						params, -1, -1);
//		for (OrderForm order : confirm_return_ofs) {
//			List<Map> maps = this.orderFormTools.queryGoodsInfo(order
//					.getGoods_info());
//			List<Map> new_maps = new ArrayList<Map>();
//			Map gls = new HashMap();
//			for (Map m : maps) {
//				m.put("goods_return_status", -1);
//				gls.putAll(m);
//				new_maps.add(m);
//			}
//			order.setGoods_info(Json.toJson(new_maps));
//			this.orderFormDAO.update(order);
//			Map rgl_params = new HashMap();
//			rgl_params.put("goods_return_status", "-2");
//			rgl_params.put("return_order_id", order.getId());
//			List<ReturnGoodsLog> rgl = this.returnGoodsLogDAO
//					.query("select obj from ReturnGoodsLog obj where obj.goods_return_status is not :goods_return_status and obj.return_order_id=:return_order_id",
//							rgl_params, -1, -1);
//			for (ReturnGoodsLog r : rgl) {
//				r.setGoods_return_status("-2");
//				this.returnGoodsLogDAO.update(r);
//			}
//			// 增加购物积分
//			int user_integral = (int) CommUtil.div(order.getTotalPrice(),
//					sc.getConsumptionRatio());
//			if (user_integral > sc.getEveryIndentLimit()) {
//				user_integral = sc.getEveryIndentLimit();
//			}
//			User orderUser = this.userDAO.get(CommUtil.null2Long(order
//					.getUser_id()));
//			orderUser.setIntegral(orderUser.getIntegral() + user_integral);
//			// 记录积分明细
//			if (sc.isIntegral()) {
//				IntegralLog log = new IntegralLog();
//				log.setAddTime(new Date());
//				log.setContent("购物增加" + user_integral + "分");
//				log.setIntegral(user_integral);
//				log.setIntegral_user(orderUser);
//				log.setType("order");
//				this.integralLogDao.save(log);
//			}
//		}
		// 统计所有商品的评分信息
		List<Long> goods_list = this.evaluateDAO.selectDistinctGoodsId();
		for (Long goodsId : goods_list) {
			Goods goods = goodsDao.findOne(goodsId);
			if(goods == null){
				break;
			}
			// 统计所有商品的描述相符评分
			double description_evaluate = 0;
			List<Evaluate> eva_list = this.evaluateDAO.selectEvaluateByGoodsId(goodsId);
			for (Evaluate eva : eva_list) {
				description_evaluate = CommUtil.add(eva.getDescriptionEvaluate(), description_evaluate);
			}
			description_evaluate = CommUtil.div(description_evaluate, eva_list.size());
			goods.setDescriptionEvaluate(CommUtil.null2Long(description_evaluate));
			if (eva_list.size() > 0) {// 商品有评价情况下
				// 统计所有商品的好评率
				double well_evaluate = 0;
				List<Evaluate> well_list = this.evaluateDAO.selectEvaluateByAndBuyerGoodsId(goodsId, 1);
				well_evaluate = CommUtil.div(well_list.size(), eva_list.size());
				goods.setWellEvaluate(BigDecimal.valueOf(well_evaluate));
				// 统计所有商品的中评率
				double middle_evaluate = 0;
				List<Evaluate> middle_list = this.evaluateDAO.selectEvaluateByAndBuyerGoodsId(goodsId, 0);
				middle_evaluate = CommUtil.div(middle_list.size(), eva_list.size());
				goods.setMiddleEvaluate(BigDecimal.valueOf(middle_evaluate));
				// 统计所有商品的差评率
				double bad_evaluate = 0;
				List<Evaluate> bad_list = this.evaluateDAO.selectEvaluateByAndBuyerGoodsId(goodsId, -1);
				bad_evaluate = CommUtil.div(bad_list.size(), eva_list.size());
				goods.setBadEvaluate(BigDecimal.valueOf(bad_evaluate));
			}
			this.goodsDao.update(goods);
		}
	}

//	/**
//	 * 更新商品库存
//	 *
//	 * @param order
//	 */
//	private void update_goods_inventory(OrderForm order) {
//		// 付款成功，订单状态更新，同时更新商品库存，如果是团购商品，则更新团购库存
//		List<Goods> goods_list = this.orderFormTools.queryOfGoods(CommUtil
//				.null2String(order.getId()));
//		for (Goods goods : goods_list) {
//			int goods_count = this.orderFormTools.queryOfGoodsCount(
//					CommUtil.null2String(order.getId()),
//					CommUtil.null2String(goods.getId()));
//			if (goods.getGroup() != null && goods.getGroup_buy() == 2) {
//				for (GroupGoods gg : goods.getGroup_goods_list()) {
//					if (gg.getGroup().getId().equals(goods.getGroup().getId())) {
//						gg.setGg_count(gg.getGg_count() - goods_count);
//						this.groupGoodsDAO.update(gg);
//						// 更新lucene索引
//						String goods_lucene_path = System
//								.getProperty("user.dir")
//								+ File.separator
//								+ "luence" + File.separator + "groupgoods";
//						File file = new File(goods_lucene_path);
//						if (!file.exists()) {
//							CommUtil.createFolder(goods_lucene_path);
//						}
//						//LuceneUtil lucene = LuceneUtil.instance();
//						//lucene.setIndex_path(goods_lucene_path);
//						luceneUtil.update(CommUtil.null2String(goods.getId()),
//								luceneVoTools.updateGroupGoodsIndex(gg));
//					}
//				}
//			}
//			List<String> gsps = new ArrayList<String>();
//			List<GoodsSpecProperty> temp_gsp_list = this.orderFormTools
//					.queryOfGoodsGsps(CommUtil.null2String(order.getId()),
//							CommUtil.null2String(goods.getId()));
//			String spectype = "";
//			for (GoodsSpecProperty gsp : temp_gsp_list) {
//				gsps.add(gsp.getId().toString());
//				spectype += gsp.getSpec().getName() + ":" + gsp.getValue()
//						+ " ";
//			}
//			String[] gsp_list = new String[gsps.size()];
//			gsps.toArray(gsp_list);
//			goods.setGoods_salenum(goods.getGoods_salenum() + goods_count);
//			GoodsLog todayGoodsLog = this.goodsViewTools.getTodayGoodsLog(goods
//					.getId());
//			todayGoodsLog.setGoods_salenum(todayGoodsLog.getGoods_salenum()
//					+ goods_count);
//			Map<String, Integer> logordermap = (Map<String, Integer>) Json
//					.fromJson(todayGoodsLog.getGoods_order_type());
//			String ordertype = order.getOrder_type();
//			if (logordermap.containsKey(ordertype)) {
//				logordermap.put(ordertype, logordermap.get(ordertype)
//						+ goods_count);
//			} else {
//				logordermap.put(ordertype, goods_count);
//			}
//			todayGoodsLog.setGoods_order_type(Json.toJson(logordermap,
//					JsonFormat.compact()));
//
//			Map<String, Integer> logspecmap = (Map<String, Integer>) Json
//					.fromJson(todayGoodsLog.getGoods_sale_info());
//
//			if (logspecmap.containsKey(spectype)) {
//				logspecmap
//						.put(spectype, logspecmap.get(spectype) + goods_count);
//			} else {
//				logspecmap.put(spectype, goods_count);
//			}
//			todayGoodsLog.setGoods_sale_info(Json.toJson(logspecmap,
//					JsonFormat.compact()));
//
//			this.goodsLogDAO.update(todayGoodsLog);
//			String inventory_type = goods.getInventory_type() == null ? "all"
//					: goods.getInventory_type();
//			if (inventory_type.equals("all")) {
//				goods.setGoods_inventory(goods.getGoods_inventory()
//						- goods_count);
//			} else {
//				List<HashMap> list = Json
//						.fromJson(ArrayList.class, CommUtil.null2String(goods
//								.getGoods_inventory_detail()));
//				for (Map temp : list) {
//					String[] temp_ids = CommUtil.null2String(temp.get("id"))
//							.split("_");
//					Arrays.sort(temp_ids);
//					Arrays.sort(gsp_list);
//					if (Arrays.equals(temp_ids, gsp_list)) {
//						temp.put("count", CommUtil.null2Int(temp.get("count"))
//								- goods_count);
//					}
//				}
//				goods.setGoods_inventory_detail(Json.toJson(list,
//						JsonFormat.compact()));
//			}
//			for (GroupGoods gg : goods.getGroup_goods_list()) {
//				if (gg.getGroup().getId().equals(goods.getGroup().getId())
//						&& gg.getGg_count() == 0) {
//					goods.setGroup_buy(3);// 标识商品的状态为团购数量已经结束
//				}
//			}
//			this.goodsDAO.update(goods);
//			// 更新lucene索引
//			String goods_lucene_path = System.getProperty("thinkervcb2b2c.root")
//					+ File.separator + "luence" + File.separator + "goods";
//			File file = new File(goods_lucene_path);
//			if (!file.exists()) {
//				CommUtil.createFolder(goods_lucene_path);
//			}
//			//LuceneUtil lucene = LuceneUtil.instance();
//			//lucene.setIndex_path(goods_lucene_path);
//			luceneUtil.update(CommUtil.null2String(goods.getId()),
//					luceneVoTools.updateGoodsIndex(goods));
//		}
//
//	}

}
