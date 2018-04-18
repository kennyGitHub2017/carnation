package com.sinco.carnation.o2o.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.o2o.bo.GroupOrderLogBO;
import com.sinco.carnation.o2o.dao.GroupOrderLogDao;
import com.sinco.carnation.o2o.model.GroupOrderLog;
import com.sinco.carnation.o2o.vo.GroupOrderLogVO;

@Service
@Transactional(rollbackFor = {Exception.class})
public class GroupOrderLogService {
	@Autowired
	GroupOrderLogDao groupOrderLogDao;

	public List<GroupOrderLogBO> findAll() {
		return groupOrderLogDao.findAll();
	}

	public long count() {
		return groupOrderLogDao.count();
	}

	public List<GroupOrderLog> save(Iterable<GroupOrderLog> entities) {
		return groupOrderLogDao.save(entities);
	}

	public GroupOrderLog save(GroupOrderLog record) {
		return groupOrderLogDao.save(record);
	}

	public void update(GroupOrderLog record) {
		groupOrderLogDao.update(record);
	}

	public GroupOrderLogBO findOne(java.lang.Long id) {
		return groupOrderLogDao.findOne(id);
	}

	public GroupOrderLogBO get(java.lang.Long id) {
		return groupOrderLogDao.get(id);
	}

	public boolean exists(java.lang.Long id) {
		return groupOrderLogDao.exists(id);
	}

	public List<GroupOrderLogBO> findAll(Iterable<Long> ids) {
		return groupOrderLogDao.findAll(ids);
	}

	public void delete(java.lang.Long id) {
		groupOrderLogDao.delete(id);
	}

	public void remove(java.lang.Long id) {
		groupOrderLogDao.remove(id);
	}

	public void delete(GroupOrderLog entity) {
		groupOrderLogDao.delete(entity.getId());
	}

	public void delete(Iterable<GroupOrderLog> entities) {
		groupOrderLogDao.delete(entities);
	}

	public void deleteByIds(Iterable<Long> ids) {
		groupOrderLogDao.deleteByIds(ids);
	}

	public void deleteAll() {
		groupOrderLogDao.deleteAll();
	}

	public List<GroupOrderLogBO> selectByVO(@Param("vo") GroupOrderLogVO vo) {
		return groupOrderLogDao.selectByVO(vo);
	}
}
