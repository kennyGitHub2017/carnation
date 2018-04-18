package com.sinco.carnation.sns.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sns.mapper.CheckQuestionMapper;
import com.sinco.carnation.sns.model.CheckQuestion;
import com.sinco.carnation.sns.vo.CheckQuestionVO;

@Repository
public class CheckQuestionDao {

	@Autowired
	private CheckQuestionMapper mapper;

	public List<CheckQuestionBO> selectListByGroup(Long groupId) {
		return mapper.selectAllByGroup(groupId);
	}

	public int insertSelective(CheckQuestion record) {
		return mapper.insertSelective(record);
	}

	public int updateById(CheckQuestion record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	public CheckQuestionBO selectQuestionByGroupAndIndex(CheckQuestionVO vo) {
		return mapper.selectQuestionByGroupAndIndex(vo);
	}

	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public CheckQuestionBO findById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckQuestionBO queryQuestionSorceRange(Long groupId) {
		return mapper.queryQuestionSorceRange(groupId);
	}
}
