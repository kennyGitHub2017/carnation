package com.sinco.carnation.pay.tools;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.dao.PaymentDao;

/**
 * 
 * <p>
 * Title: PaymentTools.java
 * </p>
 * 
 * <p>
 * Description: 支付方式处理工具类，用来管理支付方式信息，主要包括查询支付方式等
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
 * @date 2014-5-25
 * 
 * @version 1.0.1
 */
@Component
public class PaymentTools {
	@Autowired
	private PaymentDao paymentDao;

	public boolean queryPayment(String mark) {
		PaymentBO payment = paymentDao.findByMark(mark);

		if (payment != null) {
			return payment.getInstall();
		} else
			return false;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map queryShopPayment(String mark) {
		Map ret = Maps.newHashMap();
		PaymentBO payment = paymentDao.findByMark(mark);
		if (payment != null) {
			ret.put("install", payment.getInstall());
			ret.put("content", payment.getContent());
		} else {
			ret.put("install", false);
			ret.put("content", "");
		}
		return ret;
	}
}
