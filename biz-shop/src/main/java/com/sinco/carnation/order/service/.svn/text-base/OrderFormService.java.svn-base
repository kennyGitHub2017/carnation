package com.sinco.carnation.order.service;

import java.awt.Container;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.dozer.Mapper;
import org.nlpcn.commons.lang.util.StringUtil;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.dao.GoodsClassDao;
import com.sinco.carnation.goods.dao.GoodsSpecPropertyDao;
import com.sinco.carnation.goods.dao.ReturnGoodsLogDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsLog;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.order.vo.OrderEvaluateVO;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.SelectYgPayModeBO;
import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.dao.EcCommonDao;
import com.sinco.carnation.shop.dao.GoodsReceiptDao;
import com.sinco.carnation.shop.dao.OrderFormDao;
import com.sinco.carnation.shop.dao.PaymentDao;
import com.sinco.carnation.shop.dao.ShipAddressDao;
import com.sinco.carnation.shop.dao.ShopBonusRepeatLogDao;
import com.sinco.carnation.shop.dao.ZeroGoodsDao;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.GoodsReceipt;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnRenturnYgOrderBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.bo.orcl.CnUserPayBO;
import com.sinco.carnation.sys.bo.orcl.CnValidatPasswordBO;
import com.sinco.carnation.sys.bo.orcl.CnWirteOrderBO;
import com.sinco.carnation.sys.bo.orcl.CnYgOrderPayBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.constant.OrclSchmaNameConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.IntegralRegService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.bo.UserMoneyBO;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.dal.common.MyPage;
import com.sinco.messager.MessageHandler;

@Service
@Transactional(rollbackFor = ServiceException.class)
@SuppressWarnings({"static-access", "rawtypes", "unchecked", "unused"})
public class OrderFormService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderFormDao orderFormDao;
	@Autowired
	IntegralService integralService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	ReturnGoodsLogDao returnGoodsLogDao;
	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private GoodsReceiptDao goodsReceiptDao;

	@Autowired
	private GoodsLogService goodsLogService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private UserMoneyService moneyService;

	@Autowired
	private LuceneUtil luceneUtil;

	@Autowired
	private LuceneVoTools luceneVoTools;

	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private PayoffLogService payoffLogservice;
	@Autowired
	private GoodsSpecPropertyDao goodsSpecPropertyDao;

	@Autowired
	private SellerService sellerService;
	@Autowired
	private EcCommonDao expressCompanyCommonDao;
	@Autowired
	private ShipAddressDao shipAddressDao;
	@Autowired
	private TransInfoService transInfoService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private GoodsClassDao goodsClassDao;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;
	@Autowired
	@Lazy
	private EvaluateService evaluateService;
	@Autowired
	private StorePointService storePointService;
	@Autowired
	private UserService userService;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private Mapper mapper;
	@Value(value = "${order.payofflog.daycount}")
	Integer day;
	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;
	@Autowired
	private WordFind wordFind;
	@Autowired
	private UserAccountDao userAccountDao;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private ShopBonusRepeatLogDao ShopBonusRepeatLogDao;
	@Autowired
	private ZeroGoodsDao zeroGoodsDao;
	@Autowired
	private UserRelationDao userRelationDao;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private NoticeMessageService noticeMessageService;

	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private UserMoneyService userMoneyService;
	@Autowired
	private IntegralRegService integralRegService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private PayTools payTools;
	public List<OrderFormBO> findOrderCanPreRebateArray() {
		return orderFormDao.selectOrderCanPreRebateArray(day);
	}

	public List<OrderFormBO> findYunGouCNOrderRebateArray() {
		return orderFormDao.selectYunGouCNOrderArray(day);
	}

	public List<OrderFormBO> findYunGouYSOrderRebateArray() {
		return orderFormDao.selectYunGouYSOrderArray(day);
	}

	public List<OrderFormBO> selectListById(String ids) {
		List<OrderFormBO> orderList = new ArrayList<OrderFormBO>();
		String[] str = ids.substring(0, ids.length() - 1).split(",");
		for (String id : str) {
			OrderFormBO order = orderFormDao.selectListById(CommUtil.null2Long(id));
			orderList.add(order);
		}
		return orderList;
	}

	/**
	 * 退货申请
	 * 
	 * @param orderId
	 * @param uid
	 * @param returnGoodsContent
	 * @param goodsId
	 * @param returnGoodsCount
	 * @param goodsGspIds
	 * @throws ServiceException
	 */
	public void applyOrderReturn(Long orderId, Long uid, String returnGoodsContent, Long goodsId,
			String returnGoodsCount, String goodsGspIds) throws ServiceException {
		OrderForm obj = getObjById(orderId);

		if (obj.getConfirmTime() != null) {
			Date first = DateUtils.addDays(obj.getConfirmTime(), day);
			Date second = new Date();
			if (DateUtils.truncatedCompareTo(first, second, Calendar.DATE) < 0)
				throw new ServiceException("已超出最大的退货时间范围");
		}

		if (!obj.getUserId().equals(uid))
			throw new ServiceException("用户不存在该订单");

		// 验证状态，不能小于已收货
		if (obj.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TAKE_DELIVERY_OF_GOODS)
			throw new ServiceException("该订单不能申请退货");

		if (null != obj && obj.getIsygOrder())
			throw new ServiceException("该订单不能申请退货");

		List<GoodsBO> goods_list = orderFormTools.queryOfGoods(obj.getId().toString());
		Goods goods = null;
		for (Goods g : goods_list) {
			if (g.getId().equals(goodsId)) {
				goods = g;
			}
		}
		if (goods == null) {
			throw new ServiceException("订单不存在该商品");
		}

		SysConfigBO config = this.configService.getSysConfig();

		List<Map> list = new ArrayList<Map>();
		Map json = new HashMap();
		json.put("return_goods_id", goods.getId());
		json.put("return_goods_content", CommUtil.filterHTML(returnGoodsContent));
		json.put("return_goods_count", returnGoodsCount);
		json.put("return_goods_price", goods.getStorePrice());
		json.put("return_goods_commission_rate", goodsClassDao.getBO(goods.getGcId()).getCommissionRate());
		json.put("return_order_id", obj.getId());
		// 添加商品当前加价金额 add by chen.z
		json.put("return_commission_amount", goods.getGoodsCommissionAmount());

		list.add(json);
		obj.setReturnGoodsInfo(Json.toJson(list, JsonFormat.compact()));
		List<Map> maps = this.orderFormTools.queryGoodsInfo(obj.getGoodsInfo());
		// List<Map> new_maps = new ArrayList<Map>();
		Map gls = new HashMap();
		for (Map m : maps) {
			if (m.get("goods_id").toString().equals(goodsId.toString())
					&& (goodsGspIds == null || goodsGspIds.equals(m.get("goods_gsp_ids").toString()))) {
				m.put("goods_return_status", 5);
				gls.putAll(m);
			}
		}
		obj.setGoodsInfo(Json.toJson(maps, JsonFormat.compact()));
		update(obj);
		UserCustomerBO user = customerService.queryUserByUid(uid);

		if (returnGoodsLogDao.goodsUserIdCount(user.getUid(), goodsId, orderId, goodsGspIds) != 0)
			throw new ServiceException("该商品已经在退货流程中");

		// 生成退货日志
		ReturnGoodsLog rlog = new ReturnGoodsLog();
		rlog.setReturnServiceId("re" + user.getUid() + CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
		rlog.setUserName(user.getNickname());
		rlog.setUserId(user.getUid());
		rlog.setReturnContent(CommUtil.filterHTML(returnGoodsContent));
		rlog.setGoodsAllPrice(gls.get("goods_all_price").toString());
		rlog.setGoodsCount(gls.get("goods_count").toString());
		rlog.setGoodsId(CommUtil.null2Long(gls.get("goods_id").toString()));
		rlog.setGoodsGspIds(goodsGspIds);
		rlog.setGoodsMainphotoPath(gls.get("goods_mainphoto_path").toString());
		// 这里改成平台加价
		rlog.setGoodsCommissionRate(BigDecimal.valueOf(CommUtil.null2Double(gls.get("self_add_price"))));
		rlog.setGoodsName(gls.get("goods_name").toString());
		rlog.setGoodsPrice(gls.get("goods_price").toString());
		rlog.setGoodsReturnStatus("5");
		rlog.setAddTime(new Date());
		rlog.setReturnOrderId(obj.getId());
		rlog.setGoodsType(goods.getGoodsType());
		rlog.setStoreId(goods.getGoodsStoreId());
		returnGoodsLogService.save(rlog);

		// // 如果是收费接口，则通知快递100，建立订单物流查询推送
		// if (configService.getSysConfig().getKuaidiType() == 1) {
		// TaskRequest req = new TaskRequest();
		// Map express_map = Json.fromJson(Map.class, obj.getExpressInfo());
		// req.setCompany(CommUtil.null2String(express_map.get("express_company_mark")));
		// String from_addr = "";
		// req.setFrom(from_addr);
		// req.setTo(obj.getReceiverArea());
		// req.setNumber(obj.getShipCode());
		// req.getParameters().put("callbackurl",
		// CommUtil.getURL(request) + "/kuaidi100_callback.htm?order_id=" +
		// obj.getId() + "&orderType=1");
		// req.getParameters().put("salt",
		// Md5Encrypt.md5(CommUtil.null2String(obj.getId())).toLowerCase());
		// req.setKey(this.configService.getSysConfig().getKuaidiId2());
		//
		// HashMap<String, String> p = new HashMap<String, String>();
		// p.put("schema", "json");
		// p.put("param", JacksonHelper.toJSON(req));
		// try {
		// String ret =
		// HttpRequest.postData("http://www.kuaidi100.com/poll", p,
		// "UTF-8");
		// TaskResponse resp = JacksonHelper.fromJSON(ret,
		// TaskResponse.class);
		// if (resp.getResult() == true) {
		// System.out.println("订阅成功");
		// } else {
		// System.out.println("订阅失败");
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

		if (obj.getOrderForm() == 0) {
			try {
				SellerBO seller = sellerService.selectByStore(obj.getStoreId());
				Map map = new HashMap();
				map.put("buyer_id", user.getUid());
				map.put("seller_id", seller.getUid());
				msgTools.sendEmailCharge(config.getAddress(), "email_toseller_order_return_apply_notify",
						seller.getEmail(), Json.toJson(map), null, obj.getStoreId());
				map.clear();
				map.put("buyer_id", user.getUid());
				map.put("seller_id", seller.getUid());
				msgTools.sendSmsCharge(config.getAddress(), "sms_toseller_order_return_apply_notify",
						seller.getMobile(), Json.toJson(map), null, obj.getStoreId());
			} catch (Exception e) {
				log.error("退货申请发送消息错误", e);
			}
		}
	}

	/**
	 * 根据订单id
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderFormBO findByOrderNo(String orderId) {
		return orderFormDao.findByOrderId(orderId);
	}

	public List<OrderFormBO> selectOrderFormByStoreId(String storeId) {
		return orderFormDao.selectOrderFormByStoreId(storeId);
	}

	public List<OrderFormBO> selectOrderFormByOrderId(String orderId) {
		return orderFormDao.selectOrderFormByOrderId(orderId);
	}

	/**
	 * 商家发货
	 * 
	 * @param orderId
	 * @param eccId
	 * @param shipCode
	 * @param saId
	 * @param stateInfo
	 * @param userId
	 * @param userStoreId
	 * @param order_seller_intros
	 * @param goods_ids
	 * @param goods_names
	 * @param goods_counts
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm deliverySeller(Long orderId, Long eccId, String shipCode, Long saId, String stateInfo,
			Long userId, Long userStoreId, String[] order_seller_intros, String[] goods_ids,
			String[] goods_names, String[] goods_counts, String eccName) throws ServiceException {
		SysConfigBO config = this.configService.getSysConfig();

		OrderForm obj = this.getObjById(orderId);

		EcCommon ecc = this.expressCompanyCommonDao.get(eccId);
		/*if(eccId.intValue()==999999){//自定义物流 商家固有  自定义物流暂不做
			if(StringUtils.isBlank(eccName)){
				throw new ServiceException("自定义物流需要填写物流公司名");
			}
			ecc = new EcCommon();
			ecc.setEccEcId(eccId);
			ecc.setEccName("eccName");
			ecc.setEccCode("zidingyi");
			ecc.setEccEcType("EXPRESS");
		}*/
		UserCustomer buyer = this.customerService.findById(obj.getUserId());

		if (!userStoreId.equals(CommUtil.null2Long(obj.getStoreId()))) {
			// 该订单不属于这个商家
			throw new ServiceException("该订单不属于这个商家");
		}

		obj.setOrderStatus(30);
		obj.setShipCode(shipCode);
		obj.setShipTime(new Date());
		if (ecc != null) {
			Map json_map = new HashMap();
			json_map.put("express_company_id", ecc.getEccEcId());// 物流表ID
			json_map.put("express_company_name", ecc.getEccName());
			json_map.put("express_company_mark", ecc.getEccCode());
			json_map.put("express_company_type", ecc.getEccEcType());
			obj.setExpressInfo(Json.toJson(json_map));
		}

		if (order_seller_intros != null && order_seller_intros.length > 0) {
			List<Map> list_map = new ArrayList<Map>();
			for (int i = 0; i < goods_ids.length; i++) {
				Map json_map = new HashMap();
				json_map.put("goods_id", goods_ids[i]);
				json_map.put("goods_name", goods_names[i]);
				json_map.put("goods_count", goods_counts[i]);
				json_map.put("order_seller_intro", order_seller_intros[i]);
				json_map.put("order_id", orderId);
				list_map.add(json_map);
			}
			obj.setOrderSellerIntro(Json.toJson(list_map));
		}
		ShipAddressBO sa = this.shipAddressDao.findBO(CommUtil.null2Long(saId));
		if (sa != null) {
			obj.setShipAddrId(sa.getId());
			obj.setShipAddr(sa.getAreaName() + sa.getSaAddr());
		}
		this.update(obj);
		OrderLog ofl = new OrderLog();
		ofl.setAddTime(new Date());
		ofl.setLogInfo("确认发货");
		ofl.setStateInfo(stateInfo);
		ofl.setLogUserId(userId);
		ofl.setOfId(obj.getId());
		this.orderFormLogService.save(ofl);
		// User buyer = this.userService.getObjById(CommUtil.null2Long(obj
		// .getUser_id()));
		// 如果是收费接口，则通知快递100，建立订单物流查询推送
		transInfoService.createExpressSearchSend(obj);
		// 异步通知支付宝,只有在支付宝担保支付情况下才支持此接口
		// if (obj.getPayment() != null
		// && obj.getPayment().getMark().equals("alipay")
		// && obj.getPayment().getInterfaceType() == 1) {
		// // 把请求参数打包成数组
		// boolean synch = false;
		// String safe_key = "";
		// String partner = "";
		// if (!CommUtil.null2String(obj.getPayment().getSafeKey())
		// .equals("")
		// && !CommUtil.null2String(obj.getPayment().getPartner())
		// .equals("")) {
		// safe_key = obj.getPayment().getSafeKey();
		// partner = obj.getPayment().getPartner();
		// synch = true;
		// }
		// if (synch) {
		// AlipayConfig config = new AlipayConfig();
		// config.setKey(safe_key);
		// config.setPartner(partner);
		// Map<String, String> sParaTemp = new HashMap<String, String>();
		// sParaTemp.put("service", "send_goods_confirm_by_platform");
		// sParaTemp.put("partner", config.getPartner());
		// sParaTemp.put("_input_charset", config.getInput_charset());
		// sParaTemp.put("trade_no", obj.getOut_order_id());
		// sParaTemp.put("logistics_name", ecc.getEcc_name());
		// sParaTemp.put("invoice_no", shipCode);
		// sParaTemp.put("transport_type", ecc.getEcc_ec_type());
		// // 建立请求
		// String sHtmlText = AlipaySubmit.buildRequest(config, "web",
		// sParaTemp, "", "");
		// // System.out.println(sHtmlText);
		// }
		// }
		Map map = new HashMap();
		map.put("buyer_id", obj.getUserId());
		map.put("seller_id", userId);
		map.put("order_id", obj.getId());
		String json = Json.toJson(map);
		try {
			if (obj.getOrderForm() == 0) {
				this.msgTools.sendEmailCharge(config.getAddress(), "email_tobuyer_order_ship_notify",
						buyer.getEmail(), json, null, obj.getStoreId());
				this.msgTools.sendSmsCharge(config.getAddress(), "sms_tobuyer_order_ship_notify",
						buyer.getMobile(), json, null, obj.getStoreId());
			} else {
				this.msgTools.sendEmailFree(config.getAddress(), "email_tobuyer_order_ship_notify",
						buyer.getEmail(), json, null);
				this.msgTools.sendSmsFree(config.getAddress(), "sms_tobuyer_order_ship_notify",
						buyer.getMobile(), json, null);
			}
		} catch (Exception e) {
			log.error("订单【" + obj.getOrderId() + "】发送消息通知异常", e);
		}
		return obj;
	}

	/**
	 * 进行订单支付
	 * 
	 * @param payType
	 * @param orderId
	 * @param isAvailableBalance
	 *            微信
	 * @param paymentPassword
	 * @param isYunGouMoney
	 *            是否使用云购币
	 * @param yunGouPassword
	 *            云购币/奖金 密码
	 * @throws ServiceException
	 *             isBonusPay 是否使用奖金 accountType 判断accountType 是否等于8 说明有CN 账户
	 */
	public  synchronized OrderFormBO orderPay(String payType, Long orderId, Long uid, boolean isAvailableBalance,
			String paymentPassword, boolean isYunGouMoney, String yunGouPassword, String accountType,
			boolean isBonusPay) throws ServiceException {

		OrderFormBO order = this.fetch(orderId);

		UserCustomer customer = customerService.findById(uid);

		if (order != null && order.getOrderStatus() != 10) {
			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				return order;
			}
			throw new ServiceException("参数错误，付款失败");
		}

		/**
		 * 用户第一次消费 如果没有绑定商家 就与当前商户产生从属关系 add by yuleijia 2016.12.19 2017-4-24 方法抽出 by qin
		 */
		userRelationService.firstConsumptionRelation(uid, order.getStoreId());

		boolean inventory_very = true;
		boolean goods_status = true; // 订单中产品类型
		List<GoodsBO> goods_list = this.orderFormTools.queryOfGoods(orderId);
		for (GoodsBO obj : goods_list) {

			if (obj.getGoodsStatus() != 0) {
				goods_status = false;
				break;
			}
			
		if (!CommUtil.null2Long(10121).equals(obj.getId())) {//临时处理 请购商品
				int order_goods_count = this.orderFormTools.queryOfGoodsCount(orderId.toString(),
						CommUtil.null2String(obj.getId()), obj.getGoodsSpecIds());
				// 真实商品库存
				int real_goods_count = CommUtil.null2Int(this.goodsService
						.generic_default_info(obj, obj.getGoodsSpecIds(), customer).get("count"));// 计算商品库存信息
				if (order_goods_count > real_goods_count) {
					inventory_very = false;
					break;
				}
			}
			
		}
		ZeroGoods zeroGoods = this.getZeroGoods(goods_list.get(0).getId());// 0元购
																			// 增加库存判断
		if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
			if (zeroGoods.getGoodsInventory() < 0) {
				inventory_very = false;
			}
		}

		if (!inventory_very) {// 订单中商品库存验证
			throw new ServiceException("订单中商品库存不足，请重新下单");
		}
		if (!goods_status) {// 订单产品状态查询
			throw new ServiceException("订单中存在下架产品，请重新下单");
		}

		double order_total_price = this.orderFormTools.query_order_price(order);
		double availableBalance = 0;
		if (isAvailableBalance) {
			availableBalance = this.moneyService.getAvailableBalance(uid);
		}

		if (isYunGouMoney) {// ///////////////////////如果存在云购币支付

			if (isYunGouMoney && isAvailableBalance) { // 1:云购币加云豆

				boolean bl = this.validatCNPassword(null, paymentPassword, uid);
				if (!bl) {
					throw new ServiceException("CN账号支付密码错误!");
				}

				OrderForm res = this.yungouMoneyAndBalance(orderId, uid, paymentPassword, "",
						availableBalance);
				OrderFormBO orderFormBO = mapper.map(res, OrderFormBO.class);
				return orderFormBO;

			} else if (isYunGouMoney && StringUtils.isNotBlank(payType)) {// 2:云购币加第三方[微信
																			// 支付宝]

				OrderForm res = this.yungouMoneyAndCash(orderId, uid, yunGouPassword, payType);// 先扣除云购币
				OrderFormBO orderFormBO = mapper.map(res, OrderFormBO.class);
				return orderFormBO;

			} else {// 3:云购币独立支付

				boolean bl = this.validatCNPassword(null, yunGouPassword, uid);
				if (!bl) {
					throw new ServiceException("CN账号支付密码错误!");
				}
				OrderFormBO orderFormBO = mapper.map(
						this.yungouMoneyPay(orderId, yunGouPassword, availableBalance, uid),
						OrderFormBO.class);
				return orderFormBO;
			}

		} else {

			// 使用云豆和奖金支付
			if (isAvailableBalance) {// TODO

				// 订单支付方式为云豆支付{为了方便退款，将修改方式增加到具体的方法上}
				PaymentBO balancePayment = this.paymentService
						.findByMark(PaymentConstants.PAYMENT_MARK_BALANCE);
				order.setPaymentId(balancePayment.getId());
				order.setPayType(OrderFormConstants.ORDER_PAY_TYPE_BALANCE); // 云豆支付
				this.update(order);

				if ("8".equals(accountType)) { // CN用户,要验证他们的密码
					// cn账户密码正确
					boolean passwordTrue = this.validatCNPassword(null, paymentPassword, uid);

					if (passwordTrue) {

						if (availableBalance >= order_total_price) {// 判断CN账户的在我们平台的云豆余额[一般情况下在我们平台的云豆是0]
							OrderFormBO orderFormBO = mapper
									.map(this.completeMoneyPay(order.getId(), null, ""), OrderFormBO.class);
//							this.saveGoodsReceipt(order);
							return orderFormBO;

						} else {// 云豆+奖金支付

							BigDecimal pdAmount = new BigDecimal(order_total_price)
									.subtract(new BigDecimal(availableBalance));

							BigDecimal bonus = this.getBonus(pdAmount, uid);

							// CN账户的奖金满足,{如果有CN账户,将 云豆的密码 看做 奖金的密码 }
							if (bonus.compareTo(pdAmount) != -1) {
								OrderForm orderFrom = this.bonusAndBlance(order.getId(), null, "",
										paymentPassword, new BigDecimal(availableBalance).setScale(2, BigDecimal.ROUND_HALF_UP), pdAmount, uid);

								OrderFormBO orderFormBO = mapper.map(orderFrom, OrderFormBO.class);
//								this.saveGoodsReceipt(order);
								return orderFormBO;
							}

						}
					} else {
						throw new ServiceException("CN账号支付密码错误!");
					}

				} else { // 非CN用户,要验证本平台密码
					// 如果云豆足够
					if (availableBalance >= order_total_price) {
						OrderFormBO orderFormBO = mapper.map(
								this.completeMoneyPay(order.getId(), paymentPassword, ""), OrderFormBO.class);
//						this.saveGoodsReceipt(order);
						return orderFormBO;

					}

				}

			}
			BigDecimal repeat = new BigDecimal(0);
			if (StringUtils.isBlank(payType)) {
				throw new ServiceException("支付方式错误");
			}

			payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYB)
					? PaymentConstants.PAYMENT_MARK_ALIPAYB : payType;
			payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYC)
					? PaymentConstants.PAYMENT_MARK_ALIPAYC : payType;

			// 拿到在线支付的方式
			PaymentBO onlinePayment = this.paymentService.findByMark(payType);

			// 使用云豆不足，需要在线充值,充值完成后会使用云豆支付
			if (isAvailableBalance) {

				// 如果云豆不够，不足的部分充值到云豆后，再完成云豆支付
				BigDecimal pdAmount = new BigDecimal(order_total_price)
						.subtract(new BigDecimal(availableBalance));
				Long cashId = this.predepositService.save(order.getId(), PaymentConstants.ORDER_TYPE_GOODS,
						payType, pdAmount, uid);
				order.setCashId(cashId);

			} else {
				// 产生订单支付id
				String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
				order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());

				// 使用在线支付,设置在线支付方式
				order.setPaymentId(onlinePayment.getId());
				order.setPayType("online");
				this.update(order);
				log.error("支付订单：" + "order-" + trade_no + "-" + order.getId().toString());
			}

			// 如果有子订单，修改子订单支付方式
			if (order != null && StringUtils.isNotBlank(order.getChildOrderDetail())) {
				List<Map> maps = this.orderFormTools.queryGoodsInfo(order.getChildOrderDetail());
				for (Map map : maps) {
					OrderForm child_order = getObjById(CommUtil.null2Long(map.get("order_id")));
					child_order.setPaymentId(onlinePayment.getId());
					update(child_order);
				}
			}

		}

//		this.saveGoodsReceipt(order);

		return order;
	}

	/**
	 * 使用云豆完成订单支付
	 * 
	 * @param mainOrderId
	 * @param tradeNo
	 * @param uid
	 * @param logInfo
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm completeMoneyPay(Long mainOrderId, String password, String payMsg)
			throws ServiceException {
		OrderForm order = this.getObjById(mainOrderId);
		// 异步没有出来订单，则同步处理订单
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}

		Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_BALANCE);

		double orderTotalPrice = this.orderFormTools.query_order_price(order);

		String logInfo = order.getOrderId() + "订单购物减少可用云豆";

		boolean bo = false;

		// 如果密码为空,则不验证密码
		if (StringUtils.isNotBlank(password)) {
			bo = moneyService.consumptionMoney(order.getUserId(), orderTotalPrice, password, logInfo);
		} else {
			bo = moneyService.consumptionMoney(order.getUserId(), orderTotalPrice, logInfo);
		}
		if (!bo) {
			throw new ServiceException("云豆支付失败");
		}

		return completePay(mainOrderId, payment.getId(), null, logInfo);
	}

	public BigDecimal selectSumTotlePriceByVO(OrderFormVO vo) {
		return orderFormDao.selectSumTotlePriceByVO(vo);
	}

	public int selectCountByVO(OrderFormVO vo) {
		return orderFormDao.selectCountByVO(vo);
	}

	/**
	 * 完成订单支付
	 * 
	 * @param mainOrderId
	 * @param tradeNo
	 * @param uid
	 * @param logInfo
	 * @return
	 * @throws ServiceException
	 */
	// @Transactional(propagation=Propagation.REQUIRED)
	public OrderForm completePay(Long mainOrderId, String tradeNo, String logInfo) throws ServiceException {
		return completePay(mainOrderId, null, tradeNo, logInfo);
	}

	/**
	 * 完成订单支付
	 * 
	 * @param mainOrderId
	 * @param paymentId
	 *            支付方法id
	 * @param tradeNo
	 * @param uid
	 * @param logInfo
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm completePay(Long mainOrderId, Long paymentId, String tradeNo, String logInfo)
			throws ServiceException {
		OrderForm mainOrder = this.getObjById(mainOrderId);

		if (mainOrder == null) {
			throw new ServiceException("订单不存在！");
		}
		List<OrderForm> result = new ArrayList<>();
		// result.add(mainOrder);//重复发短信的问题屏蔽，KENNY2016-10-10

		// 如果已经支付，直接返回成功
		if (mainOrder.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED
				|| mainOrder.getOrderStatus() == OrderFormConstants.ORDER_STATUS_ORDER_CANCEL) {
			return mainOrder;
		}

		SysConfigBO config = this.configService.getSysConfig();

		mainOrder.setId(mainOrderId);
		mainOrder.setOrderStatus(20);
		mainOrder.setOutOrderId(tradeNo);
		mainOrder.setPayTime(new Date());
		if (paymentId != null) {
			mainOrder.setPaymentId(paymentId);
		}
		this.orderFormDao.update(mainOrder);

		result.add(mainOrder);
		// 主订单付款成功，订单状态更新，同时更新商品库存，如果是团购商品，则更新团购库存
		if (!mainOrder.getOrderTypeFlag().equals(1)) {// 0元购 非0元购更新字库存
			updateGoodsInventory(mainOrder);
		}

		System.out.println("差不多");
		OrderLog main_ofl = new OrderLog();
		main_ofl.setAddTime(new Date());
		main_ofl.setLogInfo(logInfo);
		main_ofl.setLogUserId(mainOrder.getUserId());
		main_ofl.setOfId(mainOrderId);
		this.orderFormLogService.save(main_ofl);// shop_order_log

		// 子订单操作
		// 同步完成子订单付款状态调整
		if (mainOrder.getOrderMain() == 1
				&& !CommUtil.null2String(mainOrder.getChildOrderDetail()).equals("")) {
			List<Map> maps = this.orderFormTools.queryGoodsInfo(mainOrder.getChildOrderDetail());
			for (Map child_map : maps) {
				OrderForm child_order = this.orderFormDao.get(CommUtil.null2Long(child_map.get("order_id")));
				if (child_order.getOrderStatus() != OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
					child_order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
					child_order.setPayTime(new Date());
					child_order.setPaymentId(paymentId);// 给子订单增加支付方式
					this.orderFormDao.update(child_order);
					// 子订单付款成功，订单状态更新，同时更新商品库存，如果是团购商品，则更新团购库存
					updateGoodsInventory(child_order);
					OrderLog child_ofl = new OrderLog();
					child_ofl.setAddTime(new Date());
					child_ofl.setLogInfo(logInfo);
					child_ofl.setLogUserId(mainOrder.getUserId());
					child_ofl.setOfId(child_order.getId());
					this.orderFormLogService.save(child_ofl);
					result.add(child_order);
				}
			}
		}

		// 发送完成付款消息
		sendCompletePayMsg(result, config.getAddress());

		return mainOrder;
	}

	/**
	 * 根据状态count
	 * 
	 * @param status
	 * @param userId
	 * @param notOrderCat
	 * @return
	 */
	public int countByStatus(Integer status, Long userId, Integer notOrderCat) {
		return orderFormDao.countByStatus(status, userId, null, notOrderCat);
	}

	/**
	 * 保存定单
	 * 
	 * @param orderForm
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean createOrderFrom(OrderForm orderForm) {
		orderForm.setAddTime(new Date());
		this.orderFormDao.save(orderForm);

		OrderLog ofl = new OrderLog();
		ofl.setAddTime(new Date());
		ofl.setOfId(orderForm.getId());
		ofl.setLogInfo("提交订单");
		ofl.setLogUserId(orderForm.getUserId());
		this.orderFormLogService.save(ofl);

		return true;
	}

	public OrderFormBO fetch(Long id) {
		return orderFormDao.fetch(id);
	}

	public OrderForm getObjById(Long id) {
		OrderForm orderForm = this.orderFormDao.get(id);
		if (orderForm != null) {
			return orderForm;
		}
		return null;
	}

	/** 查询可退货订单 **/
	public List<OrderFormBO> search(String orderId, Long userId, MyPage<OrderFormBO> page) {
		List<OrderFormBO> list = orderFormDao.search(orderId, userId, day, page);
		List<OrderFormBO> result = new ArrayList<OrderFormBO>();
		if (null != list && list.size() > 0) {
			for (OrderFormBO bo : list) {
				if (!bo.getIsygOrder()) {
					result.add(bo);
				}
			}
		}
		return result;
	}

	/**
	 * 查找能够，退货收款的
	 * 
	 * @return
	 */
	public List<OrderFormBO> findOrderCanPayOff() {
		return orderFormDao.findOrderCanPayOff(day);
	}

	/**
	 * 结算记录
	 * 
	 * @return
	 */
	public List<OrderFormBO> findOrderCanPayOffV2() {
		return orderFormDao.findOrderCanPayOffV2(day);
	}

	public List<OrderFormBO> complain(String orderId, Long userId, MyPage<OrderFormBO> page) {
		return orderFormDao.complain(orderId, userId, page);
	}

	public boolean delete(Long id) {
		try {
			this.orderFormDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(readOnly = false)
	public void save(OrderForm orderForm) {
		this.orderFormDao.save(orderForm);
	}

	@Transactional(readOnly = false)
	public void cancelSave(HttpServletRequest request, String id, String state_info, String other_state_info,
			long currUserId) throws Exception {
		List<OrderForm> objs = new ArrayList<OrderForm>();
		OrderForm obj = getObjById(CommUtil.null2Long(id));
		objs.add(obj);
		boolean all_verify = true;
		if (obj != null && obj.getUserId().equals(currUserId)) {
			if (obj.getOrderMain() == 1 && obj.getChildOrderDetail() != null) {
				List<Map> maps = (List<Map>) Json.fromJson(CommUtil.null2String(obj.getChildOrderDetail()));
				if (maps != null) {
					for (Map map : maps) {
						OrderForm child_order = getObjById(CommUtil.null2Long(map.get("order_id")));
						objs.add(child_order);
					}
				}
			}

			for (OrderForm of : objs) {
				if (of.getOrderStatus() >= 20) {
					all_verify = false;
				}
			}
		}
		if (all_verify) {
			if (obj != null && obj.getUserId().equals(currUserId)) {
				if (obj.getOrderMain() == 1) {
					List<Map> maps = (List<Map>) Json
							.fromJson(CommUtil.null2String(obj.getChildOrderDetail()));
					if (maps != null) {
						for (Map map : maps) {
							OrderForm child_order = getObjById(CommUtil.null2Long(map.get("order_id")));
							child_order.setOrderStatus(0);
							update(child_order);
						}
					}
				}

				log.debug("订单号类型{} 订单状态{} 订单支付类型{}", obj.getIsygOrder(), obj.getOrderStatus(),
						obj.getPayTypeFlag());
				if (obj.getIsygOrder() && obj.getOrderStatus() == OrderFormConstants.ORDER_STATUS_TO_BE_YG
						&& obj.getPayTypeFlag().intValue() == 2) {// 积分支付退款

					ShopBonusRepeatLog shopLog = new ShopBonusRepeatLog();
					shopLog.setOrderId(obj.getOrderId());
					ShopBonusRepeatLog shopBonusRepeatLog = this.ShopBonusRepeatLogDao.getByVo(shopLog);
					if (shopBonusRepeatLog != null && shopBonusRepeatLog.getReturnTracNo() != null) {
						try {
							String[] trac = this.cnPayBaseService
									.handString(shopBonusRepeatLog.getReturnTracNo());
							String payNo = trac[0];
							CnRenturnYgOrderBO res = this.cnPayBaseService.returnIntegralPay(
									obj.getCnUseralias(), CommUtil.null2Double(obj.getActualIntegral()),
									payNo, obj.getOrderId());

							if (res.getRETURN_STATUS() != null && res.getRETURN_STATUS().equals("100.0")) {
								ShopBonusRepeatLog record = new ShopBonusRepeatLog();
								record.setDateTime(new Date());
								record.setOrderId(obj.getOrderId());
								record.setPayType(1);
								record.setUsedIntegralMoney(obj.getAllIntegral());
								record.setUserAlias(obj.getCnUseralias());
								record.setType(1);
								record.setUid(obj.getUserId());
								this.ShopBonusRepeatLogDao.save(record);

							}

						} catch (Exception e) {
							log.error("积分订单取消退款异常 订单编号{}", obj.getOrderId());
							log.error("积分订单取消退款异常 ", e);
						}

					}
				}

				if (obj.getIsygOrder() && obj.getOrderStatus() == OrderFormConstants.ORDER_STATUS_TO_BE_YG
						&& obj.getPayTypeFlag().intValue() == 3) {
					try {
						this.jingxunOrderCancel(currUserId, obj.getId());
					} catch (Exception e) {
						log.info("精选专区订单取消", e);
					}

				}

				obj.setOrderStatus(0);
				update(obj);
				int integral = calcOrderIntegral(obj);

				if (obj.getIsygOrder() && obj.getActualygPrice() != null
						&& StringUtils.isNotBlank(obj.getCnUseralias()) && obj.getActualygPrice() != null
						&& CommUtil.null2Double(obj.getActualygPrice()) > 0) {// 云购币订单取消退款
					int type = 3;
					CnRenturnYgOrderBO bo = null;
					try {
						bo = this.cnPayBaseService.return_ygOrder(obj.getCnUseralias(), type,
								obj.getActualygPrice(), obj.getOrderId());
						log.debug("退款完成，退款结果" + obj.getOrderId(), bo.getRETURN_STATUS());
					} catch (Exception e) {
						log.error("cancel return ygMoney--->", e);
					}
					if (bo != null && Double.valueOf(bo.getRETURN_STATUS()).intValue() == 100) {// 退款成功
						// 退还云购币日志
						ShopBonusRepeatLog record = new ShopBonusRepeatLog();
						record.setDateTime(new Date());
						record.setOrderId(obj.getOrderId());
						record.setPayType(1);
						record.setUsedRepeatMoney(obj.getActualygPrice());
						record.setUserAlias(obj.getCnUseralias());
						record.setType(1);
						record.setUid(obj.getUserId());
						this.ShopBonusRepeatLogDao.save(record);
					}
				}

				if (integral > 0) {
					customerService.useOrderIntegralReturn(obj.getUserId(), integral, obj.getOrderId());
				}

				OrderLog ofl = new OrderLog();
				ofl.setAddTime(new Date());
				ofl.setLogInfo("取消订单");
				ofl.setLogUserId(currUserId);
				ofl.setOfId(obj.getId());
				if (state_info.equals("other")) {
					ofl.setStateInfo(other_state_info);
				} else {
					ofl.setStateInfo(state_info);
				}
				this.orderFormLogService.save(ofl);
				SellerBO seller = sellerService.selectByStore(obj.getStoreId());
				Map map = new HashMap();
				if (seller != null) {
					map.put("seller_id", seller.getUid());
				}
				map.put("order_id", obj.getId().toString());
				String json = Json.toJson(map);
				if (obj.getOrderForm() == 0) {
					/*msgTools.sendEmailCharge(CommUtil.getURL(request), "email_toseller_order_cancel_notify",
							seller.getEmail(), json, null, CommUtil.null2String(obj.getStoreId()));
					msgTools.sendEmailCharge(CommUtil.getURL(request), "sms_toseller_order_cancel_notify",
							seller.getMobile(), json, null, CommUtil.null2String(obj.getStoreId()));*/
				}
			}
		}
	}

	/**
	 * 计算订单所使用的积分
	 * 
	 * @param order
	 * @return
	 */
	public int calcOrderIntegral(OrderForm order) {
		int useIntegral = 0;// 使用积分
		List<Map> list = orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		for (Map map : list) {
			if (CommUtil.null2Boolean(map.get("is_integral_price"))) {
				useIntegral += CommUtil.null2Int(map.get("exchange_integral"))
						* CommUtil.null2Int(map.get("goods_count"));
			}
		}
		return useIntegral;
	}

	public boolean batchDelete(List<Serializable> orderFormIds) {
		for (Serializable id : orderFormIds) {
			delete((Long) id);
		}
		return true;
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(OrderForm.class,construct,
	// query,
	// params, this.orderFormDao);
	// if (properties != null) {
	// PageObject pageObj = properties.getPageObj();
	// if (pageObj != null)
	// pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	// .getCurrentPage(), pageObj.getPageSize() == null ? 0
	// : pageObj.getPageSize());
	// } else
	// pList.doList(0, -1);
	// return pList;
	// }

	public boolean update(OrderForm orderForm) {
		this.orderFormDao.update(orderForm);
		return true;
	}

	// public List<OrderForm> query(String query, Map params, int begin, int
	// max) {
	// return this.orderFormDao.query(query, params, begin, max);
	//
	// }

	// @Override
	// public List queryFromOrderForm(String query, Map params, int begin, int
	// max) {
	// // Auto-generated method stub
	// return this.orderFormDao.query(query, params, begin, max);
	// }
	public void findPageByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		/* List<OrderFormBO> content = */this.orderFormDao.findListByVo(page, vo);
		// page.setContent(content);
	}

	public List<OrderFormBO> findAllPageByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		return this.orderFormDao.findAllListByVo(page, vo);
	}
	

	public int countByCnd(int status, Long userId, Integer notOrderCat) {

		return orderFormDao.countByStatus(status, userId, null, notOrderCat);
	}

	public List<OrderFormBO> statusCount(long userId) {
		return orderFormDao.statusCount(userId);
	}

	/****
	 * 
	 * @param userId
	 * @param beginTime
	 * @param endTime
	 * @param order_id
	 * @param order_status
	 * @param page
	 * @param yungouFlag
	 *            云购币标识 0普通订单 1云购币订单
	 */
	public void queryByCnd(Long userId, String beginTime, String endTime, String order_id,
			String order_status, MyPage<OrderFormBO> page, Integer yungouFlag) {
		Integer status = null;
		if (order_status != null) {
			switch (order_status) {
				case "order_submit":
					status = 10;
					break;
				case "order_pay":
					status = 20;
					break;
				case "order_shipping":
					status = 30;
					break;
				case "order_receive":
					status = 40;
					break;
				case "order_finish":
					status = 50;
					break;
				case "order_cancel":
					status = 0;
					break;
				case "order_evaluate":
					status = 1;
					break;
				case "all":
					status = 100;
					break;
				default:
					break;
			}
		}
		OrderFormVO vo = new OrderFormVO();
		if (!CommUtil.null2String(beginTime).equals(""))
			vo.setBeginTime(beginTime);
		if (!CommUtil.null2String(endTime).equals("")) {
			endTime += " 23:59:59";
			vo.setEndTime(endTime);
		}
		if (StringUtils.isNotEmpty(order_id))
			vo.setOrderId(order_id.trim());
		if (StringUtils.isNotEmpty(order_status))
			vo.setOrderStatus(status + "");
		if (StringUtils.isBlank(order_status)) {
			vo.setOrderStatus("");
		}
		/*if (null != yungouFlag && yungouFlag.equals(0)) {// 标识普通产品.20170417屏蔽
			vo.setIsygOrder(false);
		}*/
		vo.setUserId(userId);
		//vo.setOrderMain(1);
		//List<OrderFormBO> content = this.orderFormDao.queryListByVo(page, vo);
		List<OrderFormBO> content = this.orderFormDao.queryAllOrderListByVo(page, vo);//
		if (null != content) {
			for (OrderFormBO item : content) {
				// 获取支付方式
				if (item.getPaymentId() != null) {
					Payment payment = this.paymentService.findById(item.getPaymentId());
					item.setPaymentName(payment.getName());
				}
			}
		}

		page.setContent(content);
	}

	public void queryListByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		orderFormDao.queryListByVo(page, vo);
	}

	public void findListPageByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		List<OrderFormBO> list = this.orderFormDao.queryListByVo(page, vo);
		page.setContent(list);

	}

	public List<OrderFormBO> findListPageByParam(MyPage<OrderFormBO> page, OrderFormVO vo) {
		return this.orderFormDao.queryListByVo(page, vo);
	}

	/**
	 * 保存确认收货（实物）
	 * 
	 * @param userId
	 * @param id
	 * @param url
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void orderCofirmSave(Long userId, String id, String url) throws Exception {
		OrderFormBO obj = fetch(CommUtil.null2Long(id));
		if (obj != null && obj.getUserId().toString().equals(userId.toString())
				&& obj.getOrderStatus() == 30) {
			/*
			 * double price = orderFormTools.query_order_price(obj);
			 * integralService.addIntegral(IntegralConstants.INTEGRAL_CONSUMER,
			 * obj.getUserId(), Math.round(price) + "", userId,
			 * "goods",obj.getPayTime());
			 */
			orderCofirmSaveCom(userId, url, obj);
		}
	}

	/**
	 * 将Goods的Json信息转化为List
	 * 
	 * @param goodsJsonStr
	 * @return
	 */
	public List<GoodsReceipt> jsonToGoodReceiptList(OrderForm obj) {
		List<GoodsReceipt> list = new ArrayList<GoodsReceipt>();
		List<Map> goodsJsonMap = this.orderFormTools.queryGoodsInfo(obj.getGoodsInfo());
		for (Map gJsonMap : goodsJsonMap) {
			GoodsReceipt goodsReceipt = new GoodsReceipt();
			goodsReceipt.setAddTime(new Date());
			goodsReceipt.setOfId(obj.getId());
			goodsReceipt.setUserId(obj.getUserId());
			goodsReceipt.setStoreId(obj.getStoreId());
			goodsReceipt.setGoodsId(CommUtil.null2Long(gJsonMap.get("goods_id")));
			goodsReceipt.setGoodsNum(CommUtil.null2Int(gJsonMap.get("goods_count")));
			goodsReceipt.setGoodsPrice(BigDecimal.valueOf(CommUtil.null2Double(gJsonMap.get("goods_price"))));
			goodsReceipt.setGoodsSpecIds(CommUtil.null2Long(gJsonMap.get("goods_gsp_ids")));
			goodsReceipt.setGoodsSpecVs(CommUtil.null2String(gJsonMap.get("goods_gsp_val")));
			list.add(goodsReceipt);
		}
		return list;
	}

	/**
	 * 确认收货；
	 * 
	 * @param userId
	 * @param url
	 * @param obj
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void orderCofirmSaveCom(Long userId, String url, OrderFormBO obj) throws Exception {
		// 将订单状态改为以收货
		if(null == obj || null == obj.getOrderStatus() || obj.getOrderStatus()>=40){
			return;
		}
		obj.setOrderStatus(40);
		boolean isCN = false ;
		Calendar ca = Calendar.getInstance();
		ca.add(ca.DATE, this.configService.getSysConfig().getAutoOrderReturn());
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String latertime = bartDateFormat.format(ca.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(latertime);
		obj.setReturnShipTime(date);
		obj.setConfirmTime(new Date());// 设置确认收货时间

		// 订单种类 0为商家，1为自营商品订单
		if (obj.getOrderForm() == 0) {
			Store store = this.storeService.getObjById(CommUtil.null2Long(obj.getStoreId()));
			Seller seller = sellerService.findByStore(CommUtil.null2Long(obj.getStoreId()));
			Map json_map = new HashMap();
			json_map.put("seller_id", seller.getUid());
			json_map.put("order_id", obj.getId().toString());
			String json = Json.toJson(json_map);
			// this.msgTools.sendEmailCharge(CommUtil.getURL(request),
			// "email_toseller_order_receive_ok_notify",
			// store.getUser().getEmail(), json, null, obj.getStore_id());
			// this.msgTools.sendSmsCharge(CommUtil.getURL(request),
			// "sms_toseller_order_receive_ok_notify",
			// store.getUser().getEmail(), json, null, obj.getStore_id());
			if (userId != null) {
				UserCustomer customer = customerService.queryUserByUid(userId);
				msgTools.sendEmailCharge(url, "email_toseller_order_cancel_notify", customer.getEmail(), json,
						null, CommUtil.null2String(store.getId()));
				msgTools.sendEmailCharge(url, "sms_toseller_order_cancel_notify", customer.getMobile(), json,
						null, CommUtil.null2String(store.getId()));
				isCN = userAccountService.check_User_Is_CN(userId);
			}
		}
		boolean ret = update(obj);// 更新订单

		double price = orderFormTools.query_order_price(obj);
		String iType = IntegralConstants.INTEGRAL_CONSUMER;
		if(null != obj.getPayTypeFlag()){
			if (obj.getPayTypeFlag() == 3 || obj.getPayTypeFlag() == 2){
				//	如果订单是平台积分+现金(普通会员)，加积分=现金+运费
				price = orderFormTools.query_order_cash_price(obj);
				if(!isCN){//普通会员 支付类型为2或者3的订单显示类型为积分+现金购物
					iType = IntegralConstants.INTEGRAL_MARK_AND_CASH;
				}
			}else if(obj.getPayTypeFlag() == 1){
				//	如果订单是重消支付，加积分只加运费部分
				price = orderFormTools.query_order_ship(obj);
			}
		}
		// 保存收货商品明细流水 ---改成一购买就添加购买记录，而不是收货后才添加
		// List<GoodsReceipt> listGoodsReceipt = jsonToGoodReceiptList(obj);
		// goodsReceiptDao.save(listGoodsReceipt);
		if (obj.getPayType() != null && obj.getPayType().equals("payafter")) {//
			this.updateGoodsInventory(obj);// 更新商品库存
		}

		if (ret) {// 订单状态更新成功，更新相关信息
			try {
				if(iType.equals(IntegralConstants.INTEGRAL_MARK_AND_CASH)){
					this.jingxunOrderBuyer(obj.getUserId(), price);
				}else{
					integralService.addIntegral(iType, obj.getUserId(),
							Math.round(price) + "", userId, "goods", obj.getPayTime());
				}
			} catch (Exception e) {
				log.error("[orderCofirmSaveCom] [addIntegral] error +" + e);
			}
			if (obj.getOrderMain() == 1 && !CommUtil.null2String(obj.getChildOrderDetail()).equals("")) {
				// 更新子订单状态信息
				List<Map> maps = this.orderFormTools.queryGoodsInfo(obj.getChildOrderDetail());
				for (Map map : maps) {
					OrderForm child_order = getObjById(CommUtil.null2Long(map.get("order_id")));
					child_order.setOrderStatus(40);
					child_order.setReturnShipTime(date);
					child_order.setConfirmTime(new Date());// 设置确认收货时间
					update(child_order);

					// // 保存收货商品明细流水
					// List<GoodsReceipt> listChildGoodsReceipt =
					// jsonToGoodReceiptList(child_order);
					// goodsReceiptDao.save(listChildGoodsReceipt);

					if (obj.getMark().equals("payafter")) {//
						// 如果买家支付方式为货到付款，买家确认收货，子订单商品销量增加
						List<Map> goods_map = this.orderFormTools.queryGoodsInfo(child_order.getGoodsInfo());
						for (Map child_map : goods_map) {
							Goods goods = this.goodsService
									.getObjById(CommUtil.null2Long(child_map.get("goods_id")));
							goods.setGoodsSalenum(goods.getGoodsSalenum()
									+ CommUtil.null2Int(child_map.get("goods_count")));// 增加商品销量
							saveGoodsReceipt(obj);//新增成交记录
							GoodsLog todayGoodsLog = this.goodsViewTools.getTodayGoodsLog(goods.getId());

							todayGoodsLog.setGoodsSalenum(todayGoodsLog.getGoodsSalenum()
									+ CommUtil.null2Int(child_map.get("goods_count")));
							Map<String, Integer> logordermap = null;
							if (todayGoodsLog.getGoodsOrderType() == null) {
								logordermap = Maps.newHashMap();
							} else {
								logordermap = (Map<String, Integer>) Json
										.fromJson(todayGoodsLog.getGoodsOrderType());
							}
							String ordertype = child_order.getOrderType();
							if (logordermap.containsKey(ordertype)) {
								logordermap.put(ordertype, logordermap.get(ordertype)
										+ CommUtil.null2Int(child_map.get("goods_count")));
							} else {
								logordermap.put(ordertype, CommUtil.null2Int(child_map.get("goods_count")));
							}
							todayGoodsLog.setGoodsOrderType(Json.toJson(logordermap, JsonFormat.compact()));

							Map<String, Integer> logspecmap = null;
							if (todayGoodsLog.getGoodsSaleInfo() == null) {
								logspecmap = Maps.newHashMap();
							} else {
								logspecmap = (Map<String, Integer>) Json
										.fromJson(todayGoodsLog.getGoodsSaleInfo());
							}
							String spectype = child_map.get("goods_gsp_val").toString();
							if (logspecmap.containsKey(spectype)) {
								logspecmap.put(spectype, logspecmap.get(spectype)
										+ CommUtil.null2Int(child_map.get("goods_count")));
							} else {
								logspecmap.put(spectype, CommUtil.null2Int(child_map.get("goods_count")));
							}
							todayGoodsLog.setGoodsSaleInfo(Json.toJson(logspecmap, JsonFormat.compact()));

							this.goodsLogService.update(todayGoodsLog);

							goods.setGoodsInventory(goods.getGoodsInventory()
									- CommUtil.null2Int(child_map.get("goods_count")));// 库存减少
							// if (goods.getGroupBuy() == 2) {//
							// 如果为团购商品，增加团购销量,减少团购库存
							// for (GroupGoods gg :
							// goods.getGroup_goods_list()) {
							// if
							// (gg.getGroup().getId().equals(goods.getGroup().getId()))
							// {
							// gg.setGg_selled_count(CommUtil.null2Int(gg.getGg_selled_count()
							// +
							// CommUtil.null2Int(map.get("goods_count"))));//
							// 增加团购销量
							// if (gg.getGg_count()// 减少团购库存
							// - CommUtil.null2Int(map.get("goods_count")) >
							// 0) {
							// gg.setGg_count(gg.getGg_count() -
							// CommUtil.null2Int(map.get("goods_count")));
							// } else {
							// gg.setGg_count(0);
							// }
							// this.ggService.update(gg);
							// }
							// }
							// }
							this.goodsService.update(goods);
						}
					}
					// 向子订单商家发送提醒信息，同时生成结算日志，如果子订单为平台自营，则不发送短信和邮件,
					if (child_order.getOrderForm() == 0) {
						Store store = this.storeService
								.getObjById(CommUtil.null2Long(child_order.getStoreId()));
						Map json_map = new HashMap();
						Seller seller = sellerService.findByStore(store.getId());
						json_map.put("seller_id", seller.getUid());
						json_map.put("childorder_id", child_order.getId().toString());
						String json = Json.toJson(json_map);
						if (obj.getOrderForm() == 0) {
							// this.msgTools.sendEmailCharge(url,
							// "email_toseller_order_receive_ok_notify",
							// store.getUser().getEmail(), json, null,
							// obj.getStore_id());
							// this.msgTools.sendSmsCharge(url,
							// "sms_toseller_order_receive_ok_notify",
							// store.getUser().getEmail(), json, null,
							// obj.getStore_id());
							UserCustomer customer = customerService.queryUserByUid(seller.getUid());
							try {
								msgTools.sendEmailCharge(url, "email_toseller_order_cancel_notify",
										customer.getEmail(), json, null, CommUtil.null2String(store.getId()));
								msgTools.sendEmailCharge(url, "sms_toseller_order_cancel_notify",
										customer.getMobile(), json, null,
										CommUtil.null2String(store.getId()));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// 订单生成商家结算日志
						PayoffLog plog = new PayoffLog();
						plog.setPlSn(
								"pl" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + seller.getUid());
						plog.setPlInfo("确认收货");
						plog.setAddTime(new Date());
						plog.setSellerId(seller.getUid());
						plog.setoId(CommUtil.null2String(child_order.getId()));
						plog.setOrderId(child_order.getOrderId().toString());
						plog.setCommissionAmount(child_order.getCommissionAmount());
						plog.setShipAmount(child_order.getShipPrice());
						plog.setStatus(1);
						// 该订单总佣金费用
						plog.setGoodsInfo(child_order.getGoodsInfo());
						plog.setOrderTotalPrice(child_order.getGoodsAmount());// 该订单总商品金额
						// 如果店家有使用优惠券的话
						String couponInfo = obj.getCouponInfo();
						if (StringUtils.isNotBlank(couponInfo)) {
							Map mapCoupon = orderFormTools.queryCouponInfo(couponInfo);
							BigDecimal couponAmount = new BigDecimal(
									mapCoupon.get("coupon_amount").toString());
							plog.setTotalAmount(BigDecimal.valueOf(CommUtil.subtract(
									child_order.getGoodsAmount()
											.add(plog.getShipAmount() != null ? plog.getShipAmount()
													: BigDecimal.ZERO),
									child_order.getCommissionAmount().add(couponAmount))));// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
						} else {
							plog.setTotalAmount(
									BigDecimal.valueOf(CommUtil.subtract(
											child_order.getGoodsAmount()
													.add(plog.getShipAmount() != null ? plog.getShipAmount()
															: BigDecimal.ZERO),
											child_order.getCommissionAmount())));// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
						}
						payoffLogservice.save(plog);

						// store.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.add(child_order.getGoodsAmount(),
						// store.getStoreSaleAmount())));// 店铺本次结算总销售金额
						// store.setStoreCommissionAmount(BigDecimal.valueOf(CommUtil.add(child_order.getCommissionAmount(),
						// store.getStoreCommissionAmount())));// 店铺本次结算总佣金
						// store.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.add(plog.getTotalAmount(),
						// store.getStorePayoffAmount())));// 店铺本次结算总佣金
						// this.storeService.update(store);

						this.storeDao
								.addStoreAmount(
										child_order.getCommissionAmount(), plog
												.getTotalAmount(),
										child_order.getGoodsAmount().add(plog.getShipAmount() != null
												? plog.getShipAmount() : BigDecimal.ZERO),
										store.getId());

						// 增加系统总销售金额、总佣金
						// SysConfig sc = configService.getSysConfig();
						// sc.setPayoffAllSale(BigDecimal.valueOf(CommUtil.add(child_order.getGoodsAmount(),
						// sc.getPayoffAllSale())));
						// sc.setPayoffAllCommission(BigDecimal.valueOf(CommUtil.add(child_order.getCommissionAmount(),
						// sc.getPayoffAllCommission())));
						// configService.update(sc);

						configService.addConfigAmount(null, null, child_order.getCommissionAmount(),
								child_order.getGoodsAmount().add(plog.getShipAmount() != null
										? plog.getShipAmount() : BigDecimal.ZERO));
					}
				}
			}
			// OrderFormLog ofl = new OrderFormLog();
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("确认收货");
			// ofl.setLog_user(SecurityUserHolder.getCurrentUser());
			ofl.setLogUserId(userId);
			// ofl.setOf(obj);
			ofl.setOfId(obj.getId());
			this.orderFormLogService.save(ofl);
			// 主订单生成商家结算日志
			if (obj.getOrderForm() == 0) {
				Store store = this.storeService.getObjById(CommUtil.null2Long(obj.getStoreId()));
				Seller seller = sellerService.findByStore(store.getId());
				PayoffLog plog = new PayoffLog();
				plog.setPlSn("pl" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + seller.getUid());
				plog.setPlInfo("确认收货");
				plog.setAddTime(new Date());
				// plog.setSeller(store.getUser());
				plog.setSellerId(seller.getUid());
				plog.setoId(CommUtil.null2String(obj.getId()));
				plog.setOrderId(obj.getOrderId().toString());
				plog.setCommissionAmount(obj.getCommissionAmount());// 该订单总佣金费用
				plog.setShipAmount(obj.getShipPrice());
				plog.setStatus(1);
				plog.setGoodsInfo(obj.getGoodsInfo());

				String couponInfo = obj.getCouponInfo();
				plog.setOrderTotalPrice(obj.getGoodsAmount());// 该订单总商品金额

				if (StringUtils.isNotBlank(couponInfo)) {
					Map mapCoupon = orderFormTools.queryCouponInfo(couponInfo);
					BigDecimal couponAmount = new BigDecimal(mapCoupon.get("coupon_amount").toString());
					plog.setTotalAmount(BigDecimal.valueOf(CommUtil.subtract(
							obj.getGoodsAmount()
									.add(plog.getShipAmount() != null ? plog.getShipAmount()
											: BigDecimal.ZERO),
							obj.getCommissionAmount().add(couponAmount))));// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
				} else {
					plog.setTotalAmount(
							BigDecimal
									.valueOf(
											CommUtil.subtract(
													obj.getGoodsAmount()
															.add(plog.getShipAmount() != null
																	? plog.getShipAmount() : BigDecimal.ZERO),
											obj.getCommissionAmount())));// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
				}
				payoffLogservice.save(plog);
				// // 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
				// store.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.add(obj.getGoodsAmount(),
				// store.getStoreSaleAmount())));// 店铺本次结算总销售金额
				// store.setStoreCommissionAmount(BigDecimal.valueOf(CommUtil.add(obj.getCommissionAmount(),
				// store.getStoreCommissionAmount())));// 店铺本次结算总佣金
				// store.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.add(plog.getTotalAmount(),
				// store.getStoreCommissionAmount())));// 店铺本次结算总佣金
				// this.storeService.update(store);
				// // 增加系统总销售金额、总佣金
				// SysConfig sc = this.configService.getSysConfig();
				// sc.setPayoffAllSale(BigDecimal.valueOf(CommUtil.add(obj.getGoodsAmount(),
				// sc.getPayoffAllSale())));
				// sc.setPayoffAllCommission(BigDecimal.valueOf(CommUtil.add(obj.getCommissionAmount(),
				// sc.getPayoffAllCommission())));
				// this.configService.update(sc);
				this.storeDao.addStoreAmount(obj.getCommissionAmount(), plog.getTotalAmount(),
						obj.getGoodsAmount()
								.add(plog.getShipAmount() != null ? plog.getShipAmount() : BigDecimal.ZERO),
						store.getId());
				configService.addConfigAmount(null, null, obj.getCommissionAmount(), obj.getGoodsAmount()
						.add(plog.getShipAmount() != null ? plog.getShipAmount() : BigDecimal.ZERO));
			}
		}
		// }
	}

	/**
	 * 修改订单中商品的库存信息
	 * 
	 * @param order
	 */
	public void updateGoodsInventory(OrderForm order) {
		// 付款成功，订单状态更新，同时更新商品库存，如果是团购商品，则更新团购库存
		log.error("=====进入");
		List<Map> map_list = this.orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		Map<Goods, List<String>> goodsMap = Maps.newHashMap();
		for (Map map : map_list) {
			Goods goods = new Goods(CommUtil.null2Long(map.get("goods_id")));
			if (goodsMap.containsKey(goods)) {
				List<String> gspList = goodsMap.get(goods);
				String gspId = CommUtil.null2String(map.get("goods_gsp_ids"));
				if (StringUtils.isNotBlank(gspId)) {
					gspList.add(gspId);
				}
			} else {
				goods = this.goodsService.getObjById(CommUtil.null2Long(map.get("goods_id")));
				List<String> gspList = new ArrayList<>();
				String gspId = CommUtil.null2String(map.get("goods_gsp_ids"));
				if (StringUtils.isNotBlank(gspId)) {
					gspList.add(gspId);
				}
				goodsMap.put(goods, gspList);
			}
		}
		// 普通商品更新信息
		for (Map.Entry<Goods, List<String>> entry : goodsMap.entrySet()) {

			Goods goods = entry.getKey();
			List<String> gspList = entry.getValue();

			GoodsLog todayGoodsLog = this.goodsViewTools.getTodayGoodsLog(goods.getId());

			// 商品本次销量
			int goods_count = 0;
			// 库存类型
			String inventory_type = goods.getInventoryType() == null ? "all" : goods.getInventoryType();
			// 是否库存报警
			boolean inventory_warn = false;
			if (gspList.isEmpty()) {
				// 如果非sku销售,以商品本身为准
				goods_count = this.orderFormTools.queryOfGoodsCount(CommUtil.null2String(order.getId()),
						CommUtil.null2String(goods.getId()), null);
				Map<String, Integer> logordermap = null;
				if (todayGoodsLog.getGoodsOrderType() == null) {
					logordermap = Maps.newHashMap();
				} else {
					logordermap = (Map<String, Integer>) Json.fromJson(todayGoodsLog.getGoodsOrderType());
				}
				String ordertype = order.getOrderType();
				if (logordermap.containsKey(ordertype)) {
					logordermap.put(ordertype, logordermap.get(ordertype) + goods_count);
				} else {
					logordermap.put(ordertype, goods_count);
				}
				todayGoodsLog.setGoodsOrderType(Json.toJson(logordermap, JsonFormat.compact()));
			} else {
				// sku 库存配制
				List<HashMap> goodsInventoryDetailList = Json.fromJson(ArrayList.class,
						CommUtil.null2String(goods.getGoodsInventoryDetail()));

				// 如果sku销售，需每个sku清算库存
				for (String gsp : gspList) {
					int specCount = this.orderFormTools.queryOfGoodsCount(CommUtil.null2String(order.getId()),
							CommUtil.null2String(goods.getId()), gsp);
					goods_count += specCount;

					String[] specIds = gsp.split(",");
					String spectype = "";
					for (String specId : specIds) {
						// 这里需要检查是否是这个
						GoodsSpecPropertyBO sp = goodsSpecPropertyDao.findBOById(CommUtil.null2Long(specId));
						if (sp != null) {
							spectype += sp.getSpec().getName() + ":" + sp.getValue() + " ";
						}
					}
					// 设置商品log每sku的销量
					Map<String, Integer> logspecmap = null;
					if (todayGoodsLog.getGoodsSaleInfo() == null) {
						logspecmap = Maps.newHashMap();
					} else {
						logspecmap = (Map<String, Integer>) Json.fromJson(todayGoodsLog.getGoodsSaleInfo());
					}
					if (logspecmap.containsKey(spectype)) {
						logspecmap.put(spectype, logspecmap.get(spectype) + goods_count);
					} else {
						logspecmap.put(spectype, goods_count);
					}
					todayGoodsLog.setGoodsSaleInfo(Json.toJson(logspecmap, JsonFormat.compact()));

					// 如果库存配制不为全部，减少每个sku的库存
					if (!inventory_type.equals("all")) {
						String[] gsps = gsp.split(",");
						for (Map temp : goodsInventoryDetailList) {
							String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
							Arrays.sort(temp_ids);
							Arrays.sort(gsps);
							if (Arrays.equals(temp_ids, gsps)) {
								int inventory = CommUtil.null2Int(temp.get("count")) - specCount;
								// 库存如果小于0，设置为0
								if (inventory < 0) {
									inventory = 0;
								}
								temp.put("count", inventory);
								if (CommUtil.null2Int(temp.get("count")) <= CommUtil
										.null2Int(temp.get("supp"))) {
									inventory_warn = true;
								}
							}
						}
					}
				}
				if (!inventory_type.equals("all")) {
					goods.setGoodsInventoryDetail(
							Json.toJson(goodsInventoryDetailList, JsonFormat.compact()));
				}

			}
			// 设置商品销售量
			goods.setGoodsSalenum(goods.getGoodsSalenum() + goods_count);
			saveGoodsReceipt(order);//新增成交记录
			// 设置当前商品log销售量
			if (todayGoodsLog.getGoodsSalenum() == null) {
				todayGoodsLog.setGoodsSalenum(0);
			}
			todayGoodsLog.setGoodsSalenum(todayGoodsLog.getGoodsSalenum() + goods_count);

			this.goodsLogService.update(todayGoodsLog);

			// 如果库存为all,统一库存管理
			if (inventory_type.equals("all")) {
				goods.setGoodsInventory(goods.getGoodsInventory() - goods_count);
				// 库存如果小于0，设置为0
				if (goods.getGoodsInventory() < 0) {
					goods.setGoodsInventory(0);
				}
				if (goods.getGoodsInventory() <= goods.getGoodsWarnInventory()) {
					inventory_warn = true;
				}
			}
			// for (GroupGoods gg : goods.getGroup_goods_list()) {
			// if (gg.getGroup().getId().equals(goods.getGroup().getId()) &&
			// gg.getGg_count() == 0) {
			// goods.setGroup_buy(3);// 标识商品的状态为团购数量已经结束
			// }
			// }
			if (inventory_warn) {
				goods.setWarnInventoryStatus(-1);// 该商品库存预警状态
			}
			
			Long activityGoodsId = CommUtil.null2Long(10121);//不等于 1元购的 修改库存//临时处理抢购商品
			if (!goods.getId().equals(activityGoodsId)) {//不等于 1元购的 修改库存
				this.goodsService.update(goods);
			}
			
			// 更新lucene索引
			// luceneUtil.update(CommUtil.null2String(goods.getId()),
			// luceneVoTools.updateGoodsIndex(goods));
		}
	}

	/**
	 * 发送订单完成付款的消息
	 * 
	 * @param result
	 * @param webPath
	 */
	private void sendCompletePayMsg(List<OrderForm> result, String webPath) {
		try {
			for (OrderForm orderForm : result) {
				// 主订单付款成功，发送邮件提示
				// 向加盟商家发送付款成功邮件提示，自营商品无需发送邮件提示
				if (orderForm.getOrderMain() == 1) {
					this.send_msg_tobuyer(webPath, orderForm);
					this.send_msg_toseller(webPath, orderForm);
				} else {
					// 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
					// 付款成功，发送邮件提示
					this.send_msg_toseller(webPath, orderForm);
				}
			}
		} catch (Exception e) {
			log.error("发送订单完成付款消息失败", e);
		}
	}

	/**
	 * 向买家、商家发送短信、邮件提醒订单在线付款成功！
	 * 
	 * @param request
	 * @param order
	 * @throws Exception
	 */
	private void send_msg_tobuyer(String webPath, OrderForm order) throws Exception {
		UserCustomer buyer = this.customerService.findSessionUser(order.getUserId());

		msgTools.sendSms("sms_tobuyer_store_order_pay_notify", buyer.getMobile(), order.getOrderId());
	}

	/**
	 * 向买家、商家发送短信、邮件提醒订单在线付款成功！
	 * 
	 * @param request
	 * @param order
	 * @throws Exception
	 */
	private void send_msg_toseller(String webPath, OrderForm order) throws Exception {
		if (order.getOrderForm() == OrderFormConstants.ORDER_FORM_SELLER) {
			Seller seller = this.sellerService.findByStore(CommUtil.null2Long(order.getStoreId()));
			this.msgTools.sendEmailCharge(webPath, "email_toseller_online_pay_ok_notify", seller.getEmail(),
					null, CommUtil.null2String(order.getId()), order.getStoreId());
			this.msgTools.sendSmsCharge(webPath, "sms_toseller_online_pay_ok_notify", seller.getMobile(),
					null, CommUtil.null2String(order.getId()), order.getStoreId());
			// 发送短信
			String[] params = null;
			String mobile = seller.getMobile();
			log.info("商家电话：" + mobile);
			// 当商户对应的mobile字段为null或未空时
			// 获取该商户对应绑定手机号码作为短信通知
			// add by yuleijia on 2017.4.26
			if (mobile == null || mobile.trim().length() == 0) {
				Long uid = seller.getUid();
				UserAccountBO userAccount = new UserAccountBO();
				userAccount.setUid(uid);
				userAccount.setAccountType(UserContant.ACCOUNT_TYPE_2);
				UserAccountBO phoneUserAccount = this.userAccountDao.findAccountByVo(userAccount);
				if (phoneUserAccount != null) {
					mobile = phoneUserAccount.getLoginName();
					log.info("【商家电话为空，使用绑定手机号码】->" + mobile);
				}
			}
			this.msgTools.sendSms("sms_toseller_online_shipments_notify", mobile, params);
			// TODO 商户收款通知
			// noticeMessageService.pushReceiveMoneyMessage(seller.getUid(), order.getTotalPrice(),
			// order.getId());
		}
	}

	/**
	 * 保存用户评价(接口调用)
	 * 
	 * @param evaluateInfo
	 */
	@Transactional(readOnly = false)
	public int evaluateSave(Long uid, String evaluateInfo) throws ServiceException {
		OrderEvaluateVO vo = JSON.parseObject(evaluateInfo, OrderEvaluateVO.class);
		if (vo.getId() != null) {
			OrderForm obj = this.getObjById(vo.getId());
			if (obj != null && obj.getUserId().equals(uid) && obj.getOrderStatus().equals(40)) {
				OrderLog ofl = new OrderLog();
				ofl.setAddTime(new Date());
				ofl.setLogInfo("评价订单");
				ofl.setLogUserId(uid);
				ofl.setOfId(obj.getId());
				this.orderFormLogService.save(ofl);

				// 商品评论列表
				for (com.sinco.carnation.order.vo.EvaluateVO element : vo.getEvaluate()) {
					boolean flag = Pattern.matches("^[1-5]", element.getServiceEvaluate().toString());
					boolean flag1 = Pattern.matches("^[1-5]", element.getShipEvaluate().toString());
					boolean flag2 = Pattern.matches("^[1-5]", element.getDescription().toString());
					boolean flag3 = Pattern.matches("^(-1)|(0)|(1)$",
							element.getEvaluateBuyerVal().toString());
					// 判断参数是否合法
					if (flag && flag1 && flag2 && flag3) {
						Evaluate eva = new Evaluate();
						Goods goods = this.goodsService.getObjById(element.getGoodsId());
						eva.setAddTime(new Date());
						eva.setEvaluateGoodsId(goods.getId());
						goods.setEvaluateCount(goods.getEvaluateCount() + 1);
						eva.setGoodsNum(element.getGoodsCount());
						eva.setGoodsPrice(element.getGoodsPrice().toString());
						eva.setGoodsSpec(element.getGoodsGspVal());
						// 评论内容有关键词
						if (wordFind.find(element.getEvaluateInfo()).length > 0) {
							return 600;
						}
						eva.setEvaluateInfo(element.getEvaluateInfo());
						eva.setEvaluatePhotos(element.getImgPath());
						eva.setEvaluateBuyerVal(element.getEvaluateBuyerVal());// 1//
																				// 0
																				// //
																				// -1
						eva.setDescriptionEvaluate(
								BigDecimal.valueOf(CommUtil.null2Double(element.getDescription())));
						eva.setServiceEvaluate(
								BigDecimal.valueOf(CommUtil.null2Double(element.getServiceEvaluate())));
						eva.setShipEvaluate(
								BigDecimal.valueOf(CommUtil.null2Double(element.getShipEvaluate())));
						eva.setEvaluateType("goods");
						eva.setEvaluateUserId(uid);
						eva.setOfId(obj.getId());
						OrderForm of = this.getObjById(vo.getId());
						eva.setOfId(of.getId());
						eva.setReplyStatus(0);
						eva.setEvaluateStatus(0);
						evaluateService.save(eva);

						if (goods.getGoodsType() == 1) {
							Store store = this.storeService
									.getObjById(CommUtil.null2Long(goods.getGoodsStoreId()));
							List<EvaluateBO> evas = evaluateService.queryByStoreId(store.getId());
							double store_evaluate = 0;
							double description_evaluate = 0;
							double description_evaluate_total = 0;
							double service_evaluate = 0;
							double service_evaluate_total = 0;
							double ship_evaluate = 0;
							double ship_evaluate_total = 0;
							DecimalFormat df = new DecimalFormat("0.0");
							for (Evaluate eva1 : evas) {
								description_evaluate_total = description_evaluate_total
										+ CommUtil.null2Double(eva1.getDescriptionEvaluate());
								service_evaluate_total = service_evaluate_total
										+ CommUtil.null2Double(eva1.getServiceEvaluate());
								ship_evaluate_total = ship_evaluate_total
										+ CommUtil.null2Double(eva1.getShipEvaluate());
							}
							description_evaluate = CommUtil
									.null2Double(df.format(description_evaluate_total / evas.size()));
							service_evaluate = CommUtil
									.null2Double(df.format(service_evaluate_total / evas.size()));
							ship_evaluate = CommUtil
									.null2Double(df.format(ship_evaluate_total / evas.size()));
							store_evaluate = (description_evaluate + service_evaluate + ship_evaluate) / 3;// 综合评分=三项具体评分之和/3
							store.setStoreCredit(store.getStoreCredit() + eva.getEvaluateBuyerVal());
							this.storeService.update(store);
							StorePoint point = storePointService.fetchByStoreId(store.getId());
							if (null == point)
								point = new StorePoint();
							point.setAddTime(new Date());
							point.setStoreId(store.getId());
							point.setDescriptionEvaluate(
									BigDecimal.valueOf(description_evaluate > 5 ? 5 : description_evaluate));
							point.setServiceEvaluate(
									BigDecimal.valueOf(service_evaluate > 5 ? 5 : service_evaluate));
							point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 : ship_evaluate));
							point.setStoreEvaluate(
									BigDecimal.valueOf(store_evaluate > 5 ? 5 : store_evaluate));
							if (point.getId() != null && point.getId() > 0) {
								this.storePointService.update(point);
							} else {
								this.storePointService.save(point);
							}
						} else {
							User sp_user = this.userService.getObjById(obj.getEvaUserId());
							List<EvaluateBO> evas = evaluateService.queryByUserId(uid);
							double store_evaluate = 0;
							double description_evaluate = 0;
							double description_evaluate_total = 0;
							double service_evaluate = 0;
							double service_evaluate_total = 0;
							double ship_evaluate = 0;
							double ship_evaluate_total = 0;
							DecimalFormat df = new DecimalFormat("0.0");
							for (Evaluate eva1 : evas) {
								description_evaluate_total = description_evaluate_total
										+ CommUtil.null2Double(eva1.getDescriptionEvaluate());
								service_evaluate_total = service_evaluate_total
										+ CommUtil.null2Double(eva1.getServiceEvaluate());
								ship_evaluate_total = ship_evaluate_total
										+ CommUtil.null2Double(eva1.getShipEvaluate());
							}
							description_evaluate = CommUtil
									.null2Double(df.format(description_evaluate_total / evas.size()));
							service_evaluate = CommUtil
									.null2Double(df.format(service_evaluate_total / evas.size()));
							ship_evaluate = CommUtil
									.null2Double(df.format(ship_evaluate_total / evas.size()));
							store_evaluate = (description_evaluate + service_evaluate + ship_evaluate) / 3;
							StorePoint point = storePointService.fetchByUserId(obj.getEvaUserId());
							if (null == point)
								point = new StorePoint();
							point.setAddTime(new Date());
							point.setUserId(sp_user.getId());
							point.setDescriptionEvaluate(
									BigDecimal.valueOf(description_evaluate > 5 ? 5 : description_evaluate));
							point.setServiceEvaluate(
									BigDecimal.valueOf(service_evaluate > 5 ? 5 : service_evaluate));
							point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 : ship_evaluate));
							point.setStoreEvaluate(
									BigDecimal.valueOf(store_evaluate > 5 ? 5 : store_evaluate));
							if (null != point.getId() && point.getId() > 0) {
								this.storePointService.update(point);
							} else {
								this.storePointService.save(point);
							}
						}

						this.goodsService.update(goods);
						// User user =
						// this.userService.getObjById(CommUtil.null2Long(obj.getUserId()));
						UserCustomerBO user = customerService.queryUserByUid(obj.getUserId());
						// // 增加评价积分
						// user.setIntegral(user.getIntegral() +
						// this.configService.getSysConfig().getIndentComment());
						// 增加用户消费金额
						user.setUserGoodsFee(BigDecimal
								.valueOf(CommUtil.add(user.getUserGoodsFee(), obj.getTotalPrice())));

						try {
							integralService.addIntegral(IntegralConstants.INTEGRAL_EVALUATE, obj.getUserId(),
									null);
						} catch (Exception e) {
							log.error("add integral is unsuccess userid = evaluation.getEvaluateUserId()");
						}

						// this.userService.update(user);
						// 记录积分明细
						// if (this.configService.getSysConfig().isIntegral()) {
						// }
						// if (configService.getSysConfig().getIntegral()) {
						// IntegralLog log = new IntegralLog();
						// log.setAddtime(new Date());
						// log.setContent("订单评价增加" +
						// this.configService.getSysConfig().getIndentComment()
						// + "分");
						// log.setIntegral(this.configService.getSysConfig().getIndentComment());
						// log.setIntegralUserId(user.getUid());
						// log.setType("order");
						// this.integralLogService.save(log);
						// }
					} else {
						throw new ServiceException();
					}
				}

				obj.setOrderStatus(50);
				obj.setFinishTime(new Date());
				this.update(obj);
				return 100;
			} else {
				return 300;
			}
		}
		return 400;
	}

	/**
	 * 追加评论保存(接口调用)
	 * 
	 * @param uid
	 * @param evalId
	 * @param evalInfo
	 * @param imgPath
	 */
	@Transactional(readOnly = false)
	public int evaluateAddSave(Long uid, Long evalId, String evalInfo, String imgPath) {
		EvaluateBO eva = this.evaluateService.queryEvaluateById(CommUtil.null2Long(evalId));
		String goods_id = eva.getEvaluateGoodsId().toString();
		OrderFormBO obj = this.fetch(eva.getOfId());
		// Goods goods =
		// this.goodsService.getObjById(CommUtil.null2Long(goods_id));
		if (orderFormTools.evaluate_able(obj.getFinishTime()) == 0) {
			return 200;// 已超出评价追加期限
		} else {
			if (obj != null && obj.getUserId().equals(uid)) {
				if (obj.getOrderStatus().equals(50)) {
					OrderLog ofl = new OrderLog();
					ofl.setAddTime(new Date());
					ofl.setLogInfo("追加评价订单");
					ofl.setLogUserId(uid);
					ofl.setOfId(obj.getId());
					this.orderFormLogService.save(ofl);

					if (eva.getAddevaStatus() == 0) {
						eva.setAddevaStatus(1);
						eva.setAddevaInfo(evalInfo);
						eva.setAddevaPhotos(imgPath);
						eva.setAddevaTime(new Date());
						evaluateService.save(eva);
					}
				}
				return 100;// 订单追加评价成功
			} else {
				return 300;// 订单信息错误
			}
		}
	}

	/**
	 * 保存收货商品明细流水
	 * 
	 * @param order
	 */
	private void saveGoodsReceipt(OrderForm order) {
		if (order != null) {
			// 保存父订单商品明细流水
			List<GoodsReceipt> listGoodsReceipt = jsonToGoodReceiptList(order);
			goodsReceiptDao.save(listGoodsReceipt);
			if (order.getOrderMain() == 1 && !CommUtil.null2String(order.getChildOrderDetail()).equals("")) {
				List<Map> maps = this.orderFormTools.queryGoodsInfo(order.getChildOrderDetail());
				for (Map map : maps) {
					OrderForm child_order = getObjById(CommUtil.null2Long(map.get("order_id")));
					// 保存子订单商品明细流水
					List<GoodsReceipt> listChildGoodsReceipt = jsonToGoodReceiptList(child_order);
					goodsReceiptDao.save(listChildGoodsReceipt);
				}
			}
		}
	}

	/***
	 * 云购币支付1
	 * 
	 * @param order
	 *            订单信息
	 * @param uid
	 *            用户Id
	 * @param order_total_price
	 *            订单价格
	 * @param yunGouPassword
	 *            云购币支付密码
	 * @throws ServiceException
	 */
	public OrderForm yunGouMoneyPayService(OrderForm order, Long uid, double order_total_price,
			String yunGouPassword, String payIp) throws ServiceException {

		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);// 用户id
		vo.setAccountType("8");// CN账户类型
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		if (account != null) { // 说明有有CN账户

			CnUserMoneyBO repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());// 获取Cn账户的重消余额（云购币）

			if (repeatBo != null) {
				if (repeatBo.getBONUS_REPEAT() >= order_total_price) {

					int payType = 3;// 表示重消(云购币)
					order = this.yunGouMoneyPay(order.getId(), order_total_price, yunGouPassword, payIp,
							payType, account.getLoginName());

//					this.saveGoodsReceipt(order);

				} else {
					throw new ServiceException("云购币不够");
				}

			} else {
				throw new ServiceException("CN账户为空");
			}

		} else {
			throw new ServiceException("本地没有CN账号");
		}
		return order;
	}

	/***
	 * 
	 * 云购币支付2
	 * 
	 * @param mainOrderId
	 * @param order_total_price
	 * @param yunGouPassword
	 * @param payIp
	 * @param payType
	 * @param loginName
	 * @return
	 * @throws ServiceException
	 */
	private OrderForm yunGouMoneyPay(Long mainOrderId, double order_total_price, String yunGouPassword,
			String payIp, int payType, String loginName) throws ServiceException {

		OrderForm order = this.getObjById(mainOrderId);
		// 异步没有出来订单，则同步处理订单
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}
		String logInfo = order.getOrderId() + "订单购物使用云购币";

		Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_MONEY);// 查询支付方式(云购币)
		// 调用云购币支付方法
		CnUserPayBO cnUserPayBO = this.cnPayBaseService.OrderPay(payType, loginName, order.getOrderId(),
				CommUtil.null2BigDecimal(order_total_price), yunGouPassword, payIp);

		if (cnUserPayBO.getISPAY().equals("0")) {
			throw new ServiceException("云购币支付失败");
		}
		// 添加云购币/奖金 日志 信息
		String returnTransactionalNo = cnUserPayBO.getDEAL_NUMBER();
		ShopBonusRepeatLog record = new ShopBonusRepeatLog();
		record.setDateTime(new Date());
		record.setOrderId(order.getOrderId());
		record.setPayType(3);
		record.setReturnTracNo(returnTransactionalNo);
		record.setTotalPrice(CommUtil.null2BigDecimal(order_total_price));
		record.setType(0);
		record.setUsedRepeatMoney(CommUtil.null2BigDecimal(order_total_price));
		record.setUserAlias(loginName);
		record.setUid(order.getUserId());
		this.addBonusRepeatLog(record);
		// 添加日志
		return completePay(mainOrderId, payment.getId(), null, logInfo);
	}

	/***
	 * 获取CN账户户奖金
	 * 
	 */
	private BigDecimal getBonus(BigDecimal pdAmount, Long uid) throws ServiceException {
		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);
		vo.setAccountType("8");
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		if (account != null) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(account.getLoginName());
			if (cnUserMoneyBO != null) {
				BigDecimal resBonus = CommUtil.null2BigDecimal(cnUserMoneyBO.getBONUS());
				return resBonus;
			} else {
				return new BigDecimal(0);
			}
		} else {
			return new BigDecimal(0);
		}
	}

	/***
	 * 
	 * 云豆 和 奖金 支付
	 * 
	 * @param mainOrderId
	 *            订单Id
	 * @param password
	 *            云豆密码
	 * @param payMsg
	 * @param bonusPassword
	 *            奖金支付密码
	 * @param BigDecimal
	 *            availableBalance 云豆账户剩余
	 * @param BigDecimal
	 *            pdAmount 还需要支付
	 * @param user_alias
	 *            cn账户 用户名
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm bonusAndBlance(Long mainOrderId, String password, String payMsg, String bonusPassword,
			BigDecimal availableBalance, BigDecimal pdAmount, Long uid) throws ServiceException {
		OrderForm order = this.getObjById(mainOrderId);
		// 异步没有出来订单，则同步处理订单
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}

		Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_BALANCE);

		double orderTotalPrice = this.orderFormTools.query_order_price(order);

		String logInfo = order.getOrderId() + "订单购物减少可用云豆";

		boolean bo = false;

		bo = moneyService.consumptionMoney2(order.getUserId(), orderTotalPrice, password, logInfo,
				bonusPassword, availableBalance, pdAmount, order.getOrderId());

		if (!bo) {
			throw new ServiceException("云豆支付失败");
		}

		return completePay(mainOrderId, payment.getId(), null, logInfo);
	}

	/***
	 * 添加云购币/奖金 日志 信息
	 * 
	 * @param record
	 */
	public void addBonusRepeatLog(ShopBonusRepeatLog record) {
		ShopBonusRepeatLog log = this.ShopBonusRepeatLogDao.save(record);
	}

	/***
	 * 获取CN账户户云购币
	 * 
	 */
	private BigDecimal getRepeat(BigDecimal pdAmount, Long uid) throws ServiceException {
		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);
		vo.setAccountType("8");
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		if (account != null) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());
			if (cnUserMoneyBO != null) {
				BigDecimal resRepeat = CommUtil.null2BigDecimal(cnUserMoneyBO.getBONUS_REPEAT());
				return resRepeat;
			} else {
				return new BigDecimal(0);
			}
		} else {
			return new BigDecimal(0);
		}
	}

	private boolean validatCNPassword(String userAlias, String password, Long uid) {
		boolean bl = false;
		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);
		vo.setAccountType("8");
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		CnValidatPasswordBO pwd = this.cnPayBaseService.validatPassword2(account.getLoginName(), password);
		if (0 == pwd.getISPAY()) {// 错误
			bl = false;
		}
		if (1 == pwd.getISPAY().intValue()) {// 正确
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断用户用哪种支付方式。
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public SelectYgPayModeBO selectYgPayMode(String orderId, Long userId) {
		SelectYgPayModeBO bo = new SelectYgPayModeBO();
		Double actualygPrice = 0.0;// 实际需要用云购币多少
		Double actualPrice = 0.0;// 实际需要用现金多少
		Double s = 0.0;

		Double ygPrice = 0.0;// 订单云购币总和
		Double totalPrice = 0.0;// 订单现金总和

		Double repeatBO = 0.0;// 用户云购币余额
		Double bounsBO = 0.0;// 用户奖金余额
		Double rechargeBO = 0.0;// 用户充值账户余额

		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		if (order == null) {
			bo.setRes(501);
			return bo;// 订单异常
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			bo.setRes(502);
			return bo;// 订单已支付
		}
		if (null == order.getIsygOrder() || !order.getIsygOrder()) {
			bo.setRes(503);
			return bo;// 该订单不是云购币订单
		}
		bo.setOrder(order);
		if (null != order.getAllygPrice()) {
			ygPrice = order.getAllygPrice().doubleValue();
		}
		if (null != order.getAllCashPrice()) {
			BigDecimal shipPrice = new BigDecimal(0.0);
			if (null != order.getShipPrice()) {
				shipPrice = order.getShipPrice();
			}
			totalPrice = order.getAllCashPrice().doubleValue();
			// totalPrice = shipPrice.add(order.getAllCashPrice()).doubleValue();// 加上订单的运费
		}

		UserAccountBO vo = new UserAccountBO();
		vo.setUid(userId);
		vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccountBO accountBO = userAccountDao.findAccountByVo(vo);// 查询CN账户名
		if (accountBO == null) {
			bo.setRes(504);
			return bo;// 该账户非CN账户
		}
		Map map = new HashMap();
		map.put("USER_ALIAS", accountBO.getLoginName());
		map.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_YG);
		CnMoneyBO cn_repeatBO = cnPayBaseService.getCnUserCxWalletView(map);// 云购币
		if (null != cn_repeatBO && null != cn_repeatBO.getMONEY() && null != cn_repeatBO.getWALLET_STATUS()) {
			repeatBO = cn_repeatBO.getMONEY();
			bo.setyGWallet_status(Double.valueOf(cn_repeatBO.getWALLET_STATUS()).intValue());
			bo.setCurrentYgBalance(repeatBO);
			if (bo.getyGWallet_status() == 5) {// 账户被冻结
				repeatBO = 0.0;
			}
		}
		Map map_1 = new HashMap();
		map_1.put("USER_ALIAS", accountBO.getLoginName());
		map_1.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_JJ);
		CnMoneyBO cn_bounsBO = cnPayBaseService.getCnUserCxWalletView(map_1);// 奖金账户
		if (null != cn_bounsBO && null != cn_bounsBO.getMONEY() && null != cn_bounsBO.getWALLET_STATUS()) {
			bounsBO = cn_bounsBO.getMONEY();
			bo.setjJWallet_status(Double.valueOf(cn_bounsBO.getWALLET_STATUS()).intValue());
			bo.setCurrentJjBalance(bounsBO);
			if (bo.getjJWallet_status() == 5) {// 账户被冻结
				bounsBO = 0.0;
			}
		}
		if (repeatBO - ygPrice >= 0) {
			actualygPrice = ygPrice;
		} else {
			actualygPrice = repeatBO;
			s = ygPrice - repeatBO;// 云购币不足,需要用现金补
			BigDecimal b1 = new BigDecimal(totalPrice.toString());
			BigDecimal b2 = new BigDecimal(s.toString());
			totalPrice = new Double(b1.add(b2).doubleValue());// 总共需要用多少现金支付
		}

		if (bounsBO > 0 && bounsBO - totalPrice >= 0) {
			actualPrice = totalPrice;
			bo.setRes(10);
			bo.setActualPrice(actualPrice);
			bo.setActualygPrice(actualygPrice);
			bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_JJ);
			return bo;// 奖金账户余额充足,用奖金账户支付
		} else {
			Map map_2 = new HashMap();
			map_2.put("USER_ALIAS", accountBO.getLoginName());
			map_2.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_CZ);
			CnMoneyBO cn_rechargeBO = cnPayBaseService.getCnUserCxWalletView(map_2);// 充值账户
			if (null != cn_rechargeBO && null != cn_rechargeBO.getMONEY()
					&& null != cn_rechargeBO.getWALLET_STATUS()) {
				rechargeBO = cn_rechargeBO.getMONEY();
				bo.setcZWallet_status(Double.valueOf(cn_rechargeBO.getWALLET_STATUS()).intValue());
				bo.setCurrentCzBalance(rechargeBO);
				if (bo.getcZWallet_status() == 5) {// 账户被冻结
					rechargeBO = 0.0;
				}
			}
			if (rechargeBO > 0 && rechargeBO - totalPrice >= 0) {
				actualPrice = totalPrice;
				bo.setRes(20);
				bo.setActualPrice(actualPrice);
				bo.setActualygPrice(actualygPrice);
				bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_CZ);
				return bo;// 奖金账户余额不足，充值账户余额充足,用充值账户支付
			} else {
				actualPrice = totalPrice;
				bo.setRes(30);
				bo.setActualPrice(actualPrice);
				bo.setActualygPrice(actualygPrice);
				bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_CASH);
				return bo;// 充值账户与奖金账户余额都不足，只能用第三方支付支付
			}
		}

	}

	public OrderFormBO selectById(String order_id) {
		OrderFormBO order = orderFormDao.selectListById(CommUtil.null2Long(order_id));
		return order;
	}

	/**
	 * 
	 * @param payMode
	 *            直销支付类型1:工资 2:充值 3:第三方支付
	 * @param orderId
	 *            订单id
	 * @param password
	 *            CN账户二级密码
	 * @param actualygPrice
	 *            实际支付云购币
	 * @param actualPrice
	 *            实际支付现金
	 * @param user_id
	 *            当前登录用户id
	 * @param payMentid
	 *            支付方式id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int ygorder_Pay(int payMode, String orderId, String password, String actualygPrice,
			String actualPrice, Long user_id, Long payMentid) throws ServiceException {
		// steup one:检查订单状态
		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		if (null == order) {
			return 501;// 订单参数错误
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return 502;// 订单已支付
		}
		if (null == order.getIsygOrder() || !order.getIsygOrder()) {
			return 503;// 该订单非云购币订单
		}
		if (StringUtils.isEmpty(password)) {
			return 85;
		}
		// steup two:验证商品库存，是否下架
		boolean inventory_very = true;
		boolean goods_status = true; // 订单中产品类型
		List<GoodsBO> goods_list = this.orderFormTools.queryOfGoods(orderId);
		for (GoodsBO obj : goods_list) {
			if (obj.getGoodsStatus() != 0) {
				goods_status = false;
				break;
			}
			int order_goods_count = this.orderFormTools.queryOfGoodsCount(orderId.toString(),
					CommUtil.null2String(obj.getId()), obj.getGoodsSpecIds());
			// 真实商品库存
			int real_goods_count = CommUtil.null2Int(this.goodsService
					.generic_default_info(obj, obj.getGoodsSpecIds(), new UserCustomer()).get("count"));// 计算商品库存信息
			if (order_goods_count > real_goods_count) {
				inventory_very = false;
				break;
			}
		}
		if (!inventory_very) {// 订单中商品库存验证
			// throw new ServiceException("订单中商品库存不足，请重新下单");
			return 504;// 订单中商品库存不足，请重新下单
		}
		if (!goods_status) {// 订单产品状态查询
			// throw new ServiceException("订单中存在下架产品，请重新下单");
			return 505;// 订单中存在下架产品，请重新下单
		}
		// steup three:查看订单是否已支付云购币
		if (order.getOrderStatus() == OrderFormConstants.ORDER_STATUS_TO_BE_YG) {// 订单已支付云购币
			// 产生订单交易号
			this.updateOrderPayment(order, payMentid);
		} else {// 订单未支付云购币
				// steup four去支付
			int s = this.yGorder_pay(password, Double.valueOf(actualygPrice), Double.valueOf(actualPrice),
					order.getOrderId(), payMode, user_id);
			if (s != 100) {
				return s;
			}
			// steup five:更新订单状态-完成订单添加相关订单日志发送订单支付成功消息
			order.setActualPrice(new BigDecimal(actualPrice));
			order.setActualygPrice(new BigDecimal(actualygPrice));
			order.setPaymentId(CommUtil.null2Long(payMentid));// 这里是支付方式
			if (payMode == 3) {
				order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_YG);
			} else {
				order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
			}
			int res = this.complete_ygOrder(order);
			if (res != 100) {
				return res;
			}
			// this.saveGoodsReceipt(order);
			return 100;
		}
		return 100;
	}

	/**
	 * 调用直销支付接口，扣相应的款，记录日志
	 * 
	 * @param password2
	 *            :CN账户二级密码
	 * @param actualygPrice
	 *            :实际支付云购余额
	 * @param actualPrice
	 *            :实际支付现金
	 * @param orderId
	 *            :订单id
	 * @param payMode
	 *            :直销支付类型1:工资 2:充值 3:第三方支付
	 * @param user_id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int yGorder_pay(String password2, Double actualygPrice, Double actualPrice, String orderId,
			int payMode, Long user_id) throws ServiceException {
		UserAccountBO vo = new UserAccountBO();
		vo.setUid(user_id);
		vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccountBO accountBO = userAccountDao.findAccountByVo(vo);// 查询CN账户名

		CnValidatPasswordBO vPwd = this.cnPayBaseService.validatPassword2(accountBO.getLoginName(),
				password2);
		if (null != vPwd && vPwd.getISPAY().intValue() == 0) {
			throw new ServiceException("支付密码错误");
		}

		if (accountBO == null) {
			return 506;// 该账户非CN账户
		}
		CnYgOrderPayBO orderpayRes = cnPayBaseService.ygOrderPay(accountBO.getLoginName(), password2,
				actualygPrice, actualPrice, orderId, payMode);
		if (null == orderpayRes || null == orderpayRes.getPAY_STATUS_1()) {
			return 509;// 支付错误
		}
		if (orderpayRes.getPAY_STATUS_1() != OrderFormConstants.GET_USER_CX_WALLET_PAY_100) {
			return Integer.valueOf(orderpayRes.getPAY_STATUS_1());// 返回支付失败原因
		}
		// 添加云购币日志信息
		int payType = 0;
		if (payMode == 1) {
			payType = 10;// 奖金+云购币支付
		} else if (payMode == 2) {
			payType = 11;// 充值+云购币支付
		} else {
			payType = 12;// 第三方支付+云购币支付
			actualPrice = 0.0;// 第三方支付日志，回调时成功时更新第三方支付,如订单未支付完成需清理掉
		}
		ShopBonusRepeatLog record = new ShopBonusRepeatLog();
		record.setDateTime(new Date());
		record.setOrderId(orderId);
		record.setPayType(payType);
		record.setReturnTracNo(orderpayRes.getDEAL_NUMBER_1() + "|" + orderpayRes.getDEAL_NUMBER_2());
		BigDecimal b1 = new BigDecimal(actualPrice);// 含运费
		BigDecimal b2 = new BigDecimal(actualygPrice);
		record.setTotalPrice(b1.add(b2));
		record.setUsedBonusPrice(b1);
		record.setUsedRepeatMoney(b2);
		record.setUserAlias(accountBO.getLoginName());
		record.setType(0);
		record.setUid(user_id);
		this.ShopBonusRepeatLogDao.save(record);
		return 100;
	}

	/**
	 * 订单完成
	 * 
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int complete_ygOrder(OrderForm order) {
		List<OrderForm> result = new ArrayList<>();
		SysConfigBO config = this.configService.getSysConfig();
		if (order == null) {
			return 501;
		}
		if (order.getIsygOrder() != true) {
			return 503;// 该订单非云购币订单
		}
		if (OrderFormConstants.ORDER_STATUS_TO_BE_YG == order.getOrderStatus()) {// 云购币+第三方支付时
			// 当订单为云购币+第三方支付时才产生
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
			// 使用在线支付,设置在线支付方式
			// order.setPaymentId(payMentId);
			order.setPayType("online");
		}
		order.setPayTime(new Date());
		this.orderFormDao.update(order);
		result.add(order);
		if (OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED == order.getOrderStatus()) {// 当订单为云购币订单+现金全部完成，才执行
			// 主订单付款成功，订单状态更新
//			this.saveGoodsReceipt(order);// 当订单全支付完成，保存产品成交记录
			String logInfo = order.getOrderId() + "云购订单消费金额";
			updateGoodsInventory(order);
			OrderLog main_ofl = new OrderLog();
			main_ofl.setAddTime(new Date());
			main_ofl.setLogInfo(logInfo);
			main_ofl.setLogUserId(order.getUserId());
			main_ofl.setOfId(order.getId());
			this.orderFormLogService.save(main_ofl);// shop_order_log
			// 发送完成付款消息
			sendCompletePayMsg(result, config.getAddress());
		}
		return 100;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateOrderPayment(OrderForm order, Long payId) {
		// 产生订单支付id
		String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
		// 使用在线支付,设置在线支付方式
		order.setPaymentId(payId);
		order.setPayType("online");
		this.orderFormDao.update(order);
		log.error("云购币线上支付订单：" + "order-" + trade_no + "-" + order.getId().toString());
	}

	/**
	 * 当云购币订单状态为半付款状态18，超过72小时未支付现金的订单，退款-取消订单
	 * 
	 * @return
	 */
	public int return_ygOrder() {
		// 查询超过72小时，订单状态为18的订单
		List<OrderForm> order_list = orderFormDao.selectPayFailureOrder();
		if (null != order_list && order_list.size() > 0) {
			for (OrderForm order : order_list) {
				String cn_useralias = order.getCnUseralias();// cn编号
				BigDecimal actualygPrice = order.getActualygPrice();// 已支付的云购币
				int type = 3;// 退款类型3重消
				String order_id = order.getOrderId();// 订单号
				CnRenturnYgOrderBO bo = null;
				if (StringUtils.isEmpty(cn_useralias)) {
					log.error(order_id + "[云购币订单异常cn_useralias is null orderID=]" + order_id);
				} else {
					bo = cnPayBaseService.return_ygOrder(cn_useralias, type, actualygPrice, order_id);
				}
				if (!StringUtils.isEmpty(cn_useralias) && null != bo
						&& Double.valueOf(bo.getRETURN_STATUS()).intValue() == 100) {// 退款成功
					order.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
					this.orderFormDao.update(order);
					OrderLog log = new OrderLog();
					log.setDeleteStatus(0);
					log.setLogInfo(order_id + "订单由于超过72小时内未付现金，退还云购币:" + actualygPrice);
					log.setLogUserId(order.getUserId());
					log.setOfId(order.getId());
					this.orderFormLogService.save(log);
					// 退还云购币日志
					ShopBonusRepeatLog record = new ShopBonusRepeatLog();
					record.setDateTime(new Date());
					record.setOrderId(order_id);
					record.setPayType(1);
					record.setUsedRepeatMoney(actualygPrice);
					record.setUserAlias(cn_useralias);
					record.setType(1);
					record.setUid(order.getUserId());
					this.ShopBonusRepeatLogDao.save(record);
				} else {
					log.error(order_id + "[云购币订单，退款失败error，返回结果]"
							+ ((null == bo) ? null : bo.getRETURN_STATUS()));
				}
			}
		} else {
			log.info("未查到符合退款条件云购币订单");
		}
		return 0;
	}

	/**
	 * 
	 * @param type
	 * @param tradeNo
	 * @param totalFee
	 * @param orderNo
	 * @param paymentType
	 * @return
	 */
	public OrderForm handle_ygorder(String orderId, String outOrderId, double totalFee) {
		// 当云购币订单云购币与现金都支付完成，该订单才为完成，同时要添加
		log.info("orderId===" + orderId + "outOrderId==" + outOrderId + "totalFee===" + totalFee);
		OrderForm orderForm = this.orderFormDao.fetch(Long.valueOf(orderId));
		if (null != orderForm && null != orderForm.getIsygOrder() && orderForm.getIsygOrder() == true
				&& orderForm.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			orderForm.setActualPrice(new BigDecimal(totalFee));
			orderForm.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
			this.complete_ygOrder(orderForm);
			orderForm = this.orderFormDao.fetch(CommUtil.null2Long(orderId));
			// 更新订单支付现金信息
			ShopBonusRepeatLog vo = new ShopBonusRepeatLog();
			vo.setOrderId(orderForm.getOrderId());
			vo.setType(0);
			ShopBonusRepeatLog record = ShopBonusRepeatLogDao.getByVo(vo);
			if (null != record) {
				BigDecimal b1 = new BigDecimal(totalFee);// 含运费
				record.setTotalPrice(b1.add(record.getUsedBonusPrice()));
				ShopBonusRepeatLogDao.update(record);
			}
			return orderForm;
		}
		return orderForm;
	}

	/**
	 * 查询订单
	 * 
	 * @param order
	 * @param type
	 * @return
	 */
	public ShopBonusRepeatLog getBonusLogsByOrderId(String orderId, int type) {
		// 更新订单支付现金信息
		ShopBonusRepeatLog vo = new ShopBonusRepeatLog();
		vo.setOrderId(orderId);
		vo.setType(type);
		ShopBonusRepeatLog record = ShopBonusRepeatLogDao.getByVo(vo);
		return record;
	}

	public ZeroGoods getZeroGoods(Long goodsId) {
		ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(goodsId);
		return zeroGoods;
	}

	public boolean checkOrderGoodsZero(OrderForm order) {
		boolean bl = false;
		List<Map> map_list = this.orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		for (Map map : map_list) {
			Long goodsId = CommUtil.null2Long(map.get("goods_id"));
			ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(goodsId);
			if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
				bl = true;
			}
		}
		return bl;
	}

	public void updateZeroGoodsInventory(OrderForm order) throws ServiceException {

		List<Map> map_list = this.orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		for (Map map : map_list) {
			Long goodsId = CommUtil.null2Long(map.get("goods_id"));
			Integer count = CommUtil.null2Int(map.get("goods_count"));
			ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(goodsId);
			if (null != zeroGoods && zeroGoods.getGoodsStatus()) {

				if (zeroGoods.getGoodsInventory() >= count) {
					ZeroGoods record = new ZeroGoods();
					record.setGoodsInventory(zeroGoods.getGoodsInventory() - count);
					record.setGoodsSalenum(zeroGoods.getGoodsSalenum() + count);
					record.setId(zeroGoods.getId());
					this.zeroGoodsDao.update(record);
				} else {
					throw new ServiceException("0元购产品数量不够！");
				}

			} else {
				throw new ServiceException("0元购产品状态错误！");
			}
		}

	}

	/***
	 * 根据 userId 和 是否是 0元购订单
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */

	public boolean isBought(MyPage<OrderFormBO> page, Long userId, Long goodsId) {
		boolean bl = true;

		if (null != userId) {
			OrderFormVO vo = new OrderFormVO();
			vo.setUserId(userId);// 用户ID
			vo.setOrderTypeFlag(1);// 表示0元购产品
			vo.setOrderStatus(CommUtil.null2String(100));//
			List<OrderFormBO> order = this.orderFormDao.queryListByVo(page, vo);
			if (null != order && order.size() > 0) {
				for (OrderFormBO bo : order) {
					int flag = 0;

					List<Map> map_list = this.orderFormTools.queryGoodsInfo(bo.getGoodsInfo());

					for (Map map : map_list) {
						Long resGoodsId = CommUtil.null2Long(map.get("goods_id"));
						if (null != resGoodsId && resGoodsId.intValue() == goodsId.intValue()) {
							bl = false;// 表示购买过
							flag = 1;
							break;
						}
					}

					if (flag == 1) {
						break;
					}
				}
			}
		}
		return bl;
	}

	/**
	 * 超过3分钟未支付的0元购订单设置为取消状态
	 */

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cancelZeroOrder() {
		List<OrderFormBO> bos = this.orderFormDao.findCancelZeroActOrder();
		for (OrderFormBO bo : bos) {
			if (bo != null) {
				// 取消0元购订单返回库存
				this.zeroOrderCancel(bo.getId());
			}
		}
	}

	/**
	 * 返回库存
	 * 
	 * @param record
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private void cancelZeroOrderReturn(OrderForm record, String info) {
		info = info.substring(1, info.length() - 1);
		JSONObject jsonObject = JSONObject.fromObject(info);
		String goodsId = jsonObject.getString("goods_id");
		String goodsCount = jsonObject.getString("goods_count");
		if (CommUtil.isNotNull(goodsCount) && CommUtil.isNotNull(goodsCount)) {
			ZeroGoods rtZeroGoods = zeroGoodsDao.getByGoodsId(Long.valueOf(goodsId));
			if (rtZeroGoods != null) {
				ZeroGoods save = new ZeroGoods();
				save.setId(rtZeroGoods.getId());
				save.setGoodsInventory(rtZeroGoods.getGoodsInventory() + Integer.valueOf(goodsCount));
				save.setGoodsSalenum(rtZeroGoods.getGoodsSalenum() - Integer.valueOf(goodsCount));
				zeroGoodsDao.save(save);
			}
		}
	}

	/**
	 * 取消0元购订单返回库存 id:订单id
	 */
	public void zeroOrderCancel(Long id) {
		OrderForm record = new OrderForm();
		record.setId(id);
		record.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
		log.info("[cancelZeroActOrder] this orderForm time out , id=" + id);
		// 订单状态修改为取消状态
		this.orderFormDao.update(record);
		OrderForm orderForm = this.orderFormDao.findOne(id);
		// 返回库存
		cancelZeroOrderReturn(record, orderForm.getGoodsInfo());
	}

	// /////////////////////////////////////////////////////////////////////////////////////////云购币支付

	/***
	 * 
	 * 云购币加云豆(奖金的支付方式)
	 * 
	 * @param orderId
	 *            订单ID uid 会员ID yunGouPassword 云购币 等于 奖金 支付密码
	 * 
	 *            payIp 支付Ip availableBalance 云豆 [本地账户余额]
	 */
	public OrderForm yungouMoneyAndBalance(Long orderId, Long uid, String yunGouPassword, String payIp,
			Double availableBalance) throws ServiceException {

		OrderFormBO order = this.fetch(orderId);
		OrderForm resOrderForm = null;// 返回对象
		if (order == null) {
			throw new ServiceException("参数错误");
		}

		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);// 用户id
		vo.setAccountType("8");// CN账户类型
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		CnUserMoneyBO repeatBo = null;

		try {
			repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());// 获取Cn账户的重消余额（云购币）
		} catch (Exception e) {
			throw new ServiceException("结算系统出错");
		}

		BigDecimal orderNeedYgb = order.getAllygPrice();// 订单需要多少云购币
		BigDecimal orderNeedCash = order.getAllCashPrice();// 订单需要多少云豆
		BigDecimal orderActualygPrice = order.getActualygPrice();// 订单已支付云豆

		boolean bl = this.checkOrderisPay(order.getActualygPrice());// 检查是否已经支付过

		if (bl) {// 表示没有支付过

			if (repeatBo.getISPAY().intValue() == 1
					&& repeatBo.getBONUS_REPEAT() >= CommUtil.null2Double(orderNeedYgb)) { // 云购币账户
				// 满足
				// 订单需要的云购币

				try {

					if (null != orderNeedCash && orderNeedCash.compareTo(new BigDecimal(0)) > 0) {// 一:说明订单需要现金值(云豆)支付

						if (availableBalance >= CommUtil.null2Double(orderNeedCash)) { // 1:本地账户余额满足订单要现金值(云豆)

							Integer payType = 3;
							CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(
									account.getLoginName(), yunGouPassword,
									CommUtil.null2Double(orderNeedYgb), CommUtil.null2Double(0),
									order.getOrderId(), payType);
							if (cnUserPayBO.getPAY_STATUS_1().intValue() == 100) {
								this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
										order.getTotalPrice(), 0, payType, orderNeedYgb,
										account.getLoginName(), uid, CommUtil.null2BigDecimal(0),
										CommUtil.null2BigDecimal(0));

								order.setActualygPrice(orderNeedYgb);
								this.update(order);// 填充 支付记录

							} else {
								throw new ServiceException("结算系统支付异常");
							}

							Integer flag = 0;// 表示只需要本地云豆不需要奖金
							resOrderForm = this.completeMoneyPayForYunGou(orderId, flag,
									CommUtil.null2Double(orderNeedCash), account.getLoginName(),
									yunGouPassword);

							resOrderForm.setActualPrice(orderNeedCash);
							this.update(resOrderForm);// 填充 支付记录

						} else {// 2:本地账户余额不满足订单要现金值(云豆)，需要查看 奖金账户

							Integer flag = 2;// 表示 需要云豆和奖金
							resOrderForm = this.completeMoneyPayForYunGou(orderId, flag,
									CommUtil.null2Double(orderNeedCash), account.getLoginName(),
									yunGouPassword);
						}

					} else {// 3:说明不需要现金值(云豆)支付，使用云购币就可以,可能不需要

						Integer flag = 3;// 表示不需要云豆和奖金
						resOrderForm = this.completeMoneyPayForYunGou(orderId, flag,
								CommUtil.null2Double(orderNeedCash), account.getLoginName(), yunGouPassword);
					}

				} catch (Exception e) {
					log.info("yungouMoneyAndBalance 云购币支付异常" + e);
					throw new ServiceException("云购币支付异常");
				}

			} else {// 云购币账户 不满足-- 订单还需要的云豆

				/*
				 * this.bonusAndBlanceForYunGou2(orderId,
				 * account.getLoginName(), repeatBo.getBONUS_REPEAT(),
				 * availableBalance, yunGouPassword);
				 */
				resOrderForm = this.bonusAndBlanceForYunGou4(orderId, uid, account.getLoginName(),
						yunGouPassword);
			}

		} else { // 已经支付过 从订单列表中进去 可能不需要

			BigDecimal balance = orderNeedYgb.add(orderNeedCash).subtract(orderActualygPrice);// 还需要支付多少

			if (availableBalance > CommUtil.null2Double(balance)) { // 本地云豆 满足剩余

				Integer flag = 0;// 表示只需要本地云豆不需要奖金
				resOrderForm = this.completeMoneyPayForYunGou(orderId, flag, CommUtil.null2Double(balance),
						account.getLoginName(), yunGouPassword);
				order.setActualygPrice(balance);
				this.update(resOrderForm);// 填充 支付记录
			} else {

				Integer flag = 2;// 表示不需要云豆和奖金
				resOrderForm = this.completeMoneyPayForYunGou(orderId, flag, CommUtil.null2Double(balance),
						account.getLoginName(), yunGouPassword);
				order.setActualygPrice(balance);
				this.update(resOrderForm);// 填充 支付记录
			}

		}
		return resOrderForm;

	}

	/***
	 * 
	 * 云购币支付逻辑
	 * 
	 * @param orderId
	 *            订单ID flag 0 表示云豆满足 1表示云豆加奖金 3表示不需要云豆和奖金 needBalance 需要支付的云豆 userAlias CN 编号 bonusPassword
	 *            云购币 奖金 密码
	 * 
	 * 
	 */
	public OrderForm completeMoneyPayForYunGou(Long orderId, Integer flag, Double needBalance,
			String userAlias, String bonusPassword) throws ServiceException {

		OrderForm order = this.getObjById(orderId);
		OrderForm resOrderForm = null;
		// 异步没有出来订单，则同步处理订单
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}

		// 本地云豆满足
		if (flag.intValue() == 0) {
			Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币加云豆
			String logInfo = order.getOrderId() + "订单购物减少可用云豆";
			boolean bo = moneyService.consumptionMoney(order.getUserId(), needBalance, logInfo);

			if (!bo) {
				throw new ServiceException("云豆支付失败");
			}
			resOrderForm = completePay(orderId, payment.getId(), null, logInfo);
		}

		// 需要云豆和奖金支付、
		if (flag.intValue() == 2) {

			/*
			 * this.bonusAndBlanceForYunGou(orderId, needBalance,
			 * order.getUserId(), userAlias, bonusPassword, order.getOrderId());
			 */

			resOrderForm = this.bonusAndBlanceForYunGou3(orderId, needBalance, order.getUserId(), userAlias,
					bonusPassword, order.getOrderId());
		}

		// 不需要云豆和奖金 直接完成订单
		if (flag.intValue() == 3) {
			String logInfo = order.getOrderId() + "全云购币订单";
			Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_MONEY);// 云购币支付订单
			resOrderForm = completePay(orderId, payment.getId(), null, logInfo);
		}
		return resOrderForm;
	}

	public OrderForm bonusAndBlanceForYunGou3(Long orderId, Double needBalance, Long uid, String userAlias,
			String bonusPassword, String orderNo) throws ServiceException {
		OrderForm resOrderForm = null;
		OrderForm order = this.getObjById(orderId);
		double availableBalance = this.moneyService.getAvailableBalance(uid);// 本地云豆
		CnUserMoneyBO repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(userAlias);// 获取Cn账户的重消余额（云购币）

		BigDecimal orderCashPrice = order.getAllCashPrice();// 订单需要的现金
		BigDecimal orderYgPrice = order.getAllygPrice();// 订单需要的云购币
		BigDecimal countAmount = orderCashPrice.add(orderYgPrice);// 需要的总金额

		if (null != repeatBo && null != repeatBo.getBONUS_REPEAT()) {
			Integer payType = 1;
			if (repeatBo.getBONUS_REPEAT() > CommUtil.null2Double(orderYgPrice)) {

				BigDecimal subBonus = orderCashPrice.subtract(CommUtil.null2BigDecimal(availableBalance));// 订单需要的现金
																											// -
																											// 本地云豆
																											// =
																											// 奖金需要支付的
				CnYgOrderPayBO cnYgOrderPayBO = this.cnPayBaseService.ygOrderPay(userAlias, bonusPassword,
						CommUtil.null2Double(orderYgPrice), CommUtil.null2Double(subBonus),
						order.getOrderId(), payType);
				log.info("[orcl] method=GET_USER_CX_WALLET_PAY, result code="
						+ cnYgOrderPayBO.getPAY_STATUS_1());
				if (cnYgOrderPayBO.getPAY_STATUS_1().intValue() != 100) {
					log.error("[orcl] method=GET_USER_CX_WALLET_PAY, error result." + "moneyone="
							+ orderYgPrice.doubleValue() + "moneytwo=" + subBonus.doubleValue()
							+ "cn account=" + userAlias + " code=" + cnYgOrderPayBO.getPAY_STATUS_1());
					throw new ServiceException("直销系统，云购币扣取失败!");
				}
				this.yungouMoneyPaySaveLog(order.getOrderId(), cnYgOrderPayBO.getDEAL_NUMBER_1(),
						order.getTotalPrice(), 0, 3, orderYgPrice, userAlias, uid, subBonus,
						CommUtil.null2BigDecimal(0));
				order.setActualygPrice(orderYgPrice);
				String pdLogInfo = "购买商品减少云豆";
				boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
						CommUtil.null2BigDecimal(availableBalance));// 本地云豆支付
				order.setActualPrice(subBonus.add(CommUtil.null2BigDecimal(availableBalance)));
				this.update(order);
				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单
				String logInfo = "购买上品减少云豆奖金";
				resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);
				// 减少本地云豆
			} else {// 云购币不足
				BigDecimal yg = orderYgPrice.subtract(CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()));// 支付的云购币
				BigDecimal cash = yg.add(orderCashPrice);// 云购币还需要支付的金额 加上
															// 订单需要的现金
				BigDecimal subBonus = cash.subtract(CommUtil.null2BigDecimal(availableBalance));// 支付的奖金

				CnYgOrderPayBO cnYgOrderPayBO = this.cnPayBaseService.ygOrderPay(userAlias, bonusPassword,
						CommUtil.null2Double(yg), CommUtil.null2Double(subBonus), order.getOrderId(),
						payType);

				if (cnYgOrderPayBO.getPAY_STATUS_1().intValue() != 100) {
					log.error("[orcl] method=GET_USER_CX_WALLET_PAY, error result." + "moneyone="
							+ orderYgPrice.doubleValue() + "moneytwo=" + subBonus.doubleValue()
							+ "cn account=" + userAlias + " code=" + cnYgOrderPayBO.getPAY_STATUS_1());
					throw new ServiceException("直销系统，云购币扣取失败!");
				}

				this.yungouMoneyPaySaveLog(order.getOrderId(), cnYgOrderPayBO.getDEAL_NUMBER_1(),
						order.getTotalPrice(), 0, 3, yg, userAlias, uid, subBonus,
						CommUtil.null2BigDecimal(0));

				order.setActualygPrice(yg);

				String pdLogInfo = "购买商品减少云豆";
				boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
						CommUtil.null2BigDecimal(availableBalance));// 本地云豆支付
				order.setActualPrice(subBonus.add(CommUtil.null2BigDecimal(availableBalance)));

				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单
				String logInfo = "购买上品减少云豆奖金";
				resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);
			}

		}
		return resOrderForm;
	}

	public OrderForm bonusAndBlanceForYunGou4(Long orderId, Long uid, String userAlias, String bonusPassword)
			throws ServiceException {
		OrderForm resOrderForm = null;
		OrderForm order = this.getObjById(orderId);
		double availableBalance = this.moneyService.getAvailableBalance(uid);// 本地云豆
		CnUserMoneyBO repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(userAlias);// 获取Cn账户的重消余额（云购币）
		BigDecimal bonus = this.getBonus(null, uid);// 奖金

		BigDecimal orderCashPrice = order.getAllCashPrice();// 订单需要的现金
		BigDecimal orderYgPrice = order.getAllygPrice();// 订单需要的云购币
		BigDecimal countAmount = orderCashPrice.add(orderYgPrice);// 需要的总金额

		if (null == repeatBo || repeatBo.getBONUS_REPEAT() == null || repeatBo.getBONUS_REPEAT() <= 0
				|| repeatBo.getISPAY().intValue() != 1) {

			if (availableBalance > CommUtil.null2Double(countAmount)) {

				String pdLogInfo = "订单减少云豆";
				boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
						CommUtil.null2BigDecimal(countAmount));// 本地云豆支付
				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单
				String logInfo = "购买上品减少云豆奖金";
				resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);

			} else {

				// 先扣除奖金 再 扣除本地云豆
				Integer payType = 1;
				CnYgOrderPayBO cnYgOrderPayBO = this.cnPayBaseService.ygOrderPay(userAlias, bonusPassword,
						CommUtil.null2Double(0), CommUtil.null2Double(bonus), order.getOrderId(), payType);

				if (cnYgOrderPayBO.getPAY_STATUS_1().equals(100)) {
					this.yungouMoneyPaySaveLog(order.getOrderId(), cnYgOrderPayBO.getDEAL_NUMBER_1(),
							order.getTotalPrice(), 0, 1, CommUtil.null2BigDecimal(0), userAlias, uid, bonus,
							CommUtil.null2BigDecimal(0));
				}

				BigDecimal sub = countAmount.subtract(bonus);

				String pdLogInfo = "订单减少云购币";
				boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
						CommUtil.null2BigDecimal(sub));// 本地云豆支付

				order.setActualPrice(countAmount);
				this.update(order);
				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单
				String logInfo = "购买上品减少云豆奖金";
				resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);
			}

		} else {

			Integer payType = 1;
			BigDecimal yg = repeatBo.getBONUS_REPEAT().doubleValue() <= orderYgPrice.doubleValue()
					? orderYgPrice.subtract(CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()))
					: new BigDecimal(0);// 支付的云购币
			BigDecimal cash = yg.add(orderCashPrice);// 云购币还需要支付的金额 加上 订单需要的现金
			BigDecimal subBonus = availableBalance < cash.doubleValue()
					? cash.subtract(CommUtil.null2BigDecimal(availableBalance)) : new BigDecimal(0);// 支付的奖金

			CnYgOrderPayBO cnYgOrderPayBO = this.cnPayBaseService.ygOrderPay(userAlias, bonusPassword,
					CommUtil.null2Double(repeatBo.getBONUS_REPEAT()), CommUtil.null2Double(subBonus),
					order.getOrderId(), payType);

			if (cnYgOrderPayBO.getPAY_STATUS_1().equals(100)) {

				this.yungouMoneyPaySaveLog(order.getOrderId(), cnYgOrderPayBO.getDEAL_NUMBER_1(),
						order.getTotalPrice(), 0, 3, yg, userAlias, uid, subBonus,
						CommUtil.null2BigDecimal(0));

				order.setActualygPrice(yg);

				String pdLogInfo = "购买商品减少云豆";
				boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
						CommUtil.null2BigDecimal(availableBalance));// 本地云豆支付
				order.setActualPrice(subBonus.add(CommUtil.null2BigDecimal(availableBalance)));

				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单
				String logInfo = "购买上品减少云豆奖金";
				resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);

			}

		}

		return resOrderForm;

	}

	/****
	 * 云购币 + {云豆+奖金支付}
	 * 
	 * 
	 * @param orderId
	 *            订单Id @param needBalance 需要的云豆 @param uid 会员Id userAlias CN会员编号 bonusPassword 奖金 云购币 支付密码
	 *            orderNo 订单编号 @throws
	 */
	public OrderForm bonusAndBlanceForYunGou(Long orderId, Double needBalance, Long uid, String userAlias,
			String bonusPassword, String orderNo) throws ServiceException {
		OrderForm order = this.getObjById(orderId);
		OrderForm resOrderForm = null;
		double availableBalance = this.moneyService.getAvailableBalance(uid);// 本地云豆

		if (availableBalance < needBalance) {// 本地账户余额 小于 需要支付的云豆

			String pdLogInfo = "购买商品减少云豆";
			boolean bl = this.moneyService.consumptionMoney3(uid, pdLogInfo,
					CommUtil.null2BigDecimal(availableBalance));// 本地云豆支付
			if (bl) {

				BigDecimal bonus = this.getBonus(null, uid);// 查询剩余奖金
				BigDecimal pdAmount = new BigDecimal(needBalance).subtract(new BigDecimal(availableBalance));// 还需要支付的云豆{奖金}是多少

				if (bonus.compareTo(pdAmount) < 0) {
					System.out.println("云豆不足  请先充值");
					throw new ServiceException("云豆不足  请先充值");

				} else {
					Integer payPype = 1;// 表示奖金
					CnUserPayBO cnUserPayBO = this.cnPayBaseService.OrderPay(1, userAlias, orderNo, pdAmount,
							bonusPassword, ""); // 奖金支付

					if (cnUserPayBO.getISPAY().equals("0")) {
						throw new ServiceException("支付失败");
					}

					this.yungouMoneyPaySaveLog(orderNo, cnUserPayBO.getDEAL_NUMBER(), order.getTotalPrice(),
							0, payPype, pdAmount, userAlias, uid, CommUtil.null2BigDecimal(0),
							CommUtil.null2BigDecimal(0));// 增加奖金日志

					Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币支付订单

					String logInfo = "购买上品减少云豆奖金";
					resOrderForm = this.completePay(orderId, payment.getId(), null, logInfo);

				}

			}

		} else {
			log.info("bonusAndBlanceForYunGou-本地云豆大于需要支付的云豆");
			throw new ServiceException("支付参数错误，请重新支付");
		}
		return resOrderForm;
	}

	/***
	 * 账户云购币余额 不满足 订单所需云购币时{需要使用云豆支付}
	 * 
	 * orderId 订单ID userAlias CN编号 yungouBalance 云购币账户余额 availableBalance 账户余额 bonusPassword 奖金/云购币支付密码
	 */
	public OrderForm bonusAndBlanceForYunGou2(Long orderId, String userAlias, Double yungouBalance,
			Double availableBalance, String bonusPassword) throws ServiceException {
		OrderForm order = this.getObjById(orderId);
		OrderForm resOrderForm = null;
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}

		Integer payType = 3;
		CnUserPayBO cnUserPayBO = this.cnPayBaseService.OrderPay(payType, userAlias, order.getOrderId(),
				CommUtil.null2BigDecimal(yungouBalance), bonusPassword, "");// 扣除云购币

		if (cnUserPayBO.getISPAY().equals("1")) {

			this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER(),
					order.getTotalPrice(), 0, payType, CommUtil.null2BigDecimal(yungouBalance), userAlias,
					order.getUserId(), CommUtil.null2BigDecimal(0), CommUtil.null2BigDecimal(0));// 云购币支付完成
			// 增加日志

			order.setActualygPrice(CommUtil.null2BigDecimal(yungouBalance));

		} else {
			System.out.println("支付失败");
			throw new ServiceException("云购币支付失败");
		}

		BigDecimal orderNeedYgb = order.getAllygPrice();// 订单需要多少云购币
		BigDecimal orderNeedCash = order.getAllCashPrice();// 订单需要多少云购币
		BigDecimal orderNeedYgbSubtract = orderNeedYgb.subtract(CommUtil.null2BigDecimal(yungouBalance));// 订单需要多少云购币
																											// -
																											// 减
																											// 云购币账户余额
		// 订单需要多少云购币- 云购币账户余额 +订单需要多少现金
		BigDecimal orderNeedCashAdd = orderNeedYgbSubtract
				.add(order.getAllCashPrice() != null ? order.getAllCashPrice() : new BigDecimal(0));

		if (null != orderNeedCash && orderNeedCash.compareTo(new BigDecimal(0)) > 0) { // 需要现金支付和云购币支付的(半云购币支付)

			if (CommUtil.null2BigDecimal(availableBalance).compareTo(orderNeedCashAdd) >= 0) {
				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币加云豆
				String logInfo = order.getOrderId() + "订单购物减少可用云豆";
				boolean bo = moneyService.consumptionMoney(order.getUserId(),
						CommUtil.null2Double(orderNeedCashAdd), logInfo);
				if (!bo) {
					throw new ServiceException("云豆支付失败");
				}
				resOrderForm = completePay(orderId, payment.getId(), null, logInfo);

				order.setActualPrice(orderNeedCashAdd);
				this.update(order);

			} else {// 云购币 + {云豆+奖金支付}
				resOrderForm = this.bonusAndBlanceForYunGou(orderId, CommUtil.null2Double(orderNeedCashAdd),
						order.getUserId(), userAlias, bonusPassword, order.getOrderId());//
				order.setActualPrice(orderNeedCashAdd);
			}

		} else { // 只需要云购币支付支付的(全云购币产品)

			if (CommUtil.null2BigDecimal(availableBalance).compareTo(orderNeedCashAdd) >= 0) {
				Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);// 云购币加云豆
				String logInfo = order.getOrderId() + "订单购物减少可用云豆";
				boolean bo = moneyService.consumptionMoney(order.getUserId(),
						CommUtil.null2Double(orderNeedCashAdd), logInfo);
				if (!bo) {
					throw new ServiceException("云豆支付失败");
				}
				order.setActualPrice(orderNeedCashAdd);
				this.update(order);

				resOrderForm = completePay(orderId, payment.getId(), null, logInfo);
			} else {// 云购币 + {云豆+奖金支付}

				resOrderForm = this.bonusAndBlanceForYunGou(orderId, CommUtil.null2Double(orderNeedCashAdd),
						order.getUserId(), userAlias, bonusPassword, order.getOrderId());//

				order.setActualPrice(orderNeedCashAdd);
				this.update(order);
			}

		}

		return resOrderForm;
	}

	/***
	 * 
	 * 云购币独立支付
	 * 
	 * @param orderId
	 * @param userAlias
	 * @param yunGouPassword
	 * @param availableBalance
	 *            账户本地余额
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm yungouMoneyPay(Long orderId, String yunGouPassword, Double availableBalance, Long uid)
			throws ServiceException {

		OrderForm resOrderForm = null;
		OrderFormBO order = this.fetch(orderId);
		BigDecimal orderNeedYgb = order.getAllygPrice();// 订单需要多少云购币
		BigDecimal orderNeedCash = order.getAllCashPrice();// 订单需要多少云购币

		UserAccount account = this.userAccountDao.findUserAccount(uid, "8");
		CnUserMoneyBO repeatBo = null;
		try {
			repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());// 获取Cn账户的重消余额（云购币）
			if (null == repeatBo || null == repeatBo.getBONUS_REPEAT()) {
				throw new ServiceException("结算系统出错");
			}
		} catch (Exception e) {
			throw new ServiceException("结算系统出错");
		}

		if (repeatBo.getBONUS_REPEAT() >= CommUtil.null2Double(orderNeedYgb)) { // 云购币账户
																				// 满足
																				// 订单需要的云购币

			/*
			 * Integer payType = 3; CnUserPayBO cnUserPayBO =
			 * this.cnPayBaseService.OrderPay( payType, account.getLoginName(),
			 * order.getOrderId(), CommUtil.null2BigDecimal(orderNeedYgb),
			 * yunGouPassword, "");
			 */// 扣除云购币

			Integer payType = 3;
			CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(account.getLoginName(),
					yunGouPassword, CommUtil.null2Double(orderNeedYgb), CommUtil.null2Double(0),
					order.getOrderId(), payType);

			if (cnUserPayBO.getPAY_STATUS_1().intValue() == 100) {

				this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
						order.getTotalPrice(), 0, payType, CommUtil.null2BigDecimal(orderNeedYgb),
						account.getLoginName(), order.getUserId(), CommUtil.null2BigDecimal(0),
						CommUtil.null2BigDecimal(0));// 云购币支付完成
				// 增加日志

				order.setActualygPrice(orderNeedYgb);
				this.update(order);

			}

			Integer flag = 3;// 表示云购币完成支付
			resOrderForm = this.completeMoneyPayForYunGou(orderId, flag, CommUtil.null2Double(orderNeedCash),
					account.getLoginName(), yunGouPassword);

		} else {// 云购币账户 不满足 订单需要的云豆? 可能存在问题不需要

			resOrderForm = this.bonusAndBlanceForYunGou2(orderId, account.getLoginName(),
					repeatBo.getBONUS_REPEAT(), availableBalance, yunGouPassword);
		}
		return resOrderForm;
	}

	/***
	 * 云购币 加 现金 支付逻辑
	 * 
	 * 这里只扣除云购币，保存日志
	 * 
	 * @param orderId
	 * @param uid
	 * @return payType 选择支付时间
	 * @throws ServiceException
	 */
	public OrderForm yungouMoneyAndCash(Long orderId, Long uid, String yunGouPassword, String payTypeStr)
			throws ServiceException {
		OrderForm order = this.getObjById(orderId);

		if (StringUtils.isNotBlank(yunGouPassword)) {

			boolean blr = this.validatCNPassword(null, yunGouPassword, uid);
			if (!blr) {
				throw new ServiceException("CN账号支付密码错误!");
			}

			OrderForm resOrderForm = null;
			if (order == null) {
				throw new ServiceException("参数错误，或者订单已完成支付");
			}

			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				return order;
			}

			BigDecimal orderNeedYgb = order.getAllygPrice();// 订单需要多少云购币
			BigDecimal orderNeedCash = order.getAllCashPrice();// 订单需要多少现金

			BigDecimal orderNeedCount = orderNeedYgb.add(orderNeedCash);// 需要总费用

			UserAccount account = this.userAccountDao.findUserAccount(uid, "8");
			CnUserMoneyBO repeatBo = null;
			try {
				repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());// 获取Cn账户的重消余额（云购币）
				if (null == repeatBo || null == repeatBo.getBONUS_REPEAT()) {
					throw new ServiceException("结算系统出错");
				}
			} catch (Exception e) {
				throw new ServiceException("结算系统出错");
			}

			// checkOrderisPay
			boolean bl = this.checkOrderisPay(order.getActualygPrice());// 是否支付过

			if (repeatBo.getBONUS_REPEAT() >= CommUtil.null2Double(order.getAllygPrice()) && bl) {

				Integer payType = 3;
				CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(account.getLoginName(),
						yunGouPassword, CommUtil.null2Double(orderNeedYgb), CommUtil.null2Double(0),
						order.getOrderId(), payType);
				// TODO 剩下的现金 要微信支付 只需要 orderNeedCash

				if (cnUserPayBO.getPAY_STATUS_1().equals(100)) {

					this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
							order.getTotalPrice(), 0, payType, orderNeedYgb, account.getLoginName(), uid,
							CommUtil.null2BigDecimal(0), CommUtil.null2BigDecimal(0));// 云购币支付完成
					// 增加日志

					order.setActualygPrice(orderNeedYgb);

					// 表示 全云购支付的
					if (null == orderNeedCash || CommUtil.null2Double(orderNeedCash) == 0) {
						String logInfo = "云购币支付";
						order = completePay(orderId, order.getPaymentId(), null, logInfo);

					} else {
						PaymentBO paymentBO = null;
						if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_ALIPAY.equals(payTypeStr)
								|| PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payTypeStr)) {
							paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_AL);
						}

						if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(payTypeStr)
								|| PaymentConstants.PAYMENT_MARK_WX_APP.equals(payTypeStr)) {
							paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_WX);// 云购币和微信
						}
						// 产生订单支付id
						String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
						order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
						order.setPaymentId(paymentBO.getId());
						// this.update(order);
					}

					this.update(order);

				}

			} else {

				if (bl) {// 表示未支付

					Integer payType = 3;

					CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(account.getLoginName(),
							yunGouPassword, repeatBo.getBONUS_REPEAT(), CommUtil.null2Double(0),
							order.getOrderId(), payType);

					if (cnUserPayBO.getPAY_STATUS_1().equals(100)) {
						this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
								order.getTotalPrice(), 0, payType,
								CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()), account.getLoginName(),
								uid, CommUtil.null2BigDecimal(0), CommUtil.null2BigDecimal(0));// 云购币支付完成
						// 增加日志

						order.setActualygPrice(CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()));

						PaymentBO paymentBO = null;
						if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_ALIPAY.equals(payTypeStr)
								|| PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payTypeStr)) {
							paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_AL);
						}

						if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(payTypeStr)
								|| PaymentConstants.PAYMENT_MARK_WX_APP.equals(payTypeStr)) {
							paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_WX);// 云购币和微信
						}
						// 产生订单支付id
						String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
						order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
						order.setPaymentId(paymentBO.getId());
						this.update(order);
					}

				}

			}

		} else {
			PaymentBO paymentBO = null;
			if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_ALIPAY.equals(payTypeStr)
					|| PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payTypeStr)) {
				paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_AL);
			}

			if (null != payTypeStr && PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(payTypeStr)
					|| PaymentConstants.PAYMENT_MARK_WX_APP.equals(payTypeStr)) {
				paymentBO = this.paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_YG_WX);// 云购币和微信
			}
			// 产生订单支付id
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
			order.setPaymentId(paymentBO.getId());
			this.update(order);
		}
		return order;
	}

	/****
	 * 
	 * 订单支付云购币 还需要支付多少现金
	 * 
	 * 
	 * @param orderId
	 * @return
	 */
	public Double subtractOrderNeedAmount(Long orderId) {
		OrderForm order = this.getObjById(orderId);

		if (null == order.getAllCashPrice()) {
			order.setAllCashPrice(new BigDecimal(0));
		}
		if (null == order.getAllygPrice()) {
			order.setAllygPrice(new BigDecimal(0));
		}
		if (null == order.getActualygPrice()) {
			order.setActualygPrice(new BigDecimal(0));
		}

		Double orderNeedCash = CommUtil.null2Double(order.getAllCashPrice());// 订单需要的现金
		Double orderNeedPrice = CommUtil.null2Double(order.getAllygPrice());// 订单需要的云购币
		Double orderCount = orderNeedCash + orderNeedPrice;// 订单总额
		Double orderActualygPrice = CommUtil.null2Double(order.getActualygPrice());// 订单支付
																					// 已经支付的云购币
		Double orderNeedAmount = orderCount - orderActualygPrice;// 还需要支付多少现金

		return orderNeedAmount;
	}

	/***
	 * 增加云购币和奖金支付记录
	 * 
	 * @param orderId
	 *            订单编号 returnTransactionalNo 云购币支付后返回的支付交易号 order_total_price 订单总金额 Type 0 收费 支出; 收入(退回)1
	 *            payPype 1奖金 3重消 loginName CN名 Long uid 用户ID money 费用
	 */
	public void yungouMoneyPaySaveLog(String orderId, String returnTransactionalNo, BigDecimal totalPrice,
			Integer type, Integer payPype, BigDecimal money, String loginName, Long uid, BigDecimal usedBonus,
			BigDecimal usedIntegralMoney) {
		ShopBonusRepeatLog record = new ShopBonusRepeatLog();
		record.setDateTime(new Date());
		record.setOrderId(orderId);
		record.setPayType(payPype);
		record.setReturnTracNo(returnTransactionalNo);
		record.setTotalPrice(totalPrice);
		record.setType(type);
		record.setUsedRepeatMoney(money);
		record.setUsedBonusPrice(usedBonus);
		record.setUserAlias(loginName);
		record.setUid(uid);
		record.setUsedIntegralMoney(usedIntegralMoney);
		this.addBonusRepeatLog(record);
	}

	/****
	 * 云购币订单 检查订单知否已经支付过
	 * 
	 * @param ActualygPrice
	 * @return
	 */
	public boolean checkOrderisPay(BigDecimal ActualygPrice) {
		boolean bl = false;
		if (null == ActualygPrice) {
			bl = true;
		}
		if (null != ActualygPrice && ActualygPrice.compareTo(new BigDecimal(0)) == 0) {
			bl = true;
		}
		return bl;
	}

	/***
	 * 云购币订单支付回调修改订单
	 * 
	 * @param orderId
	 * @param tradeNo
	 * @param logInfo
	 * @param totalFee
	 * @return
	 * @throws ServiceException
	 */
	// @Transactional(propagation=Propagation.REQUIRED)
	public OrderForm completePayForYg(Long orderId, String tradeNo, String logInfo, double totalFee)
			throws ServiceException {
		OrderForm orderForm = this.orderFormDao.fetch(Long.valueOf(orderId));
		orderForm.setActualPrice(CommUtil.null2BigDecimal(totalFee));
		boolean bl = this.update(orderForm);
		if (bl) {
			orderForm = this.completePay(orderId, tradeNo, logInfo);
		}
		return orderForm;
	}

	/***
	 * 云购币订单退回云购币 非云购币专区的订单
	 * 
	 * @return
	 */
	public int returnYgOrderActualygPrice() {
		// 查询超过48小时，订单状态为18的订单 selectFailedYgOrder
		List<OrderForm> order_list = orderFormDao.selectFailedYgOrder();

		if (null != order_list && order_list.size() > 0) {
			for (OrderForm order : order_list) {
				String cn_useralias = order.getCnUseralias();// cn编号
				BigDecimal actualygPrice = order.getActualygPrice();// 已支付的云购币
				String order_id = order.getOrderId();// 订单号
				if (null != actualygPrice && actualygPrice.compareTo(new BigDecimal(0)) > 0) {// 半支付状态

					int type = 3;// 退款类型3重消
					CnRenturnYgOrderBO bo = null;
					if (StringUtils.isEmpty(cn_useralias)) {
						log.error(order_id + "[云购币订单异常cn_useralias is null orderID=]" + order_id);
					} else {

						bo = cnPayBaseService.return_ygOrder(cn_useralias, type, actualygPrice, order_id);
					}

					if (!StringUtils.isEmpty(cn_useralias) && null != bo
							&& Double.valueOf(bo.getRETURN_STATUS()).intValue() == 100) {// 退款成功

						order.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
						this.orderFormDao.update(order);

						OrderLog log = new OrderLog();
						log.setDeleteStatus(0);
						log.setLogInfo(order_id + "订单由于超过48小时内未付现金，退还云购币:" + actualygPrice);
						log.setLogUserId(order.getUserId());
						log.setOfId(order.getId());
						this.orderFormLogService.save(log);
						// 退还云购币日志
						ShopBonusRepeatLog record = new ShopBonusRepeatLog();
						record.setDateTime(new Date());
						record.setOrderId(order_id);
						record.setPayType(1);
						record.setUsedRepeatMoney(actualygPrice);
						record.setUserAlias(cn_useralias);
						record.setType(1);
						record.setUid(order.getUserId());
						this.ShopBonusRepeatLogDao.save(record);
					} else {
						log.error(order_id + "[云购币订单，退款失败error，返回结果]"
								+ ((null == bo) ? null : bo.getRETURN_STATUS()));
					}

				} else { // 未支付
					order.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
					this.orderFormDao.update(order);
					OrderLog log = new OrderLog();
					log.setDeleteStatus(0);
					log.setLogInfo(order_id + "订单由于超过72小时内未付现金，取消:");
					log.setLogUserId(order.getUserId());
					log.setOfId(order.getId());
					this.orderFormLogService.save(log);
				}

			}
		} else {
			log.info("未查到符合退款条件云购币订单");
		}
		return 0;
	}

	/**
	 * 获取N天前某个状态下的订单
	 */
	public List<OrderFormBO> getOrderByDaysAgo(Date dateAgo, int status) {
		// 参数异常
		if (null == dateAgo || status < 0) {
			log.info("参数异常，tenDaysAgo:" + dateAgo + ",status" + status);
			return null;
		}
		List<OrderFormBO> orderForms = this.orderFormDao.getOrderByDaysAgo(dateAgo, status);
		return orderForms;
	}

	/**
	 * 获取符合自动评论的订单列表
	 */
	public List<OrderFormBO> getOrdersByAutoReview(Date dateAgo, int status) {
		// 参数异常
		if (null == dateAgo || status < 0) {
			log.info("参数异常，tenDaysAgo:" + dateAgo + ",status" + status);
			return null;
		}
		List<OrderFormBO> orderForms = this.orderFormDao.getOrdersByAutoReview(dateAgo, status);
		return orderForms;
	}

	/***
	 * 云购币 加 现金 支付逻辑 微商城的 这里只扣除云购币，保存日志
	 * 
	 * @param orderId
	 *            订单Id
	 * @param uid
	 *            uid
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm yungouMoneyAndCashForH5(Long orderId, Long uid, String yunGouPassword)
			throws ServiceException {
		OrderForm order = this.getObjById(orderId);

		if (StringUtils.isNotBlank(yunGouPassword)) {

			boolean blr = this.validatCNPassword(null, yunGouPassword, uid);
			if (!blr) {
				throw new ServiceException("CN账号支付密码错误!");
			}

			OrderForm resOrderForm = null;
			if (order == null) {
				throw new ServiceException("参数错误，或者订单已完成支付");
			}

			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				return order;
			}

			BigDecimal orderNeedYgb = order.getAllygPrice();// 订单需要多少云购币
			BigDecimal orderNeedCash = order.getAllCashPrice();// 订单需要多少现金

			BigDecimal orderNeedCount = orderNeedYgb.add(orderNeedCash);// 需要总费用

			UserAccount account = this.userAccountDao.findUserAccount(uid, "8");
			CnUserMoneyBO repeatBo = null;
			try {
				repeatBo = this.cnPayBaseService.getCnUserRepeatMoney(account.getLoginName());// 获取Cn账户的重消余额（云购币）
				if (null == repeatBo || null == repeatBo.getBONUS_REPEAT()) {
					throw new ServiceException("结算系统出错");
				}
			} catch (Exception e) {
				throw new ServiceException("结算系统出错");
			}

			// checkOrderisPay
			boolean bl = this.checkOrderisPay(order.getActualygPrice());// 是否支付过

			if (repeatBo.getBONUS_REPEAT() >= CommUtil.null2Double(order.getAllygPrice()) && bl) {

				Integer payType = 3;
				CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(account.getLoginName(),
						yunGouPassword, CommUtil.null2Double(orderNeedYgb), CommUtil.null2Double(0),
						order.getOrderId(), payType);
				// TODO 剩下的现金 要微信支付 只需要 orderNeedCash

				if (cnUserPayBO.getPAY_STATUS_1().equals(100)) {

					this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
							order.getTotalPrice(), 0, payType, orderNeedYgb, account.getLoginName(), uid,
							CommUtil.null2BigDecimal(0), CommUtil.null2BigDecimal(0));// 云购币支付完成
					// 增加日志

					order.setActualygPrice(orderNeedYgb);

					// 表示 全云购支付的
					if (null == orderNeedCash || CommUtil.null2Double(orderNeedCash) == 0) {
						String logInfo = "云购币支付";
						order = completePay(orderId, order.getPaymentId(), null, logInfo);
					}
					this.update(order);
				}

			} else {

				if (bl) {// 表示未支付

					Integer payType = 3;

					CnYgOrderPayBO cnUserPayBO = this.cnPayBaseService.ygOrderPay(account.getLoginName(),
							yunGouPassword, repeatBo.getBONUS_REPEAT(), CommUtil.null2Double(0),
							order.getOrderId(), payType);

					if (cnUserPayBO.getPAY_STATUS_1().equals(100)) {
						this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER_1(),
								order.getTotalPrice(), 0, payType,
								CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()), account.getLoginName(),
								uid, CommUtil.null2BigDecimal(0), CommUtil.null2BigDecimal(0));// 云购币支付完成
						order.setActualygPrice(CommUtil.null2BigDecimal(repeatBo.getBONUS_REPEAT()));
						this.update(order);
					}

				}

			}

		}
		return order;
	}

	/***
	 * 微商城支付云豆支付逻辑
	 * 
	 * @param orderId
	 *            订单Id uid 用户id isAvailableBalance 是否使用云豆
	 * @throws ServiceException
	 */
	public OrderFormBO balancePayForH5(Long orderId, Long uid, boolean isAvailableBalance,
			String paymentPassword, String accountType, String payType) throws ServiceException {
		OrderFormBO order = this.fetch(orderId);
		double availableBalance = this.moneyService.getAvailableBalance(uid);
		double order_total_price = this.orderFormTools.query_order_price(order);

		if (availableBalance >= order_total_price && isAvailableBalance) { // 云豆支付
			OrderFormBO orderFormBO = mapper.map(
					this.completeMoneyPayForCn(order.getId(), paymentPassword, "", accountType),
					OrderFormBO.class);
//			this.saveGoodsReceipt(order);
			return orderFormBO;
		}

		if (availableBalance < order_total_price && isAvailableBalance
				&& accountType.equals(UserContant.ACCOUNT_TYPE_8) && StringUtils.isBlank(payType)) { // 云豆+奖金

			BigDecimal pdAmount = new BigDecimal(order_total_price)
					.subtract(new BigDecimal(availableBalance));
			BigDecimal bonus = this.getBonus(pdAmount, uid);

			// CN账户的奖金满足,{如果有CN账户,将 云豆的密码 看做 奖金的密码 }
			if (bonus.compareTo(pdAmount) != -1) {
				OrderForm orderFrom = this.bonusAndBlance(order.getId(), null, "", paymentPassword,
						new BigDecimal(availableBalance).setScale(2, BigDecimal.ROUND_HALF_UP), pdAmount, uid);

				OrderFormBO orderFormBO = mapper.map(orderFrom, OrderFormBO.class);
//				this.saveGoodsReceipt(order);
				return orderFormBO;
			}
		}

		if (isAvailableBalance && StringUtils.isNotBlank(payType)) {// 云豆和现金支付,先扣除现有的云豆

			String logInfo = "订单支付减少云豆";
			boolean bo = moneyService.consumptionMoney(order.getUserId(), availableBalance, logInfo);
			if (accountType.equals(UserContant.ACCOUNT_TYPE_8)) {
				BigDecimal bonus = this.getBonus(null, uid);
				order.setActualygPrice(CommUtil.null2BigDecimal(availableBalance).add(bonus));
				// 增加奖金奖金
				this.update(order);
			} else {
				order.setActualygPrice(CommUtil.null2BigDecimal(availableBalance));
				this.update(order);
			}

		}
		return order;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/** 取消超过设定时间的未付款订单 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cancelNotPayingOrderForm(Long second) {
		// 查询超过设定时间的未付款订单 不包括云购币订单和云购币专区订单
		List<OrderForm> list = this.orderFormDao.selectFailedOrderFormByTime(second);
		if (null == list) {
			return;
		}
		// 取消订单
		for (OrderForm order : list) {
			this.cancelOrderForm(order, "订单长时间未支付,自动取消");
		}
	}

	/** 取消订单 加日志 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	private void cancelOrderForm(OrderForm order, String logoInfo) {
		if (null == order) {
			return;
		}
		
		boolean  bl = this.selectOrderPayStatus(order.getId());
		if (!bl) {
			return;
		}
		
		if (StringUtils.isBlank(logoInfo)) {
			logoInfo = "订单取消";
		}
		Date nowDate = new Date();
		// 加日志
		OrderLog log = new OrderLog();
		log.setDeleteStatus(0);
		log.setLogInfo(order.getOrderId() + logoInfo);
		log.setLogUserId(order.getUserId());
		log.setOfId(order.getId());
		log.setAddTime(nowDate);
		this.orderFormLogService.save(log);

		// 取消订单
		order.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
		this.update(order);

	}

	/**
	 * 向买家、商家发送短信、邮件提醒订单在线付款成功！（催单功能）
	 * 
	 * @param request
	 * @param order
	 * @throws Exception
	 */
	public void sendMsgToSeller(String storeId) throws Exception {
		// 验证店铺ID不为空
		if (CommUtil.isNotNull(storeId)) {
			// 根据店铺ID获取商家信息
			Seller seller = sellerService.findByStore(CommUtil.null2Long(storeId));
			UserAccount acount = userAccountService.findByUid(seller.getUid(), UserContant.ACCOUNT_TYPE_2);
			// 发送短信
			if (null != seller && null != acount && CommUtil.isNotNull(acount.getLoginName())) {
				String[] params = null;
				log.info("Seller Mobile===" + acount.getLoginName());
				this.msgTools.sendSms(StoreConstants.SMS_TOSELLER_ONLINE_SHIPMENTS_NOTIFY, acount.getLoginName(),
						params);
			}
		}
	}

	/***
	 * 调用直销接口的类型 直销支付方式
	 * 
	 * @param payType
	 * @return paymode 1：重消+工资、2：重消+充值帐户、3：重消+第三方支付
	 */
	public int getpayMode(String payType) {
		int paymode = 0;
		if (OrderFormConstants.YG_ORDER_PAY_TYPE_JJ.equals(payType)) {
			paymode = 1;
		}
		if (OrderFormConstants.YG_ORDER_PAY_TYPE_CZ.equals(payType)) {
			paymode = 2;
		}
		if (OrderFormConstants.YG_ORDER_PAY_TYPE_CASH.equals(payType)) {
			paymode = 3;
		}
		return paymode;
	}

	/**
	 * 本地支付方式1
	 * 
	 * @param payMode
	 *            1：重消+工资、2：重消+充值帐户、3：重消+第三方支付
	 * @param payCash
	 *            wx_app alipay_app
	 * @return
	 */
	public Payment getPayment(int payMode, String payCash) {
		String mark = "";
		if (payMode == 3) {
			if ("wx_app".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_YG_WX;
			}
			if ("alipay_app".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_YG_AL;
			}
		} else if (payMode == 2) {
			mark = PaymentConstants.PAYMENT_MARK_YG_CZ;
		} else if (payMode == 1) {
			mark = PaymentConstants.PAYMENT_MARK_YG_JJ;
		}
		Payment payment = this.paymentService.findByMark(mark);
		return payment;
	}

	/****
	 * 用于CN和普通会员支付的方法
	 * 
	 * @param mainOrderId
	 * @param password
	 * @param payMsg
	 * @param accountType
	 * @return
	 * @throws ServiceException
	 */
	public OrderForm completeMoneyPayForCn(Long mainOrderId, String password, String payMsg,
			String accountType) throws ServiceException {
		OrderForm order = this.getObjById(mainOrderId);
		// 异步没有出来订单，则同步处理订单
		if (order == null) {
			throw new ServiceException("参数错误，或者订单已完成支付");
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			return order;
		}

		Payment payment = paymentDao.findByMark(PaymentConstants.PAYMENT_MARK_BALANCE);

		double orderTotalPrice = this.orderFormTools.query_order_price(order);

		String logInfo = order.getOrderId() + "订单购物减少可用云豆";

		boolean bo = false;
		if (UserContant.ACCOUNT_TYPE_8.equals(accountType)) {
			boolean bl = this.validatCNPassword("", password, order.getUserId());
			if (!bl) {
				throw new ServiceException("支付密码错误");
			}
			bo = moneyService.consumptionMoney(order.getUserId(), orderTotalPrice, logInfo);
		} else {
			bo = moneyService.consumptionMoney(order.getUserId(), orderTotalPrice, password, logInfo);
		}

		if (!bo) {
			throw new ServiceException("云豆支付失败");
		}

		return completePay(mainOrderId, payment.getId(), null, logInfo);
	}

	/***
	 * 查询用户当前云购币余额
	 * 
	 * @param userAlias
	 * @return
	 */
	public Double repeatMoney(String userAlias) {
		Double repeatBO = 0.0;// 用户云购币余额
		Map map = new HashMap();
		map.put("USER_ALIAS", userAlias);
		map.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_YG);
		CnMoneyBO cn_repeatBO = cnPayBaseService.getCnUserCxWalletView(map);// 云购币
		if (null != cn_repeatBO && null != cn_repeatBO.getMONEY() && null != cn_repeatBO.getWALLET_STATUS()) {
			repeatBO = cn_repeatBO.getMONEY();
			if (Double.valueOf(cn_repeatBO.getWALLET_STATUS()).intValue() == 5) {// 账户被冻结
				repeatBO = 0.0;
			}
		}
		return repeatBO;
	}

	/**
	 * 获取精品专区的支付方式
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public SelectYgPayModeBO getBeautyPayMode(String orderId, Long userId) {
		SelectYgPayModeBO bo = new SelectYgPayModeBO();
		Double actualygPrice = 0.0;// 实际需要用云购币多少
		Double actualPrice = 0.0;// 实际需要用现金多少
		Double actualJfPrice = 0.0;// 实际需要积分多少

		Double ygPrice = 0.0;// 订单云购币总和
		Double totalPrice = 0.0;// 订单现金总和
		Double jfPrice = 0.0;// 订单积分总和

		Double repeatBO = 0.0;// 用户云购币余额
		Double bounsBO = 0.0;// 用户奖金余额
		Double rechargeBO = 0.0;// 用户充值账户余额
		Double integralBO = 0.0;// 用户积分账户余额

		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		if (order == null) {
			bo.setRes(501);
			return bo;// 订单异常
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			bo.setRes(502);
			return bo;// 订单已支付
		}

		if (null == order.getIsygOrder() || !order.getIsygOrder()) {
			bo.setRes(503);
			return bo;// 该订单不是云购币订单
		}
		bo.setOrder(order);

		if (null != order.getAllIntegral()) {
			jfPrice = order.getAllIntegral().doubleValue(); // 订单积分总和
			actualJfPrice = jfPrice;
		}

		if (null != order.getAllCashPrice()) {
			totalPrice = order.getAllCashPrice().doubleValue(); // 订单现金总和
		}

		UserAccountBO vo = new UserAccountBO();
		vo.setUid(userId);
		vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccountBO accountBO = userAccountDao.findAccountByVo(vo);// 查询CN账户名
		if (accountBO == null) {
			bo.setRes(504);
			return bo;// 该账户非CN账户
		}

		Map map = new HashMap();
		map.put("USER_ALIAS", accountBO.getLoginName());
		CnMoneyBO cn_pv = this.cnPayBaseService.getCnUserShopPv(map);// 积分账户
		if (null != cn_pv && null != cn_pv.getSHOP_PV()) {
			bo.setCurrentIntegralBalance(cn_pv.getSHOP_PV());
			integralBO = cn_pv.getSHOP_PV();
		}

		Map map_1 = new HashMap();
		map_1.put("USER_ALIAS", accountBO.getLoginName());
		map_1.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_JJ);
		CnMoneyBO cn_bounsBO = cnPayBaseService.getCnUserCxWalletView(map_1);// 奖金账户
		if (null != cn_bounsBO && null != cn_bounsBO.getMONEY() && null != cn_bounsBO.getWALLET_STATUS()) {
			bounsBO = cn_bounsBO.getMONEY();
			bo.setjJWallet_status(Double.valueOf(cn_bounsBO.getWALLET_STATUS()).intValue());
			bo.setCurrentJjBalance(bounsBO);
			if (bo.getjJWallet_status() == 5) {// 账户被冻结
				bounsBO = 0.0;
			}
		}

		if (bounsBO > 0 && bounsBO - totalPrice >= 0) {
			actualPrice = totalPrice;
			bo.setRes(10);
			bo.setActualPrice(actualPrice);
			bo.setActualIntegralBalance(actualJfPrice);
			bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_JJ);
			return bo;// 奖金账户余额充足,用奖金账户支付
		} else {

			Map map_2 = new HashMap();
			map_2.put("USER_ALIAS", accountBO.getLoginName());
			map_2.put("WALLETTYPE", OrclSchmaNameConstants.WALLET_TYPE_CZ);
			CnMoneyBO cn_rechargeBO = cnPayBaseService.getCnUserCxWalletView(map_2);// 充值账户

			if (null != cn_rechargeBO && null != cn_rechargeBO.getMONEY()
					&& null != cn_rechargeBO.getWALLET_STATUS()) {
				rechargeBO = cn_rechargeBO.getMONEY();
				bo.setcZWallet_status(Double.valueOf(cn_rechargeBO.getWALLET_STATUS()).intValue());
				bo.setCurrentCzBalance(rechargeBO);
				if (bo.getcZWallet_status() == 5) {// 账户被冻结
					rechargeBO = 0.0;
				}
			}

			if (rechargeBO > 0 && rechargeBO - totalPrice >= 0) {
				actualPrice = totalPrice;
				bo.setRes(20);
				bo.setActualPrice(actualPrice);
				bo.setActualIntegralBalance(actualJfPrice);
				bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_CZ);
				return bo;// 奖金账户余额不足，充值账户余额充足,用充值账户支付
			} else {
				actualPrice = totalPrice;
				bo.setRes(30);
				bo.setActualPrice(actualPrice);
				bo.setActualIntegralBalance(actualJfPrice);
				bo.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_CASH);
				return bo;// 充值账户与奖金账户余额都不足，只能用第三方支付支付
			}
		}

	}

	/***
	 * 精品专区 - 积分+奖金.充值 支付0
	 * 
	 * @param payMode
	 *            1.2.3
	 * @param orderId
	 * @param password
	 * @param actualJfPrice
	 *            要支付的积分
	 * @param actualPrice
	 *            要支付的现金部分
	 * @param user_id
	 * @param payMentid
	 *            支付方法ID
	 * @return
	 * @throws ServiceException
	 */
	public int beautyIntegralPay0(int payMode, String orderId, String password, String actualJfPrice,
			String actualPrice, Long user_id, Long payMentid) throws ServiceException {
		int payResult = this.beautyIntegralPay1(payMode, orderId, password, actualJfPrice, actualPrice,
				user_id, payMentid);
		int result = 0;
		if (payResult == 100) {// 表示支付成功
			OrderFormBO order = this.fetch(CommUtil.null2Long(orderId));
			int res = this.complete_ygOrder(order);
			result = res;
		}
		return result;
	}

	/***
	 * 精品专区 -积分 +奖金/充值 支付1
	 * 
	 * @param payMode
	 * @param orderNo
	 * @param password
	 * @param actualJfPrice
	 * @param actualPrice
	 * @param user_id
	 * @param payMentid
	 * @return
	 * @throws ServiceException
	 */
	public int beautyIntegralPay1(int payMode, String orderId, String password, String actualJfPrice,
			String actualPrice, Long user_id, Long payMentid) throws ServiceException {

		UserAccount userAccount = this.userAccountDao.findByUid(user_id, UserContant.ACCOUNT_TYPE_8);
		boolean bl = this.validatCNPassword(userAccount.getLoginName(), password, user_id);
		if (!bl) {
			throw new ServiceException("支付密码错误");
		}
		OrderFormBO order = this.fetch(CommUtil.null2Long(orderId));

		CnUserPayBO cnUserPayBO = this.cnPayBaseService.cnUserIntegralPay(userAccount.getLoginName(),
				password, CommUtil.null2Double(actualJfPrice), order.getOrderId());// 扣除积分

		if (cnUserPayBO != null && OrderFormConstants.GET_USER_CX_WALLET_PAY_100 == CommUtil
				.null2Int(cnUserPayBO.getPAY_STATUS())) {
			order.setActualIntegral(CommUtil.null2BigDecimal(actualJfPrice));
		} else {
			throw new ServiceException("积分支付错误");
		}

		String ip = "192.168.1.17";
		int pay_type = 1;
		Integer payPype = 1;

		if (payMode == 1) {// 表示奖金支付
			pay_type = 1;
			payPype = 13;// 日志记录 积分+奖金

		} else if (payMode == 2) {// 表示充值账户支付
			pay_type = 2;
			payPype = 14;// 日志记录 积分+充值
		}
		int resultValue = 0;
		if (payMode != 3) {

			CnUserPayBO cnUserPayBO1 = this.cnPayBaseService.OrderPay(pay_type, userAccount.getLoginName(),
					order.getOrderId(), CommUtil.null2BigDecimal(actualPrice), password, ip);

			if (null != cnUserPayBO1 && cnUserPayBO1.getISPAY().equals("1")) {// 奖金.充值

				this.yungouMoneyPaySaveLog(order.getOrderId(),
						cnUserPayBO.getDEAL_NUMBER() + "|" + cnUserPayBO1.getDEAL_NUMBER(),
						order.getTotalPrice(), 0, payPype, CommUtil.null2BigDecimal(actualPrice),
						userAccount.getLoginName(), user_id, CommUtil.null2BigDecimal(0),
						CommUtil.null2BigDecimal(actualJfPrice));

				order.setActualPrice(CommUtil.null2BigDecimal(actualPrice));
				order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
				order.setPaymentId(payMentid);
				this.update(order);
				resultValue = 100;// 表示支付完成

			} else {
				this.update(order);
				throw new ServiceException("奖金.充值 支付成功 支付失败");
			}

		} else {
			// updateOrderPayment();
			// this.updateOrderPayment(order, payMentid);
			System.out.println("微信支付宝");

		}
		return resultValue;

	}

	/***
	 * 精品专区 - 积分+微信支付宝
	 * 
	 * @param orderId
	 * @param payMentid
	 * @param user_id
	 * @param password
	 * @param actualJfPrice
	 * @throws ServiceException
	 */
	public void beautyIntegralPay2(String orderId, Long payMentid, Long user_id, String password,
			String actualJfPrice) throws ServiceException {
		OrderFormBO order = this.fetch(CommUtil.null2Long(orderId));
		UserAccount userAccount = this.userAccountDao.findByUid(user_id, UserContant.ACCOUNT_TYPE_8);

		if (order.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TO_BE_YG) {// 小于18状态扣积分反之不扣
			boolean bl = this.validatCNPassword(userAccount.getLoginName(), password, user_id);
			if (!bl) {
				throw new ServiceException("密码错误");
			}
			CnUserPayBO cnUserPayBO = this.cnPayBaseService.cnUserIntegralPay(userAccount.getLoginName(),
					password, CommUtil.null2Double(actualJfPrice), order.getOrderId());// 扣除积分
			if (cnUserPayBO != null && OrderFormConstants.GET_USER_CX_WALLET_PAY_100 == CommUtil
					.null2Int(cnUserPayBO.getPAY_STATUS())) {
				order.setActualIntegral(CommUtil.null2BigDecimal(actualJfPrice));
				order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_YG);// 支付完成积分状态为18

				Integer payPype = 15;// 积分加微信支付宝
				this.yungouMoneyPaySaveLog(order.getOrderId(), cnUserPayBO.getDEAL_NUMBER() + "|",
						order.getTotalPrice(), 0, payPype, CommUtil.null2BigDecimal(0),
						userAccount.getLoginName(), user_id, CommUtil.null2BigDecimal(0),
						CommUtil.null2BigDecimal(actualJfPrice));

			} else {
				throw new ServiceException("积分支付错误");
			}
		}
		this.updateOrderPayment(order, payMentid);
	}

	/**
	 * 积分支付 支付方法
	 * 
	 * @param payMode
	 *            1：积分+工资[=奖金] 、2：积分+充值帐户、3：积分+第三方支付
	 * @param payCash
	 *            alipay wxqrpay
	 * @return
	 */
	public Payment getBeautyPayment(int payMode, String payCash) {
		String mark = "";
		if (payMode == 3) {
			if ("wxqrpay".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_JF_WX;
			}
			if ("alipay".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_JF_AL;
			}
		} else if (payMode == 2) {
			mark = PaymentConstants.PAYMENT_MARK_JF_CZ;
		} else if (payMode == 1) {
			mark = PaymentConstants.PAYMENT_MARK_JF_JJ;
		}
		Payment payment = this.paymentService.findByMark(mark);
		return payment;
	}

	/**
	 * 获取重消支付信息
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public SelectYgPayModeBO getCxPayMode(String orderId, Long userId) {
		SelectYgPayModeBO bo = new SelectYgPayModeBO();
		Double actualygPrice = 0.0;// 实际需要用云购币多少
		Double ygPrice = 0.0;// 订单云购币总和
		Double repeatBO = 0.0;// 用户云购币余额

		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		if (order == null) {
			bo.setRes(501);
			return bo;// 订单异常
		}
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			bo.setRes(502);
			return bo;// 订单已支付
		}

		if (null == order.getIsygOrder() || !order.getIsygOrder()) {
			bo.setRes(503);
			return bo;// 该订单不是云购币订单
		}
		bo.setOrder(order);

		UserAccountBO vo = new UserAccountBO();
		vo.setUid(userId);
		vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
		UserAccountBO accountBO = userAccountDao.findAccountByVo(vo);// 查询CN账户名
		if (accountBO == null) {
			bo.setRes(504);
			return bo;// 该账户非CN账户
		}

		// 获取重消余额
		repeatBO = this.repeatMoney(accountBO.getLoginName());
		// 获取需要的重消金额
		actualygPrice = null != order.getAllygPrice() ? order.getAllygPrice().doubleValue() : 0.0;
		// 需要的运费
		Double shipPrice = null != order.getShipPrice() ? order.getShipPrice().doubleValue() : 0.0;
		bo.setCurrentYgBalance(repeatBO);
		bo.setActualygPrice(actualygPrice);
		bo.setActualPrice(shipPrice);
		return bo;

	}

	/****
	 * 积分+现金 支付 回调
	 * 
	 * @param orderId
	 * @param outOrderId
	 * @param totalFee
	 * @return
	 */
	public OrderForm handle_jforder(String orderId, String outOrderId, double totalFee) {
		OrderForm orderForm = this.orderFormDao.fetch(Long.valueOf(orderId));
		if (null != orderForm) {
			orderForm.setActualPrice(new BigDecimal(totalFee));
			orderForm.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
			orderForm.setPayTime(new Date());
			this.orderFormDao.update(orderForm);

			List<OrderForm> result = new ArrayList<>();
			SysConfigBO config = this.configService.getSysConfig();

//			this.saveGoodsReceipt(orderForm);
			String logInfo = orderForm.getOrderId() + "精品专区支付消费";
			updateGoodsInventory(orderForm);
			OrderLog main_ofl = new OrderLog();
			main_ofl.setAddTime(new Date());
			main_ofl.setLogInfo(logInfo);
			main_ofl.setLogUserId(orderForm.getUserId());
			main_ofl.setOfId(orderForm.getId());
			this.orderFormLogService.save(main_ofl);// shop_order_log
			sendCompletePayMsg(result, config.getAddress());
			this.updateGoodsInventory(orderForm);//增加库存信息
		}
		return orderForm;
	}

	/***
	 * 精品专区 积分支付 回写订单
	 * 
	 * @param userAlias
	 * @param money
	 * @param payNo
	 * @param orderNo
	 * @return
	 */
	public CnWirteOrderBO writeIntegralOrder(String userAlias, double money, String payNo, String orderNo) {
		CnWirteOrderBO cnWirteOrderBO = this.cnPayBaseService.shopPy(userAlias, money, orderNo, payNo);
		return cnWirteOrderBO;
	}

	/**
	 * 积分支付 支付方法APP
	 * 
	 * @param payMode
	 *            1：积分+工资[=奖金] 、2：积分+充值帐户、3：积分+第三方支付
	 * @param payCash
	 *            alipay wxqrpay
	 * @return
	 */
	public Payment getBeautyPaymentApp(int payMode, String payCash) {
		String mark = "";
		if (payMode == 3) {
			if ("wx_app".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_JF_WX;
			}
			if ("alipay_app".equals(payCash)) {
				mark = PaymentConstants.PAYMENT_MARK_JF_AL;
			}
		} else if (payMode == 2) {
			mark = PaymentConstants.PAYMENT_MARK_JF_CZ;
		} else if (payMode == 1) {
			mark = PaymentConstants.PAYMENT_MARK_JF_JJ;
		}
		Payment payment = this.paymentService.findByMark(mark);
		return payment;
	}

	/***
	 * 查询购物积分
	 * 
	 * @param userId
	 * @return
	 */
	public Double getCnUserPv(Long userId) {
		Double integralBO = 0.0;// 用户积分账户余额
		UserAccount account = this.userAccountDao.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
		if (account != null) {
			Map map = new HashMap();
			map.put("USER_ALIAS", account.getLoginName());
			CnMoneyBO cn_pv = this.cnPayBaseService.getCnUserShopPv(map);// 积分账户
			if (null != cn_pv && null != cn_pv.getSHOP_PV()) {
				integralBO = cn_pv.getSHOP_PV();
			}
		}
		return integralBO;
	}

	/***
	 * 
	 * 精品专区 积分支付一半 退款
	 * 
	 */
	public void selectFailedIntegralOrder() {
		List<OrderForm> order = this.orderFormDao.selectFailedIntegralOrder();
		System.out.println(order.size());
		if (order != null && order.size() > 0) {
			for (OrderForm obj : order) {
				
				
				boolean bl = this.selectOrderPayStatus(obj.getId());
				if (!bl) {
					continue;
				}

				if (obj.getPayTypeFlag().intValue() == 2) {

					ShopBonusRepeatLog shopLog = new ShopBonusRepeatLog();
					shopLog.setOrderId(obj.getOrderId());
					shopLog.setType(0);
					ShopBonusRepeatLog resShopLog = this.ShopBonusRepeatLogDao.getByVo(shopLog);
					if (resShopLog != null && resShopLog.getReturnTracNo() != null) {
						try {
							String tracNos = resShopLog.getReturnTracNo();
							String[] tracNo = this.cnPayBaseService.handString(tracNos);

							log.debug("ShopBonusRepeatLog getReturnTracNo {} {}", tracNos, tracNo);

							CnRenturnYgOrderBO cnRenturnYgOrderBO = this.cnPayBaseService.returnIntegralPay(
									obj.getCnUseralias(), CommUtil.null2Double(obj.getActualIntegral()),
									tracNo[0], obj.getOrderId());

							if (cnRenturnYgOrderBO != null && Double
									.valueOf(cnRenturnYgOrderBO.getRETURN_STATUS()).intValue() == 100) {
								obj.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
								this.orderFormDao.update(obj);// 修改订单状态

								this.yungouMoneyPaySaveLog(obj.getOrderId(), "", CommUtil.null2BigDecimal(0),
										1, 15, CommUtil.null2BigDecimal(0), obj.getCnUseralias(),
										obj.getUserId(), CommUtil.null2BigDecimal(0), obj.getAllIntegral());
							}

						} catch (Exception e) {
							log.error("[selectFailedIntegralOrder]", e);
						}
					}

				}

				if (obj.getPayTypeFlag().intValue() == 3) {// 普通会员 精选专区退积分
					log.info("jingxunOrderCancel BEGIN");
					try {
						this.jingxunOrderCancel(obj.getUserId(), obj.getId());
						obj.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_CANCEL);
						this.orderFormDao.update(obj);// 修改订单状态
					log.info("jingxunOrderCancel END");
					} catch (Exception e) {
						log.error("[精选专区普通会员取消订单出错]", e);
					}
				}
			}
		}
	}

	/***
	 * 计算精品专区订单运费
	 * 
	 * @param amount
	 *            订单费用
	 */
	public BigDecimal getYgOrderShopFee(BigDecimal amount) {

		BigDecimal baseFee = new BigDecimal(30);// 积分运费
		BigDecimal baseAmount = new BigDecimal(3000);// 比较基准
		BigDecimal compareFee = new BigDecimal(1000);// 比较值
		BigDecimal addShopFee = new BigDecimal(10);// 增加值
		if (amount.compareTo(baseAmount) != 1) { // 订单金额 不大于(小于等于)于3K
			return baseFee;

		} else { // 订单金额 大于3K

			BigDecimal subtract = amount.subtract(baseAmount).setScale(BigDecimal.ROUND_HALF_UP, 2);// 大于3K的值
			BigDecimal divide = subtract.divide(compareFee, 2, BigDecimal.ROUND_DOWN); // 除以1000 的小数
			BigDecimal divideInteger = subtract.divideToIntegralValue(compareFee);// 除以10000 的整数部分

			if (divide.compareTo(new BigDecimal(1)) == -1) {// 小于等于4K
				baseFee = baseFee.add(addShopFee);
			} else {
				if (divide.compareTo(divideInteger) == 0) {
					baseFee = addShopFee.multiply(divideInteger).add(baseFee);
				} else if (divide.compareTo(divideInteger) == 1) {
					baseFee = addShopFee.multiply(divideInteger).add(baseFee).add(addShopFee);
				}
			}
		}
		return baseFee.setScale(0, 0);
	}

	public List<OrderFormBO> listOtherOrder() {
		return orderFormDao.listOtherOrder();
	}
	
//	public List<OrderFormBO> findAllName(){
//		return orderFormDao.findAllName();
//	}
	
	

	/***
	 * 普通会员精品专区运费
	 * 
	 */
	public BigDecimal membersShipFee(BigDecimal goodPrice) {
		// 商品金额
		BigDecimal shipPrice = BigDecimal.ZERO;
		if (goodPrice.intValue() <= 3000) { // 小于3000元固定运费30
			shipPrice = BigDecimal.valueOf(30);
		} else { // 大于3000则每增加1000运费+10元
			// 需增加的运费
			int increase = (goodPrice.intValue() - 3000) / 1000 * 10;
			// 尾数不满1000取1000
			if ((goodPrice.intValue() - 3000) % 1000 != 0) {
				increase += 10;
			}
			// 最终运费
			shipPrice = BigDecimal.valueOf(increase + 30);
		}
		return shipPrice;
	}

	/***
	 * 精品专区 普通会员支付 逻辑
	 * 
	 * @param orderId
	 * @param isAvailableBalance
	 * @param paymentPassword
	 * @param payType
	 * @param uid
	 * @param paymentId
	 * @return
	 * @throws ServiceException
	 */
	public OrderFormBO jingpinOrderPay(Long orderId, Boolean isAvailableBalance, String paymentPassword,
			String payType, Long uid, Long paymentId) throws ServiceException {
		UserMoney money = this.userMoneyService.isExistAndCreate(uid);
		OrderFormBO order = this.fetch(CommUtil.null2Long(orderId));
		if ("balance".equals(payType)) {
			// 用户支付密码是否为空
			if (StringUtils.isBlank(money.getPassword())) {
				throw new MoneyPasswordNullConsumption();
			}
			if (!PasswordUtils.validatePassword(paymentPassword, money.getPassword())) {
				throw new ServiceException("支付密码错误!");
			}
			if (money.getAvailableBalance().compareTo(order.getAllCashPrice()) == -1) {
				throw new ServiceException("云豆不足");
			}
		}

		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			throw new ServiceException("参数错误，付款失败");
		}

		if (order.getOrderStatus() == OrderFormConstants.ORDER_STATUS_HAVE_SUBMITTED) {// 在状态为10的情况下扣除积分
			this.deductIntegral(uid, order.getAllIntegral().intValue());
			order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_YG);
			order.setActualIntegral(order.getAllIntegral());
		}

		if (StringUtil.isNotBlank(payType) && !"balance".equals(payType)) { // 表示平台积分+微信
			this.updateOrderPayment(order, paymentId);
		}

		if (StringUtil.isNotBlank(payType) && "balance".equals(payType)) { // 表示平台积分+云豆
			String logInfo = order.getOrderId() + "订单购物减少可用云豆";
			moneyService.consumptionMoney(order.getUserId(), CommUtil.null2Double(order.getAllCashPrice()),
					logInfo);
			order.setPaymentId(paymentId);
			order.setOrderStatus(OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED);
			order.setActualPrice(order.getAllCashPrice());
			order.setPayTime(new Date());
			this.updateGoodsInventory(order);//增加库存信息
			this.update(order);
		}
		order = this.fetch(CommUtil.null2Long(orderId));
		return order;
	}

	/***
	 * 精品专区购物扣除积分
	 * 
	 * @param uid
	 * @param deduct
	 *            订单需要的支付的积分
	 * @throws ServiceException
	 */
	public void deductIntegral(Long uid, Integer deductIntegral) throws ServiceException {
		UserCustomerBO userCustomerBO = this.customerService.findOneByUserId(uid);
		Integer currentIntegral = userCustomerBO.getIntegral() == null ? 0 : userCustomerBO.getIntegral();
		if (CommUtil.null2BigDecimal(currentIntegral)
				.compareTo(CommUtil.null2BigDecimal(deductIntegral)) == -1) {
			throw new ServiceException("积分不足!");
		}

		IntegralReg integralReg = this.integralRegService
				.getObjByType(IntegralConstants.INTEGRAL_MARK_AND_CASH);
		String content = "精选专区购买商品";
		try {
			this.integralService.addIntegralLog(content, "-" + CommUtil.null2String(deductIntegral),
					integralReg, uid, null, 0, null);
		} catch (Exception e) {
			log.info("精品专区消费日志", e);
		}
		boolean bl = this.customerService.subtractIntegral(uid, deductIntegral);// 扣除积分
	}

	/***
	 * 可扩展的支付对象查询
	 * 
	 * @param payType
	 *            支付mark
	 * @param useFlag
	 *            使用在哪里
	 */
	public PaymentBO getPayment(String payType, int useFlag) {
		PaymentBO paymentBO = null;
		if (useFlag == 1) {
			if (payType.equals("wxqrpay")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_WX);
			}
			if (payType.equals("alipay")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_AL);
			}
			if (payType.equals("balance")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_BL);
			}
		}

		if (useFlag == 2) {
			if (payType.equals("wx_app")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_WX);
			}
			if (payType.equals("alipay_app")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_AL);
			}
			if (payType.equals("balance")) {
				paymentBO = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_PTJF_BL);
			}
		}
		return paymentBO;
	}

	/***
	 * 获取会员信息 精选专区 普通会员
	 * 
	 * @param orderId
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public SelectYgPayModeBO getJingXuanPayMode(String orderId, Long userId) throws ServiceException {
		SelectYgPayModeBO bo = new SelectYgPayModeBO();
		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		bo.setActualIntegralBalance(CommUtil.null2Double(order.getAllIntegral()));
		bo.setActualPrice(CommUtil.null2Double(order.getAllCashPrice()));
		UserCustomerBO userCustomerBO = this.customerService.findOneByUserId(userId);
		if (order != null && order.getOrderStatus() == OrderFormConstants.ORDER_STATUS_HAVE_SUBMITTED) {
			if (CommUtil.null2BigDecimal(userCustomerBO.getIntegral())
					.compareTo(order.getAllIntegral()) == -1) {
				throw new ServiceException("积分不足!");
			}
		}

		bo.setCurrentIntegralBalance(CommUtil.null2Double(userCustomerBO.getIntegral()));
		UserMoneyBO userMoneyBO = this.userMoneyService.findUserMoneyByUid(userId);
		bo.setCurrentBalance(CommUtil.null2Double(userMoneyBO.getAvailableBalance()));
		return bo;
	}

	/***
	 * 精选专区-普通会员-取消订单
	 * 
	 * @param uid
	 * @param orderId
	 * @throws Exception
	 */
	public void jingxunOrderCancel(Long uid, Long orderId) throws Exception {
		OrderFormBO order = this.fetch(Long.valueOf(orderId));
		if (order.getOrderStatus() == OrderFormConstants.ORDER_STATUS_TO_BE_YG
				&& order.getActualIntegral() != null) {
			String content = "精选专区取消订单";
			IntegralReg integralReg = this.integralRegService
					.getObjByType(IntegralConstants.INTEGRAL_MARK_AND_CASH);
			this.integralService.addIntegralLog(content, CommUtil.null2String(order.getActualIntegral()),
					integralReg, uid, null, 0, null);
			this.customerService.addIntegral(uid, order.getActualIntegral().intValue());// 积分返还
		}
	}
	
	/***
	 * 精选专区-普通会员-加积分
	 * @param uid
	 * @param orderId
	 * @throws Exception
	 */
	public void jingxunOrderBuyer(Long uid, Double price) throws Exception {
			String content = "精选专区购物获得积分"+price;
			IntegralReg integralReg = this.integralRegService
					.getObjByType(IntegralConstants.INTEGRAL_MARK_AND_CASH);
			this.integralService.addIntegralLog(content, CommUtil.null2String(price),
					integralReg, uid, null, 0, null);
			this.customerService.addIntegral(uid, price.intValue());// 积分返还
	}
	
	/***
	 * 查询订单是否微信支付状态
	 * @param orderId
	 * @return
	 */
	public boolean selectOrderPayStatus(Long orderId) {
		boolean bl = true;
		OrderForm order = this.orderFormDao.get(orderId);
		Payment payment = this.paymentDao.get(order.getPaymentId());
		if (order.getTradeNo() != null && payment != null && payment.getMark() != null ) {
			if (payment.getName().indexOf("微信") != -1) {
				Map map = this.payTools.selectPayStatus(order.getPaymentId(), order.getTradeNo());
				if (map != null && map.size() > 0) {
					String res = (String)map.get("trade_state");
					if ("SUCCESS".equals(res)) {
						bl = false;
					}
				}
			}
		}
		return bl;
	}
	
	public List<OrderFormBO> queryAllOrderListByVo(MyPage<OrderFormBO> page,OrderFormVO vo) {
		return this.orderFormDao.queryAllOrderListByVo(page, vo);
	}

}
