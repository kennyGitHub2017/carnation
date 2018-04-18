package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.enums.EmShopQrOrderPayStatus;
import com.sinco.carnation.shop.mapper.ShopQrPayOrderMapper;
import com.sinco.carnation.shop.model.ShopQrPayOrder;
import com.sinco.carnation.shop.model.ShopQrPayOrderExample;

@Repository
public class ShopQrPayOrderDao {

	@Autowired
	private ShopQrPayOrderMapper mapper;

	/** generate code begin **/
	public List<ShopQrPayOrderBO> findAll() {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		return mapper.selectByExample(example);
	}

	List<ShopQrPayOrderBO> findAll(Iterable<Long> ids) {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		return mapper.countByExample(example);
	}

	public List<ShopQrPayOrder> save(Iterable<ShopQrPayOrder> entities) {
		List<ShopQrPayOrder> list = new ArrayList<ShopQrPayOrder>();
		for (ShopQrPayOrder ShopQrPayOrder : entities) {
			list.add(save(ShopQrPayOrder));
		}
		return list;
	}

	public ShopQrPayOrder save(ShopQrPayOrder record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ShopQrPayOrder record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ShopQrPayOrderBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ShopQrPayOrder entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ShopQrPayOrder> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ShopQrPayOrder entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public ShopQrPayOrderBO getOrderByPayOrderNo(String payOrderNo) {

		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		example.createCriteria().andPayOrderNoEqualTo(payOrderNo);
		List<ShopQrPayOrderBO> list = mapper.selectByExample(example);

		if (list.size() > 0)
			return list.get(0);

		return null;
	}

	public int updateByPayState(ShopQrPayOrder record) {
		return this.mapper.updateByPayState(record);
	}

	public BigDecimal findAllPaySuccessMoney(Long sellerId, Date startTime, Date endTime) {
		BigDecimal money = mapper.findAllPaySuccessMoney(sellerId, startTime, endTime);
		if (money == null) {
			money = new BigDecimal(0);
		}
		return money;
	}

	public List<ShopQrPayOrderBO> queryUnpaySuccessOrder() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, -2);
		Date startTime = calendar.getTime();
		
		calendar.setTime(now);
		calendar.add(Calendar.MINUTE, -30);
		Date endTime = calendar.getTime();
		
		ShopQrPayOrderExample example = new ShopQrPayOrderExample();
		example.createCriteria().andPayStatusEqualTo((byte)EmShopQrOrderPayStatus.NoPay.getValue()).andCreateTimeBetween(startTime, endTime);
		return mapper.selectByExample(example);
	}
}
