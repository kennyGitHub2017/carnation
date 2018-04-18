package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsFormatBO;
import com.sinco.carnation.goods.mapper.GoodsFormatMapper;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.model.GoodsFormatExample;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsFormatDao {

	@Autowired
	private GoodsFormatMapper mapper;

	public List<GoodsFormatBO> selectBOPageByStoreId(MyPage<GoodsFormatBO> page, Long storeId) {
		return mapper.selectBOPageByStoreId(page, storeId);
	}

	public List<GoodsFormatBO> list(MyPage<GoodsFormatBO> page, Integer cat) {
		return mapper.selectBOPageByCat(page, cat);
	}

	public List<GoodsFormat> findByGFCat(Integer cat) {
		GoodsFormatExample example = new GoodsFormatExample();
		example.createCriteria().andGfCatEqualTo(cat).andDeleteStatusEqualTo(0);
		return mapper.selectByExample(example);
	}

	public List<GoodsFormat> findByStoreId(Long storeId) {
		GoodsFormatExample example = new GoodsFormatExample();
		example.createCriteria().andGfStoreIdEqualTo(storeId).andDeleteStatusEqualTo(0);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<GoodsFormat> findAll() {
		GoodsFormatExample example = new GoodsFormatExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsFormatExample example = new GoodsFormatExample();
		return mapper.countByExample(example);
	}

	public List<GoodsFormat> save(Iterable<GoodsFormat> entities) {
		List<GoodsFormat> list = new ArrayList<GoodsFormat>();
		for (GoodsFormat GoodsFormat : entities) {
			list.add(save(GoodsFormat));
		}
		return list;
	}

	public GoodsFormat save(GoodsFormat record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsFormat record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsFormat findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsFormat get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsFormatExample example = new GoodsFormatExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsFormat> findAll(Iterable<Long> ids) {
		GoodsFormatExample example = new GoodsFormatExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsFormat entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsFormat> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsFormat entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsFormatExample example = new GoodsFormatExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsFormatExample example = new GoodsFormatExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
