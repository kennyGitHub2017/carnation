package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.model.UserRelation;
import com.sinco.carnation.user.model.UserRelationExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserRelationMapper {
	int updateUserReferee2Nll(long uid);

	int countByExample(UserRelationExample example);

	int deleteByExample(UserRelationExample example);

	int deleteByPrimaryKey(Long userId);

	int insert(UserRelation record);

	int insertSelective(UserRelation record);

	List<UserRelationBO> selectByExample(UserRelationExample example);

	UserRelationBO selectByPrimaryKey(Long userId);

	int updateByExampleSelective(@Param("record") UserRelation record,
			@Param("example") UserRelationExample example);

	int updateByExample(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

	int updateByPrimaryKeySelective(UserRelation record);

	int updateByPrimaryKey(UserRelation record);

	int queryRefereeUserCount(@Param("refereeUserId") Long refereeUserId,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	int queryOwnCustomerCount(@Param("sellerUserId") Long sellerUserId, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

	int queryRefereeSellerCount(@Param("refereeUserId") Long refereeUserId,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	UserRelationBO queryReferee(@Param("uid") Long uid);

	UserRelationBO queryUserRelation(@Param("uid") Long uid);

	UserRelationBO queryExistUserRelationCode(@Param("uid") Long uid);

	UserRelationBO findFirstNORelationBelongSeller();

	int updateUserRelationToNull();

	List<UserRelationBO> findRelationUser(@Param("refereeUserId") Long refereeUserId);

	public List<Long> queryUserRefereeByInRefereeUserID(@Param("list") List<Long> list);

	public Integer queryRegistCountByCnUserNameFromAccount(@Param("list") List<String> list,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	public Integer queryRegistCountByCnUserNameFromOperator(@Param("list") List<String> list,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	public Integer queryRegistShopRegistCountByCnUserName(@Param("list") List<String> list,
			@Param("type") String type, @Param("startDate") String startDate, @Param("endDate") String endDate);

	public List<Long> getRelationUidByUid(@Param("list") List<Long> list);

	/**
	 * 获取当前用户推荐注册数量
	 * 
	 * @param uid
	 *            用户ID
	 * @param startTime
	 *            开始时间
	 * @return
	 */
	int staticsRefereeRegCount(@Param("uid") long userId, @Param("startTime") Date startTime);
	/** 根据推荐人uid查询该会员推荐人数 **/
	int countRelationByRefereeUid(@Param("refereeUid") long refereeUid);
	/** 根据商户uid查询该商户绑定会员人数 **/
	int countSellerRelationByUid(@Param("sellerUid") long sellerUid);
	/** 更新推荐人 **/
	int updateRefereeUidByOldRefereeUid(@Param("oldRefereeUid") Long oldRefereeUid,
			@Param("newRefereeUid") Long newRefereeUid);
	/** 绑定商户 **/
	int updateSellerByOldRefereeUid(@Param("oldUid") Long oldUid,
			@Param("newUid") Long newUid);
}
