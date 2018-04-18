package com.sinco.carnation.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserCustomerExample;
import com.sinco.carnation.user.vo.UserCustomerVO;
import com.sinco.dal.common.MyPage;

public interface UserCustomerMapper {

	int addIntegral(@Param("uid") Long uid, @Param("integral") int integral);

	int subtractIntegral(@Param("uid") Long uid, @Param("integral") int integral);

	UserCustomerBO findSessionUser(Long id);

	UserCustomerBO findBOByUserId(Long id);

	int countByExample(UserCustomerExample example);

	int deleteByExample(UserCustomerExample example);

	int deleteByPrimaryKey(Long uid);

	int insert(UserCustomer record);

	UserCustomerBO selectByNickname(@Param("nickname") String nickname);

	int insertSelective(UserCustomer record);

//    int updateBalance(@Param("balance") String balance, @Param("userId") String userId);

	List<UserCustomerBO> selectByExampleBO(UserCustomerExample example);

	List<UserCustomer> selectByExample(UserCustomerExample example);

	UserCustomer selectByPrimaryKey(Long uid);

	int updateByExampleSelective(@Param("record") UserCustomer record,
			@Param("example") UserCustomerExample example);

	int updateByExample(@Param("record") UserCustomer record, @Param("example") UserCustomerExample example);

	int updateByPrimaryKeySelective(UserCustomer record);

	int updateByPrimaryKeyForMobile(UserCustomer record);

	int updateByPrimaryKey(UserCustomer record);

	List<UserCustomerBO> queryCustomerPageList(@Param("vo") UserCustomerVO vo,
			@Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryCustomerPageList2(@Param("vo") UserCustomerVO vo,
			@Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserByUid(@Param("uid") Long uid);

	int selectCustomerCountByArea(@Param("areaId") String areaId);

	int selectOperatorCustomerCount(@Param("vo") UserCustomerVO vo);

	int selectOwnCustomerCount(@Param("vo") UserCustomerVO vo);

	List<UserCustomerBO> selectUserCustomerByOperatorUserId(@Param("vo") UserCustomerVO vo,
			@Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> selectOwnCustomerByOperatorUserId(@Param("vo") UserCustomerVO vo,
			@Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserCuxtomerList();

	List<UserCustomerBO> queryUserCuxtomerByLoginName(@Param("loginName") String loginName);

	List<UserCustomerBO> queryStoreCustomer(@Param("sellerUid") Long sellerUid,
			@Param("mobile") String mobile, @Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserCustomerByOperatorUserId(@Param("vo") UserCustomerVO vo,
			@Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserStatistics();

	List<UserCustomerBO> queryRelationList(@Param("uid") Long uid, @Param("page") MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserByRelation1(@Param("relationId") Long relationId,
			MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserByRelation2(@Param("relationId") Long relationId,
			MyPage<UserCustomerBO> page);

	List<UserCustomerBO> queryUserByRelation3(@Param("relationId") Long relationId,
			MyPage<UserCustomerBO> page);

	public int queryUserByRelation1_count(@Param("relationId") Long relationId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public int queryUserByRelation2_count(@Param("relationId") Long relationId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public int queryUserByRelation3_count(@Param("relationId") Long relationId,
			@Param("startTime") String startTime, @Param("endTime") String endTime);

	public List<UserCustomerBO> queryUserByRelationByIn_RefereeUserId(@Param("list") List<Long> list);

	public int updateUserCustomerForIsDelete(@Param("uid") Long uid, @Param("updateBy") Long updateBy,
			@Param("isDeleted") Boolean isDeleted);
	
	public UserCustomerBO findOneByUserId(Long id);
}