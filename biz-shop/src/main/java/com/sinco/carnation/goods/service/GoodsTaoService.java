package com.sinco.carnation.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.model.Goods;

/***
 * 根据淘宝链接添加商品
 * 
 * @author kenny
 * 
 */
@Service
public class GoodsTaoService {

	@Autowired
	private GoodsDao goodsDao;

	@SuppressWarnings("unused")
	private void insertGoods(Goods record) {
		this.goodsDao.save(record);
	}

}
