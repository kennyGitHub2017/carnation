package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.domain.virtual.SysMap;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.common.service.ServiceNORollbackException;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.dao.GoodsCartDao;
import com.sinco.carnation.goods.dao.GoodsCartGspDao;
import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.dao.GoodsSpecPropertyDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;
import com.sinco.carnation.goods.model.GoodsCartGsp;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.dao.ZeroGoodsDao;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.vo.GoodsCartMyVO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.AddressDao;
import com.sinco.carnation.user.dao.SellerDao;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;

@Service
//@Transactional(rollbackFor = ServiceException.class)
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class GoodsCartService {

	private static final Logger log = LoggerFactory.getLogger(GoodsCartService.class);

	@Autowired
	private GoodsCartDao goodsCartDao;

	@Autowired
	private GoodsSpecPropertyDao gspDao;

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsSpecPropertyDao goodsSpecPropertyDao;

	@Autowired
	private GoodsCartGspDao goodsCartGspDao;

	@Autowired
	private StoreService storeService;

	@Autowired
	private GoodsClassService goodsClassService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private TransportTools transportTools;

	@Autowired
	private CouponInfoService couponInfoService;

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private MsgTools msgTools;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private ZeroGoodsDao zeroGoodsDao;
	@Autowired
	private PayTools payTools;
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 
	 * @param userId
	 * @param addr
	 *            送货地址
	 * @param transports
	 *            快递方式
	 * @param msgs
	 *            给商家的msg
	 * @param couponIds
	 *            优惠卷id
	 * @param integrals
	 *            是否积分兑购
	 * @param store_ids
	 *            所有商家id，自营为 self
	 * @param gc_ids
	 *            所有商品id
	 * @param invoiceType
	 *            发票类型
	 * @param invoice
	 *            发票抬头
	 * @param delivery_time
	 *            到时货时间，目前还没有，可空
	 * @param isMobile
	 *            是否手机端
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public  OrderFormBO createOrderForm(Long userId, Long addrId, Map<String, String> transports,
			Map<String, String> msgs, Map<String, Long> couponIds, String[] integrals, String[] gcIds,
			Integer invoiceType, String invoice, String deliveryTime, boolean isMobile, Integer isYgb, Integer payTypeFlag)
			throws ServiceException {

		List<Long> ids = Lists.newArrayList();
		for (String gc_id : gcIds) {
			if (StringUtils.isNotBlank(gc_id)) {
				ids.add(CommUtil.null2Long(gc_id));
			}
		}
		GoodsCartMyVO vo = new GoodsCartMyVO();
		vo.setUserId(userId);
		vo.setIds(ids);

		List<GoodsCartBO> cartsUser = this.findMyCart(vo);

		Set<String> storeIds = Sets.newHashSet();

		for (String gcId : gcIds) {
			for (GoodsCartBO cart : cartsUser) {
				if (CommUtil.null2Long(gcId).equals(cart.getId())) {
					// 如果是商家商品
					if (cart.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
						storeIds.add(String.valueOf(cart.getGoods().getGoodsStoreId()));
					} else {
						storeIds.add("self");
					}
				}
			}
		}

		String servicePath = this.configService.getSysConfig().getAddress();

		Map<Long, String> integralMap = Maps.newHashMap();
		for (String gcId : integrals) {
			integralMap.put(CommUtil.null2Long(gcId), "1");
		}
		
		for (String gcId : gcIds) {//增加判断云购币专区产品,即使是多条购物车，也只判断其中之一
			for (GoodsCartBO cart2 : cartsUser) {
				if (CommUtil.null2Long(gcId).equals(cart2.getId())) {
					GoodsBO goodsBo = this.goodsService.getObjById(cart2
							.getGoodsId());
					if (null != goodsBo && goodsBo.getIsYgb().intValue() == 1) {
						isYgb = goodsBo.getIsYgb();
					}
				}
			}
		}

		return createOrderForm(cartsUser, userId, servicePath, addrId, transports, msgs, couponIds,
				integralMap, storeIds.toArray(new String[storeIds.size()]), gcIds, invoiceType, invoice,
				deliveryTime, isMobile, isYgb, payTypeFlag);
	}

	/**
	 * 创建定单
	 * 
	 * @param order_carts
	 * @param userId
	 * @param servicePath
	 * @param domain
	 * @param addr
	 *            送货地址
	 * @param transports
	 *            快递方式
	 * @param msgs
	 *            给商家的msg
	 * @param couponIds
	 *            优惠卷id
	 * @param integrals
	 *            是否积分兑购
	 * @param store_ids
	 *            所有商家id，自营为 self
	 * @param gc_ids
	 *            所有商品id
	 * @param invoiceType
	 *            发票类型
	 * @param invoice
	 *            发票抬头
	 * @param delivery_time
	 *            到时货时间，目前还没有，可空
	 * @param isMobile
	 *            是否手机端
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public  OrderFormBO createOrderForm(List<GoodsCartBO> order_carts, Long userId, String servicePath,
			Long addrId, Map<String, String> transports, Map<String, String> msgs,
			Map<String, Long> couponIds, Map<Long, String> integrals, String store_ids[], String[] gc_ids,
			Integer invoiceType, String invoice, String delivery_time, boolean isMobile, Integer isYgb, Integer payTypeFlag)
			throws ServiceException {
		try{
		if (store_ids == null || store_ids.length <= 0) {
			throw new ServiceException("所选商品不存在");
		}

		UserCustomerBO customer = customerService.findSessionUser(userId);

		SysConfigBO config = this.configService.getSysConfig();

		if (order_carts.size() <= 0) {
			throw new ServiceException("用户购物车为空");
		}
		UserAccount userAccount = this.userAccountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8);
		BigDecimal countNeedIntegral = BigDecimal.ZERO;
		BigDecimal userIntegral = CommUtil.null2BigDecimal(customer.getIntegral());
		// 验证购物车中是否存在库存为0的商品
		for (GoodsCartBO gc : order_carts) {
			Goods goods = goodsService.getObjById(gc.getGoodsId());
			if (payTypeFlag != null && payTypeFlag == 3 && goods.getIsYgb().intValue()==1) {
				countNeedIntegral = countNeedIntegral.add(goods.getNeedIntegral().multiply(new BigDecimal(gc.getCount())));
			}
			if (gc.getCount() == 0) {
				throw new ServiceException("订单中商品[" + gc.getGoods().getGoodsName() + "]信息已变更，请删除后再提交订单");
			}
			int goods_inventory = CommUtil.null2Int(this.generic_default_info(goods, gc.getCartGsp(),
					customer).get("count"));// 计算商品库存信息

			if (goods_inventory == 0 || goods_inventory < gc.getCount()) {
				throw new ServiceException("订单中商品[" + gc.getGoods().getGoodsName() + "]库存为0，请删除后再提交订单");
			}

			ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(gc.getGoodsId());
			if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
				if (zeroGoods.getGoodsInventory().intValue() == 0) {
					throw new ServiceException("0元商品库存为0，创建订单失败");
				}
			}

			if (gc.getGoods().getGoodsStatus() != GoodsConstants.GOODS_STATUS_SELLING) {
				throw new ServiceException("订单中商品[" + gc.getGoods().getGoodsName() + "]已下架，请删除后再提交订单");
			}
			if (gc.getCount() <= 0) {
				throw new ServiceException("订单中商品[" + gc.getGoods().getGoodsName() + "]数据小于1，请删除后再提交订单");
			}
		}
		
		if (payTypeFlag != null && userIntegral.compareTo(countNeedIntegral) == -1 && payTypeFlag == 3) {
			throw new ServiceException("积分不足,不能创建订单");	
		}
		AddressBO addr = this.addressDao.get(addrId);
		if (addr == null || !addr.getUserId().equals(userId)) {
			throw new ServiceException("送货地址不存在");
		}

		if (StringUtils.isBlank(addr.getAreaInfo())) {// 详细地址为空
			throw new ServiceException("详细地址为空");
		}
		if (StringUtils.isBlank(addr.getTrueName())) {// 收货人为空
			throw new ServiceException("收货人为空");
		}
		if (!CommUtil.isNotNull(addr.getAreaId())) {// 收货人地区
			throw new ServiceException("收货人地区为空");
		}
		if (StringUtils.isBlank(addr.getMobile()) && StringUtils.isBlank(addr.getTelephone())) {// 收货电话
			throw new ServiceException("收货电话为空");
		}
		OrderFormBO main_order = null;

		List<Map> child_order_maps = new ArrayList<Map>();

		BigDecimal all_of_price = new BigDecimal(0);

		int whether_gift_in = 0;// 判断是否有满就送 子订单中包含赠品
								// 则主订单whether_gift变为1
		int useIntegral = 0;// 使用积分
		Set<Long> integralSet = Sets.newHashSet(); // 使用积分的id

		for (int i = 0; i < store_ids.length; i++) {// 根据店铺id，保存多个子订单
			String sid = store_ids[i];// TODO
			Store store = null;

			double commission_amount = 0;// 平台佣金，已加价方式

			List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();
			List<Map> map_list = new ArrayList<Map>();
			if (sid != "self" && !sid.equals("self")) {
				store = this.storeService.getObjById(CommUtil.null2Long(sid));
			}

			for (GoodsCartBO gc : order_carts) {

				boolean add = false;
				for (String gc_id : gc_ids) {
					if (StringUtils.isNotBlank(gc_id) && gc.getId().equals(CommUtil.null2Long(gc_id))) {// 判断是否是用户勾选要购买的商品
						// 判断是否是该商家的商品
						if (gc.getGoods().getGoodsType() == 1) {// 商家商品
							if (gc.getGoods().getGoodsStoreId().equals(CommUtil.null2Long(sid))) {
								add = true;
								break;
							}
						} else {
							if ("self".equals(sid)) {
								add = true;
								break;
							}
						}
					}
				}
				if (!add) {
					continue;
				}

				String isIntegral = integrals.get(gc.getId()); // 是否使用积分

				if (isIntegral != null) {
					useIntegral += gc.getExchangeIntegral() * gc.getCount();
					integralSet.add(gc.getId());
					// 如果使用积分超出用户积分，出异常
					if (useIntegral > customer.getIntegral()) {
						throw new ServiceException("用户积分不够，请重新下单！");
					}
				}

				String goods_type = "";
				if (GoodsConstants.GOODS_CART_TYPE_COMBIN.equals(gc.getCartType())) {
					if (gc.getCombinMain() == 1) {
						goods_type = GoodsConstants.GOODS_CART_TYPE_COMBIN;
					}
				}
				if (GoodsConstants.GOODS_CART_TYPE_GROUP.equals(gc.getCartType())) {
					goods_type = GoodsConstants.GOODS_CART_TYPE_GROUP;
				}
				Map json_map = new HashMap();
				json_map.put("goods_id", gc.getGoods().getId());
				json_map.put("goods_name", gc.getGoods().getGoodsName());
				json_map.put("goods_choice_type", gc.getGoods().getGoodsChoiceType());
				json_map.put("goods_type", goods_type);
				json_map.put("goods_count", gc.getCount());
				json_map.put("goods_integral_price", gc.getGoodsIntegralPrice());// 积分兑换价
				json_map.put("is_integral_price", isIntegral != null);// 是否积分兑换
				json_map.put("is_mobile_price", isIntegral != null ? false : isMobile);// 是否积分兑换
				json_map.put("exchange_integral", gc.getExchangeIntegral());// 所需积分
				ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(gc.getGoods().getId());

				if (null != zeroGoods && zeroGoods.getGoodsStatus()) {// 0元购,产品价格
					json_map.put("goods_price", 0);// 商品单价
					json_map.put("goods_mobile_price", 0);// 手机价
					json_map.put("self_add_price", 0);// 平台加价
				} else {
					json_map.put("goods_price", gc.getPrice());// 商品单价
					json_map.put("goods_mobile_price", gc.getGoodsMobilePrice());// 手机价
					json_map.put("self_add_price", gc.getSelfAddPrice());// 平台加价

					GoodsBO goodsBO = this.goodsService.findBOByid(gc.getGoods().getId());
					String cartGsp = gc.getCartGsp();
					// cn用户
//					if (null != userAccount) {

						if (null != cartGsp && StringUtils.isNotBlank(cartGsp)) {
							Map resMap = this.getYunGouGoodsInfo(gc.getGoods().getId(), cartGsp);
							json_map.put("needYgb", resMap.get("countYgb"));
							json_map.put("needMoney", resMap.get("countCashPrice"));
							json_map.put("cnSelfAddPrice", resMap.get("cnSelfAddPrice"));
							json_map.put("needIntegral", resMap.get("needIntegral"));
							

						} else {
							json_map.put("needYgb", goodsBO.getNeedYgb());
							json_map.put("needMoney", goodsBO.getNeedMoney());
							json_map.put("cnSelfAddPrice", goodsBO.getCnSelfAddPrice());
							json_map.put("needIntegral", goodsBO.getNeedIntegral());
						}
//					}

				}

				// 加上平台佣金
				if (gc.getSelfAddPrice() != null) {
					commission_amount = CommUtil.add(commission_amount,
							CommUtil.mul(gc.getSelfAddPrice(), gc.getCount()));
				}

				// 商品总价,根据是否积分、手机端计算
				json_map.put(
						"goods_all_price",
						CommUtil.mul(gc.getCurrentPrice(integralSet.contains(gc.getId()), isMobile),
								gc.getCount()));
				json_map.put("goods_gsp_val", gc.getSpecInfo());
				json_map.put("goods_gsp_ids", gc.getCartGsp());

				if (gc.getGoods().getGoodsMainPhotoPath() != null) {
					json_map.put("goods_mainphoto_path", gc.getGoods().getGoodsMainPhotoPath());
				} else {
					json_map.put("goods_mainphoto_path", this.configService.getSysConfig().getGoodsImage()
							.getPath());
				}

				// 设置商品组合套装信息
				if (goods_type.equals("combin")) {
					json_map.put("combin_suit_info", gc.getCombinSuitInfo());
				}

				if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {// 商家商品
					String snapshootPath = goodsService.createSnapshoot(userId, gc.getGoodsId());

					json_map.put("goods_commission_price", this.getGoodscartCommission(gc));// 设置该商品总佣金
					GoodsClass goodsClass = this.goodsClassService.getObjById(gc.getGoods().getGcId());
//					json_map.put("goods_commission_rate", goodsClass.getCommissionRate());// 设置该商品的佣金比例
					json_map.put(
							"goods_payoff_price",
							CommUtil.subtract(CommUtil.mul(gc.getPrice(), gc.getCount()),
									this.getGoodscartCommission(gc)));// 该商品结账价格=该商品总价格-商品总佣金
					json_map.put("goods_snapshoot", snapshootPath);
					String goods_domainPath = servicePath + "/goods_" + gc.getGoods().getId() + ".htm";
					String store_domainPath = servicePath + "/store_" + gc.getGoods().getGoodsStoreId()
							+ ".htm";
					json_map.put("goods_domainPath", goods_domainPath);// 商品二级域名路径
					json_map.put("store_domainPath", store_domainPath);// 店铺二级域名路径
					map_list.add(json_map);
					gc_list.add(gc);
				} else {
					// 自营商品
					String snapshootPath = goodsService.createSnapshoot(userId, gc.getGoodsId());
					json_map.put("goods_snapshoot", snapshootPath);
					json_map.put("goods_domainPath",
							new StringBuilder(servicePath).append("/goods_").append(gc.getGoods().getId())
									.append(".htm").toString());// 商品二级域名路径

					map_list.add(json_map);
					gc_list.add(gc);
				}
			}
			// 如果不存在商品,不创建订单
			if (gc_list.size() <= 0) {
				continue;
			}

			double goods_amount = this.calCartPrice(gc_list, gc_ids, integralSet, isMobile);// 订单中商品价格

			double selfAddPrice = this.calSelfAddPrice(gc_list); // 总加价

			List<SysMap> sms = this.transportTools.query_cart_trans(gc_list,
					CommUtil.null2String(addr.getAreaId()));
			String transport = transports.get(sid);
			if (CommUtil.null2String(transport).indexOf("平邮") < 0
					&& CommUtil.null2String(transport).indexOf("快递") < 0
					&& CommUtil.null2String(transport).indexOf("EMS") < 0) {
				transport = "快递";
			}
			double ship_price = 0.00;
			for (SysMap sm : sms) {
				if (CommUtil.null2String(sm.getKey()).indexOf(transport) >= 0) {
					ship_price = CommUtil.null2Double(sm.getValue());// 订单物流运费//TODO
				}
			}
			double totalPrice = CommUtil.add(goods_amount, ship_price);// 订单总价//TODO
			all_of_price = all_of_price.add(new BigDecimal(totalPrice));// 总订单价格

			// double commission_amount = this.getOrderCommission(gc_list);// 订单总体佣金,已经改造成加价

			Map ermap = this.calEnoughReducePrice(gc_list, gc_ids, integrals, isMobile);
			String er_json = (String) ermap.get("er_json");
			double all_goods = Double.parseDouble(ermap.get("all").toString());
			double reduce = Double.parseDouble(ermap.get("reduce").toString());
			OrderFormBO of = new OrderFormBO();
			String order_store_id = "0";
			if (sid != "self" && !sid.equals("self")) {
				order_store_id = CommUtil.null2String(store.getId());
			}
			String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			of.setOrderId(userId + order_suffix + order_store_id);// 订单号码
			// 设置收货地址信息
			of.setReceiverName(addr.getTrueName());
			of.setReceiverArea(addr.getAreaName());
			of.setReceiverAreaInfo(addr.getAreaInfo());
			of.setReceiverMobile(addr.getMobile());
			of.setReceiverTelephone(addr.getTelephone());
			of.setReceiverZip(addr.getZip());
			of.setEnoughReduceAmount(BigDecimal.valueOf(reduce));
			of.setEnoughReduceInfo(er_json);
			of.setTransport(transport);
			of.setOrderStatus(10);
			of.setUserId(customer.getUid());
			of.setUserName(customer.getNickname());
			of.setGoodsInfo(Json.toJson(map_list, JsonFormat.compact()));// 设置商品信息json数据
			of.setMsg(msgs.get(sid));
			of.setInvoiceType(invoiceType);
			of.setInvoice(invoice);

			of.setShipPrice(BigDecimal.valueOf(ship_price));// 订单运费
			of.setGoodsAmount(BigDecimal.valueOf(all_goods));
			of.setTotalPrice(BigDecimal.valueOf(totalPrice));// 订单总价
			of.setSelfAddPrice(new BigDecimal(selfAddPrice));
			// /////////////////////////////////////////////////////////////////0元购 增加费用
			ZeroGoods zeroGoods = this.isZeroGoods(order_carts);
			if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
				of.setShipPrice(zeroGoods.getShipFee());// 订单运费
				of.setGoodsAmount(new BigDecimal(0));
				of.setTotalPrice(zeroGoods.getShipFee());// 订单总价
				of.setSelfAddPrice(new BigDecimal(0));//
				of.setOrderTypeFlag(1);// 0云购订单
				this.updateZeroGoodsInventory(zeroGoods);// 更新锁定库存
			}
			
		
			of.setIsMobile(isMobile);
			Long couponId = couponIds.get(sid);
			if (null != couponId) {
				CouponInfoBO ci = this.couponInfoService.findMyById(couponId, customer.getUid());
				if (ci != null) {
					ci.setStatus(1);
					this.couponInfoService.update(ci);
					Map coupon_map = new HashMap();
					coupon_map.put("couponinfo_id", ci.getId());
					coupon_map.put("couponinfo_sn", ci.getCouponSn());
					coupon_map.put("coupon_amount", ci.getCoupon().getCouponAmount());
					double rate = div(ci.getCoupon().getCouponAmount(), goods_amount);
					coupon_map.put("coupon_goods_rate", rate);
					of.setCouponInfo(Json.toJson(coupon_map, JsonFormat.compact()));
					of.setTotalPrice(BigDecimal.valueOf(CommUtil.subtract(of.getTotalPrice(), ci.getCoupon()
							.getCouponAmount())));
				}
			}
			if (sid.equals("self") || sid == "self") {
				of.setCommissionAmount(BigDecimal.valueOf(commission_amount));// 该订单总体佣金费用
				of.setOrderForm(1);// 平台自营商品订单
			} else {
				of.setCommissionAmount(BigDecimal.valueOf(commission_amount));// 该订单总体佣金费用
				of.setOrderForm(0);// 商家商品订单
				of.setStoreId(store.getId().toString());
				of.setStoreName(store.getStoreName());
			}
			of.setOrderType(OrderFormConstants.ORDER_TYPE_WEB);// 设置为PC网页订单
			of.setDeliveryTime(delivery_time);
			of.setDeliveryType(0);
			if (i == store_ids.length - 1) {
				of.setOrderMain(1);// 同时购买多个商家商品，最后一个订单为主订单，其他的作为子订单，以json信息保存，用在买家中心统一显示大订单，统一付款
				if (whether_gift_in > 0) {
					of.setWhetherGift(1);
				}
				if (child_order_maps.size() > 0) {
					of.setChildOrderDetail(Json.toJson(child_order_maps, JsonFormat.compact()));
				}
			}
			// ///////////////////////////////////////////////////////////判断云购币订单，如果是增加相应的记录
			// 判断订单是都是云购币订单 组装云购币专用支付数据
			if (null != isYgb && isYgb.intValue() == 1) {
				Map mapPice = this.countYunGouOrderMoney(order_carts, gc_ids);
				of.setIsygOrder(true);
				of.setAllygPrice(CommUtil.null2BigDecimal(mapPice.get("allygPrice")));
				of.setAllCashPrice(CommUtil.null2BigDecimal(mapPice.get("allCashPrice")));
				of.setAllIntegral(CommUtil.null2BigDecimal(mapPice.get("allIntegral")));
				BigDecimal totalYgPrice = of.getAllygPrice().add(of.getAllCashPrice());
				//BigDecimal maxPrice = new BigDecimal(2000);
				of.setOrderTypeFlag(3);//将云购币专区 增加新的标识 为3 方便以后扩展
				of.setPayTypeFlag(payTypeFlag);
				
				if (null != userAccount) {
					of.setCnUseralias(userAccount.getLoginName());
				}
				if (null != payTypeFlag && payTypeFlag.intValue() == 2) {
					double commissionAmount = CommUtil.mul(commission_amount, 0.5);
					of.setCommissionAmount(CommUtil.null2BigDecimal(commissionAmount));
					totalYgPrice = of.getAllCashPrice().add(of.getAllIntegral());
					BigDecimal shipFee = this.orderFormService.getYgOrderShopFee(totalYgPrice);
					of.setShipPrice(shipFee);
					of.setAllCashPrice(of.getAllCashPrice().add(shipFee));
					of.setTotalPrice(totalYgPrice.add(shipFee));
					
				} else if (null != payTypeFlag && payTypeFlag.intValue() == 1){
					
					of.setCommissionAmount(CommUtil.null2BigDecimal(0));
					BigDecimal shipFee = this.orderFormService.getYgOrderShopFee(of.getAllygPrice());
					of.setShipPrice(shipFee);
					of.setTotalPrice(of.getAllygPrice().add(shipFee));
				} else if (null != payTypeFlag && payTypeFlag.intValue() == 3) {//增加普通会员数据
					double commissionAmount = CommUtil.mul(commission_amount, 0.5);
					of.setCommissionAmount(CommUtil.null2BigDecimal(commissionAmount));
					totalYgPrice = of.getAllCashPrice().add(of.getAllIntegral());
					BigDecimal shipFee = this.orderFormService.getYgOrderShopFee(totalYgPrice);
					of.setShipPrice(shipFee);
					of.setAllCashPrice(of.getAllCashPrice().add(shipFee));
					of.setTotalPrice(totalYgPrice.add(shipFee));
				}

			} else {
				// //////////////////////////////////////////////非云购币专区的云购币订单记录
				if (null != userAccount) {
					Map mapPice = this.countYunGouOrderMoney(order_carts, gc_ids);
					of.setAllygPrice(CommUtil.null2BigDecimal(mapPice.get("allygPrice")));
					of.setAllCashPrice(CommUtil.null2BigDecimal(mapPice.get("allCashPrice")).add(
							new BigDecimal(ship_price)));
					int resource = of.getAllygPrice().compareTo(new BigDecimal(0));
					if (resource > 0) {// 当AllygPrice字段值大于0说明是参与云购币产品
						of.setOrderTypeFlag(2);// 表示云购币订单[非云购币专区的参与云购币产品]
					}
					of.setCnUseralias(userAccount.getLoginName());
				}
			}
			
			boolean flag = this.orderFormService.createOrderFrom(of);
			main_order = of;
	/*		try {
				this.cheakActivity(order_carts);
			} catch (Exception e) {
				log.error("error",e);
			}*/
			
			if (flag) {
				// 如果是多个店铺的订单同时提交，则记录子订单信息到主订单中，用在买家中心统一显示及统一付款
				if (store_ids.length > 1) {
					Map order_map = new HashMap();
					order_map.put("order_id", of.getId());
					order_map.put("order_goods_info", of.getGoodsInfo());
					child_order_maps.add(order_map);
				}
				for (GoodsCart gc : gc_list) {// 删除已经提交订单的购物车信息
					for (String gc_id : gc_ids) {
						if (!CommUtil.null2String(gc_id).equals("")
								&& CommUtil.null2Long(gc_id).equals(gc.getId())) {
							this.delete(gc.getId());
						}
					}
				}
			}
		}

		if (all_of_price.doubleValue() > 100000) {
			throw new ServiceException("订单金额不能大于 100000 ");
		}

		if (main_order == null) {
			throw new ServiceException("所选商品已失效，订单创建失败！");
		}

		// 扣减用户使用的积分
		this.customerService.useOrderIntegral(userId, useIntegral);

		main_order.setAllOfPrice(all_of_price.doubleValue());

		// 在循环外，给买家只发送一次短信邮件
		try {
			if (main_order.getOrderForm() == 0) {
				this.msgTools.sendEmailCharge(config.getAddress(), "email_tobuyer_order_submit_ok_notify",
						customer.getEmail(), null, CommUtil.null2String(main_order.getId()),
						main_order.getStoreId());
				this.msgTools.sendSmsCharge(config.getAddress(), "sms_tobuyer_order_submit_ok_notify",
						customer.getMobile(), null, CommUtil.null2String(main_order.getId()),
						main_order.getStoreId());
			} else {
				this.msgTools.sendEmailFree(config.getAddress(), "email_tobuyer_order_submit_ok_notify",
						customer.getEmail(), null, CommUtil.null2String(main_order.getId()));
				this.msgTools.sendSmsFree(config.getAddress(), "sms_tobuyer_order_submit_ok_notify",
						customer.getMobile(), null, CommUtil.null2String(main_order.getId()));
			}
		} catch (Exception e) {
			log.error("创建订单发送消息出错", e);
		}
		// 返回主定单
		return main_order;
		
		}catch(Exception e)
		{
			log.error("[create order] error",e);
			return null;
		}

	}

	/**
	 * 除法，保留精度
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double div(Object a, Object b) {
		double ret = 0.0;
		if (!CommUtil.null2String(a).equals("") && !CommUtil.null2String(b).equals("")) {
			BigDecimal e = new BigDecimal(CommUtil.null2String(a));
			BigDecimal f = new BigDecimal(CommUtil.null2String(b));
			if (CommUtil.null2Double(f) > 0)
				ret = e.divide(f, 8, BigDecimal.ROUND_DOWN).doubleValue();
		}
		return ret;
	}

	/**
	 * 根据商品及传递的规格信息，计算该规格商品的价格、库存量
	 * 
	 * @param goods
	 * @param gsp
	 * @return 价格、库存组成的Map
	 */
	public Map generic_default_info(Goods goods, String gsp, UserCustomer user) {
		double price = 0;
		Map map = new HashMap();
		int count = goods.getGoodsInventory();
		price = CommUtil.null2Double(goods.getStorePrice());
		if ("spec".equals(goods.getInventoryType())) {
			if (gsp != null && !gsp.equals("")) {
				List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
				String[] gsp_ids = gsp.split(",");
				for (Map temp : list) {
					String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
					Arrays.sort(gsp_ids);
					Arrays.sort(temp_ids);
					if (Arrays.equals(gsp_ids, temp_ids)) {
						count = CommUtil.null2Int(temp.get("count"));
						price = CommUtil.null2Double(temp.get("price"));
					}
				}
			}
		}
		map.put("price", price);
		map.put("count", count);
		return map;
	}

	/**
	 * 计算商品各种
	 * 
	 * @param carts
	 * @param gcIds
	 * @return
	 */
	public Map calEnoughReducePrice(List<GoodsCartBO> carts, String[] gcIds, Map<Long, String> integrals,
			boolean isMobile) {
		Map<Long, String> erString = new HashMap<Long, String>();
		double all_price = 0.0;
		Map<String, Double> ermap = new HashMap<String, Double>();
		Map erid_goodsids = new HashMap();
		Date date = new Date();
		if (gcIds == null || gcIds.length == 0) {
			for (GoodsCartBO gc : carts) {
				String isIntegral = integrals.get(gc.getId()); // 是否使用积分
				all_price = CommUtil.add(all_price,
						CommUtil.mul(gc.getCount(), gc.getCurrentPrice(isIntegral != null, isMobile)));
			}
		} else {
			for (GoodsCartBO gc : carts) {
				for (String gc_id : gcIds) {
					if (gc.getId().equals(CommUtil.null2Long(gc_id))) {
						String isIntegral = integrals.get(gc.getId()); // 是否使用积分
						all_price = CommUtil
								.add(all_price,
										CommUtil.mul(gc.getCount(),
												gc.getCurrentPrice(isIntegral != null, isMobile)));
					}
				}
			}
		}
		double all_enough_reduce = 0;
		Map prices = new HashMap();
		prices.put("er_json", Json.toJson(erid_goodsids, JsonFormat.compact()));
		prices.put("erString", erString);

		double d2 = Math.round(all_price * 100) / 100.0;
		BigDecimal bd = new BigDecimal(d2);
		BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("all", CommUtil.null2Double(bd2));// 商品总价

		double er = Math.round(all_enough_reduce * 100) / 100.0;
		BigDecimal erbd = new BigDecimal(er);
		BigDecimal erbd2 = erbd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("reduce", CommUtil.null2Double(erbd2));// 满减价格

		double af = Math.round((all_price - all_enough_reduce) * 100) / 100.0;
		BigDecimal afbd = new BigDecimal(af);
		BigDecimal afbd2 = afbd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("after", CommUtil.null2Double(afbd2));// 减后价格

		return prices;
	}

	/**
	 * TODO 计算商品各种
	 * 
	 * @param carts
	 * @param gcIds
	 * @return
	 */
	public Map calEnoughReducePrice(List<GoodsCartBO> carts, String[] gcIds) {
		Map<Long, String> erString = new HashMap<Long, String>();
		double all_price = 0.0;
		double all_need_integral = 0.0;
		double all_need_money = 0.0;
		double all_need_ygb = 0.0;
		Map<String, Double> ermap = new HashMap<String, Double>();
		Map erid_goodsids = new HashMap();
		Date date = new Date();
		if (gcIds == null || gcIds.length == 0) {
			for (GoodsCart gc : carts) {
				all_price = CommUtil.add(all_price, CommUtil.mul(gc.getCount(), gc.getPrice()));
				if(gc.getIsYgb() != null && gc.getIsYgb() == 1){
					GoodsBO goods = goodsService.getObjById(gc.getGoodsId());
					if(goods != null){
						if(goods.getNeedIntegral() != null){
							all_need_integral = CommUtil.add(all_need_integral, CommUtil.mul(gc.getCount(), goods.getNeedIntegral()));
						}
						if(goods.getNeedMoney() != null){
							all_need_money = CommUtil.add(all_need_money, CommUtil.mul(gc.getCount(), goods.getNeedMoney()));
						}
						if(goods.getNeedYgb() != null){
							all_need_ygb = CommUtil.add(all_need_ygb, CommUtil.mul(gc.getCount(), goods.getNeedYgb()));
						}
					}
				}
			}
		} else {
			for (GoodsCart gc : carts) {
				for (String gc_id : gcIds) {
					if (gc.getId().equals(CommUtil.null2Long(gc_id))) {
						all_price = CommUtil.add(all_price, CommUtil.mul(gc.getCount(), gc.getPrice()));
						if(gc.getIsYgb() != null && gc.getIsYgb() == 1){
							GoodsBO goods = goodsService.getObjById(gc.getGoodsId());
							if(goods != null){
								if(goods.getNeedIntegral() != null){
									all_need_integral = CommUtil.add(all_need_integral, CommUtil.mul(gc.getCount(), goods.getNeedIntegral()));
								}
								if(goods.getNeedMoney() != null){
									all_need_money = CommUtil.add(all_need_money, CommUtil.mul(gc.getCount(), goods.getNeedMoney()));
								}
								if(goods.getNeedYgb() != null){
									all_need_ygb = CommUtil.add(all_need_ygb, CommUtil.mul(gc.getCount(), goods.getNeedYgb()));
								}
							}
						}
					}
				}
			}
		}
		double all_enough_reduce = 0;
		Map prices = new HashMap();
		prices.put("er_json", Json.toJson(erid_goodsids, JsonFormat.compact()));
		prices.put("erString", erString);

		double d2 = Math.round(all_price * 100) / 100.0;
		BigDecimal bd = new BigDecimal(d2);
		BigDecimal bd2 = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("all", CommUtil.null2Double(bd2));// 商品总价

		double er = Math.round(all_enough_reduce * 100) / 100.0;
		BigDecimal erbd = new BigDecimal(er);
		BigDecimal erbd2 = erbd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("reduce", CommUtil.null2Double(erbd2));// 满减价格

		double af = Math.round((all_price - all_enough_reduce) * 100) / 100.0;
		BigDecimal afbd = new BigDecimal(af);
		BigDecimal afbd2 = afbd.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("after", CommUtil.null2Double(afbd2));// 减后价格

		double d3 = Math.round(all_need_integral * 100) / 100.0;
		BigDecimal bd3 = new BigDecimal(d3);
		BigDecimal bd4 = bd3.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("allIntegral", CommUtil.null2Double(bd4));// 精品专区需要的总积分

		d3 = Math.round(all_need_money * 100) / 100.0;
		bd3 = new BigDecimal(d3);
		bd4 = bd3.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("allNeedMoney", CommUtil.null2Double(bd4));// 精品专区需要的现金(不含运费)
		
		d3 = Math.round(all_need_ygb * 100) / 100.0;
		bd3 = new BigDecimal(d3);
		bd4 = bd3.setScale(2, BigDecimal.ROUND_HALF_UP);
		prices.put("allNeedYgb", CommUtil.null2Double(bd4));// 精品专区需要的总积分
		
		return prices;
	}

	/**
	 * 获得商品佣金,改成加价
	 * 
	 * @param request
	 * @param response
	 */
	public double getGoodscartCommission(GoodsCartBO gc) {
//		GoodsClass goodsClass = this.goodsClassService.getObjById(gc.getGoods().getGcId());
//		double commission_price = CommUtil.mul(goodsClass.getCommissionRate(), CommUtil.mul(gc.getPrice(), gc.getCount()));
//		return commission_price;
		// 改成加价
		double commission_price = CommUtil.mul(gc.getSelfAddPrice(), gc.getCount());
		return commission_price;
	}

	/**
	 * 获得商品佣金
	 * 
	 * @param request
	 * @param response
	 */
	public double getOrderCommission(List<GoodsCartBO> gcs) {
		double commission_price = 0.00;
		for (GoodsCartBO gc : gcs) {
			commission_price = commission_price + this.getGoodscartCommission(gc);
		}
		return commission_price;
	}

	/**
	 * APP调整商品数量
	 * 
	 * @param gc_id
	 * @param count
	 * @param gcs
	 * @param gift_id
	 */
	public String appAdjustGoodsCount(String gc_id, String count, String[] gcIds, String gift_id)
			throws ServiceNORollbackException {
		GoodsCartBO gc = this.goodsCartDao.findOne(CommUtil.null2Long(gc_id));

		String code = "100";// 100表示修改成功，200表示库存不足,300表示团购库存不足
		if (gc != null) {

			if (CommUtil.null2String(count).length() <= 9) {
				if (gc.getId().toString().equals(gc_id)) {
					String cartType = CommUtil.null2String(gc.getCartType());
					Goods goods = this.goodsService.getObjById(gc.getGoodsId());
					if (cartType.equals("")) {// 普通商品的处理
						if (goods.getGroupBuy() == 2) {// 团购商品处理
						} else if (goods.getActivityStatus() == 2) {// 活动商品处理
						} else {
							String gsp = gc.getCartGsp();
							int inventory = goods.getGoodsInventory();
							if (("spec").equals(goods.getInventoryType())) {
								List<HashMap> list = Json.fromJson(ArrayList.class,
										goods.getGoodsInventoryDetail());
								String[] gsp_ids = gsp.split(",");
								for (Map temp : list) {
									String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
									Arrays.sort(gsp_ids);
									Arrays.sort(temp_ids);
									if (Arrays.equals(gsp_ids, temp_ids)) {
										inventory = CommUtil.null2Int(temp.get("count"));
									}
								}
							}
							if (inventory >= CommUtil.null2Int(count)
									&& CommUtil.null2String(count).length() <= 9 && goods.getGroupBuy() != 2) {
								gc.setCount(CommUtil.null2Int(count));
								this.update(gc);
								code = "100";
							} else {
								if (inventory == 0) {
									gc.setCount(0);
									this.update(gc);
								}
								code = "200";
								throw new ServiceNORollbackException(code);
							}
						}
					}
				}
			} else {
				code = "200";
				throw new ServiceNORollbackException(code);
			}
		}
		return code;
	}

	/**
	 * 调整商品数量
	 * 
	 * @param gc_id
	 * @param count
	 * @param gcs
	 * @param gift_id
	 */
	public GoodsCartBO adjustGoodsCount(String gc_id, String count, String[] gcIds, String gift_id)
			throws ServiceNORollbackException {
		GoodsCartBO gc = this.goodsCartDao.findOne(CommUtil.null2Long(gc_id));

		String code = "100";// 100表示修改成功，200表示库存不足,300表示团购库存不足
		if (gc != null) {

			double gc_price = 0.00;// 单位GoodsCart总价钱

			if (CommUtil.null2String(count).length() <= 9) {
				if (gc.getId().toString().equals(gc_id)) {
					String cartType = CommUtil.null2String(gc.getCartType());
					Goods goods = this.goodsService.getObjById(gc.getGoodsId());
					if (cartType.equals("")) {// 普通商品的处理
						String gsp = gc.getCartGsp();
						int inventory = goods.getGoodsInventory();
						if (("spec").equals(goods.getInventoryType())) {
							List<HashMap> list = Json.fromJson(ArrayList.class,
									goods.getGoodsInventoryDetail());
							String[] gsp_ids = gsp.split(",");
							for (Map temp : list) {
								String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
								Arrays.sort(gsp_ids);
								Arrays.sort(temp_ids);
								if (Arrays.equals(gsp_ids, temp_ids)) {
									inventory = CommUtil.null2Int(temp.get("count"));
									break;
								}
							}
						}
						if (inventory >= CommUtil.null2Int(count)
								&& CommUtil.null2String(count).length() <= 9 && goods.getGroupBuy() != 2) {
							gc.setCount(CommUtil.null2Int(count));
							this.update(gc);
							gc_price = CommUtil.mul(gc.getPrice(), count);
						} else {
							if (inventory == 0) {
								gc.setCount(0);
								this.update(gc);
							}
							code = "200";
							throw new ServiceNORollbackException(code);
						}
					}
				}
			} else {
				code = "200";
				throw new ServiceNORollbackException(code);
			}
		}
		return gc;
	}

	/**
	 * 删除购物车商品
	 * 
	 * @param cart_ids
	 * @return
	 */
	public void removeGoods(String... cart_ids) {

		List<Long> idList = new ArrayList<Long>();
		for (String id : cart_ids) {
			if (id != null && !id.equals("")) {
				if (id.indexOf("combin") < 0) {
					idList.add(CommUtil.null2Long(id));
				}
			}
		}
		GoodsCartMyVO vo = new GoodsCartMyVO();
		vo.setIds(idList);
		if (idList.size() > 0) {
			List<GoodsCartBO> cartList = this.goodsCartDao.findMyCart(vo);

			for (GoodsCartBO gc : cartList) {
				this.goodsCartGspDao.deleteByCartId(gc.getId());
				this.delete(gc.getId());
			}

		}

		List<String> marks = new ArrayList<String>();
		for (String id : cart_ids) {
			if (id != null && id.indexOf("combin") >= 0) {
				marks.add(id);
			}
		}
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param id
	 * @param count
	 * @param price
	 * @param gsp
	 * @param buy_type
	 * @param combin_ids
	 * @param combin_version
	 * @param cart_session_id
	 * @param user
	 * @param carts_list
	 * @return
	 */
	public int addGoods(Long id, String count, String gsp, String buy_type, String combin_ids,
			String combin_version, Long uid, Integer isYgb) {
		List<GoodsCartBO> carts_user = this.findUserCart(uid);

		User user = new User();
		user.setId(uid);

		return addGoods(id, count, gsp, buy_type, combin_ids, combin_version, null, user, carts_user, isYgb);
	}

	/**
	 * 查找用户购物车
	 * 
	 * @param uid
	 * @return
	 */
	public List<GoodsCartBO> findUserCart(Long uid) {
		GoodsCartMyVO cartUserVO = new GoodsCartMyVO();
		cartUserVO.setCartStatus(GoodsConstants.GOODS_CART_STATUS_0);
		cartUserVO.setUserId(uid);
		return this.findMyCart(cartUserVO);
	}

	/**
	 * 添加商品到购物车
	 * 
	 * @param id
	 * @param count
	 * @param price
	 * @param gsp
	 * @param buy_type
	 * @param combin_ids
	 * @param combin_version
	 * @param cart_session_id
	 * @param user
	 * @param carts_list
	 * @return
	 */
	public int addGoods(Long id, String count, String gsp, String buy_type, String combin_ids,
			String combin_version, String cart_session_id, User user, List<GoodsCartBO> carts_list,
			Integer isYgb) {
		int next = 0;// 0为添加成功，-3库存不足,
		// -1添加失败，-2商品下架，添加失败，0普通商品添加,1组合配件添加，2组合套装添加

		UserCustomerBO customer = user != null ? this.customerService.findSessionUser(user.getId()) : null;
		Long uid = 0L;
		if (null != user){
			 uid = user.getId() != null ? user.getId() : 0L;
		}
		
		GoodsBO goods = this.goodsService.findBOByid(id);
		if (goods.getGoodsStatus() == GoodsConstants.GOODS_STATUS_SELLING) { // 是否为上架,
			if (GoodsConstants.GOODS_TYPE_SHOP.equals(goods.getGoodsType())) {
				// 店铺状态正常
				if (!StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS.equals(goods.getGoodsStore()
						.getStoreStatus())) {
					return -2;
				}
				// 不能添加自家商品
				if (customer != null && customer.getStoreId() != null
						&& customer.getStoreId().equals(goods.getGoodsStoreId())) {
					return -4;
				}
			}

			if (StringUtils.isBlank(gsp)) { // 从商品列表页添加到购车，生成默认的gsp信息
				gsp = this.goodsService.genericDefaultGsp(goods);
			}
			int goods_inventory = CommUtil.null2Int(this.goodsService
					.genericDefaultInfo(goods, gsp, customer).get("count"));// 计算商品库存信息

			// 商品且库存大于0，正常加入购物车
			if (goods.getfSaleType() == 0 && goods_inventory > 0) {

				String temp_gsp = gsp;
				if ("parts".equals(buy_type)) {
					if (combin_ids != null && !combin_ids.equals("")) {
						next = 1;
					}
				}
				if ("suit".equals(buy_type)) {
					if (combin_ids != null && !combin_ids.equals("")) {
						next = 2;
					}
				}
				boolean add = true;
				boolean combin_add = true;
				if ("suit".equals(buy_type)) {
					combin_add = false;
				}
				String[] gsp_ids = CommUtil.null2String(temp_gsp).split(",");
				Arrays.sort(gsp_ids);
				for (GoodsCartBO gc : carts_list) {
					if (gsp_ids != null && gsp_ids.length > 0 && StringUtils.isNotBlank(gc.getCartGsp())) {
						String[] gsp_ids1 = gc.getCartGspsId();

						if (gsp_ids1 != null && gc.getGoodsId().equals(id)
								&& Arrays.equals(gsp_ids, gsp_ids1)) {
							// 为组合
							if (GoodsConstants.GOODS_CART_TYPE_COMBIN.equals(gc.getCartType())) {
								if (!combin_add) {
									add = false;
									break;
								} else {
									add = true;
								}
							} else {
								add = false;
								break;
							}
						}
					} else {
						if (gc.getGoodsId().equals(id)) {
							if (GoodsConstants.GOODS_CART_TYPE_COMBIN.equals(gc.getCartType())) {
								if (!combin_add) {
									add = false;
									break;
								} else {
									add = true;
								}
							} else {
								add = false;
								break;
							}
						}
					}
				}
				if (add && combin_add) // 排除购物车中没有重复商品后添加该商品到购物车,并且非组合添加
				{
					GoodsCart obj = new GoodsCart();
					obj.setCartGsp(StringUtils.join(gsp_ids, ","));
					obj.setAddTime(new Date());
					obj.setCount(CommUtil.null2Int(count));

					// 设置平台各价格
					boolean bl = false;
					if (user != null) {
						bl = this.checkUserIsCn(user.getId());// 检查是否是cn会员
					}
					
					this.setGspGoodsPrice(obj, temp_gsp, customer, goods, bl);

					obj.setGoodsId(goods.getId());

					// 设置 spec_info
					List<GoodsSpecPropertyBO> specPropertys = this.goodsSpecPropertyDao
							.selectBOSpecByIds(gsp_ids);
					String spec_info = "";
					for (GoodsSpecPropertyBO spec_property : specPropertys) {
						spec_info = spec_property.getSpec().getName() + "：" + spec_property.getValue()
								+ "<br>" + spec_info;
					}
					obj.setSpecInfo(spec_info);

					if (user == null) {
						obj.setCartSessionId(cart_session_id);
					} else {
						obj.setUserId(user.getId());
					}

					//if (null != isYgb && isYgb.intValue() == 1) {
					//	obj.setIsYgb(1);// 增加云购币标识
					//}
					obj.setIsYgb(goods.getIsYgb());
					//boolean isCN = this.userAccountService.check_User_Is_CN(uid);
					boolean isCN = bl;
					boolean isCNGoods = goods.getExPriceFlag() == 1 ? Boolean.TRUE : Boolean.FALSE;
					if (isCN && isCNGoods) // 是CN用户&&CN商品
					{
						obj.setExPriceFlag(GoodsCart.EXPEICEFLAG_YES);
					} else {
						obj.setExPriceFlag(GoodsCart.EXPEICEFLAG_NO);
					}
					// 设置商品shu
					this.goodsCartDao.save(obj);

					// 设置购物车商品属性
					List<GoodsCartGsp> cgspList = new ArrayList<GoodsCartGsp>();
					for (GoodsSpecPropertyBO spec_property : specPropertys) {
						GoodsCartGsp cgsp = new GoodsCartGsp();
						cgsp.setCartId(obj.getId());
						cgsp.setGspId(spec_property.getId());
					}
					this.goodsCartGspDao.save(cgspList);
				} else {
					for (GoodsCartBO gc : carts_list) {
						if (gc.getGoodsId().equals(id)) {
							if (gsp_ids != null && gsp_ids.length > 0
									&& StringUtils.isNotBlank(gc.getCartGsp())) {
								String[] gsp_ids1 = gc.getCartGspsId();
								if (gsp_ids1 != null && Arrays.equals(gsp_ids, gsp_ids1)) {
									gc.setCount(gc.getCount() + CommUtil.null2Int(count));
								}
							} else {
								gc.setCount(gc.getCount() + CommUtil.null2Int(count));
							}
							this.goodsCartDao.save(gc);
						}
					}
				}
			} else {
				next = -3;
			}
		} else {
			next = -2;
		}

		return next;
	}

	/**
	 * 立即购买
	 * 
	 * @param id
	 * @param count
	 * @param price
	 * @param gsp
	 * @param combin_ids
	 * @param combin_version
	 * @param cart_session_id
	 * @param user
	 * @param carts_list
	 * @return
	 * @throws ServiceException
	 */
	public GoodsCartBO buyGoods(Long id, String count, String gsp, String cart_session_id, User user)
			throws ServiceException {

		UserCustomerBO customer = user != null ? this.customerService.findSessionUser(user.getId()) : null;

		GoodsBO goods = this.goodsService.findBOByid(id);
		// 是否为上架,
		if (goods.getGoodsStatus() != GoodsConstants.GOODS_STATUS_SELLING) {
			throw new ServiceException("商品已下架，购买失败");
		}
		if (GoodsConstants.GOODS_TYPE_SHOP.equals(goods.getGoodsType())) {
			// 店铺状态正常
			if (!StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS
					.equals(goods.getGoodsStore().getStoreStatus())) {
				throw new ServiceException("店铺状态异常");
			}
			// 不能添加自家商品
			if (customer != null && customer.getStoreId() != null
					&& customer.getStoreId().equals(goods.getGoodsStoreId())) {
				throw new ServiceException("请不要购买自家商品");
			}
		}
		
		// 不能添加自家商品
/*		if (customer != null && customer.getStoreId() != null
				&& customer.getStoreId().equals(goods.getGoodsStoreId())) {
			throw new ServiceException("请不要购买自家商品");
		}*/

		if (StringUtils.isBlank(gsp)) {// 从商品列表页添加到购车，生成默认的gsp信息
			gsp = this.goodsService.genericDefaultGsp(goods);
		}
		int goods_inventory = CommUtil.null2Int(this.goodsService.genericDefaultInfo(goods, gsp, customer)
				.get("count"));// 计算商品库存信息

		if (goods_inventory <= 0) {
			throw new ServiceException("库存不足，无法购买！");
		}

		String temp_gsp = gsp;
		String[] gsp_ids = CommUtil.null2String(temp_gsp).split(",");
		Arrays.sort(gsp_ids);

		GoodsCartBO obj = new GoodsCartBO();
		obj.setCartGsp(StringUtils.join(gsp_ids, ","));
		obj.setAddTime(new Date());
		obj.setCount(CommUtil.null2Int(count));
		// 状态为立即支付
		obj.setCartStatus(GoodsConstants.GOODS_CART_STATUS_2);
		boolean bl = false;
		if (null != user) {
			bl = this.checkUserIsCn(user.getId());// 检查是否是cn会员 TODO
		}
		
		// 设置平台各价格
		this.setGspGoodsPrice(obj, temp_gsp, customer, goods, bl);// 增加CN会员标识

		obj.setGoodsId(goods.getId());

		// 设置 spec_info
		List<GoodsSpecPropertyBO> specPropertys = this.goodsSpecPropertyDao.selectBOSpecByIds(gsp_ids);
		String spec_info = "";
		for (GoodsSpecPropertyBO spec_property : specPropertys) {
			spec_info = spec_property.getSpec().getName() + "：" + spec_property.getValue() + "<br>"
					+ spec_info;
		}
		obj.setSpecInfo(spec_info);

		if (user == null) {
			obj.setCartSessionId(cart_session_id);
		} else {
			obj.setUserId(user.getId());
		}
		if(goods.getIsYgb() != null && goods.getIsYgb() == 1){
			obj.setIsYgb(1);
		}
		this.goodsCartDao.save(obj);

		// 设置购物车商品属性
		List<GoodsCartGsp> cgspList = new ArrayList<GoodsCartGsp>();
		for (GoodsSpecPropertyBO spec_property : specPropertys) {
			GoodsCartGsp cgsp = new GoodsCartGsp();
			cgsp.setCartId(obj.getId());
			cgsp.setGspId(spec_property.getId());
		}
		this.goodsCartGspDao.save(cgspList);

//		if(null != user){//用户在商品详情页面停留过久,登录信息失效空指针异常
		// 删除过期数据
			delExpireBuyCart(user.getId());
//		}

		return obj;
	}

	/**
	 * 删除过期的立即购买商品
	 * 
	 * @param uid
	 */
	public void delExpireBuyCart(Long uid) {
		// 默认 1 小时为过期时间
		Calendar date = Calendar.getInstance();
		System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
		date.add(Calendar.HOUR, -1);
		System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
		goodsCartDao.deleteByAddTime(uid, date.getTime());
	}

	/**
	 * 得到购物车数量
	 * 
	 * @param user
	 * @param storeId
	 * @param cart_session_id
	 * @param isLoadAll
	 * @return
	 */
	public int countCartCalc(Long uid, String sessionId) {
		return goodsCartDao.countByUidOrSessionId(uid, sessionId);
	}

	/**
	 * 查找用户购物车
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public List<GoodsCartBO> findUserCart(User user, Long storeId, String cart_session_id, Boolean isLoadAll) {
		List<GoodsCartBO> myCarts = Lists.newArrayList();
		if (user == null) {
			myCarts.addAll(this.findCookieCarts(cart_session_id));
		} else {
			myCarts.addAll(this.findUserCart(user.getId()));
		}

		// 最终返回结果
		List<GoodsCartBO> result = new ArrayList<>();

		for (GoodsCartBO gc : myCarts) {
			// 删除用户自己的商品
			if (GoodsConstants.GOODS_TYPE_SHOP.equals(gc.getGoods().getGoodsType())
					&& gc.getGoods().getGoodsStoreId().equals(storeId)) {
				delete(gc.getId());
			} else {
				result.add(gc);
			}
		}

		if (isLoadAll) {
			for (GoodsCartBO goodsCartBO : result) {
				goodsCartBO.setGsps(this.gspDao.selectBOSpecByCartId(goodsCartBO.getId()));
			}
		}

		return result;
	}

	/**
	 * 查找用户立即购买购物车
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public List<GoodsCartBO> findUserBuyCart(Long uid, String cart_session_id, Boolean isLoadAll) {
		GoodsCartMyVO cartUserVO = new GoodsCartMyVO();
		cartUserVO.setCartStatus(GoodsConstants.GOODS_CART_STATUS_2);
		cartUserVO.setUserId(uid);
		List<GoodsCartBO> result = this.findMyCart(cartUserVO);
		if (isLoadAll) {
			for (GoodsCartBO goodsCartBO : result) {
				goodsCartBO.setGsps(this.gspDao.selectBOSpecByCartId(goodsCartBO.getId()));
			}
		}
		return result;
	}

	/**
	 * 用户登陆后清除用户购物车中自己店铺的商品，将cookie购物车与用户user购物车合并，去重复商品（相同商品不同规格不去掉）
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public List<GoodsCartBO> mergerCart(Long uid, Long storeId, String cart_session_id) {
		List<GoodsCartBO> carts_cookie = this.findCookieCarts(cart_session_id);// 未提交的用户cookie购物车
		List<GoodsCartBO> carts_list = new ArrayList<GoodsCartBO>();// 用户整体购物车
		// 将cookie购物车与用户user购物车合并，去重
		if (uid != null) {

			GoodsCartMyVO cartUserVO = new GoodsCartMyVO();
			cartUserVO.setCartStatus(GoodsConstants.GOODS_CART_STATUS_0);
			cartUserVO.setUserId(uid);
			List<GoodsCartBO> carts_user = this.findMyCart(cartUserVO);

			for (GoodsCartBO cookie : carts_cookie) {
				boolean add = true;

				for (GoodsCartBO gc2 : carts_user) {
					if (cookie.getGoodsId().equals(gc2.getGoodsId())) {
						if (cookie.getSpecInfo().equals(gc2.getSpecInfo())) {
							add = false;
							delete(cookie.getId());
						}
					}
				}
				if (add) {// 将cookie去重并添加到cart_list中
					cookie.setCartSessionId("");
					cookie.setUserId(uid);
					this.update(cookie);
					carts_list.add(cookie);
				}
			}

			carts_list.addAll(carts_user);
		} else {
			carts_list.addAll(carts_cookie);
		}

		// 最终返回结果
		List<GoodsCartBO> result = new ArrayList<>();

		String temp_val = "";
		for (GoodsCartBO gc : carts_list) {

			// 删除用户自己的商品
			if (GoodsConstants.GOODS_TYPE_SHOP.equals(gc.getGoods().getGoodsType())
					&& gc.getGoods().getGoodsStoreId().equals(storeId)) {
				delete(gc.getId());
				continue;
			}

			// 去重复
			String val = "," + CommUtil.null2String(gc.getGoodsId()) + "_" + gc.getSpecInfo() + "_"
					+ gc.getCartType() + "_" + gc.getCombinVersion();
			if (temp_val.indexOf(val) < 0) {
				result.add(gc);
				temp_val = temp_val + "," + val;
			} else {
				this.delete(gc.getId());
			}
		}

		return result;
	}

	/**
	 * 根据商品规格获取价格
	 * 
	 * @param request
	 * @param response
	 */
	public double generGspgoodsPrice(String gsp, UserCustomerBO user, GoodsBO goods) {
		double price = CommUtil.null2Double(goods.getGoodsCurrentPrice());

		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
			String[] gsp_ids = gsp.split(",");
			for (Map temp : list) {
				String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
				Arrays.sort(gsp_ids);
				Arrays.sort(temp_ids);
				if (Arrays.equals(gsp_ids, temp_ids)) {
					price = CommUtil.null2Double(temp.get("price"));
				}
			}
		}
		return price;
	}

	/**
	 * 设置商品规格价格
	 * 
	 * @param request
	 * @param response
	 */
	public void setGspGoodsPrice(GoodsCart cart, String gsp, UserCustomerBO user, GoodsBO goods,
			boolean cnUser) {
		BigDecimal price = goods.getGoodsCurrentPrice();

		// 积分价
		BigDecimal integralPrice = goods.getGoodsIntegralPrice();

		// 积分值
		Integer exchangeIntegral = goods.getExchangeIntegral();

		// 手机价
		BigDecimal mobilePrice = goods.getGoodsMobilePrice();

		// 平台加价
		BigDecimal selfAddPrice = goods.getSelfAddPrice();

		if (cnUser && goods.getExPriceFlag().equals(1)) {
			selfAddPrice = goods.getCnSelfAddPrice();
		}
		
		if (goods.getIsYgb() == 1) {
			selfAddPrice = goods.getNeedMoney();
			log.debug("选择积分支付时的分润值 {} ", selfAddPrice);
		}

		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			List<HashMap> list = Json.fromJson(ArrayList.class, goods.getGoodsInventoryDetail());
			String[] gsp_ids = gsp.split(",");
			for (Map temp : list) {
				String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
				Arrays.sort(gsp_ids);
				
				Arrays.sort(temp_ids);
				if (Arrays.equals(gsp_ids, temp_ids)) {
					price = new BigDecimal(CommUtil.null2Double(temp.get("price")));
					integralPrice = new BigDecimal(CommUtil.null2Double(temp.get("integralPrice")));
					exchangeIntegral = CommUtil.null2Int(temp.get("integralCount"));
					mobilePrice = new BigDecimal(CommUtil.null2Double(temp.get("mobilePrice")));
					selfAddPrice = new BigDecimal(CommUtil.null2Double(temp.get("selfAddPrice")));

					if (cnUser && goods.getExPriceFlag().equals(1)) {
						selfAddPrice = new BigDecimal(CommUtil.null2Double(temp.get("cnSelfAddPrice")));
					}

				}
			}
		}
		if(goods.getIsYgb() != null && goods.getIsYgb() == 1){
			if(goods.getStorePrice() != null)
			price = goods.getStorePrice();
		}
		cart.setPrice(price);
		cart.setGoodsIntegralPrice(integralPrice);
		cart.setExchangeIntegral(exchangeIntegral);
		cart.setGoodsMobilePrice(mobilePrice);
		cart.setSelfAddPrice(selfAddPrice);
	}

	/**
	 * 获得购物车中用户勾选需要购买的商品总价格
	 * 
	 * @param request
	 * @param response
	 */
	public double calCartPrice(List<GoodsCartBO> carts, String[] gcIds) {
		return calCartPrice(carts, gcIds, null, false);
	}

	/**
	 * 获得购物车中用户勾选需要购买的商品总价格
	 * 
	 * @param request
	 * @param response
	 */
	public double calCartPrice(Long uid, String[] gcIds, boolean isApp) {
		List<GoodsCartBO> carts = this.findUserCart(uid);
		return calCartPrice(carts, gcIds, null, isApp);
	}

	/**
	 * 获得购物车的总加价
	 * 
	 * @param request
	 * @param response
	 */
	public double calSelfAddPrice(List<GoodsCartBO> carts) {
		BigDecimal price = new BigDecimal(0.00);
		for (GoodsCart gc : carts) {
			if (gc.getSelfAddPrice() != null) {
				price.add(gc.getSelfAddPrice());
			}
		}
		return price.doubleValue();
	}

	/**
	 * 获得购物车中用户勾选需要购买的商品总价格
	 * 
	 * @param request
	 * @param response
	 */
	public double calCartPrice(List<GoodsCartBO> carts, String[] gcIds, Set<Long> integralSet, boolean isApp) {
		double all_price = 0.0;
		Map<String, Double> ermap = new HashMap<String, Double>();
		if (gcIds == null || gcIds.length == 0) {
			for (GoodsCart gc : carts) {
				if (StringUtils.isBlank(gc.getCartType())) {// 普通商品处理
					if (integralSet != null && integralSet.contains(gc.getId())) {
						all_price = CommUtil.add(all_price,
								CommUtil.mul(gc.getCount(), gc.getGoodsIntegralPrice()));
					} else {
						GoodsBO goods = goodsService.getObjById(gc.getGoodsId());// 取得购物车中商品
						if (goods != null) {
							gc.setGoodsMobilePrice(goods.getGoodsMobilePrice());
						}
						this.update(gc);// 更新价格
						// 是否app端
						if (isApp && gc.getGoodsMobilePrice() != null
								&& gc.getGoodsMobilePrice().doubleValue() > 0) {
							all_price = CommUtil.add(all_price,
									CommUtil.mul(gc.getCount(), gc.getGoodsMobilePrice().doubleValue()));
						} else {
							all_price = CommUtil.add(all_price, CommUtil.mul(gc.getCount(), gc.getPrice()));
						}
					}
				} else if (gc.getCartType().equals("combin")) {// 组合套装商品处理
					if (gc.getCombinMain() == 1) {
						Map map = (Map) Json.fromJson(gc.getCombinSuitInfo());
						all_price = CommUtil.add(all_price, map.get("suit_all_price"));
					}
				}
			}
		} else {
			for (GoodsCart gc : carts) {
				for (String gc_id : gcIds) {
					if (gc.getId().equals(CommUtil.null2Long(gc_id))) {
						if (gc.getCartType() != null && gc.getCartType().equals("combin")
								&& gc.getCombinMain() == 1) {
							Map map = (Map) Json.fromJson(gc.getCombinSuitInfo());
							all_price = CommUtil.add(all_price, map.get("suit_all_price"));
						} else {
							if (integralSet != null && integralSet.contains(gc.getId())) {
								all_price = CommUtil.add(all_price,
										CommUtil.mul(gc.getCount(), gc.getGoodsIntegralPrice()));
							} else {
								GoodsBO goods = goodsService.getObjById(gc.getGoodsId());// 取得购物车中商品
								if (goods != null) {
									gc.setGoodsMobilePrice(goods.getGoodsMobilePrice());
								}
								this.update(gc);// 更新价格
								// 是否app端
								if (isApp && gc.getGoodsMobilePrice() != null
										&& gc.getGoodsMobilePrice().doubleValue() > 0) {
									all_price = CommUtil.add(all_price, CommUtil.mul(gc.getCount(), gc
											.getGoodsMobilePrice().doubleValue()));
								} else {
									all_price = CommUtil.add(all_price,
											CommUtil.mul(gc.getCount(), gc.getPrice()));
								}
							}
						}
					}
				}
			}
		}

		double d2 = Math.round((all_price) * 100) / 100.0;
		// double d2 = Math.round((all_price - all_enough_reduce) * 100) /
		// 100.0;
		return CommUtil.null2Double(CommUtil.formatMoney(d2));
	}

	/**
	 * 查找cookie 中的购物车
	 * 
	 * @param cartSessionId
	 * @param uid
	 * @return
	 */
	public List<GoodsCartBO> findCookieCarts(String cartSessionId) {
		GoodsCartMyVO cartCookieVO = new GoodsCartMyVO();
		cartCookieVO.setCartStatus(GoodsConstants.GOODS_CART_STATUS_0);

		cartCookieVO.setCartSessionId(cartSessionId);

		return this.goodsCartDao.findMyCart(cartCookieVO);
	}

	/**
	 * 查找我的购物车
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsCartBO> findMyCart(GoodsCartMyVO vo) {
		List<GoodsCartBO> list = goodsCartDao.findMyCart(vo);
		return list;
	}

	public boolean save(GoodsCart goodsCart) {
		/**
		 * init other field here
		 */
		this.goodsCartDao.save(goodsCart);
		return true;
	}

	public GoodsCartBO getObjById(Long id) {
		return this.goodsCartDao.get(id);
	}

	public boolean delete(Long id) {
		this.goodsCartDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Serializable> goodsCartIds) {
		for (Serializable id : goodsCartIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(GoodsCart goodsCart) {
		this.goodsCartDao.update(goodsCart);
		return true;
	}

	public GoodsCartBO findMyByIdCart(Long cartId) {
		return goodsCartDao.findMyByIdCart(cartId);
	}

	/**
	 * 添加商品到购物车 返回 cartId
	 * 
	 * @param id
	 * @param count
	 * @param price
	 * @param gsp
	 * @param buy_type
	 * @param combin_ids
	 * @param combin_version
	 * @param cart_session_id
	 * @param user
	 * @param carts_list
	 * @return
	 */
	public int addGoods2(Long id, String count, String gsp, String buy_type, String combin_ids,
			String combin_version, String cart_session_id, User user, List<GoodsCartBO> carts_list) {
		int next = 0;// 0为添加成功，-3库存不足,
		// -1添加失败，-2商品下架，添加失败，0普通商品添加,1组合配件添加，2组合套装添加

		UserCustomerBO customer = user != null ? this.customerService.findSessionUser(user.getId()) : null;

		GoodsBO goods = this.goodsService.findBOByid(id);
		if (goods.getGoodsStatus() == GoodsConstants.GOODS_STATUS_SELLING) { // 是否为上架,
			if (GoodsConstants.GOODS_TYPE_SHOP.equals(goods.getGoodsType())) {
				// 店铺状态正常
				if (!StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS.equals(goods.getGoodsStore()
						.getStoreStatus())) {
					return -2;
				}
				// 不能添加自家商品
				if (customer != null && customer.getStoreId() != null
						&& customer.getStoreId().equals(goods.getGoodsStoreId())) {
					return -4;
				}
			}

			if (StringUtils.isBlank(gsp)) {// 从商品列表页添加到购车，生成默认的gsp信息
				gsp = this.goodsService.genericDefaultGsp(goods);
			}
			int goods_inventory = CommUtil.null2Int(this.goodsService
					.genericDefaultInfo(goods, gsp, customer).get("count"));// 计算商品库存信息

			// 商品且库存大于0，正常加入购物车
			if (goods.getfSaleType() == 0 && goods_inventory > 0) {

				String temp_gsp = gsp;
				if ("parts".equals(buy_type)) {
					if (combin_ids != null && !combin_ids.equals("")) {
						next = 1;
					}
				}
				if ("suit".equals(buy_type)) {
					if (combin_ids != null && !combin_ids.equals("")) {
						next = 2;
					}
				}
				boolean add = true;
				boolean combin_add = true;
				if ("suit".equals(buy_type)) {
					combin_add = false;
				}
				String[] gsp_ids = CommUtil.null2String(temp_gsp).split(",");
				Arrays.sort(gsp_ids);
				for (GoodsCartBO gc : carts_list) {
					if (gsp_ids != null && gsp_ids.length > 0 && StringUtils.isNotBlank(gc.getCartGsp())) {
						String[] gsp_ids1 = gc.getCartGspsId();

						if (gsp_ids1 != null && gc.getGoodsId().equals(id)
								&& Arrays.equals(gsp_ids, gsp_ids1)) {
							// 为组合
							if (GoodsConstants.GOODS_CART_TYPE_COMBIN.equals(gc.getCartType())) {
								if (!combin_add) {
									add = false;
									break;
								} else {
									add = true;
								}
							} else {
								add = false;
								break;
							}
						}
					} else {
						if (gc.getGoodsId().equals(id)) {
							if (GoodsConstants.GOODS_CART_TYPE_COMBIN.equals(gc.getCartType())) {
								if (!combin_add) {
									add = false;
									break;
								} else {
									add = true;
								}
							} else {
								add = false;
								break;
							}
						}
					}
				}
				if (add && combin_add) {// 排除购物车中没有重复商品后添加该商品到购物车,并且非组合添加
					GoodsCart obj = new GoodsCart();
					obj.setCartGsp(StringUtils.join(gsp_ids, ","));
					obj.setAddTime(new Date());
					obj.setCount(CommUtil.null2Int(count));
					boolean bl = this.checkUserIsCn(user.getId());// 检查是否是cn会员 TODO
					// 设置平台各价格1
					this.setGspGoodsPrice(obj, temp_gsp, customer, goods, bl);// 增加CN会员标识

					obj.setGoodsId(goods.getId());

					// 设置 spec_info
					List<GoodsSpecPropertyBO> specPropertys = this.goodsSpecPropertyDao
							.selectBOSpecByIds(gsp_ids);
					String spec_info = "";
					for (GoodsSpecPropertyBO spec_property : specPropertys) {
						spec_info = spec_property.getSpec().getName() + "：" + spec_property.getValue()
								+ "<br>" + spec_info;
					}
					obj.setSpecInfo(spec_info);

					if (user == null) {
						obj.setCartSessionId(cart_session_id);
					} else {
						obj.setUserId(user.getId());
						boolean isCN = this.userAccountService.check_User_Is_CN(user.getId());
						boolean isCNGoods = goods.getExPriceFlag() == 1 ? Boolean.TRUE : Boolean.FALSE;
						if (isCN && isCNGoods) // 是CN用户&&CN商品
						{
							obj.setExPriceFlag(GoodsCart.EXPEICEFLAG_YES);
						} else {
							obj.setExPriceFlag(GoodsCart.EXPEICEFLAG_NO);
						}
					}

					// 设置商品shu
					GoodsCart cart = this.goodsCartDao.save(obj);
					next = CommUtil.null2Int(cart.getId());

					// 设置购物车商品属性
					List<GoodsCartGsp> cgspList = new ArrayList<GoodsCartGsp>();
					for (GoodsSpecPropertyBO spec_property : specPropertys) {
						GoodsCartGsp cgsp = new GoodsCartGsp();
						cgsp.setCartId(obj.getId());
						cgsp.setGspId(spec_property.getId());
					}
					List<GoodsCartGsp> a = this.goodsCartGspDao.save(cgspList);
				} else {
					for (GoodsCartBO gc : carts_list) {
						if (gc.getGoodsId().equals(id)) {
							if (gsp_ids != null && gsp_ids.length > 0
									&& StringUtils.isNotBlank(gc.getCartGsp())) {
								String[] gsp_ids1 = gc.getCartGspsId();
								if (gsp_ids1 != null && Arrays.equals(gsp_ids, gsp_ids1)) {
									gc.setCount(gc.getCount() + CommUtil.null2Int(count));
								}
							} else {
								gc.setCount(gc.getCount() + CommUtil.null2Int(count));
							}
							if (user != null) {
								boolean isCN = this.userAccountService.check_User_Is_CN(user.getId());
								boolean isCNGoods = goods.getExPriceFlag() == 1 ? Boolean.TRUE
										: Boolean.FALSE;
								if (isCN && isCNGoods) // 是CN用户&&CN商品
								{
									gc.setExPriceFlag(GoodsCart.EXPEICEFLAG_YES);
								} else {
									gc.setExPriceFlag(GoodsCart.EXPEICEFLAG_NO);
								}
							}
							GoodsCart cart = this.goodsCartDao.save(gc);
							next = CommUtil.null2Int(cart.getId());
						}
					}
				}
			} else {
				next = -3;
			}
		} else {
			next = -2;
		}
		return next;
	}

	public List<GoodsCartBO> getByUserAndGoodsId(Long userId, Long goodsId) {
		return this.goodsCartDao.getByUserAndGoodsId(userId, goodsId);
	}

	/****
	 * 
	 * 计算云购币专区产品和 云购币产品 需要的云购币总和和现金总和
	 * 
	 * @param carts
	 *            购物车集合
	 * @param gcIds
	 *            产品Id数组
	 * @return
	 */
	public Map countYunGouOrderMoney(List<GoodsCartBO> carts, String[] gcIds) {
		Map mapPrice = new HashMap();

		double allygPrice = 0.0;// 云购币
		double allCashPrice = 0.0;// 需要现金
		double allIntegral = 0.0;//需要的积分

		for (GoodsCartBO cart : carts) {

			Long buyGoodsId = cart.getGoodsId();// 单个订单产品Id
			Integer buyCount = cart.getCount();// 单个产品购买总数
			GoodsBO goodsBo = this.goodsService.getGoodsBOById(buyGoodsId);
			BigDecimal money = goodsBo.getNeedMoney();
			BigDecimal ygb = goodsBo.getNeedYgb();
			BigDecimal Integral = goodsBo.getNeedIntegral();

			if (money != null && ygb != null && goodsBo.getIsYgb().intValue() == 1) {
				BigDecimal countYgb = ygb.multiply(CommUtil.null2BigDecimal(buyCount)).setScale(0,
						BigDecimal.ROUND_HALF_UP); // 云购币整数
				allygPrice = CommUtil.add(allygPrice, countYgb);

				BigDecimal countCashPrice = money.multiply(CommUtil.null2BigDecimal(buyCount)).setScale(2,
						BigDecimal.ROUND_HALF_UP);
				allCashPrice = CommUtil.add(allCashPrice, countCashPrice);
				
				BigDecimal countIntegral = Integral.multiply(CommUtil.null2BigDecimal(buyCount).setScale(2,
						BigDecimal.ROUND_HALF_UP));
				allIntegral = CommUtil.add(allIntegral, countIntegral);

			} else {

				if (goodsBo.getExPriceFlag().intValue() == 1 && null != cart.getCartGsp()
						&& StringUtils.isNotBlank(cart.getCartGsp())) {

					List<HashMap> list = Json.fromJson(ArrayList.class, goodsBo.getGoodsInventoryDetail());
					for (Map temp : list) {
						String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
						Arrays.sort(temp_ids);

						String[] gsp_ids = CommUtil.null2String(cart.getCartGsp()).split(",");
						Arrays.sort(gsp_ids);

						if (Arrays.equals(gsp_ids, temp_ids)) {
							BigDecimal countYgb = new BigDecimal(CommUtil.null2Double(temp.get("needYgb")));
							BigDecimal countYgb1 = countYgb.multiply(CommUtil.null2BigDecimal(buyCount));
							allygPrice = CommUtil.add(allygPrice, countYgb1);

							BigDecimal countCashPrice = new BigDecimal(CommUtil.null2Double(temp
									.get("needMoney")));
							BigDecimal countCashPrice1 = countCashPrice.multiply(CommUtil
									.null2BigDecimal(buyCount));
							allCashPrice = CommUtil.add(allCashPrice, countCashPrice1);
						}

					}
				} else if (goodsBo.getExPriceFlag().intValue() == 1) {

					if (null == cart.getCartGsp() || StringUtils.isBlank(cart.getCartGsp())) {

						BigDecimal countYgb = ygb.multiply(CommUtil.null2BigDecimal(buyCount)); // 云购币整数

						allygPrice = CommUtil.add(allygPrice, countYgb);

						BigDecimal countCashPrice = money.multiply(CommUtil.null2BigDecimal(buyCount))
								.setScale(2, BigDecimal.ROUND_HALF_UP);

						allCashPrice = CommUtil.add(allCashPrice, countCashPrice);

					}

				}

			}

		}

		mapPrice.put("allygPrice", allygPrice);// 云购币
		mapPrice.put("allCashPrice", allCashPrice);// 需要的现金
		mapPrice.put("allIntegral",allIntegral);//需要的积分

		return mapPrice;

	}

	public Map getYunGouGoodsInfo(Long goodsId, String cartGsp) {
		Map map = new HashMap();
		GoodsBO goodsBo = this.goodsService.getGoodsBOById(goodsId);
		List<HashMap> list = Json.fromJson(ArrayList.class, goodsBo.getGoodsInventoryDetail());
		for (Map temp : list) {
			String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
			Arrays.sort(temp_ids);
			String[] gsp_ids = CommUtil.null2String(cartGsp).split(",");
			Arrays.sort(gsp_ids);
			if (Arrays.equals(gsp_ids, temp_ids)) {
				BigDecimal countYgb = new BigDecimal(CommUtil.null2Double(temp.get("needYgb")));
				BigDecimal countCashPrice = new BigDecimal(CommUtil.null2Double(temp.get("needMoney")));
				BigDecimal cnSelfAddPrice = new BigDecimal(CommUtil.null2Double(temp.get("cnSelfAddPrice")));
				BigDecimal needIntegral = new BigDecimal(CommUtil.null2Double(temp.get("needIntegral")));

				map.put("countYgb", countYgb);
				map.put("countCashPrice", countCashPrice);
				map.put("cnSelfAddPrice", cnSelfAddPrice);
				map.put("needIntegral", needIntegral);
			}
		}
		return map;

	}

	public List<GoodsCartBO> findAppUserCart(Long uid) {
		GoodsCartMyVO cartUserVO = new GoodsCartMyVO();
		cartUserVO.setCartStatus(GoodsConstants.GOODS_CART_STATUS_0);
		cartUserVO.setUserId(uid);
		//cartUserVO.setIsYgb(0);// 非云购币购物车
		return this.findMyCart(cartUserVO);
	}

	/**
	 * 验证是否是0元购产品
	 * 
	 * @param order_carts
	 */
	private ZeroGoods isZeroGoods(List<GoodsCartBO> order_carts) {
		Long goodsId = order_carts.get(0).getGoods().getId();
		ZeroGoods zeroGoods = this.zeroGoodsDao.getByGoodsId(goodsId);
		return zeroGoods;
	}

	public void updateZeroGoodsInventory(ZeroGoods zeroGoods) {
		if (null != zeroGoods && zeroGoods.getGoodsStatus() && zeroGoods.getGoodsInventory().intValue() > 0) {
			ZeroGoods record = new ZeroGoods();
			record.setGoodsInventory(zeroGoods.getGoodsInventory() - 1);
			record.setGoodsSalenum(zeroGoods.getGoodsSalenum() + 1);
			record.setId(zeroGoods.getId());
			this.zeroGoodsDao.update(record);
		}

	}

	public boolean checkUserIsCn(Long uid) {
		boolean bl = false;
		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		for (UserAccountBO type : userAccount) {
			if ("8".equals(type.getAccountType())) {
				bl = true;
				break;
			}
		}
		return bl;
	}

	/***
	 * H5健康商城获取运费
	 * 
	 * @param gc_list
	 *            购物车集合
	 * @param uid
	 * @return
	 */
	public double countShipFee(List<GoodsCartBO> gc_list, Long uid) {
		Address addr = this.addressDao.getDefaultByUserId(uid);
		Long areaId = 4524157L;//计算运费如果没地址默认为深圳
		if(null != addr && null != addr.getAreaId()){
			areaId = addr.getAreaId();
		}
		List<SysMap> sms = this.transportTools.query_cart_trans(gc_list,
				CommUtil.null2String(areaId));

		String transport = null;

		if (CommUtil.null2String(transport).indexOf("平邮") < 0
				&& CommUtil.null2String(transport).indexOf("快递") < 0
				&& CommUtil.null2String(transport).indexOf("EMS") < 0) {
			transport = "快递";
		}
		double ship_price = 0.00;
		for (SysMap sm : sms) {
			if (CommUtil.null2String(sm.getKey()).indexOf(transport) >= 0) {
				ship_price = CommUtil.null2Double(sm.getValue());// 订单物流运费//TODO
				System.out.println(ship_price);
			}
		}
		return ship_price;
	}
	
	/***
	 * 
	 * 临时处理抢购商品
	 * @param order_carts
	 * @throws ServiceException 
	 */
	public void cheakActivity(List<GoodsCartBO> order_carts) {
		try {
			System.out.println("10121 进入");
			Long goodsId = order_carts.get(0).getGoods().getId();
			Long activityGoodsId = CommUtil.null2Long(10121);
			if (goodsId.equals(activityGoodsId)) {
				GoodsBO goodsBO = this.goodsService.getObjById(activityGoodsId);
				if (goodsBO != null && goodsBO.getGoodsInventory() > 0) {
					System.out.println("10121 进入"+goodsId);
					GoodsBO record = new GoodsBO();
					record.setGoodsInventory(goodsBO.getGoodsInventory().intValue() - 1);
					record.setGoodsSalenum(goodsBO.getGoodsSalenum() + 1);
					record.setId(activityGoodsId);
					System.out.println(record.getGoodsInventory() +"----"+record.getGoodsSalenum());
					this.goodsService.update(record);
				} 
			}
		} catch (Exception e) {
			log.error("error",e);
		}
	}
}
