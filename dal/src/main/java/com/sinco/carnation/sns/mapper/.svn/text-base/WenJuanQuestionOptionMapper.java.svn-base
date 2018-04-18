package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.carnation.sns.model.WenJuanQuestionOption;
import com.sinco.carnation.sns.model.WenJuanQuestionOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WenJuanQuestionOptionMapper {
	int countByExample(WenJuanQuestionOptionExample example);

	int deleteByExample(WenJuanQuestionOptionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanQuestionOption record);

	int insertSelective(WenJuanQuestionOption record);

	List<WenJuanQuestionOptionBO> selectByExample(WenJuanQuestionOptionExample example);

	WenJuanQuestionOptionBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanQuestionOption record,
			@Param("example") WenJuanQuestionOptionExample example);

	int updateByExample(@Param("record") WenJuanQuestionOption record,
			@Param("example") WenJuanQuestionOptionExample example);

	int updateByPrimaryKeySelective(WenJuanQuestionOption record);

	int updateByPrimaryKey(WenJuanQuestionOption record);

	// 根据获取题目ID获取题目选择
	public List<WenJuanQuestionOptionBO> get_QuestionOption_By_QuestionID(@Param("questionID") Long questionID);

	public int deleteByQuestionID(@Param("questionID") Long questionID);
}