package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CheckResultGroupBO;
import com.sinco.carnation.sns.mapper.CheckResultGroupMapper;
import com.sinco.carnation.sns.model.CheckResultGroup;
import com.sinco.carnation.sns.model.CheckResultGroupExample;
import com.sinco.carnation.sns.vo.CheckResultGroupVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckResultGroupDao {

	@Autowired
	private CheckResultGroupMapper mapper;

	/** generate code begin **/
	public List<CheckResultGroupBO> findAll() {
		CheckResultGroupExample example = new CheckResultGroupExample();
		return mapper.selectByExample(example);
	}

	public List<CheckResultGroupBO> search(CheckResultGroupVO vo, MyPage<CheckResultGroupBO> page) {
		return mapper.search(vo, page);
	}

	public long count() {
		CheckResultGroupExample example = new CheckResultGroupExample();
		return mapper.countByExample(example);
	}

	public List<CheckResultGroup> save(Iterable<CheckResultGroup> entities) {
		List<CheckResultGroup> list = new ArrayList<CheckResultGroup>();
		for (CheckResultGroup CheckResultGroup : entities) {
			list.add(save(CheckResultGroup));
		}
		return list;
	}

	public CheckResultGroup save(CheckResultGroup record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CheckResultGroup record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CheckResultGroupBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckResultGroupBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CheckResultGroupExample example = new CheckResultGroupExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CheckResultGroupBO> findAll(Iterable<Long> ids) {
		CheckResultGroupExample example = new CheckResultGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CheckResultGroup entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CheckResultGroup> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CheckResultGroup entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CheckResultGroupExample example = new CheckResultGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CheckResultGroupExample example = new CheckResultGroupExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public List<CheckResultGroupBO> queryCheckResultGroupList() {
		return mapper.queryCheckResultGroupList();
	}
}
