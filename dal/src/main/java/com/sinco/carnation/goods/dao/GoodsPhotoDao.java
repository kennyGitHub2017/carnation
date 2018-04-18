package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.goods.bo.GoodsPhotoBO;
import com.sinco.carnation.goods.mapper.GoodsPhotoMapper;
import com.sinco.carnation.goods.model.GoodsPhoto;
import com.sinco.carnation.goods.model.GoodsPhotoExample;

@Repository
public class GoodsPhotoDao {

	@Autowired
	private GoodsPhotoMapper mapper;

	/** generate code begin **/
	public List<GoodsPhoto> findAll() {
		GoodsPhotoExample example = new GoodsPhotoExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsPhotoExample example = new GoodsPhotoExample();
		return mapper.countByExample(example);
	}

	public List<GoodsPhoto> save(Iterable<GoodsPhoto> entities) {
		List<GoodsPhoto> list = new ArrayList<GoodsPhoto>();
		for (GoodsPhoto GoodsPhoto : entities) {
			list.add(save(GoodsPhoto));
		}
		return list;
	}

	public GoodsPhoto save(GoodsPhoto record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GoodsPhoto> findByGoodsId(java.lang.Long goodsId) {
		GoodsPhotoExample example = new GoodsPhotoExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.selectByExample(example);
	}

	public List<GoodsPhotoBO> findBOByGoodsId(java.lang.Long goodsId) {
		return mapper.findBOByGoodsId(goodsId);
	}

	public int deleteByGoodsId(java.lang.Long goodsId) {
		GoodsPhotoExample example = new GoodsPhotoExample();
		example.createCriteria().andGoodsIdEqualTo(goodsId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsPhoto> findByPhotoId(java.lang.Long photoId) {
		GoodsPhotoExample example = new GoodsPhotoExample();
		example.createCriteria().andPhotoIdEqualTo(photoId);
		return mapper.selectByExample(example);
	}

	public int deleteByPhotoId(java.lang.Long photoId) {
		GoodsPhotoExample example = new GoodsPhotoExample();
		example.createCriteria().andPhotoIdEqualTo(photoId);
		return mapper.deleteByExample(example);
	}

	/** generate code end **/
	public int deleteByPhotoIdAndGoodsId(java.lang.Long photoId, java.lang.Long goodsId) {
		GoodsPhotoExample example = new GoodsPhotoExample();
		example.createCriteria().andPhotoIdEqualTo(photoId).andGoodsIdEqualTo(goodsId);
		return mapper.deleteByExample(example);
	}
}
