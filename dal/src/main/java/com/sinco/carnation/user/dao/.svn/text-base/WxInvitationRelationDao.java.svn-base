package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.WxInvitationRelationMapper;
import com.sinco.carnation.user.model.WxInvitationRelation;
import com.sinco.carnation.user.bo.WxInvitationRelationBO;
import com.sinco.carnation.user.model.WxInvitationRelationExample;

@Repository
public class WxInvitationRelationDao {

	@Autowired
	private WxInvitationRelationMapper mapper;

	/** generate code begin **/
	public List<WxInvitationRelationBO> findAll() {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		return mapper.selectByExample(example);
	}

	List<WxInvitationRelationBO> findAll(Iterable<Long> ids) {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		return mapper.countByExample(example);
	}

	public List<WxInvitationRelation> save(Iterable<WxInvitationRelation> entities) {
		List<WxInvitationRelation> list = new ArrayList<WxInvitationRelation>();
		for (WxInvitationRelation WxInvitationRelation : entities) {
			list.add(save(WxInvitationRelation));
		}
		return list;
	}

	public WxInvitationRelation save(WxInvitationRelation record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WxInvitationRelation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WxInvitationRelationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WxInvitationRelation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WxInvitationRelation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WxInvitationRelation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * ����unionId�����Ƿ����
	 * 
	 * @param unionId
	 * @return
	 */
	public WxInvitationRelationBO findByUnionId(String unionId) {
		WxInvitationRelationExample example = new WxInvitationRelationExample();
		example.createCriteria().andUnionIdEqualTo(unionId);
		List<WxInvitationRelationBO> list = mapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public WxInvitationRelationBO getWxAuthInfo(Long userId) {
		return this.mapper.getWxAuthInfo(userId);
	}

	public int saveWxAuthInfo(String openId, Long userId) {
		return this.mapper.saveWxAuthInfo(openId, userId);
	}
}
