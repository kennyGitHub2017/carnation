package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.CircleClassMapper;
import com.sinco.carnation.sns.model.CircleClass;
import com.sinco.carnation.sns.model.CircleClassExample;

@Repository
public class CircleClassDao {

	@Autowired
	private CircleClassMapper mapper;

	public List<CircleClass> findAll() {
		CircleClassExample example = new CircleClassExample();
		return mapper.selectByExample(example);
	}

	public List<CircleClass> save(Iterable<CircleClass> entities) {
		List<CircleClass> list = new ArrayList<CircleClass>();
		for (CircleClass CircleClass : entities) {
			list.add(save(CircleClass));
		}
		return list;
	}

	public CircleClass save(CircleClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CircleClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CircleClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CircleClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CircleClassExample example = new CircleClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CircleClass> findAll(Iterable<Long> ids) {
		CircleClassExample example = new CircleClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		CircleClassExample example = new CircleClassExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CircleClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CircleClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CircleClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CircleClassExample example = new CircleClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CircleClassExample example = new CircleClassExample();
		mapper.deleteByExample(example);
	}

}
