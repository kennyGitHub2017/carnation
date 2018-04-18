package com.sinco.carnation.o2o.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.model.GroupOrderExample;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.dal.common.MyPage;

public interface GroupOrderMapper {
	List<GroupOrder> findGroupOrderCanPayOff();

	List<GroupOrder> findGroupOrderPayByUpline();

	List<GroupOrder> findGroupOrderPayByCashCoupon();

	List<GroupOrder> findGroupOrderPayByCouPon();

	List<GroupOrderBO> statusCount(@Param("userId") Long userId, @Param("statusList") List<Integer> statusList);

	int countByExample(GroupOrderExample example);

	int deleteByExample(GroupOrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupOrder record);

	int insertSelective(GroupOrder record);

	List<GroupOrderBO> search(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page);

	List<GroupOrderBO> offLine(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderListByVO(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page);

	List<GroupOrderBO> selectOrderBySellerId(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page);

	List<GroupOrderBO> selectByExampleWithBLOBs(GroupOrderExample example);

	List<GroupOrderBO> selectByExample(GroupOrderExample example);

	GroupOrderBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupOrder record,
			@Param("example") GroupOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") GroupOrder record,
			@Param("example") GroupOrderExample example);

	int updateByExample(@Param("record") GroupOrder record, @Param("example") GroupOrderExample example);

	int updateByPrimaryKeySelective(GroupOrder record);

	int updateByPrimaryKeyWithBLOBs(GroupOrder record);

	int updateByPrimaryKey(GroupOrder record);

	List<GroupOrderBO> selectListByVo(@Param("page") MyPage<GroupOrderBO> page, @Param("vo") GroupOrderVO vo);

	List<GroupOrderBO> queryMerchantOrderList(@Param("storeId") Long storeId,
			@Param("orderStatus") Integer orderStatus, @Param("orderType") Integer orderType,
			@Param("localStatus") Integer localStatus, @Param("page") MyPage<GroupOrderBO> page);

	BigDecimal queryOrderTotalPrice(@Param("orderType") Integer orderType, @Param("storeId") Long storeId,
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

	List<GroupOrderBO> queryGroupOrderByMonth(@Param("storeId") Long storeId,
			@Param("orderType") Integer orderType);

	List<GroupOrderBO> groupOrderDetails(@Param("storeId") Long storeId,
			@Param("orderType") Integer orderType, @Param("page") MyPage<GroupOrderBO> page);

	GroupOrderBO getGroupOrderBOById(java.lang.Long id);

	java.math.BigDecimal queryOrderPriceByDate(@Param("storeId") Long storeId,
			@Param("startDate") String startDate, @Param("endDate") String endDate);

	int queryOrderCountByDate(@Param("storeId") Long storeId, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

	int selectGroupOrderCountByArea(@Param("areaId") String areaId);

	BigDecimal queryOnLineTotalPrice(@Param("storeId") Long storeId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	BigDecimal queryLineTotalPrice(@Param("storeId") Long storeId, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	BigDecimal queryTotalPrice(@Param("storeId") Long storeId);

	/**
	 * 查询买家所有订单，包括线上线下
	 * 
	 * @param status
	 *            状态|0已取消,10未付款20未使用,30已使用100退款|
	 * @param orderType
	 *            订单类型1线上订单2扫码支付3优惠买单4套餐券5代金券
	 * @param uid
	 *            用户ID
	 * @param page
	 */
	List<GroupOrderBO> queryAllGroupOrderPageList(@Param("status") Integer status,
			@Param("orderType") Integer orderType, @Param("uid") Long uid,
			@Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderPageList(@Param("status") Integer status, @Param("uid") Long uid,
			@Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderLinePageList(@Param("uid") Long uid,
			@Param("orderType") Integer orderType, @Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderId(@Param("orderId") Long orderId);

	List<GroupOrderBO> queryOrderCouponInfo(@Param("orderId") Long orderId);

	List<GroupOrderBO> selectLastMonthOrder();

	List<GroupOrderBO> queryMerchantOrderLineList(@Param("storeId") Long storeId,
			@Param("orderStatus") Integer orderStatus, @Param("orderType") Integer orderType,
			@Param("localStatus") Integer localStatus, @Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryAllMerchantOrderList(@Param("storeId") Long storeId,
			@Param("orderStatus") Integer orderStatus, @Param("orderType") Integer orderType,
			@Param("localStatus") Integer localStatus, @Param("page") MyPage<GroupOrderBO> page);

	GroupOrderBO queryGroupOrderById(@Param("orderId") Long orderId);

	List<GroupOrderBO> queryGroupOrderLineDetails(@Param("storeId") Long storeId,
			@Param("orderType") Integer orderType, @Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderlist(@Param("uid") Long uid, @Param("orderType") Integer orderType,
			@Param("page") MyPage<GroupOrderBO> page);

	List<GroupOrderBO> queryGroupOrderIdByStatus(@Param("orderId") Long orderId);

	/**
	 * 统计商户优惠买单的订单金额
	 * 
	 * @param storeId
	 * @return
	 */
	BigDecimal staticsDiscountPayAmount(@Param("storeId") Long storeId);

	/**
	 * 根据id查询返润金额
	 * 
	 * @param id
	 * @return
	 */
	BigDecimal queryRebateAmountById(@Param("id") Long id);
}