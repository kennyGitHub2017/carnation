package com.sinco.carnation.market.mapper;

import com.sinco.carnation.market.bo.ActCouponGetInfoBO;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.model.ActCouponGetInfo;
import com.sinco.carnation.market.model.ActCouponGetInfoExample;
import com.sinco.carnation.market.vo.ActCouponGetInfoVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActCouponGetInfoMapper {
	int countByExample(ActCouponGetInfoExample example);

	int deleteByExample(ActCouponGetInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActCouponGetInfo record);

	int insertSelective(ActCouponGetInfo record);

	List<ActCouponGetInfoBO> selectByExample(ActCouponGetInfoExample example);

	ActCouponGetInfoBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActCouponGetInfo record,
			@Param("example") ActCouponGetInfoExample example);

	int updateByExample(@Param("record") ActCouponGetInfo record,
			@Param("example") ActCouponGetInfoExample example);

	int updateByPrimaryKeySelective(ActCouponGetInfo record);

	int updateByPrimaryKey(ActCouponGetInfo record);

	List<ActMarketCouponBO> findAllByPage(@Param("vo") ActCouponGetInfoVO vo, MyPage<ActCouponGetInfoBO> page);
}