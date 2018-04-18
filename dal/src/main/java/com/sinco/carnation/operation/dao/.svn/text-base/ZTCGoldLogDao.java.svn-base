package com.sinco.carnation.operation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.operation.mapper.ZTCGoldLogMapper;
import com.sinco.carnation.operation.model.ZTCGoldLog;
import com.sinco.carnation.operation.bo.ZTCGoldLogBO;
import com.sinco.carnation.operation.model.ZTCGoldLogExample;

@Repository
public class ZTCGoldLogDao {

	@Autowired
	private ZTCGoldLogMapper mapper;

	/** generate code begin **/
	public List<ZTCGoldLogBO> findAll() {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		return mapper.countByExample(example);
	}

	public List<ZTCGoldLog> save(Iterable<ZTCGoldLog> entities) {
		List<ZTCGoldLog> list = new ArrayList<ZTCGoldLog>();
		for (ZTCGoldLog ZTCGoldLog : entities) {
			list.add(save(ZTCGoldLog));
		}
		return list;
	}

	public ZTCGoldLog save(ZTCGoldLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ZTCGoldLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ZTCGoldLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ZTCGoldLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ZTCGoldLogBO> findAll(Iterable<Long> ids) {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ZTCGoldLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ZTCGoldLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ZTCGoldLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ZTCGoldLogExample example = new ZTCGoldLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
