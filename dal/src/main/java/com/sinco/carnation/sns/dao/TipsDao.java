package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.TipsMapper;
import com.sinco.carnation.sns.model.Tips;
import com.sinco.carnation.sns.bo.TipsBO;
import com.sinco.carnation.sns.model.TipsExample;

@Repository
public class TipsDao {

	@Autowired
	private TipsMapper mapper;

	/** generate code begin **/
	public List<TipsBO> findAll() {
		TipsExample example = new TipsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		TipsExample example = new TipsExample();
		return mapper.countByExample(example);
	}

	public List<Tips> save(Iterable<Tips> entities) {
		List<Tips> list = new ArrayList<Tips>();
		for (Tips Tips : entities) {
			list.add(save(Tips));
		}
		return list;
	}

	public Tips save(Tips record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Tips record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public TipsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public TipsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		TipsExample example = new TipsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<TipsBO> findAll(Iterable<Long> ids) {
		TipsExample example = new TipsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Tips entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Tips> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Tips entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		TipsExample example = new TipsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		TipsExample example = new TipsExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
