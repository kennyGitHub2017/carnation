package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.UserHealthtaskSignlogBO;
import com.sinco.carnation.sns.mapper.UserHealthtaskSignlogMapper;
import com.sinco.carnation.sns.model.UserHealthtaskSignlog;
import com.sinco.carnation.sns.model.UserHealthtaskSignlogExample;

@Repository
public class UserHealthtaskSignlogDao {

	@Autowired
	private UserHealthtaskSignlogMapper mapper;

	/** generate code begin **/
	public List<UserHealthtaskSignlogBO> findAll() {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		return mapper.selectByExample(example);
	}

	List<UserHealthtaskSignlogBO> findAll(Iterable<Long> ids) {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		return mapper.countByExample(example);
	}

	public List<UserHealthtaskSignlog> save(Iterable<UserHealthtaskSignlog> entities) {
		List<UserHealthtaskSignlog> list = new ArrayList<UserHealthtaskSignlog>();
		for (UserHealthtaskSignlog UserHealthtaskSignlog : entities) {
			list.add(save(UserHealthtaskSignlog));
		}
		return list;
	}

	public UserHealthtaskSignlog save(UserHealthtaskSignlog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserHealthtaskSignlog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserHealthtaskSignlogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserHealthtaskSignlog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserHealthtaskSignlog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserHealthtaskSignlog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserHealthtaskSignlogExample example = new UserHealthtaskSignlogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<UserHealthtaskSignlogBO> selectByCondition(UserHealthtaskSignlog record) {
		return this.mapper.selectByCondition(record);
	}
}
