package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.mapper.IntegralGoodsOrderMapper;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.IntegralGoodsOrderExample;
import com.sinco.carnation.shop.vo.IntegralGoodsOrderVO;
import com.sinco.dal.common.MyPage;

@Repository
public class IntegralGoodsOrderDao {

	@Autowired
	private IntegralGoodsOrderMapper mapper;

	/**
	 * 根据订单号
	 * 
	 * @param igoOrderSn
	 * @return
	 */
	public IntegralGoodsOrderBO findByIgoOrderSn(String igoOrderSn) {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		example.createCriteria().andIgoOrderSnEqualTo(igoOrderSn);
		List<IntegralGoodsOrderBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<IntegralGoodsOrderBO> findAll() {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		return mapper.countByExample(example);
	}

	public List<IntegralGoodsOrder> save(Iterable<IntegralGoodsOrder> entities) {
		List<IntegralGoodsOrder> list = new ArrayList<IntegralGoodsOrder>();
		for (IntegralGoodsOrder IntegralGoodsOrder : entities) {
			list.add(save(IntegralGoodsOrder));
		}
		return list;
	}

	public List<IntegralGoodsOrderBO> selectByUser(long userId, MyPage<IntegralGoodsOrderBO> page) {
		return mapper.selectByUser(userId, page);
	}

	public IntegralGoodsOrder save(IntegralGoodsOrder record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(IntegralGoodsOrder record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public IntegralGoodsOrderBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public IntegralGoodsOrderBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<IntegralGoodsOrderBO> findAll(Iterable<Long> ids) {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(IntegralGoodsOrder entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<IntegralGoodsOrder> entities) {
		List<Long> ids = Lists.newArrayList();
		for (IntegralGoodsOrder entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		IntegralGoodsOrderExample example = new IntegralGoodsOrderExample();
		mapper.deleteByExample(example);
	}

	/**
	 * generate code end
	 * 
	 * @param page
	 **/

	public List<IntegralGoodsOrderBO> findListByVo(MyPage<IntegralGoodsOrderBO> page, IntegralGoodsOrderVO vo) {
		return mapper.findListByVo(page, vo);
	}

	public IntegralGoodsOrderBO getById(Long id) {
		return mapper.selectById(id);
	}

	/**
	 * 积分兑换 查询待发货订单
	 * 
	 * @return
	 */
	public List<IntegralGoodsOrderBO> findForExcel(MyPage<IntegralGoodsOrderBO> page, String startTime,
			String endTime , String status) {
		return mapper.findForExcel(page, startTime, endTime ,status);
	}

	public List<IntegralGoodsOrderBO> findNoPayThirdDay() {
		return mapper.findNoPayThirdDay();
	}

	public BigDecimal countTransFeeByVO (IntegralGoodsOrderVO vo){
		return mapper.countTransFeeByVO(vo);
	}
	public Long countIntegralByVO (IntegralGoodsOrderVO vo){
		return mapper.countIntegralByVO(vo);
	}
}
