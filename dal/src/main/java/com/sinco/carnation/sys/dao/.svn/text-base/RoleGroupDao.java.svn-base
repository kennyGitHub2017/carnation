package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.RoleGroupBO;
import com.sinco.carnation.sys.mapper.RoleGroupMapper;
import com.sinco.carnation.sys.model.RoleGroup;
import com.sinco.carnation.sys.model.RoleGroupExample;

@Repository
public class RoleGroupDao {

	@Autowired
	private RoleGroupMapper mapper;

	public List<RoleGroupBO> findByType(String type) {
		RoleGroupExample example = new RoleGroupExample();
		example.createCriteria().andTypeEqualTo(type);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public List<RoleGroupBO> findByTypeAndName(String type, String name) {
		RoleGroupExample example = new RoleGroupExample();
		example.createCriteria().andTypeEqualTo(type).andNameEqualTo(name);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<RoleGroupBO> findAll() {
		RoleGroupExample example = new RoleGroupExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RoleGroupExample example = new RoleGroupExample();
		return mapper.countByExample(example);
	}

	public List<RoleGroup> save(Iterable<RoleGroup> entities) {
		List<RoleGroup> list = new ArrayList<RoleGroup>();
		for (RoleGroup RoleGroup : entities) {
			list.add(save(RoleGroup));
		}
		return list;
	}

	public RoleGroup save(RoleGroup record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RoleGroup record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RoleGroup findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RoleGroup get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RoleGroupExample example = new RoleGroupExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public List<RoleGroupBO> findAll(Iterable<Long> ids) {
		RoleGroupExample example = new RoleGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RoleGroup entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RoleGroup> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RoleGroup entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RoleGroupExample example = new RoleGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RoleGroupExample example = new RoleGroupExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
