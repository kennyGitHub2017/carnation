package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.CmsIndexTemplateMapper;
import com.sinco.carnation.sns.model.CmsIndexTemplate;
import com.sinco.carnation.sns.model.CmsIndexTemplateExample;

@Repository
public class CmsIndexTemplateDao {

	@Autowired
	private CmsIndexTemplateMapper mapper;

	public List<CmsIndexTemplate> findAll() {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		return mapper.selectByExample(example);
	}

	public List<CmsIndexTemplate> save(Iterable<CmsIndexTemplate> entities) {
		List<CmsIndexTemplate> list = new ArrayList<CmsIndexTemplate>();
		for (CmsIndexTemplate CmsIndexTemplate : entities) {
			list.add(save(CmsIndexTemplate));
		}
		return list;
	}

	public CmsIndexTemplate save(CmsIndexTemplate record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CmsIndexTemplate record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CmsIndexTemplate findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CmsIndexTemplate get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CmsIndexTemplate> findAll(Iterable<Long> ids) {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CmsIndexTemplate entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CmsIndexTemplate> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CmsIndexTemplate entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CmsIndexTemplateExample example = new CmsIndexTemplateExample();
		mapper.deleteByExample(example);
	}

}
