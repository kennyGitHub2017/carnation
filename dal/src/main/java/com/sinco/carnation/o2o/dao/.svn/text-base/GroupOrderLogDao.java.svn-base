package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.o2o.mapper.GroupOrderLogMapper;
import com.sinco.carnation.o2o.model.GroupOrderLog;
import com.sinco.carnation.o2o.bo.GroupOrderLogBO;
import com.sinco.carnation.o2o.model.GroupOrderLogExample;
import com.sinco.carnation.o2o.vo.GroupOrderLogVO;

@Repository
public class GroupOrderLogDao {

	@Autowired
	private GroupOrderLogMapper mapper;

	/** generate code begin **/
	public List<GroupOrderLogBO> findAll() {
		GroupOrderLogExample example = new GroupOrderLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupOrderLogExample example = new GroupOrderLogExample();
		return mapper.countByExample(example);
	}

	public List<GroupOrderLog> save(Iterable<GroupOrderLog> entities) {
		List<GroupOrderLog> list = new ArrayList<GroupOrderLog>();
		for (GroupOrderLog GroupOrderLog : entities) {
			list.add(save(GroupOrderLog));
		}
		return list;
	}

	public GroupOrderLog save(GroupOrderLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupOrderLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupOrderLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupOrderLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupOrderLogExample example = new GroupOrderLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public List<GroupOrderLogBO> findAll(Iterable<Long> ids) {
		GroupOrderLogExample example = new GroupOrderLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupOrderLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupOrderLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupOrderLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupOrderLogExample example = new GroupOrderLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupOrderLogExample example = new GroupOrderLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupOrderLogBO> selectByVO(@Param("vo") GroupOrderLogVO vo) {
		return mapper.selectByVO(vo);
	}
}
