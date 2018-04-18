package com.sinco.carnation.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.sinco.carnation.user.bo.UserStepRecordBO;
import com.sinco.carnation.user.model.UserStepRecord;
import com.sinco.carnation.user.model.UserStepRecordExample;

public interface UserStepRecordMapper {
	int countByExample(UserStepRecordExample example);

	int deleteByExample(UserStepRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserStepRecord record);

	int insertSelective(UserStepRecord record);

	List<UserStepRecord> selectByExample(UserStepRecordExample example);

	UserStepRecord selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserStepRecord record,
			@Param("example") UserStepRecordExample example);

	int updateByExample(@Param("record") UserStepRecord record,
			@Param("example") UserStepRecordExample example);

	int updateByPrimaryKeySelective(UserStepRecord record);

	int updateByPrimaryKey(UserStepRecord record);

	List<UserStepRecord> findByUidAndTime(@Param("uid") Long uid, @Param("recordDate") String recordDate);

	List<UserStepRecordBO> weekStepRecord(@Param("uid") Long uid);

	List<UserStepRecord> queryStepByRange(@Param("uid") Long uid, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

	List<UserStepRecordBO> equipStepQueryMonByYear(@Param("uid") Long uid,
			@Param("startDate") String startDate, @Param("endDate") String endDate);
}