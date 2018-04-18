package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.mapper.ArticleClassMapper;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.carnation.sys.model.ArticleClassExample;
import com.sinco.dal.common.MyPage;

@Repository
public class ArticleClassDao {

	@Autowired
	private ArticleClassMapper mapper;

	/**
	 * 根据标识查找
	 * 
	 * @param mark
	 * @return
	 */
	public ArticleClassBO findByMark(String mark) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andMarkEqualTo(mark);
		List<ArticleClassBO> list = mapper.selectBOByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 按级别整理好的对象
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findLevelAll(boolean containManager) {
		List<ArticleClassBO> list = findAllOrder();

		List<ArticleClassBO> result = Lists.newArrayList();

		for (ArticleClassBO ac : list) {

			if (!containManager) {
				if (ac.getMark().equals("gongsidongtai") || ac.getMark().equals("ZS_WEB")
						|| ac.getMark().equals("sellernotice") || ac.getMark().equals("o2osellernotice")
						|| ac.getMark().equals("operatornotice")) {
					continue;
				}
			}
			if (ac.getParentId() == null) {
				ac.setChilds(findChild(list, ac.getId()));
				result.add(ac);
			}
		}

		return result;
	}

	/**
	 * 得到子对象
	 * 
	 * @return
	 */
	private List<ArticleClassBO> findChild(List<ArticleClassBO> allList, Long id) {

		List<ArticleClassBO> list = Lists.newArrayList();
		for (ArticleClassBO ac : allList) {
			if (id.equals(ac.getParentId())) {
				list.add(ac);
			}
		}

		for (ArticleClassBO ac : list) {
			ac.setChilds(findChild(allList, ac.getId()));
		}

		return list;
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<ArticleClassBO> findAllChild(Long... ids) {

		List<ArticleClassBO> list = findByParent(ids);

		if (list != null && list.size() > 0) {
			Long[] parents = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				parents[i] = list.get(i).getId();
			}
			list.addAll(findAllChild(parents));
		}
		return list;
	}

	public List<ArticleClassBO> findByParentIsNull() {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andParentIdIsNull();
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	/**
	 * 所有顶级分类
	 * 
	 * @return
	 */
	public List<ArticleClassBO> topClass() {
		return mapper.topClass();
	}

	public List<ArticleClassBO> findByParentIsNull(List<String> notMarks, Integer count) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andParentIdIsNull().andMarkIn(notMarks);
		example.setOrderByClause(" sequence asc");
		example.setCount(count);
		return mapper.selectBOByExample(example);
	}

	/**
	 * 
	 * @param parnetId
	 * @return
	 */
	public List<ArticleClassBO> findByParent(Long parnetId) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andParentIdEqualTo(parnetId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	/**
	 * 根据name 是到数量
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		ArticleClassExample example = new ArticleClassExample();
		ArticleClassExample.Criteria c = example.createCriteria();
		c.andClassNameEqualTo(name);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		return mapper.countByExample(example);
	}

	/**
	 * 分布查询
	 * 
	 * @param page
	 * @return
	 */
	public List<ArticleClassBO> findByPage(MyPage<ArticleClassBO> page) {
		List<ArticleClassBO> list = mapper.findByPage(page);
		page.setContent(list);
		return list;
	}

	/** generate code begin **/
	public List<ArticleClassBO> findAll() {
		ArticleClassExample example = new ArticleClassExample();
		return mapper.selectByExample(example);
	}

	public List<ArticleClassBO> findAllOrder() {
		ArticleClassExample example = new ArticleClassExample();
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	public List<ArticleClassBO> findArticleClassByParentId(Long parentClassId) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andParentIdEqualTo(parentClassId).andDeleteStatusEqualTo(0);
		example.setOrderByClause(" add_Time desc");
		return mapper.selectBOByExample(example);
	}

	public long count() {
		ArticleClassExample example = new ArticleClassExample();
		return mapper.countByExample(example);
	}

	public List<ArticleClass> save(Iterable<ArticleClass> entities) {
		List<ArticleClass> list = new ArrayList<ArticleClass>();
		for (ArticleClass ArticleClass : entities) {
			list.add(save(ArticleClass));
		}
		return list;
	}

	public ArticleClass save(ArticleClass record) {
		if (record.getId() == null) {
			record.setAddTime(new Date());
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ArticleClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ArticleClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ArticleClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ArticleClassBO> findAll(Iterable<Long> ids) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	List<ArticleClassBO> findByParent(Long... parents) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andParentIdIn(Lists.newArrayList(parents));
		return mapper.selectBOByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public int remove(java.lang.Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public void delete(ArticleClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ArticleClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ArticleClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ArticleClassExample example = new ArticleClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ArticleClassExample example = new ArticleClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ArticleClassBO> queryArticleList(String mark) {
		return mapper.queryArticleList(mark);
	}
}
