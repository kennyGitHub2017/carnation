package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.goods.mapper.BrandCategoryMapper;
import com.sinco.carnation.goods.model.BrandCategory;
import com.sinco.carnation.goods.model.BrandCategoryExample;

@Repository
public class BrandCategoryDao {

	@Autowired
	private BrandCategoryMapper mapper;

	/** generate code begin **/
	public List<BrandCategory> findAll() {
		BrandCategoryExample example = new BrandCategoryExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		BrandCategoryExample example = new BrandCategoryExample();
		return mapper.countByExample(example);
	}

	public List<BrandCategory> save(Iterable<BrandCategory> entities) {
		List<BrandCategory> list = new ArrayList<BrandCategory>();
		for (BrandCategory BrandCategory : entities) {
			list.add(save(BrandCategory));
		}
		return list;
	}

	public BrandCategory save(BrandCategory record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(BrandCategory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public BrandCategory findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public BrandCategory get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		BrandCategoryExample example = new BrandCategoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<BrandCategory> findAll(Iterable<Long> ids) {
		BrandCategoryExample example = new BrandCategoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(BrandCategory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<BrandCategory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (BrandCategory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		BrandCategoryExample example = new BrandCategoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		BrandCategoryExample example = new BrandCategoryExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
