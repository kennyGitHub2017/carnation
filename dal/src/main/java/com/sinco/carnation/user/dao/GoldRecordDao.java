package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.GoldRecordMapper;
import com.sinco.carnation.user.model.GoldRecord;
import com.sinco.carnation.user.bo.GoldRecordBO;
import com.sinco.carnation.user.model.GoldRecordExample;

@Repository
public class GoldRecordDao {

	@Autowired
	private GoldRecordMapper mapper;

	/** generate code begin **/
	public List<GoldRecordBO> findAll() {
		GoldRecordExample example = new GoldRecordExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoldRecordExample example = new GoldRecordExample();
		return mapper.countByExample(example);
	}

	public List<GoldRecord> save(Iterable<GoldRecord> entities) {
		List<GoldRecord> list = new ArrayList<GoldRecord>();
		for (GoldRecord GoldRecord : entities) {
			list.add(save(GoldRecord));
		}
		return list;
	}

	public GoldRecord save(GoldRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoldRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoldRecordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoldRecordBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoldRecordExample example = new GoldRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoldRecordBO> findAll(Iterable<Long> ids) {
		GoldRecordExample example = new GoldRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoldRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoldRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoldRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoldRecordExample example = new GoldRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoldRecordExample example = new GoldRecordExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
