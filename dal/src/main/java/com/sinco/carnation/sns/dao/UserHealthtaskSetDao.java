package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.carnation.sns.mapper.UserHealthtaskSetMapper;
import com.sinco.carnation.sns.model.UserHealthtaskSet;
import com.sinco.carnation.sns.model.UserHealthtaskSetExample;

@Repository
public class UserHealthtaskSetDao {

	@Autowired
	private UserHealthtaskSetMapper mapper;

	/** generate code begin **/
	public List<UserHealthtaskSetBO> findAll() {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		return mapper.selectByExample(example);
	}

	List<UserHealthtaskSetBO> findAll(Iterable<Long> ids) {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		return mapper.countByExample(example);
	}

	/*public List<UserHealthtaskSet> save(Iterable<UserHealthtaskSet> entities){
		List<UserHealthtaskSet> list=new ArrayList<UserHealthtaskSet>();
		for (UserHealthtaskSet UserHealthtaskSet : entities) {
			list.add(save(UserHealthtaskSet));
		}
		return list;
	}*/

	/*public UserHealthtaskSet save(UserHealthtaskSet record){
		if(record.getId() == null){
			mapper.insertSelective(record);
		}else{
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}*/

	public void update(UserHealthtaskSet record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserHealthtaskSetBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserHealthtaskSet entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserHealthtaskSet> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserHealthtaskSet entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserHealthtaskSetExample example = new UserHealthtaskSetExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public int insert_UserHealthtaskSetDao(UserHealthtaskSet entity) {
		return this.mapper.insert_UserHealthtaskSet(entity);
	}

	public List<UserHealthtaskSetBO> select_Today_HealthTaskDao(UserHealthtaskSet entity) {
		return this.mapper.select_userHealthTaskSet_today_taskID(entity);
	}

	public UserHealthtaskSetBO findOne_By_UID_TaskIDDao(Long uid, Long taskID) {
		return this.mapper.findOne_UserHealthTaskSet_By_UID_TaskID(uid, taskID);
	}

	public int updateUserHealthTaskSetDao(UserHealthtaskSet entity) {
		return this.mapper.updateUserHealthTaskSet(entity);
	}

	public int deleteHealthtaskSet(Long uid, Long taskID) {
		return this.mapper.deleteHealthtaskSet(uid, taskID);
	}
}
