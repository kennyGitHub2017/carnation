package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.mapper.GoodsTypeBrandMapper;
import com.sinco.carnation.goods.model.GoodsTypeBrand;
import com.sinco.carnation.goods.model.GoodsTypeBrandExample;

@Repository
public class GoodsTypeBrandDao {

	@Autowired
	private GoodsTypeBrandMapper mapper;

	/** generate code begin **/
	public List<GoodsTypeBrand> findAll() {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		return mapper.countByExample(example);
	}

	public List<GoodsTypeBrand> save(Iterable<GoodsTypeBrand> entities) {
		List<GoodsTypeBrand> list = new ArrayList<GoodsTypeBrand>();
		for (GoodsTypeBrand GoodsTypeBrand : entities) {
			list.add(save(GoodsTypeBrand));
		}
		return list;
	}

	public GoodsTypeBrand save(GoodsTypeBrand record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsTypeBrand> findByBrandId(java.lang.Long brandId) {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		example.createCriteria().andBrandIdEqualTo(brandId);
		return mapper.selectByExample(example);
	}

	public int deleteByBrandId(java.lang.Long brandId) {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		example.createCriteria().andBrandIdEqualTo(brandId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsTypeBrand> findByTypeId(java.lang.Long typeId) {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		example.createCriteria().andTypeIdEqualTo(typeId);
		return mapper.selectByExample(example);
	}

	public int deleteByTypeId(java.lang.Long typeId) {
		GoodsTypeBrandExample example = new GoodsTypeBrandExample();
		example.createCriteria().andTypeIdEqualTo(typeId);
		return mapper.deleteByExample(example);
	}
	/** generate code end **/
}
