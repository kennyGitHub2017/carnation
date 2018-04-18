package com.sinco.carnation.resource.web.actions.jiuye;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.druid.util.StringUtils;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.jiuye.config.JiuyeConfig;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.jiuye.utils.IdTypeHandler;
import com.sinco.carnation.resource.bo.jiuye.JiuyeOrderMO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.constant.ResultMsgConstant;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.jiuye.JiuyeOrderResponse;
import com.sinco.carnation.resource.web.response.jiuye.PayStateCheckResponse;

/**
 * 酒业订单业务
 * 
 * @author Administrator
 * 
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "酒业订单业务", namespace = "jiuyeOrder")
public class OrderAction extends BasicApiController {
	private static final Logger log = LoggerFactory
			.getLogger(OrderAction.class);
	@Autowired
	private JiuyeOrderFormService jiuyeOrderFormService;

	/***
	 * 根据订单ID获取订单信息
	 * 
	 * @param vo
	 * @param request
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/jiuye/order/detail", method = RequestMethod.POST)
	@MethodMapping(desc = "根据订单ID获取订单信息")
	@ResponseBody
	public JiuyeOrderResponse getOrderDetail(@Param String orderId,
			HttpServletRequest request) throws ServiceException {
		JiuyeOrderResponse response = new JiuyeOrderResponse();
		JiuyeOrderMO jiuyeOrderMO = new JiuyeOrderMO();

		if (StringUtils.isEmpty(orderId)) {
			log.info("orderId error:", orderId);
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			response.setM_errorMsg(ResultMsgConstant.PARAMETER_ERROR);
			return response;
		}
		// 验证参数
		JiuyeOrder jiuyeOrder = jiuyeOrderFormService.findByOrderId(CommUtil
				.null2Long(orderId));
		// 对象转换
		MapperUtils.copyProperties(jiuyeOrder, jiuyeOrderMO);
		// 封装酒业详情H5页面URL
		String encodeOrderId = IdTypeHandler
				.encode(CommUtil.null2Long(orderId));
		StringBuffer orderDetailUrl = new StringBuffer();
		orderDetailUrl.append(JiuyeConfig.getOrderDetailUrl()).append(
				encodeOrderId);
		jiuyeOrderMO.setOrderDetailUrl(orderDetailUrl.toString());
		// 酒业首页URL返回
		jiuyeOrderMO.setIndexUrl(JiuyeConfig.getIndexUrl());
		response.setJiuyeOrder(jiuyeOrderMO);
		return response;
	}

	/***
	 * 校验酒业订单支付状态
	 * 
	 * @param vo
	 * @param request
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/jiuye/state/check", method = RequestMethod.POST)
	@MethodMapping(desc = "验酒业订单支付状态")
	@ResponseBody
	public PayStateCheckResponse payStateCheck(@Param String orderId,
			HttpServletRequest request) throws ServiceException {
		PayStateCheckResponse response = new PayStateCheckResponse();

		// 校验IP地址是否合法
		// if (!checkIp(CommUtil.getIpAddr(request))) {
		// log.info("IP error:", CommUtil.getIpAddr(request));
		// response.setM_status(ResultCodeConstant.ERROR_STATUS);
		// response.setM_errorCode(ResultCodeConstant.CONNECTION_ERROR);
		// response.setM_errorMsg(ResultMsgConstant.CONNECTION_ERROR);
		// return response;
		// }

		if (StringUtils.isEmpty(orderId)) {
			log.info("orderId error:", orderId);
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			response.setM_errorMsg(ResultMsgConstant.PARAMETER_ERROR);
			return response;
		}

		// 验证参数
		JiuyeOrder result = jiuyeOrderFormService.payStateCheck(CommUtil
				.null2Long(orderId));

		if (null != result) {
			response.setHasPay(true);
			response.setPayTime(null != result.getPayTime() ? CommUtil
					.convertDateTimeToString(result.getPayTime()) : "");
		} else {
			response.setHasPay(false);

		}
		return response;
	}

	@SuppressWarnings("unused")
	private boolean checkIp(String ip) {
		String[] ips = JiuyeConfig.getWhiteListIp().split(",");
		if (null == ips) {
			return false;
		}
		if (!Arrays.asList(ips).contains(ip)) {
			return false;
		}
		return true;
	}

}
