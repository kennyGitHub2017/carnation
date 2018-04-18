package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.mapper.GoodsTypeMapper;
import com.sinco.carnation.goods.model.GoodsType;
import com.sinco.carnation.goods.model.GoodsTypeExample;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsTypeDao {

	@Autowired
	private GoodsTypeMapper mapper;

	@Autowired
	private Mapper objMap;

	/**
	 * 得到bo
	 * 
	 * @param id
	 * @return
	 */
	public GoodsTypeBO getBO(java.lang.Long id) {
		return objMap.map(mapper.selectByPrimaryKey(id), GoodsTypeBO.class);
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	public List<GoodsTypeBO> findByPage(MyPage<GoodsTypeBO> page) {
		return mapper.findByPage(page);
	}

	/**
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		GoodsTypeExample example = new GoodsTypeExample();
		GoodsTypeExample.Criteria c = example.createCriteria().andNameEqualTo(name);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		return mapper.countByExample(example);
	}

	/** generate code begin **/
	public List<GoodsTypeBO> findAll() {
		GoodsTypeExample example = new GoodsTypeExample();
		return mapper.selectBOByExample(example);
	}

	public long count() {
		GoodsTypeExample example = new GoodsTypeExample();
		return mapper.countByExample(example);
	}

	public List<GoodsType> save(Iterable<GoodsType> entities) {
		List<GoodsType> list = new ArrayList<GoodsType>();
		for (GoodsType GoodsType : entities) {
			list.add(save(GoodsType));
		}
		return list;
	}

	public GoodsType save(GoodsType record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsType record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsType findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsType get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsType> findAll(Iterable<Long> ids) {
		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsType entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsType> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsType entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsTypeExample example = new GoodsTypeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsTypeExample example = new GoodsTypeExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
