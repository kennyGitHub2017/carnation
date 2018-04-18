package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.mapper.GoodsMapper;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsExample;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class GoodsDao {

	@Autowired
	private GoodsMapper mapper;
	@Autowired
	private DicNameMappingHandle dicNameMappingHandle;

	public List<Map<String, Integer>> findCountByStoreId(Long storeId) {
		return mapper.findCountByStoreId(storeId);
	}

	public List<Long> findAllSellingGoods() {
		return mapper.findAllSellingGoods();
	}

	public int selectGoodsCountByStatusAndType(Integer type, Integer status) {
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria criteria = example.createCriteria().andDeleteStatusEqualTo(0)
				.andGoodsStatusEqualTo(status);
		if (type != null) {
			criteria.andGoodsTypeEqualTo(type);
		}
		return mapper.countByExample(example);
	}

	/**
	 * 根据时间查询商品
	 * 
	 * @return
	 */
	public int selectGoodsCountByTime(Date time) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andAddTimeGreaterThanOrEqualTo(time);
		return mapper.countByExample(example);
	}

	/**
	 * 增加收藏数
	 * 
	 * @param id
	 * @return
	 */
	public int increaseGoodsCollect(Long id) {
		return mapper.increaseGoodsCollect(id);
	}

	/**
	 * 减少收藏数
	 * 
	 * @param id
	 * @return
	 */
	public int reduceGoodsCollect(Long id) {
		return mapper.reduceGoodsCollect(id);
	}

	/**
	 * 用于商城列表数据查询
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsBO> findShopListBO(GoodsShowListVO vo) {
		return mapper.findShopListBO(vo);
	}

	public GoodsBO findBOByid(Long id) {
		return mapper.findBOByid(id);
	}

	public List<GoodsBO> selectBOByVO(GoodsVO vo, MyPage<GoodsBO> page) {
		mapper.selectBOByVO(vo, page);
		dicNameMappingHandle.mappinHandle(page.getContent());
		return page.getContent();
	}

	public List<GoodsBO> selectGoodsYourLike(Long gcId, Long goodsId, Integer start, Integer offset,
			Set<Long> goodsIds, Set<Long> gcIds) {
		return mapper.selectGoodsYourLike(gcId, goodsId, goodsIds, gcIds, start, offset);
	}

	public List<GoodsBO> searchGoodsYourLike(Long gcId, Long goodsId, Set<Long> goodsIds, Set<Long> gcIds,
			MyPage<GoodsBO> page) {
		return mapper.searchGoodsYourLike(gcId, goodsId, goodsIds, gcIds, page);
	}

	public List<GoodsBO> selectSameClassGoodsList(Long gcId, Long goodsId, Integer start, Integer offset) {
		return mapper.selectSameClassGoodsList(gcId, goodsId, start, offset);
	}

	public List<GoodsBO> selectGoodsListByVO(GoodsVO vo, MyPage<GoodsBO> page) {
		mapper.selectGoodsListByVO(vo, page);
		dicNameMappingHandle.mappinHandle(page.getContent());
		return page.getContent();
	}

	/** generate code begin **/
	public List<Goods> findAll() {
		GoodsExample example = new GoodsExample();
		return mapper.selectByExample(example);
	}

	public int count() {
		GoodsExample example = new GoodsExample();
		return mapper.countByExample(example);
	}

	public List<Goods> save(Iterable<Goods> entities) {
		List<Goods> list = new ArrayList<Goods>();
		for (Goods Goods : entities) {
			list.add(save(Goods));
		}
		return list;
	}

	public Goods save(Goods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Goods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Goods findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Goods> findAll(Iterable<Long> ids) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<Goods> findAllByIds(Iterable<Long> ids) {
		return this.findAll(ids);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Goods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Goods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Goods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsExample example = new GoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsExample example = new GoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GoodsBO> querygoodsYourLike(Long gcId, Long goodsId, MyPage<GoodsBO> page) {
		return mapper.querygoodsYourLike(gcId, goodsId, page);
	}

	public List<GoodsBO> findPageByVo(MyPage<GoodsBO> page, GoodsVO vo) {
		return mapper.findPageByVo(page, vo);
	}

	public List<GoodsBO> queryFavaGoodsPageList(Long uid, Integer type, MyPage<GoodsBO> page) {
		return mapper.queryFavaGoodsPageList(type, uid, page);
	}

	public List<GoodsBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}

	public List<GoodsBO> searchGoodsLikeByIds(Long[] goodsIds) {
		return mapper.searchGoodsLikeByIds(goodsIds);
	}

	public int findCountWarnGoods(Long storeId) {
		return mapper.findCountWarnGoods(storeId);
	}

	public List<GoodsBO> findGoodsByVoAndLimit(GoodsVO vo, Integer start, Integer offset) {
		return this.mapper.findGoodsByVoAndLimit(vo, start, offset);
	}

	public List<GoodsBO> selectYgGoodsListByVO(GoodsVO vo, MyPage<GoodsBO> page) {
		mapper.selectYgGoodsListByVO(vo, page);
		dicNameMappingHandle.mappinHandle(page.getContent());
		return page.getContent();
	}

	public void updateGoodStateByID(Goods goods) {
		this.mapper.updateGoodStateByID(goods);
	}
}
