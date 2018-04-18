package com.sinco.carnation.resource.web.actions.elong;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.dozer.Mapper;
import org.nlpcn.commons.lang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.elong.bo.ElongOrderBO;
import com.sinco.carnation.elong.constants.ElongOrderConstants;
import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.service.ElongOrderService;
import com.sinco.carnation.elong.service.remote.IHotelService;
import com.sinco.carnation.elong.util.JsonUtil;
import com.sinco.carnation.resource.bo.elong.ElongOrderMO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.vo.elong.ElongContact;
import com.sinco.carnation.resource.vo.elong.ElongOrderVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.elong.ElongOrderResponse;
import com.sinco.carnation.resource.web.util.DateUtils;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "艺龙订单", namespace = "elong")
public class ElongOrderAction extends BasicApiController {

	@Autowired
	private ElongOrderService elongOrderService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/elong/order/list", method = RequestMethod.POST)
	@MethodMapping(desc = "艺龙订单列表")
	@ResponseBody
	public ElongOrderResponse getElongOrderList(@Valid @ModelAttribute @Param ElongOrderVO vo,
			HttpServletRequest request) {
		ElongOrderResponse response = new ElongOrderResponse();
		// 验证参数
		Long uid = ActionsUtil.getOwnerUid();
		if (null == uid || null == vo) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			response.setM_errorMsg(ResultMsgConstant.PARAMETER_ERROR);
			return response;
		}
		// 封装分页信息
		MyPage<ElongOrderBO> page = new MyPage<ElongOrderBO>();
		page.setPageSize(vo.getPageSize());
		page.setPageNumber(vo.getPageNum());

		// 分页获取艺龙订单列表
		elongOrderService.getElongOrderList(uid, page);

		List<ElongOrderMO> elongOrderList = MapperUtils.map(mapper, page.getContent(), ElongOrderMO.class);
		for (ElongOrderMO item : elongOrderList) {
			// 根据酒店ID获取酒店详情
			HotelDetailViewModel hotelDetailData = JsonUtil.jsonToObject(item.getOrderHotel(),
					HotelDetailViewModel.class);
			if (null != hotelDetailData) {
				// 酒店缩略图
				item.setThumbnailUrl(hotelDetailData.getThumbnailUrl());
				// 酒店电话
				item.setPhone(hotelDetailData.getPhone());
				// 日期差值（单位：天）
				item.setIntervalDay(hotelDetailData.getIntervalDay());
				// 酒店纬度
				item.setLatitude(hotelDetailData.getLatitude());
				// 酒店经度
				item.setLongitude(hotelDetailData.getLongitude());
				// 酒店地址
				item.setAddress(hotelDetailData.getAddress());
			}
			// 日期差值（单位：天）
			Integer intervalDay = (int) (DateUtils.getDifferenceBetweenDay(item.getDepartureDate(),
					item.getArrivalDate()));
			item.setIntervalDay(intervalDay);
		}
		response.setElongOrderList(elongOrderList);
		return response;
	}

	@RequestMapping(value = "/elong/cancel/order", method = RequestMethod.POST)
	@MethodMapping(desc = "取消艺龙订单")
	@ResponseBody
	public ElongOrderResponse cancelOrder(@Valid @ModelAttribute @Param ElongOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		ElongOrderResponse response = new ElongOrderResponse();

		ElongOrder elongOrder = elongOrderService.getByOrderId(CommUtil.null2Long(vo.getOrderId()));
		if (null == elongOrder) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.ORDER_NOT_EXIST);
			response.setM_errorMsg(ResultMsgConstant.ORDER_NOT_EXIST);
			return response;
		}

		if (elongOrder.getIsCancelable()) {// 判断此订单是否可取消
			// 取消的订单
			elongOrder.setStatus(ElongOrderConstants.ELONG_ORDER_STATUS_E);
			elongOrder.setShowStatus(ElongOrderConstants.ELONG_ORDER_SHOW_STATUS_CANCEL);
			try {
				elongOrderService.cancelOrder(elongOrder);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return response;
	}

	@RequestMapping(value = "/elong/delete/order", method = RequestMethod.POST)
	@MethodMapping(desc = "删除艺龙订单")
	@ResponseBody
	public ElongOrderResponse deleteOrder(@Valid @ModelAttribute @Param ElongOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		ElongOrderResponse response = new ElongOrderResponse();

		ElongOrder elongOrder = elongOrderService.getByOrderId(CommUtil.null2Long(vo.getOrderId()));

		if (null == elongOrder) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.ORDER_NOT_EXIST);
			response.setM_errorMsg(ResultMsgConstant.ORDER_NOT_EXIST);
			return response;
		}

		// 删除的订单状态必须为取消
		if (!ElongOrderConstants.ELONG_ORDER_STATUS_E.equals(elongOrder.getStatus())
				&& !ElongOrderConstants.ELONG_ORDER_STATUS_C.equals(elongOrder.getStatus())) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.ORDER_STATUS_ERROR);
			response.setM_errorMsg(ResultMsgConstant.ORDER_STATUS_ERROR);
			return response;
		}

		// 删除已取消的订单
		elongOrder.setIsDelete(1);
		elongOrderService.updateById(elongOrder);
		return response;
	}

	@RequestMapping(value = "/get/elong/order/by/orderId", method = RequestMethod.POST)
	@MethodMapping(desc = "根据ID获取艺龙订单")
	@ResponseBody
	public ElongOrderResponse getOrderById(@Valid @ModelAttribute @Param ElongOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		ElongOrderResponse response = new ElongOrderResponse();

		ElongOrder elongOrder = elongOrderService.getByOrderId(CommUtil.null2Long(vo.getOrderId()));
		if (null == elongOrder) {
			return response;
		}

		ElongOrderMO em = new ElongOrderMO();
		// 对象转换
		MapperUtils.copyProperties(elongOrder, em);
		if (null != em) {
			HotelDetailViewModel hotelDetailData = JsonUtil.jsonToObject(em.getOrderHotel(),
					HotelDetailViewModel.class);
			if (null != hotelDetailData) {
				// 酒店电话
				em.setPhone(hotelDetailData.getPhone());
				// 日期差值（单位：天）
				em.setIntervalDay(hotelDetailData.getIntervalDay());
				// 酒店纬度
				em.setLatitude(hotelDetailData.getLatitude());
				// 酒店经度
				em.setLongitude(hotelDetailData.getLongitude());
				// 酒店地址
				em.setAddress(hotelDetailData.getAddress());
			}
		}
		// 获取用户信息
		if (StringUtil.isNotBlank(elongOrder.getContact())) {
			ElongContact elongContact = JsonUtil.jsonToObject(elongOrder.getContact(), ElongContact.class);
			em.setUserName(elongContact.getName());
			em.setMobile(elongContact.getMobile());
		}
		response.setElongOrder(em);
		return response;
	}
}
