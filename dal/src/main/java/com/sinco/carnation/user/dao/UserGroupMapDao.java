package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.user.bo.UserGroupMapBO;
import com.sinco.carnation.user.mapper.UserGroupMapMapper;
import com.sinco.carnation.user.model.UserGroupMap;
import com.sinco.carnation.user.model.UserGroupMapExample;

@Repository
public class UserGroupMapDao {

	@Autowired
	private UserGroupMapMapper mapper;

	/** generate code begin **/
	public List<UserGroupMapBO> findAll() {
		UserGroupMapExample example = new UserGroupMapExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserGroupMapExample example = new UserGroupMapExample();
		return mapper.countByExample(example);
	}

	public List<UserGroupMap> save(Iterable<UserGroupMap> entities) {
		List<UserGroupMap> list = new ArrayList<UserGroupMap>();
		for (UserGroupMap UserGroupMap : entities) {
			list.add(save(UserGroupMap));
		}
		return list;
	}

	public UserGroupMap save(UserGroupMap record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<UserGroupMapBO> findByUserGroupId(java.lang.Long userGroupId) {
		UserGroupMapExample example = new UserGroupMapExample();
		example.createCriteria().andUserGroupIdEqualTo(userGroupId);
		return mapper.selectByExample(example);
	}

	public int deleteByUserGroupId(java.lang.Long userGroupId) {
		UserGroupMapExample example = new UserGroupMapExample();
		example.createCriteria().andUserGroupIdEqualTo(userGroupId);
		return mapper.deleteByExample(example);
	}

	public List<UserGroupMapBO> findByUserId(java.lang.Long userId) {
		UserGroupMapExample example = new UserGroupMapExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.selectByExample(example);
	}

	public int deleteByUserId(java.lang.Long userId) {
		UserGroupMapExample example = new UserGroupMapExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return mapper.deleteByExample(example);
	}

	public int delete(java.lang.Long userGroupId, java.lang.Long userId) {
		return mapper.deleteByPrimaryKey(userGroupId, userId);
	}

	/** generate code end **/

	public UserGroupMapBO findByUserGroupIdAndUserId(java.lang.Long userGroupId, java.lang.Long userId) {
		UserGroupMapExample example = new UserGroupMapExample();
		example.createCriteria().andUserGroupIdEqualTo(userGroupId).andUserIdEqualTo(userId);
		List<UserGroupMapBO> list = mapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list))
			return null;

		return list.get(0);
	}
}
