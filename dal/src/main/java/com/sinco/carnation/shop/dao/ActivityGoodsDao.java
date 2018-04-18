package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.ActivityGoodsMapper;
import com.sinco.carnation.shop.model.ActivityGoods;
import com.sinco.carnation.shop.bo.ActivityGoodsBO;
import com.sinco.carnation.shop.model.ActivityGoodsExample;

@Repository
public class ActivityGoodsDao {

	@Autowired
	private ActivityGoodsMapper mapper;

	/** generate code begin **/
	public List<ActivityGoodsBO> findAll() {
		ActivityGoodsExample example = new ActivityGoodsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ActivityGoodsExample example = new ActivityGoodsExample();
		return mapper.countByExample(example);
	}

	public List<ActivityGoods> save(Iterable<ActivityGoods> entities) {
		List<ActivityGoods> list = new ArrayList<ActivityGoods>();
		for (ActivityGoods ActivityGoods : entities) {
			list.add(save(ActivityGoods));
		}
		return list;
	}

	public ActivityGoods save(ActivityGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActivityGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActivityGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ActivityGoodsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActivityGoodsExample example = new ActivityGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ActivityGoodsBO> findAll(Iterable<Long> ids) {
		ActivityGoodsExample example = new ActivityGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActivityGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActivityGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActivityGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActivityGoodsExample example = new ActivityGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActivityGoodsExample example = new ActivityGoodsExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
