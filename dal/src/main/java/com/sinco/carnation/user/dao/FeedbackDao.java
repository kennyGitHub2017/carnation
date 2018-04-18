package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.FeedbackBO;
import com.sinco.carnation.user.mapper.FeedbackMapper;
import com.sinco.carnation.user.model.Feedback;
import com.sinco.carnation.user.model.FeedbackExample;
import com.sinco.carnation.user.vo.FeedbackVO;
import com.sinco.dal.common.MyPage;

@Repository
public class FeedbackDao {

	@Autowired
	private FeedbackMapper mapper;

	/** generate code begin **/
	public List<FeedbackBO> findAll() {
		FeedbackExample example = new FeedbackExample();
		return mapper.selectByExample(example);
	}

	List<FeedbackBO> findAll(Iterable<Long> ids) {
		FeedbackExample example = new FeedbackExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		FeedbackExample example = new FeedbackExample();
		return mapper.countByExample(example);
	}

	public List<Feedback> save(Iterable<Feedback> entities) {
		List<Feedback> list = new ArrayList<Feedback>();
		for (Feedback Feedback : entities) {
			list.add(save(Feedback));
		}
		return list;
	}

	public Feedback save(Feedback record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Feedback record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public FeedbackBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		FeedbackExample example = new FeedbackExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Feedback entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Feedback> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Feedback entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		FeedbackExample example = new FeedbackExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		FeedbackExample example = new FeedbackExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<FeedbackBO> query(FeedbackVO vo, MyPage<FeedbackBO> page) {
		return mapper.query(vo, page);
	}
}
