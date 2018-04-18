package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.mapper.OrderFormMapper;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.OrderFormExample;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.dal.common.MyPage;

@Repository
public class OrderFormDao {

	@Autowired
	private OrderFormMapper mapper;

	/**
	 * 根据 id 查找订单金额总和
	 * 
	 * @param ids
	 * @return
	 */
	public double sumOrderPrice(List<Long> ids) {
		return mapper.sumOrderPrice(ids);
	}

	/**
	 * 根据 id 查找订单现金部分总和
	 * 
	 * @param ids
	 * @return
	 */
	public double sumOrderCashPrice(List<Long> ids) {
		return mapper.sumOrderCashPrice(ids);
	}
	
	/**
	 * 根据 id 查找订单积分部分总和
	 * 
	 * @param ids
	 * @return
	 */
	public double sumOrderIntegral(List<Long> ids) {
		return mapper.sumOrderIntegral(ids);
	}	
	
	/**
	 * 根据 id 查找订单运费部分总和
	 * 
	 * @param ids
	 * @return
	 */
	public double sumOrderShip(List<Long> ids) {
		return mapper.sumOrderShip(ids);
	}
	
	/**
	 * 根据订单id
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderFormBO findByOrderId(String orderId) {

		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderFormBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}
	public List<OrderFormBO> selectOrderFormByStoreId(String storeId) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andStoreIdEqualTo(storeId);
		example.setOrderByClause(" add_time desc");
		return mapper.selectByExample(example);
	}

	public List<OrderFormBO> selectOrderFormByOrderId(String orderId) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andOrderIdEqualTo(orderId);
		example.setOrderByClause(" add_time desc");
		return mapper.selectByExampleWithBLOBs(example);
	}

	public List<OrderFormBO> selectSumPriceByStoreId(Integer orderStatus, Long storeId) {
		return mapper.selectSumPriceByStoreId(orderStatus, storeId);
	}

	public List<OrderFormBO> statusCount(long userId) {
		return mapper.statusCount(userId);
	}

	public List<OrderFormBO> selectOrderFormByStatusAndShipTime(Date shipTime, Integer orderStatus) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andOrderStatusEqualTo(orderStatus)
				.andShipTimeLessThanOrEqualTo(shipTime);
		return mapper.selectByExample(example);
	}

	public BigDecimal selectSumTotlePriceByStatus(Integer orderStatus) {
		return mapper.selectSumTotlePriceByStatus(orderStatus);
	}

	public BigDecimal selectSumTotlePriceByVO(OrderFormVO vo) {
		return mapper.selectSumTotlePriceByVO(vo);
	}

	public int selectCountByVO(OrderFormVO vo) {
		return mapper.selectCountByVO(vo);
	}

	public int selectSelfOrderShipping(Integer orderForm, Integer orderCat, List<Integer> status) {
		OrderFormExample example = new OrderFormExample();
		OrderFormExample.Criteria criteria = example.createCriteria().andDeleteStatusEqualTo(0)
				.andOrderFormEqualTo(orderForm).andOrderCatNotEqualTo(orderCat);
		if (status != null) {
			if (status.size() == 1) {
				criteria.andOrderStatusEqualTo(status.get(0));
			} else {
				criteria.andOrderStatusIn(status);
			}
		}

		return mapper.countByExample(example);
	}

	public int selectCountByTime(Date time) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andAddTimeGreaterThanOrEqualTo(time);
		return mapper.countByExample(example);
	}

	/**
	 * 根据状态count
	 * 
	 * @param status
	 * @param userId
	 * @param notOrderCat
	 * @return
	 */
	public int countByStatus(Integer status, Long userId, Long storeId, Integer notOrderCat) {
		OrderFormExample example = new OrderFormExample();
		OrderFormExample.Criteria c = example.createCriteria();
		c.andOrderStatusEqualTo(status);
		if (userId != null) {
			c.andUserIdEqualTo(String.valueOf(userId));
		}
		if (storeId != null) {
			c.andStoreIdEqualTo(String.valueOf(storeId));
		}
		if (notOrderCat != null) {
			c.andOrderCatNotEqualTo(notOrderCat);
		}
		return mapper.countByExample(example);
	}

	/** generate code begin **/
	public List<OrderFormBO> findAll() {
		OrderFormExample example = new OrderFormExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		OrderFormExample example = new OrderFormExample();
		return mapper.countByExample(example);
	}

	public List<OrderFormBO> search(String orderId, Long userId, int day, MyPage<OrderFormBO> page) {
		return mapper.search(orderId, userId, day, page);
	}

	public List<OrderFormBO> findOrderCanPayOff(int day) {
		return mapper.findOrderCanPayOff(day);
	}

	/**
	 * 商城已完成订单查询，云购币订单除外
	 * 
	 * @param day
	 * @return
	 */
	public List<OrderFormBO> selectOrderCanPreRebateArray(int day) {
		return mapper.selectOrderCanPreRebateArray(day);
	}

	 
	public List<OrderFormBO> selectYunGouCNOrderArray(int day) {
		return mapper.selectYunGouCNOrderArray(day);
	}
 
	public List<OrderFormBO> selectYunGouYSOrderArray(int day) {
		return mapper.selectYunGouYSOrderArray(day);
	}
	
	public List<OrderFormBO> findOrderCanPayOffV2(int day) {
		return mapper.findOrderCanPayOffV2(day);
	}

	public List<OrderFormBO> complain(String orderId, Long userId, MyPage<OrderFormBO> page) {
		return mapper.complain(orderId, userId, page);
	}

	public List<OrderForm> save(Iterable<OrderForm> entities) {
		List<OrderForm> list = new ArrayList<OrderForm>();
		for (OrderForm OrderForm : entities) {
			list.add(save(OrderForm));
		}
		return list;
	}

	public OrderForm save(OrderForm record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(OrderForm record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public OrderForm findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public OrderForm get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public OrderFormBO fetch(@Param("id") Long id) {
		return mapper.fetch(id);
	}

	public boolean exists(java.lang.Long id) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public List<OrderFormBO> findAll(Iterable<Long> ids) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExampleWithBLOBs(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(OrderForm entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<OrderForm> entities) {
		List<Long> ids = Lists.newArrayList();
		for (OrderForm entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		OrderFormExample example = new OrderFormExample();
		mapper.deleteByExample(example);
	}

	/**
	 * generate code end
	 * 
	 * @param page
	 **/

	public List<OrderFormBO> findListByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		return this.mapper.selectListByVo(page, vo);
	}

	public List<OrderFormBO> findAllListByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		return this.mapper.selectAllListByVo(page, vo);
	}

	public List<OrderFormBO> queryListByVo(MyPage<OrderFormBO> page, OrderFormVO vo) {
		return mapper.queryListByVo(page, vo);
	}

	public List<OrderFormBO> queryOrderFromByUid(String uid) {
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andUserIdEqualTo(uid);
		return mapper.selectByExample(example);
	}

	public OrderFormBO selectListById(Long id) {
		return mapper.selectListById(id);
	}

	public int updateStatus(OrderForm order) {
		return mapper.updateStatus(order);
	}

	public List<OrderForm> selectPayFailureOrder() {
		return mapper.selectPayFailureOrder();
	}

	/**
	 * 查询三分钟后没支付的0元购订单
	 * 
	 * @param status
	 * @param flag
	 * @param time
	 * @return
	 */
	public List<OrderFormBO> findCancelZeroActOrder() {
		int status = 10;
		int flag = 1;
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.MINUTE, -3);
		Date date = nowTime.getTime();
		return mapper.findCancelZeroActOrder(status, flag, date);
	}

	public List<OrderForm> selectFailedYgOrder() {
		return mapper.selectFailedYgOrder();
	}

	public List<OrderFormBO> getOrderByDaysAgo(Date daysAgo, int status) {

		return mapper.getOrderByDaysAgo(daysAgo, status);
	}

	public List<OrderFormBO> getOrdersByAutoReview(Date daysAgo, int status) {

		return mapper.getOrdersByAutoReview(daysAgo, status);
	}
	
	
	
	/** 查询下单时间超过设定值的普通订单 和精选专区订单**/
	public List<OrderForm> selectFailedOrderFormByTime(Long second) {
		if (second == null) {
			return null;
		}
		return mapper.selectFailedOrderFormByTime(second);
	}
	
	public List<OrderForm> selectFailedIntegralOrder(){
		return this.mapper.selectFailedIntegralOrder();
	}
	
	public List<OrderFormBO> listOtherOrder(){
		return this.mapper.listOtherOrder();
	}
	
	public List<OrderFormBO> queryAllOrderListByVo(MyPage<OrderFormBO> page,OrderFormVO vo) {
		return this.mapper.queryAllOrderListByVo(page, vo);
	}
}
