package com.sinco.carnation.sys.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.mapper.SysConfigMapper;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.SysConfigExample;

@Repository
public class SysConfigDao {

	@Autowired
	private SysConfigMapper mapper;

	public int addConfigAmount(BigDecimal payoffAllAmount, BigDecimal payoffAllAmountReality,
			BigDecimal payoffAllCommission, BigDecimal payoffAllSale) {
		return mapper.addConfigAmount(payoffAllAmount, payoffAllAmountReality, payoffAllCommission,
				payoffAllSale);
	}

	public List<SysConfigBO> findAll() {
		SysConfigExample example = new SysConfigExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		SysConfigExample example = new SysConfigExample();
		return mapper.countByExample(example);
	}

	public List<SysConfig> save(Iterable<SysConfig> entities) {
		List<SysConfig> list = new ArrayList<SysConfig>();
		for (SysConfig SysConfig : entities) {
			list.add(save(SysConfig));
		}
		return list;
	}

	public SysConfig save(SysConfig record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(SysConfig record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SysConfig findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public SysConfig get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SysConfigExample example = new SysConfigExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<SysConfigBO> findAll(Iterable<Long> ids) {
		SysConfigExample example = new SysConfigExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SysConfig entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SysConfig> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SysConfig entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SysConfigExample example = new SysConfigExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SysConfigExample example = new SysConfigExample();
		mapper.deleteByExample(example);
	}

}
