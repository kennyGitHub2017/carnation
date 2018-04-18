package com.sinco.carnation.jiuye.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.jiuye.bo.JiuyeOrderBO;
import com.sinco.carnation.jiuye.bo.JiuyeTotalDataBO;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.vo.JiuyeOrderManageVO;
import com.sinco.dal.common.MyPage;

public interface JiuyeOrderMapper {
	int insertSelective(JiuyeOrder record);

	int updateByOrderId(JiuyeOrder record);

	JiuyeOrder findByOrderId(long orderId);

	JiuyeOrder payStateCheck(long orderId);

	List<JiuyeOrderBO> findOrderList(@Param("vo") JiuyeOrderManageVO vo,
			MyPage<JiuyeOrderBO> page);

	JiuyeTotalDataBO findOrderTotalPayMoney(@Param("vo") JiuyeOrderManageVO vo);

	List<String> querySynOrderId(@Param("start") int start, @Param("end") int end);

	int updateOrderStatusByOrderId(@Param("orderId") String orderId, @Param("orderStatus") int orderStatus);

	Map<String, Object> getRefundOrderByOrderId(@Param("orderId") String orderId);
	
	JiuyeTotalDataBO findOrderTotalRefundsMoney(@Param("vo") JiuyeOrderManageVO vo);
}