package com.sinco.carnation.shop.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.OrderFormExample;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.dal.common.MyPage;

public interface OrderFormMapper {

	double sumOrderPrice(@Param("ids") List<Long> ids);
	double sumOrderCashPrice(@Param("ids") List<Long> ids);
	double sumOrderIntegral(@Param("ids") List<Long> ids);
	double sumOrderShip(@Param("ids") List<Long> ids);
	
	int countByExample(OrderFormExample example);

	int deleteByExample(OrderFormExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OrderForm record);

	int insertSelective(OrderForm record);

	List<OrderFormBO> selectSumPriceByStoreId(@Param("orderStatus") Integer orderStatus,
			@Param("storeId") Long storeId);

	BigDecimal selectSumTotlePriceByStatus(@Param("orderStatus") Integer orderStatus);

	BigDecimal selectSumTotlePriceByVO(@Param("vo") OrderFormVO vo);

	int selectCountByVO(@Param("vo") OrderFormVO vo);

	List<OrderFormBO> selectByExampleWithBLOBs(OrderFormExample example);

	List<OrderFormBO> selectByExample(OrderFormExample example);

	OrderFormBO fetch(Long id);

	OrderForm selectByPrimaryKey(Long id);

	List<OrderFormBO> search(@Param("orderId") String orderId, @Param("userId") Long userId,
			@Param("day") int day, MyPage<OrderFormBO> page);

	List<OrderFormBO> findOrderCanPayOff(@Param("day") int day);

	List<OrderFormBO> selectOrderCanPreRebateArray(@Param("day") int day);

	List<OrderFormBO> findOrderCanPayOffV2(@Param("day") int day);

	List<OrderFormBO> statusCount(@Param("userId") long userId);

	List<OrderFormBO> complain(@Param("orderId") String orderId, @Param("userId") Long userId,
			MyPage<OrderFormBO> page);

	int updateByExampleSelective(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

	int updateByExampleWithBLOBs(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

	int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

	int updateByPrimaryKeySelective(OrderForm record);

	int updateByPrimaryKeyWithBLOBs(OrderForm record);

	int updateByPrimaryKey(OrderForm record);

	List<OrderFormBO> selectListByVo(MyPage<OrderFormBO> page, @Param("vo") OrderFormVO vo);

	List<OrderFormBO> queryListByVo(MyPage<OrderFormBO> page, @Param("vo") OrderFormVO vo);

	List<OrderFormBO> selectAllListByVo(@Param("page") MyPage<OrderFormBO> page, @Param("vo") OrderFormVO vo);

	List<OrderFormBO> queryOrders(MyPage<OrderFormBO> page, OrderFormVO vo);

	OrderFormBO selectListById(@Param("id") Long id);

	int updateStatus(OrderForm order);

	List<OrderForm> selectPayFailureOrder();

	List<OrderFormBO> selectYunGouCNOrderArray(int day);
	List<OrderFormBO> selectYunGouYSOrderArray(int day);
	List<OrderFormBO> findCancelZeroActOrder(@Param("status") int status, @Param("flag") int flag,
			@Param("time") Date time);

	List<OrderForm> selectFailedYgOrder();

	List<OrderFormBO> getOrderByDaysAgo(@Param("time") Date time, @Param("status") int status);

	List<OrderFormBO> getOrdersByAutoReview(@Param("time") Date time, @Param("status") int status);

	List<OrderForm> selectFailedOrderFormByTime(@Param("second") Long second);
	List<OrderForm> selectFailedIntegralOrder();
	
	List<OrderFormBO> listOtherOrder();
	
	List<OrderFormBO> queryAllOrderListByVo(MyPage<OrderFormBO> page, @Param("vo") OrderFormVO vo);
}