package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.PartnerMapper;
import com.sinco.carnation.sys.model.Partner;
import com.sinco.carnation.sys.bo.PartnerBO;
import com.sinco.carnation.sys.model.PartnerExample;

@Repository
public class PartnerDao {

	@Autowired
	private PartnerMapper mapper;

	public List<PartnerBO> findImg(boolean isNull) {
		PartnerExample example = new PartnerExample();
		if (isNull) {
			example.createCriteria().andImagePathIsNull();
		} else {
			example.createCriteria().andImagePathIsNotNull();
		}
		example.setOrderByClause("sequence asc");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<PartnerBO> findAll() {
		PartnerExample example = new PartnerExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PartnerExample example = new PartnerExample();
		return mapper.countByExample(example);
	}

	public List<Partner> save(Iterable<Partner> entities) {
		List<Partner> list = new ArrayList<Partner>();
		for (Partner Partner : entities) {
			list.add(save(Partner));
		}
		return list;
	}

	public Partner save(Partner record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Partner record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PartnerBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PartnerBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PartnerExample example = new PartnerExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PartnerBO> findAll(Iterable<Long> ids) {
		PartnerExample example = new PartnerExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Partner entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Partner> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Partner entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PartnerExample example = new PartnerExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PartnerExample example = new PartnerExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
