package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.store.mapper.StorePartnerMapper;
import com.sinco.carnation.store.model.StorePartner;
import com.sinco.carnation.store.bo.StorePartnerBO;
import com.sinco.carnation.store.model.StorePartnerExample;

@Repository
public class StorePartnerDao {

	@Autowired
	private StorePartnerMapper mapper;

	/** generate code begin **/
	public List<StorePartnerBO> findAll() {
		StorePartnerExample example = new StorePartnerExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StorePartnerExample example = new StorePartnerExample();
		return mapper.countByExample(example);
	}

	public List<StorePartner> save(Iterable<StorePartner> entities) {
		List<StorePartner> list = new ArrayList<StorePartner>();
		for (StorePartner StorePartner : entities) {
			list.add(save(StorePartner));
		}
		return list;
	}

	public StorePartner save(StorePartner record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StorePartner record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StorePartnerBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StorePartnerBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StorePartnerExample example = new StorePartnerExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StorePartnerBO> findAll(Iterable<Long> ids) {
		StorePartnerExample example = new StorePartnerExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StorePartner entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StorePartner> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StorePartner entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StorePartnerExample example = new StorePartnerExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StorePartnerExample example = new StorePartnerExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
