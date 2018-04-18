package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.mapper.RoleResMapper;
import com.sinco.carnation.sys.model.RoleRes;
import com.sinco.carnation.sys.model.RoleResExample;

@Repository
public class RoleResDao {

	@Autowired
	private RoleResMapper mapper;

	public List<RoleRes> findByResType(String type) {
		return mapper.findByResType(type);
	}

	public List<RoleRes> findAll() {
		RoleResExample example = new RoleResExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RoleResExample example = new RoleResExample();
		return mapper.countByExample(example);
	}

	public List<RoleRes> save(Iterable<RoleRes> entities) {
		List<RoleRes> list = new ArrayList<RoleRes>();
		for (RoleRes RoleRes : entities) {
			list.add(save(RoleRes));
		}
		return list;
	}

	public RoleRes save(RoleRes record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<RoleRes> findByResId(java.lang.Long resId) {
		RoleResExample example = new RoleResExample();
		example.createCriteria().andResIdEqualTo(resId);
		return mapper.selectByExample(example);
	}

	public int deleteByResId(java.lang.Long resId) {
		RoleResExample example = new RoleResExample();
		example.createCriteria().andResIdEqualTo(resId);
		return mapper.deleteByExample(example);
	}

	public List<RoleRes> findByRoleId(java.lang.Long roleId) {
		RoleResExample example = new RoleResExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}

	public int deleteByRoleId(java.lang.Long roleId) {
		RoleResExample example = new RoleResExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.deleteByExample(example);
	}

}
