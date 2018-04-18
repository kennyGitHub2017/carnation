package com.sinco.carnation.notice.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.notice.mapper.NoticeMessageMapper;
import com.sinco.carnation.notice.model.NoticeMessage;
import com.sinco.carnation.notice.bo.NoticeMessageBO;
import com.sinco.carnation.notice.model.NoticeMessageExample;

@Repository
public class NoticeMessageDao {

	@Autowired
	private NoticeMessageMapper mapper;

	/** generate code begin **/
	public List<NoticeMessageBO> findAll() {
		NoticeMessageExample example = new NoticeMessageExample();
		return mapper.selectByExample(example);
	}

	List<NoticeMessageBO> findAll(Iterable<Long> ids) {
		NoticeMessageExample example = new NoticeMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		NoticeMessageExample example = new NoticeMessageExample();
		return mapper.countByExample(example);
	}

	public List<NoticeMessage> save(Iterable<NoticeMessage> entities) {
		List<NoticeMessage> list = new ArrayList<NoticeMessage>();
		for (NoticeMessage NoticeMessage : entities) {
			list.add(save(NoticeMessage));
		}
		return list;
	}

	public NoticeMessage save(NoticeMessage record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(NoticeMessage record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public NoticeMessageBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		NoticeMessageExample example = new NoticeMessageExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(NoticeMessage entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<NoticeMessage> entities) {
		List<Long> ids = Lists.newArrayList();
		for (NoticeMessage entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		NoticeMessageExample example = new NoticeMessageExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		NoticeMessageExample example = new NoticeMessageExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/

	public int queryUnreadMessageCount(Long uid, int noticeType) {
		return mapper.queryUnreadMessageCount(uid, noticeType);
	}

	public void cleanUnreadMessage(Long uid, int noticeType) {
		mapper.cleanUnreadMessage(uid, noticeType);
	}
}
