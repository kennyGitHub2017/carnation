package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.OrderLogBO;
import com.sinco.carnation.shop.mapper.OrderLogMapper;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.model.OrderLogExample;

@Repository
public class OrderLogDao {

	@Autowired
	private OrderLogMapper mapper;

	/** generate code begin **/
	public List<OrderLog> findAll() {
		OrderLogExample example = new OrderLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		OrderLogExample example = new OrderLogExample();
		return mapper.countByExample(example);
	}

	public List<OrderLog> save(Iterable<OrderLog> entities) {
		List<OrderLog> list = new ArrayList<OrderLog>();
		for (OrderLog OrderLog : entities) {
			list.add(save(OrderLog));
		}
		return list;
	}

	public OrderLog save(OrderLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(OrderLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public OrderLog findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<OrderLog> queryByUserId(Long userId) {
		return mapper.queryByUserId(userId);
	}

	public List<OrderLogBO> queryByOrderId(Long orderId) {
		return mapper.queryByOrderId(orderId);
	}

	public OrderLog get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		OrderLogExample example = new OrderLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<OrderLog> findAll(Iterable<Long> ids) {
		OrderLogExample example = new OrderLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(OrderLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<OrderLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (OrderLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		OrderLogExample example = new OrderLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		OrderLogExample example = new OrderLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
