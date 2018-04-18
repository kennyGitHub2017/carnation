package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.ResBO;
import com.sinco.carnation.sys.mapper.ResMapper;
import com.sinco.carnation.sys.model.Res;
import com.sinco.carnation.sys.model.ResExample;

@Repository
public class ResDao {

	@Autowired
	private ResMapper mapper;

	public List<ResBO> findByType(String type) {
		ResExample example = new ResExample();
		example.createCriteria().andTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

	public List<ResBO> findByValue(String value) {
		ResExample example = new ResExample();
		example.createCriteria().andValueEqualTo(value);
		return mapper.selectByExample(example);
	}

	public List<ResBO> findAll() {
		ResExample example = new ResExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ResExample example = new ResExample();
		return mapper.countByExample(example);
	}

	public List<Res> save(Iterable<Res> entities) {
		List<Res> list = new ArrayList<Res>();
		for (Res Res : entities) {
			list.add(save(Res));
		}
		return list;
	}

	public Res save(Res record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Res record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Res findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Res get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ResExample example = new ResExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ResBO> findAll(Iterable<Long> ids) {
		ResExample example = new ResExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Res entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Res> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Res entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ResExample example = new ResExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ResExample example = new ResExample();
		mapper.deleteByExample(example);
	}

	public List<ResBO> findResByRoleType(String roleType, String value) {
		return mapper.findResByRoleType(roleType, value);
	}
}
