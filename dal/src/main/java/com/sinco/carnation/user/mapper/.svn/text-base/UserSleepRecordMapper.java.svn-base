package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserSleepRecordBO;
import com.sinco.carnation.user.model.UserSleepRecord;
import com.sinco.carnation.user.model.UserSleepRecordExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserSleepRecordMapper {
	int countByExample(UserSleepRecordExample example);

	int deleteByExample(UserSleepRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserSleepRecord record);

	int insertSelective(UserSleepRecord record);

	List<UserSleepRecord> selectByExample(UserSleepRecordExample example);

	UserSleepRecord selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserSleepRecord record,
			@Param("example") UserSleepRecordExample example);

	int updateByExample(@Param("record") UserSleepRecord record,
			@Param("example") UserSleepRecordExample example);

	int updateByPrimaryKeySelective(UserSleepRecord record);

	int updateByPrimaryKey(UserSleepRecord record);

	List<UserSleepRecord> findByUidAndTime(@Param("uid") Long uid, @Param("recordDate") String recordDate);

	List<UserSleepRecordBO> weekSleepRecord(@Param("uid") Long uid);

	List<UserSleepRecordBO> equipSleepQueryByRange(@Param("uid") Long uid,
			@Param("startDateStr") String startDateStr, @Param("endDateStr") String endDateStr);
}