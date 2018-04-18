package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.UserPhoneAreaMapper;
import com.sinco.carnation.sys.model.UserPhoneArea;
import com.sinco.carnation.sys.bo.UserPhoneAreaBO;
import com.sinco.carnation.sys.model.UserPhoneAreaExample;

@Repository
public class UserPhoneAreaDao {

	@Autowired
	private UserPhoneAreaMapper mapper;

	/** generate code begin **/
	public List<UserPhoneAreaBO> findAll() {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		return mapper.selectByExample(example);
	}

	List<UserPhoneAreaBO> findAll(Iterable<Long> ids) {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		return mapper.countByExample(example);
	}

	public List<UserPhoneArea> save(Iterable<UserPhoneArea> entities) {
		List<UserPhoneArea> list = new ArrayList<UserPhoneArea>();
		for (UserPhoneArea UserPhoneArea : entities) {
			list.add(save(UserPhoneArea));
		}
		return list;
	}

	public UserPhoneArea save(UserPhoneArea record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserPhoneArea record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserPhoneAreaBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserPhoneArea entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserPhoneArea> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserPhoneArea entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserPhoneAreaExample example = new UserPhoneAreaExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
