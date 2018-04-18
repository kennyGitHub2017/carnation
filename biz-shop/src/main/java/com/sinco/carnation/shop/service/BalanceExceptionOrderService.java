package com.sinco.carnation.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.shop.bo.BalanceExceptionOrderBO;
import com.sinco.carnation.shop.dao.BalanceExceptionOrderDao;
import com.sinco.carnation.shop.model.BalanceExceptionOrder;

@Service
public class BalanceExceptionOrderService {
	@Autowired
	private BalanceExceptionOrderDao balanceExceptionOrderDao;

	public void save(BalanceExceptionOrder exOrder) {
		balanceExceptionOrderDao.save(exOrder);
	}

	public List<BalanceExceptionOrderBO> queryExceptionOrder() {
		return balanceExceptionOrderDao.queryExceptionOrder();
	}

	public void update(BalanceExceptionOrderBO order) {
		balanceExceptionOrderDao.update(order);
	}

}
