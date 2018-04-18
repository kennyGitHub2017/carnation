package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupFloorContentBO;
import com.sinco.carnation.o2o.model.GroupFloorContent;
import com.sinco.carnation.o2o.model.GroupFloorContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupFloorContentMapper {
	int countByExample(GroupFloorContentExample example);

	int deleteByExample(GroupFloorContentExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupFloorContent record);

	int insertSelective(GroupFloorContent record);

	List<GroupFloorContentBO> selectByExample(GroupFloorContentExample example);

	GroupFloorContentBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupFloorContent record,
			@Param("example") GroupFloorContentExample example);

	int updateByExample(@Param("record") GroupFloorContent record,
			@Param("example") GroupFloorContentExample example);

	int updateByPrimaryKeySelective(GroupFloorContent record);

	int updateByPrimaryKey(GroupFloorContent record);
}