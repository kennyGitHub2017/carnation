package com.yun.shang.carnation.rebate.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import com.sinco.carnation.elong.model.ElongOrder;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.hotel.HotelDetailViewModel;
import com.sinco.carnation.elong.service.ElongOrderService;
import com.sinco.carnation.elong.service.remote.IHotelService;
import com.sinco.carnation.elong.service.remote.impl.HotelService;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.service.GoodsReturnService;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.AreaMPBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AreaMPServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.service.OperatorRemoteService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.carnation.user.service.UserRelationService;
import com.yun.shang.carnation.job.base.JobBasic;
import com.yun.shang.carnation.rebate.constant.JobConstant;
import com.yun.shang.carnation.rebate.porprotion.PlatformProportion;

public class RebateTools {
	private static final Logger logger = LoggerFactory.getLogger(RebateTools.class);
	// 用户推荐关系服务
	private static UserRelationService userRelationService;
	// 用户推荐关系服务
	private static SellerService sellerService;
	// 商家运营商隶属关系
	private static UserOwnService userOwnService;
	// 运营商
	private static OperatorService operatorService;
	// 店铺
	private static StoreService storeService;

	private static AreaServiceImpl areaServiceImpl;
	// 订单服务
	private static OrderFormService orderFormService;
	// 订单服务
	private static GoodsReturnService goodsReturnService;
	// o2o订单服务
	private static GroupOrderService groupOrderService;

	private static GroupInfoService groupInfoService;

	private static PlatformProportion platformProportion;

	private static UserAccountService accountService;

	private static OperatorRemoteService operatorRemoteService;

	private static ElongOrderService elongOrderService;
	/**
	 * 酒店信息获取
	 */
	private static IHotelService hotelService;
	// 地区映射表
	private static AreaMPServiceImpl areaMPService;
	// 卷皮订单服务
	private static JuanpiOrderService juanpiOrderService;
	// 卷皮商品
	private static JuanpiGoodsService juanpiGoodsService;

	static {
		if (userRelationService == null || sellerService == null || userOwnService == null
				|| null == areaServiceImpl || null == operatorService || null == orderFormService
				|| null == groupOrderService || null == groupInfoService || null == platformProportion
				|| null == accountService || null == operatorRemoteService) {
			ApplicationContext wac = JobBasic.ctx;
			userRelationService = wac.getBean(UserRelationService.class);
			sellerService = wac.getBean(SellerService.class);
			userOwnService = wac.getBean(UserOwnService.class);
			storeService = wac.getBean(StoreService.class);
			operatorService = wac.getBean(OperatorService.class);
			areaServiceImpl = wac.getBean(AreaServiceImpl.class);
			orderFormService = wac.getBean(OrderFormService.class);
			goodsReturnService = wac.getBean(GoodsReturnService.class);
			groupOrderService = wac.getBean(GroupOrderService.class);
			groupInfoService = wac.getBean(GroupInfoService.class);
			platformProportion = wac.getBean(PlatformProportion.class);
			accountService = wac.getBean(UserAccountService.class);
			operatorRemoteService = wac.getBean(OperatorRemoteService.class);
			elongOrderService = wac.getBean(ElongOrderService.class);
			hotelService = wac.getBean(HotelService.class);
			areaMPService = wac.getBean(AreaMPServiceImpl.class);
			juanpiOrderService = wac.getBean(JuanpiOrderService.class);
			juanpiGoodsService = wac.getBean(JuanpiGoodsService.class);
		}
	}

	public static GroupOrderBO getO2OOrderInfo(long orderId) {
		// 1.获取当前订单
		GroupOrderBO groupOrderBO = groupOrderService.getGroupOrderBOById(orderId);
		if (groupOrderBO == null) {
			logger.warn("[self group rebate]  get order is empty.orderId=" + orderId);
			return null;
		}
		return groupOrderBO;
	}

	public static BigDecimal getUpLineOrderBvamout(long orderId) {
		GroupOrderBO groupOrderBO = getO2OOrderInfo(orderId);
		if (groupOrderBO == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal orderAmount = groupOrderBO.getOriginalPrice();
		List<GroupInfoBO> groupInfoBOes = groupInfoService.queryGroupInfoList(orderId);
		if (null == groupInfoBOes) {
			return BigDecimal.ZERO;
		}
		for (GroupInfoBO groupInfoBO : groupInfoBOes) {
			if (1 != groupInfoBO.getStatus()) {
				break;
			}
			BigDecimal bvamount = orderAmount.multiply(groupInfoBO.getProportion()).setScale(2,
					RoundingMode.DOWN);
			BigDecimal platformamount = bvamount.multiply(platformProportion.getCounterFee()).setScale(2,
					RoundingMode.DOWN);
			return bvamount.subtract(platformamount);
		}
		return BigDecimal.ZERO;
	}

	/**
	 * 代金券
	 * 
	 * @param orderId
	 * @return
	 */
	public static BigDecimal getCashCoupon(long orderId) {
		BigDecimal orderAmount = groupOrderService.queryRebateAmountById(orderId);
		if (null == orderAmount) {
			return BigDecimal.ZERO;
		}
		BigDecimal platformamount = orderAmount.multiply(platformProportion.getCounterFee()).setScale(2,
				RoundingMode.DOWN);
		return orderAmount.subtract(platformamount);
	}

	/**
	 * 套餐券
	 * 
	 * @param orderId
	 * @return
	 */
	public static BigDecimal getCoupon(long orderId) {
		BigDecimal orderAmount = groupOrderService.queryRebateAmountById(orderId);
		if (null == orderAmount) {
			return BigDecimal.ZERO;
		}
		BigDecimal platformamount = orderAmount.multiply(platformProportion.getCounterFee()).setScale(2,
				RoundingMode.DOWN);
		return orderAmount.subtract(platformamount);
	}

	public static BigDecimal getO2OrderBvamout(long orderId) {
		GroupOrderBO groupOrderBO = getO2OOrderInfo(orderId);
		if (groupOrderBO == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal orderAmount = groupOrderBO.getTotalPrice();
		List<GroupInfoBO> groupInfoBOes = groupInfoService.queryGroupInfoList(orderId);
		if (null == groupInfoBOes) {
			return BigDecimal.ZERO;
		}
		for (GroupInfoBO groupInfoBO : groupInfoBOes) {
			if (1 != groupInfoBO.getStatus()) {
				break;
			}
			BigDecimal bvamount = orderAmount.multiply(groupInfoBO.getProportion()).setScale(2,
					RoundingMode.DOWN);
			BigDecimal platformamount = bvamount.multiply(platformProportion.getCounterFee()).setScale(2,
					RoundingMode.DOWN);
			return bvamount.subtract(platformamount);
		}
		return BigDecimal.ZERO;
	}

	public static ElongOrder getElongOrderInfo(long orderId) {
		// 1.获取当前订单
		ElongOrder elongOrder = elongOrderService.getByOrderId(orderId);
		if (elongOrder == null) {
			logger.warn("[elong order rebate]  get order is empty.orderId=" + orderId);
			return null;
		}
		return elongOrder;
	}

	public static JuanpiOrder getJuanpiOrderInfo(long orderId) {
		// 1.获取当前订单
		JuanpiOrder juanpiOrder = juanpiOrderService.findById(orderId);
		if (juanpiOrder == null) {
			logger.warn("[juanpi good rebate]  get order is empty.orderId=" + orderId);
			return null;
		}
		return juanpiOrder;
	}

	public static BigDecimal getJuanpiOrderBvamout(Long orderId, int status) {
		List<JuanpiOrderGoodsBO> juanpiOrderGoodsBOArray = juanpiGoodsService
				.findGoodsByOrderId(orderId.intValue());
		BigDecimal commission = new BigDecimal(0);
		for (JuanpiOrderGoodsBO juanpiOrderGoodsBO : juanpiOrderGoodsBOArray) {
			if (status == juanpiOrderGoodsBO.getStatus()) {
				commission = commission.add(juanpiOrderGoodsBO.getYunCommission());
			}
		}
		return commission;
	}

	public static OrderForm getShopOrderInfo(long orderId) {
		// 1.获取当前订单
		OrderForm currentOrderForm = orderFormService.getObjById(orderId);
		if (currentOrderForm == null) {
			logger.warn("[self good rebate]  get order is empty.orderId=" + orderId);
			return null;
		}
		return currentOrderForm;
	}

	public static BigDecimal getElongOrderBVamout(long orderId) {
		ElongOrder elongOrder = getElongOrderInfo(orderId);
		if (null == elongOrder) {
			return BigDecimal.ZERO;
		}
		// 订单BV（利润值）
		BigDecimal orderAddAmount = elongOrder.getTotalPrice();
		return orderAddAmount.multiply(platformProportion.getElongOrderFee());
	}

	public static BigDecimal getShopOrderBvamout(long orderId) {
		// 1.获取当前订单
		OrderForm currentOrderForm = getShopOrderInfo(orderId);
		if (currentOrderForm == null) {
			return BigDecimal.ZERO;
		}
		// 订单BV（利润值）
		BigDecimal orderAddAmount = currentOrderForm.getCommissionAmount();
		if (orderAddAmount == null) {
			orderAddAmount = BigDecimal.ZERO;
		}
		// 查询订单退货信息是否被拒绝
		List<String> list = new ArrayList<>();
		list.add(OrderFormConstants.ORDER_RETURN_STATUS_REFUSE);
		List<ReturnGoodsLogBO> returnList = goodsReturnService.findorderlogByOrderId(orderId);

		if (!CollectionUtils.isEmpty(returnList)) {
			for (ReturnGoodsLogBO returnGoodsLogBO : returnList) {
				if (OrderFormConstants.ORDER_RETURN_STATUS_SUCCESS
						.equals(returnGoodsLogBO.getGoodsReturnStatus())) {
					orderAddAmount = orderAddAmount.subtract(returnGoodsLogBO.getGoodsCommissionRate());
				}
			}
		}
		if (orderAddAmount.doubleValue() < 0) {
			orderAddAmount = BigDecimal.ZERO;
		}
		// 自营商品订单
		if (0 == currentOrderForm.getOrderForm()) {
			orderAddAmount = orderAddAmount.subtract(orderAddAmount
					.multiply(platformProportion.getSupplierRisk()).setScale(2, RoundingMode.DOWN));
		}
		BigDecimal platformamount = orderAddAmount.multiply(platformProportion.getCounterFee()).setScale(2,
				RoundingMode.DOWN);
		return orderAddAmount.subtract(platformamount);
	}

	/**
	 * 获取市级运营商
	 * 
	 * @param level
	 * @param areaCode
	 * @return
	 */
	public static Map<Integer, Long> getCityOperatorLevelByArea(int level, Long areaCode) {
		if (null == areaCode) {
			return null;
		}
		// 市级运营商
		Area area = areaServiceImpl.getParentObjById(areaCode);
		if (null == area) {
			logger.warn(
					"[rebate] binding city operator rebate,current district area hav'ot city area, areacode="
							+ areaCode);
			return null;
		}
		// 获取商家的市级运营商
		OperatorBO operatorBO = operatorService.getCityOperatorByCode(String.valueOf(area.getId()));
		if (null == operatorBO) {
			logger.warn(
					"[rebate] binding city operator rebate,current seller hav'ot operator in area, areacode="
							+ areaCode);
			return null;
		}
		Map<Integer, Long> resultMp = new HashMap<Integer, Long>();
		resultMp.put(1, operatorBO.getUserId());
		return resultMp;
		// return getUserRecommendByLevel(level, operatorBO.getUserId());
	}

	/**
	 * 获取市级运营商
	 * 
	 * @param level
	 * @param areaCode
	 * @return
	 */
	public static Map<Integer, Long> getElongCityOperatorLevelByArea(int level, long orderId) {
		ElongOrder elongOrder = elongOrderService.getByOrderId(orderId);
		ResultInfo<HotelDetailViewModel> resultInfo = hotelService.getHotelDetail(elongOrder.getHotelId(),
				elongOrder.getArrivalDate(), elongOrder.getDepartureDate());
		HotelDetailViewModel hotelDetailViewModel = resultInfo.getData();
		if (null == hotelDetailViewModel) {
			logger.warn("[get elong hotel] hotel is empty,hotel_id=" + elongOrder.getHotelId()
					+ ",arrival_date=" + elongOrder.getArrivalDate() + ",departure_date="
					+ elongOrder.getDepartureDate());
			return null;
		}
		// 城市ID
		String elongCityCode = hotelDetailViewModel.getCity();
		// 区域ID
		String elongDistrictCode = hotelDetailViewModel.getDistrict();
		// 查询城市ID对应关系表
		AreaMPBO areaMPBO = areaMPService.getYSAreaCode(elongCityCode, elongDistrictCode);
		if (null == areaMPBO) {
			logger.warn("[get elong city code mp] empty, elong order ID=" + orderId + ",hotel_id="
					+ elongOrder.getHotelId() + ",elong_city_code=" + elongCityCode + ",elong_district_code="
					+ elongDistrictCode);
			return null;
		}
		long ysDistrictCode = areaMPBO.getYsAreaCode();
		// 市级运营商
		Area area = areaServiceImpl.getParentObjById(ysDistrictCode);
		if (null == area) {
			logger.warn("[get YS city code] current district area hav'ot city area code,order ID=" + orderId
					+ ", district_code=" + ysDistrictCode);
			return null;
		}
		// 获取商家的市级运营商
		OperatorBO operatorBO = operatorService.getCityOperatorByCode(String.valueOf(area.getId()));
		if (null == operatorBO) {
			logger.warn("this YS city_code not haves city operator in db,order ID=" + orderId
					+ ",district_code=" + ysDistrictCode + ",city_code=" + area.getId());
			return null;
		}
		Map<Integer, Long> recommendMP = getUserRecommendByLevel(level, operatorBO.getUserId());
		if (null == recommendMP || recommendMP.size() <= 0) {
			logger.warn("[rebate] city operator rebate,current area hav'ot operator recommend, order ID="
					+ orderId + ",areacode=" + ysDistrictCode);
		}
		return recommendMP;
	}

	/**
	 * 获取，区域运营商的关系
	 * 
	 * @param level
	 * @param sellerUserId
	 */
	public static Map<Integer, Long> getDistrictOperatorLevelBySeller(int level, long sellerUserId) {
		StoreBO storeBO = getStoreInfo(sellerUserId);
		if (null == storeBO || null == storeBO.getAreaId()) {
			return null;
		}
		// 商家的区域代号
		long areaCode = storeBO.getAreaId();
		// 获取商家的区级运营商的编号
		OperatorBO operatorBO = operatorService.getDistrictOperatorByCode(String.valueOf(areaCode));
		if (null == operatorBO) {
			logger.warn(
					"[rebate] binding district operator rebate,current seller hav'ot operator in area, sellerid="
							+ sellerUserId + ",areacode=" + areaCode);
			return null;
		}
		Map<Integer, Long> resultMp = new HashMap<Integer, Long>();
		resultMp.put(1, operatorBO.getUserId());
		return resultMp;
		// return getUserRecommendByLevel(level, operatorBO.getUserId());
	}

	public static Map<Integer, Long> getElongDistrictOperatorLevelBySeller(int level, long orderId) {
		ElongOrder elongOrder = elongOrderService.getByOrderId(orderId);
		ResultInfo<HotelDetailViewModel> resultInfo = hotelService.getHotelDetail(elongOrder.getHotelId(),
				elongOrder.getArrivalDate(), elongOrder.getDepartureDate());
		HotelDetailViewModel hotelDetailViewModel = resultInfo.getData();
		if (null == hotelDetailViewModel) {
			logger.warn("[get elong hotel] hotel is empty,order ID=" + orderId + ",hotel_id="
					+ elongOrder.getHotelId() + ",arrival_date=" + elongOrder.getArrivalDate()
					+ ",departure_date=" + elongOrder.getDepartureDate());
			return null;
		}
		// 城市ID
		String elongCityCode = hotelDetailViewModel.getCity();
		// 区域ID
		String elongDistrictCode = hotelDetailViewModel.getDistrict();
		// 查询城市ID对应关系表
		AreaMPBO areaMPBO = areaMPService.getYSAreaCode(elongCityCode, elongDistrictCode);
		if (null == areaMPBO) {
			logger.warn("[get elong city code mp] empty, elong order ID=" + orderId + ",hotel_id="
					+ elongOrder.getHotelId() + ",elong_city_code=" + elongCityCode + ",elong_district_code="
					+ elongDistrictCode);
			return null;
		}
		// 查询对应关系表
		long ysAreaCode = areaMPBO.getYsAreaCode();
		// 获取商家的区级运营商的编号
		OperatorBO operatorBO = operatorService.getDistrictOperatorByCode(String.valueOf(ysAreaCode));
		if (null == operatorBO) {
			logger.warn(
					"[rebate] binding district operator rebate,current seller hav'ot operator in area, order ID="
							+ orderId + ",areacode=" + ysAreaCode);
			return null;
		}
		Map<Integer, Long> recommendMP = getUserRecommendByLevel(level, operatorBO.getUserId());
		if (null == recommendMP || recommendMP.size() <= 0) {
			logger.warn("[rebate] district operator rebate,current area hav'ot operator recommend, order ID="
					+ orderId + ",areacode=" + ysAreaCode);
		}
		return recommendMP;
	}

	/**
	 * 获取商家/供应商隶属的运营商信息
	 */

	public static Map<Integer, Long> getSellerBindingOperatorLevel(int level, long sellerUserId) {
		Integer ownType = 1;// 代表商户
		UserOwnsBO userOwnsBO = userOwnService.findOne(sellerUserId, ownType);
		if (null == userOwnsBO || null == userOwnsBO.getOwnOperatorId()) {
			logger.warn("[rebate] current seller hav'not binding operator. sellerUid=" + sellerUserId);
			return null;
		}
		OperatorBO operatorBO = operatorService.get(userOwnsBO.getOwnOperatorId());
		if (null == operatorBO) {
			logger.warn("[rebate] current seller hav'not binding operator. sellerUid=" + sellerUserId);
			return null;
		}
		if (StringUtils.isNotBlank(operatorBO.getOperatorCode())
				&& operatorBO.getOperatorCode().startsWith(JobConstant.OTHER_REBATE_ACCOUNT_START)) {
			return operatorRemoteService.getRemoteOperatorLevelByCode(operatorBO.getOperatorCode());
		}
		long userId = operatorBO.getUserId();
		return getUserRecommendByLevel(level, userId);
	}

	/**
	 * 获取商家/供应商隶属的运营商信息
	 */

	public static Map<Integer, Long> getSupplierBindingOperatorLevel(int level, long sellerUserId) {
		Integer ownType = 2;// 代表商户
		UserOwnsBO userOwnsBO = userOwnService.findOne(sellerUserId, ownType);
		if (null == userOwnsBO || null == userOwnsBO.getOwnOperatorId()) {
			logger.warn("[rebate] current seller hav'not binding operator. sellerUid=" + sellerUserId);
			return null;
		}
		OperatorBO operatorBO = operatorService.get(userOwnsBO.getOwnOperatorId());
		if (null == operatorBO) {
			logger.warn("[rebate] current seller hav'not binding operator. sellerUid=" + sellerUserId);
			return null;
		}
		if (StringUtils.isNotBlank(operatorBO.getOperatorCode())
				&& operatorBO.getOperatorCode().startsWith(JobConstant.OTHER_REBATE_ACCOUNT_START)) {
			return operatorRemoteService.getRemoteOperatorLevelByCode(operatorBO.getOperatorCode());
		}
		long userId = operatorBO.getUserId();
		return getUserRecommendByLevel(level, userId);
	}

	/**
	 * 获取会员消费的商户信息
	 * 
	 * @param userid
	 * @return
	 */
	public static SellerBO getSellerInfo(long sellerUserid) {
		SellerBO sellerBO = sellerService.findSessionById(sellerUserid, true, null);
		if (null == sellerBO) {
			logger.warn(
					"[rebate]current user is not seller,seller message is empty,sellerid=" + sellerUserid);
			return null;
		}
		return sellerBO;
	}

	public static StoreBO getStoreInfo(long sellerUserid) {
		SellerBO sellerBO = getSellerInfo(sellerUserid);
		if (null == sellerBO || null == sellerBO.getStoreId()) {
			logger.warn("[rebate]current seller is not store,sellerid=" + sellerUserid);
			return null;
		}
		long storeId = sellerBO.getStoreId();
		StoreBO storeBO = storeService.getObjById(storeId);
		if (null == storeBO) {
			logger.warn("[rebate] current user is not store,store message is empty,sellerid=" + sellerUserid);
		}
		return storeBO;
	}

	public static UserAccount getAccount(long uid, String accountType) {
		return accountService.findByUid(uid, accountType);
	}

	public static String getUserRecommendCnOperator(long userId) {
		// 当前装好是否为CN号
		UserAccount cnAccount = accountService.findUserAccount(userId, "8");
		if (null != cnAccount) {
			return cnAccount.getLoginName();
		}
		Long cnUserid = userRelationService.getUserRecommendCnOperator(userId);
		if (null == cnUserid) {
			logger.info("[rebate] current user is not cn operator,user id=" + userId);
			return null;
		}
		UserAccount useraccount = accountService.findUserAccount(cnUserid, "8");
		if (null == useraccount) {
			logger.info("[rebate] current user is not cn operator,user id=" + userId);
			return null;
		}
		return useraccount.getLoginName();
	}

	/**
	 * 获取会员绑定的商家信息
	 * 
	 * @param userid
	 * @return
	 */
	public static SellerBO getMemberBindingSeller(long userid) {
		UserRelationBO userRelation = userRelationService.getUserRelation(userid);
		if (null == userRelation || null == userRelation.getSellerUserId()) {
			logger.warn(
					"[rebate] get member binding seller, current user ：'No recommendation',userid=" + userid);
			return null;
		}
		// 被绑定的商家ID；
		long bindingSellerId = userRelation.getSellerUserId();
		SellerBO sellerBO = sellerService.findSessionById(bindingSellerId, true, null);
		if (null == sellerBO) {
			logger.warn(
					"[rebate]  get member binding seller,current user is not seller,seller message is empty,sellerid="
							+ bindingSellerId);
			return null;
		}
		return sellerBO;
	}

	/**
	 * 获取用户推荐关系表
	 * 
	 * @param level
	 * @param userId
	 * @return
	 */
	public static Map<Integer, Long> getUserRecommendByLevel(int level, long userId) {
		Map<Integer, Long> resultMP = new HashMap<Integer, Long>();
		Map<Integer, Long> recommendMP = userRelationService.getUserRecommendByLevel(level, userId);
		Map<Integer, Long> userRelationMp = null;
		if (null == recommendMP) {
			return new HashMap<Integer, Long>();
		}
		for (int i = 1; i <= recommendMP.size(); i++) {
			Long uid = recommendMP.get(i);
			UserAccount userAccount = accountService.findByUid(uid, "8");
			if (null != userAccount && StringUtils.isNotBlank(userAccount.getLoginName())
					&& userAccount.getLoginName().startsWith(JobConstant.OTHER_REBATE_ACCOUNT_START)) {
				userRelationMp = operatorRemoteService
						.getRemoteOperatorLevelByCode(userAccount.getLoginName());
				break;
			}
			resultMP.put(i, uid);
		}
		if (null == userRelationMp) {
			return resultMP;
		}
		int resultSize = resultMP.size();
		for (int j = 1; j <= userRelationMp.size(); j++) {
			long uid = userRelationMp.get(j);
			resultMP.put(resultSize + j, uid);
		}
		logger.debug("[rebate] user recomment,uid=" + userId + ",recomment=" + resultMP);
		return resultMP;
	}
}
