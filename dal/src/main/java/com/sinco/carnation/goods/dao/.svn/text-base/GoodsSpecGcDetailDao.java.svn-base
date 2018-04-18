package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.mapper.GoodsSpecGcDetailMapper;
import com.sinco.carnation.goods.model.GoodsSpecGcDetail;
import com.sinco.carnation.goods.model.GoodsSpecGcDetailExample;

@Repository
public class GoodsSpecGcDetailDao {

	@Autowired
	private GoodsSpecGcDetailMapper mapper;

	/** generate code begin **/
	public List<GoodsSpecGcDetail> findAll() {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		return mapper.countByExample(example);
	}

	public List<GoodsSpecGcDetail> save(Iterable<GoodsSpecGcDetail> entities) {
		List<GoodsSpecGcDetail> list = new ArrayList<GoodsSpecGcDetail>();
		for (GoodsSpecGcDetail GoodsSpecGcDetail : entities) {
			list.add(save(GoodsSpecGcDetail));
		}
		return list;
	}

	public GoodsSpecGcDetail save(GoodsSpecGcDetail record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsSpecGcDetail> findBySpecGcId(java.lang.Long specGcId) {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		example.createCriteria().andSpecGcIdEqualTo(specGcId);
		return mapper.selectByExample(example);
	}

	public int deleteBySpecGcId(java.lang.Long specGcId) {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		example.createCriteria().andSpecGcIdEqualTo(specGcId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsSpecGcDetail> findBySpecId(java.lang.Long specId) {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		example.createCriteria().andSpecIdEqualTo(specId);
		return mapper.selectByExample(example);
	}

	public int deleteBySpecId(java.lang.Long specId) {
		GoodsSpecGcDetailExample example = new GoodsSpecGcDetailExample();
		example.createCriteria().andSpecIdEqualTo(specId);
		return mapper.deleteByExample(example);
	}
	/** generate code end **/
}
