package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.carnation.user.model.UserFootPointExample;
import com.sinco.dal.common.MyPage;

public interface UserFootPointMapper {
	int countByExample(UserFootPointExample example);

	int deleteByExample(UserFootPointExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UserFootPoint record);

	int insertSelective(UserFootPoint record);

	List<UserFootPoint> selectByExampleWithBLOBs(UserFootPointExample example);

	List<UserFootPoint> selectByExample(UserFootPointExample example);

	UserFootPoint selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UserFootPoint record,
			@Param("example") UserFootPointExample example);

	int updateByExampleWithBLOBs(@Param("record") UserFootPoint record,
			@Param("example") UserFootPointExample example);

	int updateByExample(@Param("record") UserFootPoint record, @Param("example") UserFootPointExample example);

	int updateByPrimaryKeySelective(UserFootPoint record);

	int updateByPrimaryKeyWithBLOBs(UserFootPoint record);

	int updateByPrimaryKey(UserFootPoint record);

	List<UserFootPoint> queryByUserId(@Param("userId") Long userId, MyPage<UserFootPoint> page);
}