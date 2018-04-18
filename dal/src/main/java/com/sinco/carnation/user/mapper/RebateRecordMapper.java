package com.sinco.carnation.user.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.carnation.user.model.RebateRecordExample;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;

public interface RebateRecordMapper {
	public RebateRecord selectOneRecordByCodeAndType(Map<String, String> argumentsMap);
	
	public List<RebateRecord> selectOneRecordeByCode(Map<String, String> argumentsMap);

	boolean updatePreRecordToAlready(Map<String, String> map);

	int countByExample(RebateRecordExample example);

	int deleteByExample(RebateRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RebateRecord record);

	int insertSelective(RebateRecord record);

	List<RebateRecordBO> selectByExample(RebateRecordExample example);

	List<RebateRecordBO> queryByUser(@Param("vo") RebateRecordVO vo,
			@Param("page") MyPage<RebateRecordBO> page);

	RebateRecordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RebateRecord record,
			@Param("example") RebateRecordExample example);

	int updateByExample(@Param("record") RebateRecord record, @Param("example") RebateRecordExample example);

	int updateByPrimaryKeySelective(RebateRecord record);

	int updateByPrimaryKey(RebateRecord record);

	RebateRecordBO queryrebatesum(@Param("storeId") Long storeId, @Param("startTime") String startTime,
			@Param("endTime") String endTime , @Param("userType") String userType);

	List<RebateRecordBO> queryRebateCount(@Param("uid") Long uid , @Param("userType") String userType);

	List<RebateRecordBO> queryShareDetails(@Param("uid") Long uid, @Param("vo") StoreVO vo,
			@Param("page") MyPage<RebateRecordBO> page ,@Param("userType") String userType);

	List<RebateRecordBO> selectOperatorRebateRecordList(@Param("operatorUserId") Long operatorUserId,
			@Param("status") String status, @Param("vo") RebateRecordVO vo,
			@Param("page") MyPage<RebateRecordBO> page);

	BigDecimal selectOperatorRebateRecordTotal(@Param("operatorUserId") Long operatorUserId,
			@Param("status") String status);

	List<RebateRecordBO> queryOperatorProfitList(@Param("uid") Long uid,@Param("group") Boolean group,@Param("shop")Boolean shop,
			@Param("page") MyPage<RebateRecordBO> page);

	List<RebateRecordBO> selectOperatorRebateCode(@Param("vo") RebateRecordVO vo,
			@Param("page") MyPage<RebateRecordBO> page);

	BigDecimal selectSumByTypeAndUserId(@Param("userId") Long userId, @Param("typeList") String[] typeList,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	BigDecimal selectSumRechargeByUserId(@Param("userId") Long userId, @Param("operatorId") Long operatorId,
			@Param("isOwn") Integer isOwn, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	BigDecimal selectSumAreaByVO(@Param("vo") RebateRecordVO vo);

	BigDecimal selectSumOwnByVO(@Param("vo") RebateRecordVO vo);

	BigDecimal selectRebateSumByArea(@Param("areaId") String areaId, @Param("rebateType") String rebateType);

	List<RebateRecordBO> queryShareListByVO(@Param("vo") RebateRecordVO vo,
			@Param("page") MyPage<RebateRecordBO> page);

	List<RebateRecordBO> findAllByUidAndTime(@Param("uid") Long uid, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	BigDecimal selectSumByTypeUid(@Param("userId") Long userId, @Param("typeList") String[] typeList,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime, @Param("queryType") int type);

}