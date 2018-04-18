package com.sinco.carnation.rebate.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.dao.ReturnGoodsLogDao;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.dao.PredepositPfLogDao;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.PredepositPfLog;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.bo.UserRelationBO;
import com.sinco.carnation.user.dao.OperatorDao;
import com.sinco.carnation.user.dao.RebateLogDao;
import com.sinco.carnation.user.dao.RebateRecordDao;
import com.sinco.carnation.user.dao.RebateTrackDao;
import com.sinco.carnation.user.dao.UserOwnsDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.model.RebateFeeRate;
import com.sinco.carnation.user.model.RebateLog;
import com.sinco.carnation.user.model.RebateRate;
import com.sinco.carnation.user.model.RebateTrack;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * @ClassName: RebateService
 * @Description: TODO(返利计算类)
 * @author Tang
 * @date 2015年9月1日 上午11:22:55
 * 
 */
@Service
public class RebateService {

	private static final Logger logger = LoggerFactory.getLogger(RebateService.class);

	@Autowired
	private UserOwnsDao ownsDao;

	@Autowired
	private UserRelationDao relationDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private UserMoneyService moneyService;

	@Autowired
	private RebateRecordDao rebateRecordDao;
	@Autowired
	private OperatorDao operatorDao;

	@Autowired
	private RebateTrackDao rebateTrackDao;

	@Autowired
	private RebateLogDao rebateLogDao;

	@Autowired
	private SysConfigService sysConfigService;
	@Autowired
	private GroupOrderDao groupOrderDao;

	@Autowired
	private UserRelationService relationService;

	@Autowired
	private GroupInfoService groupInfoService;

	@Autowired
	private GroupOrderService groupOrderService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private PredepositPfLogDao predepositPfLogDao;

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private PayoffLogService payoffLogService;

	@Autowired
	private RebateRecordService rebateRecordService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private ReturnGoodsLogDao returnGoodsLogDao;

	/**
	 * 购买商品返润；
	 * 
	 * @param sellerId
	 *            卖家店铺ID
	 * @param orderId
	 *            订单ID
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("unused")
	@Transactional(rollbackFor = ServiceException.class)
	public boolean buyGoodsRebate(Long sellerId, Long orderId) throws ServiceException {

		if (sellerId == null || orderId == null) {
			throw new ServiceException("参数不正确！");
		}

		// 1.获取当前订单
		OrderForm currentOrderForm = orderFormService.getObjById(orderId);
		if (currentOrderForm == null) {
			throw new ServiceException("订单不存在！");
		}
		// 计算订单反润的金额
		Long orderUserId = currentOrderForm.getUserId();
		BigDecimal orderAddAmount = currentOrderForm.getCommissionAmount();// 订单商品中加价金额
		if (orderAddAmount == null) {
			orderAddAmount = BigDecimal.ZERO;
		}
		// 查询订单退货信息是否被拒绝 update by bill.tang 2015-11-16
		List<String> list = new ArrayList<>();
		list.add(OrderFormConstants.ORDER_RETURN_STATUS_REFUSE);
		List<ReturnGoodsLogBO> returnList = returnGoodsLogDao.selectByOrderId(orderId);

		if (!CollectionUtils.isEmpty(returnList)) {
			for (ReturnGoodsLogBO returnGoodsLogBO : returnList) {
				if (OrderFormConstants.ORDER_RETURN_STATUS_SUCCESS.equals(returnGoodsLogBO
						.getGoodsReturnStatus())) {
					orderAddAmount = orderAddAmount.subtract(returnGoodsLogBO.getGoodsCommissionRate());
				}
			}
		}
		// BigDecimal returnOrderAddAmount =
		// orderFormTools.getReturnGoodsCommisionAmount(currentOrderForm.getReturnGoodsInfo());
		// orderAddAmount = orderAddAmount.subtract(returnOrderAddAmount);

		if (orderAddAmount.doubleValue() < 0) {
			orderAddAmount = BigDecimal.ZERO;
		}

		// 2.下面找推荐关系，找到具体的获润对象，没有找到则为平台获润
		UserRelationBO userRelation = relationDao.get(orderUserId); // 获取会员的推荐用户
		UserRelationBO sellderRelation = null;
		if (sellerId > 0) {
			sellderRelation = relationDao.get(sellerId); // 获取店铺的推荐用户
		}

		// 3.分润金额计算,添加反润记录
		Long refereeUserId = userRelation == null || userRelation.getRefereeUserId() == null ? 0L
				: userRelation.getRefereeUserId(); // 获取反润推荐的用户id,0归为平台
		Long refereeSellerId = 0L;// 获取反润推荐的商家id,0归为平台
		if (sellderRelation != null && sellderRelation.getRefereeUserId() > 0) {
			// 仅运营商，才能分润
			if (this.operatorDao.queryOperatorInfo(sellderRelation.getRefereeUserId()) != null) {
				refereeSellerId = sellderRelation.getRefereeUserId();
			}
		}

//		BigDecimal userRefereeAmount = orderAddAmount.multiply(UserContants.MEMBER_GOOD_REBATE_RATE).setScale(2,
//				RoundingMode.DOWN);
//		BigDecimal sellerRefereeAmount = orderAddAmount.multiply(UserContants.SHOP_GOOD_REBATE_RATE).setScale(2,
//				RoundingMode.DOWN);
//
//		this.addGoodRebateRecordAndMoney(orderUserId, orderId, sellerId, refereeUserId, orderAddAmount,
//				userRefereeAmount, RebateConstants.REBATE_TYPE_301);
//		this.addGoodRebateRecordAndMoney(orderUserId, orderId, sellerId, refereeSellerId, orderAddAmount,
//				sellerRefereeAmount, RebateConstants.REBATE_TYPE_302);

		return true;
	}

	/**
	 * @throws ServiceException
	 *             userId 可以为空，扫码支付用户Id为空
	 * @Title: sendBuyRebate @Description: TODO(购买消费返润；调用此类之后，需要再调用 addRebateLog 方法记录返润日志) @param @param
	 *         userId 购买用户id @param @param sellerId 购买商品商户id @param @param orderId 购买订单id @param @param
	 *         orderAmount 购买订单金额 @param @param rebateCode 消费码(如果是刷卡消费返润的话，该值传null) @param @return 设定文件 @return
	 *         boolean 返回类型 @author Tang @throws
	 */
	@SuppressWarnings("unused")
	@Transactional(rollbackFor = ServiceException.class)
	public boolean sendBuyRebate(Long userId, Long sellerId, Long orderId, BigDecimal codeAmount,
			String rebateCode) throws ServiceException {
		if (sellerId == null || orderId == null || codeAmount == null) {
			throw new ServiceException("参数不正确！");
		}
		UserRelationBO userRelation = null;
		if (userId > 0) {
			userRelation = relationDao.get(userId);
		}
		// if (userRelation == null) {
		// throw new ServiceException("用户关系不存在！");
		// }
		StoreBO storeBO = storeDao.queryStoreInfo(sellerId,true,false);
		if (storeBO == null) {
			throw new ServiceException("商户不存在！");
		}
		if (storeBO.getCommissionRebate() == null) {
			throw new ServiceException("商户返润比率为空！");
		}
		// 得到服务商户的消费返润比率
		BigDecimal rebateRate = storeBO.getCommissionRebate();
		// 得到返润金额总额
		BigDecimal rebateAmount = codeAmount.multiply(rebateRate).setScale(2, RoundingMode.DOWN);
		// 4套餐券5代金券 的返润取订单返润字段
		GroupOrderBO groupOrderBO = groupOrderService.fetch(orderId);
		if (groupOrderBO != null && groupOrderBO.getGroupRebateAmount().doubleValue() > 0) {
			if (groupOrderBO.getOrderType() == 4) {
				rebateAmount = BigDecimal.ZERO;
				rebateAmount = groupOrderBO.getGroupRebateAmount();
			} else if (groupOrderBO.getOrderType() == 5) {
				rebateAmount = BigDecimal.ZERO;
				rebateAmount = groupOrderBO.getGroupRebateAmount();
			}
		}
		// 如果推荐人id，和购买商户的id相同，那么说明是本地本销，如果不同，说明是本地外销
		RebateRate rate = null;

		if (userRelation != null && sellerId.equals(userRelation.getSellerUserId())) {
			rate = RebateConstants.MAP_RATE.get(RebateConstants.RETATE_LOCAL);
		} else {
			rate = RebateConstants.MAP_RATE.get(RebateConstants.RETATE_EXPORT);

			// 本地外销才有这些需要算
			BigDecimal buySellerRefereeRebate = rebateAmount.multiply(rate.getBuySellerReferenceRate())
					.setScale(2, RoundingMode.DOWN);// 购买商户推荐人返润
			BigDecimal buyRegionalRebate = rebateAmount.multiply(rate.getBuyRegionalRate()).setScale(2,
					RoundingMode.DOWN);// 购买区域返润
			BigDecimal buyDistrictRebate = rebateAmount.multiply(rate.getBuyDistrictRate()).setScale(2,
					RoundingMode.DOWN);// 购买区返润
			BigDecimal buyCityRebate = rebateAmount.multiply(rate.getBuyCityRate()).setScale(2,
					RoundingMode.DOWN);// 购买市返润

			// 查询购买商户的推荐人
			UserRelationBO sellerRelation = relationDao.get(sellerId);
			Long buySellerRefereeUserId = null;
			if (sellerRelation != null) {
				buySellerRefereeUserId = sellerRelation.getRefereeUserId();
			}
			// addMoney(buySellerRefereeUserId, buySellerRefereeRebate, userId,
			// orderId, codeAmount, rebateCode,
			// RebateConstants.REBATE_TYPE_109, null, sellerId,
			// RebateConstants.REBATE_STATUS_1);
			/*UserOwnsBO owns = ownsDao.selectBOBySellerId(sellerId);
			Long ownOperatorUserId = null;
			Long operatorDistrictUserId = null;
			Long operatorCityUserId = null;
			Long operatorDistrictId = null;
			Long operatorCityId = null;
			if (owns != null) {
				ownOperatorUserId = owns.getOwnOperatorUserId();

				// 接下来查出该商户所属都区，市级运营商
				List<OperatorBO> operatorDistrictList = operatorDao.selectOperatorBySellerUserId(sellerId,
						UserContants.OPERATOR_LEVEL_QU);
				if (!CollectionUtils.isEmpty(operatorDistrictList)) {
					operatorDistrictUserId = operatorDistrictList.get(0).getUserId();
					operatorDistrictId = operatorDistrictList.get(0).getId();
				}

				List<OperatorBO> operatorCityList = operatorDao.selectOperatorBySellerUserId(sellerId,
						UserContants.OPERATOR_LEVEL_SHI);
				if (!CollectionUtils.isEmpty(operatorCityList)) {
					operatorCityUserId = operatorCityList.get(0).getUserId();
					operatorCityId = operatorCityList.get(0).getId();
				}

				addTrack(orderId, "外地消费返润", rebateCode, owns.getSellerUserId(), owns.getOwnOperatorUserId());
			}*/
			// addMoney(ownOperatorUserId, buyRegionalRebate, userId, orderId,
			// codeAmount, rebateCode,
			// RebateConstants.REBATE_TYPE_110, (owns == null ||
			// owns.getOwnOperatorId() == null) ? 0L : owns.getOwnOperatorId(),
			// sellerId,
			// RebateConstants.REBATE_STATUS_1);
			// addMoney(operatorDistrictUserId, buyDistrictRebate, userId,
			// orderId, codeAmount, rebateCode,
			// RebateConstants.REBATE_TYPE_111, operatorDistrictId, sellerId,
			// RebateConstants.REBATE_STATUS_1);
			// addMoney(operatorCityUserId, buyCityRebate, userId, orderId,
			// codeAmount, rebateCode,
			// RebateConstants.REBATE_TYPE_112, operatorCityId, sellerId,
			// RebateConstants.REBATE_STATUS_1);
		}

		BigDecimal ownRebate = rebateAmount.multiply(rate.getOwnRate()).setScale(2, RoundingMode.DOWN); // 自身返润
		BigDecimal refereeRebate = rebateAmount.multiply(rate.getReferenceRate()).setScale(2,
				RoundingMode.DOWN);// 推荐人返润
		BigDecimal ownSellerRebate = rebateAmount.multiply(rate.getOwnSellerRate()).setScale(2,
				RoundingMode.DOWN);// 所属商户返润
		BigDecimal ownSellerRefereeRebate = rebateAmount.multiply(rate.getOwnSellerReferenceRate()).setScale(
				2, RoundingMode.DOWN);// 所属商户推荐人返润
		BigDecimal ownRegionalRebate = rebateAmount.multiply(rate.getOwnRegionalRate()).setScale(2,
				RoundingMode.DOWN);// 所属区域返润
		BigDecimal ownRegionalReferenceRebate = rebateAmount.multiply(rate.getOwnRegionalReferenceRate())
				.setScale(2, RoundingMode.DOWN);// 所属区域推荐人返润
		BigDecimal ownDistrictRebate = rebateAmount.multiply(rate.getOwnDistrictRate()).setScale(2,
				RoundingMode.DOWN);// 所属区返润
		BigDecimal ownCityRebate = rebateAmount.multiply(rate.getOwnCityRate())
				.setScale(2, RoundingMode.DOWN);// 所属市返润
		// 查询购买用户的推荐关系
		Long refereeUserId = (userRelation == null || userRelation.getRefereeUserId() == null) ? 0L
				: userRelation.getRefereeUserId();
		Long ownSellerUserId = (userRelation == null || userRelation.getSellerUserId() == null) ? 0L
				: userRelation.getSellerUserId();

		Long ownSellerRefereeUserId = null;
		if (ownSellerUserId != null) {
			UserRelationBO ownSellerRelation = relationDao.get(ownSellerUserId);
			if (ownSellerRelation != null) {
				ownSellerRefereeUserId = ownSellerRelation.getRefereeUserId();
			}
		}

		// addMoney(userId, ownRebate, userId, orderId, codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_101, null,
		// sellerId, RebateConstants.REBATE_STATUS_1);
		// addMoney(refereeUserId, refereeRebate, userId, orderId, codeAmount,
		// rebateCode, RebateConstants.REBATE_TYPE_102,
		// null, sellerId, RebateConstants.REBATE_STATUS_1);
		// addMoney(ownSellerUserId, ownSellerRebate, userId, orderId,
		// codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_103, null, sellerId,
		// RebateConstants.REBATE_STATUS_1);
		// addMoney(ownSellerRefereeUserId, ownSellerRefereeRebate, userId,
		// orderId, codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_104, null, sellerId,
		// RebateConstants.REBATE_STATUS_1);

/*		UserOwnsBO owns = ownsDao.selectBOBySellerId(ownSellerUserId);
		Long ownRegionalRefereeUserId = null;
		if (owns != null) {
			Long ownUserId = owns.getOwnOperatorUserId();
			// addMoney(ownUserId, ownRegionalRebate, userId, orderId,
			// codeAmount, rebateCode,
			// RebateConstants.REBATE_TYPE_105, owns.getOwnOperatorId(),
			// sellerId,
			// RebateConstants.REBATE_STATUS_1);
			// 找出隶属运营商推荐人
			if (ownUserId != null) {
				UserRelationBO ownRegionalRelation = relationDao.get(ownUserId);
				if (ownRegionalRelation != null) {
					ownRegionalRefereeUserId = ownRegionalRelation.getRefereeUserId();
				}
			}
			addTrack(orderId, "本地消费返润", rebateCode, owns.getSellerUserId(), owns.getOwnOperatorUserId());
		}*/
		// addMoney(ownRegionalRefereeUserId, ownRegionalReferenceRebate,
		// userId, orderId, codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_106, null, sellerId,
		// RebateConstants.REBATE_STATUS_1);

		Long ownOperatorDistrictUserId = null;
		Long ownOperatorCityUserId = null;
		Long ownOperatorDistrictId = null;
		Long ownOperatorCityId = null;
		// 接下来查出该商户所属都区，市级运营商
		List<OperatorBO> operatorDistrictList = operatorDao.selectOperatorBySellerUserId(ownSellerUserId,
				UserContants.OPERATOR_LEVEL_QU);
		if (!CollectionUtils.isEmpty(operatorDistrictList)) {
			ownOperatorDistrictUserId = operatorDistrictList.get(0).getUserId();
			ownOperatorDistrictId = operatorDistrictList.get(0).getId();
		}
		List<OperatorBO> operatorCityList = operatorDao.selectOperatorBySellerUserId(ownSellerUserId,
				UserContants.OPERATOR_LEVEL_SHI);
		if (!CollectionUtils.isEmpty(operatorCityList)) {
			ownOperatorCityUserId = operatorCityList.get(0).getUserId();
			ownOperatorCityId = operatorCityList.get(0).getId();
		}
		// addMoney(ownOperatorDistrictUserId, ownDistrictRebate, userId,
		// orderId, codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_107, ownOperatorDistrictId, sellerId,
		// RebateConstants.REBATE_STATUS_1);
		// addMoney(ownOperatorCityUserId, ownCityRebate, userId, orderId,
		// codeAmount, rebateCode,
		// RebateConstants.REBATE_TYPE_108, ownOperatorCityId, sellerId,
		// RebateConstants.REBATE_STATUS_1);

		/*
		 * 消费码如果为空的话，说明是刷卡消费返润。就不用在去发放商户销售金额
		 */
		if (rebateCode != null) {
			BigDecimal sellerAmount = codeAmount.subtract(rebateAmount);
			if (sellerAmount.doubleValue() > 0) {
				/*moneyService.addMoney(sellerId, sellerAmount.doubleValue(), null,
						UserContants.PD_OP_TYPE_SELL, "消费码：" + rebateCode + "销售金额");*/
				moneyService.addMoneyV2(sellerId, sellerAmount.doubleValue(), null,
						UserContants.PD_OP_TYPE_SELL, "消费码：" + rebateCode + "销售金额",
						UserContant.ACCOUNT_TYPE_MERCHANT);// 商户销售服务 发放商户销售金额
			}
		}

		/*addMoney(null, rebateAmount.multiply(rate.getShopRate()).setScale(2, RoundingMode.DOWN), userId, orderId,
				codeAmount, rebateCode, "991", null, sellerId, RebateConstants.REBATE_STATUS_1);*/
		return true;
	}

	/**
	 * 
	 * @Title: getComissionChargeRebateAmount @Description: TODO(得到商户手续费返润金额) @param @param orderAmount ，订单金额 @param @return
	 *         设定文件 @return BigDecimal 返回类型 @author Tang @throws
	 */
	public BigDecimal getComissionChargeRebateAmount(BigDecimal orderAmount) throws ServiceException {
		if (orderAmount == null) {
			throw new ServiceException("传入订单金额不允许为空！");
		}
		// 得到服务商户的手续费
		BigDecimal rebateRate = sysConfigService.getSysConfig().getCommissionRebateRate()
				.add(sysConfigService.getSysConfig().getEeepayFee());
		if (rebateRate == null) {
			rebateRate = BigDecimal.ZERO;
		}
		// 得到返润金额总额
		BigDecimal rebateAmount = orderAmount.multiply(rebateRate).setScale(2, RoundingMode.DOWN);
		return rebateAmount;
	}

	/**
	 * @throws ServiceException
	 * 
	 * @Title: sendCommissionChargeRebate @Description: TODO(手续费返润接口，需要再调用 addRebateLog 方法记录返润日志) @param @param
	 *         sellerId 商品买家id @param @param orderId @param @param orderAmount 订单金额 @param @return 设定文件 @return
	 *         boolean 返回类型 @author Tang @throws
	 */
	@SuppressWarnings("unused")
	@Transactional
	public boolean sendCommissionChargeRebate(Long sellerId, Long orderId, BigDecimal orderAmount)
			throws ServiceException {

		RebateFeeRate rebateFeeRate = RebateConstants.MAP_FEE_RATE.get(RebateConstants.DEFAULT_RATE);

		// 得到服务商户的手续费
		BigDecimal rebateRate = sysConfigService.getSysConfig().getCommissionRebateRate();
		if (rebateRate == null) {
			rebateRate = BigDecimal.ZERO;
		}
		// 得到返润金额总额
		// BigDecimal rebateAmount =
		// orderAmount.multiply(rebateRate).setScale(2, RoundingMode.DOWN);
		BigDecimal rebateAmount = orderAmount;
		// 得到返润比率
		BigDecimal regionalRate = rebateFeeRate.getRegionalRate();
		BigDecimal districtRate = rebateFeeRate.getDistrictRate();
		BigDecimal cityRate = rebateFeeRate.getCityRate();
		BigDecimal refereeRate = rebateFeeRate.getRegionalRefereeRate();
		BigDecimal shopRate = rebateFeeRate.getShopRate();
		// 得到返润金额
		BigDecimal regionalRebate = rebateAmount.multiply(regionalRate).setScale(2, RoundingMode.DOWN);
		BigDecimal districtRebate = rebateAmount.multiply(districtRate).setScale(2, RoundingMode.DOWN);
		BigDecimal cityRebate = rebateAmount.multiply(cityRate).setScale(2, RoundingMode.DOWN);
		BigDecimal refereeRebate = rebateAmount.multiply(refereeRate).setScale(2, RoundingMode.DOWN);
		BigDecimal shopRebate = rebateAmount.multiply(shopRate).setScale(2, RoundingMode.DOWN);

		// 得到返润用户
		Integer ownType = 1;
		UserOwnsBO owns = ownsDao.selectBOBySellerId(sellerId,ownType);
		Long operatorUserId = null;
		Long operatorId = null;
		if (owns != null) {
			operatorUserId = owns.getOwnOperatorUserId();
			operatorId = owns.getOwnOperatorId();
		}
		// addMoney(operatorUserId, regionalRebate, null, orderId, orderAmount,
		// null, RebateConstants.REBATE_TYPE_201,
		// operatorId, sellerId, RebateConstants.REBATE_STATUS_0);

		Long districtUserId = null;
		Long districtId = null;
		Long cityUserId = null;
		Long cityId = null;
		// 接下来查出该商户所属都区，市级运营商
		List<OperatorBO> operatorDistrictList = operatorDao.selectOperatorBySellerUserId(sellerId,
				UserContants.OPERATOR_LEVEL_QU);
		if (!CollectionUtils.isEmpty(operatorDistrictList)) {
			districtUserId = operatorDistrictList.get(0).getUserId();
			districtId = operatorDistrictList.get(0).getId();
		}
		// addMoney(districtUserId, districtRebate, null, orderId, orderAmount,
		// null, RebateConstants.REBATE_TYPE_202,
		// districtId, sellerId, RebateConstants.REBATE_STATUS_0);

		List<OperatorBO> operatorCityList = operatorDao.selectOperatorBySellerUserId(sellerId,
				UserContants.OPERATOR_LEVEL_SHI);
		if (!CollectionUtils.isEmpty(operatorCityList)) {
			cityUserId = operatorCityList.get(0).getUserId();
			cityId = operatorCityList.get(0).getId();
		}
		// addMoney(cityUserId, cityRebate, null, orderId, orderAmount, null,
		// RebateConstants.REBATE_TYPE_203, cityId,
		// sellerId, RebateConstants.REBATE_STATUS_0);

		Long ownRegionalRefereeUserId = null;
		if (owns != null && owns.getOwnOperatorUserId() != null) {
			UserRelationBO ownRegionalRelation = relationDao.get(owns.getOwnOperatorUserId());
			if (ownRegionalRelation != null) {
				ownRegionalRefereeUserId = ownRegionalRelation.getRefereeUserId();
			}
		}
		// addMoney(ownRegionalRefereeUserId, refereeRebate, null, orderId,
		// orderAmount, null,
		// RebateConstants.REBATE_TYPE_204, null, sellerId,
		// RebateConstants.REBATE_STATUS_0);

		// addMoney(null, shopRebate, null, orderId, orderAmount, null, "992",
		// null, sellerId,
		// RebateConstants.REBATE_STATUS_1);
		if (owns != null && owns.getOwnOperatorUserId() != null) {
			addTrack(orderId, "手续费返润", null, owns.getSellerUserId(), owns.getOwnOperatorUserId());
		}
		return true;
	}

	/**
	 * 
	 * @Title: addMoney @Description: TODO(给用户增加金额) @param @param userId @param @param amount 设定文件 @return
	 *         void 返回类型 @author Tang @throws
	 */
	/*
	@Transactional
	private void addMoney(Long userId, BigDecimal amount, Long orderUserId, Long orderId, BigDecimal codeAmount,
		String rebateCode, String rebateType, Long operatorId, Long sellerUserId, String rebateStatus) {
	if (userId != null && !userId.equals(0L)) {
		String desc = RebateConstants.getRebateNameByType(rebateType);
		// int code = Integer.parseInt(rebateType);
		// if (code >= 100 && code < 200)
		// {
		// desc = "消费返润";
		// }
		// if (code >= 200 && code < 300)
		// {
		// desc = "手续费返润";
		// }
		if (amount.doubleValue() > 0 && rebateStatus.equals(RebateConstants.REBATE_STATUS_1)) {
			moneyService.addMoney(userId, amount.doubleValue(), null, UserContants.PD_OP_TYPE_REBATE, desc);
		}
		RebateRecord record = new RebateRecord();
		record.setOperatorId(operatorId);
		record.setUserId(userId);
		record.setOrderId(orderId);
		record.setRebateCode(rebateCode);
		record.setOrderUserId(orderUserId);
		record.setCodeAmount(codeAmount);
		record.setRebateAmount(amount);
		record.setRebateType(rebateType);
		record.setCreateTime(new Date());
		record.setSellerUserId(sellerUserId);
		record.setRebateStatus(rebateStatus);
		record.setSendTime(new Date());
		rebateRecordDao.save(record);
	} else {
		RebateRecord record = new RebateRecord();
		record.setOperatorId(operatorId);
		record.setUserId(0L);
		record.setOrderId(orderId);
		record.setRebateCode(rebateCode);
		record.setOrderUserId(orderUserId);
		record.setCodeAmount(codeAmount);
		record.setRebateAmount(amount);
		record.setRebateType(rebateType);
		record.setCreateTime(new Date());
		record.setSellerUserId(sellerUserId);
		record.setRebateStatus(rebateStatus);
		record.setSendTime(new Date());
		rebateRecordDao.save(record);
	}
	}*/

	@Transactional
	private void addTrack(Long orderId, String rebateType, String rebateCode, Long sellerUserId,
			Long ownOperatorUserId) {
		RebateTrack rebateTrack = new RebateTrack();
		rebateTrack.setSellerUserId(sellerUserId);
		rebateTrack.setOwnOperatorUserId(ownOperatorUserId);;
		rebateTrack.setRebateType(rebateType);
		rebateTrack.setRebateCode(rebateCode);
		rebateTrack.setOrderId(orderId);
		rebateTrack.setCreateTime(new Date());
		rebateTrackDao.save(rebateTrack);
	}

	/**
	 * 
	 * @Title: addRebateLog @Description: TODO(添加返润日志，每操作一笔返润记录一条) @param @param orderId 订单id @param @param
	 *         rebateCode 消费码，只有消费返润有此项 @param @param rebateType 返润类型：消费返润，手续费返润 @param @param rebateStatus
	 *         返润状态，true为操作成功，false为操作失败 @param @param errorMsg 错误信息，近返润失败的时候需要 @return void 返回类型 @author Tang @throws
	 */
	public void addRebateLog(Long orderId, String rebateCode, String rebateType, boolean rebateStatus,
			String errorMsg) {
		RebateLog rebateLog = new RebateLog();
		rebateLog.setOrderId(orderId);
		rebateLog.setRebateType(rebateType);
		rebateLog.setRebateStatus(rebateStatus);
		rebateLog.setErrorMsg(errorMsg);
		rebateLog.setCreateTime(new Date());
		rebateLog.setRebateCode(rebateCode);
		rebateLogDao.save(rebateLog);
	}

	public RebateRecordBO queryrebatesum(Long storeId, String startTime, String endTime) {
		return rebateRecordDao.queryrebatesum(storeId, startTime, endTime, null);
	}
	/** 根据storeid startTime endTime userType(buyer seller operator ) 查询分润总额 **/
	public RebateRecordBO queryrebatesum(Long storeId, String startTime, String endTime, String userType) {
		return rebateRecordDao.queryrebatesum(storeId, startTime, endTime, userType);
	}

	/** 根据uid查询分润 **/
	public List<RebateRecordBO> queryRebateCount(Long uid) {
		return rebateRecordDao.queryRebateCount(uid, null);
	}
	/** 根据uid userType查询分润 **/
	public List<RebateRecordBO> queryRebateCount(Long uid, String userType) {
		return rebateRecordDao.queryRebateCount(uid, userType);
	}

	/** **/
	public void queryShareDetails(Long uid, StoreVO vo, MyPage<RebateRecordBO> page) {
		page.setContent(rebateRecordDao.queryShareDetails(uid, vo, page, null));
	}
	/** 根据 uid 开始结束时间 用户类型查询分润记录 **/
	public void queryShareDetails(Long uid, StoreVO vo, MyPage<RebateRecordBO> page, String userType) {
		page.setContent(rebateRecordDao.queryShareDetails(uid, vo, page, userType));
	}

	public void queryShareListByVO(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		rebateRecordDao.queryShareListByVO(vo, page);
	}

	/**
	 * 
	 * @Title: sendLastMonthChargeRebate @Description: TODO(手续费返润接口，供定时任务调用) @param 设定文件 @return void 返回类型 @author
	 *         Tang @throws
	 */
	public void sendLastMonthChargeRebate() {
		List<GroupOrderBO> listOrder = groupOrderDao.selectLastMonthOrder();
		if (!CollectionUtils.isEmpty(listOrder)) {
			for (GroupOrderBO groupOrderBO : listOrder) {
				try {
					sendLastMonthChargeRebate(groupOrderBO);
					addRebateLog(groupOrderBO.getId(), null, "手续费返润", true, null);
				} catch (ServiceException e) {
					addRebateLog(groupOrderBO.getId(), null, "手续费返润", false, e.getErrorCode());
				}
			}
		}
	}

	/**
	 * @throws ServiceException
	 * 
	 * @Title: sendLastMonthChargeRebate @Description: TODO(手续费返润接口，单条返润) @param @param groupOrderBO 设定文件 @return
	 *         void 返回类型 @author Tang @throws
	 */
	@Transactional(rollbackFor = ServiceException.class)
	private void sendLastMonthChargeRebate(GroupOrderBO groupOrderBO) throws ServiceException {
		String storeId = groupOrderBO.getStoreId();
		if (StringUtils.isEmpty(storeId)) {
			throw new ServiceException("订单错误，店铺id为空！");
		}
		StoreBO storeBO = storeDao.findObjById(Long.parseLong(storeId));
		if (storeBO == null) {
			throw new ServiceException("店铺为空！");
		}

		List<RebateRecordBO> list = rebateRecordDao.findByChargeFeeOrderIdAndAndSellerId(
				groupOrderBO.getId(), storeBO.getCreateUserId());
		if (!CollectionUtils.isEmpty(list)) {
			for (RebateRecordBO rebateRecordBO : list) {
				if (RebateConstants.REBATE_STATUS_0.equals(rebateRecordBO.getRebateStatus())) {
					moneyService.addMoney(rebateRecordBO.getUserId(), rebateRecordBO.getRebateAmount()
							.doubleValue(), null, UserContants.PD_OP_TYPE_REBATE, "手续费返润");
					RebateRecordBO rebateRecordUpdate = new RebateRecordBO();
					rebateRecordUpdate.setId(rebateRecordBO.getId());
					rebateRecordUpdate.setRebateStatus(RebateConstants.REBATE_STATUS_1);
					rebateRecordUpdate.setSendTime(new Date());
					rebateRecordDao.update(rebateRecordUpdate);
				}
			}
		}
	}

	/**
	 * app 会员返润调用
	 * 
	 * @param userId
	 *            消费者ID
	 * @param sellerUserId商户id
	 * @param orderId订单id
	 * @param totalPrice订单总价
	 * @param groupSn订单id
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void appRebate(Long infoId, Long userId, Long sellerUserId, Long orderId, BigDecimal totalPrice,
			String groupSn, BigDecimal commissionRebate) throws ServiceException {
		// 推荐关系
		// 检测消费者是否是店铺会员，如果不是则变为店铺会员
		relationService.checkUserRelation(userId, sellerUserId);
		// if (relationService.getUserRelation(userId) == null) {
		// relationService.createUserRelation(userId, null, sellerUserId);
		// }
		// 返润
		this.sendBuyRebate(userId, sellerUserId, orderId, totalPrice, groupSn);

		// 保存返润比例
		// GroupOrderBO orderBO=groupOrderDao.get(orderId);
		// orderBO.setProportion(commissionRebate);
		// groupOrderDao.save(orderBO);

		if (infoId != null) {
			GroupInfo infoBO = groupInfoService.getObjById(infoId);
			infoBO.setProportion(commissionRebate);
			groupInfoService.save(infoBO);
		}
	}

	@Autowired
	private IntegralService integralService;

	@Transactional(readOnly = false)
	public boolean lineProfit(double amount, GroupOrder groupOrder, boolean isChargeRebate)
			throws ServiceException {
		if (groupOrder.getTotalPrice().doubleValue() == amount && groupOrder.getOrderStatus() == 30) {

			// 设置线下刷卡总收益
			BigDecimal prossPrice = groupOrder.getTotalPrice().multiply(groupOrder.getProportion());// 总金额*返润比例(下线刷卡用)=返润金额
			BigDecimal comissPrice = this.getComissionChargeRebateAmount(groupOrder.getTotalPrice());// 手续费
			if (prossPrice == null) {
				prossPrice = BigDecimal.ZERO;
			}
			if (comissPrice == null) {
				comissPrice = BigDecimal.ZERO;
			}
			BigDecimal profitAmount = groupOrder.getTotalPrice();

			//StoreBO storeBO = storeService.getObjById(CommUtil.null2Long(groupOrder.getStoreId()));
			StoreBO storeBO = this.storeDao.getStoreStatus(CommUtil.null2Long(groupOrder.getStoreId()));
			if (groupOrder.getIsSysUser()) {
				// 卖家是会员才分润 add by chenz
				// 2016-01-21
				logger.debug("----------------执行分润--------------");
				this.appRebate(null, groupOrder.getUserId(), storeBO.getCreateUserId(), groupOrder.getId(),
						groupOrder.getTotalPrice(), null, storeBO.getCommissionRebate());// 返润
				profitAmount = profitAmount.subtract(prossPrice);
			}
			if (isChargeRebate) // 手续费是否分润
			{
				// 手续费返润
				logger.debug("----------------手续费返润--------------");
				this.sendCommissionChargeRebate(storeBO.getCreateUserId(), groupOrder.getId(),
						groupOrder.getTotalPrice());
				profitAmount = profitAmount.subtract(comissPrice);
			}
			this.addRebateLog(groupOrder.getId(), null, "消费返润", true, null);

			PredepositPfLog pfLog = new PredepositPfLog();
			// 设置线下刷卡收益流水
			pfLog.setAddTime(new Date());
			pfLog.setPfLogUserId(storeBO.getCreateUserId());
			pfLog.setOrderId(groupOrder.getId());
			pfLog.setPfLogAmount(profitAmount);
			predepositPfLogDao.save(pfLog);

			if (groupOrder.getIsSysUser() && groupOrder.getUserId() != null) {
				// 赠送积分
				try {
					integralService.addIntegral(IntegralConstants.INTEGRAL_CONSUMER, groupOrder.getUserId(),
							CommUtil.null2String(amount), null, "offlineOrder", null);
				} catch (Exception e) {
					logger.error("add integral is unsuccess uid=" + groupOrder.getUserId());
				}
			}
			return true;

		}
		return false;
	}

}
