package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.ComplaintGoodsMapper;
import com.sinco.carnation.shop.model.ComplaintGoods;
import com.sinco.carnation.shop.bo.ComplaintGoodsBO;
import com.sinco.carnation.shop.model.ComplaintGoodsExample;
import com.sinco.carnation.shop.vo.ComplaintGoodsVO;

@Repository
public class ComplaintGoodsDao {

	@Autowired
	private ComplaintGoodsMapper mapper;

	/** generate code begin **/
	public List<ComplaintGoodsBO> findAll() {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		return mapper.countByExample(example);
	}

	public List<ComplaintGoods> save(Iterable<ComplaintGoods> entities) {
		List<ComplaintGoods> list = new ArrayList<ComplaintGoods>();
		for (ComplaintGoods ComplaintGoods : entities) {
			list.add(save(ComplaintGoods));
		}
		return list;
	}

	public ComplaintGoods save(ComplaintGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ComplaintGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ComplaintGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ComplaintGoodsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ComplaintGoodsBO> findAll(Iterable<Long> ids) {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ComplaintGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ComplaintGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ComplaintGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ComplaintGoodsExample example = new ComplaintGoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ComplaintGoodsBO> findListByVo(ComplaintGoodsVO vo) {
		return mapper.findListByVo(vo);
	}
}
