package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.KnowledgeClassBO;
import com.sinco.carnation.sns.mapper.KnowledgeClassMapper;
import com.sinco.carnation.sns.model.KnowledgeClass;
import com.sinco.carnation.sns.model.KnowledgeClassExample;
import com.sinco.dal.common.MyPage;

@Repository
public class KnowledgeClassDao {

	@Autowired
	private KnowledgeClassMapper mapper;

	/** generate code begin **/
	public List<KnowledgeClassBO> findAll() {
		KnowledgeClassExample example = new KnowledgeClassExample();
		return mapper.selectByExample(example);
	}

	List<KnowledgeClassBO> findAll(Iterable<Long> ids) {
		KnowledgeClassExample example = new KnowledgeClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		KnowledgeClassExample example = new KnowledgeClassExample();
		return mapper.countByExample(example);
	}

	public List<KnowledgeClass> save(Iterable<KnowledgeClass> entities) {
		List<KnowledgeClass> list = new ArrayList<KnowledgeClass>();
		for (KnowledgeClass KnowledgeClass : entities) {
			list.add(save(KnowledgeClass));
		}
		return list;
	}

	public KnowledgeClass save(KnowledgeClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(KnowledgeClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public KnowledgeClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		KnowledgeClassExample example = new KnowledgeClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(KnowledgeClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<KnowledgeClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (KnowledgeClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		KnowledgeClassExample example = new KnowledgeClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		KnowledgeClassExample example = new KnowledgeClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<KnowledgeClassBO> queryKnowClassAll(String className, MyPage<KnowledgeClassBO> page) {
		return mapper.queryKnowClassAll(className, page);
	}
}
