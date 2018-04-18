package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.IntegralGoodsBO;
import com.sinco.carnation.shop.mapper.IntegralGoodsMapper;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsExample;
import com.sinco.carnation.shop.vo.IntegralGoodsVO;
import com.sinco.dal.common.MyPage;

@Repository
public class IntegralGoodsDao {

	@Autowired
	private IntegralGoodsMapper mapper;

	/**
	 * 减少库存数量
	 * 
	 * @param id
	 * @param count
	 * @return
	 */
	public int subtractGoodsCount(Long id, int count) {
		return mapper.subtractGoodsCount(id, count);
	}

	/**
	 * 添加销售数量
	 * 
	 * @param id
	 * @param count
	 * @return
	 */
	public int addExchangeCount(Long id, int count) {
		return mapper.addExchangeCount(id, count);
	}

	/** generate code begin **/
	public List<IntegralGoodsBO> findAll() {
		IntegralGoodsExample example = new IntegralGoodsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		IntegralGoodsExample example = new IntegralGoodsExample();
		return mapper.countByExample(example);
	}

	public List<IntegralGoods> save(Iterable<IntegralGoods> entities) {
		List<IntegralGoods> list = new ArrayList<IntegralGoods>();
		for (IntegralGoods IntegralGoods : entities) {
			list.add(save(IntegralGoods));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchA(boolean recommend, boolean show) {
		return mapper.searchA(recommend, show);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchB(boolean recommend, boolean show, int begin) {
		return mapper.searchB(recommend, show, begin);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> searchC(boolean recommend, boolean show, int begin, int end) {
		return mapper.searchC(recommend, show, begin, end);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectForDesc() {
		return mapper.selectForDesc();
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectForList(String orderType, String rang_begin, String rang_end, MyPage<Map> page) {
		return mapper.selectForList(orderType, rang_begin, rang_end, page);
	}

	public List<IntegralGoodsBO> selectForListBean(String orderType, String rang_begin, String rang_end,
			MyPage<IntegralGoodsBO> page) {
		return mapper.selectForListBean(orderType, rang_begin, rang_end, page);
	}

	public IntegralGoods save(IntegralGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(IntegralGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public IntegralGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public IntegralGoodsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@SuppressWarnings("rawtypes")
	public Map selectByKeyForMap(Long id) {
		return mapper.selectByKeyForMap(id);
	}

	public boolean exists(java.lang.Long id) {
		IntegralGoodsExample example = new IntegralGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<IntegralGoodsBO> findAll(Iterable<Long> ids) {
		IntegralGoodsExample example = new IntegralGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(IntegralGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<IntegralGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (IntegralGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		IntegralGoodsExample example = new IntegralGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		IntegralGoodsExample example = new IntegralGoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<IntegralGoodsBO> findListByVo(MyPage<IntegralGoodsBO> page, IntegralGoodsVO vo) {
		return mapper.findListByVo(page, vo);
	}

	public List<IntegralGoodsBO> queryIntegralGoodsCountList(Long[] goodIds) {
		return mapper.queryIntegralGoodsCountList(goodIds);
	}

	public List<IntegralGoodsBO> selectListByCriteria(String orderType, String rang_begin, String rang_end,
			MyPage<IntegralGoodsBO> page) {
		return mapper.selectListByCriteria(orderType, rang_begin, rang_end, page);
	}
}
