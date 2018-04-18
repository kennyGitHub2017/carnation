package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.PredepositPfLogBO;
import com.sinco.carnation.shop.mapper.PredepositPfLogMapper;
import com.sinco.carnation.shop.model.PredepositPfLog;
import com.sinco.carnation.shop.model.PredepositPfLogExample;

@Repository
public class PredepositPfLogDao {

	@Autowired
	private PredepositPfLogMapper mapper;

	/** generate code begin **/
	public List<PredepositPfLogBO> findAll() {
		PredepositPfLogExample example = new PredepositPfLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PredepositPfLogExample example = new PredepositPfLogExample();
		return mapper.countByExample(example);
	}

	public List<PredepositPfLog> save(Iterable<PredepositPfLog> entities) {
		List<PredepositPfLog> list = new ArrayList<PredepositPfLog>();
		for (PredepositPfLog PredepositPfLog : entities) {
			list.add(save(PredepositPfLog));
		}
		return list;
	}

	public PredepositPfLog save(PredepositPfLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PredepositPfLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PredepositPfLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PredepositPfLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PredepositPfLogExample example = new PredepositPfLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PredepositPfLogBO> findAll(Iterable<Long> ids) {
		PredepositPfLogExample example = new PredepositPfLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PredepositPfLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PredepositPfLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PredepositPfLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PredepositPfLogExample example = new PredepositPfLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PredepositPfLogExample example = new PredepositPfLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public BigDecimal queryPredepositTotal(Long uid, Date startTime, Date endTime) {
		return mapper.queryPredepositTotal(uid, startTime, endTime);
	}

	public List<PredepositPfLogBO> queryMonthlyPre(Long uid) {
		return mapper.queryMonthlyPre(uid);
	}
}
