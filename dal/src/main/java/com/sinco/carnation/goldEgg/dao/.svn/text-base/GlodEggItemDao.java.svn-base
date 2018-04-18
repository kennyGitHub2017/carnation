package com.sinco.carnation.goldEgg.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.goldEgg.mapper.GlodEggItemMapper;
import com.sinco.carnation.goldEgg.model.GlodEggItem;
import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.model.GlodEggItemExample;

@Repository
public class GlodEggItemDao {

	@Autowired
	private GlodEggItemMapper mapper;

	/** generate code begin **/
	public List<GlodEggItemBO> findAll() {
		GlodEggItemExample example = new GlodEggItemExample();
		return mapper.selectByExample(example);
	}

	List<GlodEggItemBO> findAll(Iterable<Long> ids) {
		GlodEggItemExample example = new GlodEggItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		GlodEggItemExample example = new GlodEggItemExample();
		return mapper.countByExample(example);
	}

	public List<GlodEggItem> save(Iterable<GlodEggItem> entities) {
		List<GlodEggItem> list = new ArrayList<GlodEggItem>();
		for (GlodEggItem GlodEggItem : entities) {
			list.add(save(GlodEggItem));
		}
		return list;
	}

	public GlodEggItem save(GlodEggItem record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GlodEggItem record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GlodEggItemBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GlodEggItemExample example = new GlodEggItemExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GlodEggItem entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GlodEggItem> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GlodEggItem entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GlodEggItemExample example = new GlodEggItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GlodEggItemExample example = new GlodEggItemExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public void addCurrentGetCount(Long id, long num) {
		mapper.addCurrentGetCount(id, num);
	}

	public void deleteByGlodEggID(Long glodEggID) {
		this.mapper.deleteByGlodEggID(glodEggID);
	}

	public List<GlodEggItemBO> findByGlodEggID(Long act_GlodEgg_ID) {
		List<GlodEggItemBO> result_List = this.mapper.findByGlodEggID(act_GlodEgg_ID);
		return result_List;
	}
}
