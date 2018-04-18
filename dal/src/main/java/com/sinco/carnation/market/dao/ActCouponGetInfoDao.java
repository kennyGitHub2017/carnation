package com.sinco.carnation.market.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.market.mapper.ActCouponGetInfoMapper;
import com.sinco.carnation.market.model.ActCouponGetInfo;
import com.sinco.carnation.market.bo.ActCouponGetInfoBO;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.model.ActCouponGetInfoExample;
import com.sinco.carnation.market.vo.ActCouponGetInfoVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActCouponGetInfoDao {

	@Autowired
	private ActCouponGetInfoMapper mapper;

	/** generate code begin **/
	public List<ActCouponGetInfoBO> findAll() {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		return mapper.selectByExample(example);
	}

	List<ActCouponGetInfoBO> findAll(Iterable<Long> ids) {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		return mapper.countByExample(example);
	}

	public List<ActCouponGetInfo> save(Iterable<ActCouponGetInfo> entities) {
		List<ActCouponGetInfo> list = new ArrayList<ActCouponGetInfo>();
		for (ActCouponGetInfo ActCouponGetInfo : entities) {
			list.add(save(ActCouponGetInfo));
		}
		return list;
	}

	public ActCouponGetInfo save(ActCouponGetInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActCouponGetInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActCouponGetInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActCouponGetInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActCouponGetInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActCouponGetInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 是否有会员抢到券
	 * 
	 * @param actCouponId
	 * @return
	 */
	public boolean existsGetCouponRecord(Long actCouponId) {
		// String is_get = "1";//用户是否抢到优惠卷/抢到为：1 否则：0
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andActCouponIdEqualTo(actCouponId).andIsGetEqualTo("1");
		return mapper.countByExample(example) > 0;
	}

	/**
	 * 会员抢券记录
	 * 
	 * @param userId
	 * @param actCouponId
	 * @return
	 */
	public boolean existsUserCouponRecord(Long userId, Long actCouponId) {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andUserIdEqualTo(userId).andActCouponIdEqualTo(actCouponId);
		List<ActCouponGetInfoBO> acts = mapper.selectByExample(example);
		return (acts != null && acts.size() > 0);
	}

	public List<ActMarketCouponBO> findAllByPage(ActCouponGetInfoVO vo, MyPage<ActCouponGetInfoBO> page) {
		return mapper.findAllByPage(vo, page);
	}

	/**
	 * 查询领取优惠券的数量
	 * 
	 * @return
	 */
	public int countGetCouponNum(Long id) {
		ActCouponGetInfoExample example = new ActCouponGetInfoExample();
		example.createCriteria().andActCouponIdEqualTo(id);
		return mapper.countByExample(example);
	}
}
