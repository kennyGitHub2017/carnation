package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.model.PredepositExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositMapper {

	PredepositBO findBOById(Long id);

	List<PredepositBO> findPageByUid(@Param("uid") Long uid, MyPage<PredepositBO> page);

	int countByExample(PredepositExample example);

	int deleteByExample(PredepositExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Predeposit record);

	int insertSelective(Predeposit record);

	List<PredepositBO> selectByExampleWithBLOBs(PredepositExample example);

	List<PredepositBO> selectByExample(PredepositExample example);

	PredepositBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Predeposit record,
			@Param("example") PredepositExample example);

	int updateByExampleWithBLOBs(@Param("record") Predeposit record,
			@Param("example") PredepositExample example);

	int updateByExample(@Param("record") Predeposit record, @Param("example") PredepositExample example);

	int updateByPrimaryKeySelective(Predeposit record);

	int updateByPrimaryKeyWithBLOBs(Predeposit record);

	int updateByPrimaryKey(Predeposit record);

	List<PredepositBO> queryPredepositPageList(@Param("pdPayment") String pdPayment,
			@Param("pdPayStatus") String pdPayStatus, @Param("pdStatus") String pdStatus,
			@Param("pdRemittanceUser") String pdRemittanceUser,
			@Param("pdRemittanceBank") String pdRemittanceBank, @Param("pdUserName") String pdUserName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("pdSn") String pdSn, @Param("page") MyPage<PredepositBO> page);
}