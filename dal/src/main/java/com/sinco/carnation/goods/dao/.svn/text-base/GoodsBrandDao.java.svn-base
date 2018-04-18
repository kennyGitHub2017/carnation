package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.mapper.GoodsBrandMapper;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsBrandExample;
import com.sinco.carnation.goods.vo.GoodsBrandShowIndexVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsBrandDao {

	@Autowired
	private GoodsBrandMapper mapper;

	/**
	 * 用于商城显示,根据ids查找
	 * 
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("unused")
	public List<GoodsBrandBO> findShopListByIds(List<Long> ids) {
		GoodsBrandExample example = new GoodsBrandExample();
		GoodsBrandExample.Criteria c = example.createCriteria().andIdIn(ids).andDeleteStatusEqualTo(0);
		return mapper.selectBOByExample(example);
	}

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsBrandBO> findByShowIndex(GoodsBrandShowIndexVO vo) {
		return mapper.findByShowIndex(vo);
	}

	/**
	 * find bo by id
	 * 
	 * @param id
	 * @return
	 */
	public GoodsBrandBO findBOById(Long id) {
		return mapper.findBOById(id);
	}

	/**
	 * 根据名称查询数量
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		GoodsBrandExample example = new GoodsBrandExample();
		GoodsBrandExample.Criteria c = example.createCriteria().andNameEqualTo(name)
				.andDeleteStatusEqualTo(0);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		return mapper.countByExample(example);
	}

	/**
	 * 
	 * @param gb
	 * @param ids
	 * @return
	 */
	public int updateByIds(GoodsBrand gb, List<Long> ids) {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andIdIn(ids);
		return mapper.updateByExampleSelective(gb, example);
	}

	/**
	 * 分页查询
	 * 
	 * @param brandFindVO
	 * @param page
	 * @return
	 */
	public List<GoodsBrandBO> findByPage(BrandFindVO brandFindVO, MyPage<GoodsBrandBO> page) {
		return mapper.findByPage(brandFindVO, page);
	}

	/**
	 * 根据商品类别查找品牌
	 * 
	 * @param gcId
	 * @return
	 */
	public List<GoodsBrandBO> findByGoodsClass(Long gcId) {
		return mapper.findByGoodsClass(gcId);
	}

	/**
	 * 根据商品类型查找品牌
	 * 
	 * @param gcId
	 * @return
	 */
	public List<GoodsBrandBO> findByGoodsType(Long gtId) {
		return mapper.findByGoodsType(gtId);
	}

	/**
	 * 查找品牌分类不为空的
	 * 
	 * @return
	 */
	public List<GoodsBrandBO> findByCategoryIsNotNul() {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andCategoryIdIsNotNull().andDeleteStatusEqualTo(0);
		return mapper.selectBOByExample(example);
	}

	/** generate code begin **/
	public List<GoodsBrand> findAll() {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andDeleteStatusEqualTo(0);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsBrandExample example = new GoodsBrandExample();
		return mapper.countByExample(example);
	}

	public List<GoodsBrand> save(Iterable<GoodsBrand> entities) {
		List<GoodsBrand> list = new ArrayList<GoodsBrand>();
		for (GoodsBrand GoodsBrand : entities) {
			list.add(save(GoodsBrand));
		}
		return list;
	}

	public GoodsBrand save(GoodsBrand record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsBrand record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsBrand findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsBrand get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsBrand> findAll(Iterable<Long> ids) {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids)).andDeleteStatusEqualTo(0);
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsBrand entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsBrand> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsBrand entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsBrandExample example = new GoodsBrandExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsBrandExample example = new GoodsBrandExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GoodsBrandBO> findByVo(GoodsBrand record) {
		return this.mapper.findByVo(record);
	}
	
	public List<GoodsBrandBO> selectByAll()
	{
		return this.mapper.selectByAll();
	}
}
