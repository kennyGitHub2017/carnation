package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.mapper.ActMarketCouponMapper;
import com.sinco.carnation.market.model.ActMarketCoupon;
import com.sinco.carnation.market.model.ActMarketCouponExample;
import com.sinco.carnation.market.vo.ActMarketCouponVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActMarketCouponDao {

	@Autowired
	private ActMarketCouponMapper mapper;

	/** generate code begin **/
	public List<ActMarketCouponBO> findAll() {
		ActMarketCouponExample example = new ActMarketCouponExample();
		return mapper.selectByExample(example);
	}

	List<ActMarketCouponBO> findAll(Iterable<Long> ids) {
		ActMarketCouponExample example = new ActMarketCouponExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActMarketCouponExample example = new ActMarketCouponExample();
		return mapper.countByExample(example);
	}

	public List<ActMarketCoupon> save(Iterable<ActMarketCoupon> entities) {
		List<ActMarketCoupon> list = new ArrayList<ActMarketCoupon>();
		for (ActMarketCoupon ActMarketCoupon : entities) {
			list.add(save(ActMarketCoupon));
		}
		return list;
	}

	public ActMarketCoupon save(ActMarketCoupon record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActMarketCoupon record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActMarketCouponBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActMarketCouponExample example = new ActMarketCouponExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActMarketCoupon entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActMarketCoupon> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActMarketCoupon entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActMarketCouponExample example = new ActMarketCouponExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActMarketCouponExample example = new ActMarketCouponExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ActMarketCouponBO> findAllByPage(ActMarketCouponVO vo, MyPage<ActMarketCouponBO> page) {
		return mapper.findAllByPage(vo, page);
	}

	/**
	 * 获得权重最大的记录
	 * 
	 * @return
	 */
	public ActMarketCouponBO getActMarketCouponMax() {
		return mapper.getActMarketCouponMax();
	}
}
