package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.UserShareMapper;
import com.sinco.carnation.user.model.UserShare;
import com.sinco.carnation.user.bo.UserShareBO;
import com.sinco.carnation.user.model.UserShareExample;

@Repository
public class UserShareDao {

	@Autowired
	private UserShareMapper mapper;

	/** generate code begin **/
	public List<UserShareBO> findAll() {
		UserShareExample example = new UserShareExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserShareExample example = new UserShareExample();
		return mapper.countByExample(example);
	}

	public List<UserShare> save(Iterable<UserShare> entities) {
		List<UserShare> list = new ArrayList<UserShare>();
		for (UserShare UserShare : entities) {
			list.add(save(UserShare));
		}
		return list;
	}

	public UserShare save(UserShare record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserShare record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserShareBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserShareBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserShareExample example = new UserShareExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserShareBO> findAll(Iterable<Long> ids) {
		UserShareExample example = new UserShareExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserShare entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserShare> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserShare entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserShareExample example = new UserShareExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserShareExample example = new UserShareExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
