package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.domain.virtual.SysMap;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.common.service.ServiceNORollbackException;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.CartTools;
import com.sinco.carnation.resource.bo.shop.ShopAddresBO;
import com.sinco.carnation.resource.bo.shop.ShopCouponInfoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsCartBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderListBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderListDetailBO;
import com.sinco.carnation.resource.bo.shop.ShopStoreBO;
import com.sinco.carnation.resource.bo.shop.ShopTransPortBO;
import com.sinco.carnation.resource.bo.shop.ShopUserAddressBO;
import com.sinco.carnation.resource.bo.shop.TransBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.shop.ShopAddCartVO;
import com.sinco.carnation.resource.vo.shop.ShopAddressVO;
import com.sinco.carnation.resource.vo.shop.ShopBuyGoodsVO;
import com.sinco.carnation.resource.vo.shop.ShopGoodsDetailsVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.ShopAddressResponse;
import com.sinco.carnation.resource.web.response.shop.ShopCartResponse;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "购物车", namespace = "shop")
public class ShopCartAction extends BasicApiController {

	private final Logger logger = LoggerFactory.getLogger(ShopCartAction.class);

	@Autowired
	private GoodsCartService goodsCartService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private TransportTools tools;

	@Autowired
	private StoreService storeService;

	@Autowired
	private CartTools cartTools;
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserCustomerService userCustomerService;

	@RequestMapping(value = "/shop/cart/add", method = RequestMethod.POST)
	@MethodMapping(desc = "添加购物车")
	public @ResponseBody
	ShopCartResponse addShopCart(@Valid @ModelAttribute @Param ShopAddCartVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopCartResponse response = new ShopCartResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid != null) {
			int num = goodsCartService.addGoods(vo.getGoodId(), CommUtil.null2String(vo.getCount()),
					vo.getGsp(), null, null, null, uid, null);
			switch (num) {
			// 成功
				case 0:
					List<GoodsCartBO> goodsCartList = goodsCartService.findUserCart(uid);
					response.setShopCartSize(goodsCartList.size());
					return response;
					// 库存不足
				case -3:
					response.putErrorMessage("4.shop.addShopCart.inventory_problem");
					return response;
					// 商品下架
				case -2:
					response.putErrorMessage("4.shop.addShopCart.commodity_shelf");
					return response;
					// 添加失败
				case -1:
					response.putErrorMessage("4.shop.addShopCart.add_fail");
					return response;
					// 成功
				default:
					response.putErrorMessage("4.shop.addShopCart.add_fail");
					return response;
			}
		}
		return response;
	}

	@RequestMapping(value = "/shop/find_user_cart/query", method = RequestMethod.POST)
	@MethodMapping(desc = "查看购物车列表")
	public @ResponseBody
	ShopCartResponse findUserCart() {
		ShopCartResponse response = new ShopCartResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("5.shop.findUserCart.not_login");
			return response;
		}
		List<GoodsCartBO> goodsCartList = goodsCartService.findAppUserCart(uid);
		List<ShopGoodsCartBO> cartList = MapperUtils.map(mapper, goodsCartList, ShopGoodsCartBO.class);
		// 商品小计
		getTotalPrice(cartList);
//		response.setCartList(cartList);
		// 平台购物车
		List<GoodsCartBO> cartList_ = new ArrayList<GoodsCartBO>();
		// cn购物车
		List<GoodsCartBO> cnCartList = new ArrayList<GoodsCartBO>();
		// 云购币购物车
		List<GoodsCartBO> ygbCartList = new ArrayList<GoodsCartBO>();

		Map<Long, BigDecimal[]> cnPriceMap = new HashMap<Long, BigDecimal[]>();
		for (GoodsCartBO goodsCart : goodsCartList) {
			Integer exPriceFlag = goodsCart.getExPriceFlag();
			Integer isYgb = goodsCart.getIsYgb();
			if (GoodsCartBO.EXPEICEFLAG_YES == exPriceFlag) {
				Goods goods = goodsCart.getGoods();
				goodsService.cartGoodsMulSpecHandler(goodsCart, goods);
				cnCartList.add(goodsCart);

				BigDecimal[] cnPrice = new BigDecimal[] {goods.getNeedYgb(), goods.getNeedMoney(),
						goods.getCnSelfAddPrice(), goods.getNeedIntegral()};
				cnPriceMap.put(goodsCart.getId(), cnPrice);
			} else if (null != isYgb && isYgb.intValue() == 1) {
				Goods goods = goodsCart.getGoods();
				// goodsService.cartGoodsMulSpecHandler(goodsCart, goods);
				ygbCartList.add(goodsCart);
				BigDecimal[] cnPrice = new BigDecimal[] {goods.getNeedYgb(), goods.getNeedMoney(),
						goods.getSelfAddPrice(), goods.getNeedIntegral()};
				cnPriceMap.put(goodsCart.getId(), cnPrice);
			} else {
				cartList_.add(goodsCart);
			}
		}

		int cartSize = cartList_.size();
		int cnCartSize = cnCartList.size();
		int ygbCarSize = ygbCartList.size();
		response.setCartListSize(cartSize);
		response.setCnCartListSize(cnCartSize);
		response.setYgbCartListSize(ygbCarSize);
		if (cartSize > 0) {
			response.setCartList(MapperUtils.map(mapper, cartList_, ShopGoodsCartBO.class));
		}
		if (cnCartSize > 0) {
			response.setCnCartList(MapperUtils.map(mapper, cnCartList, ShopGoodsCartBO.class));
			for (ShopGoodsCartBO shopGoodsCartBO : response.getCnCartList()) {
				ShopGoodsBo shopGoods = shopGoodsCartBO.getGoods();
				BigDecimal[] cnPrice = cnPriceMap.get(shopGoodsCartBO.getId());

				if (cnPrice != null && cnPrice.length == 4) {
					int proType = goodsService
							.proType(shopGoods.getNeedIntegral(), shopGoods.getNeedYgb(), 1);
					shopGoods.setProType(proType);
					shopGoods.setNeedIntegral(cnPrice[3]);
					shopGoods.setBv(cnPrice[2]);
					shopGoods.setCash(cnPrice[1]);
					shopGoods.setYunGouBi(cnPrice[0]);
				}
			}
		}
		if (ygbCarSize > 0) {
			response.setYgbCartList(MapperUtils.map(mapper, ygbCartList, ShopGoodsCartBO.class));
			for (ShopGoodsCartBO shopGoodsCartBO : response.getYgbCartList()) {
				ShopGoodsBo shopGoods = shopGoodsCartBO.getGoods();
				BigDecimal[] cnPrice = cnPriceMap.get(shopGoodsCartBO.getId());

				if (cnPrice != null && cnPrice.length == 4) {
					int proType = goodsService
							.proType(shopGoods.getNeedIntegral(), shopGoods.getNeedYgb(), 1);
					shopGoods.setNeedIntegral(cnPrice[3]);
					shopGoods.setBv(cnPrice[2]);
					shopGoods.setCash(cnPrice[1]);
					shopGoods.setYunGouBi(cnPrice[0]);
					shopGoods.setProType(proType);
				}
			}
		}
		return response;
	}

	@RequestMapping(value = "/shop/cart/remove", method = RequestMethod.POST)
	@MethodMapping(desc = "从购物车移除商品")
	public @ResponseBody
	ShopCartResponse cartRemove(
			@Valid @RequestParam(value = "goodsId") @Param(desc = "商品id|多个id以逗号隔开如：1,2,3,4,5,6,7") String goodsId) {
		ShopCartResponse response = new ShopCartResponse();
		if (StringUtils.isBlank(goodsId)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 商品id
		List<String> list_ids = new ArrayList<String>();
		String cart_ids[] = goodsId.split(",");
		for (String id : cart_ids) {
			if (StringUtils.isNotBlank(id)) {
				list_ids.add(id);
			}
		}
		// 移除商品
		goodsCartService.removeGoods(cart_ids);
		// 用户id
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("5.shop.findUserCart.not_login");
			return response;
		}
		// 我购物车列表
		List<GoodsCartBO> goodsCartList = goodsCartService.findUserCart(uid);
		List<ShopGoodsCartBO> cartList = MapperUtils.map(mapper, goodsCartList, ShopGoodsCartBO.class);
		// 商品小计
		getTotalPrice(cartList);
		response.setCartList(cartList);

		return response;
	}

	@RequestMapping(value = "/shop/goods_count/adjust", method = RequestMethod.POST)
	@MethodMapping(desc = "商品数量调整")
	public @ResponseBody
	ShopCartResponse goodsCountAdjust(@Valid @RequestParam(value = "gcId") @Param(desc = "购物车id") Long gcId,
			@Valid @RequestParam(value = "count") @Param(desc = "商品数量") Integer count) {
		ShopCartResponse response = new ShopCartResponse();
		if (gcId == null || count < 1) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		try {
			// 修改商品数量
			String code = goodsCartService.appAdjustGoodsCount(CommUtil.null2String(gcId),
					CommUtil.null2String(count), null, null);
			if (code.equals("200")) {
				// 修改失败，库存不足
				response.putErrorMessage("5.shop.goodsCountAdjust.adjust_fail");
				return response;
			}

			// 用户id
			Long uid = ActionsUtil.getOwnerUid();
			if (uid == null) {
				response.putErrorMessage("5.shop.findUserCart.not_login");
				return response;
			}
			// 我购物车列表
			List<GoodsCartBO> goodsCartList = goodsCartService.findUserCart(uid);
			List<ShopGoodsCartBO> cartList = MapperUtils.map(mapper, goodsCartList, ShopGoodsCartBO.class);
			// 商品小计
			getTotalPrice(cartList);
			response.setCartList(cartList);

		} catch (ServiceNORollbackException e) {
			response.putErrorMessage("5.shop.goodsCountAdjust.adjust_GoodsCount");
		}
		return response;
	}

	@RequestMapping(value = "/shop/goods_total/price", method = RequestMethod.POST)
	@MethodMapping(desc = "购物车选中商品的总价")
	public @ResponseBody
	ShopCartResponse selectGoodsTotalPrice(
			@Valid @RequestParam(value = "gcids") @Param(desc = "选中商品id，已逗号隔开|如1,2,3,4,5,6,7") String gcids) {
		ShopCartResponse response = new ShopCartResponse();
		if (StringUtils.isBlank(gcids)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 获取uid
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("5.shop.selectGoodsTotalPrice.not_uid");
			return response;
		}
		String[] gcIds = gcids.split(",");
		double totalPrice = goodsCartService.calCartPrice(uid, gcIds, true);
		BigDecimal price = new BigDecimal(totalPrice);
		response.setTotalPrice(price);
		return response;
	}

	@RequestMapping(value = "/shop/addres/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商品收获地址,省，市区")
	public @ResponseBody
	ShopAddressResponse addressList(@Valid @RequestParam(value = "id") @Param(desc = "父级id|第一级为0") Long id) {
		ShopAddressResponse response = new ShopAddressResponse();
		// 如果为null 根节点
		if (id == 0) {
			List<Area> list = dicContent.getRootDics(Area.class);
			List<ShopAddresBO> addressList = MapperUtils.map(mapper, list, ShopAddresBO.class);
			response.setAddressList(addressList);
			return response;
		}
		// 根据父级id取子集对象
		List<DicBase> list = dicContent.getDicsByParentCode(Area.class, CommUtil.null2String(id));
		List<ShopAddresBO> addressList = MapperUtils.map(mapper, list, ShopAddresBO.class);
		response.setAddressList(addressList);
		return response;
	}

	@RequestMapping(value = "/shop/cart_address/save", method = RequestMethod.POST)
	@MethodMapping(desc = "保存地址")
	public @ResponseBody
	ShopCartResponse cartAddressSave(@Valid @ModelAttribute @Param ShopAddressVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopCartResponse response = new ShopCartResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 用户id
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		Address address = new Address();
		AddressBO addressBO = addressService.getObjById(vo.getId());
		if (addressBO != null) {
			address.setId(addressBO.getId());
		}

		address.setUserId(uid);
		address.setAddTime(new Date());
		address.setAreaId(vo.getAreaId());
		address.setAreaInfo(vo.getAreaInfo());
		address.setMobile(vo.getMobile());
		address.setTelephone(vo.getTelephone());
		address.setTrueName(vo.getTrueName());
		address.setZip(vo.getZip());
		try {
			addressService.save(address);
		} catch (ServiceException e) {
			logger.error("用户保存地区错误", e);
			response.putErrorMessage("5.shop.setDefaultAddress.set_default_address_fails");
			return response;
		}
		// 如果为默认地址
		if (vo.getDefaultValue()) {
			boolean ret = addressService.updateDefault(address.getId(), uid);
			if (!ret) {
				response.putErrorMessage("5.shop.setDefaultAddress.set_default_address_fails");
				return response;
			}
		}

		return response;
	}

	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@RequestMapping(value = "/shop/cart_goods/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "订单详情")
	public @ResponseBody
	ShopCartResponse shopCartDetial(@Valid @ModelAttribute @Param ShopGoodsDetailsVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopCartResponse response = new ShopCartResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		String[] gcIds = null;
		if (StringUtils.isNotBlank(vo.getGcs())) {
			gcIds = vo.getGcs().split(",");
		}

		// 用户id
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		// 订单详细列表
		ShopOrderListDetailBO orderListDetailBOs = new ShopOrderListDetailBO();
		AddressBO addres = null;
		Double countShipFee = 0.00;
		// 我购物车列表
		List<GoodsCartBO> goodsCartList = goodsCartService.findUserCart(uid);
		// 判断账号是否为CN账号
		boolean isCN = userAccountService.check_User_Is_CN(uid);
		Map<Long, BigDecimal> bvMap = new HashMap<Long, BigDecimal>();
		Map<Long, BigDecimal> cashMap = new HashMap<Long, BigDecimal>();
		Map<Long, BigDecimal> yuGouBiMap = new HashMap<Long, BigDecimal>();
		Map<Long, BigDecimal> needIntegralMap = new HashMap<Long, BigDecimal>();
		BigDecimal countBV = BigDecimal.ZERO; // 订单BV
		BigDecimal countNeedIntegral = BigDecimal.ZERO;// 订单需要的积分
		BigDecimal countNeedMoney = BigDecimal.ZERO;// 订单需要的现金
		BigDecimal countNeedYgb = BigDecimal.ZERO;// 订单需要的重消
		Integer isYgb = 0;// 是否为精选专区(云购币)专区订单 0.不是 1.是
		Double userIntegral = 0.00;// 用户积分值
		Map<String, Object> CNwallet = statisticsService.getCNUserIntegralAndMoney(uid);// CN账号重消购物积分
		Double cnRepeat = (Double) CNwallet.get("cnRepeat");
		Double shopingIntegral = (Double) CNwallet.get("shopingIntegral");
		Integer proType =0;
		boolean payTypeYgb = true;
		boolean payTypeIntegral = true;
		boolean payTypeTwo = true;
		if (goodsCartList != null && goodsCartList.size() > 0) {// 订单收货地址
			List<AddressBO> addrs = this.addressService.findShopByUid(uid);
			for (AddressBO addressBO : addrs) {
				if (addressBO.getDefaultVal() != null && addressBO.getDefaultVal()) {
					addres = addressBO;
					// 用户默认地址
					ShopUserAddressBO userAddressBO = mapper.map(addressBO, ShopUserAddressBO.class);
					orderListDetailBOs.setShopUserAddress(userAddressBO);
					// response.setDefaultAddress(userAddressBO);
				}
			}
		}

		// 商品类型 0为自营商品，1为第三方经销商
		Set<Object> store_list = new HashSet<Object>();
		for (GoodsCartBO gc : goodsCartList) {
			if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
				store_list.add(gc.getGoods().getGoodsStoreId());
			} else {
				store_list.add("self");
			}
		}
		// boolean goods_cod = true;// 默认支持货到付款，这样有一款产品不支持货到付款，这个订单就不支持货到付款
		// int tax_invoice = 1;// 默认可以开具增值税发票，只要存在一款产品不支持增值税发票，整体订单不可以开具增值税发票
		// 订单列表
		List<ShopOrderListBO> shopOrderList = new ArrayList<ShopOrderListBO>();
		for (Object sl : store_list) {
			if (sl != "self" && !sl.equals("self")) {// 商家商品
				List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();// 商家商品
				for (GoodsCartBO gc : goodsCartList) {
					for (String gc_id : gcIds) {
						if (StringUtils.isNotBlank(gc_id) && CommUtil.null2Long(gc_id).equals(gc.getId())) {
							if (gc.getGoods().getGoodsStoreId() != null
									&& gc.getGoods().getGoodsStoreId().equals(sl)) {
								gc_list.add(gc);
							}
						}
					}
				}
				// gc_list不为空
				if (gc_list != null && gc_list.size() > 0) {
					ShopOrderListBO shopOrder = new ShopOrderListBO();
					countShipFee = goodsCartService.countShipFee(gc_list, uid);// 计算运费
					for (GoodsCartBO gc : gc_list) {
						if (gc.getGoods().getGoodsCod() == -1 || gc.getGoods().getGoodsChoiceType() == 1) {// 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
							shopOrder.setGoodsCod(false);
						}
						if (gc.getGoods().getTaxInvoice() == 0) {// 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
							shopOrder.setTaxInvoice(0);
						}
						goodsService.handleGoods(gc.getGoods(), bvMap, needIntegralMap, cashMap, yuGouBiMap,
								gc.getCartGsp());
					}

					// 店铺对象
					StoreBO storeBO = storeService.getObjById(CommUtil.null2Long(sl));
					ShopStoreBO stroBO = mapper.map(storeBO, ShopStoreBO.class);
					shopOrder.setShopStore(stroBO);
					// 商品对象列表
					List<ShopGoodsCartBO> cartBOList = MapperUtils
							.map(mapper, gc_list, ShopGoodsCartBO.class);
					// 选中的商品支付类型不同 (只支持重消 只支持购物积分)
					for (ShopGoodsCartBO cart : cartBOList) {
						if (null != cart.getGoods().getNeedIntegral() && null != cart.getGoods().getNeedYgb()
								&& null != cart.getIsYgb()) {
							proType = goodsService.proType(cart.getGoods().getNeedIntegral(), cart
									.getGoods().getNeedYgb(), cart.getIsYgb());
							cart.getGoods().setProType(proType);
							if (proType == 1) {
								payTypeIntegral = false;
								payTypeTwo = false;
							}
							if (proType == 2) {
								payTypeYgb = false;
								payTypeTwo = false;
							}
							if(isCN){
								if (proType == 3) {
									payTypeYgb = false;
									payTypeIntegral = false;
								}
							}
						}
						cart.setGoods(cart.getGoods());
					}
					if (!payTypeYgb && !payTypeIntegral && !payTypeTwo) {
						response.setErrorCode("4");
						response.putErrorMessage("4.shop_goods.createOrder.failure.otherPayType");
						return response;
					}
					shopOrder.setGoodsCartList(cartBOList);

					// 每个订单商品总价
					double orderTotalPrice = goodsCartService.calCartPrice(gc_list, gcIds);

					// 运送方式
					if (addres != null && addres.getAreaId() != null) {
						List<SysMap> query_cart_trans = tools.query_cart_trans(gc_list,
								CommUtil.null2String(addres.getAreaId()));
						List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
								ShopTransPortBO.class);
						shopOrder.setTransList(transPortBOs);
					}

					GoodsCartBO cart = this.goodsCartService.getObjById(CommUtil.null2Long(gcIds[0]));
					GoodsBO bo = this.goodsService.getGoodsBOById(cart.getGoodsId());
					if (bo != null && bo.getIsYgb().intValue() == 1) {// 标识云购币专区运费
						BigDecimal maxPrice = new BigDecimal(2000);
						if (isCN) {
							countShipFee = orderFormService
									.getYgOrderShopFee(new BigDecimal(orderTotalPrice)).doubleValue();
						} else {
							countShipFee = orderFormService.membersShipFee(new BigDecimal(orderTotalPrice))
									.doubleValue();
						}

//						if (CommUtil.null2BigDecimal(orderTotalPrice).compareTo(maxPrice) == -1) {
//							ShopTransPortBO transPortBOs = new ShopTransPortBO();
//							transPortBOs.setKey("运费:" + countShipFee);
//							transPortBOs.setValue(CommUtil.null2Double(countShipFee));
//							List list = new ArrayList();
//							list.add(transPortBOs);
//							shopOrder.setTransList(list);
//						} else {
						ShopTransPortBO transPortBOs = new ShopTransPortBO();
						transPortBOs.setKey("运费:" + countShipFee);
						transPortBOs.setValue(CommUtil.null2Double(countShipFee));
						List list = new ArrayList();
						list.add(transPortBOs);
						shopOrder.setTransList(list);
//						}
					}

					// 优惠券
					List<CouponInfoBO> couponList = cartTools.query_coupon(CommUtil.null2String(sl),
							CommUtil.null2String(orderTotalPrice), uid);
					List<ShopCouponInfoBO> couponInfoBOs = MapperUtils.map(mapper, couponList,
							ShopCouponInfoBO.class);
					shopOrder.setCouponInfoList(couponInfoBOs);

					shopOrderList.add(shopOrder);
				}

			} else {// 自营商品
				List<GoodsCartBO> self_list = new ArrayList<GoodsCartBO>();// 自营商品
				for (GoodsCartBO gc : goodsCartList) {
					for (String gc_id : gcIds) {
						if (StringUtils.isNotBlank(gc_id) && CommUtil.null2Long(gc_id).equals(gc.getId())) {
							if (gc.getGoods().getGoodsStoreId() == null) {
								self_list.add(gc);
							}
						}
					}
				}
				// self_list不为空
				if (self_list != null && self_list.size() > 0) {
					ShopOrderListBO shopOrder = new ShopOrderListBO();

					for (GoodsCartBO gc : self_list) {
						if (gc.getGoods().getGoodsCod() == -1 || gc.getGoods().getGoodsChoiceType() == 1) {// 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
							shopOrder.setGoodsCod(false);
						}
						if (gc.getGoods().getTaxInvoice() == 0) {// 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
							shopOrder.setTaxInvoice(0);
						}
						goodsService.handleGoods(gc.getGoods(), bvMap, needIntegralMap, cashMap, yuGouBiMap,
								gc.getCartGsp());
					}

					// 转换后的自营商品列表
					List<ShopGoodsCartBO> shopGoodsList = MapperUtils.map(mapper, self_list,
							ShopGoodsCartBO.class);
					for (ShopGoodsCartBO cart : shopGoodsList) {
						if (null != cart.getGoods().getNeedIntegral() && null != cart.getGoods().getNeedYgb()
								&& null != cart.getIsYgb()) {
							proType = goodsService.proType(cart.getGoods().getNeedIntegral(), cart
									.getGoods().getNeedYgb(), cart.getIsYgb());
							cart.getGoods().setProType(proType);
							if (proType == 1) {
								payTypeYgb = false;
							}
							if (proType == 2) {
								payTypeIntegral = false;
							}
							if(isCN){
								if (proType == 3) {
									payTypeYgb = false;
									payTypeIntegral = false;
								}
							}
						}
						cart.setGoods(cart.getGoods());
					}
					if (!payTypeYgb && !payTypeIntegral  && !payTypeTwo) {
						response.putErrorMessage("4.shop_goods.createOrder.failure.otherPayType");
						return response;
					}
					shopOrder.setGoodsCartList(shopGoodsList);

					// 自营商品总价
					double orderTotalPrice = goodsCartService.calCartPrice(self_list, gcIds);

					// 运送方式
					if (addres != null && addres.getAreaId() != null) {
						List<SysMap> query_cart_trans = tools.query_cart_trans(self_list,
								CommUtil.null2String(addres.getAreaId()));
						List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
								ShopTransPortBO.class);
						shopOrder.setTransList(transPortBOs);
					}

					// 优惠券
					List<CouponInfoBO> couponList = cartTools.query_coupon(CommUtil.null2String(sl),
							CommUtil.null2String(orderTotalPrice), uid);
					List<ShopCouponInfoBO> couponInfoBOs = MapperUtils.map(mapper, couponList,
							ShopCouponInfoBO.class);
					shopOrder.setCouponInfoList(couponInfoBOs);

					shopOrderList.add(shopOrder);
				}

			}
		}

		orderListDetailBOs.setOrderList(shopOrderList);
		response.setOrderList(orderListDetailBOs);
		ShopOrderListDetailBO shopOrderListDetail = response.getOrderList();
		List<ShopOrderListBO> shopOrderBOList = shopOrderListDetail.getOrderList();

		for (ShopOrderListBO shopOrderBO : shopOrderBOList) {
			List<ShopGoodsCartBO> listTemp = shopOrderBO.getGoodsCartList();

			for (ShopGoodsCartBO shopGoodsCar : listTemp) {
				Integer count = shopGoodsCar.getCount();
				ShopGoodsBo shopGood = shopGoodsCar.getGoods();
				Long goodsID = shopGood.getId();
				BigDecimal bv = BigDecimal.ZERO;
				BigDecimal cash = BigDecimal.ZERO;
				BigDecimal yuGouBi = BigDecimal.ZERO;
				BigDecimal needIntegral = BigDecimal.ZERO;
				if (bvMap.containsKey(goodsID)) {
					bv = bvMap.get(goodsID);
				}
				if (cashMap.containsKey(goodsID)) {
					cash = cashMap.get(goodsID);
				}
				if (yuGouBiMap.containsKey(goodsID)) {
					yuGouBi = yuGouBiMap.get(goodsID);
				}
				if (needIntegralMap.containsKey(goodsID)) {
					needIntegral = needIntegralMap.get(goodsID);
				}
				shopGood.setBv(bv);
				shopGood.setCash(cash);
				shopGood.setYunGouBi(yuGouBi);
				shopGood.setNeedIntegral(needIntegral);
				if (count != null && count > 0) {
					countBV = countBV.add(shopGood.getBv().multiply(new BigDecimal(count)));
					if (null != shopGood.getNeedIntegral() && null != shopGood.getNeedMoney()
							&& null != shopGood.getNeedYgb()) {
						countNeedIntegral = countNeedIntegral.add(shopGood.getNeedIntegral().multiply(
								new BigDecimal(count)));
						countNeedMoney = countNeedMoney.add(shopGood.getNeedMoney().multiply(
								new BigDecimal(count)));
						countNeedYgb = countNeedYgb
								.add(shopGood.getNeedYgb().multiply(new BigDecimal(count)));
					}
				} else {
					countBV = countBV.add(shopGood.getBv());
					if (null != shopGood.getNeedIntegral() && null != shopGood.getNeedMoney()
							&& null != shopGood.getNeedYgb()) {
						countNeedIntegral = countNeedIntegral.add(shopGood.getNeedIntegral());
						countNeedMoney = countNeedMoney.add(shopGood.getNeedMoney());
						countNeedYgb = countNeedYgb.add(shopGood.getNeedYgb());
					}
				}
				// 是否为云购币专区订单
				isYgb = shopGoodsCar.getIsYgb();
			}

			if(!isCN){
				if(proType.intValue() == 2 || proType.intValue() == 3 ){
					proType = 4;
				}
			}
			shopOrderBO.setProType(proType);
			shopOrderBO.setBvCount(countBV);
			shopOrderBO.setNeedIntegral(countNeedIntegral);
			shopOrderBO.setNeedMoney(countNeedMoney);
			shopOrderBO.setNeedYgb(countNeedYgb);
			shopOrderBO.setIsYgb("1".equals(String.valueOf(isYgb)));
			shopOrderBO.setShopingIntegral(BigDecimal.valueOf(shopingIntegral));
			shopOrderBO.setCnRepeat(BigDecimal.valueOf(cnRepeat));
		}

		if (isCN) {
//			userIntegral = shopingIntegral; //CN账号不需判断
		} else {
			UserCustomerBO userBO = userCustomerService.findSessionUser(uid);
			if (null != userBO && null != userBO.getIntegral()) {
				userIntegral = userBO.getIntegral().doubleValue();
			}
			if (isYgb == 1 && countNeedIntegral.doubleValue() > userIntegral.doubleValue()) {// 普通会员 并且选择的是精选专区商品 判断积分是否足够
				response.putErrorMessage("5.integral.saveOrder.integral.inadequate");
				return response;
			}
		}
		response.setFreeShipAmount(2000);
		response.setAllGoodsFree(new BigDecimal(countShipFee));
		return response;
	}

	/**
	 * 设置购物车商品小计价格
	 * 
	 * @param cartList
	 */
	public void getTotalPrice(List<ShopGoodsCartBO> cartList) {
		for (ShopGoodsCartBO shopGoodsCartBO : cartList) {
			BigDecimal bigCount = new BigDecimal(shopGoodsCartBO.getCount());
			BigDecimal bigPrice = shopGoodsCartBO.getPrice();
			shopGoodsCartBO.setSubtotalPrice(bigPrice.multiply(bigCount));
		}
	}

	@RequestMapping(value = "/shop/user_address/all", method = RequestMethod.POST)
	@MethodMapping(desc = "用户收获地址")
	public @ResponseBody
	ShopCartResponse userAddressList(
			@Valid @RequestParam(value = "def") @Param(desc = "def为true获取默认收货地址|false获取全部收货地址") boolean def) {
		ShopCartResponse response = new ShopCartResponse();
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		// 默认收货地址
		if (def) {
			List<AddressBO> addrs = this.addressService.findShopByUid(uid);
			for (AddressBO addressBO : addrs) {
				if (addressBO.getDefaultVal()) {
					ShopUserAddressBO defaultAddress = mapper.map(addressBO, ShopUserAddressBO.class);
					response.setDefaultAddress(defaultAddress);
				}
			}
		} else {
			// 全部地址
			List<AddressBO> addrs = this.addressService.findShopByUid(uid);
			List<ShopUserAddressBO> addressList = MapperUtils.map(mapper, addrs, ShopUserAddressBO.class);
			response.setUserAddressAll(addressList);
		}

		return response;
	}

	@RequestMapping(value = "/shop/default/address", method = RequestMethod.POST)
	@MethodMapping(desc = "设为默认地址")
	public @ResponseBody
	ShopCartResponse setDefaultAddress(@Valid @RequestParam(value = "id") @Param(desc = "id") Long id) {
		ShopCartResponse response = new ShopCartResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		boolean ret = addressService.updateDefault(CommUtil.null2Long(id), uid);
		if (!ret) {
			response.putErrorMessage("5.shop.setDefaultAddress.set_default_address_fails");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/shop/delete/address", method = RequestMethod.POST)
	@MethodMapping(desc = "删除用户收获地址")
	public @ResponseBody
	ShopCartResponse deleteUserAddressById(
			@Valid @RequestParam(value = "ids") @Param(desc = "地址ids|多个有逗号隔开如1，2，3，4，5，6，7") String ids) {
		ShopCartResponse response = new ShopCartResponse();
		if (StringUtils.isBlank(ids)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		addressService.deleteAddress(ids);
		return response;
	}

	@RequestMapping(value = "/shop/transport/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取运送方式")
	public @ResponseBody
	ShopCartResponse sys(@Valid @RequestParam(value = "cartIds") @Param(desc = "购物车id") String cartIds,
			@Valid @RequestParam(value = "areaId") @Param(desc = "地区id") Long areaId) {
		ShopCartResponse response = new ShopCartResponse();
		if (StringUtils.isBlank(cartIds)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 所有选中的购物车商品
		List<GoodsCartBO> allCart = new ArrayList<GoodsCartBO>();
		String[] ids = cartIds.split(",");
		for (String id : ids) {
			GoodsCartBO cart = goodsCartService.findMyByIdCart(CommUtil.null2Long(id));
			allCart.add(cart);
			// map.put(cart.getGoods().getGoodsStoreId(), allCart);
		}
		// 商品类型 0为自营商品，1为第三方经销商
		Set<Object> store_list = new HashSet<Object>();
		for (GoodsCartBO gc : allCart) {
			if (gc.getGoods().getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
				store_list.add(gc.getGoods().getGoodsStoreId());
			} else {
				store_list.add("self");
			}
		}
		List<TransBO> traList = new ArrayList<TransBO>();
		for (Object sl : store_list) {
			TransBO trans = new TransBO();
			trans.setStoreId(CommUtil.null2Long(sl));
			if (sl != "self" && !sl.equals("self")) {// 商家商品
				List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();// 商家商品
				for (GoodsCartBO gc : allCart) {
					for (String gc_id : ids) {
						if (StringUtils.isNotBlank(gc_id) && CommUtil.null2Long(gc_id).equals(gc.getId())) {
							if (gc.getGoods().getGoodsStoreId() != null
									&& gc.getGoods().getGoodsStoreId().equals(sl)) {
								gc_list.add(gc);
							}
						}
					}
				}

				if (gc_list != null && gc_list.size() > 0) {
					// 配送地址
					AddressBO addres = addressService.getObjById(areaId);
					// 运送方式
					if (addres != null && addres.getAreaId() != null) {
						List<SysMap> query_cart_trans = tools.query_cart_trans(gc_list,
								CommUtil.null2String(addres.getAreaId()));
						List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
								ShopTransPortBO.class);
						trans.setTrans(transPortBOs);
						// shopOrder.setTransList(transPortBOs);
					}
				}
			} else {
				List<GoodsCartBO> self_list = new ArrayList<GoodsCartBO>();// 自营商品
				for (GoodsCartBO gc : allCart) {
					for (String gc_id : ids) {
						if (StringUtils.isNotBlank(gc_id) && CommUtil.null2Long(gc_id).equals(gc.getId())) {
							if (gc.getGoods().getGoodsStoreId() == null) {
								self_list.add(gc);
							}
						}
					}
				}
				if (self_list != null && self_list.size() > 0) {
					// 配送地址
					AddressBO addres = addressService.getObjById(areaId);
					// 运送方式
					if (addres != null && addres.getAreaId() != null) {
						List<SysMap> query_cart_trans = tools.query_cart_trans(self_list,
								CommUtil.null2String(addres.getAreaId()));
						List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
								ShopTransPortBO.class);
						trans.setTrans(transPortBOs);
						// shopOrder.setTransList(transPortBOs);
					}
				}
			}
			traList.add(trans);
		}
		response.setTrans(traList);
		return response;
	}

	@RequestMapping(value = "/shop/cart/size", method = RequestMethod.POST)
	@MethodMapping(desc = "购物车商品数量")
	public @ResponseBody
	ShopCartResponse shopCartSize() {
		ShopCartResponse response = new ShopCartResponse();
		Long uid = ActionsUtil.getOwnerUid();
		List<GoodsCartBO> goodsCartList = goodsCartService.findUserCart(uid);
		response.setShopCartSize(goodsCartList.size());
		return response;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/shop/buy/goods", method = RequestMethod.POST)
	@MethodMapping(desc = "立即购买")
	public @ResponseBody
	ShopCartResponse shopBuyGoods(@Valid @ModelAttribute @Param ShopBuyGoodsVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopCartResponse response = new ShopCartResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 用户id
		Long uid = ActionsUtil.getOwnerUid();
		User user = userService.queryUserById(uid);
		try {
			String[] gcIds = null;
			GoodsCartBO goodCart = goodsCartService.buyGoods(vo.getGoodsId(),
					CommUtil.null2String(vo.getCount()), vo.getGsp(), null, user);
			if (goodCart != null) {
				gcIds = new String[1];
				gcIds[0] = CommUtil.null2String(goodCart.getId());
			}

			// 订单详细列表
			ShopOrderListDetailBO orderListDetailBOs = new ShopOrderListDetailBO();
			AddressBO addres = null;
			// 我购物车列表
			/*List<GoodsCartBO> goodsCartList = goodsCartService.findUserBuyCart(user.getId(),null,false);
			*/

			// 判断账号是否为CN账号
			boolean isCN = userAccountService.check_User_Is_CN(uid);
			Map<Long, BigDecimal> bvMap = new HashMap<Long, BigDecimal>();
			Map<Long, BigDecimal> cashMap = new HashMap<Long, BigDecimal>();
			Map<Long, BigDecimal> yunGouBiMap = new HashMap<Long, BigDecimal>();
			Map<Long, BigDecimal> needIntegralMap = new HashMap<Long, BigDecimal>();
			BigDecimal countBV = BigDecimal.ZERO; // 订单BV
			BigDecimal countNeedIntegral = BigDecimal.ZERO;// 订单需要的积分
			BigDecimal countNeedMoney = BigDecimal.ZERO;// 订单需要的现金
			BigDecimal countNeedYgb = BigDecimal.ZERO;// 订单需要的重消
			Integer isYgb = 0;// 是否为精选专区(云购币)专区订单 0.不是 1.是
			Double userIntegral = 0.00;// 用户积分值
			Map<String, Object> CNwallet = statisticsService.getCNUserIntegralAndMoney(uid);// CN账号重消购物积分
			Double cnRepeat = (Double) CNwallet.get("cnRepeat");
			Double shopingIntegral = (Double) CNwallet.get("shopingIntegral");
			Integer proType =0;
			
			if (goodCart != null) {
				List<AddressBO> addrs = this.addressService.findShopByUid(uid);
				for (AddressBO addressBO : addrs) {
					if (addressBO.getDefaultVal() != null && addressBO.getDefaultVal()) {
						addres = addressBO;
						// 用户默认地址
						ShopUserAddressBO userAddressBO = mapper.map(addressBO, ShopUserAddressBO.class);
						orderListDetailBOs.setShopUserAddress(userAddressBO);
						// response.setDefaultAddress(userAddressBO);
					}
				}
			}

			// 商品类型 0为自营商品，1为第三方经销商
			Set<Object> store_list = new HashSet<Object>();
			GoodsBO goods = goodsService.getObjById(goodCart.getGoodsId());
			/*
			 * 处理商品多个规格问题
			 * 		获取JSON规格字段 根据选择规格重新设置needYgb,needMoney,cnSelfAddPrice
			 */
			this.goodsService.handleGoods(goods, goodCart.getCartGsp());
			System.out.println(goods.getNeedMoney() + "  " + goods.getNeedYgb() + " "
					+ goods.getCnSelfAddPrice());

			ZeroGoods resZeroGoods = this.zeroGoodsService.getByGoodsId(goods.getId());// 0元购
			if (null != resZeroGoods && resZeroGoods.getGoodsStatus()) {
				goods.setStorePrice(resZeroGoods.getGoodsPrice());
				goods.setGoodsMobilePrice(resZeroGoods.getGoodsPrice());
				goods.setMobilePrice(resZeroGoods.getGoodsPrice());
				goods.setGoodsCurrentPrice(resZeroGoods.getGoodsPrice());
				goods.setSelfAddPrice(resZeroGoods.getGoodsPrice());
				goods.setGoodsTransfee(0);
				goodCart.setPrice(resZeroGoods.getGoodsPrice());
				goods.setHasMobilePrice(false);
			}
			Long goodsID = goods.getId();
			Integer exPriceFlag = goods.getExPriceFlag();
			BigDecimal cnSelfAddPrice = goods.getCnSelfAddPrice();
			BigDecimal cash = goods.getNeedMoney();// 精品专区 需要的现金
			BigDecimal ygb = goods.getNeedYgb();// 精品专区 需要的云购币
			BigDecimal needIntegral = BigDecimal.ZERO;
			if (null != goods.getNeedIntegral()) {
				needIntegral = goods.getNeedIntegral();
			}
			if (exPriceFlag != null && exPriceFlag == 1 && cnSelfAddPrice != null
					&& cnSelfAddPrice.compareTo(BigDecimal.ZERO) == 1) {
				bvMap.put(goodsID, cnSelfAddPrice);
			}
			if (goods.getIsYgb() != null && goods.getIsYgb() == 1) {
				// 如果是云购币专区的商品，BV值取selfAddPrice
				bvMap.put(goodsID, goods.getSelfAddPrice());
			}
			if (cash != null && ygb != null) {
				cashMap.put(goodsID, cash);
				yunGouBiMap.put(goodsID, ygb);
				needIntegralMap.put(goodsID, needIntegral);
			}
			ShopGoodsBo goodsBO = mapper.map(goods, ShopGoodsBo.class);
			if (goods.getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
				store_list.add(goods.getGoodsStoreId());
			} else {
				store_list.add("self");
			}

			// boolean goods_cod = true;// 默认支持货到付款，这样有一款产品不支持货到付款，这个订单就不支持货到付款
			// int tax_invoice = 1;// 默认可以开具增值税发票，只要存在一款产品不支持增值税发票，整体订单不可以开具增值税发票
			// 订单列表
			List<ShopOrderListBO> shopOrderList = new ArrayList<ShopOrderListBO>();
			// 运费
			Double countShipFee = 0.00;
			for (Object sl : store_list) {
				if (sl != "self" && !sl.equals("self")) {// 商家商品
					List<GoodsCartBO> gc_list = new ArrayList<GoodsCartBO>();// 商家商品
					/*for (GoodsCartBO gc : goodsCartList) {*/
					for (String gc_id : gcIds) {
						if (StringUtils.isNotBlank(gc_id)
								&& CommUtil.null2Long(gc_id).equals(goodCart.getId())) {
							if (goods.getGoodsStoreId() != null && goods.getGoodsStoreId().equals(sl)) {
								gc_list.add(goodCart);
							}
						}
					}
					// }
					// gc_list不为空
					if (gc_list != null && gc_list.size() > 0) {
						countShipFee = goodsCartService.countShipFee(gc_list, uid);// 计算运费
						ShopOrderListBO shopOrder = new ShopOrderListBO();

						if (goods.getGoodsCod() == -1 || goods.getGoodsChoiceType() == 1) // 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
						{
							shopOrder.setGoodsCod(false);
						}
						if (goods.getTaxInvoice() == 0) // 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
						{
							shopOrder.setTaxInvoice(0);
						}

						// 店铺对象
						StoreBO storeBO = storeService.getObjById(CommUtil.null2Long(sl));
						ShopStoreBO stroBO = mapper.map(storeBO, ShopStoreBO.class);
						shopOrder.setShopStore(stroBO);
						// 商品对象列表
						List<ShopGoodsCartBO> cartBOList = MapperUtils.map(mapper, gc_list,
								ShopGoodsCartBO.class);
						for (ShopGoodsCartBO cart : cartBOList) {
							if (null != goodsBO.getNeedIntegral() && null != goodsBO.getNeedYgb()
									&& null != cart.getIsYgb()) {
								goodsBO.setProType(goodsService.proType(goodsBO.getNeedIntegral(),
										goodsBO.getNeedYgb(), cart.getIsYgb()));
							}
							cart.setGoods(goodsBO);
						}
						shopOrder.setGoodsCartList(cartBOList);

						// 每个订单商品总价
						double orderTotalPrice = goodsCartService.calCartPrice(gc_list, gcIds);

						// 运送方式
						if (addres != null && addres.getAreaId() != null) {
							List<SysMap> query_cart_trans = tools.query_cart_trans(gc_list,
									CommUtil.null2String(addres.getAreaId()));
							List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
									ShopTransPortBO.class);
							shopOrder.setTransList(transPortBOs);
						}

						GoodsBO bo = this.goodsService.getGoodsBOById(vo.getGoodsId());
						if (bo != null && bo.getIsYgb().intValue() == 1) {// 标识云购币专区运费
							countShipFee = orderFormService
									.getYgOrderShopFee(new BigDecimal(orderTotalPrice)).doubleValue();
							BigDecimal maxPrice = new BigDecimal(2000);
							if (CommUtil.null2BigDecimal(orderTotalPrice).compareTo(maxPrice) == -1) {
								ShopTransPortBO transPortBOs = new ShopTransPortBO();
								transPortBOs.setKey("运费:" + countShipFee);
								transPortBOs.setValue(CommUtil.null2Double(countShipFee));
								List list = new ArrayList();
								list.add(transPortBOs);
								shopOrder.setTransList(list);
							} else {
								ShopTransPortBO transPortBOs = new ShopTransPortBO();
								transPortBOs.setKey("运费:" + countShipFee);
								transPortBOs.setValue(CommUtil.null2Double(countShipFee));
								List list = new ArrayList();
								list.add(transPortBOs);
								shopOrder.setTransList(list);
							}
						}

						ZeroGoods zeroGoods = this.zeroGoodsService.getByGoodsId(vo.getGoodsId());// 增加0元购
																									// 将商品价格改为0
						if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
							orderTotalPrice = 0.0;
							ShopTransPortBO transPortBOs = new ShopTransPortBO();
							transPortBOs.setKey("运费:" + zeroGoods.getShipFee());
							transPortBOs.setValue(CommUtil.null2Double(zeroGoods.getShipFee()));
							List list = new ArrayList();
							list.add(transPortBOs);
							shopOrder.setTransList(list);
						}

						// 优惠券
						List<CouponInfoBO> couponList = cartTools.query_coupon(CommUtil.null2String(sl),
								CommUtil.null2String(orderTotalPrice), uid);
						List<ShopCouponInfoBO> couponInfoBOs = MapperUtils.map(mapper, couponList,
								ShopCouponInfoBO.class);
						shopOrder.setCouponInfoList(couponInfoBOs);

						shopOrderList.add(shopOrder);
					}

				} else {// 自营商品
					List<GoodsCartBO> self_list = new ArrayList<GoodsCartBO>();// 自营商品
					/*for (GoodsCartBO gc : goodsCartList) {*/
					for (String gc_id : gcIds) {
						if (StringUtils.isNotBlank(gc_id)
								&& CommUtil.null2Long(gc_id).equals(goodCart.getId())) {
							if (goods.getGoodsStoreId() == null) {
								self_list.add(goodCart);
							}
						}
					}
					// }

					// self_list不为空
					if (self_list != null && self_list.size() > 0) {
						ShopOrderListBO shopOrder = new ShopOrderListBO();

						// for (GoodsCartBO gc : self_list) {
						if (goods.getGoodsCod() == -1 || goods.getGoodsChoiceType() == 1) // 只要存在一件不允许使用货到付款购买的商品整个订单就不允许使用货到付款
						{
							shopOrder.setGoodsCod(false);
						}
						if (goods.getTaxInvoice() == 0) // 只要存在一件不支持开具增值税发票的商品，整个订单就不允许开具增值税发票
						{
							shopOrder.setTaxInvoice(0);
						}
						// }

						// 转换后的自营商品列表
						List<ShopGoodsCartBO> shopGoodsList = MapperUtils.map(mapper, self_list,
								ShopGoodsCartBO.class);
						for (ShopGoodsCartBO cart : shopGoodsList) {
							cart.setGoods(goodsBO);
						}
						for (ShopGoodsCartBO cart : shopGoodsList) {
							if (null != goodsBO.getNeedIntegral() && null != goodsBO.getNeedYgb()
									&& null != cart.getIsYgb()) {
								goodsBO.setProType(goodsService.proType(goodsBO.getNeedIntegral(),
										goodsBO.getNeedYgb(), cart.getIsYgb()));
							}
							cart.setGoods(goodsBO);
						}
						shopOrder.setGoodsCartList(shopGoodsList);

						// 自营商品总价
						double orderTotalPrice = goodsCartService.calCartPrice(self_list, gcIds);

						// 运送方式
						if (addres != null && addres.getAreaId() != null) {
							List<SysMap> query_cart_trans = tools.query_cart_trans(self_list,
									CommUtil.null2String(addres.getAreaId()));

							List<ShopTransPortBO> transPortBOs = MapperUtils.map(mapper, query_cart_trans,
									ShopTransPortBO.class);

							shopOrder.setTransList(transPortBOs);
						}

						ZeroGoods zeroGoods = this.zeroGoodsService.getByGoodsId(vo.getGoodsId());// 增加0元购
																									// 将商品价格改为0
						if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
							orderTotalPrice = 0.0;
							ShopTransPortBO transPortBOs = new ShopTransPortBO();
							transPortBOs.setKey("运费:" + zeroGoods.getShipFee());
							transPortBOs.setValue(CommUtil.null2Double(zeroGoods.getShipFee()));
							List list = new ArrayList();
							list.add(transPortBOs);
							shopOrder.setTransList(list);

						}

						// 优惠券
						List<CouponInfoBO> couponList = cartTools.query_coupon(CommUtil.null2String(sl),
								CommUtil.null2String(orderTotalPrice), uid);

						List<ShopCouponInfoBO> couponInfoBOs = MapperUtils.map(mapper, couponList,
								ShopCouponInfoBO.class);
						shopOrder.setCouponInfoList(couponInfoBOs);

						shopOrderList.add(shopOrder);
					}

				}
			}
			orderListDetailBOs.setOrderList(shopOrderList);

			List<ShopOrderListBO> shopOrderBOList = orderListDetailBOs.getOrderList();

			for (ShopOrderListBO shopOrderBO : shopOrderBOList) {
				List<ShopGoodsCartBO> shopGoodsCartList = shopOrderBO.getGoodsCartList();
				for (ShopGoodsCartBO shopGoodsCart : shopGoodsCartList) {
					ShopGoodsBo shopGood = shopGoodsCart.getGoods();
					Integer count = shopGoodsCart.getCount();
					BigDecimal bvTemp = BigDecimal.ZERO;
					BigDecimal cashTemp = BigDecimal.ZERO;
					BigDecimal ygbTemp = BigDecimal.ZERO;
					BigDecimal needIntegralTemp = BigDecimal.ZERO;
					Long goodID = goods.getId();
					if (bvMap.containsKey(goodID)) {
						bvTemp = bvMap.get(goodID);
					}
					if (cashMap.containsKey(goodID)) {
						cashTemp = cashMap.get(goodID);
					}
					if (yunGouBiMap.containsKey(goodID)) {
						ygbTemp = yunGouBiMap.get(goodID);
					}
					if (needIntegralMap.containsKey(goodsID)) {
						needIntegralTemp = needIntegralMap.get(goodsID);
					}
					shopGood.setBv(bvTemp);
					shopGood.setCash(cashTemp);
					shopGood.setYunGouBi(ygbTemp);
					shopGood.setNeedIntegral(needIntegralTemp);
					if (null != shopGood.getNeedIntegral() && null != shopGood.getNeedYgb()
							&& null != shopGoodsCart.getIsYgb()) {
						proType = goodsService.proType(shopGood.getNeedIntegral(), shopGood.getNeedYgb(),shopGoodsCart.getIsYgb());
					}
					if (count != null && count > 0) {
						countBV = countBV.add(shopGood.getBv().multiply(new BigDecimal(count)));
						if (null != shopGood.getNeedIntegral() && null != shopGood.getNeedMoney()
								&& null != shopGood.getNeedYgb()) {
							countNeedIntegral = countNeedIntegral.add(shopGood.getNeedIntegral().multiply(
									new BigDecimal(count)));
							countNeedMoney = countNeedMoney.add(shopGood.getNeedMoney().multiply(
									new BigDecimal(count)));
							countNeedYgb = countNeedYgb.add(shopGood.getNeedYgb().multiply(
									new BigDecimal(count)));
						}
					} else {
						countBV = countBV.add(shopGood.getBv());
						if (null != shopGood.getNeedIntegral() && null != shopGood.getNeedMoney()
								&& null != shopGood.getNeedYgb()) {
							countNeedIntegral = countNeedIntegral.add(shopGood.getNeedIntegral());
							countNeedMoney = countNeedMoney.add(shopGood.getNeedMoney());
							countNeedYgb = countNeedYgb.add(shopGood.getNeedYgb());
						}
					}
					// 是否为云购币专区订单
					isYgb = shopGoodsCart.getIsYgb();
				}
				if(!isCN){
					if(proType.intValue() == 2 || proType.intValue() == 3 ){
						proType = 4;
					}
				}
				shopOrderBO.setProType(proType);
				shopOrderBO.setBvCount(countBV);
				shopOrderBO.setNeedIntegral(countNeedIntegral);
				shopOrderBO.setNeedMoney(countNeedMoney);
				shopOrderBO.setNeedYgb(countNeedYgb);
				shopOrderBO.setIsYgb("1".equals(String.valueOf(isYgb)));
				shopOrderBO.setShopingIntegral(BigDecimal.valueOf(shopingIntegral));
				shopOrderBO.setCnRepeat(BigDecimal.valueOf(cnRepeat));
			}

			if("1".equals(String.valueOf(isYgb))){
				if (isCN) {
//					userIntegral = shopingIntegral; //CN账号不需判断
				} else {
					UserCustomerBO userBO = userCustomerService.findSessionUser(uid);
					if (null != userBO && null != userBO.getIntegral()) {
						userIntegral = userBO.getIntegral().doubleValue();
					}
					if (isYgb == 1 && countNeedIntegral.doubleValue() > userIntegral.doubleValue()) {// 普通会员 并且选择的是精选专区商品 判断积分是否足够
						response.putErrorMessage("5.integral.saveOrder.integral.inadequate");
						return response;
					}
				}
			}
			
			response.setOrderList(orderListDetailBOs);
			response.setAllGoodsFree(new BigDecimal(countShipFee));
			response.setFreeShipAmount(2000);
			return response;

		} catch (ServiceException e) {
			logger.error("[shopByGoods] error " + e);
		}
		return response;
	}

	/**
	 * 处理商品 云购币+现金 BV值
	 * 
	 * @param good
	 */
	@SuppressWarnings("unused")
	private void handleGoods(Goods good, Map<Long, BigDecimal> bvMap, Map<Long, BigDecimal> cashMap,
			Map<Long, BigDecimal> yunGouBiMap, String cart_gsp) {
		if (good != null && bvMap != null && yunGouBiMap != null && cashMap != null) {
			Long goodID = good.getId();
			good = this.goodsService.findBOByid(goodID);

			this.goodsService.handleGoods(good, cart_gsp);
			System.out.println(good.getNeedMoney() + "  " + good.getNeedYgb() + " "
					+ good.getCnSelfAddPrice());

			BigDecimal cash = good.getNeedMoney();
			BigDecimal yunGouBi = good.getNeedYgb();
			BigDecimal bv = good.getCnSelfAddPrice();
			Integer flag = good.getExPriceFlag();
			BigDecimal zero = BigDecimal.ZERO;
			System.out.println(" goodsName = " + good.getGoodsName() + " cash=" + cash + " yunGouBi="
					+ yunGouBi + " bv=" + bv + " flag=" + flag);
			if (bv != null && flag != null && flag == 1 && bv.compareTo(BigDecimal.ZERO) == 1) {
				bvMap.put(goodID, bv);
			}
			if (good.getIsYgb() != null && good.getIsYgb() == 1) {
				// 如果是云购币专区的商品，BV值取selfAddPrice
				bvMap.put(goodID, good.getSelfAddPrice());
			}
			if (cash != null && cash.compareTo(zero) == 1) {
				cashMap.put(goodID, cash);
			}
			if (yunGouBi != null && yunGouBi.compareTo(zero) == 1) {
				yunGouBiMap.put(goodID, yunGouBi);
			}
		}
	}

}
