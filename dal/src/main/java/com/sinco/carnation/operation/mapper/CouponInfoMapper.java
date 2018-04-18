package com.sinco.carnation.operation.mapper;

import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.operation.model.CouponInfoExample;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.dal.common.MyPage;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CouponInfoMapper {
	int countByExample(CouponInfoExample example);

	int deleteByExample(CouponInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CouponInfo record);

	int insertSelective(CouponInfo record);

	List<CouponInfoBO> selectByExample(CouponInfoExample example);

	List<CouponInfoBO> findMyCoupon(@Param("vo") CouponInfoMyVO vo, MyPage<CouponInfoBO> page);

	List<CouponInfoBO> findHasIsOver(@Param("status") Integer status, @Param("endTime") Date endTime);

	CouponInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CouponInfo record,
			@Param("example") CouponInfoExample example);

	int updateByExample(@Param("record") CouponInfo record, @Param("example") CouponInfoExample example);

	int updateByPrimaryKeySelective(CouponInfo record);

	int updateByPrimaryKey(CouponInfo record);

	List<CouponInfoBO> queryCouponInfoPageList(@Param("couponId") Long couponId,
			@Param("page") MyPage<CouponInfoBO> page);
}