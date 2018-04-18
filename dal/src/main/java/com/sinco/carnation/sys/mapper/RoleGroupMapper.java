package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.RoleGroupBO;
import com.sinco.carnation.sys.model.RoleGroup;
import com.sinco.carnation.sys.model.RoleGroupExample;

public interface RoleGroupMapper {
	int countByExample(RoleGroupExample example);

	int deleteByExample(RoleGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RoleGroup record);

	int insertSelective(RoleGroup record);

	List<RoleGroupBO> selectByExample(RoleGroupExample example);

	RoleGroup selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RoleGroup record, @Param("example") RoleGroupExample example);

	int updateByExample(@Param("record") RoleGroup record, @Param("example") RoleGroupExample example);

	int updateByPrimaryKeySelective(RoleGroup record);

	int updateByPrimaryKey(RoleGroup record);
}