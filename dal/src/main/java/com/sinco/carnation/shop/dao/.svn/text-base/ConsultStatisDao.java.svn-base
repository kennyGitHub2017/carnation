package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.ConsultStatisMapper;
import com.sinco.carnation.shop.model.ConsultStatis;
import com.sinco.carnation.shop.bo.ConsultStatisBO;
import com.sinco.carnation.shop.model.ConsultStatisExample;

@Repository
public class ConsultStatisDao {

	@Autowired
	private ConsultStatisMapper mapper;

	/** generate code begin **/
	public List<ConsultStatisBO> findAll() {
		ConsultStatisExample example = new ConsultStatisExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ConsultStatisExample example = new ConsultStatisExample();
		return mapper.countByExample(example);
	}

	public List<ConsultStatis> save(Iterable<ConsultStatis> entities) {
		List<ConsultStatis> list = new ArrayList<ConsultStatis>();
		for (ConsultStatis ConsultStatis : entities) {
			list.add(save(ConsultStatis));
		}
		return list;
	}

	public ConsultStatis save(ConsultStatis record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ConsultStatis record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ConsultStatisBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ConsultStatisBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ConsultStatisExample example = new ConsultStatisExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ConsultStatisBO> findAll(Iterable<Long> ids) {
		ConsultStatisExample example = new ConsultStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ConsultStatis entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ConsultStatis> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ConsultStatis entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ConsultStatisExample example = new ConsultStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ConsultStatisExample example = new ConsultStatisExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
