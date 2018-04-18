package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.UserAddressMapper;
import com.sinco.carnation.user.model.UserAddress;
import com.sinco.carnation.user.model.UserAddressExample;

@Repository
public class UserAddressDao {

	@Autowired
	private UserAddressMapper mapper;

	/** generate code begin **/
	public List<UserAddress> findAll() {
		UserAddressExample example = new UserAddressExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserAddressExample example = new UserAddressExample();
		return mapper.countByExample(example);
	}

	public List<UserAddress> save(Iterable<UserAddress> entities) {
		List<UserAddress> list = new ArrayList<UserAddress>();
		for (UserAddress UserAddress : entities) {
			list.add(save(UserAddress));
		}
		return list;
	}

	public UserAddress save(UserAddress record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserAddress record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserAddress findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserAddress get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserAddressExample example = new UserAddressExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserAddress> findAll(Iterable<Long> ids) {
		UserAddressExample example = new UserAddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserAddress entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserAddress> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserAddress entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserAddressExample example = new UserAddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserAddressExample example = new UserAddressExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
