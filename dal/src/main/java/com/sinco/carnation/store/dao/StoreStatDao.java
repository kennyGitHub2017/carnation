package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.store.mapper.StoreStatMapper;
import com.sinco.carnation.store.model.StoreStat;
import com.sinco.carnation.store.bo.StoreStatBO;
import com.sinco.carnation.store.model.StoreStatExample;

@Repository
public class StoreStatDao {

	@Autowired
	private StoreStatMapper mapper;

	/** generate code begin **/
	public List<StoreStatBO> findAll() {
		StoreStatExample example = new StoreStatExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreStatExample example = new StoreStatExample();
		return mapper.countByExample(example);
	}

	public List<StoreStat> save(Iterable<StoreStat> entities) {
		List<StoreStat> list = new ArrayList<StoreStat>();
		for (StoreStat StoreStat : entities) {
			list.add(save(StoreStat));
		}
		return list;
	}

	public StoreStat save(StoreStat record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreStat record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreStatBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreStatBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreStatExample example = new StoreStatExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreStatBO> findAll(Iterable<Long> ids) {
		StoreStatExample example = new StoreStatExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreStat entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreStat> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreStat entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreStatExample example = new StoreStatExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreStatExample example = new StoreStatExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
