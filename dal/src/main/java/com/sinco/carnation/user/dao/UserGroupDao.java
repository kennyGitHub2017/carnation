package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.UserGroupBO;
import com.sinco.carnation.user.mapper.UserGroupMapper;
import com.sinco.carnation.user.model.UserGroup;
import com.sinco.carnation.user.model.UserGroupExample;
import com.sinco.carnation.user.vo.UserGroupVO;
import com.sinco.dal.common.MyPage;

@Repository
public class UserGroupDao {

	@Autowired
	private UserGroupMapper mapper;

	/** generate code begin **/
	public List<UserGroupBO> findAll() {
		UserGroupExample example = new UserGroupExample();
		return mapper.selectByExample(example);
	}

	List<UserGroupBO> findAll(Iterable<Long> ids) {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserGroupExample example = new UserGroupExample();
		return mapper.countByExample(example);
	}

	public List<UserGroup> save(Iterable<UserGroup> entities) {
		List<UserGroup> list = new ArrayList<UserGroup>();
		for (UserGroup UserGroup : entities) {
			list.add(save(UserGroup));
		}
		return list;
	}

	public UserGroup save(UserGroup record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserGroup record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserGroupBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserGroup entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserGroup> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserGroup entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserGroupExample example = new UserGroupExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 获取当前系统默认的用户组
	 * 
	 * @return
	 */
	public List<UserGroupBO> getUserGroupIsSystem() {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andIsSystemEqualTo((byte) 1);

		return mapper.selectByExample(example);
//		List<UserGroupBO> list =  mapper.selectByExample(example);
//		if(CollectionUtils.isEmpty(list)) return null;		
//		return list.get(0);
	}

	public List<UserGroupBO> selectGroupPageByVO(@Param("vo") UserGroupVO vo, MyPage<UserGroupBO> page) {
		return mapper.selectGroupPageByVO(vo, page);
	}

	public UserGroupBO findUserGroupByName(String groupName) {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andGroupNameEqualTo(groupName).andDeleteStatusEqualTo((byte) 0);

		List<UserGroupBO> list = mapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list))
			return null;
		return list.get(0);
	}

	public List<UserGroupBO> findAllValid() {
		UserGroupExample example = new UserGroupExample();
		example.createCriteria().andDeleteStatusEqualTo((byte) 0);
		return mapper.selectByExample(example);
	}
}
