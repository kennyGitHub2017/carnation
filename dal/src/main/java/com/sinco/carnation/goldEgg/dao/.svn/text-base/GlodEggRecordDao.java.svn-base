package com.sinco.carnation.goldEgg.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goldEgg.mapper.GlodEggRecordMapper;
import com.sinco.carnation.goldEgg.model.GlodEggRecord;
import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.model.GlodEggRecordExample;
import com.sinco.carnation.goldEgg.vo.GlodEggRecordVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GlodEggRecordDao {

	@Autowired
	private GlodEggRecordMapper mapper;

	/** generate code begin **/
	public List<GlodEggRecordBO> findAll() {
		GlodEggRecordExample example = new GlodEggRecordExample();
		return mapper.selectByExample(example);
	}

	public List<GlodEggRecordBO> findAll(Iterable<Long> ids) {
		GlodEggRecordExample example = new GlodEggRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<GlodEggRecordBO> findByExample(GlodEggRecordExample example) {
		return mapper.selectByExample(example);
	}

	public long count() {
		GlodEggRecordExample example = new GlodEggRecordExample();
		return mapper.countByExample(example);
	}

	public List<GlodEggRecord> save(Iterable<GlodEggRecord> entities) {
		List<GlodEggRecord> list = new ArrayList<GlodEggRecord>();
		for (GlodEggRecord GlodEggRecord : entities) {
			list.add(save(GlodEggRecord));
		}
		return list;
	}

	public GlodEggRecord save(GlodEggRecord record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GlodEggRecord record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GlodEggRecordBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GlodEggRecordExample example = new GlodEggRecordExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GlodEggRecord entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GlodEggRecord> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GlodEggRecord entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GlodEggRecordExample example = new GlodEggRecordExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GlodEggRecordExample example = new GlodEggRecordExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public BigDecimal staticsCurrentGrantMoney(Date startDate, Date endDate) {
		return mapper.staticsCurrentGrantMoney(startDate, endDate);
	}

	public List<GlodEggRecordBO> findPageByVO(MyPage<GlodEggRecordBO> page, GlodEggRecordVO vo) {
		return this.mapper.findPageByVO(page, vo);
	}
}
