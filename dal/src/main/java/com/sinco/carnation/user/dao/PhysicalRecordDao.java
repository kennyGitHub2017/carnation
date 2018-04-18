package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.PhysicalRecordMapper;
import com.sinco.carnation.user.model.PhysicalRecord;
import com.sinco.carnation.user.bo.PhysicalRecordBO;
import com.sinco.carnation.user.model.PhysicalRecordExample;

@Repository
public class PhysicalRecordDao {

	@Autowired
	private PhysicalRecordMapper mapper;

	/** generate code begin **/
	public List<PhysicalRecordBO> findAll() {
		PhysicalRecordExample example = new PhysicalRecordExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalRecordExample example = new PhysicalRecordExample();
		return mapper.countByExample(example);
	}

	public List<PhysicalRecord> save(Iterable<PhysicalRecord> entities) {
		List<PhysicalRecord> list = new ArrayList<PhysicalRecord>();
		for (PhysicalRecord PhysicalRecord : entities) {
			list.add(save(PhysicalRecord));
		}
		return list;
	}

	public PhysicalRecord save(PhysicalRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PhysicalRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalRecordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PhysicalRecordBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalRecordExample example = new PhysicalRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PhysicalRecordBO> findAll(Iterable<Long> ids) {
		PhysicalRecordExample example = new PhysicalRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalRecordExample example = new PhysicalRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalRecordExample example = new PhysicalRecordExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
