package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.EnoughReduceMapper;
import com.sinco.carnation.shop.model.EnoughReduce;
import com.sinco.carnation.shop.bo.EnoughReduceBO;
import com.sinco.carnation.shop.model.EnoughReduceExample;

@Repository
public class EnoughReduceDao {

	@Autowired
	private EnoughReduceMapper mapper;

	/** generate code begin **/
	public List<EnoughReduceBO> findAll() {
		EnoughReduceExample example = new EnoughReduceExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		EnoughReduceExample example = new EnoughReduceExample();
		return mapper.countByExample(example);
	}

	public List<EnoughReduce> save(Iterable<EnoughReduce> entities) {
		List<EnoughReduce> list = new ArrayList<EnoughReduce>();
		for (EnoughReduce EnoughReduce : entities) {
			list.add(save(EnoughReduce));
		}
		return list;
	}

	public EnoughReduce save(EnoughReduce record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(EnoughReduce record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public EnoughReduceBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public EnoughReduceBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		EnoughReduceExample example = new EnoughReduceExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<EnoughReduceBO> findAll(Iterable<Long> ids) {
		EnoughReduceExample example = new EnoughReduceExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(EnoughReduce entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<EnoughReduce> entities) {
		List<Long> ids = Lists.newArrayList();
		for (EnoughReduce entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		EnoughReduceExample example = new EnoughReduceExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		EnoughReduceExample example = new EnoughReduceExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
