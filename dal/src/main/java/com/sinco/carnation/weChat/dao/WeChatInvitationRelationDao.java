package com.sinco.carnation.weChat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.weChat.mapper.WeChatInvitationRelationMapper;
import com.sinco.carnation.weChat.model.WeChatInvitationRelation;
import com.sinco.carnation.weChat.bo.WeChatInvitationRelationBO;
import com.sinco.carnation.weChat.model.WeChatInvitationRelationExample;

@Repository
public class WeChatInvitationRelationDao {

	@Autowired
	private WeChatInvitationRelationMapper mapper;

	/** generate code begin **/
	public List<WeChatInvitationRelationBO> findAll() {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		return mapper.selectByExample(example);
	}

	List<WeChatInvitationRelationBO> findAll(Iterable<Long> ids) {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		return mapper.countByExample(example);
	}

	public List<WeChatInvitationRelation> save(Iterable<WeChatInvitationRelation> entities) {
		List<WeChatInvitationRelation> list = new ArrayList<WeChatInvitationRelation>();
		for (WeChatInvitationRelation WeChatInvitationRelation : entities) {
			list.add(save(WeChatInvitationRelation));
		}
		return list;
	}

	public WeChatInvitationRelation save(WeChatInvitationRelation record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WeChatInvitationRelation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WeChatInvitationRelationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WeChatInvitationRelation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WeChatInvitationRelation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WeChatInvitationRelation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WeChatInvitationRelationExample example = new WeChatInvitationRelationExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
