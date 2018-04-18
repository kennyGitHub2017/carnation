package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CheckQuestionOptionBO;
import com.sinco.carnation.sns.model.CheckQuestionOption;
import com.sinco.carnation.sns.model.CheckQuestionOptionExample;

public interface CheckQuestionOptionMapper {
	int countByExample(CheckQuestionOptionExample example);

	int deleteByExample(CheckQuestionOptionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckQuestionOption record);

	int insertSelective(CheckQuestionOption record);

	List<CheckQuestionOption> selectByExample(CheckQuestionOptionExample example);

	CheckQuestionOption selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckQuestionOption record,
			@Param("example") CheckQuestionOptionExample example);

	int updateByExample(@Param("record") CheckQuestionOption record,
			@Param("example") CheckQuestionOptionExample example);

	int updateByPrimaryKeySelective(CheckQuestionOption record);

	int updateByPrimaryKey(CheckQuestionOption record);

	List<CheckQuestionOptionBO> selectListByQuestion(Long questionId);
}