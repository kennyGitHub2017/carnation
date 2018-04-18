package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.GoldLogMapper;
import com.sinco.carnation.user.model.GoldLog;
import com.sinco.carnation.user.bo.GoldLogBO;
import com.sinco.carnation.user.model.GoldLogExample;

@Repository
public class GoldLogDao {

	@Autowired
	private GoldLogMapper mapper;

	/** generate code begin **/
	public List<GoldLogBO> findAll() {
		GoldLogExample example = new GoldLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoldLogExample example = new GoldLogExample();
		return mapper.countByExample(example);
	}

	public List<GoldLog> save(Iterable<GoldLog> entities) {
		List<GoldLog> list = new ArrayList<GoldLog>();
		for (GoldLog GoldLog : entities) {
			list.add(save(GoldLog));
		}
		return list;
	}

	public GoldLog save(GoldLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoldLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoldLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoldLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoldLogExample example = new GoldLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoldLogBO> findAll(Iterable<Long> ids) {
		GoldLogExample example = new GoldLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoldLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoldLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoldLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoldLogExample example = new GoldLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoldLogExample example = new GoldLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
