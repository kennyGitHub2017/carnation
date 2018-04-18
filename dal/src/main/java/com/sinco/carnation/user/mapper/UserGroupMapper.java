package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.UserGroupBO;
import com.sinco.carnation.user.model.UserGroup;
import com.sinco.carnation.user.model.UserGroupExample;
import com.sinco.carnation.user.vo.UserGroupVO;
import com.sinco.dal.common.MyPage;

public interface UserGroupMapper {
	int countByExample(UserGroupExample example);

	int deleteByExample(UserGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserGroup record);

	int insertSelective(UserGroup record);

	List<UserGroupBO> selectByExample(UserGroupExample example);

	UserGroupBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

	int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

	int updateByPrimaryKeySelective(UserGroup record);

	int updateByPrimaryKey(UserGroup record);

	List<UserGroupBO> selectGroupPageByVO(@Param("vo") UserGroupVO vo, MyPage<UserGroupBO> page);
}