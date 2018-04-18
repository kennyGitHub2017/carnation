package com.sinco.carnation.o2o.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.mapper.GroupOrderMapper;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.model.GroupOrderExample;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Repository
public class GroupOrderDao {
	@Autowired
	private GroupInfoDao groupInfoDao;
	@Autowired
	private GroupOrderMapper mapper;
	@Autowired
	GroupComplaintDao groupComplaintDao;

	/**
	 * 现金券
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderPayByCashCoupon() {
		return mapper.findGroupOrderPayByCashCoupon();
	}

	/**
	 * 代金券
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderPayByCouPon() {
		return mapper.findGroupOrderPayByCouPon();
	}

	/**
	 * 线上服务消费
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderCanPayOff() {
		return mapper.findGroupOrderCanPayOff();
	}

	/**
	 * 线上刷卡消费
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderPayByUpline() {
		return mapper.findGroupOrderPayByUpline();
	}

	/**
	 * 查找各订单状态的数量
	 * 
	 * @param userId
	 * @param statusList
	 * @return
	 */
	public List<GroupOrderBO> statusCount(Long userId, List<Integer> statusList) {
		return mapper.statusCount(userId, statusList);
	}

	public List<GroupOrderBO> selectLastMonthOrder() {
		return mapper.selectLastMonthOrder();
	}

	/** generate code begin **/
	public List<GroupOrderBO> findAll() {
		GroupOrderExample example = new GroupOrderExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupOrderExample example = new GroupOrderExample();
		return mapper.countByExample(example);
	}

	public List<GroupOrderBO> search(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		return mapper.search(vo, page);
	}

	public List<GroupOrderBO> offLine(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		return mapper.offLine(vo, page);
	}

	public List<GroupOrder> save(Iterable<GroupOrder> entities) {
		List<GroupOrder> list = new ArrayList<GroupOrder>();
		for (GroupOrder GroupOrder : entities) {
			list.add(save(GroupOrder));
		}
		return list;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public GroupOrder save(GroupOrder record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(GroupOrder record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupOrderBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupOrderBO get(java.lang.Long id) {
		GroupOrderBO bo = mapper.selectByPrimaryKey(id);
		bo.setGroupInfoBOList(groupInfoDao.findByOrder(bo.getId()));
		bo.setGroupComplaintBO(groupComplaintDao.findByOrder(bo.getId()));

		return bo;
	}

	@SuppressWarnings("rawtypes")
	public GroupOrderBO getGroupOrderBOById(java.lang.Long id) {
		GroupOrderBO gg = mapper.getGroupOrderBOById(id);
		if (null != gg) {
			String groupInfo = gg.getGroupInfo();
			if (StringUtils.isNotEmpty(groupInfo)) {
				Map map = (Map) Json.fromJson(groupInfo);
				if (map.containsKey("goods_name")
						&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_name")))) {
					gg.setLocalGroupName(String.valueOf(map.get("goods_name")));
				}
				if (map.containsKey("goods_total_price")
						&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_total_price")))) {
					gg.setTotalPrice(BigDecimal.valueOf(CommUtil.null2Double(map.get("goods_total_price"))));
				}
			}
		}
		return gg;
	}

	public GroupOrderBO findByTradeNo(String tradeNo) {
		GroupOrderExample ex = new GroupOrderExample();
		ex.createCriteria().andTradeNoEqualTo(tradeNo);
		List<GroupOrderBO> list = mapper.selectByExample(ex);
		return list.isEmpty() ? null : list.get(0);
	}

	public boolean exists(java.lang.Long id) {
		GroupOrderExample example = new GroupOrderExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupOrderBO> findAll(Iterable<Long> ids) {
		GroupOrderExample example = new GroupOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupOrder entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupOrder> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupOrder entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupOrderExample example = new GroupOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupOrderExample example = new GroupOrderExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupOrderBO> findPageByVo(MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		return mapper.selectListByVo(page, vo);
	}

	public List<GroupOrderBO> queryMerchantOrderList(Long storeId, Integer orderStatus, Integer orderType,
			Integer localStatus, MyPage<GroupOrderBO> page) {
		return mapper.queryMerchantOrderList(storeId, orderStatus, orderType, localStatus, page);
	}

	public BigDecimal queryOrderTotalPrice(Integer orderType, Long storeId, Date startTime, Date endTime) {
		return mapper.queryOrderTotalPrice(orderType, storeId, startTime, endTime);
	}

	public List<GroupOrderBO> queryGroupOrderByMonth(Long storeId, Integer orderType) {
		return mapper.queryGroupOrderByMonth(storeId, orderType);
	}

	public List<GroupOrderBO> groupOrderDetails(Long storeId, Integer orderType, MyPage<GroupOrderBO> page) {
		return mapper.groupOrderDetails(storeId, orderType, page);
	}

	@SuppressWarnings("rawtypes")
	public List<GroupOrderBO> queryGroupOrderListByVO(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		List<GroupOrderBO> gos = mapper.queryGroupOrderListByVO(vo, page);
		if (null != gos && gos.size() > 0) {
			for (GroupOrderBO gg : gos) {
				if (null != gg) {
					String groupInfo = gg.getGroupInfo();
					if (StringUtils.isNotEmpty(groupInfo)) {
						Map map = (Map) Json.fromJson(groupInfo);
						if (map.containsKey("goods_name")
								&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_name")))) {
							gg.setLocalGroupName(String.valueOf(map.get("goods_name")));
						}
						if (map.containsKey("goods_total_price")
								&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_total_price")))) {
							gg.setTotalPrice(BigDecimal.valueOf(CommUtil.null2Double(map
									.get("goods_total_price"))));
						}
					}
				}
			}
		}

		return gos;
	}

	@SuppressWarnings("rawtypes")
	public List<GroupOrderBO> selectOrderBySellerId(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		List<GroupOrderBO> gos = mapper.selectOrderBySellerId(vo, page);
		if (null != gos && gos.size() > 0) {
			for (GroupOrderBO gg : gos) {
				if (null != gg) {
					String groupInfo = gg.getGroupInfo();
					if (StringUtils.isNotEmpty(groupInfo)) {
						Map map = (Map) Json.fromJson(groupInfo);
						if (map.containsKey("goods_name")
								&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_name")))) {
							gg.setLocalGroupName(String.valueOf(map.get("goods_name")));
						}
						if (map.containsKey("goods_price")
								&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_price")))) {
							gg.setGoodsPrice(BigDecimal.valueOf(CommUtil.null2Double(map.get("goods_price"))));
						}
						if (map.containsKey("goods_count")
								&& StringUtils.isNotEmpty(String.valueOf(map.get("goods_count")))) {
							gg.setGoodsCount(String.valueOf(map.get("goods_count")));
						}
					}
				}
			}
		}
		page.setContent(gos);
		return gos;
	}

	public BigDecimal queryOrderPriceByDate(Long storeId, String startDate, String endDate) {
		return mapper.queryOrderPriceByDate(storeId, startDate, endDate);
	}

	public int queryOrderCountByDate(Long storeId, String startDate, String endDate) {
		return mapper.queryOrderCountByDate(storeId, startDate, endDate);
	}

	public int selectGroupOrderCountByArea(String areaId) {
		return mapper.selectGroupOrderCountByArea(areaId);
	}

	public BigDecimal queryOnLineTotalPrice(Long storeId, String startTime, String endTime) {
		return mapper.queryOnLineTotalPrice(storeId, startTime, endTime);
	}

	public BigDecimal queryLineTotalPrice(Long storeId, String startTime, String endTime) {
		return mapper.queryLineTotalPrice(storeId, startTime, endTime);
	}

	public BigDecimal queryTotalPrice(Long storeId) {
		return mapper.queryTotalPrice(storeId);
	}

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
	public List<GroupOrderBO> queryAllGroupOrderPageList(Integer status, Integer orderType, Long uid,
			MyPage<GroupOrderBO> page) {
		return mapper.queryAllGroupOrderPageList(status, orderType, uid, page);
	}

	public List<GroupOrderBO> queryGroupOrderPageList(Integer status, Long uid, MyPage<GroupOrderBO> page) {
		return mapper.queryGroupOrderPageList(status, uid, page);
	}

	public List<GroupOrderBO> queryGroupOrderLinePageList(Long uid, Integer orderType,
			MyPage<GroupOrderBO> page) {
		return mapper.queryGroupOrderLinePageList(uid, orderType, page);
	}

	public GroupOrderBO queryGroupOrderId(Long orderId) {
		List<GroupOrderBO> list = mapper.queryGroupOrderId(orderId);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<GroupOrderBO> queryOrderCouponInfo(Long orderId) {
		return mapper.queryOrderCouponInfo(orderId);
	}

	public List<GroupOrderBO> queryMerchantOrderLineList(Long storeId, Integer orderStatus,
			Integer orderType, Integer localStatus, MyPage<GroupOrderBO> page) {
		return mapper.queryMerchantOrderLineList(storeId, orderStatus, orderType, localStatus, page);
	}

	public List<GroupOrderBO> queryAllMerchantOrderList(Long storeId, Integer orderStatus, Integer orderType,
			Integer localStatus, MyPage<GroupOrderBO> page) {
		return mapper.queryAllMerchantOrderList(storeId, orderStatus, orderType, localStatus, page);
	}

	public GroupOrderBO findByOrderNoBig(String orderNo) {
		GroupOrderExample ex = new GroupOrderExample();
		ex.createCriteria().andOrderIdEqualTo(orderNo);
		List<GroupOrderBO> list = mapper.selectByExampleWithBLOBs(ex);
		return list.isEmpty() ? null : list.get(0);
	}

	public GroupOrderBO findByOrderNo(String orderNo) {
		GroupOrderExample ex = new GroupOrderExample();
		ex.createCriteria().andOrderIdEqualTo(orderNo);
		List<GroupOrderBO> list = mapper.selectByExample(ex);
		return list.isEmpty() ? null : list.get(0);
	}

	public GroupOrderBO queryGroupOrderById(Long orderId) {
		return mapper.queryGroupOrderById(orderId);
	}

	public List<GroupOrderBO> queryGroupOrderLineDetails(Long storeId, Integer orderType,
			MyPage<GroupOrderBO> page) {
		return mapper.queryGroupOrderLineDetails(storeId, orderType, page);
	}

	public List<GroupOrderBO> queryGroupOrderlist(Long uid, Integer orderType, MyPage<GroupOrderBO> page) {
		return mapper.queryGroupOrderlist(uid, orderType, page);
	}

	public GroupOrderBO queryGroupOrderIdByStatus(Long orderId) {
		List<GroupOrderBO> list = mapper.queryGroupOrderIdByStatus(orderId);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 统计商户优惠买单的订单金额
	 * 
	 * @param storeId
	 * @return
	 */
	public BigDecimal staticsDiscountPayAmount(Long storeId) {
		return mapper.staticsDiscountPayAmount(storeId);
	}

	/**
	 * 根据id查询返润金额
	 * 
	 * @param id
	 * @return
	 */
	public BigDecimal queryRebateAmountById(Long id) {
		return mapper.queryRebateAmountById(id);
	}

	public List<GroupOrderBO> queryUnpaySuccessOrder() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, -2);
		Date startTime = calendar.getTime();
		
		calendar.setTime(now);
		calendar.add(Calendar.MINUTE, -30);
		Date endTime = calendar.getTime();
		
		GroupOrderExample example = new GroupOrderExample();
		List<Integer> types = new ArrayList<Integer>();
		types.add(2);
		types.add(3);
		example.createCriteria().andOrderTypeIn(types).andOrderStatusEqualTo(GroupOrderConstants.ORDER_STATUS_SUBMIT).andAddTimeBetween(startTime, endTime);
		return mapper.selectByExample(example);
	}
}
