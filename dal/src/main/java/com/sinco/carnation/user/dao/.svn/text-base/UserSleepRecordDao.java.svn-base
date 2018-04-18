package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.UserSleepRecordBO;
import com.sinco.carnation.user.mapper.UserSleepRecordMapper;
import com.sinco.carnation.user.model.UserSleepRecord;
import com.sinco.carnation.user.model.UserSleepRecordExample;

@Repository
public class UserSleepRecordDao {

	@Autowired
	private UserSleepRecordMapper mapper;

	/** generate code begin **/
	public List<UserSleepRecord> findAll() {
		UserSleepRecordExample example = new UserSleepRecordExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserSleepRecordExample example = new UserSleepRecordExample();
		return mapper.countByExample(example);
	}

	public List<UserSleepRecord> save(Iterable<UserSleepRecord> entities) {
		List<UserSleepRecord> list = new ArrayList<UserSleepRecord>();
		for (UserSleepRecord UserSleepRecord : entities) {
			list.add(save(UserSleepRecord));
		}
		return list;
	}

	public UserSleepRecord save(UserSleepRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserSleepRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserSleepRecord findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserSleepRecord get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserSleepRecordExample example = new UserSleepRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserSleepRecord> findAll(Iterable<Long> ids) {
		UserSleepRecordExample example = new UserSleepRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserSleepRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserSleepRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserSleepRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserSleepRecordExample example = new UserSleepRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserSleepRecordExample example = new UserSleepRecordExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public UserSleepRecord findByUidAndTime(Long uid, String recordDate) {
		List<UserSleepRecord> list = mapper.findByUidAndTime(uid, recordDate);
		return list.isEmpty() ? null : list.get(0);
	}

	public int sleepUpdate(UserSleepRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int sleepInsert(UserSleepRecord record) {
		return mapper.insert(record);
	}

	public List<UserSleepRecord> sleepRecordQuery(Long uid, String recordDate) {
		return mapper.findByUidAndTime(uid, recordDate);
	}

	public List<UserSleepRecordBO> weekSleepRecord(Long uid) {
		return mapper.weekSleepRecord(uid);
	}

	public List<UserSleepRecordBO> equipSleepQueryByRange(Long uid, String startDateStr, String endDateStr) {
		// TODO Auto-generated method stub
		return mapper.equipSleepQueryByRange(uid, startDateStr, endDateStr);
	}
}
