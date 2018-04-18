package com.sinco.carnation.operation.mapper;

import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.model.CouponExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
	int countByExample(CouponExample example);

	int deleteByExample(CouponExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Coupon record);

	int insertSelective(Coupon record);

	List<CouponBO> selectByExample(CouponExample example);

	CouponBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

	int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

	int updateByPrimaryKeySelective(Coupon record);

	int updateByPrimaryKey(Coupon record);

	List<CouponBO> queryCouponPageList(@Param("storeId") Long storeId,
			@Param("couponName") String couponName, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime, MyPage<CouponBO> page);

	CouponBO queryCouponById(@Param("couponId") Long couponId);

	CouponBO queryNewYearById(@Param("newYearId") Long newYearId);

	CouponBO getByName(@Param("couponName") String couponName);
	
	CouponBO getByCouponInfoId(@Param("infoId") Long infoId);

}