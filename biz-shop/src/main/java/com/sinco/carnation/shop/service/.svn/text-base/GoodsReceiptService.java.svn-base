package com.sinco.carnation.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.GoodsReceiptBO;
import com.sinco.carnation.shop.dao.GoodsReceiptDao;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GoodsReceiptService {

	@Autowired
	private GoodsReceiptDao goodsReceiptDao;

	public void findGoodsReceiptList(MyPage<GoodsReceiptBO> page, Long goodsId) {
		goodsReceiptDao.findGoodsReceiptList(page, goodsId);
	}
}
