package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.goods.mapper.GoodsReturnMapper;
import com.sinco.carnation.goods.model.GoodsReturn;
import com.sinco.carnation.goods.model.GoodsReturnExample;

@Repository
public class GoodsReturnDao {

	@Autowired
	private GoodsReturnMapper mapper;

	/** generate code begin **/
	public List<GoodsReturn> findAll() {
		GoodsReturnExample example = new GoodsReturnExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsReturnExample example = new GoodsReturnExample();
		return mapper.countByExample(example);
	}

	public List<GoodsReturn> save(Iterable<GoodsReturn> entities) {
		List<GoodsReturn> list = new ArrayList<GoodsReturn>();
		for (GoodsReturn GoodsReturn : entities) {
			list.add(save(GoodsReturn));
		}
		return list;
	}

	public GoodsReturn save(GoodsReturn record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsReturn record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsReturn findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsReturn get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsReturnExample example = new GoodsReturnExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsReturn> findAll(Iterable<Long> ids) {
		GoodsReturnExample example = new GoodsReturnExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsReturn entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsReturn> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsReturn entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsReturnExample example = new GoodsReturnExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsReturnExample example = new GoodsReturnExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
