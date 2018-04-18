package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CheckGroupResultBO;
import com.sinco.carnation.sns.model.CheckGroupResult;
import com.sinco.carnation.sns.model.CheckGroupResultExample;

public interface CheckGroupResultMapper {
	int countByExample(CheckGroupResultExample example);

	int deleteByExample(CheckGroupResultExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckGroupResult record);

	int insertSelective(CheckGroupResult record);

	List<CheckGroupResult> selectByExample(CheckGroupResultExample example);

	CheckGroupResult selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckGroupResult record,
			@Param("example") CheckGroupResultExample example);

	int updateByExample(@Param("record") CheckGroupResult record,
			@Param("example") CheckGroupResultExample example);

	int updateByPrimaryKeySelective(CheckGroupResult record);

	int updateByPrimaryKey(CheckGroupResult record);

	List<CheckGroupResultBO> selectAllByGroupId(Long groupId);

	CheckGroupResultBO selectById(Long id);

	Integer selectMaxEndScoreByGroup(Long groupId);

	int findExistsRecordHistory(@Param("userId") Long userId, @Param("groupId") Long groupId);
}