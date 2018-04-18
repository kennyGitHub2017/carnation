package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.CheckQuestionOptionBO;
import com.sinco.carnation.sns.mapper.CheckQuestionOptionMapper;
import com.sinco.carnation.sns.model.CheckQuestionOption;

@Repository
public class CheckQuestionOptionDao {

	@Autowired
	private CheckQuestionOptionMapper mapper;

	public List<CheckQuestionOptionBO> selectListByQuestion(Long questionId) {
		return mapper.selectListByQuestion(questionId);
	}

	public int addOption(CheckQuestionOption record) {
		return mapper.insertSelective(record);
	}

	public int updateById(CheckQuestionOption record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}
}
