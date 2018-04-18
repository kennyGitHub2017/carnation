package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.InvitationClassBO;
import com.sinco.carnation.sns.mapper.InvitationClassMapper;
import com.sinco.carnation.sns.model.InvitationClass;
import com.sinco.carnation.sns.model.InvitationClassExample;
import com.sinco.dal.common.MyPage;

@Repository
public class InvitationClassDao {

	@Autowired
	private InvitationClassMapper mapper;

	/** generate code begin **/
	public List<InvitationClass> findAll() {
		InvitationClassExample example = new InvitationClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		InvitationClassExample example = new InvitationClassExample();
		return mapper.countByExample(example);
	}

	public List<InvitationClass> save(Iterable<InvitationClass> entities) {
		List<InvitationClass> list = new ArrayList<InvitationClass>();
		for (InvitationClass InvitationClass : entities) {
			list.add(save(InvitationClass));
		}
		return list;
	}

	public InvitationClass save(InvitationClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(InvitationClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public InvitationClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public InvitationClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		InvitationClassExample example = new InvitationClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<InvitationClass> findAll(Iterable<Long> ids) {
		InvitationClassExample example = new InvitationClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(InvitationClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<InvitationClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (InvitationClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		InvitationClassExample example = new InvitationClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		InvitationClassExample example = new InvitationClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<InvitationClassBO> queryInvitationClass(String name, Long parentId,
			MyPage<InvitationClassBO> page) {
		return mapper.queryInvitationClass(name, parentId, page);
	}

	public List<InvitationClassBO> queryInvitationClassBoByParentId(Long parentId) {
		return mapper.queryInvitationClassBoByParentId(parentId);
	}

	public Long countChild(Long id) {
		return mapper.countChild(id);
	}

	public List<InvitationClassBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}
}
