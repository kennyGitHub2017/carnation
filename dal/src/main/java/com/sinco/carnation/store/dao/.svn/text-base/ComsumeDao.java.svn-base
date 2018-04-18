package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.store.mapper.ComsumeMapper;
import com.sinco.carnation.store.model.Comsume;
import com.sinco.carnation.store.bo.ComsumeBO;
import com.sinco.carnation.store.model.ComsumeExample;

@Repository
public class ComsumeDao {

	@Autowired
	private ComsumeMapper mapper;

	/** generate code begin **/
	public List<ComsumeBO> findAll() {
		ComsumeExample example = new ComsumeExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ComsumeExample example = new ComsumeExample();
		return mapper.countByExample(example);
	}

	public List<Comsume> save(Iterable<Comsume> entities) {
		List<Comsume> list = new ArrayList<Comsume>();
		for (Comsume Comsume : entities) {
			list.add(save(Comsume));
		}
		return list;
	}

	public Comsume save(Comsume record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Comsume record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ComsumeBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ComsumeBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ComsumeExample example = new ComsumeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ComsumeBO> findAll(Iterable<Long> ids) {
		ComsumeExample example = new ComsumeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Comsume entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Comsume> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Comsume entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ComsumeExample example = new ComsumeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ComsumeExample example = new ComsumeExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
