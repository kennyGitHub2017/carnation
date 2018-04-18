package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.CheckResultHistoryBO;
import com.sinco.carnation.user.mapper.CheckResultHistoryMapper;
import com.sinco.carnation.user.model.CheckResultHistory;
import com.sinco.carnation.user.model.CheckResultHistoryExample;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckResultHistoryDao {

	@Autowired
	private CheckResultHistoryMapper mapper;

	public List<CheckResultHistoryBO> findPageByUserId(Long userId, MyPage<CheckResultHistoryBO> page) {
		return mapper.selectPageByUserId(userId, page);
	}

	/** generate code begin **/
	public List<CheckResultHistory> findAll() {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		return mapper.countByExample(example);
	}

	public List<CheckResultHistory> save(Iterable<CheckResultHistory> entities) {
		List<CheckResultHistory> list = new ArrayList<CheckResultHistory>();
		for (CheckResultHistory CheckResultHistory : entities) {
			list.add(save(CheckResultHistory));
		}
		return list;
	}

	public CheckResultHistory save(CheckResultHistory record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CheckResultHistory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CheckResultHistory findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckResultHistory get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CheckResultHistory> findAll(Iterable<Long> ids) {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CheckResultHistory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CheckResultHistory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CheckResultHistory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CheckResultHistoryExample example = new CheckResultHistoryExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
