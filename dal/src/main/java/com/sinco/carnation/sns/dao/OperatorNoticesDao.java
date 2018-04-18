package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.OperatorNoticesBO;
import com.sinco.carnation.sns.mapper.OperatorNoticesMapper;
import com.sinco.carnation.sns.model.OperatorNotices;
import com.sinco.carnation.sns.model.OperatorNoticesExample;
import com.sinco.carnation.sns.vo.OperatorNoticesVO;
import com.sinco.dal.common.MyPage;

@Repository
public class OperatorNoticesDao {

	@Autowired
	private OperatorNoticesMapper mapper;

	/** generate code begin **/
	public List<OperatorNoticesBO> findAll() {
		OperatorNoticesExample example = new OperatorNoticesExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		OperatorNoticesExample example = new OperatorNoticesExample();
		return mapper.countByExample(example);
	}

	public List<OperatorNotices> save(Iterable<OperatorNotices> entities) {
		List<OperatorNotices> list = new ArrayList<OperatorNotices>();
		for (OperatorNotices OperatorNotices : entities) {
			list.add(save(OperatorNotices));
		}
		return list;
	}

	public OperatorNotices save(OperatorNotices record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(OperatorNotices record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public OperatorNoticesBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public OperatorNoticesBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public OperatorNoticesBO getBo(java.lang.Long id) {
		return mapper.selectBoByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		OperatorNoticesExample example = new OperatorNoticesExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<OperatorNoticesBO> findAll(Iterable<Long> ids) {
		OperatorNoticesExample example = new OperatorNoticesExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(OperatorNotices entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<OperatorNotices> entities) {
		List<Long> ids = Lists.newArrayList();
		for (OperatorNotices entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		OperatorNoticesExample example = new OperatorNoticesExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		OperatorNoticesExample example = new OperatorNoticesExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<OperatorNoticesBO> findList(OperatorNoticesVO vo, MyPage<OperatorNoticesBO> page) {
		return mapper.selectListByVo(vo, page);
	}

	public List<OperatorNoticesBO> queryNoticesList(Long opertorId, MyPage<OperatorNoticesBO> page) {
		return mapper.queryNoticesList(opertorId, page);
	}
}
