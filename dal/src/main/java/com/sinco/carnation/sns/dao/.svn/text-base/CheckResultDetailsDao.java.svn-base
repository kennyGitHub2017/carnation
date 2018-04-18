package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CheckResultDetailsBO;
import com.sinco.carnation.sns.mapper.CheckResultDetailsMapper;
import com.sinco.carnation.sns.model.CheckResultDetails;
import com.sinco.carnation.sns.model.CheckResultDetailsExample;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckResultDetailsDao {

	@Autowired
	private CheckResultDetailsMapper mapper;

	/** generate code begin **/
	public List<CheckResultDetailsBO> findAll() {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		return mapper.countByExample(example);
	}

	public List<CheckResultDetails> save(Iterable<CheckResultDetails> entities) {
		List<CheckResultDetails> list = new ArrayList<CheckResultDetails>();
		for (CheckResultDetails CheckResultDetails : entities) {
			list.add(save(CheckResultDetails));
		}
		return list;
	}

	public List<CheckResultDetailsBO> findByReply(Long replyId) {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		example.createCriteria().andReplyIdEqualTo(replyId);

		return mapper.selectByExample(example);
	}

	public List<CheckResultDetailsBO> queryByReply(Long replyId) {
		return mapper.queryByReply(replyId);
	}

	public CheckResultDetails save(CheckResultDetails record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CheckResultDetails record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CheckResultDetailsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckResultDetailsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CheckResultDetailsBO> findAll(Iterable<Long> ids) {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CheckResultDetails entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CheckResultDetails> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CheckResultDetails entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CheckResultDetailsExample example = new CheckResultDetailsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<CheckResultDetailsBO> queryResultDetailsList(Long replyId, MyPage<CheckResultDetailsBO> page) {
		return mapper.queryResultDetailsList(replyId, page);
	}

	public int queryResultStatusCount(Long id, Integer result) {
		return mapper.queryResultStatusCount(id, result);
	}
}
