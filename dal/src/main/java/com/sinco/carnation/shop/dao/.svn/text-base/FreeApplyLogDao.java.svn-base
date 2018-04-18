package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.FreeApplyLogMapper;
import com.sinco.carnation.shop.model.FreeApplyLog;
import com.sinco.carnation.shop.bo.FreeApplyLogBO;
import com.sinco.carnation.shop.model.FreeApplyLogExample;

@Repository
public class FreeApplyLogDao {

	@Autowired
	private FreeApplyLogMapper mapper;

	/** generate code begin **/
	public List<FreeApplyLogBO> findAll() {
		FreeApplyLogExample example = new FreeApplyLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		FreeApplyLogExample example = new FreeApplyLogExample();
		return mapper.countByExample(example);
	}

	public List<FreeApplyLog> save(Iterable<FreeApplyLog> entities) {
		List<FreeApplyLog> list = new ArrayList<FreeApplyLog>();
		for (FreeApplyLog FreeApplyLog : entities) {
			list.add(save(FreeApplyLog));
		}
		return list;
	}

	public FreeApplyLog save(FreeApplyLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(FreeApplyLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public FreeApplyLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public FreeApplyLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		FreeApplyLogExample example = new FreeApplyLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<FreeApplyLogBO> findAll(Iterable<Long> ids) {
		FreeApplyLogExample example = new FreeApplyLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(FreeApplyLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<FreeApplyLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (FreeApplyLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		FreeApplyLogExample example = new FreeApplyLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		FreeApplyLogExample example = new FreeApplyLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
