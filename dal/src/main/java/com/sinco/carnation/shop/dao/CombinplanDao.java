package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.CombinplanMapper;
import com.sinco.carnation.shop.model.Combinplan;
import com.sinco.carnation.shop.bo.CombinplanBO;
import com.sinco.carnation.shop.model.CombinplanExample;

@Repository
public class CombinplanDao {

	@Autowired
	private CombinplanMapper mapper;

	/** generate code begin **/
	public List<CombinplanBO> findAll() {
		CombinplanExample example = new CombinplanExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CombinplanExample example = new CombinplanExample();
		return mapper.countByExample(example);
	}

	public List<Combinplan> save(Iterable<Combinplan> entities) {
		List<Combinplan> list = new ArrayList<Combinplan>();
		for (Combinplan Combinplan : entities) {
			list.add(save(Combinplan));
		}
		return list;
	}

	public Combinplan save(Combinplan record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Combinplan record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CombinplanBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CombinplanBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CombinplanExample example = new CombinplanExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CombinplanBO> findAll(Iterable<Long> ids) {
		CombinplanExample example = new CombinplanExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Combinplan entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Combinplan> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Combinplan entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CombinplanExample example = new CombinplanExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CombinplanExample example = new CombinplanExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
