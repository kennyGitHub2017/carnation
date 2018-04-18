package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.CheckResultHistoryBO;
import com.sinco.carnation.user.model.CheckResultHistory;
import com.sinco.carnation.user.model.CheckResultHistoryExample;
import com.sinco.dal.common.MyPage;

public interface CheckResultHistoryMapper {
	int countByExample(CheckResultHistoryExample example);

	int deleteByExample(CheckResultHistoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckResultHistory record);

	int insertSelective(CheckResultHistory record);

	List<CheckResultHistory> selectByExample(CheckResultHistoryExample example);

	List<CheckResultHistoryBO> selectPageByUserId(@Param("userId") Long userId,
			MyPage<CheckResultHistoryBO> page);

	CheckResultHistory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckResultHistory record,
			@Param("example") CheckResultHistoryExample example);

	int updateByExample(@Param("record") CheckResultHistory record,
			@Param("example") CheckResultHistoryExample example);

	int updateByPrimaryKeySelective(CheckResultHistory record);

	int updateByPrimaryKey(CheckResultHistory record);
}