package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.SysLogBO;
import com.sinco.carnation.sys.mapper.SysLogMapper;
import com.sinco.carnation.sys.model.SysLog;
import com.sinco.carnation.sys.model.SysLogExample;
import com.sinco.dal.common.MyPage;

@Repository
public class SysLogDao {

	@Autowired
	private SysLogMapper mapper;

	public List<SysLogBO> findByPage(MyPage<SysLogBO> page) {
		List<SysLogBO> list = mapper.findByPage(page);
		page.setContent(list);
		return list;
	}

	public List<SysLog> findAll() {
		SysLogExample example = new SysLogExample();
		return mapper.selectByExample(example);
	}

	public List<SysLog> save(Iterable<SysLog> entities) {
		List<SysLog> list = new ArrayList<SysLog>();
		for (SysLog SysLog : entities) {
			list.add(save(SysLog));
		}
		return list;
	}

	public SysLog save(SysLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(SysLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SysLog findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public SysLog get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SysLogExample example = new SysLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<SysLog> findAll(Iterable<Long> ids) {
		SysLogExample example = new SysLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		SysLogExample example = new SysLogExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SysLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SysLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SysLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SysLogExample example = new SysLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SysLogExample example = new SysLogExample();
		mapper.deleteByExample(example);
	}

	public List<SysLog> querySysLogByUid(Long userId) {
		return mapper.querySysLogByUid(userId);
	}

	public SysLog selectOneByUid(Long uid) {
		return this.mapper.selectOneByUid(uid);
	}
}
