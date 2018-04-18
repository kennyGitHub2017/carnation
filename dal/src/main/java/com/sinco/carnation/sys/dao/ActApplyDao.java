package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.mapper.ActApplyMapper;
import com.sinco.carnation.sys.model.ActApply;
import com.sinco.carnation.sys.bo.ActApplyBO;
import com.sinco.carnation.sys.model.ActApplyExample;
import com.sinco.carnation.sys.vo.ActApplyVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ActApplyDao {

	@Autowired
	private ActApplyMapper mapper;

	/** generate code begin **/
	public List<ActApplyBO> findAll() {
		ActApplyExample example = new ActApplyExample();
		return mapper.selectByExample(example);
	}

	List<ActApplyBO> findAll(Iterable<Long> ids) {
		ActApplyExample example = new ActApplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ActApplyExample example = new ActApplyExample();
		return mapper.countByExample(example);
	}

	public List<ActApply> save(Iterable<ActApply> entities) {
		List<ActApply> list = new ArrayList<ActApply>();
		for (ActApply ActApply : entities) {
			list.add(save(ActApply));
		}
		return list;
	}

	public ActApply save(ActApply record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ActApply record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ActApplyBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ActApplyExample example = new ActApplyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ActApply entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ActApply> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ActApply entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ActApplyExample example = new ActApplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ActApplyExample example = new ActApplyExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ActApplyBO> selectListByVo(ActApplyVO vo, MyPage<ActApplyBO> page) {
		return mapper.selectListByVo(vo, page);
	}
}
