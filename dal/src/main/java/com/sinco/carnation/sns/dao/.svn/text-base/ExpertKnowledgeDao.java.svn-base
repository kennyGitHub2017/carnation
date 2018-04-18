package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.ExpertKnowledgeBO;
import com.sinco.carnation.sns.mapper.ExpertKnowledgeMapper;
import com.sinco.carnation.sns.model.ExpertKnowledge;
import com.sinco.carnation.sns.model.ExpertKnowledgeExample;
import com.sinco.dal.common.MyPage;

@Repository
public class ExpertKnowledgeDao {

	@Autowired
	private ExpertKnowledgeMapper mapper;

	/** generate code begin **/
	public List<ExpertKnowledgeBO> findAll() {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		return mapper.selectByExample(example);
	}

	List<ExpertKnowledgeBO> findAll(Iterable<Long> ids) {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		return mapper.countByExample(example);
	}

	public List<ExpertKnowledge> save(Iterable<ExpertKnowledge> entities) {
		List<ExpertKnowledge> list = new ArrayList<ExpertKnowledge>();
		for (ExpertKnowledge ExpertKnowledge : entities) {
			list.add(save(ExpertKnowledge));
		}
		return list;
	}

	public ExpertKnowledge save(ExpertKnowledge record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ExpertKnowledge record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ExpertKnowledgeBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ExpertKnowledge entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ExpertKnowledge> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ExpertKnowledge entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ExpertKnowledgeExample example = new ExpertKnowledgeExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ExpertKnowledgeBO> queryExpertKnowledgeList(String title, MyPage<ExpertKnowledgeBO> page) {
		return mapper.queryExpertKnowledgeList(title, page);
	}

	public List<ExpertKnowledgeBO> queryKnowledgeByclassId(Long id) {
		return mapper.queryKnowledgeByclassId(id);
	}

	public List<ExpertKnowledgeBO> searchKnowList(String id, String name) {
		return mapper.searchKnowList(id, name);
	}
}
