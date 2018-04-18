package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.model.UserRole;
import com.sinco.carnation.sys.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {

	int deleteByRoleTypeAndUid(@Param("uid") Long uid, @Param("roleType") String roleType);

	int countByExample(UserRoleExample example);

	int deleteByExample(UserRoleExample example);

	int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("userId") Long userId);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

	int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
}