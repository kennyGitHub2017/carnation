package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupFloorContentBO;
import com.sinco.carnation.o2o.mapper.GroupFloorContentMapper;
import com.sinco.carnation.o2o.model.GroupFloorContent;
import com.sinco.carnation.o2o.model.GroupFloorContentExample;

@Repository
public class GroupFloorContentDao {

	@Autowired
	private GroupFloorContentMapper mapper;

	/** generate code begin **/
	public List<GroupFloorContentBO> findAll() {
		GroupFloorContentExample example = new GroupFloorContentExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupFloorContentExample example = new GroupFloorContentExample();
		return mapper.countByExample(example);
	}

	public List<GroupFloorContent> save(Iterable<GroupFloorContent> entities) {
		List<GroupFloorContent> list = new ArrayList<GroupFloorContent>();
		for (GroupFloorContent GroupFloorContent : entities) {
			list.add(save(GroupFloorContent));
		}
		return list;
	}

	public GroupFloorContent save(GroupFloorContent record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupFloorContent record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupFloorContentBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupFloorContentBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupFloorContentBO> findAll(Iterable<Long> ids) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupFloorContent entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupFloorContent> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupFloorContent entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupFloorContentExample example = new GroupFloorContentExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/**
	 * 根据floorID查找与商品的关联关系
	 * 
	 * @param floorid
	 * @return groupFloorContentBOList
	 **/
	public List<GroupFloorContentBO> queryGroupCaseContentlistByFloorId(java.lang.Long floorid) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andFloorIdEqualTo(floorid);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据floorID查找与商品的关联关系
	 * 
	 * @param floorid
	 * @return groupFloorContentBOList
	 **/
	public List<GroupFloorContentBO> queryGroupCaseContentlistByFloorIdAndCityId(java.lang.Long floorid,
			java.lang.Long cityid) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andFloorIdEqualTo(floorid).andCityIdEqualTo(cityid);
		return mapper.selectByExample(example);
	}

	/**
	 * 根据floorid删除关与商品的关联关系
	 * 
	 * @param floorid
	 * @return void
	 */
	public void deleteByFloorId(java.lang.Long floorid) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andFloorIdEqualTo(floorid);
		mapper.deleteByExample(example);
	}

	/**
	 * 根据floorid,cityid删除关与商品的关联关系
	 * 
	 * @param floorid
	 * @return void
	 */
	public void deleteByFloorIdAndCityId(java.lang.Long floorid, java.lang.Long cityid) {
		GroupFloorContentExample example = new GroupFloorContentExample();
		example.createCriteria().andFloorIdEqualTo(floorid).andCityIdEqualTo(cityid);
		mapper.deleteByExample(example);
	}
}
