package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CircleInvitationReplyBO;
import com.sinco.carnation.sns.mapper.CircleInvitationReplyMapper;
import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.carnation.sns.model.CircleInvitationReplyExample;
import com.sinco.carnation.sns.vo.CircleInvitationReplyVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CircleInvitationReplyDao {

	@Autowired
	private CircleInvitationReplyMapper mapper;

	public List<CircleInvitationReply> findAll() {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		return mapper.selectByExample(example);
	}

	public List<CircleInvitationReply> save(Iterable<CircleInvitationReply> entities) {
		List<CircleInvitationReply> list = new ArrayList<CircleInvitationReply>();
		for (CircleInvitationReply CircleInvitationReply : entities) {
			list.add(save(CircleInvitationReply));
		}
		return list;
	}

	public CircleInvitationReply save(CircleInvitationReply record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CircleInvitationReply record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CircleInvitationReply findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CircleInvitationReply get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CircleInvitationReply> findAll(Iterable<Long> ids) {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<CircleInvitationReply> selectPageByVO(CircleInvitationReplyVO vo,
			MyPage<CircleInvitationReply> page) {
		return mapper.selectPageByVO(vo, page);
	}

	public long count() {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CircleInvitationReply entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CircleInvitationReply> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CircleInvitationReply entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CircleInvitationReplyExample example = new CircleInvitationReplyExample();
		mapper.deleteByExample(example);
	}

	public List<CircleInvitationReplyBO> replyList(Long maxId, Long invitationId, Integer start,
			Integer pageSize) {
		return mapper.invitationReplyList(maxId, invitationId, start, pageSize);
	}

	public int addReplyInvitation(CircleInvitationReply reply) {
		return mapper.insertSelective(reply);
	}

	public int intreplyInvitationCount(Long invitationId) {
		return mapper.replyInvitationCount(invitationId);
	};

	/** 查询未加分记录 **/
	public List<CircleInvitationReply> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
