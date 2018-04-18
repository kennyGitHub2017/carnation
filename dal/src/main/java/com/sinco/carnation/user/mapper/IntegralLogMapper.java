package com.sinco.carnation.user.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.model.IntegralLog;
import com.sinco.carnation.user.model.IntegralLogExample;
import com.sinco.carnation.user.vo.IntegralLogVO;
import com.sinco.dal.common.MyPage;

public interface IntegralLogMapper {
	int countByExample(IntegralLogExample example);

	int deleteByExample(IntegralLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IntegralLog record);

	int insertSelective(IntegralLog record);

	List<IntegralLogBO> selectByExampleWithBLOBs(IntegralLogExample example);

	List<IntegralLogBO> selectByExample(IntegralLogExample example);
	
	IntegralLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") IntegralLog record,
			@Param("example") IntegralLogExample example);

	int updateByExampleWithBLOBs(@Param("record") IntegralLog record,
			@Param("example") IntegralLogExample example);

	int updateByExample(@Param("record") IntegralLog record, @Param("example") IntegralLogExample example);

	int updateByPrimaryKeySelective(IntegralLog record);
	int updateBlanceByPrimaryKeySelective(IntegralLog record);
	
	int updateByPrimaryKeyWithBLOBs(IntegralLog record);

	int updateByPrimaryKey(IntegralLog record);

	
	
	
	List<IntegralLogBO> queryIntegralPageList(@Param("loginName") String loginName,
			@Param("page") MyPage<IntegralLogBO> page);

	List<IntegralLogBO> selectIntegralPageList(@Param("loginName") String loginName,
			@Param("type") String type,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("page") MyPage<IntegralLogBO> page);

	List<IntegralLogBO> queryIntegralPageListByUid(@Param("uid") Long uid,
			@Param("page") MyPage<IntegralLogBO> page);

	List<IntegralLogBO> queryUserIntegralPageListByUid(@Param("uid") Long uid,
			@Param("markType") String markType, @Param("page") MyPage<IntegralLogBO> page);

	int checkIntegralLog(@Param("vo") IntegralRegVO vo);
	int checkIntegralLogByTime(@Param("vo") IntegralRegVO vo);

	List<IntegralLogBO> querySignIntegralLogYestoday(@Param("integralUserId") Long integralUserId,
			@Param("type") String type, @Param("regType") String regType);

	List<IntegralLogBO> queryByVO(@Param("vo") IntegralLogVO vo, @Param("page") MyPage<IntegralLogBO> page);

	List<IntegralLogBO> findListByUid(@Param("uid") Long uid);
	List<IntegralLogBO> findListByUidTime(@Param("uid") Long uid,@Param("addTime")Date addTime);
	
	List<IntegralLogBO> getByUidTimeType(@Param("uid")Long uid ,@Param("time")Date time ,@Param("type")String type);
	
	IntegralLogBO getLastByUidType(@Param("uid")Long uid ,@Param("type")String type);
	
//	List<IntegralLogBO> listErrorUidByType();
//	Integer sumErrorByUidType(@Param("uid")Long uid ,@Param("type")String type);
//	List<IntegralLogBO> listErrorByUidId(@Param("uid")Long uid ,@Param("id")Long id);
//	List<IntegralLogBO> listErrorByUidType(@Param("uid")Long uid ,@Param("type")String type);
	
}