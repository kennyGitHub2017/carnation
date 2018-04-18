package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ActivityBO;
import com.sinco.carnation.shop.mapper.ActivityMapper;
import com.sinco.carnation.shop.model.Activity;
import com.sinco.carnation.shop.model.ActivityExample;
import com.sinco.carnation.shop.vo.ActivityShopVO;

@Repository
public class ActivityDao {

	@Autowired
	private ActivityMapper mapper;

	/**
	 * 得到商城
	 * 
	 * @param vo
	 * @return
	 */
	public List<ActivityBO> findShopByVO(ActivityShopVO vo) {
		return null;
	}

	/** generate code begin **/
	public List<ActivityBO> findAll() {
		ActivityExample example = new ActivityExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ActivityExample example = new ActivityExample();
		return mapper.countByExample(example);
	}

	public List<Activity> save(Iterable<Activity> entities) {
		List<Activity> list = new ArrayList<Activity>();
		for (Activity Activity : entities) {
			list.add(save(Activity));
		}
		return list;
	}

	public Activity save(Activity record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Activity record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActivityBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ActivityBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActivityExample example = new ActivityExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ActivityBO> findAll(Iterable<Long> ids) {
		ActivityExample example = new ActivityExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Activity entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Activity> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Activity entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActivityExample example = new ActivityExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActivityExample example = new ActivityExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
