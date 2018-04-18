package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.model.Role;
import com.sinco.carnation.sys.model.RoleExample;

public interface RoleMapper {

	List<RoleBO> findByUid(Long uid);

	List<RoleBO> findByResId(Long resId);

	List<RoleBO> findByResType(String type);

	int countByExample(RoleExample example);

	int deleteByExample(RoleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<RoleBO> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
	// List<RoleBO> findByGroupId(Long groupId);
}