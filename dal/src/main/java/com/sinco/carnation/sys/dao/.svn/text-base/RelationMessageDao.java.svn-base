package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.RelationMessageMapper;
import com.sinco.carnation.sys.model.RelationMessage;
import com.sinco.carnation.sys.bo.RelationMessageBO;
import com.sinco.carnation.sys.model.RelationMessageExample;

@Repository
public class RelationMessageDao {

	@Autowired
	private RelationMessageMapper mapper;

	/** generate code begin **/
	public List<RelationMessageBO> findAll() {
		RelationMessageExample example = new RelationMessageExample();
		return mapper.selectByExample(example);
	}

	List<RelationMessageBO> findAll(Iterable<Long> ids) {
		RelationMessageExample example = new RelationMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		RelationMessageExample example = new RelationMessageExample();
		return mapper.countByExample(example);
	}

	public List<RelationMessage> save(Iterable<RelationMessage> entities) {
		List<RelationMessage> list = new ArrayList<RelationMessage>();
		for (RelationMessage RelationMessage : entities) {
			list.add(save(RelationMessage));
		}
		return list;
	}

	public RelationMessage save(RelationMessage record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RelationMessage record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RelationMessageBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RelationMessageExample example = new RelationMessageExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RelationMessage entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RelationMessage> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RelationMessage entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RelationMessageExample example = new RelationMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RelationMessageExample example = new RelationMessageExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public RelationMessage findById(Long id) {
		return mapper.findById(id);
	}

	public List<RelationMessageBO> findAllDelStatusFalse() {
		return mapper.findAllDelStatusFalse();
	}
}
