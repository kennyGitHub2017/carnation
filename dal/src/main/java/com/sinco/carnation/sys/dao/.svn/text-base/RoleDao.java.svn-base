package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.mapper.RoleMapper;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.RoleExample;

@Repository
public class RoleDao {

	@Autowired
	private RoleMapper mapper;

	public List<RoleBO> findByRoleCode(String... roleCode) {
		RoleExample example = new RoleExample();
		example.createCriteria().andRoleCodeIn(Lists.newArrayList(roleCode));

		return mapper.selectByExample(example);
	}

	public List<RoleBO> findByRoleGroupId(Long rgId) {
		RoleExample example = new RoleExample();
		example.createCriteria().andRgIdEqualTo(rgId);
		return mapper.selectByExample(example);
	}

	public List<RoleBO> findByType(String... types) {
		RoleExample example = new RoleExample();
		example.createCriteria().andTypeIn(Lists.newArrayList(types));
		return mapper.selectByExample(example);
	}

	public List<RoleBO> findByResType(String type) {
		return mapper.findByResType(type);
	}

	public List<RoleBO> findByResId(Long resId) {
		return mapper.findByResId(resId);
	}

	public List<RoleBO> findAll() {
		RoleExample example = new RoleExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RoleExample example = new RoleExample();
		return mapper.countByExample(example);
	}

	public List<Role> save(Iterable<Role> entities) {
		List<Role> list = new ArrayList<Role>();
		for (Role Role : entities) {
			list.add(save(Role));
		}
		return list;
	}

	public Role save(Role record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Role record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Role findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Role get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RoleBO> findAll(Iterable<Long> ids) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Role entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Role> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Role entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RoleExample example = new RoleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RoleExample example = new RoleExample();
		mapper.deleteByExample(example);
	}

	public List<RoleBO> findByUid(Long uid) {
		return mapper.findByUid(uid);
	}

	/**
	 * public List<RoleBO> findByGroupId(Long groupId){ return mapper.findByGroupId(groupId); }
	 **/

	public List<RoleBO> findByRoleCodeAndType(String roleType, String... roleCode) {
		RoleExample example = new RoleExample();
		example.createCriteria().andTypeEqualTo(roleType).andRoleCodeIn(Lists.newArrayList(roleCode));

		return mapper.selectByExample(example);
	}

}
