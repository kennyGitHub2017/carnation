package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.mapper.GroupComplaintMapper;
import com.sinco.carnation.o2o.model.GroupComplaint;
import com.sinco.carnation.o2o.model.GroupComplaintExample;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class GroupComplaintDao {
	@Autowired
	private DicNameMappingHandle mappingHandle;
	@Autowired
	private GroupComplaintMapper mapper;

	/** generate code begin **/
	public List<GroupComplaintBO> findAll() {
		GroupComplaintExample example = new GroupComplaintExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupComplaintExample example = new GroupComplaintExample();
		return mapper.countByExample(example);
	}

	public GroupComplaintBO findByOrder(Long orderId) {
		GroupComplaintExample example = new GroupComplaintExample();
		example.createCriteria().andOfIdEqualTo(orderId);
		List<GroupComplaintBO> list = mapper.selectByExampleWithBLOBs(example);

		return list.isEmpty() ? null : list.get(0);
	}

	public List<GroupComplaint> save(Iterable<GroupComplaint> entities) {
		List<GroupComplaint> list = new ArrayList<GroupComplaint>();
		for (GroupComplaint GroupComplaint : entities) {
			list.add(save(GroupComplaint));
		}
		return list;
	}

	public List<GroupComplaintBO> search(GroupComplaintVO vo, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = mapper.search(vo, page);
		mappingHandle.mappinHandle(list);
		mappingHandle.mappinHandle(vo);

		return list;
	}

	public GroupComplaint save(GroupComplaint record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupComplaint record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupComplaintBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupComplaintBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupComplaintExample example = new GroupComplaintExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupComplaintBO> findAll(Iterable<Long> ids) {
		GroupComplaintExample example = new GroupComplaintExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupComplaint entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupComplaint> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupComplaint entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupComplaintExample example = new GroupComplaintExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupComplaintExample example = new GroupComplaintExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/** 我的运营商投诉列表 **/
	public List<GroupComplaintBO> groupComplaintList(int status, String name, java.lang.Long id,
			MyPage<GroupComplaintBO> page) {
		return mapper.groupComplaintList(status, name, id, page);
	}

	/** 我的运营商投诉列表 **/
	public GroupComplaintBO groupComplaintDetails(Integer id) {
		// return mapper.groupComplaintDetails(id);
		List<GroupComplaintBO> list = mapper.groupComplaintDetails(id);
		if (list != null) {
			mappingHandle.mappinHandle(list);
			return list.get(0);
		}
		return null;
	}

	// 查询运营商的投诉列表
	public List<GroupComplaintBO> searchOperatorList(GroupComplaintVO vo, MyPage<GroupComplaintBO> page) {
		List<GroupComplaintBO> list = mapper.searchOperatorList(vo, page);
		mappingHandle.mappinHandle(list);
		return list;
	}

}
