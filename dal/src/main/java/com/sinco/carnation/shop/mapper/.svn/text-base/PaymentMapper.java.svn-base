package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.PaymentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
	int countByExample(PaymentExample example);

	int deleteByExample(PaymentExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Payment record);

	int insertSelective(Payment record);

	List<PaymentBO> selectByExampleWithBLOBs(PaymentExample example);

	List<Payment> selectByExample(PaymentExample example);

	Payment selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Payment record, @Param("example") PaymentExample example);

	int updateByExampleWithBLOBs(@Param("record") Payment record, @Param("example") PaymentExample example);

	int updateByExample(@Param("record") Payment record, @Param("example") PaymentExample example);

	int updateByPrimaryKeySelective(Payment record);

	int updateByPrimaryKeyWithBLOBs(Payment record);

	int updateByPrimaryKey(Payment record);
}