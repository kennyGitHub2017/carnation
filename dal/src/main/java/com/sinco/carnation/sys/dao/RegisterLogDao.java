package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.RegisterLogMapper;
import com.sinco.carnation.sys.model.RegisterLog;
import com.sinco.carnation.sys.bo.RegisterLogBO;
import com.sinco.carnation.sys.model.RegisterLogExample;

@Repository
public class RegisterLogDao {

	@Autowired
	private RegisterLogMapper mapper;

	/** generate code begin **/
	public List<RegisterLogBO> findAll() {
		RegisterLogExample example = new RegisterLogExample();
		return mapper.selectByExample(example);
	}

	List<RegisterLogBO> findAll(Iterable<Long> ids) {
		RegisterLogExample example = new RegisterLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		RegisterLogExample example = new RegisterLogExample();
		return mapper.countByExample(example);
	}

	public List<RegisterLog> save(Iterable<RegisterLog> entities) {
		List<RegisterLog> list = new ArrayList<RegisterLog>();
		for (RegisterLog RegisterLog : entities) {
			list.add(save(RegisterLog));
		}
		return list;
	}

	public RegisterLog save(RegisterLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RegisterLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RegisterLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RegisterLogExample example = new RegisterLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RegisterLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RegisterLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RegisterLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RegisterLogExample example = new RegisterLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RegisterLogExample example = new RegisterLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
