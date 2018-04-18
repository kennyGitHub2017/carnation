package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.mapper.UserRelationStatisMapper;
import com.sinco.carnation.user.model.UserRelationStatis;
import com.sinco.carnation.user.bo.UserRelationStatisBO;
import com.sinco.carnation.user.model.UserRelationStatisExample;

@Repository
public class UserRelationStatisDao {

	@Autowired
	private UserRelationStatisMapper mapper;

	/** generate code begin **/
	public List<UserRelationStatisBO> findAll() {
		UserRelationStatisExample example = new UserRelationStatisExample();
		return mapper.selectByExample(example);
	}

	List<UserRelationStatisBO> findAll(Iterable<Long> ids) {
		UserRelationStatisExample example = new UserRelationStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserRelationStatisExample example = new UserRelationStatisExample();
		return mapper.countByExample(example);
	}

	public List<UserRelationStatis> save(Iterable<UserRelationStatis> entities) {
		List<UserRelationStatis> list = new ArrayList<UserRelationStatis>();
		for (UserRelationStatis UserRelationStatis : entities) {
			list.add(save(UserRelationStatis));
		}
		return list;
	}

	public UserRelationStatis save(UserRelationStatis record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserRelationStatis record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserRelationStatisBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserRelationStatisExample example = new UserRelationStatisExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserRelationStatis entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserRelationStatis> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserRelationStatis entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserRelationStatisExample example = new UserRelationStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserRelationStatisExample example = new UserRelationStatisExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public UserRelationStatisBO findByUid(java.lang.Long uid) {
		List<UserRelationStatisBO> list = mapper.findByUid(uid);
		return list.size() > 0 ? list.get(0) : null;
	}
	
	/**
	 * 根据loginNames获取小伙伴数量
	 * @param loginNames
	 * @return
	 */
	public int countByLoginNames(List<String> loginNames){
		int result = 0 ;
		if(loginNames.size()>0){
			result = mapper.countByLoginNames(loginNames);
		}
		return result;
	}
	
	
	/**
	 * 根据loginNames获取商户小伙伴数量
	 * @param loginNames
	 * @return
	 */
	public int countStoreByLoginNames(List<String> loginNames){
		int result = 0 ;
		if(loginNames.size()>0){
			result = mapper.countStoreByLoginNames(loginNames);
		}
		return result;
	}

}
