package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.mapper.GoodsSpecificationMapper;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.model.GoodsSpecificationExample;
import com.sinco.carnation.goods.vo.GoodsSpecificationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsSpecificationDao {

	@Autowired
	private GoodsSpecificationMapper mapper;

	@Autowired
	private Mapper objMap;

	public List<GoodsSpecificationBO> selectGoodsSpecList(Long goodsId) {
		return mapper.selectGoodsSpecList(goodsId);
	}

	/**
	 * count by name and specType
	 * 
	 * @param name
	 * @param specType
	 * @param id
	 * @return
	 */
	public int countByNameAndSpecType(String name, Integer specType, Long id) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		GoodsSpecificationExample.Criteria c = example.createCriteria().andNameEqualTo(name)
				.andSpecTypeEqualTo(specType);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}

		return mapper.countByExample(example);
	}

	public int countByNameAndStoreId(String name, Long storeId, Long id) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		GoodsSpecificationExample.Criteria c = example.createCriteria().andNameEqualTo(name)
				.andStoreIdEqualTo(storeId);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}

		return mapper.countByExample(example);
	}

	/**
	 * 得到bo
	 * 
	 * @param id
	 * @return
	 */
	public GoodsSpecificationBO findBOById(Long id) {
		return objMap.map(mapper.selectByPrimaryKey(id), GoodsSpecificationBO.class);
	}

	public List<GoodsSpecificationBO> findBOPage(MyPage<GoodsSpecificationBO> page, Integer type, Long storeId) {
		return mapper.findBOPage(page, type, storeId);
	}

	/** generate code begin **/
	public List<GoodsSpecification> findAll() {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		return mapper.countByExample(example);
	}

	public List<GoodsSpecification> save(Iterable<GoodsSpecification> entities) {
		List<GoodsSpecification> list = new ArrayList<GoodsSpecification>();
		for (GoodsSpecification GoodsSpecification : entities) {
			list.add(save(GoodsSpecification));
		}
		return list;
	}

	public GoodsSpecification save(GoodsSpecification record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsSpecification record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsSpecification findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsSpecification get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsSpecification> findAll(Iterable<Long> ids) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<GoodsSpecification> findByType(Integer type) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andSpecTypeEqualTo(type);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public List<GoodsSpecification> findByStoreId(Long storeId) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andStoreIdEqualTo(storeId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public List<GoodsSpecification> findByTypeAndClassId(Integer type, Long goodsClassId) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andSpecTypeEqualTo(type).andGoodsClassIdEqualTo(goodsClassId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public List<GoodsSpecification> findByStoreIdAndClassId(Long storeId, Long goodsClassId) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andStoreIdEqualTo(storeId).andGoodsClassIdEqualTo(goodsClassId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsSpecification entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsSpecification> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsSpecification entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsSpecificationExample example = new GoodsSpecificationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GoodsSpecificationBO> findByVO(MyPage<GoodsSpecificationBO> page, GoodsSpecificationVO vo) {
		return mapper.findByVO(page, vo);
	}
}
