package com.sinco.carnation.label.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.label.mapper.LabelCenterMapper;
import com.sinco.carnation.label.model.LabelCenter;
import com.sinco.carnation.label.bo.LabelCenterBO;
import com.sinco.carnation.label.model.LabelCenterExample;

@Repository
public class LabelCenterDao {

	@Autowired
	private LabelCenterMapper mapper;

	/** generate code begin **/
	public List<LabelCenterBO> findAll() {
		LabelCenterExample example = new LabelCenterExample();
		return mapper.selectByExample(example);
	}

	List<LabelCenterBO> findAll(Iterable<Long> ids) {
		LabelCenterExample example = new LabelCenterExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		LabelCenterExample example = new LabelCenterExample();
		return mapper.countByExample(example);
	}

	public List<LabelCenter> save(Iterable<LabelCenter> entities) {
		List<LabelCenter> list = new ArrayList<LabelCenter>();
		for (LabelCenter LabelCenter : entities) {
			list.add(save(LabelCenter));
		}
		return list;
	}

	public LabelCenter save(LabelCenter record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(LabelCenter record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public LabelCenterBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		LabelCenterExample example = new LabelCenterExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(LabelCenter entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<LabelCenter> entities) {
		List<Long> ids = Lists.newArrayList();
		for (LabelCenter entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		LabelCenterExample example = new LabelCenterExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		LabelCenterExample example = new LabelCenterExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public int batchInsert(String values) {
		return mapper.batchInsert(values);
	}
}
