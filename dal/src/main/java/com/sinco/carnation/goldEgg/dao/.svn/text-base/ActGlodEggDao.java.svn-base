package com.sinco.carnation.goldEgg.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.goldEgg.mapper.ActGlodEggMapper;
import com.sinco.carnation.goldEgg.model.ActGlodEgg;
import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.model.ActGlodEggExample;

@Repository
public class ActGlodEggDao {

	@Autowired
	private ActGlodEggMapper mapper;

	/** generate code begin **/
	public List<ActGlodEggBO> findAll() {
		ActGlodEggExample example = new ActGlodEggExample();
		return mapper.selectByExample(example);
	}

	List<ActGlodEggBO> findAll(Iterable<Long> ids) {
		ActGlodEggExample example = new ActGlodEggExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActGlodEggExample example = new ActGlodEggExample();
		return mapper.countByExample(example);
	}

	public List<ActGlodEgg> save(Iterable<ActGlodEgg> entities) {
		List<ActGlodEgg> list = new ArrayList<ActGlodEgg>();
		for (ActGlodEgg ActGlodEgg : entities) {
			list.add(save(ActGlodEgg));
		}
		return list;
	}

	public ActGlodEgg save(ActGlodEgg record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActGlodEgg record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActGlodEggBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActGlodEggExample example = new ActGlodEggExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActGlodEgg entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActGlodEgg> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActGlodEgg entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActGlodEggExample example = new ActGlodEggExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActGlodEggExample example = new ActGlodEggExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public void addCurrentGetMoney(Long id, BigDecimal money) {
		mapper.addCurrentGetMoney(id, money);
	}

	public ActGlodEgg findByActID(ActGlodEgg entity) {
		ActGlodEgg obj = this.mapper.findByActID(entity);
		return obj;
	}

	public List<ActGlodEggBO> findListByActID(Long act_id) {
		return this.mapper.findListByActID(act_id);
	}
}
