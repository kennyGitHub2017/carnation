package com.sinco.carnation.juanpi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.mapper.JuanpiOrderGoodsMapper;
import com.sinco.carnation.juanpi.model.JuanpiOrderGoods;
import com.sinco.carnation.juanpi.model.JuanpiOrderGoodsExample;
import com.sinco.carnation.juanpi.vo.JuanpiOrderGoodsVO;
import com.sinco.dal.common.MyPage;

@Repository
public class JuanpiOrderGoodsDao {

	@Autowired
	private JuanpiOrderGoodsMapper mapper;

	/** generate code begin **/
	public List<JuanpiOrderGoodsBO> findAll() {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		return mapper.selectByExample(example);
	}

	List<JuanpiOrderGoodsBO> findAll(Iterable<Long> ids) {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		return mapper.countByExample(example);
	}

	public List<JuanpiOrderGoods> save(Iterable<JuanpiOrderGoods> entities) {
		List<JuanpiOrderGoods> list = new ArrayList<JuanpiOrderGoods>();
		for (JuanpiOrderGoods JuanpiOrderGoods : entities) {
			list.add(save(JuanpiOrderGoods));
		}
		return list;
	}

	public JuanpiOrderGoods save(JuanpiOrderGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(JuanpiOrderGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public JuanpiOrderGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(JuanpiOrderGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<JuanpiOrderGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (JuanpiOrderGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public int synOrderGoods(JuanpiOrderGoodsBO record) {
		return mapper.synOrderGoods(record);
	}

	public List<JuanpiOrderGoodsBO> findGoodsByOrder(Long orderId) {
		JuanpiOrderGoodsExample example = new JuanpiOrderGoodsExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return mapper.selectByExample(example);
	}

	public List<JuanpiOrderGoodsBO> findGoodsByOrderId(Integer orderId, MyPage<JuanpiOrderGoodsBO> page) {
		return mapper.findGoodsByOrderId(orderId, page);
	}

	public List<JuanpiOrderGoodsBO> findGoodsByOrderId(Integer orderId) {
		return mapper.findGoodsByOnlyOrderId(orderId);
	}

	public List<JuanpiOrderGoodsBO> selectOrderGoodsListByVO(JuanpiOrderGoodsVO vo,
			MyPage<JuanpiOrderGoodsBO> page) {
		return mapper.selectOrderGoodsListByVO(vo, page);
	}

	public JuanpiOrderGoodsBO selectMoneyTotal(JuanpiOrderGoodsVO vo) {
		return mapper.selectMoneyTotal(vo);
	}
	

	/** 查询可加积分订单 **/
	public List<JuanpiOrderGoodsBO> listAddIntegral(){
		return mapper.listAddIntegral();
	}

	/** 修改加积分状态 **/
	public int updateAddIntegral(Long id){
		return mapper.updateAddIntegral(id);
	}

}
