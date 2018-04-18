package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.model.ShopQrPayOrder;
import com.sinco.carnation.shop.model.ShopQrPayOrderExample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShopQrPayOrderMapper {
	int countByExample(ShopQrPayOrderExample example);

	int deleteByExample(ShopQrPayOrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ShopQrPayOrder record);

	int insertSelective(ShopQrPayOrder record);

	List<ShopQrPayOrderBO> selectByExample(ShopQrPayOrderExample example);

	ShopQrPayOrderBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ShopQrPayOrder record,
			@Param("example") ShopQrPayOrderExample example);

	int updateByExample(@Param("record") ShopQrPayOrder record,
			@Param("example") ShopQrPayOrderExample example);

	int updateByPrimaryKeySelective(ShopQrPayOrder record);

	int updateByPrimaryKey(ShopQrPayOrder record);

	public int updateByPayState(@Param("obj") ShopQrPayOrder record);

	BigDecimal findAllPaySuccessMoney(@Param("sellerId") Long sellerId, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime);
}