package com.sinco.carnation.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.o2o.bo.GroupOrderLogBO;
import com.sinco.carnation.o2o.model.GroupOrderLog;
import com.sinco.carnation.o2o.model.GroupOrderLogExample;
import com.sinco.carnation.o2o.vo.GroupOrderLogVO;

public interface GroupOrderLogMapper {
	int countByExample(GroupOrderLogExample example);

	int deleteByExample(GroupOrderLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupOrderLog record);

	int insertSelective(GroupOrderLog record);

	List<GroupOrderLogBO> selectByExampleWithBLOBs(GroupOrderLogExample example);

	List<GroupOrderLogBO> selectByVO(@Param("vo") GroupOrderLogVO vo);

	List<GroupOrderLogBO> selectByExample(GroupOrderLogExample example);

	GroupOrderLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupOrderLog record,
			@Param("example") GroupOrderLogExample example);

	int updateByExampleWithBLOBs(@Param("record") GroupOrderLog record,
			@Param("example") GroupOrderLogExample example);

	int updateByExample(@Param("record") GroupOrderLog record, @Param("example") GroupOrderLogExample example);

	int updateByPrimaryKeySelective(GroupOrderLog record);

	int updateByPrimaryKeyWithBLOBs(GroupOrderLog record);

	int updateByPrimaryKey(GroupOrderLog record);
}