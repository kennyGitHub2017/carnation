package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.PrepareMoneyLogMapper;
import com.sinco.carnation.user.model.PrepareMoneyLog;
import com.sinco.carnation.user.bo.PrepareMoneyLogBO;
import com.sinco.carnation.user.model.PrepareMoneyLogExample;

@Repository
public class PrepareMoneyLogDao {

	@Autowired
	private PrepareMoneyLogMapper mapper;

	/** generate code begin **/
	public List<PrepareMoneyLogBO> findAll() {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		return mapper.selectByExample(example);
	}

	List<PrepareMoneyLogBO> findAll(Iterable<Long> ids) {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		return mapper.countByExample(example);
	}

	public List<PrepareMoneyLog> save(Iterable<PrepareMoneyLog> entities) {
		List<PrepareMoneyLog> list = new ArrayList<PrepareMoneyLog>();
		for (PrepareMoneyLog PrepareMoneyLog : entities) {
			list.add(save(PrepareMoneyLog));
		}
		return list;
	}

	public PrepareMoneyLog save(PrepareMoneyLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PrepareMoneyLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PrepareMoneyLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PrepareMoneyLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PrepareMoneyLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PrepareMoneyLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PrepareMoneyLogExample example = new PrepareMoneyLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
