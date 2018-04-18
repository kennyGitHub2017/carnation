package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.model.CheckClassGroup;
import com.sinco.carnation.sns.model.CheckClassGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckClassGroupMapper {
	int countByExample(CheckClassGroupExample example);

	int deleteByExample(CheckClassGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckClassGroup record);

	int insertSelective(CheckClassGroup record);

	List<CheckClassGroup> selectByExample(CheckClassGroupExample example);

	CheckClassGroup selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckClassGroup record,
			@Param("example") CheckClassGroupExample example);

	int updateByExample(@Param("record") CheckClassGroup record,
			@Param("example") CheckClassGroupExample example);

	int updateByPrimaryKeySelective(CheckClassGroup record);

	int updateByPrimaryKey(CheckClassGroup record);

	int updateClassByGroupId(@Param("newClassId") Long newClassId, @Param("oldClassId") Long oldClassId,
			@Param("groupId") Long groupId);
}