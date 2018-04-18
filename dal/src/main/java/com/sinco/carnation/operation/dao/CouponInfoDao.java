package com.sinco.carnation.operation.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.mapper.CouponInfoMapper;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.operation.model.CouponInfoExample;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CouponInfoDao {

	@Autowired
	private CouponInfoMapper mapper;

	/**
	 * 处理已经过期的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public List<CouponInfoBO> findHasIsOver(Integer status, Date endTime) {
		return mapper.findHasIsOver(status, endTime);
	}

	/**
	 * 查找自己的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public List<CouponInfoBO> findMyCoupon(CouponInfoMyVO vo, MyPage<CouponInfoBO> page) {
		return mapper.findMyCoupon(vo, page);
	}

	/**
	 * 查找自己的优惠券数量
	 * 
	 * @param vo
	 * @return
	 */
	public int countMyCoupon(CouponInfoMyVO vo) {
		CouponInfoExample example = new CouponInfoExample();
		CouponInfoExample.Criteria c = example.createCriteria();
		c.andUserIdEqualTo(vo.getUid());
		if (vo.getStatus() != null) {
			c.andStatusEqualTo(vo.getStatus());
		}
		return mapper.countByExample(example);
	}

	/**
	 * 查找自己的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public CouponInfoBO findMyById(Long id, Long uid) {
		CouponInfoMyVO vo = new CouponInfoMyVO();
		vo.setId(id);
		vo.setUid(uid);
		List<CouponInfoBO> list = mapper.findMyCoupon(vo, null);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<CouponInfoBO> findAll() {
		CouponInfoExample example = new CouponInfoExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CouponInfoExample example = new CouponInfoExample();
		return mapper.countByExample(example);
	}

	public List<CouponInfo> save(Iterable<CouponInfo> entities) {
		List<CouponInfo> list = new ArrayList<CouponInfo>();
		for (CouponInfo CouponInfo : entities) {
			list.add(save(CouponInfo));
		}
		return list;
	}

	public CouponInfo save(CouponInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CouponInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CouponInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CouponInfoBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CouponInfoExample example = new CouponInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CouponInfoBO> findAll(Iterable<Long> ids) {
		CouponInfoExample example = new CouponInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CouponInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CouponInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CouponInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CouponInfoExample example = new CouponInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CouponInfoExample example = new CouponInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<CouponInfoBO> queryCouponByUid(Long uid) {
		CouponInfoExample example = new CouponInfoExample();
		example.createCriteria().andUserIdEqualTo(uid);
		return mapper.selectByExample(example);
	}

	public List<CouponInfoBO> queryCouponInfoPageList(Long couponId, MyPage<CouponInfoBO> page) {
		return mapper.queryCouponInfoPageList(couponId, page);
	}

	// 根据coupon_id删除记录
	public void deleteByMainCouponId(Long couponId) {
		CouponInfoExample example = new CouponInfoExample();
		example.createCriteria().andCouponIdEqualTo(couponId);
		mapper.deleteByExample(example);

	}
}
