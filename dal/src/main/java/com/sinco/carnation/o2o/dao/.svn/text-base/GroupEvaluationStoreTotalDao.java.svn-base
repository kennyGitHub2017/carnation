package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.o2o.mapper.GroupEvaluationStoreTotalMapper;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotal;
import com.sinco.carnation.o2o.bo.GroupEvaluationStoreTotalBO;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotalExample;

@Repository
public class GroupEvaluationStoreTotalDao {

	@Autowired
	private GroupEvaluationStoreTotalMapper mapper;

	/** generate code begin **/
	public List<GroupEvaluationStoreTotalBO> findAll() {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		return mapper.countByExample(example);
	}

	public List<GroupEvaluationStoreTotal> save(Iterable<GroupEvaluationStoreTotal> entities) {
		List<GroupEvaluationStoreTotal> list = new ArrayList<GroupEvaluationStoreTotal>();
		for (GroupEvaluationStoreTotal GroupEvaluationStoreTotal : entities) {
			list.add(save(GroupEvaluationStoreTotal));
		}
		return list;
	}

	public GroupEvaluationStoreTotal save(GroupEvaluationStoreTotal record) {
		if (record.getStoreId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public GroupEvaluationStoreTotal add(GroupEvaluationStoreTotal self) {
		mapper.insertSelective(self);
		return self;
	}

	public void update(GroupEvaluationStoreTotal record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupEvaluationStoreTotalBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupEvaluationStoreTotalBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		example.createCriteria().andStoreIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupEvaluationStoreTotalBO> findAll(Iterable<Long> ids) {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		example.createCriteria().andStoreIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupEvaluationStoreTotal entity) {
		mapper.deleteByPrimaryKey(entity.getStoreId());
	}

	public void delete(Iterable<GroupEvaluationStoreTotal> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupEvaluationStoreTotal entity : entities) {
			ids.add(entity.getStoreId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		example.createCriteria().andStoreIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupEvaluationStoreTotalExample example = new GroupEvaluationStoreTotalExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupEvaluationStoreTotalBO> queryByExample(GroupEvaluationStoreTotalExample totalExample) {
		return mapper.selectByExample(totalExample);
	}
}
