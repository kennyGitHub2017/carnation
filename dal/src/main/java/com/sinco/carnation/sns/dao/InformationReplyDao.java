package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.mapper.InformationReplyMapper;
import com.sinco.carnation.sns.model.InformationReply;
import com.sinco.carnation.sns.model.InformationReplyExample;

@Repository
public class InformationReplyDao {

	@Autowired
	private InformationReplyMapper mapper;

	public int queryComment(Long id) {
		InformationReplyExample example = new InformationReplyExample();
		example.createCriteria().andInfoIdEqualTo(id);
		return mapper.countByExample(example);

	}

	public List<InformationReply> findAll() {
		InformationReplyExample example = new InformationReplyExample();
		return mapper.selectByExample(example);
	}

	public List<InformationReply> save(Iterable<InformationReply> entities) {
		List<InformationReply> list = new ArrayList<InformationReply>();
		for (InformationReply InformationReply : entities) {
			list.add(save(InformationReply));
		}
		return list;
	}

	public InformationReply save(InformationReply record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(InformationReply record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public InformationReply findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public InformationReply get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		InformationReplyExample example = new InformationReplyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<InformationReply> findAll(Iterable<Long> ids) {
		InformationReplyExample example = new InformationReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		InformationReplyExample example = new InformationReplyExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(InformationReply entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<InformationReply> entities) {
		List<Long> ids = Lists.newArrayList();
		for (InformationReply entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		InformationReplyExample example = new InformationReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		InformationReplyExample example = new InformationReplyExample();
		mapper.deleteByExample(example);
	}

}
