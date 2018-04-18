package com.sinco.carnation.resource.web.actions.integral;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.resource.bo.integral.AddressListBO;
import com.sinco.carnation.resource.bo.integral.ComputeOrderBO;
import com.sinco.carnation.resource.bo.integral.IGoBO;
import com.sinco.carnation.resource.bo.integral.IntegralGoodsDetailsBO;
import com.sinco.carnation.resource.bo.integral.IntegralListBO;
import com.sinco.carnation.resource.bo.integral.IntegralOrderDetailsBO;
import com.sinco.carnation.resource.bo.integral.OrderBO;
import com.sinco.carnation.resource.bo.integral.OrderListBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.integral.IntegralCreateOrderVO;
import com.sinco.carnation.resource.vo.integral.IntegralDetailsVO;
import com.sinco.carnation.resource.vo.integral.IntegralListCriteriaVO;
import com.sinco.carnation.resource.vo.integral.IntegralListVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.integral.IntegralResponse;
import com.sinco.carnation.shop.bo.IntegralGoodsBO;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "积分商城", namespace = "integral")
public class IntegralController extends BasicApiController {
	@Autowired
	AddressService addressService;
	@Autowired
	IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	IntegralGoodsService integralGoodsService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private IntegralViewTools tools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private Mapper mapper;
	private static final Logger logger = LoggerFactory.getLogger(IntegralController.class);
	@RequestMapping(value = "/integral/computeOrder", method = RequestMethod.POST)
	@MethodMapping(desc = "计算订单所需的积分与费用等相关信息，只需传递 goodsJson 参数")
	@ResponseBody
	public IntegralResponse computeOrder(@Valid @ModelAttribute @Param IntegralCreateOrderVO vo,
			BindingResult result) {
		Long userId = ActionsUtil.getOwnerUid();
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Object[] os = integralGoodsService.computeOrder(vo.getGoodsJson(), userId);
		ComputeOrderBO order = new ComputeOrderBO();
		order.setUserIntegral((Integer) os[0]);
		order.setTotalIntegral((Integer) os[1]);
		order.setTotalTransportFee((Double) os[2]);
		response.setComputeOrderBO(order);

		return response;
	}

	@RequestMapping(value = "/integral/rePayment", method = RequestMethod.POST)
	@MethodMapping(desc = "重新支付订单，也可以用于查询积分订单状态")
	@ResponseBody
	public IntegralResponse rePayment(@Valid @RequestParam(value = "id") @Param(desc = "积分订单ID") Long id) {
		Long userId = ActionsUtil.getOwnerUid();
		IntegralResponse response = new IntegralResponse();
		IntegralGoodsOrder order = integralGoodsOrderService.getObjById(id);
		if (order == null || !order.getIgoUserId().equals(userId)) {
			response.putErrorMessage("5.integral.rePayment.orderid.not.found");
			return response;
		}
		OrderBO orderBO = new OrderBO();
		orderBO.setId(order.getId());
		orderBO.setIgoOrderSn(order.getIgoOrderSn());
		orderBO.setIgoStatus(order.getIgoStatus());
		orderBO.setIgoTransFee(order.getIgoTransFee());
		response.setOrderBO(orderBO);
		return response;
	}

	@RequestMapping(value = "/integral/saveOrder", method = RequestMethod.POST)
	@MethodMapping(desc = "创建积分兑换订单")
	@ResponseBody
	public synchronized  IntegralResponse saveOrder(@Valid @ModelAttribute @Param IntegralCreateOrderVO vo,
			BindingResult result) {
		Long userId = ActionsUtil.getOwnerUid();
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		logger.debug("积分支付开始");
		Address addr = new Address();
		addr.setId(vo.getAddressId());
		addr.setTrueName(vo.getTrueName());
		addr.setAreaId(vo.getAreaId());
		addr.setZip(vo.getZip());
		addr.setAreaInfo(vo.getAreaInfo());
		addr.setMobile(vo.getMobile());
		addr.setTelephone(vo.getTelephone());
		IntegralGoodsOrder order = new IntegralGoodsOrder();
		
		try {
			integralGoodsService.exchangeApp(vo.getGoodsJson(), addr, vo.getIgoMsg(), userId, order);
			OrderBO orderBO = new OrderBO();
			orderBO.setId(order.getId());
			orderBO.setIgoOrderSn(order.getIgoOrderSn());
			orderBO.setIgoStatus(order.getIgoStatus());
			orderBO.setIgoTransFee(order.getIgoTransFee());
			response.setOrderBO(orderBO);
		} catch (ServiceException e) {
			response.setSubMsg(e.getMessage());
			response.setSubCode(e.getErrorCode());	
			response.setErrorCode(e.getErrorCode());
		}

		return response;
	}

	@RequestMapping(value = "/integral/addressList", method = RequestMethod.POST)
	@MethodMapping(desc = "我的收货地址列表")
	@ResponseBody
	public IntegralResponse addressList() {
		Long userId = ActionsUtil.getOwnerUid();
		IntegralResponse response = new IntegralResponse();
		List<AddressBO> list = addressService.selectByUser(userId);
		response.setAddressList(MapperUtils.map(mapper, list, AddressListBO.class));
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/integral/orderList", method = RequestMethod.POST)
	@MethodMapping(desc = "我的积分兑换列表")
	@ResponseBody
	public IntegralResponse orderList(@Valid @ModelAttribute @Param IntegralListVO vo, BindingResult result) {
		Long userId = ActionsUtil.getOwnerUid();
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<IntegralGoodsOrderBO> page = new MyPage<IntegralGoodsOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<IntegralGoodsOrderBO> list = integralGoodsOrderService.selectByUser(userId, page);
		// 解析商品信息
		for (IntegralGoodsOrderBO orderBO : list) {

		}
		response.setOrderList(MapperUtils.map(mapper, list, OrderListBO.class));
		response.setTotalCount(page.getTotalElements());

		return response;
	}

	@RequestMapping(value = "/integral/list", method = RequestMethod.POST)
	@MethodMapping(desc = "积分商品列表")
	public @ResponseBody
	IntegralResponse list(@Valid @ModelAttribute @Param IntegralListVO vo, BindingResult result) {
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<IntegralGoodsBO> page = new MyPage<IntegralGoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		List<IntegralGoodsBO> list = integralGoodsService.selectForListBean(null, null, null, page);
		response.setIntegralList(MapperUtils.map(mapper, list, IntegralListBO.class));
		response.setTotalCount(page.getTotalElements());

		return response;
	}

	/**
	 * 根据条件查询积分商品列表（所有，按积分查询）
	 * 
	 * @param vo
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/integral/listByCriteria", method = RequestMethod.POST)
	@MethodMapping(desc = "根据查询条件显示积分商品列表")
	public @ResponseBody
	IntegralResponse listByFilter(@Valid @ModelAttribute @Param IntegralListCriteriaVO vo,
			BindingResult result) {
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<IntegralGoodsBO> page = new MyPage<IntegralGoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		String minRange = null, maxRange = null;
		if (vo != null && !vo.isFindAll()) {// 根据积分范围查询
			minRange = vo.getMinIntegral();
			maxRange = vo.getMaxIntegral();
		}
		// KENNY 修改 null 为 vo.getMobileRecommend()；2016-07-29
		List<IntegralGoodsBO> list = integralGoodsService.selectListByCriteria(vo.getMobileRecommend(),
				minRange, maxRange, page);
		response.setIntegralList(MapperUtils.map(mapper, list, IntegralListBO.class));
		response.setTotalCount(page.getTotalElements());

		return response;
	}

	@RequestMapping(value = "/integral/details", method = RequestMethod.POST)
	@MethodMapping(desc = "积分商品详情")
	public @ResponseBody
	IntegralResponse integralGoodsDetails(@Valid @RequestParam(value = "id") @Param(desc = "商品id") Long id) {
		IntegralResponse response = new IntegralResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		IntegralGoods integral = integralGoodsService.getObjById(id);
		if (integral != null) {
			IntegralGoodsDetailsBO integralDetails = mapper.map(integral, IntegralGoodsDetailsBO.class);
			integralDetails.setIgContent(JsoupUtils.queryHtml(integral.getIgContent()));
			response.setIntegralDetails(integralDetails);
		}
		return response;
	}

	@RequestMapping(value = "/integral/exchange", method = RequestMethod.POST)
	@MethodMapping(desc = "立即兑换")
	public @ResponseBody
	IntegralResponse exchange(@Valid @ModelAttribute @Param IntegralDetailsVO vo, BindingResult result) {
		IntegralResponse response = new IntegralResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		synchronized(this){
			IntegralGoods integral = integralGoodsService.getObjById(vo.getId());
			UserCustomerBO customer = customerService.queryUserByUid(uid);
			long nowDate = new Date().getTime();

			// 时间已过期
			if (integral.getIgTimeType() && integral.getIgBeginTime() != null
					&& nowDate < integral.getIgBeginTime().getTime()) {
				response.setExchangeStatus(7);
				return response;
				// 等级不够
			} else if (integral.getIgTimeType() && integral.getIgEndTime() != null
					&& nowDate > integral.getIgEndTime().getTime()) {
				response.setExchangeStatus(1);
				return response;
			} else if (tools.query_user_level(CommUtil.null2String(uid)) < integral.getIgUserLevel()) {
				response.setExchangeStatus(2);
				return response;
				// 积分不够
			} else if ((integral.getIgGoodsIntegral() * vo.getCount()) > customer.getIntegral()) {
				response.setExchangeStatus(3);
				return response;
				// 库不足
			} else if (integral.getIgGoodsCount() < vo.getCount()) {
				response.setExchangeStatus(4);
				return response;
				// 超出限制兑换数
			} else if (integral.getIgLimitType() && integral.getIgLimitCount() < vo.getCount()) {
				response.setExchangeStatus(5);
				return response;
			} else if (uid == null) {
				response.setExchangeStatus(6);
				return response;
			}
			else if (integral.getIgGoodsCount() != null && integral.getIgGoodsCount() <= 0) {
				response.setExchangeStatus(8);  // 商品库存为零，兑换失败   add by yuleijia on 2017.4.13
				return response;
			}
			response.setExchangeStatus(0);
		}
		return response;
	}

	@RequestMapping(value = "/integral/cancel", method = RequestMethod.POST)
	@MethodMapping(desc = "取消订单")
	public @ResponseBody
	IntegralResponse cancelIntegralOrder(@Valid @RequestParam(value = "id") @Param(desc = "订单id") Long id) {
		IntegralResponse response = new IntegralResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		IntegralGoodsOrder obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(id));

		// 取消订单返回积分 2016-12-24
		if (obj != null && obj.getIgoStatus() == 0 && uid.equals(obj.getIgoUserId())) {
			/*obj.setIgoStatus(-1);
			this.integralGoodsOrderService.update(obj);*/
			this.integralGoodsOrderService.integralGoodsOrderCancel(null, obj);
		}

		return response;
	}

	@RequestMapping(value = "/integral/order/cofirm", method = RequestMethod.POST)
	@MethodMapping(desc = "确认收货")
	public @ResponseBody
	IntegralResponse integralOrderCofirm(@Valid @RequestParam(value = "id") @Param(desc = "订单id") Long id) {
		IntegralResponse response = new IntegralResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && uid.equals(obj.getIgoUserId()) && obj.getIgoStatus() == 30) {
			obj.setIgoStatus(40);
			integralGoodsOrderService.update(obj);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/integral/order/details", method = RequestMethod.POST)
	@MethodMapping(desc = "订单详情")
	public @ResponseBody
	IntegralResponse orderDetails(@Valid @RequestParam(value = "id") @Param(desc = "订单id") Long id) {
		IntegralResponse response = new IntegralResponse();
		if (id == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 订单信息
		IntegralGoodsOrder obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null) {
			IntegralOrderDetailsBO details = mapper.map(obj, IntegralOrderDetailsBO.class);
			// 设置订单状态
			switch (details.getIgoStatus()) {
				case -1:
					details.setStatus("已取消");
					break;
				case 0:
					details.setStatus("待付款");
					break;
				case 20:
					details.setStatus("已付款，待发货");
					break;
				case 30:
					details.setStatus("已发货");
					break;
				case 40:
					details.setStatus("已收货完成");
					break;
			}
			// 设置支付方式
			if (obj != null) {
				if (StringUtils.isNotBlank(obj.getIgoPayment())) {
					if (obj.getIgoPayment().equals("alipay")) {
						details.setPayment("支付宝");
					} else if (obj.getIgoPayment().equals("alipay_wap")) {
						details.setPayment("手机网页支付宝");
					} else if (obj.getIgoPayment().equals("alipay_app")) {
						details.setPayment("手机支付宝APP");
					} else if (obj.getIgoPayment().equals("tenpay")) {
						details.setPayment("财付通");
					} else if (obj.getIgoPayment().equals("bill")) {
						details.setPayment("快钱");
					} else if (obj.getIgoPayment().equals("chinabank")) {
						details.setPayment("网银在线");
					} else if (obj.getIgoPayment().equals("balance")) {
						details.setPayment("云豆支付");
					} else if (obj.getIgoPayment().equals("no_fee")) {
						details.setPayment("无运费订单");
					} else if (obj.getIgoPayment().equals("wx_pay")) {
						details.setPayment("网页微信支付");
					} else if (obj.getIgoPayment().equals("wx_app")) {
						details.setPayment("app微信支付");
					}
				}
			}

			// 设置物流公司信息
			details.setExpressInfo(orderFormTools.queryExInfo(details.getIgoExpressInfo(),
					"express_company_name"));
			// 设置物流公司id
			details.setExpressCompanyId(orderFormTools.queryExInfo(details.getIgoExpressInfo(),
					"express_company_id"));

			// 设置礼品信息
			List<Map> map = orderFormTools.query_integral_goodsinfo(obj.getGoodsInfo());
			List<IGoBO> list = new ArrayList<IGoBO>();
			for (Map igo : map) {
				IGoBO bo = new IGoBO();
				bo.setImages(igo.get("ig_goods_img").toString());
				bo.setIgoName(igo.get("ig_goods_name").toString());
				double num = CommUtil.null2Double(igo.get("ig_goods_integral"));
				bo.setIgoInteral((int) num);
				bo.setId(CommUtil.null2Long(igo.get("id")));
				bo.setCount(CommUtil.null2Int(igo.get("ig_goods_count")));
				list.add(bo);
			}
			details.setIgoList(list);
			response.setDetails(details);
		}
		return response;
	}

	@RequestMapping(value = "/integral/good_count/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取商品库存")
	public @ResponseBody
	IntegralResponse getGoodsCount(
			@Valid @RequestParam(value = "ids") @Param(desc = "商品id,以‘，’号隔开") String ids) {
		IntegralResponse response = new IntegralResponse();
		if (StringUtils.isBlank(ids)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		String[] idsStr = ids.split(",");
		Long[] idsLong = new Long[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			idsLong[i] = CommUtil.null2Long(idsStr[i]);
		}
		List<IntegralGoodsBO> list = integralGoodsService.queryIntegralGoodsCountList(idsLong);
		List<IntegralGoodsDetailsBO> goodsListBos = MapperUtils.map(mapper, list,
				IntegralGoodsDetailsBO.class);
		response.setIntegralGoodsList(goodsListBos);
		return response;
	}
}
