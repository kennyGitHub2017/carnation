package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.UserHealthtaskSetBO;
import com.sinco.carnation.sns.model.UserHealthtaskSet;
import com.sinco.carnation.sns.model.UserHealthtaskSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserHealthtaskSetMapper {
	int countByExample(UserHealthtaskSetExample example);

	int deleteByExample(UserHealthtaskSetExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserHealthtaskSet record);

	int insert_UserHealthtaskSet(UserHealthtaskSet record);

	List<UserHealthtaskSetBO> selectByExample(UserHealthtaskSetExample example);

	UserHealthtaskSetBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserHealthtaskSet record,
			@Param("example") UserHealthtaskSetExample example);

	int updateByExample(@Param("record") UserHealthtaskSet record,
			@Param("example") UserHealthtaskSetExample example);

	int updateByPrimaryKeySelective(UserHealthtaskSet record);

	int updateByPrimaryKey(UserHealthtaskSet record);

	/**
	 * 获取今日任务ID
	 * 
	 * @param obj
	 * @return
	 */
	public List<UserHealthtaskSetBO> select_userHealthTaskSet_today_taskID(@Param("obj") UserHealthtaskSet obj);

	public UserHealthtaskSetBO findOne_UserHealthTaskSet_By_UID_TaskID(@Param("uid") Long uid,
			@Param("taskID") Long taskID);

	public int updateUserHealthTaskSet(@Param("record") UserHealthtaskSet record);

	public int deleteHealthtaskSet(@Param("uid") Long uid, @Param("taskID") Long taskID);
}