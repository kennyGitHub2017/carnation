package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.StorePointBO;
import com.sinco.carnation.store.mapper.StorePointMapper;
import com.sinco.carnation.store.model.StorePoint;
import com.sinco.carnation.store.model.StorePointExample;

@Repository
public class StorePointDao {

	@Autowired
	private StorePointMapper mapper;

	public List<StorePoint> selectPointByStoreGcAndStatus(Long gcId, Integer status) {
		return mapper.selectPointByStoreGcAndStatus(gcId, status);
	}

	/** generate code begin **/
	public List<StorePointBO> findAll() {
		StorePointExample example = new StorePointExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StorePointExample example = new StorePointExample();
		return mapper.countByExample(example);
	}

	public List<StorePoint> save(Iterable<StorePoint> entities) {
		List<StorePoint> list = new ArrayList<StorePoint>();
		for (StorePoint StorePoint : entities) {
			list.add(save(StorePoint));
		}
		return list;
	}

	public StorePoint save(StorePoint record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StorePoint record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StorePointBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StorePointBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StorePointBO fetchByStoreId(long storeId) {
		// return mapper.fetchByStoreId(storeId);
		List<StorePointBO> list = mapper.selectByStoreId(storeId);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public StorePointBO fetchByUserId(long userId) {
		// return mapper.fetchByUserId(userId);
		List<StorePointBO> list = mapper.selectByUserId(userId);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public boolean exists(java.lang.Long id) {
		StorePointExample example = new StorePointExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StorePointBO> findAll(Iterable<Long> ids) {
		StorePointExample example = new StorePointExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StorePoint entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StorePoint> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StorePoint entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StorePointExample example = new StorePointExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StorePointExample example = new StorePointExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/

}
