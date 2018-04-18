package com.sinco.carnation.label.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.label.mapper.LabelClassMapper;
import com.sinco.carnation.label.model.LabelClass;
import com.sinco.carnation.label.bo.LabelClassBO;
import com.sinco.carnation.label.model.LabelClassExample;
import com.sinco.dal.common.MyPage;

@Repository
public class LabelClassDao {

	@Autowired
	private LabelClassMapper mapper;

	/** generate code begin **/
	public List<LabelClassBO> findAll() {
		LabelClassExample example = new LabelClassExample();
		return mapper.selectByExample(example);
	}

	List<LabelClassBO> findAll(Iterable<Long> ids) {
		LabelClassExample example = new LabelClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		LabelClassExample example = new LabelClassExample();
		return mapper.countByExample(example);
	}

	public List<LabelClass> save(Iterable<LabelClass> entities) {
		List<LabelClass> list = new ArrayList<LabelClass>();
		for (LabelClass LabelClass : entities) {
			list.add(save(LabelClass));
		}
		return list;
	}

	public LabelClass save(LabelClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(LabelClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public LabelClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		LabelClassExample example = new LabelClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public int remove(java.lang.Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public void delete(LabelClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<LabelClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (LabelClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		LabelClassExample example = new LabelClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		LabelClassExample example = new LabelClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public List<LabelClassBO> findByPage(MyPage<LabelClassBO> page) {
		List<LabelClassBO> list = mapper.findByPage(page);
		page.setContent(list);
		return list;
	}

	public List<LabelClassBO> findAllOrder() {
		LabelClassExample example = new LabelClassExample();
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	public LabelClass get(long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<LabelClassBO> findAllChild(Long... ids) {
		List<LabelClassBO> list = findByParent(ids);
		if (list != null && list.size() > 0) {
			Long[] parents = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				parents[i] = list.get(i).getId();
			}
			list.addAll(findAllChild(parents));
		}
		return list;
	}

	public List<LabelClassBO> findByParent(Long... parents) {
		LabelClassExample example = new LabelClassExample();
		example.createCriteria().andParentIdIn(Lists.newArrayList(parents));
		return mapper.selectBOByExample(example);
	}

	/**
	 * 
	 * @param parnetId
	 * @return
	 */
	public List<LabelClassBO> findByParent(Long parnetId) {
		LabelClassExample example = new LabelClassExample();
		example.createCriteria().andParentIdEqualTo(parnetId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectBOByExample(example);
	}

	public int countByName(String className, Long id) {
		LabelClassExample example = new LabelClassExample();
		LabelClassExample.Criteria c = example.createCriteria();
		c.andClassNameEqualTo(className);
		if (id != null) {
			c.andIdNotEqualTo(id);
		}
		return mapper.countByExample(example);
	}
}
