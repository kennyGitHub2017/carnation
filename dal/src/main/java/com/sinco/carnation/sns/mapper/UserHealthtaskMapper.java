package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.UserHealthtaskBO;
import com.sinco.carnation.sns.model.UserHealthtask;
import com.sinco.carnation.sns.model.UserHealthtaskExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserHealthtaskMapper {
	int countByExample(UserHealthtaskExample example);

	int deleteByExample(UserHealthtaskExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserHealthtask record);

	int insertSelective(UserHealthtask record);

	List<UserHealthtaskBO> selectByExample(UserHealthtaskExample example);

	UserHealthtaskBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserHealthtask record,
			@Param("example") UserHealthtaskExample example);

	int updateByExample(@Param("record") UserHealthtask record,
			@Param("example") UserHealthtaskExample example);

	int updateByPrimaryKeySelective(UserHealthtask record);

	int updateByPrimaryKey(UserHealthtask record);

	/**
	 * 获取会员健康任务
	 * 
	 * @param id_List
	 * @return
	 */
	public List<UserHealthtaskBO> select_UserHealthtask_in_ID(List<java.lang.Long> id_List);

	/**
	 * 获取所有健康任务
	 * 
	 * @return
	 */
	public List<UserHealthtaskBO> select_healthTask_List(MyPage<UserHealthtaskBO> page,
			@Param("list") List<Long> list);

	/**
	 * 根据健康任务名称搜索任务
	 * 
	 * @param taskName
	 * @return
	 */
	public List<UserHealthtaskBO> select_healthTaskByLike_List(@Param("taskName") String taskName,
			@Param("list") List<java.lang.Long> idList);

	/**
	 * 创建健康任务
	 * 
	 * @param obj
	 * @return
	 */
	public int insert_userHealthTask(UserHealthtask obj);

	public int update_JoinNum_ByPrimaryKey(@Param("id") Long id);

	public int update_Del_By_ID(@Param("id") Long id);

	public List<UserHealthtaskBO> select_UserHealthTask_limit(@Param("num") int num);

	/**
	 * 获取系统创建的健康任务
	 * 
	 * @param page
	 * @return
	 */
	public List<UserHealthtaskBO> select_SysHealthTaskList(MyPage<UserHealthtaskBO> page,
			@Param("list") List<Long> list);
}