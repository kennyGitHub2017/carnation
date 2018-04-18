package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sys.mapper.UserRoleMapper;
import com.sinco.carnation.sys.model.UserRole;
import com.sinco.carnation.sys.model.UserRoleExample;

@Repository
public class UserRoleDao {

	@Autowired
	private UserRoleMapper mapper;

	/**
	 * 根据角色类型删除用户角色
	 * 
	 * @param uid
	 * @param roleType
	 * @return
	 */
	public int deleteByRoleTypeAndUid(Long uid, String roleType) {
		return mapper.deleteByRoleTypeAndUid(uid, roleType);
	}

	public List<UserRole> findAll() {
		UserRoleExample example = new UserRoleExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserRoleExample example = new UserRoleExample();
		return mapper.countByExample(example);
	}

	public List<UserRole> save(Iterable<UserRole> entities) {
		List<UserRole> list = new ArrayList<UserRole>();
		for (UserRole UserRole : entities) {
			list.add(save(UserRole));
		}
		return list;
	}

	public UserRole save(UserRole record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<UserRole> findByRoleId(java.lang.Long roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}

	public int deleteByRoleId(java.lang.Long roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.deleteByExample(example);
	}

	public List<UserRole> findByUserId(java.lang.Long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.selectByExample(example);
	}

	public int deleteByUserId(java.lang.Long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.deleteByExample(example);
	}

}
