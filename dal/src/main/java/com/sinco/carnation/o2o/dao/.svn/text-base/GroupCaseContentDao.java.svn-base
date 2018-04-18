package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.o2o.mapper.GroupCaseContentMapper;
import com.sinco.carnation.o2o.model.GroupCaseContent;
import com.sinco.carnation.o2o.bo.GroupCaseContentBO;
import com.sinco.carnation.o2o.model.GroupCaseContentExample;

@Repository
public class GroupCaseContentDao {

	@Autowired
	private GroupCaseContentMapper mapper;

	/** generate code begin **/
	public List<GroupCaseContentBO> findAll() {
		GroupCaseContentExample example = new GroupCaseContentExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupCaseContentExample example = new GroupCaseContentExample();
		return mapper.countByExample(example);
	}

	public List<GroupCaseContent> save(Iterable<GroupCaseContent> entities) {
		List<GroupCaseContent> list = new ArrayList<GroupCaseContent>();
		for (GroupCaseContent GroupCaseContent : entities) {
			list.add(save(GroupCaseContent));
		}
		return list;
	}

	public GroupCaseContent save(GroupCaseContent record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupCaseContent record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupCaseContentBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupCaseContentBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupCaseContentBO> findAll(Iterable<Long> ids) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupCaseContent entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupCaseContent> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupCaseContent entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupCaseContentExample example = new GroupCaseContentExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 根据caseID查找与商品的关联关系
	 * 
	 * @param caseid
	 * @return groupCaseContentBOList
	 **/
	public List<GroupCaseContentBO> queryGroupCaseContentlistByCaseId(java.lang.Long caseid) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andCaseIdEqualTo(caseid);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据caseID,cityID查找与商品的关联关系
	 * 
	 * @param caseid
	 * @return groupCaseContentBOList
	 **/
	public List<GroupCaseContentBO> queryGroupCaseContentlistByCaseIdAndCityId(java.lang.Long caseid,
			java.lang.Long cityid) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andCaseIdEqualTo(caseid).andCityIdEqualTo(cityid);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据caseID删除关与商品的关联关系
	 * 
	 * @param caseid
	 * @return void
	 */
	public void deleteByCaseId(java.lang.Long caseid) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andCaseIdEqualTo(caseid);
		mapper.deleteByExample(example);
	}

	/**
	 * 根据caseID和cityID删除关与商品的关联关系
	 * 
	 * @param caseid
	 * @return void
	 */
	public void deleteGoodsByCaseIdAndCityId(java.lang.Long caseid, java.lang.Long cityid) {
		GroupCaseContentExample example = new GroupCaseContentExample();
		example.createCriteria().andCaseIdEqualTo(caseid).andCityIdEqualTo(cityid);
		mapper.deleteByExample(example);
	}

}
