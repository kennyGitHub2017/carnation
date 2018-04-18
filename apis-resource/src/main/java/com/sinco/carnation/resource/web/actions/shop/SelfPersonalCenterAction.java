package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.jiuye.utils.IdTypeHandler;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.resource.bo.search.EvaluatePageBO;
import com.sinco.carnation.resource.bo.self.FavaStoreBO;
import com.sinco.carnation.resource.bo.self.OrderFormDetailBO;
import com.sinco.carnation.resource.bo.self.SelfOrderBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsInfo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.search.CancelOrderVO;
import com.sinco.carnation.resource.vo.search.EvaluateAddVO;
import com.sinco.carnation.resource.vo.search.EvalutePageListVO;
import com.sinco.carnation.resource.vo.search.SelfFavaGoodsVO;
import com.sinco.carnation.resource.vo.shop.SelfOrderVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.SelfOrderListResponse;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "个人中心", namespace = "self")
@SuppressWarnings({"rawtypes", "unchecked"})
public class SelfPersonalCenterAction extends BasicApiController {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(SelfPersonalCenterAction.class);

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private StorePointService storePointService;

	@Autowired
	private OrderFormLogService orderFormLogService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private EvaluateService evaluateService;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private UserCustomerService customerService;

	@Autowired
	private UserService userService;
	@Autowired
	private PaymentService payMentService;

	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private WordFind wordFind;
	@Autowired
	private Mapper mapper;
	@Autowired
	private JuanpiOrderService juanpiOrderService;
	@Value(value = "${api.path}")
	private String apiPath;

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	@RequestMapping(value = "/self/order/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我的订单列表")
	public @ResponseBody
	SelfOrderListResponse selfOrderList(@Valid @ModelAttribute @Param SelfOrderVO vo, BindingResult result,
			HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 设置分页
		MyPage<OrderFormBO> page = new MyPage<OrderFormBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// 获取uid
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("5.shop.selectGoodsTotalPrice.not_uid");
			return response;
		}
		Integer yungouFlag = 0; // 增加yungouFlag过滤字段
		orderFormService.queryByCnd(uid, null, null, null, vo.getOrderStatus(), page, yungouFlag);

		// 所有主订单
		List<SelfOrderBO> selfOrderBOs = MapperUtils.map(mapper, page.getContent(), SelfOrderBO.class);

		for (SelfOrderBO selfOrderBO : selfOrderBOs) {
			selfOrderBO.setOrderTypeFlag(selfOrderBO.getOrderTypeFlag());
			if(selfOrderBO.getPayTypeFlag() == null){
				//返回个默认值（针对老数据为NULL处理），防止APP取不到值直接闪退了 2017-8-18 Tivan
				selfOrderBO.setPayTypeFlag(0);
			}
			// 每个主订单下面所有商品
			List<ShopGoodsInfo> allGoodsInfos = new ArrayList<ShopGoodsInfo>();
			if (selfOrderBO != null && StringUtils.isNotBlank(selfOrderBO.getChildOrderDetail())) {
				List<Map<String, Object>> list = JSON.parseObject(selfOrderBO.getChildOrderDetail(),
						new TypeReference<List<Map<String, Object>>>() {});
				for (Map<String, Object> map : list) {
					String value = map.get("order_goods_info").toString();
					if (StringUtils.isNotBlank(value)) {
						// 每个主订单下面所有子订单
						List<ShopGoodsInfo> lInfos = (List<ShopGoodsInfo>) JSON.parseArray(value,
								ShopGoodsInfo.class);
						for (ShopGoodsInfo shopGoodsInfo : lInfos) {
							if (null != selfOrderBO.getPayTypeFlag()) {
								shopGoodsInfo.setPayTypeFlag(selfOrderBO.getPayTypeFlag());
							}
							allGoodsInfos.add(shopGoodsInfo);
						}
					}
				}
			}
			
				
			if (selfOrderBO.getJuanpiOrder() != null && selfOrderBO.getJuanpiOrder() == 0) {
			// 主订单商品
			List<ShopGoodsInfo> lInfos = (List<ShopGoodsInfo>) JSON.parseArray(selfOrderBO.getGoodsInfo(),
					ShopGoodsInfo.class);
			for (ShopGoodsInfo shopGoodsInfo : lInfos) {
				if (null != selfOrderBO.getPayTypeFlag()) {
					shopGoodsInfo.setPayTypeFlag(selfOrderBO.getPayTypeFlag());
				}
				allGoodsInfos.add(shopGoodsInfo);
			}

			// // 订单总价
			// BigDecimal totalPrice = new BigDecimal(0);
			// for (ShopGoodsInfo shopGoodsInfo : allGoodsInfos) {
			// totalPrice = totalPrice.add(shopGoodsInfo.getGoods_all_price());
			// }

			// 订单总价
			if (selfOrderBO.getOrderTypeFlag().intValue() == 3
					&& (selfOrderBO.getPayTypeFlag().intValue() == 2 || selfOrderBO.getPayTypeFlag().intValue() == 3)) {
				selfOrderBO.setTotalPrice(selfOrderBO.getAllIntegral().add(
						selfOrderBO.getAllCashPrice() == null ? new BigDecimal(0) : selfOrderBO
								.getAllCashPrice()));
			} else if (selfOrderBO.getOrderTypeFlag().intValue() == 3
					&& selfOrderBO.getPayTypeFlag().intValue() == 1) {
				selfOrderBO.setTotalPrice(selfOrderBO.getAllygPrice().add(
						selfOrderBO.getShipPrice() == null ? new BigDecimal(0) : selfOrderBO.getShipPrice()));
			} else if (selfOrderBO.getOrderTypeFlag().intValue() == 3) {
				selfOrderBO.setTotalPrice(selfOrderBO.getAllygPrice().add(
						selfOrderBO.getAllCashPrice() == null ? new BigDecimal(0) : selfOrderBO
								.getAllCashPrice()));
			} else if (selfOrderBO.getOrderTypeFlag().intValue() == 2) {
				selfOrderBO.setTotalPrice(selfOrderBO.getAllygPrice().add(
						selfOrderBO.getAllCashPrice() == null ? new BigDecimal(0) : selfOrderBO
								.getAllCashPrice()));
			}else if(selfOrderBO.getOrderTypeFlag().intValue() == 4){
					selfOrderBO.setTotalPrice(selfOrderBO.getTotalPrice());
			}
			else{
				double price = orderFormTools.query_order_price(CommUtil.null2String(selfOrderBO.getId()));
				selfOrderBO.setTotalPrice(new BigDecimal(price));
			}

			// selfOrderBO.setTotalPrice(totalPrice.add(selfOrderBO.getShipPrice()));
			selfOrderBO.setGoodsInfos(allGoodsInfos);
			}
			
			if (selfOrderBO.getJuanpiOrder() != null && selfOrderBO.getJuanpiOrder() == 1) {
				boolean bl = true;
				List<ShopGoodsInfo> lInfos = (List<ShopGoodsInfo>) JSON.parseArray(selfOrderBO.getGoodsInfo(),ShopGoodsInfo.class);
				List<ShopGoodsInfo> ShopGoodsInfoAdd = new ArrayList();
				for (ShopGoodsInfo shopGoodsInfo : lInfos) {
					ShopGoodsInfo sp = new ShopGoodsInfo();
					sp.setGoods_price(shopGoodsInfo.getGoodsmoney());
					sp.setGoods_count(shopGoodsInfo.getGoodsnumber());
					sp.setGoods_name(shopGoodsInfo.getGoodstitle());
					sp.setGoods_mainphoto_path(apiPath+"/resources/img/JPOrder@3x.png");
					ShopGoodsInfoAdd.add(sp);
				}

				for (ShopGoodsInfo shopGoodsInfo : lInfos) {
					if (shopGoodsInfo.getStatus() != 3 && shopGoodsInfo.getStatus() != 4) {
						bl = false;
						break;
					}
				}
				selfOrderBO.setTargetUrlM(selfOrderBO.getTargetUrlM()+selfOrderBO.getOrderId());
				selfOrderBO.setDelete(bl);
				selfOrderBO.setOrderTypeFlag(0);
				selfOrderBO.setPayTypeFlag(0);
				selfOrderBO.setOrderStatus(0);
				selfOrderBO.setGoodsInfos(ShopGoodsInfoAdd);
				
			}
			
			if(selfOrderBO.getOrderTypeFlag().intValue() ==4 ){
				boolean bl = true;
				List<ShopGoodsInfo> lInfos = (List<ShopGoodsInfo>) JSON.parseArray(selfOrderBO.getGoodsInfo(),ShopGoodsInfo.class);
				List<ShopGoodsInfo> ShopGoodsInfoAdd = new ArrayList();
				
				for (ShopGoodsInfo shopGoodsInfo : lInfos) {
					ShopGoodsInfo sp = new ShopGoodsInfo();
					sp.setGoods_price(shopGoodsInfo.getSkuPrice());
					sp.setGoods_count(shopGoodsInfo.getSkuNum());
					sp.setGoods_name(shopGoodsInfo.getSkuName());
					sp.setGoods_mainphoto_path(shopGoodsInfo.getSkuIcon());
					ShopGoodsInfoAdd.add(sp);
				}
				String url = "http://ys.zjtech.cc/trueme/order/orderDetails.html?orderId=";
				selfOrderBO.setTargetUrlM(url+IdTypeHandler.encode(selfOrderBO.getId()));
				selfOrderBO.setDelete(bl);
				selfOrderBO.setPayTypeFlag(0);
				selfOrderBO.setGoodsInfos(ShopGoodsInfoAdd);
			}
			
		}
		response.setOrderList(selfOrderBOs);
		return response;
	}

	@RequestMapping(value = "/self/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "订单详情")
	public @ResponseBody
	SelfOrderListResponse orderDetail(@Valid @RequestParam(value = "id") @Param(desc = "订单id") Long id) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		List<OrderForm> orderForfAll = new ArrayList<OrderForm>();
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null) {
			if(obj.getPayTypeFlag() == null){
				//返回个默认值（针对老数据为NULL处理），防止APP取不到值直接闪退了 2017-8-18 Tivan
				obj.setPayTypeFlag(0);
			}
			orderForfAll.add(obj);
			if (obj != null && StringUtils.isNotBlank(obj.getChildOrderDetail())) {
				// List<Map> list =
				// orderFormTools.queryChildGoodsInfo(obj.getChildOrderDetail());
				List<Map> list = orderFormTools.queryGoodsInfo(obj.getChildOrderDetail());
				for (Map map : list) {
					String orderId = map.get("order_id").toString();
					if (StringUtils.isNotBlank(orderId)) {
						OrderForm childOrder = this.orderFormService.getObjById(CommUtil.null2Long(orderId));
						if(childOrder != null){
							if(childOrder.getPayType() == null){
								childOrder.setPayTypeFlag(0);
							}
							orderForfAll.add(childOrder);
						}
					}
				}
			}
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 订单总价
		BigDecimal totalPrice = new BigDecimal(0);
		// 可退货订单
		MyPage<OrderFormBO> page = new MyPage<OrderFormBO>();
		List<OrderFormBO> returns = orderFormService.search(null, uid, page);

		// 判断是否可退货
		List<SelfOrderBO> selfOrderBOs = MapperUtils.map(mapper, orderForfAll, SelfOrderBO.class);
		for (SelfOrderBO selfOrderBO : selfOrderBOs) {
			List<ShopGoodsInfo> lInfos = (List<ShopGoodsInfo>) JSON.parseArray(selfOrderBO.getGoodsInfo(),
					ShopGoodsInfo.class);
			if (null != returns) {
				for (ShopGoodsInfo lInfo : lInfos) {
					lInfo.setHasReturn(false);
					for (OrderFormBO returnBO : returns) {
						if (returnBO.getId().equals(selfOrderBO.getId())) {
							lInfo.setHasReturn(true);
						}
						for (Map<String, Object> map : orderFormTools.queryGoodsInfo(returnBO.getGoodsInfo())) {
							if (map.get("goods_return_status") != null
									&& lInfo.getGoods_id() == (int) map.get("goods_id")) {// 5.6.7 退货中 8 退货完成
								lInfo.setHasReturn(false);
								System.out.println("{[" + map.get("goods_return_status") + "]}");
								if (map.get("goods_return_status").equals("")) {
									lInfo.setHasReturn(true);
								}
							}
						}
					}
					if (selfOrderBO.getOrderTypeFlag() == 3) {
						lInfo.setPayTypeFlag(selfOrderBO.getPayTypeFlag());
					}
					if(lInfo.getPayTypeFlag() == null){
						lInfo.setPayTypeFlag(0);
					}
				}
			}
			selfOrderBO.setGoodsInfos(lInfos);
			totalPrice = totalPrice.add(selfOrderBO.getGoodsAmount());

			// 支付方式
			if (obj != null && obj.getPaymentId() != null) {
				Payment payment = payMentService.findById(obj.getPaymentId());
				if (payment != null)
					selfOrderBO.setPayWay(payment.getName());
			}

			if (null != obj && null != obj.getPayTypeFlag()) {
				if (obj.getPayTypeFlag().intValue() == 1) {
					selfOrderBO.setPayWay("重消支付");
					selfOrderBO.setStoreName("精选专区");
				}
				if (obj.getPayTypeFlag().intValue() == 2) {
					selfOrderBO.setPayWay("购物积分支付");
					selfOrderBO.setStoreName("精选专区");
				}
			}
		}

		// 订单总价
		// double
		// totalPrice=orderFormTools.queryOfGoodsPrice(CommUtil.null2String(obj.getId()));
		double price = orderFormTools.query_order_price(CommUtil.null2String(obj.getId()));

		OrderFormDetailBO orderFormDetail = new OrderFormDetailBO();
		orderFormDetail.setId(obj.getId());
		orderFormDetail.setOrderId(obj.getOrderId());
		orderFormDetail.setOrderStatus(obj.getOrderStatus());
		orderFormDetail.setReceiverName(obj.getReceiverName());
		orderFormDetail.setReceiverArea(obj.getReceiverArea());
		orderFormDetail.setReceiverAreaInfo(obj.getReceiverAreaInfo());
		orderFormDetail.setReceiverMobile(obj.getReceiverMobile());
		orderFormDetail.setStoreId(obj.getStoreId());
		orderFormDetail.setStoreName(obj.getStoreName());
		orderFormDetail.setShipPrice(CommUtil.null2Double(obj.getShipPrice()));
		orderFormDetail.setCouponAmount(CommUtil.null2Double(obj.getCommissionAmount()));
		orderFormDetail.setOrderFormList(selfOrderBOs);
		orderFormDetail.setGoodsAmount(CommUtil.null2Double(obj.getGoodsAmount()));
		orderFormDetail.setShipCode(obj.getShipCode());
		orderFormDetail.setTotalPrice(totalPrice);
		if (null != obj.getIsygOrder() && obj.getIsygOrder()) {
			if (obj.getPayTypeFlag().intValue() == 2 || obj.getPayTypeFlag().intValue() == 3) { // 积分+现金支付
				orderFormDetail.setPrice(obj.getAllCashPrice().add(obj.getAllIntegral()));
			} else if (obj.getPayTypeFlag().intValue() == 1) { // 重消+运费支付方式
				orderFormDetail.setPrice(obj.getAllygPrice().add(
						obj.getShipPrice() == null ? new BigDecimal(0) : obj.getShipPrice()));
			}
			orderFormDetail.setAllCashPrice((obj.getAllCashPrice() == null ? new BigDecimal(0) : obj
					.getAllCashPrice()).subtract(obj.getShipPrice() == null ? new BigDecimal(0) : obj
					.getShipPrice()));
		} else if (obj.getOrderTypeFlag().intValue() == 2) {
			orderFormDetail.setPrice(obj.getAllygPrice().add(
					obj.getShipPrice() == null ? new BigDecimal(0) : obj.getShipPrice()));
		} else {
			orderFormDetail.setPrice(new BigDecimal(price));
		}
		Long leftTime = 72 * 60 * 60L;
		leftTime = leftTime - (new Date().getTime() - obj.getAddTime().getTime()) / 1000;
		if (leftTime < 0)
			leftTime = 0L;
		String str = CommUtil.formatLongDate(obj.getAddTime());
		orderFormDetail.setAddTime(CommUtil.formatDate(str, "yyyy-MM-dd HH:mm:ss"));
		orderFormDetail.setAllygPrice(obj.getAllygPrice());
		orderFormDetail.setAllIntegral(obj.getAllIntegral());
		orderFormDetail.setActualIntegral(obj.getActualIntegral());
		orderFormDetail.setCommissionAmount(obj.getCommissionAmount());
		orderFormDetail.setOrderTypeFlag(obj.getOrderTypeFlag());
		orderFormDetail.setPayTypeFlag(obj.getPayTypeFlag());
		orderFormDetail.setLeftTime(leftTime);
		response.setOrderFormDetail(orderFormDetail);
		return response;
	}

	@RequestMapping(value = "/self/order_evaluate/save", method = RequestMethod.POST)
	@MethodMapping(desc = "商品评论保存")
	public @ResponseBody
	SelfOrderListResponse orderReturnList(
			@Valid @RequestParam(value = "evaluateInfo") @Param(desc = "商品评论信息") String evaluateInfo,
			HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();

		if (StringUtils.isBlank(evaluateInfo)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		try {
			int num = orderFormService.evaluateSave(uid, evaluateInfo);
			if (num == 300) {
				response.putErrorMessage("5.self.orderReturnList.evaluate_save_fail");
				return response;
			} else if (num == 400) {
				response.putErrorMessage("5.self.orderReturnList.evaluate_order_fail");
				return response;
			} else if (num == 600) {
				response.putErrorMessage("5.self.orderReturnList.word_fail");
				return response;
			}
		} catch (Exception e) {
			response.putErrorMessage("5.self.orderReturnList.evaluate_validate_fail");
			return response;
		}

		return response;
	}

	@RequestMapping(value = "/self/evaluate_add/save", method = RequestMethod.POST)
	@MethodMapping(desc = "追加评论保存")
	public @ResponseBody
	SelfOrderListResponse evaluateAddSave(@Valid @ModelAttribute @Param EvaluateAddVO vo,
			BindingResult result, HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		if (wordFind.find(vo.getEvaluateInfo()).length > 0) {
			response.putErrorMessage("5.self.evaluateAddSave.word_fail");
			return response;
		}

		int num = orderFormService
				.evaluateAddSave(uid, vo.getEvalId(), vo.getEvaluateInfo(), vo.getImgPath());
		if (num == 200) {
			response.putErrorMessage("4.self.evaluateAddSave.evalute_time_got");// 已超出评价追加期限
		}
		if (num == 300) {
			response.putErrorMessage("4.self.evaluateAddSave.order_fail");// 订单信息错误
		}
		return response;

	}

	@RequestMapping(value = "/self/goods/confirm", method = RequestMethod.POST)
	@MethodMapping(desc = "确认收货")
	public @ResponseBody
	SelfOrderListResponse confirmGoods(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) throws Exception {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		orderFormService.orderCofirmSave(uid, CommUtil.null2String(orderId), null);
		return response;
	}

	@RequestMapping(value = "/self/evaluate/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我评论列表")
	public @ResponseBody
	SelfOrderListResponse getEvaluateList(@Valid @ModelAttribute @Param EvalutePageListVO vo,
			BindingResult result, HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		MyPage<EvaluateBO> page = new MyPage<EvaluateBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		evaluateService.queryEvaultePageList(uid, page);

		List<EvaluatePageBO> list = MapperUtils.map(mapper, page.getContent(), EvaluatePageBO.class);
		response.setSelfEvaluate(list);
		return response;
	}

	@RequestMapping(value = "/self/fava/list", method = RequestMethod.POST)
	@MethodMapping(desc = "我收藏的商品列表")
	public @ResponseBody
	SelfOrderListResponse favaGoodsList(@Valid @ModelAttribute @Param SelfFavaGoodsVO vo,
			BindingResult result, HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		// 商品
		if (vo.getType() == 3) {
			MyPage<GoodsBO> page = new MyPage<GoodsBO>();
			page.setPageNumber(vo.getPageNum());
			page.setPageSize(vo.getPageSize());
			goodsService.queryFavaGoodsPageList(vo.getType(), uid, page);
			List<ShopGoodsBo> list = MapperUtils.map(mapper, page.getContent(), ShopGoodsBo.class);
			response.setSelfFavaGoodsList(list);
		}
		// 商铺
		if (vo.getType() == 4) {
			MyPage<StoreBO> page = new MyPage<StoreBO>();
			page.setPageNumber(vo.getPageNum());
			page.setPageSize(vo.getPageSize());
			storeService.queryFavaStorePageList(uid, CommUtil.null2String(vo.getType()), page);
			List<FavaStoreBO> list = MapperUtils.map(mapper, page.getContent(), FavaStoreBO.class);
			response.setSelfStroeList(list);
		}

		return response;
	}

	@RequestMapping(value = "/self/order/cancel", method = RequestMethod.POST)
	@MethodMapping(desc = "买家取消订单")
	public @ResponseBody
	SelfOrderListResponse cancelOrderSave(@Valid @ModelAttribute @Param CancelOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		try {
			orderFormService.cancelSave(request, CommUtil.null2String(vo.getOrderId()), vo.getStateInfo(),
					null, uid);
		} catch (Exception e) {
		}
		return response;
	}

	@RequestMapping(value = "/self/fava/delete", method = RequestMethod.POST)
	@MethodMapping(desc = "删除收藏")
	public @ResponseBody
	SelfOrderListResponse deleteFava(@Valid @RequestParam(value = "id") @Param(desc = "收藏id") Long id,
			@Valid @RequestParam(value = "type") @Param(desc = "类型|1，帖子 2，医生 3,商品 4店铺,5服务,6商户") String type) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		UserCustomerFavorites favorites = customerService.queryCustomerFavorites(uid,
				CommUtil.null2String(id), type);
		if (favorites == null) {
			response.putErrorMessage("4.self.deleteFava.fava_fail");
			return response;
		}
		try {
			customerService.cancleGoodsOrStoreFavoritesById(favorites.getId());
		} catch (ServiceException e) {
		}
		return response;
	}

	@RequestMapping(value = "/self/order/delete", method = RequestMethod.POST)
	@MethodMapping(desc = "删除订单")
	public @ResponseBody
	SelfOrderListResponse deleteOrder(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId,
			@RequestParam(value = "isJuanpiOrder") @Param(desc = "卷皮订单") Boolean isJuanpiOrder) {
		SelfOrderListResponse response = new SelfOrderListResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		
		if (isJuanpiOrder) {
			JuanpiOrder jp = new JuanpiOrder();
			jp.setDeleteStatus(1);
			jp.setId(orderId);
			this.juanpiOrderService.update(jp);
			
		}
		
		if (isJuanpiOrder ==null || !isJuanpiOrder) {
			OrderForm obj = this.orderFormService.getObjById(orderId);
			if (obj != null && obj.getUserId().toString().equals(uid.toString())) {
				// if (obj.getOrderStatus() == 0) {
				if (obj.getOrderMain() == 1 && obj.getOrderCat() == 0) {
					if (obj.getChildOrderDetail() != null && !obj.getChildOrderDetail().equals("")) {
						List<Map> maps = (List<Map>) Json.fromJson(obj.getChildOrderDetail());
						for (Map map : maps) {
							OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(map
									.get("order_id")));
							// child_order.setOrderStatus(0);
							child_order.setDeleteStatus(1);
							this.orderFormService.save(child_order);
							// this.orderFormService.delete(child_order.getId());
						}
					}
				}
				obj.setDeleteStatus(1);
				this.orderFormService.save(obj);
			}
		} 

		return response;
	}
}
