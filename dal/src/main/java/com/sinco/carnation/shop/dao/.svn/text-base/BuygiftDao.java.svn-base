package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.BuygiftMapper;
import com.sinco.carnation.shop.model.Buygift;
import com.sinco.carnation.shop.bo.BuygiftBO;
import com.sinco.carnation.shop.model.BuygiftExample;

@Repository
public class BuygiftDao {

	@Autowired
	private BuygiftMapper mapper;

	/** generate code begin **/
	public List<BuygiftBO> findAll() {
		BuygiftExample example = new BuygiftExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		BuygiftExample example = new BuygiftExample();
		return mapper.countByExample(example);
	}

	public List<Buygift> save(Iterable<Buygift> entities) {
		List<Buygift> list = new ArrayList<Buygift>();
		for (Buygift Buygift : entities) {
			list.add(save(Buygift));
		}
		return list;
	}

	public Buygift save(Buygift record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Buygift record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public BuygiftBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public BuygiftBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		BuygiftExample example = new BuygiftExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<BuygiftBO> findAll(Iterable<Long> ids) {
		BuygiftExample example = new BuygiftExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Buygift entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Buygift> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Buygift entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		BuygiftExample example = new BuygiftExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		BuygiftExample example = new BuygiftExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
