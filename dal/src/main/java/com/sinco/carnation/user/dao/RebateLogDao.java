package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.RebateLogMapper;
import com.sinco.carnation.user.model.RebateLog;
import com.sinco.carnation.user.bo.RebateLogBO;
import com.sinco.carnation.user.model.RebateLogExample;

@Repository
public class RebateLogDao {

	@Autowired
	private RebateLogMapper mapper;

	/** generate code begin **/
	public List<RebateLogBO> findAll() {
		RebateLogExample example = new RebateLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RebateLogExample example = new RebateLogExample();
		return mapper.countByExample(example);
	}

	public List<RebateLog> save(Iterable<RebateLog> entities) {
		List<RebateLog> list = new ArrayList<RebateLog>();
		for (RebateLog RebateLog : entities) {
			list.add(save(RebateLog));
		}
		return list;
	}

	public RebateLog save(RebateLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RebateLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RebateLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RebateLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RebateLogExample example = new RebateLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RebateLogBO> findAll(Iterable<Long> ids) {
		RebateLogExample example = new RebateLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RebateLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RebateLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RebateLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RebateLogExample example = new RebateLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RebateLogExample example = new RebateLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
