package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CheckResultReplyBO;
import com.sinco.carnation.sns.mapper.CheckResultReplyMapper;
import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.sns.model.CheckResultReplyExample;
import com.sinco.carnation.sns.vo.CheckResultReplyVO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckResultReplyDao {
	@Autowired
	private CheckResultReplyMapper mapper;
	@Autowired
	CheckResultDetailsDao checkResultDetailsDao;
	@Autowired
	UserCustomerDao userCustomerDao;

	/** generate code begin **/
	public List<CheckResultReplyBO> findAll() {
		CheckResultReplyExample example = new CheckResultReplyExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CheckResultReplyExample example = new CheckResultReplyExample();
		return mapper.countByExample(example);
	}

	public List<CheckResultReply> save(Iterable<CheckResultReply> entities) {
		List<CheckResultReply> list = new ArrayList<CheckResultReply>();
		for (CheckResultReply CheckResultReply : entities) {
			list.add(save(CheckResultReply));
		}
		return list;
	}

	public List<CheckResultReplyBO> search(CheckResultReplyVO vo, MyPage<CheckResultReplyBO> page) {
		return mapper.search(vo, page);
	}

	public CheckResultReply save(CheckResultReply record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CheckResultReply record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CheckResultReplyBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckResultReplyBO get(java.lang.Long id) {
		CheckResultReplyBO bo = mapper.selectByPrimaryKey(id);
		bo.setCheckResultDetailsBOList(checkResultDetailsDao.queryByReply(id));
		bo.setUserCustomerBO(userCustomerDao.searchCustomerBO(bo.getCreateBy()));

		return bo;
	}

	public boolean exists(java.lang.Long id) {
		CheckResultReplyExample example = new CheckResultReplyExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CheckResultReplyBO> findAll(Iterable<Long> ids) {
		CheckResultReplyExample example = new CheckResultReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CheckResultReply entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CheckResultReply> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CheckResultReply entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CheckResultReplyExample example = new CheckResultReplyExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CheckResultReplyExample example = new CheckResultReplyExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/** 我的体检报告列表 **/
	public List<CheckResultReplyBO> checkReportList(@Param("id") Long id,
			@Param("page") MyPage<CheckResultReplyBO> page) {
		return mapper.checkReportList(id, page);
	}
}
