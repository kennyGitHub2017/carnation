package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.mapper.GoodsSpecPropertyMapper;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecPropertyExample;

@Repository
public class GoodsSpecPropertyDao {

	@Autowired
	private GoodsSpecPropertyMapper mapper;

	/**
	 * 查找商品相关属性
	 * 
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecPropertyBO> selectBOSpecBygoodsId(Long goodsId) {
		return mapper.selectBOSpecBygoodsId(goodsId);
	}

	/**
	 * 查找购物车商品相关属性
	 * 
	 * @param cartId
	 * @return
	 */
	public List<GoodsSpecPropertyBO> selectBOSpecByCartId(Long cartId) {
		return mapper.selectBOSpecByCartId(cartId);
	}

	/**
	 * 根据规格删除
	 * 
	 * @param specId
	 * @return
	 */
	public int deleteBySpec(Long specId) {
		return deleteBySpec(specId, null);
	}

	/**
	 * 根据规格删除
	 * 
	 * @param specId
	 * @param notDelIds
	 * @return
	 */
	public int deleteBySpec(Long specId, List<Long> notDelIds) {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		GoodsSpecPropertyExample.Criteria c = example.createCriteria().andSpecIdEqualTo(specId);
		if (notDelIds != null && notDelIds.size() > 0) {
			c.andIdNotIn(notDelIds);
		}
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据商品规格查找
	 * 
	 * @param specId
	 * @return
	 */
	public List<GoodsSpecPropertyBO> findBySpec(Long specId) {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		example.createCriteria().andSpecIdEqualTo(specId);
		return mapper.selectBOByExample(example);
	}

	/**
	 * 根据规格多id查询，并查询出规格属性
	 * 
	 * @param ids
	 * @return
	 */
	public List<GoodsSpecPropertyBO> selectBOSpecByIds(String[] ids) {
		return mapper.selectBOSpecByIds(ids);
	}

	/**
	 * 根据规格id查询
	 * 
	 * @param ids
	 * @return
	 */
	public GoodsSpecPropertyBO findBOById(Long id) {
		return mapper.findBOById(id);
	}

	/** generate code begin **/
	public List<GoodsSpecProperty> findAll() {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		return mapper.countByExample(example);
	}

	public List<GoodsSpecProperty> save(Iterable<GoodsSpecProperty> entities) {
		List<GoodsSpecProperty> list = new ArrayList<GoodsSpecProperty>();
		for (GoodsSpecProperty GoodsSpecProperty : entities) {
			list.add(save(GoodsSpecProperty));
		}
		return list;
	}

	public GoodsSpecProperty save(GoodsSpecProperty record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsSpecProperty record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsSpecProperty findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsSpecProperty get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsSpecProperty> findAll(Iterable<Long> ids) {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsSpecProperty entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsSpecProperty> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsSpecProperty entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsSpecPropertyExample example = new GoodsSpecPropertyExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
	
	public List<GoodsSpecPropertyBO> getGoodsPropertyByStoreId(Long specId, Long storeId) {
		return this.mapper.getGoodsPropertyByStoreId(specId, storeId);
	}
	
	public  int insertSelective(GoodsSpecProperty record) {
	return	this.mapper.insertSelective(record);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPropertyByGoodsIdAndSpec(Long goodsId, Long specId) {
		return this.mapper.getPropertyByGoodsIdAndSpec(goodsId, specId);
	}
	
	public int deletePropertyByGoodsId(Long goodsId) {
		return this.mapper.deletePropertyByGoodsId(goodsId);
	}
}
