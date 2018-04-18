package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.PhysicalTypeMapper;
import com.sinco.carnation.user.model.PhysicalType;
import com.sinco.carnation.user.bo.PhysicalTypeBO;
import com.sinco.carnation.user.model.PhysicalTypeExample;

@Repository
public class PhysicalTypeDao {

	@Autowired
	private PhysicalTypeMapper mapper;

	/** generate code begin **/
	public List<PhysicalTypeBO> findAll() {
		PhysicalTypeExample example = new PhysicalTypeExample();
		return mapper.selectByExample(example);
	}

	List<PhysicalTypeBO> findAll(Iterable<Long> ids) {
		PhysicalTypeExample example = new PhysicalTypeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalTypeExample example = new PhysicalTypeExample();
		return mapper.countByExample(example);
	}

	public List<PhysicalType> save(Iterable<PhysicalType> entities) {
		List<PhysicalType> list = new ArrayList<PhysicalType>();
		for (PhysicalType PhysicalType : entities) {
			list.add(save(PhysicalType));
		}
		return list;
	}

	public PhysicalType save(PhysicalType record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PhysicalType record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalTypeBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalTypeExample example = new PhysicalTypeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalType entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalType> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalType entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalTypeExample example = new PhysicalTypeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalTypeExample example = new PhysicalTypeExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
