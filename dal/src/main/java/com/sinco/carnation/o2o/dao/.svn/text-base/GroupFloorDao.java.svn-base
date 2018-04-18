package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupFloorBO;
import com.sinco.carnation.o2o.mapper.GroupFloorMapper;
import com.sinco.carnation.o2o.model.GroupFloor;
import com.sinco.carnation.o2o.model.GroupFloorExample;
import com.sinco.carnation.o2o.vo.GroupFloorVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GroupFloorDao {

	@Autowired
	private GroupFloorMapper mapper;

	/**
	 * 得到显示的数据
	 * 
	 * @return
	 */
	public List<GroupFloorBO> findDisplayAll() {
		GroupFloorExample example = new GroupFloorExample();
		example.createCriteria().andDisplayEqualTo(true);
		example.setOrderByClause(" gf_sequence");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<GroupFloorBO> findAll() {
		GroupFloorExample example = new GroupFloorExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupFloorExample example = new GroupFloorExample();
		return mapper.countByExample(example);
	}

	public List<GroupFloor> save(Iterable<GroupFloor> entities) {
		List<GroupFloor> list = new ArrayList<GroupFloor>();
		for (GroupFloor GroupFloor : entities) {
			list.add(save(GroupFloor));
		}
		return list;
	}

	public GroupFloor save(GroupFloor record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupFloor record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupFloorBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupFloorBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupFloorExample example = new GroupFloorExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupFloorBO> findAll(Iterable<Long> ids) {
		GroupFloorExample example = new GroupFloorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupFloor entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupFloor> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupFloor entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupFloorExample example = new GroupFloorExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupFloorExample example = new GroupFloorExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupFloorBO> findPageByVO(GroupFloorVO vo, MyPage<GroupFloorVO> page) {
		return mapper.findPageByVO(vo, page);
	}

	public void updateDisplay(java.lang.Long id, String display) {
		GroupFloorBO bo = mapper.selectByPrimaryKey(id);
		if (display != null && display.equals("true")) {
			bo.setDisplay(true);
		} else {
			bo.setDisplay(false);
		}
		mapper.updateByPrimaryKeySelective(bo);
	}

	public void updateSequnce(java.lang.Long id, int seq) {
		GroupFloorBO bo = mapper.selectByPrimaryKey(id);
		bo.setGfSequence(seq);
		mapper.updateByPrimaryKeySelective(bo);
	}
}
