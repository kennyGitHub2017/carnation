package com.sinco.carnation.shop.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.model.PredepositCash;
import com.sinco.carnation.shop.model.PredepositCashExample;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dal.common.MyPage;

public interface PredepositCashMapper {
	int countByExample(PredepositCashExample example);

	int deleteByExample(PredepositCashExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PredepositCash record);

	int insertSelective(PredepositCash record);

	List<PredepositCashBO> selectByExampleWithBLOBs(PredepositCashExample example);

	List<PredepositCashBO> selectByExample(PredepositCashExample example);

	PredepositCashBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PredepositCash record,
			@Param("example") PredepositCashExample example);

	int updateByExampleWithBLOBs(@Param("record") PredepositCash record,
			@Param("example") PredepositCashExample example);

	int updateByExample(@Param("record") PredepositCash record,
			@Param("example") PredepositCashExample example);

	int updateByPrimaryKeySelective(PredepositCash record);

	int updateByPrimaryKeyWithBLOBs(PredepositCash record);

	int updateByPrimaryKey(PredepositCash record);

	public List<PredepositCashBO> queryPredepositCashByUid(@Param("userId") Long userId);

	public PredepositCashBO queryOnlyOneByUid(@Param("userId") Long userId);

	List<PredepositCashBO> queryByUserId(@Param("userId") Long userId, @Param("vo") OperatorVO vo,
			@Param("page") MyPage<PredepositCashBO> page);

	List<PredepositCashBO> queryPredepositCashPageList(@Param("pdPayment") String pdPayment,
			@Param("pdPayStatus") String pdPayStatus, @Param("pdStatus") String pdStatus,
			@Param("pdRemittanceUser") String pdRemittanceUser,
			@Param("pdRemittanceBank") String pdRemittanceBank, @Param("pdUserName") String pdUserName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("userType") String userType, @Param("page") MyPage<PredepositCashBO> page);
	
	List<PredepositCashBO> ListPredepositCashPageByUserCode(@Param("userCode") String userCode,@Param("pdPayment") String pdPayment,
			@Param("pdPayStatus") String pdPayStatus, @Param("pdStatus") String pdStatus,
			@Param("pdRemittanceUser") String pdRemittanceUser,
			@Param("pdRemittanceBank") String pdRemittanceBank, @Param("pdUserName") String pdUserName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("userType") String userType, @Param("page") MyPage<PredepositCashBO> page);

	List<PredepositCashBO> findPredepositPageList(@Param("uid") Long uid,
			@Param("page") MyPage<PredepositCashBO> page);
	/** 根据VO查询提现记录 **/
	public List<PredepositCashBO> listPredepositCashByVO(@Param("vo") PredepositCashVO vo);

	/** 根据VO查询提现总金额 **/
	public BigDecimal countCashAmountByVO(@Param("vo") PredepositCashVO vo);
	/** 根据VO查询提现总金额 **/
	public BigDecimal sumPredepositCashPageList(@Param("pdPayment") String pdPayment,
			@Param("pdPayStatus") String pdPayStatus, @Param("pdStatus") String pdStatus,
			@Param("pdRemittanceUser") String pdRemittanceUser,
			@Param("pdRemittanceBank") String pdRemittanceBank, @Param("pdUserName") String pdUserName,
			@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("userType") String userType);
	

}