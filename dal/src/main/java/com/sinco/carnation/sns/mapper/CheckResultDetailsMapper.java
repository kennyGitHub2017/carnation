package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.CheckResultDetailsBO;
import com.sinco.carnation.sns.model.CheckResultDetails;
import com.sinco.carnation.sns.model.CheckResultDetailsExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CheckResultDetailsMapper {
	int countByExample(CheckResultDetailsExample example);

	int deleteByExample(CheckResultDetailsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckResultDetails record);

	int insertSelective(CheckResultDetails record);

	List<CheckResultDetailsBO> selectByExample(CheckResultDetailsExample example);

	List<CheckResultDetailsBO> queryByReply(@Param("replyId") Long replyId);

	CheckResultDetailsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckResultDetails record,
			@Param("example") CheckResultDetailsExample example);

	int updateByExample(@Param("record") CheckResultDetails record,
			@Param("example") CheckResultDetailsExample example);

	int updateByPrimaryKeySelective(CheckResultDetails record);

	int updateByPrimaryKey(CheckResultDetails record);

	List<CheckResultDetailsBO> queryResultDetailsList(@Param("replyId") Long replyId,
			@Param("page") MyPage<CheckResultDetailsBO> page);

	int queryResultStatusCount(@Param("id") Long id, @Param("result") Integer result);
}