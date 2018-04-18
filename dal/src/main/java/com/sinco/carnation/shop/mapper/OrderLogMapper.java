package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.OrderLogBO;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.model.OrderLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderLogMapper {
	int countByExample(OrderLogExample example);

	int deleteByExample(OrderLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OrderLog record);

	int insertSelective(OrderLog record);

	List<OrderLog> selectByExampleWithBLOBs(OrderLogExample example);

	List<OrderLog> selectByExample(OrderLogExample example);

	OrderLog selectByPrimaryKey(Long id);

	List<OrderLog> queryByUserId(Long userId);

	List<OrderLogBO> queryByOrderId(Long orderId);

	int updateByExampleSelective(@Param("record") OrderLog record, @Param("example") OrderLogExample example);

	int updateByExampleWithBLOBs(@Param("record") OrderLog record, @Param("example") OrderLogExample example);

	int updateByExample(@Param("record") OrderLog record, @Param("example") OrderLogExample example);

	int updateByPrimaryKeySelective(OrderLog record);

	int updateByPrimaryKeyWithBLOBs(OrderLog record);

	int updateByPrimaryKey(OrderLog record);
}