package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserRebateStatisBO;
import com.sinco.carnation.user.model.UserRebateStatis;
import com.sinco.carnation.user.model.UserRebateStatisExample;
import com.sinco.carnation.user.vo.UserRebateStatisVO;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRebateStatisMapper {
	int countByExample(UserRebateStatisExample example);

	int deleteByExample(UserRebateStatisExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserRebateStatis record);

	int insertSelective(UserRebateStatis record);

	List<UserRebateStatisBO> selectByExample(UserRebateStatisExample example);

	UserRebateStatisBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserRebateStatis record,
			@Param("example") UserRebateStatisExample example);

	int updateByExample(@Param("record") UserRebateStatis record,
			@Param("example") UserRebateStatisExample example);

	int updateByPrimaryKeySelective(UserRebateStatis record);

	int updateByPrimaryKey(UserRebateStatis record);

	UserRebateStatisBO getUserRebateStatisByTimeAndUid(@Param("vo") UserRebateStatisVO vo);

	List<UserRebateStatisBO> findByUidAndTime(@Param("uid") Long uid, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);
}