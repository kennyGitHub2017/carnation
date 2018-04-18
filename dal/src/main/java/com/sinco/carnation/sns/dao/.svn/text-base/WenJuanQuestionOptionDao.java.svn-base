package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.carnation.sns.mapper.WenJuanQuestionOptionMapper;
import com.sinco.carnation.sns.model.WenJuanQuestionOption;
import com.sinco.carnation.sns.model.WenJuanQuestionOptionExample;

@Repository
public class WenJuanQuestionOptionDao {

	@Autowired
	private WenJuanQuestionOptionMapper mapper;

	/** generate code begin **/
	public List<WenJuanQuestionOptionBO> findAll() {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanQuestionOptionBO> findAll(Iterable<Long> ids) {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanQuestionOption> save(Iterable<WenJuanQuestionOption> entities) {
		List<WenJuanQuestionOption> list = new ArrayList<WenJuanQuestionOption>();
		for (WenJuanQuestionOption WenJuanQuestionOption : entities) {
			list.add(save(WenJuanQuestionOption));
		}
		return list;
	}

	public WenJuanQuestionOption save(WenJuanQuestionOption record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanQuestionOption record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanQuestionOptionBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanQuestionOption entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanQuestionOption> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanQuestionOption entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanQuestionOptionExample example = new WenJuanQuestionOptionExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<WenJuanQuestionOptionBO> getOpetionByQuestionID(Long questionID) {
		return this.mapper.get_QuestionOption_By_QuestionID(questionID);
	}

	public int addOption(WenJuanQuestionOption record) {
		return mapper.insertSelective(record);
	}

	public int updateById(WenJuanQuestionOption record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int deleteByQuestionID(Long questionID) {
		return this.mapper.deleteByQuestionID(questionID);
	}
}
