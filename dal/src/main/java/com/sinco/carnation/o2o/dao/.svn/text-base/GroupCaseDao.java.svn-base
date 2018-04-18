package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.mapper.GroupCaseMapper;
import com.sinco.carnation.o2o.model.GroupCase;
import com.sinco.carnation.o2o.model.GroupCaseExample;
import com.sinco.carnation.o2o.vo.GroupCaseShowVO;
import com.sinco.carnation.o2o.vo.GroupCaseVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GroupCaseDao {

	@Autowired
	private GroupCaseMapper mapper;

	/**
	 * 查找显示的橱窗
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupCaseBO> findShow(GroupCaseShowVO vo) {
		return mapper.findShow(vo);
	}

	/** generate code begin **/
	public List<GroupCaseBO> findAll() {
		GroupCaseExample example = new GroupCaseExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupCaseExample example = new GroupCaseExample();
		return mapper.countByExample(example);
	}

	public List<GroupCase> save(Iterable<GroupCase> entities) {
		List<GroupCase> list = new ArrayList<GroupCase>();
		for (GroupCase GroupCase : entities) {
			list.add(save(GroupCase));
		}
		return list;
	}

	public GroupCase save(GroupCase record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupCase record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupCaseBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupCaseBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupCaseExample example = new GroupCaseExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupCaseBO> findAll(Iterable<Long> ids) {
		GroupCaseExample example = new GroupCaseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupCase entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupCase> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupCase entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupCaseExample example = new GroupCaseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupCaseExample example = new GroupCaseExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupCaseBO> findPageByVO(GroupCaseVO vo, MyPage<GroupCaseBO> page) {
		return mapper.findPageByVO(vo, page);
	}

	public void updateDisplay(java.lang.Long id, int display) {
		GroupCaseBO bo = mapper.selectByPrimaryKey(id);
		bo.setDisplay(display);
		mapper.updateByPrimaryKeySelective(bo);
	}

	public void updateSequnce(java.lang.Long id, int seq) {
		GroupCaseBO bo = mapper.selectByPrimaryKey(id);
		bo.setSequence(seq);
		mapper.updateByPrimaryKeySelective(bo);
	}
}
