package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.RelationMessageBO;
import com.sinco.carnation.sys.model.RelationMessage;
import com.sinco.carnation.sys.model.RelationMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationMessageMapper {
	int countByExample(RelationMessageExample example);

	int deleteByExample(RelationMessageExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RelationMessage record);

	int insertSelective(RelationMessage record);

	List<RelationMessageBO> selectByExample(RelationMessageExample example);

	RelationMessageBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RelationMessage record,
			@Param("example") RelationMessageExample example);

	int updateByExample(@Param("record") RelationMessage record,
			@Param("example") RelationMessageExample example);

	int updateByPrimaryKeySelective(RelationMessage record);

	int updateByPrimaryKey(RelationMessage record);

	RelationMessage findById(@Param("id") Long id);

	List<RelationMessageBO> findAllDelStatusFalse();
}