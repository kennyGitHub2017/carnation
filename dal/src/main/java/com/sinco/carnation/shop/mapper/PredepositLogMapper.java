package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.model.PredepositLogExample;
import com.sinco.carnation.shop.vo.PredepositLogVO;
import com.sinco.dal.common.MyPage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositLogMapper {

	List<PredepositLogBO> findPageByUid(@Param("uid") Long uid, MyPage<PredepositLogBO> page,
			@Param("userCode") String userCode);
	List<PredepositLogBO> findByUid(@Param("uid") Long uid);

	int countByExample(PredepositLogExample example);

	int deleteByExample(PredepositLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PredepositLog record);

	int insertSelective(PredepositLog record);

	List<PredepositLogBO> selectByExampleWithBLOBs(PredepositLogExample example);

	List<PredepositLogBO> selectByExample(PredepositLogExample example);

	PredepositLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PredepositLog record,
			@Param("example") PredepositLogExample example);

	int updateByExampleWithBLOBs(@Param("record") PredepositLog record,
			@Param("example") PredepositLogExample example);

	int updateByExample(@Param("record") PredepositLog record, @Param("example") PredepositLogExample example);

	int updateByPrimaryKeySelective(PredepositLog record);

	int updateByPrimaryKeyWithBLOBs(PredepositLog record);

	int updateByPrimaryKey(PredepositLog record);

	List<PredepositLogBO> queryByUserName(@Param("vo") PredepositLogVO vo,
			@Param("page") MyPage<PredepositLogBO> page);

	BigDecimal queryGoodsProfitAmount(@Param("pdType") String pdType, @Param("sellerUid") Long sellerUid,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	List<PredepositLogBO> queryPredeMonth(@Param("sellerUid") Long sellerUid, @Param("opType") String opType,
			@Param("userCode") String userCode);
	
	List<PredepositLogBO> listByUidAndCode(@Param("uid") Long uid,@Param("userCode") String userCode);
}