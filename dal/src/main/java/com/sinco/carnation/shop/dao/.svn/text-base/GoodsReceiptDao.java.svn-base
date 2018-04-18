package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.GoodsReceiptBO;
import com.sinco.carnation.shop.mapper.GoodsReceiptMapper;
import com.sinco.carnation.shop.model.GoodsReceipt;
import com.sinco.carnation.shop.model.GoodsReceiptExample;
import com.sinco.dal.common.MyPage;

@Repository
@Transactional
public class GoodsReceiptDao {

	@Autowired
	private GoodsReceiptMapper mapper;

	/** generate code begin **/
	public List<GoodsReceiptBO> findAll() {
		GoodsReceiptExample example = new GoodsReceiptExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsReceiptExample example = new GoodsReceiptExample();
		return mapper.countByExample(example);
	}

	public List<GoodsReceipt> save(Iterable<GoodsReceipt> entities) {
		List<GoodsReceipt> list = new ArrayList<GoodsReceipt>();
		for (GoodsReceipt GoodsReceipt : entities) {
			list.add(save(GoodsReceipt));
		}
		return list;
	}

	public GoodsReceipt save(GoodsReceipt record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsReceipt record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsReceiptBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsReceiptBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsReceiptExample example = new GoodsReceiptExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsReceiptBO> findAll(Iterable<Long> ids) {
		GoodsReceiptExample example = new GoodsReceiptExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsReceipt entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsReceipt> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsReceipt entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsReceiptExample example = new GoodsReceiptExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsReceiptExample example = new GoodsReceiptExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public void findGoodsReceiptList(MyPage<GoodsReceiptBO> page, Long goodsId) {

		mapper.findGoodsReceiptList(page, goodsId);
	}

}
