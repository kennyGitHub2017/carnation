package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sns.mapper.WenJuanQuestionMapper;
import com.sinco.carnation.sns.model.WenJuanQuestion;
import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.carnation.sns.model.WenJuanQuestionExample;

@Repository
public class WenJuanQuestionDao {

	@Autowired
	private WenJuanQuestionMapper mapper;

	/** generate code begin **/
	public List<WenJuanQuestionBO> findAll() {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanQuestionBO> findAll(Iterable<Long> ids) {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanQuestion> save(Iterable<WenJuanQuestion> entities) {
		List<WenJuanQuestion> list = new ArrayList<WenJuanQuestion>();
		for (WenJuanQuestion WenJuanQuestion : entities) {
			list.add(save(WenJuanQuestion));
		}
		return list;
	}

	public WenJuanQuestion save(WenJuanQuestion record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanQuestion record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanQuestionBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanQuestion entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanQuestion> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanQuestion entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanQuestionExample example = new WenJuanQuestionExample();
		mapper.deleteByExample(example);
	}

	/**
	 * 根据问卷题ID获取对应题目
	 * 
	 * @param groupID
	 * @return
	 */
	public List<WenJuanQuestionBO> get_WJ_Question_By_GroupID(Long groupID) {
		List<WenJuanQuestionBO> list = this.mapper.get_WJ_Question_By_GroupID(groupID);
		return list;
	}

	/**
	 * 根据问卷题ID获取对应题目
	 * 
	 * @param groupID
	 * @return
	 */
	public List<WenJuanQuestionBO> queryQuestionListByID(List<Long> list) {
		List<WenJuanQuestionBO> returnList = this.mapper.query_Question_List_ByID(list);
		return returnList;
	}

	public List<WenJuanQuestionBO> queryQuestionByGroupID(Long groupID) {
		return this.mapper.queryQuestionByGroupID(groupID);
	}
}
