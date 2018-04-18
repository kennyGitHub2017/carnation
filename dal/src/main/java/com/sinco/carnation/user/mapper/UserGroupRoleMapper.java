package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserGroupRoleBO;
import com.sinco.carnation.user.model.UserGroupRole;
import com.sinco.carnation.user.model.UserGroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupRoleMapper {
	int countByExample(UserGroupRoleExample example);

	int deleteByExample(UserGroupRoleExample example);

	int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("userGroupId") Long userGroupId);

	int insert(UserGroupRole record);

	int insertSelective(UserGroupRole record);

	List<UserGroupRoleBO> selectByExample(UserGroupRoleExample example);

	int updateByExampleSelective(@Param("record") UserGroupRole record,
			@Param("example") UserGroupRoleExample example);

	int updateByExample(@Param("record") UserGroupRole record, @Param("example") UserGroupRoleExample example);

	int deleteByRoleTypeAndGroupId(@Param("groupId") Long groupId, @Param("roleType") String roleType);
}