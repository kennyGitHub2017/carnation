package com.sinco.carnation.market.mapper;

import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.model.ActMarketCoupon;
import com.sinco.carnation.market.model.ActMarketCouponExample;
import com.sinco.carnation.market.vo.ActMarketCouponVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActMarketCouponMapper {
	int countByExample(ActMarketCouponExample example);

	int deleteByExample(ActMarketCouponExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActMarketCoupon record);

	int insertSelective(ActMarketCoupon record);

	List<ActMarketCouponBO> selectByExampleWithBLOBs(ActMarketCouponExample example);

	List<ActMarketCouponBO> selectByExample(ActMarketCouponExample example);

	ActMarketCouponBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActMarketCoupon record,
			@Param("example") ActMarketCouponExample example);

	int updateByExampleWithBLOBs(@Param("record") ActMarketCoupon record,
			@Param("example") ActMarketCouponExample example);

	int updateByExample(@Param("record") ActMarketCoupon record,
			@Param("example") ActMarketCouponExample example);

	int updateByPrimaryKeySelective(ActMarketCoupon record);

	int updateByPrimaryKeyWithBLOBs(ActMarketCoupon record);

	int updateByPrimaryKey(ActMarketCoupon record);

	List<ActMarketCouponBO> findAllByPage(@Param("vo") ActMarketCouponVO vo, MyPage<ActMarketCouponBO> page);

	ActMarketCouponBO getActMarketCouponMax();
}