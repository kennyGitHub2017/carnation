package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.FreeClassMapper;
import com.sinco.carnation.shop.model.FreeClass;
import com.sinco.carnation.shop.bo.FreeClassBO;
import com.sinco.carnation.shop.model.FreeClassExample;

@Repository
public class FreeClassDao {

	@Autowired
	private FreeClassMapper mapper;

	/** generate code begin **/
	public List<FreeClassBO> findAll() {
		FreeClassExample example = new FreeClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		FreeClassExample example = new FreeClassExample();
		return mapper.countByExample(example);
	}

	public List<FreeClass> save(Iterable<FreeClass> entities) {
		List<FreeClass> list = new ArrayList<FreeClass>();
		for (FreeClass FreeClass : entities) {
			list.add(save(FreeClass));
		}
		return list;
	}

	public FreeClass save(FreeClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(FreeClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public FreeClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public FreeClassBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		FreeClassExample example = new FreeClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<FreeClassBO> findAll(Iterable<Long> ids) {
		FreeClassExample example = new FreeClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(FreeClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<FreeClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (FreeClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		FreeClassExample example = new FreeClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		FreeClassExample example = new FreeClassExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
