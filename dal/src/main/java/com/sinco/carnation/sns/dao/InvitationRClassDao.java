package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.InvitationRClassMapper;
import com.sinco.carnation.sns.model.InvitationRClass;
import com.sinco.carnation.sns.model.InvitationRClassExample;

@Repository
public class InvitationRClassDao {

	@Autowired
	private InvitationRClassMapper mapper;

	/** generate code begin **/
	public List<InvitationRClass> findAll() {
		InvitationRClassExample example = new InvitationRClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		InvitationRClassExample example = new InvitationRClassExample();
		return mapper.countByExample(example);
	}

	public List<InvitationRClass> save(Iterable<InvitationRClass> entities) {
		List<InvitationRClass> list = new ArrayList<InvitationRClass>();
		for (InvitationRClass InvitationRClass : entities) {
			list.add(save(InvitationRClass));
		}
		return list;
	}

	public InvitationRClass save(InvitationRClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(InvitationRClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public InvitationRClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public InvitationRClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		InvitationRClassExample example = new InvitationRClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<InvitationRClass> findAll(Iterable<Long> ids) {
		InvitationRClassExample example = new InvitationRClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(InvitationRClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<InvitationRClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (InvitationRClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		InvitationRClassExample example = new InvitationRClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		InvitationRClassExample example = new InvitationRClassExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
