package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.mapper.GoodsBrandCategoryMapper;
import com.sinco.carnation.goods.model.GoodsBrandCategory;
import com.sinco.carnation.goods.model.GoodsBrandCategoryExample;

@Repository
public class GoodsBrandCategoryDao {

	@Autowired
	private GoodsBrandCategoryMapper mapper;

	/**
	 * 根据名称查找
	 * 
	 * @param name
	 * @return
	 */
	public GoodsBrandCategory findByName(String name) {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		example.createCriteria().andNameEqualTo(name);
		List<GoodsBrandCategory> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<GoodsBrandCategoryBO> findAll() {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		example.setOrderByClause("sequence asc");
		return mapper.selectBOByExample(example);
	}

	public long count() {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		return mapper.countByExample(example);
	}

	public List<GoodsBrandCategory> save(Iterable<GoodsBrandCategory> entities) {
		List<GoodsBrandCategory> list = new ArrayList<GoodsBrandCategory>();
		for (GoodsBrandCategory GoodsBrandCategory : entities) {
			list.add(save(GoodsBrandCategory));
		}
		return list;
	}

	public GoodsBrandCategory save(GoodsBrandCategory record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsBrandCategory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsBrandCategory findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsBrandCategory get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsBrandCategory> findAll(Iterable<Long> ids) {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsBrandCategory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsBrandCategory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsBrandCategory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsBrandCategoryExample example = new GoodsBrandCategoryExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
