package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.UserStepRecordBO;
import com.sinco.carnation.user.mapper.UserStepRecordMapper;
import com.sinco.carnation.user.model.UserStepRecord;
import com.sinco.carnation.user.model.UserStepRecordExample;

@Repository
public class UserStepRecordDao {

	@Autowired
	private UserStepRecordMapper mapper;

	/** generate code begin **/
	public List<UserStepRecord> findAll() {
		UserStepRecordExample example = new UserStepRecordExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserStepRecordExample example = new UserStepRecordExample();
		return mapper.countByExample(example);
	}

	public List<UserStepRecord> save(Iterable<UserStepRecord> entities) {
		List<UserStepRecord> list = new ArrayList<UserStepRecord>();
		for (UserStepRecord UserStepRecord : entities) {
			list.add(save(UserStepRecord));
		}
		return list;
	}

	public UserStepRecord save(UserStepRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserStepRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserStepRecord findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserStepRecord get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserStepRecordExample example = new UserStepRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserStepRecord> findAll(Iterable<Long> ids) {
		UserStepRecordExample example = new UserStepRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserStepRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserStepRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserStepRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserStepRecordExample example = new UserStepRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserStepRecordExample example = new UserStepRecordExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public UserStepRecord findByUidAndTime(Long uid, String recordDate) {
		List<UserStepRecord> list = mapper.findByUidAndTime(uid, recordDate);
		return list.isEmpty() ? null : list.get(0);
	}

	public int addUserStepRecord(UserStepRecord record) {
		return mapper.insertSelective(record);
	}

	public List<UserStepRecordBO> weekStepRecord(Long uid) {
		return mapper.weekStepRecord(uid);
	}

	public List<UserStepRecord> queryStepByRange(Long uid, String startDate, String endDate) {
		return mapper.queryStepByRange(uid, startDate, endDate);
	}

	public List<UserStepRecordBO> equipStepQueryMonByYear(Long uid, String startDate, String endDate) {
		return mapper.equipStepQueryMonByYear(uid, startDate, endDate);
	}
}
