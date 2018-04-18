package com.sinco.carnation.weChat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.weChat.mapper.WeChatMsgLogMapper;
import com.sinco.carnation.weChat.model.WeChatMsgLog;
import com.sinco.carnation.weChat.bo.WeChatMsgLogBO;
import com.sinco.carnation.weChat.model.WeChatMsgLogExample;

@Repository
public class WeChatMsgLogDao {

	@Autowired
	private WeChatMsgLogMapper mapper;

	/** generate code begin **/
	public List<WeChatMsgLogBO> findAll() {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		return mapper.selectByExample(example);
	}

	List<WeChatMsgLogBO> findAll(Iterable<Long> ids) {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		return mapper.countByExample(example);
	}

	public List<WeChatMsgLog> save(Iterable<WeChatMsgLog> entities) {
		List<WeChatMsgLog> list = new ArrayList<WeChatMsgLog>();
		for (WeChatMsgLog WeChatMsgLog : entities) {
			list.add(save(WeChatMsgLog));
		}
		return list;
	}

	public WeChatMsgLog save(WeChatMsgLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WeChatMsgLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WeChatMsgLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WeChatMsgLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WeChatMsgLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WeChatMsgLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WeChatMsgLogExample example = new WeChatMsgLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
