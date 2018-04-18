package com.sinco.carnation.operation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.mapper.CouponMapper;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.model.CouponExample;
import com.sinco.dal.common.MyPage;

@Repository
public class CouponDao {

	@Autowired
	private CouponMapper mapper;

	/** generate code begin **/
	public List<CouponBO> findAll() {
		CouponExample example = new CouponExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CouponExample example = new CouponExample();
		return mapper.countByExample(example);
	}

	public List<Coupon> save(Iterable<Coupon> entities) {
		List<Coupon> list = new ArrayList<Coupon>();
		for (Coupon Coupon : entities) {
			list.add(save(Coupon));
		}
		return list;
	}

	public Coupon save(Coupon record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Coupon record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CouponBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CouponBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CouponExample example = new CouponExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CouponBO> findAll(Iterable<Long> ids) {
		CouponExample example = new CouponExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Coupon entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Coupon> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Coupon entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CouponExample example = new CouponExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CouponExample example = new CouponExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<CouponBO> queryCouponPageList(Long storeId, String couponName, String beginTime,
			String endTime, MyPage<CouponBO> page) {
		return mapper.queryCouponPageList(storeId, couponName, beginTime, endTime, page);
	}

	public CouponBO queryCouponById(Long couponId) {
		return mapper.queryCouponById(couponId);
	}

	/*public List<CouponBO> queryCouponByAddTime(Date addTime) {
		CouponExample example=new CouponExample();
		example.createCriteria().andAddTimeEqualTo(addTime);
		return mapper.selectByExample(example);
		
		
	}*/

	public List<CouponBO> queryCouponByAddTimeDesc() {
		CouponExample example = new CouponExample();
		example.setOrderByClause(" add_time desc");
		return mapper.selectByExample(example);
	}

	public CouponBO queryNewYearById(Long newYearId) {
		return mapper.queryNewYearById(newYearId);
	}

	public CouponBO getByName(String couponName) {
		return this.mapper.getByName(couponName);
	}
	
	public CouponBO getByCouponInfoId(Long infoId) {
		return this.mapper.getByCouponInfoId(infoId);
	}
}
