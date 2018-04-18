package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.WatermarkMapper;
import com.sinco.carnation.shop.model.Watermark;
import com.sinco.carnation.shop.model.WatermarkExample;

@Repository
public class WatermarkDao {

	@Autowired
	private WatermarkMapper mapper;

	/** generate code begin **/
	public List<Watermark> findAll() {
		WatermarkExample example = new WatermarkExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		WatermarkExample example = new WatermarkExample();
		return mapper.countByExample(example);
	}

	public List<Watermark> save(Iterable<Watermark> entities) {
		List<Watermark> list = new ArrayList<Watermark>();
		for (Watermark Watermark : entities) {
			list.add(save(Watermark));
		}
		return list;
	}

	public Watermark save(Watermark record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Watermark record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Watermark findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Watermark get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WatermarkExample example = new WatermarkExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Watermark> findAll(Iterable<Long> ids) {
		WatermarkExample example = new WatermarkExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Watermark entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Watermark> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Watermark entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WatermarkExample example = new WatermarkExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WatermarkExample example = new WatermarkExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
