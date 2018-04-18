package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.mapper.GoodsUgcMapper;
import com.sinco.carnation.goods.model.GoodsUgc;
import com.sinco.carnation.goods.model.GoodsUgcExample;

@Repository
public class GoodsUgcDao {

	@Autowired
	private GoodsUgcMapper mapper;

	/** generate code begin **/
	public List<GoodsUgc> findAll() {
		GoodsUgcExample example = new GoodsUgcExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsUgcExample example = new GoodsUgcExample();
		return mapper.countByExample(example);
	}

	public List<GoodsUgc> save(Iterable<GoodsUgc> entities) {
		List<GoodsUgc> list = new ArrayList<GoodsUgc>();
		for (GoodsUgc GoodsUgc : entities) {
			list.add(save(GoodsUgc));
		}
		return list;
	}

	public GoodsUgc save(GoodsUgc record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsUgc> findByClassId(java.lang.Long classId) {
		GoodsUgcExample example = new GoodsUgcExample();
		example.createCriteria().andClassIdEqualTo(classId);
		return mapper.selectByExample(example);
	}

	public int deleteByClassId(java.lang.Long classId) {
		GoodsUgcExample example = new GoodsUgcExample();
		example.createCriteria().andClassIdEqualTo(classId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsUgc> findByGoodsId(java.lang.Long goodsId) {
		GoodsUgcExample example = new GoodsUgcExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.selectByExample(example);
	}

	public int deleteByGoodsId(java.lang.Long goodsId) {
		GoodsUgcExample example = new GoodsUgcExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.deleteByExample(example);
	}
	/** generate code end **/
}
