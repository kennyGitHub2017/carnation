package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.WxMsgLogMapper;
import com.sinco.carnation.sys.model.WxMsgLog;
import com.sinco.carnation.sys.bo.WxMsgLogBO;
import com.sinco.carnation.sys.model.WxMsgLogExample;

@Repository
public class WxMsgLogDao {

	@Autowired
	private WxMsgLogMapper mapper;

	/** generate code begin **/
	public List<WxMsgLogBO> findAll() {
		WxMsgLogExample example = new WxMsgLogExample();
		return mapper.selectByExample(example);
	}

	List<WxMsgLogBO> findAll(Iterable<Long> ids) {
		WxMsgLogExample example = new WxMsgLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WxMsgLogExample example = new WxMsgLogExample();
		return mapper.countByExample(example);
	}

	public List<WxMsgLog> save(Iterable<WxMsgLog> entities) {
		List<WxMsgLog> list = new ArrayList<WxMsgLog>();
		for (WxMsgLog WxMsgLog : entities) {
			list.add(save(WxMsgLog));
		}
		return list;
	}

	public WxMsgLog save(WxMsgLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WxMsgLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WxMsgLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WxMsgLogExample example = new WxMsgLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WxMsgLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WxMsgLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WxMsgLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WxMsgLogExample example = new WxMsgLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WxMsgLogExample example = new WxMsgLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
