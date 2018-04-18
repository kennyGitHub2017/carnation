package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.UserHealthtaskRelationBO;
import com.sinco.carnation.sns.model.UserHealthtaskRelation;
import com.sinco.carnation.sns.model.UserHealthtaskRelationExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserHealthtaskRelationMapper {

	int countByExample(UserHealthtaskRelationExample example);

	int deleteByExample(UserHealthtaskRelationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserHealthtaskRelation record);

	int insert_UserHealthtaskRelation(UserHealthtaskRelation record);

	List<UserHealthtaskRelationBO> selectByExample(UserHealthtaskRelationExample example);

	UserHealthtaskRelationBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserHealthtaskRelation record,
			@Param("example") UserHealthtaskRelationExample example);

	int updateByExample(@Param("record") UserHealthtaskRelation record,
			@Param("example") UserHealthtaskRelationExample example);

	int updateByPrimaryKeySelective(UserHealthtaskRelation record);

	int updateByPrimaryKey(UserHealthtaskRelation record);

	public List<UserHealthtaskRelationBO> select_UserHealthtaskRelation_By_UserId(
			@Param("userID") Long userID, MyPage<UserHealthtaskRelationBO> page);

	public List<UserHealthtaskRelationBO> select_UserHealthtaskRelation_By_UserId(@Param("userID") Long userID);

	public List<UserHealthtaskRelationBO> select_today_HealthTaskRelation(@Param("userID") Long userID,
			@Param("list") List<Long> idList);

	public UserHealthtaskRelationBO getOne_HealthTaskRelation_By_uid_taskID(@Param("uid") Long userID,
			@Param("taskID") Long taskID);

	/**
	 * 获取系统健康任务
	 * 
	 * @param page
	 * @return
	 */
	public List<UserHealthtaskRelationBO> get_sys_HealthTaskRelation(MyPage<UserHealthtaskRelationBO> page);

	/**
	 * 用户健康任务签到
	 * 
	 * @param id
	 * @param uid
	 * @param taskID
	 * @return
	 */
	public int update_HealthTask_Sing(@Param("id") long id, @Param("uid") long uid,
			@Param("taskID") long taskID, @Param("finishTime") String finishTime);

	public int deleteHealthtaskRelation(@Param("uid") long uid, @Param("taskID") long taskID);
}