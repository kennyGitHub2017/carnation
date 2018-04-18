package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsLogBO;
import com.sinco.carnation.goods.mapper.GoodsLogMapper;
import com.sinco.carnation.goods.model.GoodsLog;
import com.sinco.carnation.goods.model.GoodsLogExample;

@Repository
public class GoodsLogDao {

	@Autowired
	private GoodsLogMapper mapper;

	public List<GoodsLog> selectByGoodsIdAndTime(Long goodsId, Date beginTime, Date endTime) {
		GoodsLogExample example = new GoodsLogExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId).andDeletestatusEqualTo(0)
				.andAddtimeBetween(beginTime, endTime);
		return mapper.selectByExample(example);
	}

	public List<GoodsLogBO> selectGoodsTop(Long storeId, Date startTime, Date endTime, String orderType,
			Integer offset, Integer start, String columeName) {
		return mapper.selectGoodsTop(storeId, startTime, endTime, orderType, offset, start, columeName);
	}

	/** generate code begin **/
	public List<GoodsLog> findAll() {
		GoodsLogExample example = new GoodsLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsLogExample example = new GoodsLogExample();
		return mapper.countByExample(example);
	}

	public List<GoodsLog> save(Iterable<GoodsLog> entities) {
		List<GoodsLog> list = new ArrayList<GoodsLog>();
		for (GoodsLog GoodsLog : entities) {
			list.add(save(GoodsLog));
		}
		return list;
	}

	public GoodsLog save(GoodsLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsLog findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsLog get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsLogExample example = new GoodsLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsLog> findAll(Iterable<Long> ids) {
		GoodsLogExample example = new GoodsLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsLogExample example = new GoodsLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsLogExample example = new GoodsLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
