package com.sinco.carnation.elong.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.elong.bo.ElongOrderBO;
import com.sinco.carnation.elong.constants.ElongOrderConstants;
import com.sinco.carnation.elong.dao.ElongOrderDao;
import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.model.elong.GuaranteeRule;
import com.sinco.carnation.elong.model.elong.OrderDetailResult;
import com.sinco.carnation.elong.model.elong.ValueAdd;
import com.sinco.carnation.elong.model.h5.viewmodel.common.JsonResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.order.OrderSubmitRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.order.OrderSubmitResult;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.CardValidateRequest;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.PaySubmitRequest;
import com.sinco.carnation.elong.schedule.DefaultScheduleTask;
import com.sinco.carnation.elong.schedule.Schedule;
import com.sinco.carnation.elong.schedule.ThreadPool;
import com.sinco.carnation.elong.service.remote.impl.OrderService;
import com.sinco.carnation.elong.service.remote.impl.PayService;
import com.sinco.carnation.elong.util.DateUtil;
import com.sinco.carnation.elong.util.Tool;
import com.sinco.carnation.elong.vo.ElongOrderVO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class ElongOrderService {
	private Logger LOGGER = LoggerFactory.getLogger(ElongOrderService.class);
	@Autowired
	private ElongOrderDao elongOrderDao;
	@Autowired
	private OrderService orderService;
	@Autowired
	private PayService payService;
	@Autowired
	private GroupOrderService groupOrderService;
	

	/**
	 * 查询可分润的酒店订单
	 * 
	 * @return
	 */
	public List<ElongOrder> findRebateByElongOrderStatus() {
		return elongOrderDao.selectRebateByElongOrderStatus();
		
	}

	public List<ElongOrder> getElongOrderList(Long userId, MyPage<ElongOrderBO> page) {
		// 分页获取艺龙订单列表
		return elongOrderDao.queryElongOrderList(userId, page);

	}

	/**
	 * 获取需要的同步订单
	 * 
	 * @return
	 */
	public List<ElongOrder> querySynOrderList() {
		return elongOrderDao.querySynOrderList();
	}

	/**
	 * 根据主键ID查询订单信息
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 */
	public ElongOrder getById(Long id) {
		return elongOrderDao.getById(id);
	}

	/**
	 * 根据订单ID查询订单信息
	 * 
	 * @param orderId
	 *            订单ID
	 * @return
	 */
	public ElongOrder getByOrderId(Long orderId) {
		return elongOrderDao.getByOrderId(orderId);
	}

	/**
	 * 获取艺农订单详情（不包含酒店信息）
	 * 
	 * @param affiliateConfirmationId
	 *            联盟的订单编号
	 * @return
	 */
	public JsonResult<ElongOrder> getOrderInfo(String affiliateConfirmationId) {
		if (StringUtils.isEmpty(affiliateConfirmationId)) {
			return null;
		}
		JsonResult<ElongOrder> result = new JsonResult<ElongOrder>();
		// 获取艺农订单信息
		ResultInfo<OrderDetailResult> detailRet = orderService.getOrderInfo(affiliateConfirmationId);
		if (detailRet.getIsSuccess()) {
			result.setState(detailRet.getIsSuccess());
			result.setData(convert(detailRet.getData()));
		} else {
			result.setState(false);
			result.setMsg(detailRet.getMsg());
		}
		return result;
	}

	/**
	 * 根据ID更新订单信息
	 * 
	 * @param order
	 */
	public void updateById(ElongOrder order) {
		elongOrderDao.updateById(order);
	}

	/**
	 * 创建订单
	 * 
	 * @param orderRequest
	 * @return
	 * @throws JsonProcessingException
	 * @throws InterruptedException
	 */
	public ResultInfo<OrderSubmitResult> create(OrderSubmitRequest orderRequest)
			throws ServiceException, Exception {
		// 创建本地订单
		ElongOrder order = new ElongOrder();
		order.setHotelId(orderRequest.getHotelId());
		order.setRatePlanId(orderRequest.getRatePlanId());
		order.setRoomTypeId(orderRequest.getRoomTypeId());
		order.setArrivalDate(orderRequest.getArrivalDate());
		order.setDepartureDate(orderRequest.getDepartureDate());
		order.setNumberOfRooms(orderRequest.getNumberOfRooms());
		order.setLatestArrivalTime(orderRequest.getLatestArrivalTime());
		order.setAffiliateConfirmationId(orderRequest.getAffiliateConfirmationId());
		order.setNumberOfCustomers(orderRequest.getGuesterList().size());
		order.setPaymentType(orderRequest.getPaymentType());
		order.setUserId(orderRequest.getUserId());
		order.setCreateUser(String.valueOf(orderRequest.getUserId()));
		order.setCreateTime(new Date());
		order.setStatus(ElongOrderConstants.ELONG_ORDER_STATUS_N);
		order.setShowStatus("2048");
		elongOrderDao.save(order);
		// 创建艺农订单
		ResultInfo<OrderSubmitResult> result = orderService.submitOrder(orderRequest);
		if (!result.getIsSuccess()) {
			throw new ServiceException("-1", result.getMsg());
		}
		// 更新艺农返回订单信息
		ObjectMapper mapper = new ObjectMapper();
		HotelDetailViewModel hotelDetail = result.getData().getHotelDetail();
		order.setArrivalDate(orderRequest.getArrivalDate());
		order.setDepartureDate(orderRequest.getDepartureDate());
		order.setIsNeedPay(result.getData().getIsNeedPay());
		order.setPaymentDeadlineTime(result.getData().getPaymentDeadlineTime());
		order.setCancelTime(result.getData().getCancelTime());
		order.setGuaranteeAmount(result.getData().getGuaranteeAmount());
		order.setHotelId(hotelDetail.getHotelId());
		order.setHotelName(hotelDetail.getHotelName());
		order.setRoomTypeName(hotelDetail.getRoomList().get(0).getName());
		order.setTotalPrice(hotelDetail.getRoomList().get(0).getRatePlanList().get(0).getTotalRate()
				.multiply(new BigDecimal(orderRequest.getNumberOfRooms())));
		order.setOrderHotel(mapper.writeValueAsString(hotelDetail));
		if (hotelDetail.getValueAdds() != null) {
			List<String> dess = new ArrayList<String>();
			for (ValueAdd val : hotelDetail.getValueAdds()) {
				if (StringUtils.hasText(val.getDescription())) {
					dess.add(val.getDescription());
				}
			}
			order.setValueAdds(mapper.writeValueAsString(dess));
		}
		order.setHasInvoice(orderRequest.isNeedInvoice());
		if (orderRequest.getInvoice() != null) {
			order.setInvoice(mapper.writeValueAsString(orderRequest.getInvoice()));
		}
		elongOrderDao.updateById(order);
		result.getData().setId(order.getId());
		// 同步艺农订单状态
		Thread.sleep(3000);
		synOrder(order.getId());
		Schedule schedule = new Schedule(String.valueOf(order.getId()),
				String.valueOf(result.getData().getOrderId()), new Date());
		DefaultScheduleTask task = new DefaultScheduleTask(schedule, this);
		ThreadPool.getInstance().addSchedule(task);
		return result;
	}

	/**
	 * 将艺农订单转换为平台订单
	 * 
	 * @param orderDetail
	 * @return
	 * @throws JsonProcessingException
	 */
	public ElongOrder convert(OrderDetailResult orderDetail) {
		if (orderDetail == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		ElongOrder order = new ElongOrder();
		String[] ignore = {"contact", "extendInfo", "nightlyRates", "orderRooms", "penaltyCurrencyCode",
				"invoice", "creditCard", "guaranteeRule", "prepayRule", "valueAdds", "confirmationType",
				"currencyCode", "customerType", "invoiceMode", "isCancelable", "paymentType", "showStatus"};
		try {
			BeanUtils.copyProperties(orderDetail, order, ignore);
			if (orderDetail.getContact() != null) {
				order.setContact(mapper.writeValueAsString(orderDetail.getContact()));
			}
			if (orderDetail.getExtendInfo() != null) {
				order.setExtendInfo(mapper.writeValueAsString(orderDetail.getExtendInfo()));
			}
			if (orderDetail.getNightlyRates() != null) {
				order.setNightlyRates(mapper.writeValueAsString(orderDetail.getNightlyRates()));
			}
			if (orderDetail.getOrderRooms() != null) {
				order.setOrderRooms(mapper.writeValueAsString(orderDetail.getOrderRooms()));
			}
			if (orderDetail.getInvoice() != null) {
				order.setInvoice(mapper.writeValueAsString(orderDetail.getInvoice()));
			}
			if (orderDetail.getCreditCard() != null) {
				order.setCreditCard(mapper.writeValueAsString(orderDetail.getCreditCard()));
			}
			if (orderDetail.getGuaranteeRule() != null) {
				order.setGuaranteeRule(mapper.writeValueAsString(orderDetail.getGuaranteeRule()));
			}
			if (orderDetail.getPrepayRule() != null) {
				order.setPrepayRule(mapper.writeValueAsString(orderDetail.getPrepayRule()));
			}
			if (orderDetail.getValueAdds() != null) {
				order.setValueAdds(mapper.writeValueAsString(orderDetail.getValueAdds()));
			}
			order.setPenaltyCurrencyCode(orderDetail.getPenaltyCurrencyCode().value());
			order.setConfirmationType(orderDetail.getConfirmationType().value());
			order.setCurrencyCode(orderDetail.getCurrencyCode().value());
			order.setCustomerType(orderDetail.getCustomerType().value());
			order.setInvoiceMode(orderDetail.getInvoiceMode().value());
			order.setIsCancelable(orderDetail.isIsCancelable());
			order.setPaymentType(orderDetail.getPaymentType().value());
			order.setShowStatus(String.valueOf(orderDetail.getShowStatus()));
		} catch (Exception e) {
			LOGGER.error("对象模型转换失败", e);
		}
		return order;
	}

	/**
	 * 
	 * 产生代理方平台订单号 注：为了演示，此处的订单编号为12位日期时间+4位随机数； 代理商不必采用此生成规则，而应该根据自己的业务生成订单编号； 订单编号务必保证唯一性，否则在创建订单接口，会产生重单失败；
	 * 
	 * @return
	 */
	public String generatePlatOrderId(long userId) {
		String dateString = DateUtil.getCurrentDateStr("yyMMddHHmmss");
		String randomString = Tool.getRandomNumber(4);
		return dateString + randomString + userId;
	}

	/**
	 * 验证信用卡有效性
	 * 
	 * @param cardValidateReq
	 * @return
	 */
	public ResultInfo<Boolean> cardValidate(CardValidateRequest cardValidateReq) {
		return payService.validateCreditCard(cardValidateReq.getCardNo());
	}

	/**
	 * 订单支付
	 * 
	 * @param paySubmitReq
	 * @return
	 * @throws Exception
	 */
	public ResultInfo<Boolean> submitOrderPay(PaySubmitRequest paySubmitReq)
			throws ServiceException, Exception {
		// 验证信用卡是否可用
		CardValidateRequest cardValidateReq = new CardValidateRequest();
		cardValidateReq.setCardNo(paySubmitReq.getCardNo());
		ResultInfo<Boolean> result = cardValidate(cardValidateReq);
		if (result.getIsSuccess()) {
			result.setIsSuccess(false);
			if (result.getData()) {
				if (StringUtils.isEmpty(paySubmitReq.getCvv())) {
					result.setMsg("信用卡验证码不能为空");
					return result;
				}
			}
			// 提交订单信息
			result = payService.submitOrderPay(paySubmitReq);
			if (result.getIsSuccess()) {
				// 同步艺农订单状态
				Thread.sleep(3000);
				synOrder(paySubmitReq.getId());
				Schedule schedule = new Schedule(String.valueOf(paySubmitReq.getId()),
						String.valueOf(paySubmitReq.getOrderId()), new Date());
				DefaultScheduleTask task = new DefaultScheduleTask(schedule, this);
				ThreadPool.getInstance().addSchedule(task);
			}
		}
		return result;
	}

	/**
	 * 现步艺农服务器订单到本地数据库
	 * 
	 * @param id
	 *            订单ID
	 */
	public void synOrder(Long id) {
		LOGGER.info("艺农订单同步开始...ID=" + id);
		try {
			// 获取本地订单信息
			ElongOrder order = getById(id);
			if (order == null || ElongOrderConstants.ELONG_ORDER_STATUS_C.equals(order.getStatus())
					|| ElongOrderConstants.ELONG_ORDER_STATUS_D.equals(order.getStatus())
					|| StringUtils.isEmpty(order.getAffiliateConfirmationId())) {
				return;
			}
			// 获取艺农平台订单信息
			JsonResult<ElongOrder> result = getOrderInfo(order.getAffiliateConfirmationId());
			if (result.getState()) {
				ElongOrder elongOrder = result.getData();
				elongOrder.setId(order.getId());
				elongOrder.setLastUpdateTime(new Date());
				updateById(elongOrder);
				if("C".equals(elongOrder.getStatus())){
					//如果状态变为已结算，赠送积分
					LOGGER.info("艺农订回调赠送积分 进入{}",order.getId());
					System.out.println("艺农订回调赠送积分 进入{}"+order.getId()+"elongOrder.getTotalPrice"+elongOrder.getTotalPrice());
					this.groupOrderService.o2oShopSendIntegral(order.getUserId(), CommUtil.null2Double(elongOrder.getTotalPrice()));
				}
			} else {
				LOGGER.error("获取艺农订单失败：" + result.getMsg());
				/*if(result.getMsg() != null && result.getMsg().startsWith("H001054")){
					//订单不存在了
					if(!StringUtils.isEmpty(order.getOrderId())){
						order.setStatus("D");
						order.setShowStatus("256");
						order.setLastUpdateTime(new Date());
						updateById(order);
					}
				}*/
			}
		} catch (Exception e) {
			LOGGER.error("艺农订单同步失败", e);
		}
		LOGGER.info("艺农订单同步结束.ID=" + id);
	}

	/**
	 * 取消订单信息
	 * 
	 * @param order
	 */
	public void cancelOrder(ElongOrder order) throws ServiceException {
		// 艺龙取消订单
		Boolean result = orderService.cancelOrder(order.getOrderId());
		if (!result) {
			throw new ServiceException("cancel order error!");
		}
		// 更改本地库订单状态
		elongOrderDao.updateById(order);

	}

	/**
	 * 计算酒店预定规则
	 * 
	 * @param data
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Map<String, List<String>> calaRule(HotelDetailViewModel data) {
		Map<String, List<String>> ruleMap = new HashMap<String, List<String>>();
		// 担保规则
		GuaranteeRule guarRule = null;
		if (data.getGuaranteeRules() != null && data.getGuaranteeRules().size() > 0) {
			guarRule = data.getGuaranteeRules().get(0);
		}
		// 时间段担保
		int h = new Date().getHours();
		List<String> timeRules = new ArrayList<String>();
		for (int i = 14; i <= 30; i++) {
			if (h >= i) {
				continue;
			}
			int hour = i % 24;
			String rule = (hour < 10 ? "0" + hour : "" + hour) + ":00";
			if (hour < 7) {
				rule = "凌晨" + rule;
			}
			if (guarRule != null) {
				// 强制担保
				if (guarRule.isIsTimeGuarantee() == false && guarRule.isIsAmountGuarantee() == false) {
					rule += " 需担保";
				} else {
					if (guarRule.isIsTimeGuarantee()) {
						// 时间段担保
						int startGuar = Integer.parseInt(guarRule.getStartTime().split(":")[0]);
						int endGuar = Integer.parseInt(guarRule.getEndTime().split(":")[0]);
						if (endGuar < startGuar) {
							endGuar = startGuar + (24 - startGuar) + endGuar;
						}
						if (i > startGuar && i <= endGuar) {
							rule += " 需担保";
						}
					}
				}
			}
			timeRules.add(rule);
		}
		// 房间数量担保
		List<String> countRules = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			String rule = i + "间";
			if (guarRule != null) {
				if (guarRule.isIsAmountGuarantee()) {
					if (i >= guarRule.getAmount()) {
						rule += " 需担保";
					}
				}
			}
			countRules.add(rule);
		}
		ruleMap.put("timeRules", timeRules);
		ruleMap.put("countRules", countRules);
		return ruleMap;
	}
	
	public List<ElongOrderBO> findElongOrderVOs(ElongOrderVO vo,MyPage<ElongOrderBO> page){
		return elongOrderDao.findElongOrderVOs(vo,page);
	}
	
}
