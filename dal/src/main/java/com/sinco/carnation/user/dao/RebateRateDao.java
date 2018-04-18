package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.user.bo.RebateRateBO;
import com.sinco.carnation.user.mapper.RebateRateMapper;
import com.sinco.carnation.user.model.RebateRate;
import com.sinco.carnation.user.model.RebateRateExample;

@Repository
public class RebateRateDao {

	@Autowired
	private RebateRateMapper mapper;

	@PostConstruct
	public void init() {
		List<RebateRateBO> list = findAll();
		if (CollectionUtils.isNotEmpty(list)) {
			RebateConstants.MAP_RATE = new HashMap<>();
			for (RebateRateBO rebateRateBO : list) {
				RebateConstants.MAP_RATE.put(rebateRateBO.getCode(), rebateRateBO);
			}
		}
	}

	/** generate code begin **/
	public List<RebateRateBO> findAll() {
		RebateRateExample example = new RebateRateExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RebateRateExample example = new RebateRateExample();
		return mapper.countByExample(example);
	}

	public List<RebateRate> save(Iterable<RebateRate> entities) {
		List<RebateRate> list = new ArrayList<RebateRate>();
		for (RebateRate RebateRate : entities) {
			list.add(save(RebateRate));
		}
		return list;
	}

	public RebateRate save(RebateRate record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RebateRate record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RebateRateBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RebateRateBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RebateRateExample example = new RebateRateExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RebateRateBO> findAll(Iterable<Long> ids) {
		RebateRateExample example = new RebateRateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RebateRate entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RebateRate> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RebateRate entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RebateRateExample example = new RebateRateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RebateRateExample example = new RebateRateExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
