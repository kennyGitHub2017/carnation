package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.RelationBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	UserBO findByLoginName(String loginName);

	UserBO findByInvitationCode(@Param("invitationCode") String invitationCode);

	RelationBO findRelationSidByInvitationCode(@Param("invitationCode") String invitationCode);

	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	UserBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	UserBO fetchRefereeUser(@Param("userId") Long userId);

	List<UserBO> findRefereeUserList(@Param("userId") Long userId, @Param("page") MyPage<UserBO> page);

	public Long countUserRegister(@Param("isDeleted") boolean isDeleted);

	public int updateUserForIsDeleted(@Param("uid") Long uid, @Param("currentUserID") Long currentUserID,
			@Param("isDeleted") boolean isDeleted);

	public List<User> getByTimeAndCoupon(@Param("couponId") Integer couponId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

}