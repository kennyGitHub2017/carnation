package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.FeedbackBO;
import com.sinco.carnation.user.model.Feedback;
import com.sinco.carnation.user.model.FeedbackExample;
import com.sinco.carnation.user.vo.FeedbackVO;
import com.sinco.dal.common.MyPage;

public interface FeedbackMapper {
	int countByExample(FeedbackExample example);

	int deleteByExample(FeedbackExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Feedback record);

	int insertSelective(Feedback record);

	List<FeedbackBO> selectByExample(FeedbackExample example);

	FeedbackBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Feedback record, @Param("example") FeedbackExample example);

	int updateByExample(@Param("record") Feedback record, @Param("example") FeedbackExample example);

	int updateByPrimaryKeySelective(Feedback record);

	int updateByPrimaryKey(Feedback record);

	List<FeedbackBO> query(@Param("vo") FeedbackVO vo, @Param("page") MyPage<FeedbackBO> page);

}