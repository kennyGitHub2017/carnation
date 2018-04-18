package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;
import com.sinco.carnation.goods.mapper.GoodsTypePropertyMapper;
import com.sinco.carnation.goods.model.GoodsTypeProperty;
import com.sinco.carnation.goods.model.GoodsTypePropertyExample;

@Repository
public class GoodsTypePropertyDao {

	@Autowired
	private GoodsTypePropertyMapper mapper;

	/**
	 * 根据商品类型查询
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	public List<GoodsTypePropertyBO> findByGoodsType(Long goodsTypeId) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		example.createCriteria().andGoodsTypeIdEqualTo(goodsTypeId);
		return mapper.selectBOByExample(example);
	}

	/**
	 * 根据 商品类型删除
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	public int deleteByGoodsTypeId(Long goodsTypeId) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		example.createCriteria().andGoodsTypeIdEqualTo(goodsTypeId);
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据 商品类型删除
	 * 
	 * @param goodsTypeId
	 * @return
	 */
	public int deleteByGoodsTypeId(Long goodsTypeId, List<Long> notIds) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		GoodsTypePropertyExample.Criteria c = example.createCriteria().andGoodsTypeIdEqualTo(goodsTypeId);
		if (notIds != null && notIds.size() > 0) {
			c.andIdNotIn(notIds);
		}
		return mapper.deleteByExample(example);
	}

	/** generate code begin **/
	public List<GoodsTypeProperty> findAll() {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		return mapper.countByExample(example);
	}

	public List<GoodsTypeProperty> save(Iterable<GoodsTypeProperty> entities) {
		List<GoodsTypeProperty> list = new ArrayList<GoodsTypeProperty>();
		for (GoodsTypeProperty GoodsTypeProperty : entities) {
			list.add(save(GoodsTypeProperty));
		}
		return list;
	}

	public GoodsTypeProperty save(GoodsTypeProperty record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsTypeProperty record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsTypeProperty findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsTypeProperty get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsTypeProperty> findAll(Iterable<Long> ids) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsTypeProperty entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsTypeProperty> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsTypeProperty entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsTypePropertyExample example = new GoodsTypePropertyExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
