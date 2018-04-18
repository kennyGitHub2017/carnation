package com.sinco.carnation.refund.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.shop.dao.RefundLogDao;
import com.sinco.carnation.shop.dao.ShopBonusRepeatLogDao;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.RefundLog;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.shop.tools.PayoffLogTools;
import com.sinco.carnation.shop.vo.RefundLogVO;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.sys.bo.orcl.CnUserRefundBO;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class RefundLogService {
	@Autowired
	private RefundLogDao refundLogDao;
	@Autowired
	private UserMoneyDao userMoneyDao;
	@Autowired
	private PredepositLogService predepositLogService;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;
	@Autowired
	OrderFormService orderFormService;
	@Autowired
	GoodsService goodsService;
	@Autowired
	SellerService sellerService;
	@Autowired
	StoreDao storeDao;
	@Autowired
	PayoffLogService payoffLogService;
	@Autowired
	MessageService messageService;
	@Autowired
	SysConfigService configService;
	@Autowired
	UserMoneyService userMoneyService;
	@Autowired
	PayoffLogTools payofflogTools;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private ShopBonusRepeatLogDao shopBonusRepeatLogDao;

	public boolean save(RefundLog refundLog) {
		/**
		 * init other field here
		 */
		try {
			this.refundLogDao.save(refundLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public RefundLog getObjById(Long id) {
		RefundLog refundLog = this.refundLogDao.get(id);
		if (refundLog != null) {
			return refundLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.refundLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public List<Map> search(RefundLogVO vo, MyPage<Map> page) {
		return refundLogDao.search(vo, page);
	}

	public boolean batchDelete(List<Serializable> refundLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : refundLogIds) {
			delete((Long) id);
		}
		return true;
	}

	/**
	 * 退款操作
	 * 
	 * @param user_id
	 * @param amount
	 * @param type
	 * @param info
	 * @param list_url
	 * @param refund_user_id
	 * @param obj_id
	 * @param gi_id
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Transactional(rollbackFor = {Exception.class})
	public void refunding(String user_id, String amount, String info, String refund_user_id, String obj_id,
			long currUserId) {

		BigDecimal amountBig = BigDecimal.valueOf(CommUtil.null2Double(amount));

		userMoneyService.addMoney(Long.parseLong(user_id), amountBig.doubleValue(), currUserId,
				UserContants.PD_OP_TYPE_MANUAL_OPERATION, info);

//		userMoneyDao.addMoney(currUserId, Double.parseDouble(amount));
//		
//		// 保存退款日志
//		PredepositLog log = new PredepositLog();
//		log.setPdLogAdminId(currUserId);
//		log.setAddTime(new Date());
//		log.setPdLogAmount(BigDecimal.valueOf(CommUtil.null2Double(amount)));
//		log.setPdLogInfo(info);
//		log.setPdLogUserId(Long.parseLong(user_id));
//		log.setPdOpType("人工退款");
//		log.setPdType("可用预存款");
//		predepositLogService.save(log);
		if (obj_id != null && !obj_id.equals("")) {// 商品退款
			ReturnGoodsLog rgl = returnGoodsLogService.getObjById(CommUtil.null2Long(obj_id));
			rgl.setRefundStatus(1);
			rgl.setGoodsReturnStatus("11");// 平台退款完成
			this.returnGoodsLogService.update(rgl);
			RefundLog r_log = new RefundLog();
			r_log.setAddTime(new Date());
			r_log.setRefundId(CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + user_id);
			r_log.setReturnLogId(rgl.getId());
			r_log.setReturnServiceId(rgl.getReturnServiceId());
			r_log.setRefund(amountBig);
			r_log.setRefundLog(info);
			r_log.setRefundType("云豆");
			r_log.setRefundUserId(currUserId);
			r_log.setReturnLogUserName(rgl.getUserName());
			r_log.setReturnLogUserId(rgl.getUserId());
			save(r_log);
			OrderForm of = orderFormService.getObjById(rgl.getReturnOrderId());
			Goods goods = goodsService.getObjById(rgl.getGoodsId());
			// 如果为自营商品时不添加结算日志，只有第三方经销商的商品才有结算日志
			if (goods.getGoodsType() == 1) {

				// 先查出该订单的结算信息
				PayoffLogBO oldPayoffLog = payoffLogService.selectBOByOidAndOrderId(
						CommUtil.null2String(rgl.getReturnOrderId()), of.getOrderId());

				List<Map> retrunGoodsInfoList = new ArrayList<>();
				if (StringUtils.isNotEmpty(oldPayoffLog.getReturnGoodsInfo())) {
					retrunGoodsInfoList = payofflogTools.queryGoodsInfo(oldPayoffLog.getReturnGoodsInfo());
				}

				long storeId = goodsService.getObjById(rgl.getGoodsId()).getGoodsStoreId();
				Store store = storeDao.get(storeId);
				PayoffLog pol = new PayoffLog();
				pol.setRefundUserId(rgl.getUserId());
				pol.setRefundUserName(rgl.getUserName());
				pol.setReturnServiceId(rgl.getReturnServiceId());
				BigDecimal price = amountBig; // 商品的原价,目前等于自定义退款金额
				// 已改为平台加价 * 退货数量（原：商品的佣金比例）
				BigDecimal mission = new BigDecimal(CommUtil.mul(rgl.getGoodsCount(),
						rgl.getGoodsCommissionRate()));
				// 0 -（退款金额 - 平台总加价）
				BigDecimal final_money = BigDecimal.valueOf(CommUtil.subtract(0,
						CommUtil.subtract(price, mission)));
				Map json = new HashMap();
				json.put("goods_id", rgl.getGoodsId());
				json.put("goods_name", rgl.getGoodsName());
				json.put("goods_price", rgl.getGoodsPrice());
				json.put("goods_mainphoto_path", rgl.getGoodsMainphotoPath());
				json.put("goods_commission_rate", rgl.getGoodsCommissionRate());
				json.put("goods_count", rgl.getGoodsCount());
				json.put("goods_all_price", rgl.getGoodsAllPrice());
				json.put("goods_commission_price", mission.doubleValue());
				json.put("goods_payoff_price", final_money);
				retrunGoodsInfoList.add(json);
				pol.setReturnGoodsInfo(Json.toJson(retrunGoodsInfoList, JsonFormat.compact()));
				pol.setoId(CommUtil.null2String(rgl.getReturnOrderId()));
				pol.setOrderId(of.getOrderId());
//				pol.setCommissionAmount(BigDecimal.valueOf(0));
//				pol.setOrderTotalPrice(final_money);
				// 先不这样结算payoffLogService.save(pol);

				// 计算该计算金额，销售金额
				BigDecimal oldCommissionAmount = oldPayoffLog.getCommissionAmount(); // 结算账单总佣金
				BigDecimal oldTotlePrice = oldPayoffLog.getOrderTotalPrice(); // 对应订单商品总金额
				BigDecimal oldTotleAmount = oldPayoffLog.getTotalAmount(); // 结算金额
				BigDecimal oldReturnMoney = oldPayoffLog.getReturnAmount(); // 退款金额

				pol.setCommissionAmount(oldCommissionAmount.subtract(mission));
				pol.setOrderTotalPrice(oldTotlePrice.subtract(price));
				pol.setTotalAmount(oldTotleAmount.add(final_money));
				pol.setReturnAmount(oldReturnMoney.add(price));

				payoffLogService.updateByOrderIdAndOid(pol);

				storeDao.addStoreAmount(BigDecimal.ZERO.subtract(mission), final_money, new BigDecimal(
						-Double.parseDouble(amount)), store.getId());
//				
//				store.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStoreSaleAmount(), amount)));// 减少店铺本次结算总销售金额
//				store.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStorePayoffAmount(), CommUtil.mul(price, mission))));// 减少店铺本次结算总金额
//				storeService.update(store);
				// 减少系统总销售金额、总结算金额
//				SysConfig sc = configService.getSysConfig();
//				sc.setPayoffAllSale(BigDecimal.valueOf(CommUtil.subtract(sc.getPayoffAllSale(), amount)));
//				sc.setPayoffAllAmount(BigDecimal.valueOf(CommUtil.subtract(sc.getPayoffAllAmount(), CommUtil.mul(price, mission))));
//				sc.setPayoffAllAmountReality(BigDecimal.valueOf(CommUtil.add(pol.getRealityAmount(), sc.getPayoffAllAmountReality())));// 增加系统实际总结算
//				this.configService.addConfigAmount(obj.getTotalAmount(), obj.getRealityAmount(), null, new BigDecimal(amount)));
				this.configService
						.addConfigAmount(null, null, BigDecimal.ZERO.subtract(mission), final_money);
			}
			String msg_content = "成功为订单号：" + of.getOrderId() + "退款" + amount + "元，请到收支明细中查看。";
			// 发送系统站内信
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setStatus(0);
			msg.setType(0);
			msg.setContent(msg_content);
			msg.setFromUserId(currUserId);
			msg.setToUserId(Long.parseLong(user_id));
			messageService.save(msg);
		}
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(RefundLog.class,construct, query,
//				params, this.refundLogDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
//						.getCurrentPage(), pageObj.getPageSize() == null ? 0
//						: pageObj.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(RefundLog refundLog) {
		try {
			this.refundLogDao.update(refundLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<RefundLog> query(String query, Map params, int begin, int max){
//		return this.refundLogDao.query(query, params, begin, max);
//		
//	}

	/**
	 * 退款操作-退云购币
	 * 
	 * @param user_id
	 * @param amount
	 * @param type
	 * @param info
	 * @param list_url
	 * @param refund_user_id
	 * @param obj_id
	 * @param gi_id
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Transactional(rollbackFor = {Exception.class})
	public void refunding2(String user_id, String amount, String info, String refund_user_id, String obj_id,
			long currUserId, String type) {

		BigDecimal amountBig = BigDecimal.valueOf(CommUtil.null2Double(amount));// 订单总额

		if (true) {// 退云购币

			UserAccount userAccount = this.userAccountService.findByUid(CommUtil.null2Long(user_id), "8");

			if (obj_id != null && !obj_id.equals("")) {
				ReturnGoodsLog rgl = returnGoodsLogService.getObjById(CommUtil.null2Long(obj_id));// 退款日志表shop_return_goods_log
				rgl.setRefundStatus(1);// 完成退款
				rgl.setGoodsReturnStatus("11");// 平台退款完成
				this.returnGoodsLogService.update(rgl);

				OrderForm of = this.orderFormService.getObjById(rgl.getReturnOrderId());

				String pay_ip = "";
				ShopBonusRepeatLog vo = new ShopBonusRepeatLog();
				vo.setOrderId(of.getOrderId());
				vo.setType(0);
				vo.setUid(CommUtil.null2Long(user_id));
				ShopBonusRepeatLog resLog = this.shopBonusRepeatLogDao.getByVo(vo);// 在shop_bonus_log
																					// 查出订单要退款的钱

				// 调用退款方法
				int refundType = 3;// 表示云购币
				CnUserRefundBO cnUserRefundBO = this.cnPayBaseService.orderRefund(userAccount.getLoginName(),
						of.getOrderId(), CommUtil.null2BigDecimal(amount),
						CommUtil.null2String(resLog.getReturnTracNo()), refundType, pay_ip);

				if ("1".equals(cnUserRefundBO.getISREFUND())) { // 表示退款成功

					RefundLog r_log = new RefundLog();
					r_log.setAddTime(new Date());
					r_log.setRefundId(CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + user_id);
					r_log.setReturnLogId(rgl.getId());
					r_log.setReturnServiceId(rgl.getReturnServiceId());
					r_log.setRefund(amountBig);
					r_log.setRefundLog(info);
					r_log.setRefundType("云购币");
					r_log.setRefundUserId(currUserId);
					r_log.setReturnLogUserName(rgl.getUserName());
					r_log.setReturnLogUserId(rgl.getUserId());
					save(r_log);

					Goods goods = goodsService.getObjById(rgl.getGoodsId());

					if (goods.getGoodsType() == 1) {

						// 先查出该订单的结算信息
						PayoffLogBO oldPayoffLog = payoffLogService.selectBOByOidAndOrderId(
								CommUtil.null2String(rgl.getReturnOrderId()), of.getOrderId());

						List<Map> retrunGoodsInfoList = new ArrayList<>();

						if (StringUtils.isNotEmpty(oldPayoffLog.getReturnGoodsInfo())) {
							retrunGoodsInfoList = payofflogTools.queryGoodsInfo(oldPayoffLog
									.getReturnGoodsInfo());
						}

						long storeId = goodsService.getObjById(rgl.getGoodsId()).getGoodsStoreId();
						Store store = storeDao.get(storeId);
						PayoffLog pol = new PayoffLog();
						pol.setRefundUserId(rgl.getUserId());
						pol.setRefundUserName(rgl.getUserName());
						pol.setReturnServiceId(rgl.getReturnServiceId());
						BigDecimal price = amountBig; // 商品的原价,目前等于自定义退款金额

						// 已改为平台加价 * 退货数量（原：商品的佣金比例）
						BigDecimal mission = new BigDecimal(CommUtil.mul(rgl.getGoodsCount(),
								rgl.getGoodsCommissionRate()));
						// 0 -（退款金额 - 平台总加价）
						BigDecimal final_money = BigDecimal.valueOf(CommUtil.subtract(0,
								CommUtil.subtract(price, mission)));

						Map json = new HashMap();
						json.put("goods_id", rgl.getGoodsId());
						json.put("goods_name", rgl.getGoodsName());
						json.put("goods_price", rgl.getGoodsPrice());
						json.put("goods_mainphoto_path", rgl.getGoodsMainphotoPath());
						json.put("goods_commission_rate", rgl.getGoodsCommissionRate());
						json.put("goods_count", rgl.getGoodsCount());
						json.put("goods_all_price", rgl.getGoodsAllPrice());
						json.put("goods_commission_price", mission.doubleValue());
						json.put("goods_payoff_price", final_money);
						retrunGoodsInfoList.add(json);
						pol.setReturnGoodsInfo(Json.toJson(retrunGoodsInfoList, JsonFormat.compact()));
						pol.setoId(CommUtil.null2String(rgl.getReturnOrderId()));
						pol.setOrderId(of.getOrderId());
//					pol.setCommissionAmount(BigDecimal.valueOf(0));
//					pol.setOrderTotalPrice(final_money);
						// 先不这样结算payoffLogService.save(pol);

						// 计算该计算金额，销售金额
						BigDecimal oldCommissionAmount = oldPayoffLog.getCommissionAmount(); // 结算账单总佣金
						BigDecimal oldTotlePrice = oldPayoffLog.getOrderTotalPrice(); // 对应订单商品总金额
						BigDecimal oldTotleAmount = oldPayoffLog.getTotalAmount(); // 结算金额
						BigDecimal oldReturnMoney = oldPayoffLog.getReturnAmount(); // 退款金额

						pol.setCommissionAmount(oldCommissionAmount.subtract(mission));
						pol.setOrderTotalPrice(oldTotlePrice.subtract(price));
						pol.setTotalAmount(oldTotleAmount.add(final_money));
						pol.setReturnAmount(oldReturnMoney.add(price));

						payoffLogService.updateByOrderIdAndOid(pol);

						storeDao.addStoreAmount(BigDecimal.ZERO.subtract(mission), final_money,
								new BigDecimal(-Double.parseDouble(amount)), store.getId());

						this.configService.addConfigAmount(null, null, BigDecimal.ZERO.subtract(mission),
								final_money);
					}

					String msg_content = "成功为订单号：" + of.getOrderId() + "退款" + amount + "元，请到收支明细中查看。";
					// 发送系统站内信
					Message msg = new Message();
					msg.setAddTime(new Date());
					msg.setStatus(0);
					msg.setType(0);
					msg.setContent(msg_content);
					msg.setFromUserId(currUserId);
					msg.setToUserId(Long.parseLong(user_id));
					messageService.save(msg);

				} else {
					System.out.println("退款失败,CN接口返回0");
				}

			} else {

				System.out.println("shop_return_goods_log 表的ID is null");
			}

		}
	}

	/***
	 * 
	 * 退款到奖金
	 * 
	 * @param user_id
	 * @param amount
	 * @param info
	 * @param refund_user_id
	 * @param obj_id
	 * @param currUserId
	 * @param type
	 */
	@SuppressWarnings({"unchecked", "rawtypes", "unused"})
	@Transactional(rollbackFor = {Exception.class})
	public void refunding3(String user_id, String amount, String info, String refund_user_id, String obj_id,
			long currUserId, String type) {
		BigDecimal amountBig = BigDecimal.valueOf(CommUtil.null2Double(amount));// 订单总额
		if (true) {
			UserAccount userAccount = this.userAccountService.findByUid(CommUtil.null2Long(user_id), "8");
			ReturnGoodsLog rgl = returnGoodsLogService.getObjById(CommUtil.null2Long(obj_id));// 退款日志表shop_return_goods_log
			rgl.setRefundStatus(1);// 完成退款
			rgl.setGoodsReturnStatus("11");// 平台退款完成
			this.returnGoodsLogService.update(rgl); // 修改退款日志表

			OrderForm of = this.orderFormService.getObjById(rgl.getReturnOrderId());

			String pay_ip = "";
			ShopBonusRepeatLog vo = new ShopBonusRepeatLog();
			vo.setOrderId(of.getOrderId());
			vo.setType(0);
			vo.setUid(CommUtil.null2Long(user_id));

			ShopBonusRepeatLog resLog = this.shopBonusRepeatLogDao.getByVo(vo);// 在shop_bonus_log 查出订单要退款的钱

			int refundType = 1;// 表示奖金
			CnUserRefundBO cnUserRefundBO = this.cnPayBaseService.orderRefund(userAccount.getLoginName(),
					of.getOrderId(), resLog.getUsedBonusPrice(), of.getTradeNo(), refundType, pay_ip);

			if ("1".equals(cnUserRefundBO.getISREFUND())) {// 表示退款成功

				RefundLog r_log = new RefundLog();
				r_log.setAddTime(new Date());
				r_log.setRefundId(CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + user_id);
				r_log.setReturnLogId(rgl.getId());
				r_log.setReturnServiceId(rgl.getReturnServiceId());
				r_log.setRefund(amountBig);
				r_log.setRefundLog(info);
				r_log.setRefundType("奖金");
				r_log.setRefundUserId(currUserId);
				r_log.setReturnLogUserName(rgl.getUserName());
				r_log.setReturnLogUserId(rgl.getUserId());
				this.save(r_log);// shop_refund_log 增加日志

				Goods goods = goodsService.getObjById(rgl.getGoodsId());
				if (goods.getGoodsType() == 1) {// 表示第三方的 产品

					// 先查出该订单的结算信息
					PayoffLogBO oldPayoffLog = payoffLogService.selectBOByOidAndOrderId(
							CommUtil.null2String(rgl.getReturnOrderId()), of.getOrderId());

					List<Map> retrunGoodsInfoList = new ArrayList<>();

					if (StringUtils.isNotEmpty(oldPayoffLog.getReturnGoodsInfo())) {
						retrunGoodsInfoList = payofflogTools
								.queryGoodsInfo(oldPayoffLog.getReturnGoodsInfo());
					}

					long storeId = goodsService.getObjById(rgl.getGoodsId()).getGoodsStoreId();
					Store store = storeDao.get(storeId);
					PayoffLog pol = new PayoffLog();
					pol.setRefundUserId(rgl.getUserId());
					pol.setRefundUserName(rgl.getUserName());
					pol.setReturnServiceId(rgl.getReturnServiceId());
					BigDecimal price = amountBig; // 商品的原价,目前等于自定义退款金额

					// 已改为平台加价 * 退货数量（原：商品的佣金比例）
					BigDecimal mission = new BigDecimal(CommUtil.mul(rgl.getGoodsCount(),
							rgl.getGoodsCommissionRate()));
					// 0 -（退款金额 - 平台总加价）
					BigDecimal final_money = BigDecimal.valueOf(CommUtil.subtract(0,
							CommUtil.subtract(price, mission)));

					Map json = new HashMap();
					json.put("goods_id", rgl.getGoodsId());
					json.put("goods_name", rgl.getGoodsName());
					json.put("goods_price", rgl.getGoodsPrice());
					json.put("goods_mainphoto_path", rgl.getGoodsMainphotoPath());
					json.put("goods_commission_rate", rgl.getGoodsCommissionRate());
					json.put("goods_count", rgl.getGoodsCount());
					json.put("goods_all_price", rgl.getGoodsAllPrice());
					json.put("goods_commission_price", mission.doubleValue());
					json.put("goods_payoff_price", final_money);
					retrunGoodsInfoList.add(json);
					pol.setReturnGoodsInfo(Json.toJson(retrunGoodsInfoList, JsonFormat.compact()));
					pol.setoId(CommUtil.null2String(rgl.getReturnOrderId()));
					pol.setOrderId(of.getOrderId());
//					pol.setCommissionAmount(BigDecimal.valueOf(0));
//					pol.setOrderTotalPrice(final_money);
					// 先不这样结算payoffLogService.save(pol);

					// 计算该计算金额，销售金额
					BigDecimal oldCommissionAmount = oldPayoffLog.getCommissionAmount(); // 结算账单总佣金
					BigDecimal oldTotlePrice = oldPayoffLog.getOrderTotalPrice(); // 对应订单商品总金额
					BigDecimal oldTotleAmount = oldPayoffLog.getTotalAmount(); // 结算金额
					BigDecimal oldReturnMoney = oldPayoffLog.getReturnAmount(); // 退款金额

					pol.setCommissionAmount(oldCommissionAmount.subtract(mission));
					pol.setOrderTotalPrice(oldTotlePrice.subtract(price));
					pol.setTotalAmount(oldTotleAmount.add(final_money));
					pol.setReturnAmount(oldReturnMoney.add(price));

					payoffLogService.updateByOrderIdAndOid(pol);

					storeDao.addStoreAmount(BigDecimal.ZERO.subtract(mission), final_money, new BigDecimal(
							-Double.parseDouble(amount)), store.getId());

					this.configService.addConfigAmount(null, null, BigDecimal.ZERO.subtract(mission),
							final_money);

				}

			} else {
				System.out.println("退款失败");
			}

		} else {
			System.out.println("退款类型不匹配！");
		}
	}

}
