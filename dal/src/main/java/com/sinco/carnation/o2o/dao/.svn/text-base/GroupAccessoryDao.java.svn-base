package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.o2o.bo.GroupAccessoryBO;
import com.sinco.carnation.o2o.mapper.GroupAccessoryMapper;
import com.sinco.carnation.o2o.model.GroupAccessory;
import com.sinco.carnation.o2o.model.GroupAccessoryExample;

@Repository
public class GroupAccessoryDao {

	@Autowired
	private GroupAccessoryMapper mapper;

	/** generate code begin **/
	public List<GroupAccessoryBO> findAll() {
		GroupAccessoryExample example = new GroupAccessoryExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupAccessoryExample example = new GroupAccessoryExample();
		return mapper.countByExample(example);
	}

	public List<GroupAccessory> save(Iterable<GroupAccessory> entities) {
		List<GroupAccessory> list = new ArrayList<GroupAccessory>();
		for (GroupAccessory GroupAccessory : entities) {
			list.add(save(GroupAccessory));
		}
		return list;
	}

	public GroupAccessory save(GroupAccessory record) {

		mapper.insertSelective(record);

		return record;
	}

	public List<GroupAccessoryBO> findByAccessoryId(java.lang.Long accessoryId) {
		GroupAccessoryExample example = new GroupAccessoryExample();
		example.createCriteria().andAccessoryIdEqualTo(accessoryId);
		return mapper.selectByExample(example);
	}

	public int deleteByAccessoryId(java.lang.Long accessoryId) {
		GroupAccessoryExample example = new GroupAccessoryExample();
		example.createCriteria().andAccessoryIdEqualTo(accessoryId);
		return mapper.deleteByExample(example);
	}

	public List<GroupAccessoryBO> findByGroupGoodsId(java.lang.Long groupGoodsId) {
		GroupAccessoryExample example = new GroupAccessoryExample();
		example.createCriteria().andGroupGoodsIdEqualTo(groupGoodsId);
		return mapper.selectByExample(example);
	}

	public int deleteByGroupGoodsId(java.lang.Long groupGoodsId) {
		GroupAccessoryExample example = new GroupAccessoryExample();
		example.createCriteria().andGroupGoodsIdEqualTo(groupGoodsId);
		return mapper.deleteByExample(example);
	}

	/** generate code end **/

	public int deleteByPrimaryKey(Long imageId, Long groupGoodsId) {
		GroupAccessoryExample example = new GroupAccessoryExample();
		example.createCriteria().andGroupGoodsIdEqualTo(groupGoodsId).andAccessoryIdEqualTo(imageId);
		return mapper.deleteByExample(example);
	}
}
