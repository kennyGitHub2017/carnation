package com.sinco.carnation.order.tools;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: OrderTools.java
 * </p>
 * 
 * <p>
 * Description: 卖家中心订单处理工具类，用来计算订单收货倒计时等等功能
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-11-12
 * 
 * @version 1.0.1
 */
@Component
public class OrderTools {
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private SysConfigService configService;

	public Date cal_confirm_time(String order_id) {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		if (obj != null && obj.getShipTime() != null) {
			Date ship_time = obj.getShipTime();
			Calendar cal = Calendar.getInstance();
			cal.setTime(ship_time);
			cal.add(Calendar.DAY_OF_YEAR,
					this.configService.getSysConfig().getAutoOrderConfirm() + obj.getOrderConfirmDelay());
			Date confirm_time = cal.getTime();
			return confirm_time;
		} else
			return null;
	}

	/**
	 * @param sellerId
	 * @return
	 */
	public String generateShopQrPayOrderNo(Long sellerId) {
		Random random = new Random();
		String order_suffix = CommUtil.formatTime("yyyyMMddHHmmssSSS", new Date());
		return "life" + sellerId + order_suffix + random.nextInt(10) + random.nextInt(10)
				+ random.nextInt(10);
	}
}
