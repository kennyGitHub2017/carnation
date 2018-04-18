package com.sinco.carnation.goods.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.mapper.GoodsClassMapper;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsClassExample;
import com.sinco.carnation.goods.vo.GoodsClassCountVO;
import com.sinco.data.core.Page;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.DicLoadData;
import com.sinco.dic.client.model.DicBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Repository
public class GoodsClassDao {

	@Autowired
	private GoodsClassMapper mapper;

	@Autowired
	private DicContent dicContent;

	@PostConstruct
	public void init() {
		dicContent.setDicCache(GoodsClassBO.class, new DicLoadData() {
			@Override
			public List<DicBase> loadDate() {
				List<GoodsClassBO> list = findNormalAll();
				return Lists.newArrayList(list.toArray(new DicBase[list.size()]));
			}
		}, false);
	}

	public List<GoodsClassBO> findRelatedGoodsClass(Integer level, String className) {
		return mapper.findRelatedGoodsClass(level, className);
	}

	/**
	 * 得到正常的数据
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findNormalAll() {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false);
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	/**
	 * 根据商品规格查找
	 * 
	 * @param specId
	 * @return
	 */
	public List<GoodsClassBO> findBySpec(Long specId) {
		return mapper.findBySpec(specId);
	}

	/**
	 * 根据商品规格和分类类型查找
	 * 
	 * @param specId
	 * @return
	 */
	public List<GoodsClassBO> findBySpecAndClassId(Long specId, Long classId) {
		return mapper.findBySpecAndClassId(specId, classId);
	}

	/**
	 * 按级别整理好的对象
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findLevelAll(Boolean display) {
		List<GoodsClassBO> dicData = dicContent.getRootTreeDic(GoodsClassBO.class);

		Collections.sort(dicData);

		return dicData;
	}

	/**
	 * 得到子对象
	 * 
	 * @return
	 */
	public Collection<GoodsClassBO> findChild(List<GoodsClassBO> allList, Long id) {

		List<GoodsClassBO> list = Lists.newArrayList();
		for (GoodsClassBO ac : allList) {
			if (id.equals(ac.getParentId())) {
				list.add(ac);
			}
		}
		Collections.sort(list);
		for (GoodsClassBO ac : list) {
			ac.setChilds(findChild(allList, ac.getId()));
		}

		return list;
	}

	/**
	 * 判断名称是否存在
	 * 
	 * @param name
	 * @param id
	 * @param parentId
	 * @return
	 */
	public int countByName(String name, Long id, Long parentId) {
		GoodsClassExample example = new GoodsClassExample();
		GoodsClassExample.Criteria c = example.createCriteria().andDeleteStatusEqualTo(false)
				.andClassNameEqualTo(name);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		if (parentId != null) {
			c.andParentIdEqualTo(parentId);
		} else {
			c.andParentIdIsNull();
		}

		return mapper.countByExample(example);
	}

	/**
	 * 
	 * @param gc
	 * @param ids
	 * @return
	 */
	public int updateByIds(GoodsClass gc, List<Long> ids) {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andIdIn(ids);

		return mapper.updateByExampleSelective(gc, example);
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findAllChild(Long... ids) {

		List<GoodsClassBO> list = findByParent(ids);

		if (list != null && list.size() > 0) {
			Long[] parents = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				parents[i] = list.get(i).getId();
			}
			list.addAll(findAllChild(parents));
		}
		return list;
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findAllParents() {

		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andParentIdIsNull().andDeleteStatusEqualTo(false);
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	/**
	 * 分页查找
	 * 
	 * @param page
	 * @return
	 */
	public List<GoodsClassBO> findParentIsNullPage(@Param("page") Page<GoodsClassBO> page) {
		List<GoodsClassBO> list = mapper.findParentIsNullPage(page);
		page.setContent(list);
		return list;
	}

	/**
	 * 查找子集
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsClassBO> findByParent(Long parentId) {
		return mapper.findByParent(parentId);
	}

	/**
	 * 查找指定数量的数据
	 * 
	 * @param parentId
	 * @param display
	 * @param count
	 * @return
	 */
	public Collection<GoodsClassBO> findLevelByCount(GoodsClassCountVO vo) {
		Collection<DicBase> dicData = dicContent.getDics(GoodsClassBO.class);

		List<GoodsClassBO> list = Lists.newArrayList();
		for (DicBase dicBase : dicData) {
			GoodsClassBO gc = (GoodsClassBO) dicBase;
			boolean isAdd = true;
			if (vo.getDisplay() != null) {
				if (!gc.getDisplay().equals(vo.getDisplay())) {
					isAdd = false;
				}
			}
			if (vo.getRecommend() != null) {
				if (!gc.getRecommend().equals(vo.getRecommend())) {
					isAdd = false;
				}
			}
			if (isAdd) {
				list.add(gc);
			}
		}

		Collection<GoodsClassBO> result = new TreeSet<GoodsClassBO>();

		for (GoodsClassBO ac : list) {
			if (vo.getCount() != null && vo.getCount() >= 0) {
				if (result.size() >= vo.getCount()) {
					break;
				}
			}
			if (ac.getParentId() == null) {
				ac.setChilds(findChild(list, ac.getId()));
				result.add(ac);
			}
		}
		for (GoodsClassBO ac : result) {
			System.out.println(ac.getClassName() + "======");
		}

		return result;
	}

	/**
	 * 查找父为空的
	 * 
	 * @return
	 */
	public List<GoodsClassBO> findParnetIsNull() {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andParentIdIsNull();
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	public List<GoodsClassBO> findByParent(Long... parents) {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andParentIdIn(Lists.newArrayList(parents));
		return mapper.selectBOByExample(example);
	}

	public GoodsClassBO getBO(java.lang.Long id) {
		return mapper.selectBOByPrimaryKey(id);
	}

	/** generate code begin **/
	public List<GoodsClass> findAll() {
		GoodsClassExample example = new GoodsClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GoodsClassExample example = new GoodsClassExample();
		return mapper.countByExample(example);
	}

	public List<GoodsClass> save(Iterable<GoodsClass> entities) {
		List<GoodsClass> list = new ArrayList<GoodsClass>();
		for (GoodsClass GoodsClass : entities) {
			list.add(save(GoodsClass));
		}
		return list;
	}

	public GoodsClass save(GoodsClass record) {
		if (record.getId() == null) {
			record.setAddTime(new Date());
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GoodsClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GoodsClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GoodsClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GoodsClass> findAll(Iterable<Long> ids) {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GoodsClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GoodsClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GoodsClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GoodsClassExample example = new GoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GoodsClassExample example = new GoodsClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public GoodsClassBO getBOWithParent(java.lang.Long id) {
		return mapper.selectBoWithParentByPrimaryKey(id);
	}

	public List<GoodsClassBO> findGoodsClassByLevel(Integer level) {
		return this.mapper.findGoodsClassByLevel(level);
	}

	public List<GoodsClassBO> findByCount(GoodsClassCountVO vo) {
		return this.mapper.findByCount(vo);
	}

	public List<GoodsClassBO> findByCountVO(GoodsClassCountVO vo) {
		return this.mapper.findByCountVO(vo);
	}
	
	public String findBnameById(String id){
		return this.mapper.findBnameById(id);
	}
}
