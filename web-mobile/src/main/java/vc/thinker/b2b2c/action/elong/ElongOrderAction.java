package vc.thinker.b2b2c.action.elong;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sinco.api.annotation.Param;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.elong.constants.ElongOrderConstants;
import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.model.h5.viewmodel.common.JsonResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.order.OrderSubmitRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.order.OrderSubmitResult;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.CardValidateRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.PaySubmitRequest;
import com.sinco.carnation.elong.service.ElongOrderService;
import com.sinco.carnation.elong.service.remote.IHotelService;
import com.sinco.carnation.elong.util.DateUtil;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.common.utils.IPUtil;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.model.elong.vo.OrderCreateRequestVO;
import vc.thinker.b2b2c.model.elong.vo.OrderSubmitRequestVO;
import vc.thinker.b2b2c.model.elong.vo.PaySubmitRequestVO;

/**
 * 艺龙订单模块
 * 
 * @author yuanming
 * 
 */
@Controller
public class ElongOrderAction {
	private static Logger LOOGER = LoggerFactory.getLogger(ElongOrderAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ElongOrderService elongOrderService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private UserService userService;
	@Autowired
	private Mapper mapper;

	
	/**
	 * 提交订单信息
	 * @param orderRequest
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/elong/order/submit.htm", method = RequestMethod.GET)
	public ModelAndView submit(@Valid @ModelAttribute @Param OrderSubmitRequestVO orderRequest, BindingResult result, 
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("forward:/v1/elong_hotel_list.htm");
		if(result.hasErrors()){
			mv.addObject("errorMsg", result.getAllErrors().get(0).getDefaultMessage());
			return mv;
		}
		if(orderRequest.getArrivalDate().getTime() > orderRequest.getDepartureDate().getTime()){
			mv.addObject("errorMsg", "入住时间不能大于离店时间");
			return mv;
		}
		if(!"SelfPay".equals(orderRequest.getPaymentType()) && !"Prepay".equals(orderRequest.getPaymentType())){
			mv.addObject("errorMsg", "不支持当前支付方式");
			return mv;
		}
		try{
			ResultInfo<HotelDetailViewModel> hotelDetail = hotelService.getHotelDetail(orderRequest.getHotelId(), orderRequest.getArrivalDate(), orderRequest.getDepartureDate(), orderRequest.getRatePlanId(), orderRequest.getRoomTypeId());
			if(!hotelDetail.getIsSuccess()){
				mv.addObject("errorMsg", hotelDetail.getMsg());
				return mv;
			}
			mv = new JModelAndView("hotel/order_submit.html", configService.getSysConfig(), 1, request, response); 
			mv.addObject("hotelDetail", hotelDetail.getData());
			mv.addObject("arrivalDateStr", getDateForChinese(hotelDetail.getData().getArrivalDate()));
			mv.addObject("departureDateStr", getDateForChinese(hotelDetail.getData().getDepartureDate()));
			//计算酒店预定时间
			Map<String, List<String>> rules = elongOrderService.calaRule(hotelDetail.getData());
			mv.addObject("rules", rules);
		}catch(Exception e){
			LOOGER.error("获取酒店详情失败", e);
			mv.addObject("errorMsg", "获取酒店详情失败");
			return mv;
		}
		mv.addObject("orderRequest", orderRequest);
		return mv;
	}

	/**
	 * 创建订单
	 * @param orderRequest
	 * @param result
	 * @param request 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/elong/order/create.htm", method = RequestMethod.POST)
	@ResponseBody
	public String create(@Valid @ModelAttribute @Param OrderCreateRequestVO orderRequest, BindingResult result, HttpServletRequest request) {
		JsonResult<OrderSubmitResult> orderResponse = new JsonResult<OrderSubmitResult>();
		if(result.hasErrors()){
			orderResponse.setMsg(result.getAllErrors().get(0).getDefaultMessage());
			return JSONObject.toJSONString(orderResponse);
		}
		if(orderRequest.getArrivalDate().getTime() > orderRequest.getDepartureDate().getTime()){
			orderResponse.setMsg("入住时间不能大于离店时间");
			return JSONObject.toJSONString(orderResponse);
		}
		if(!"SelfPay".equals(orderRequest.getPaymentType()) && !"Prepay".equals(orderRequest.getPaymentType())){
			orderResponse.setMsg("不支持当前支付方式");
			return JSONObject.toJSONString(orderResponse);
		}
		Date latestArrivalTime = DateUtil.getDateTimeFormat(orderRequest.getLatestArrivalTimeString(), "yyyy-MM-dd HH:mm:ss");
		if(latestArrivalTime.getHours() <= 6){
			latestArrivalTime = DateUtil.addDate(latestArrivalTime, 1);
		}
		if(latestArrivalTime.before(new Date())){
			orderResponse.setMsg("最早或最晚到店时间必须大于当前时间");
			return JSONObject.toJSONString(orderResponse);
		}
		Long userId = SecurityUserHolder.getCurrentUserId();
		UserBO user = userService.getObjById(userId);
		if(user == null){
			orderResponse.setMsg("连接超时，请重新进入酒店页面");
			return JSONObject.toJSONString(orderResponse);
		}
		//Long userId = 110l;
		OrderSubmitRequest orderSubmitRequest = mapper.map(orderRequest, OrderSubmitRequest.class);
		orderSubmitRequest.setUserId(userId);
		orderSubmitRequest.setCustomerIPAddress(IPUtil.getIpAddr(request));
		orderSubmitRequest.setAffiliateConfirmationId(elongOrderService.generatePlatOrderId(userId));
		orderSubmitRequest.setLatestArrivalTime(latestArrivalTime);
		
		try {
			ResultInfo<OrderSubmitResult> submitRet = elongOrderService.create(orderSubmitRequest);
			if(submitRet.getIsSuccess()){
				orderResponse.setData(submitRet.getData());
				orderResponse.setState(true);
				orderResponse.setMsg("订单创建成功");
			}else {
				orderResponse.setState(false);
				orderResponse.setMsg(submitRet.getMsg());
			}
		} catch (ServiceException e) { 
			LOOGER.error("创建订单异常", e);
			orderResponse.setState(false);
			orderResponse.setErrorCode(e.getErrorCode());
			orderResponse.setMsg(e.getMessage());
		} catch(Exception e) {
			LOOGER.error("创建订单异常", e);
			orderResponse.setState(false);
			orderResponse.setErrorCode("-1");
			orderResponse.setMsg("创建订单失败");
		}
		return JSONObject.toJSONString(orderResponse);
	}
	
	/**
	 * 测试专用，同步订单数据到本地数据库，不用等定时器刷新
	 * @param id 订单主键ID
	 * @return
	 */
	@RequestMapping(value = "/elong/order/syn.htm", method = RequestMethod.GET)
	@ResponseBody
	public String syn(Long id) {
		elongOrderService.synOrder(id);
		return "ok";
	}
	
	/**
	 * 去支付页面，如果为现付订单，去完成页面
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/v1/elong/order/toPay.htm", method = RequestMethod.GET)
	public ModelAndView toPay(Long id, Boolean isNeedPay, String paymentType, 
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(SecurityUserHolder.getCurrentUserId() + "===============================");
		//默认为支付完成页面
		ModelAndView mv = new JModelAndView("hotel/order_complete.html", configService.getSysConfig(), 1, request, response);
		//跳转到支付页面
		ElongOrder orderDetail = elongOrderService.getById(id);
		if(isNeedPay == null){
			isNeedPay = orderDetail.getIsNeedPay();
		}
		if(isNeedPay){
			if("card".equals(paymentType)){
				mv = new JModelAndView("hotel/order_card_pay.html", configService.getSysConfig(), 1, request, response);
			}else {
				mv = new JModelAndView("hotel/order_pay.html", configService.getSysConfig(), 1, request, response);
			}
		}
		mv.addObject("orderDetail", orderDetail);
		mv.addObject("arrivalDateStr", getDateForChinese(CommUtil.formatShortDate(orderDetail.getArrivalDate())));
		mv.addObject("departureDateStr", getDateForChinese(CommUtil.formatShortDate(orderDetail.getDepartureDate())));
		mv.addObject("arrivalDate", CommUtil.formatShortDate(orderDetail.getArrivalDate()));
		mv.addObject("departureDate", CommUtil.formatShortDate(orderDetail.getDepartureDate()));
		mv.addObject("intervalDay", DateUtil.getDifferenceBetweenDay(orderDetail.getDepartureDate(), orderDetail.getArrivalDate()));
		if(!StringUtils.isEmpty(orderDetail.getValueAdds())){
			mv.addObject("valueAdds", orderDetail.getValueAdds().replace("[", "").replace("]", "").replace("\"", ""));
		}
		if(!StringUtils.isEmpty(orderDetail.getPrepayRule())){
			mv.addObject("prepayRule", JSONObject.parseObject(orderDetail.getPrepayRule()).getString("description"));
		}
		if(!StringUtils.isEmpty(orderDetail.getGuaranteeRule())){
			mv.addObject("guaranteeRule", JSONObject.parseObject(orderDetail.getGuaranteeRule()).getString("description"));
		}
		mv.addObject("totalPrice", orderDetail.getTotalPrice());
		if(orderDetail.getIsNeedPay() && orderDetail.getGuaranteeAmount() != null 
				&& orderDetail.getGuaranteeAmount().compareTo(BigDecimal.ZERO) > 0){
			mv.addObject("totalPrice", orderDetail.getGuaranteeAmount());
			mv.addObject("isGuarantee", "true");
		}
		return mv;
	}
	
	/**
	 * 信用卡验证
	 * @param cardValidateReq
	 * @return
	 */
	@RequestMapping(value = "/elong/order/cardValidate.htm", method = RequestMethod.POST)
	@ResponseBody
	public String cardValidate(CardValidateRequest cardValidateReq) {
		JsonResult<Boolean> result = new JsonResult<Boolean>();
		if(StringUtils.isEmpty(cardValidateReq.getCardNo()) || cardValidateReq.getCardNo().trim().length() > 20){
			result.setMsg("卡号不正确");
			return JSONObject.toJSONString(result);
		}
		try {
			ResultInfo<Boolean> validateReq = elongOrderService.cardValidate(cardValidateReq);
			result.setData(validateReq.getData());
			result.setState(validateReq.getIsSuccess());
			result.setMsg(validateReq.getMsg());
		} catch (Exception e) {
			LOOGER.error("验证信息卡异常", e);
			result.setState(false);
			result.setMsg("验证信息卡异常");
		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 订单支付（信用卡）
	 * @param paySubmitReq
	 * @return
	 */
	@RequestMapping(value = "/elong/order/pay.htm", method = RequestMethod.POST)
	@ResponseBody
	public String pay(@Valid @ModelAttribute @Param PaySubmitRequestVO payRequest) {
		JsonResult<Boolean> result = new JsonResult<Boolean>();
		//查询当前订单是否属于当前用户
		Long userId = SecurityUserHolder.getCurrentUserId();
		UserBO user = userService.getObjById(userId);
		if(user == null){
			result.setMsg("连接超时，请重新进入酒店页面");
			return JSONObject.toJSONString(result);
		}
		//Long userId = 110l;
		ElongOrder order = elongOrderService.getById(payRequest.getId());
		if(order == null || !userId.equals(order.getUserId()) || !payRequest.getOrderId().equals(order.getOrderId())){
			result.setMsg("订单不存在");
			return JSONObject.toJSONString(result);
		}
		if(order.getIsNeedPay() != null && !order.getIsNeedPay()){
			result.setMsg("当前订单为到店支付");
			return JSONObject.toJSONString(result);
		}
		if(order.getPaymentDeadlineTime() != null && order.getPaymentDeadlineTime().before(new Date())){
			result.setMsg("订单已失效，请重新下单");
			return JSONObject.toJSONString(result);
		}
		if(ElongOrderConstants.ELONG_ORDER_STATUS_C.equals(order.getStatus()) || ElongOrderConstants.ELONG_ORDER_STATUS_D.equals(order.getStatus())){
			result.setMsg("订单状态异常，支付失败");
			return JSONObject.toJSONString(result);
		}
		
		PaySubmitRequest paySubmitReq = mapper.map(payRequest, PaySubmitRequest.class);
		try{
			//支付请求
			ResultInfo<Boolean> payRet = elongOrderService.submitOrderPay(paySubmitReq);
			result.setMsg(payRet.getMsg());
			result.setState(payRet.getIsSuccess());
			result.setData(payRet.getData());
		}catch (ServiceException e) {
			LOOGER.error("支付请求异常", e);
			result.setState(false);
			result.setErrorCode(e.getErrorCode());
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			LOOGER.error("支付请求异常", e);
			result.setState(false);
			result.setErrorCode("-1");
			result.setMsg("订单支付失败");
		}
		return JSONObject.toJSONString(result);
	}
	
	public String getDateForChinese(String dateStr){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		String today = df.format(now.getTime());
		
		now.add(Calendar.DATE, 1);
		String tomorrow = df.format(now.getTime());
		
		now.add(Calendar.DATE, 1);
		String afterTomorrow = df.format(now.getTime());
		
		if(today.equals(dateStr)){
			return "今天";
		}else if(tomorrow.equals(dateStr)){
			return "明天";
		}else if(afterTomorrow.equals(dateStr)){
			return "后天";
		}
		return dateStr;
	}

}
