package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.user.bo.UserGroupRoleBO;
import com.sinco.carnation.user.mapper.UserGroupRoleMapper;
import com.sinco.carnation.user.model.UserGroupRole;
import com.sinco.carnation.user.model.UserGroupRoleExample;

@Repository
public class UserGroupRoleDao {

	@Autowired
	private UserGroupRoleMapper mapper;

	/** generate code begin **/
	public List<UserGroupRoleBO> findAll() {
		UserGroupRoleExample example = new UserGroupRoleExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserGroupRoleExample example = new UserGroupRoleExample();
		return mapper.countByExample(example);
	}

	public List<UserGroupRole> save(Iterable<UserGroupRole> entities) {
		List<UserGroupRole> list = new ArrayList<UserGroupRole>();
		for (UserGroupRole UserGroupRole : entities) {
			list.add(save(UserGroupRole));
		}
		return list;
	}

	public UserGroupRole save(UserGroupRole record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<UserGroupRoleBO> findByRoleId(java.lang.Long roleId) {
		UserGroupRoleExample example = new UserGroupRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.selectByExample(example);
	}

	public int deleteByRoleId(java.lang.Long roleId) {
		UserGroupRoleExample example = new UserGroupRoleExample();
		example.createCriteria().andRoleIdEqualTo(roleId);
		return mapper.deleteByExample(example);
	}

	public List<UserGroupRoleBO> findByUserGroupId(java.lang.Long userGroupId) {
		UserGroupRoleExample example = new UserGroupRoleExample();
		example.createCriteria().andUserGroupIdEqualTo(userGroupId);
		return mapper.selectByExample(example);
	}

	public int deleteByUserGroupId(java.lang.Long userGroupId) {
		UserGroupRoleExample example = new UserGroupRoleExample();
		example.createCriteria().andUserGroupIdEqualTo(userGroupId);
		return mapper.deleteByExample(example);
	}

	public int delete(java.lang.Long roleId, java.lang.Long userGroupId) {
		return mapper.deleteByPrimaryKey(roleId, userGroupId);
	}

	/** generate code end **/

	public int deleteByRoleTypeAndGroupId(Long groupId, String roleType) {
		return mapper.deleteByRoleTypeAndGroupId(groupId, roleType);
	}
}
