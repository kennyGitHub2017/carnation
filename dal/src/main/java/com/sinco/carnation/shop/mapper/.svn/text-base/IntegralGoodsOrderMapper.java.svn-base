package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.IntegralGoodsOrderExample;
import com.sinco.carnation.shop.vo.IntegralGoodsOrderVO;
import com.sinco.dal.common.MyPage;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IntegralGoodsOrderMapper {
	int countByExample(IntegralGoodsOrderExample example);

	int deleteByExample(IntegralGoodsOrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IntegralGoodsOrder record);

	int insertSelective(IntegralGoodsOrder record);

	List<IntegralGoodsOrderBO> selectByExampleWithBLOBs(IntegralGoodsOrderExample example);

	List<IntegralGoodsOrderBO> selectByExample(IntegralGoodsOrderExample example);

	List<IntegralGoodsOrderBO> selectByUser(@Param("userId") long userId, MyPage<IntegralGoodsOrderBO> page);

	IntegralGoodsOrderBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") IntegralGoodsOrder record,
			@Param("example") IntegralGoodsOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") IntegralGoodsOrder record,
			@Param("example") IntegralGoodsOrderExample example);

	int updateByExample(@Param("record") IntegralGoodsOrder record,
			@Param("example") IntegralGoodsOrderExample example);

	int updateByPrimaryKeySelective(IntegralGoodsOrder record);

	int updateByPrimaryKeyWithBLOBs(IntegralGoodsOrder record);

	int updateByPrimaryKey(IntegralGoodsOrder record);

	List<IntegralGoodsOrderBO> findListByVo(MyPage<IntegralGoodsOrderBO> page,
			@Param("vo") IntegralGoodsOrderVO vo);

	IntegralGoodsOrderBO selectById(@Param("id") Long id);

	List<IntegralGoodsOrderBO> findForExcel(MyPage<IntegralGoodsOrderBO> page,
			@Param("startTime") String startTime, @Param("endTime") String endTime,@Param("status") String status);

	List<IntegralGoodsOrderBO> findNoPayThirdDay();

	BigDecimal countTransFeeByVO (@Param("vo") IntegralGoodsOrderVO vo);
	Long countIntegralByVO (@Param("vo") IntegralGoodsOrderVO vo);
}