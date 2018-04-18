package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.mapper.PaymentMapper;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.PaymentExample;

@Repository
public class PaymentDao {

	@Autowired
	private PaymentMapper mapper;

	public PaymentBO findByMark(String mark) {
		return findByMark(mark, null);
	}

	public PaymentBO findByMark(String mark, Boolean install) {
		PaymentExample example = new PaymentExample();
		PaymentExample.Criteria c = example.createCriteria();
		c.andMarkEqualTo(mark);
		if (install != null) {
			c.andInstallEqualTo(install);
		}
		List<PaymentBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public List<PaymentBO> findByMark(String[] notMarks, Boolean install) {
		PaymentExample example = new PaymentExample();
		PaymentExample.Criteria c = example.createCriteria();
		c.andMarkNotIn(Lists.newArrayList(notMarks));
		if (install != null) {
			c.andInstallEqualTo(install);
		}
		return mapper.selectByExampleWithBLOBs(example);
	}

	public List<Payment> findInstalledAll() {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andInstallEqualTo(true).andDeleteStatusEqualTo(0);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<Payment> findAll() {
		PaymentExample example = new PaymentExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PaymentExample example = new PaymentExample();
		return mapper.countByExample(example);
	}

	public List<Payment> save(Iterable<Payment> entities) {
		List<Payment> list = new ArrayList<Payment>();
		for (Payment Payment : entities) {
			list.add(save(Payment));
		}
		return list;
	}

	public Payment save(Payment record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Payment record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Payment findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Payment get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Payment> findAll(Iterable<Long> ids) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Payment entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Payment> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Payment entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PaymentExample example = new PaymentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PaymentExample example = new PaymentExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
