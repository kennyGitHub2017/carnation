package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserGroupMapBO;
import com.sinco.carnation.user.model.UserGroupMap;
import com.sinco.carnation.user.model.UserGroupMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupMapMapper {
	int countByExample(UserGroupMapExample example);

	int deleteByExample(UserGroupMapExample example);

	int deleteByPrimaryKey(@Param("userGroupId") Long userGroupId, @Param("userId") Long userId);

	int insert(UserGroupMap record);

	int insertSelective(UserGroupMap record);

	List<UserGroupMapBO> selectByExample(UserGroupMapExample example);

	int updateByExampleSelective(@Param("record") UserGroupMap record,
			@Param("example") UserGroupMapExample example);

	int updateByExample(@Param("record") UserGroupMap record, @Param("example") UserGroupMapExample example);
}