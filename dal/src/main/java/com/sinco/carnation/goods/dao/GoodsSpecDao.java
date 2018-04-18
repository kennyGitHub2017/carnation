package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.mapper.GoodsSpecMapper;
import com.sinco.carnation.goods.model.GoodsSpec;
import com.sinco.carnation.goods.model.GoodsSpecExample;

@Repository
public class GoodsSpecDao {

	@Autowired
	private GoodsSpecMapper mapper;

	/**
	 * 删除规格与商品关联
	 * 
	 * @param specPropertyIds
	 * @return
	 */
	public int deleteBySpec(Long... specPropertyIds) {
		GoodsSpecExample example = new GoodsSpecExample();
		example.createCriteria().andSpecIdIn(Lists.newArrayList(specPropertyIds));
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据 规格属性查找是否有关联商品
	 * 
	 * @param specPropertyIds
	 * @return
	 */
	public int countBySpec(Long... specPropertyIds) {
		return mapper.countBySpec(Lists.newArrayList(specPropertyIds));
	}

	/** generate code begin **/
	public List<GoodsSpec> findAll() {
		GoodsSpecExample example = new GoodsSpecExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsSpecExample example = new GoodsSpecExample();
		return mapper.countByExample(example);
	}

	public List<GoodsSpec> save(Iterable<GoodsSpec> entities) {
		List<GoodsSpec> list = new ArrayList<GoodsSpec>();
		for (GoodsSpec GoodsSpec : entities) {
			list.add(save(GoodsSpec));
		}
		return list;
	}

	public GoodsSpec save(GoodsSpec record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsSpec> findByGoodsId(java.lang.Long goodsId) {
		GoodsSpecExample example = new GoodsSpecExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.selectByExample(example);
	}

	public int deleteByGoodsId(java.lang.Long goodsId) {
		GoodsSpecExample example = new GoodsSpecExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsSpec> findBySpecId(java.lang.Long specId) {
		GoodsSpecExample example = new GoodsSpecExample();
		example.createCriteria().andSpecIdEqualTo(specId);
		return mapper.selectByExample(example);
	}

	public int deleteBySpecId(java.lang.Long specId) {
		GoodsSpecExample example = new GoodsSpecExample();
		example.createCriteria().andSpecIdEqualTo(specId);
		return mapper.deleteByExample(example);
	}
	/** generate code end **/
	
	public int insertGoodsSpecId (Long goodsId, Long specificationId) {
		return this.mapper.insertGoodsSpecId(goodsId, specificationId);
	}
	
	public List<GoodsSpec> selectGoodsSpecIdList(Long goodsId) {
		return this.mapper.selectGoodsSpecIdList(goodsId);
	}
	
	public int deleteGoodsSpecId(Long goodsId){
		return this.mapper.deleteGoodsSpecId(goodsId);
	}
	
}
