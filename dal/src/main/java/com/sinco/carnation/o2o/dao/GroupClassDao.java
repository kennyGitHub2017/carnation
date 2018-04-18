package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.mapper.GroupClassMapper;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.model.GroupClassExample;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

@Repository
public class GroupClassDao {

	@Autowired
	private GroupClassMapper mapper;

	/**
	 * 得到正常的数据
	 * 
	 * @return
	 */
	public List<GroupClassBO> findNormalAll() {
		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false);
		example.setOrderByClause(" gc_sequence asc");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<GroupClassBO> findAll() {
		GroupClassExample example = new GroupClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupClassExample example = new GroupClassExample();
		return mapper.countByExample(example);
	}

	public List<GroupClass> save(Iterable<GroupClass> entities) {
		List<GroupClass> list = new ArrayList<GroupClass>();
		for (GroupClass GroupClass : entities) {
			list.add(save(GroupClass));
		}
		return list;
	}

	public GroupClass save(GroupClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupClassBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupClassBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupClassBO> findAll(Iterable<Long> ids) {
		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupClassExample example = new GroupClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 分页查找
	 * 
	 * @param page
	 * @return
	 */
	public List<GroupClassBO> findParentIsNullPage(@Param("page") Page<GroupClassBO> page) {
		List<GroupClassBO> list = mapper.findParentIsNullPage(page);
		page.setContent(list);
		return list;
	}

	public List<GroupClassBO> findByParent(@Param("parentId") Long parentId) {
		List<GroupClassBO> list = mapper.findByParent(parentId);
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
		GroupClassExample example = new GroupClassExample();
		GroupClassExample.Criteria c = example.createCriteria().andDeleteStatusEqualTo(false)
				.andGcNameEqualTo(name);
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

	public List<GroupClassBO> findByParent(Long... parents) {
		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andParentIdIn(Lists.newArrayList(parents));
		return mapper.selectByExample(example);
	}

	/**
	 * 得到所有子对象,递归
	 * 
	 * @return
	 */
	public List<GroupClassBO> findAllChild(Long... ids) {

		List<GroupClassBO> list = findByParent(ids);

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
	public List<GroupClassBO> findAllParents() {

		GroupClassExample example = new GroupClassExample();
		example.createCriteria().andParentIdIsNull().andDeleteStatusEqualTo(false);
		example.setOrderByClause(" gc_sequence asc");
		return mapper.selectByExample(example);
	}

	public List<GroupClassBO> queryGroupClassList(MyPage<GroupClassBO> page) {
		return mapper.queryGroupClassList(page);
	}
}
