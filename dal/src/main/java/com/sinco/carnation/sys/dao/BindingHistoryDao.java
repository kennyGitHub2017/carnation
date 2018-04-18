package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.BindingHistoryMapper;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.bo.BindingHistoryBO;
import com.sinco.carnation.sys.model.BindingHistoryExample;

@Repository
public class BindingHistoryDao {

	@Autowired
	private BindingHistoryMapper mapper;

	/** generate code begin **/
	public List<BindingHistoryBO> findAll() {
		BindingHistoryExample example = new BindingHistoryExample();
		return mapper.selectByExample(example);
	}

	List<BindingHistoryBO> findAll(Iterable<Long> ids) {
		BindingHistoryExample example = new BindingHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		BindingHistoryExample example = new BindingHistoryExample();
		return mapper.countByExample(example);
	}

	public List<BindingHistory> save(Iterable<BindingHistory> entities) {
		List<BindingHistory> list = new ArrayList<BindingHistory>();
		for (BindingHistory BindingHistory : entities) {
			list.add(save(BindingHistory));
		}
		return list;
	}

	public BindingHistory save(BindingHistory record) {
		if (null != record.getId()) {
			mapper.updateByPrimaryKeySelective(record);
		} else {
			mapper.insertSelective(record);
		}
		return record;
	}

	public void update(BindingHistory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public BindingHistoryBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		BindingHistoryExample example = new BindingHistoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(BindingHistory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<BindingHistory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (BindingHistory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		BindingHistoryExample example = new BindingHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		BindingHistoryExample example = new BindingHistoryExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
