package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.UserHealthtaskSignlogBO;
import com.sinco.carnation.sns.model.UserHealthtaskSignlog;
import com.sinco.carnation.sns.model.UserHealthtaskSignlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserHealthtaskSignlogMapper {
	int countByExample(UserHealthtaskSignlogExample example);

	int deleteByExample(UserHealthtaskSignlogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserHealthtaskSignlog record);

	int insertSelective(UserHealthtaskSignlog record);

	List<UserHealthtaskSignlogBO> selectByExample(UserHealthtaskSignlogExample example);

	UserHealthtaskSignlogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserHealthtaskSignlog record,
			@Param("example") UserHealthtaskSignlogExample example);

	int updateByExample(@Param("record") UserHealthtaskSignlog record,
			@Param("example") UserHealthtaskSignlogExample example);

	int updateByPrimaryKeySelective(UserHealthtaskSignlog record);

	int updateByPrimaryKey(UserHealthtaskSignlog record);

	public List<UserHealthtaskSignlogBO> selectByCondition(@Param("obj") UserHealthtaskSignlog record);
}