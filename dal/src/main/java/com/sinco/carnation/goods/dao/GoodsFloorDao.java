package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.mapper.GoodsFloorMapper;
import com.sinco.carnation.goods.model.GoodsFloor;
import com.sinco.carnation.goods.model.GoodsFloorExample;
import com.sinco.dal.common.MyPage;

@Repository
public class GoodsFloorDao {

	@Autowired
	private GoodsFloorMapper mapper;

	/**
	 * 查询子
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsFloorBO> findByParent(Long parentId) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		example.setOrderByClause("gf_sequence asc");
		return mapper.selectBOByExample(example);
	}

	/**
	 * 查询分级的数据
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsFloorBO> findLevelByDisplay(Boolean display) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andGfDisplayEqualTo(display);
		example.setOrderByClause("gf_sequence asc");
		List<GoodsFloorBO> all = mapper.selectBOByExample(example);
		List<GoodsFloorBO> reuslt = new ArrayList<GoodsFloorBO>();
		for (GoodsFloorBO gf : all) {
			if (gf.getParentId() == null) {
				List<GoodsFloorBO> childs = new ArrayList<GoodsFloorBO>();
				for (GoodsFloorBO child : all) {
					if (child.getParentId() != null && child.getParentId().equals(gf.getId())) {
						childs.add(child);
					}
				}
				gf.setChilds(childs);
				reuslt.add(gf);
			}
		}
		return reuslt;
	}

	/**
	 * 查询分级的数据
	 * 
	 * @param parentId
	 * @return
	 */
	public GoodsFloorBO findLevelById(Long id) {
		GoodsFloorBO gf = mapper.selectBOByPrimaryKey(id);

		if (gf.getParentId() == null) {
			gf.setChilds(findByParent(gf.getId()));
		}
		return gf;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public GoodsFloorBO findBOById(Long id) {
		return mapper.selectBOByPrimaryKey(id);
	}

	/**
	 * 根据父删除
	 * 
	 * @param parentId
	 * @return
	 */
	public int deleteByParent(Long parentId) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return mapper.deleteByExample(example);
	}

	public List<GoodsFloorBO> findByLevel(Integer level) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andGfLevelEqualTo(level);
		example.setOrderByClause("gf_sequence asc");
		return mapper.selectBOByExample(example);
	}

	public List<GoodsFloorBO> findByPage(Integer level, MyPage<GoodsFloorBO> page) {
		return mapper.findByPage(level, page);
	}

	/** generate code begin **/
	public List<GoodsFloor> findAll() {
		GoodsFloorExample example = new GoodsFloorExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsFloorExample example = new GoodsFloorExample();
		return mapper.countByExample(example);
	}

	public List<GoodsFloor> save(Iterable<GoodsFloor> entities) {
		List<GoodsFloor> list = new ArrayList<GoodsFloor>();
		for (GoodsFloor GoodsFloor : entities) {
			list.add(save(GoodsFloor));
		}
		return list;
	}

	public GoodsFloor save(GoodsFloor record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsFloor record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsFloor findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsFloor get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsFloor> findAll(Iterable<Long> ids) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsFloor entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsFloor> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsFloor entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsFloorExample example = new GoodsFloorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsFloorExample example = new GoodsFloorExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
