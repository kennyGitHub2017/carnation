package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.PredepositPfLogBO;
import com.sinco.carnation.shop.model.PredepositPfLog;
import com.sinco.carnation.shop.model.PredepositPfLogExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PredepositPfLogMapper {
	int countByExample(PredepositPfLogExample example);

	int deleteByExample(PredepositPfLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PredepositPfLog record);

	int insertSelective(PredepositPfLog record);

	List<PredepositPfLogBO> selectByExample(PredepositPfLogExample example);

	PredepositPfLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PredepositPfLog record,
			@Param("example") PredepositPfLogExample example);

	int updateByExample(@Param("record") PredepositPfLog record,
			@Param("example") PredepositPfLogExample example);

	int updateByPrimaryKeySelective(PredepositPfLog record);

	int updateByPrimaryKey(PredepositPfLog record);

	BigDecimal queryPredepositTotal(@Param("uid") Long uid, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);

	List<PredepositPfLogBO> queryMonthlyPre(@Param("uid") Long uid);
}