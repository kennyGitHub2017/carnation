package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sns.model.CheckQuestion;
import com.sinco.carnation.sns.model.CheckQuestionExample;
import com.sinco.carnation.sns.vo.CheckQuestionVO;
import com.sinco.dal.common.MyPage;

public interface CheckQuestionMapper {
	int countByExample(CheckQuestionExample example);

	int deleteByExample(CheckQuestionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckQuestion record);

	int insertSelective(CheckQuestion record);

	List<CheckQuestion> selectByExample(CheckQuestionExample example);

	CheckQuestionBO selectByPrimaryKey(Long id);

	CheckQuestionBO selectQuestionByGroupAndIndex(@Param("vo") CheckQuestionVO vo);

	int updateByExampleSelective(@Param("record") CheckQuestion record,
			@Param("example") CheckQuestionExample example);

	int updateByExample(@Param("record") CheckQuestion record, @Param("example") CheckQuestionExample example);

	int updateByPrimaryKeySelective(CheckQuestion record);

	int updateByPrimaryKey(CheckQuestion record);

	List<CheckQuestionBO> selectListByGroup(@Param("groupId") Long groupId, MyPage<CheckQuestionBO> page);

	CheckQuestionBO queryQuestionSorceRange(Long groupId);

	List<CheckQuestionBO> selectAllByGroup(@Param("groupId") Long groupId);
}