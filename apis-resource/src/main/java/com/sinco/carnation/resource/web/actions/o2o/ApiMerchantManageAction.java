package com.sinco.carnation.resource.web.actions.o2o;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.elasticsearch.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupEvaluationService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.resource.bo.o2o.ApplyInfoBO;
import com.sinco.carnation.resource.bo.o2o.GoodsRefundBO;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.GroupEvaluateBO;
import com.sinco.carnation.resource.bo.o2o.GroupServiceBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.o2o.OGroupInfoBO;
import com.sinco.carnation.resource.bo.o2o.OrderDetailsBO;
import com.sinco.carnation.resource.bo.o2o.RebateBO;
import com.sinco.carnation.resource.bo.o2o.StoreAlbumBO;
import com.sinco.carnation.resource.bo.o2o.StoreAppInfoBO;
import com.sinco.carnation.resource.bo.o2o.StoreCustomerBO;
import com.sinco.carnation.resource.bo.o2o.StoreIndexBO;
import com.sinco.carnation.resource.bo.o2o.UPrepositCashBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.o2o.CashMoneyVO;
import com.sinco.carnation.resource.vo.o2o.EvaluateVO;
import com.sinco.carnation.resource.vo.o2o.GoodsRefundVO;
import com.sinco.carnation.resource.vo.o2o.GroupEvaluateVO;
import com.sinco.carnation.resource.vo.o2o.GroupOrderVO;
import com.sinco.carnation.resource.vo.o2o.OGroupGoodsVO;
import com.sinco.carnation.resource.vo.o2o.OrderDetailsVO;
import com.sinco.carnation.resource.vo.o2o.PayCartOrderVO;
import com.sinco.carnation.resource.vo.o2o.PredepositLogVO;
import com.sinco.carnation.resource.vo.o2o.RebateDetailsVO;
import com.sinco.carnation.resource.vo.o2o.RebateRecordVO;
import com.sinco.carnation.resource.vo.o2o.StoreAccessoryVO;
import com.sinco.carnation.resource.vo.o2o.StoreCustomerVO;
import com.sinco.carnation.resource.vo.o2o.StoreInfoVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.o2o.MerchantManageResponse;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.bo.PredepositPfLogBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.vo.PredepositCashVO;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreApplyVO;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.OperatorContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.constant.MoneyUserTypeEnum;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "o2o商户", namespace = "group")
public class ApiMerchantManageAction extends BasicApiController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private GroupOrderService groupOrderServer;

	@Autowired
	private GroupInfoService groupInfoService;

	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private GroupEvaluationService evaluationService;

	@Autowired
	private RebateService rebateService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private AlbumService albumService;

	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	private PredepositCashService predepositCashService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private GroupClassService groupClassService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreSearchService storeSearchService;

	@Autowired
	private PredepositLogService predepService;

	@Autowired
	private UserAccountService account;

	@Autowired
	private Mapper mapper;

	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	
	@Autowired
	private NoticeMessageService noticeMessageService;
	
	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private DicContent dicContent;
	
	@Autowired
	private UserOwnService userOwnService;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	@RequestMapping(value = "/group/merchant/info", method = RequestMethod.POST)
	@MethodMapping(desc = "商户首页")
	public @ResponseBody
	MerchantManageResponse merchantInfo() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String userType = MoneyUserTypeEnum.O2O.toString();
		if (uid == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		StoreBO storeInfo = storeService.queryStoreInfo(uid,true,false);
		if (storeInfo != null) {
			StoreIndexBO merchant = mapper.map(storeInfo, StoreIndexBO.class);
			String coverPath = merchant.getCoverPath();
			if(coverPath==null || coverPath.trim().length()<=0)
			{
				StoreApplyInfoBO storeApplyInfo = this.storeService.queryStoreApplyInfo(uid,true,false);
				if(storeApplyInfo!=null)
				{
					merchant.setCoverPath(storeApplyInfo.getBusinessPlacePhotoPath());
				}
			}
			BigDecimal onLine = groupOrderServer.queryOnLineTotalPrice(storeInfo.getId(), null, null);// 券销售总额
			BigDecimal line = groupOrderServer.queryLineTotalPrice(storeInfo.getId(), null, null);// 卡销售总额
			if (onLine == null) {
				onLine = BigDecimal.ZERO;
			}
			if (line == null) {
				line = BigDecimal.ZERO;
			}
			BigDecimal totalSalesPrice = onLine.add(line);// 商户销售总额 券销售+卡销售
			BigDecimal goodsProfitAmount = predepService.queryGoodsProfitAmount(UserContants.PD_OP_TYPE_SELL,
					uid, null, null);// 券收益总额
//			BigDecimal cardAmount = groupOrderServer.queryPredepositTotal(uid, null, null);// 卡收益总额
//			if (cardAmount == null) {
//				cardAmount = BigDecimal.ZERO;
//			}
			RebateRecordBO rebateRecordBO = rebateService.queryrebatesum(uid, null, null ,userType);// 返润总额
			BigDecimal rebateAmount = BigDecimal.ZERO;
			if (rebateRecordBO != null) {
				rebateAmount = rebateRecordBO.getTotalRebateAmout();
			}
			if (goodsProfitAmount == null) {
				goodsProfitAmount = BigDecimal.ZERO;
			}

			if (rebateAmount == null) {
				rebateAmount = BigDecimal.ZERO;
			}
			// BigDecimal cardAmount = shopQrPayOrderService.findAllPaySuccessMoneyBySellerId(uid
			// ,null,null);//扫码总额
			// 统计优惠买单金额
			BigDecimal orderAmount = groupOrderServer.staticsDiscountPayAmount(storeInfo.getId());
			// 取o2o_group_order线上支付订单总额
			merchant.setTotalPayAmount(orderAmount);// 扫码总额
//			BigDecimal profitTotal = goodsProfitAmount.add(cardAmount).add(rebateAmount);// 总收益  卡收益+券收益+返润总额
			BigDecimal profitTotal = goodsProfitAmount.add(rebateAmount).add(orderAmount);// 总收益 券收益+返润总额+扫码总额
			merchant.setRebateAmount(rebateAmount);// 返润总额
			merchant.setCouponPayAmount(goodsProfitAmount);// 券收益总额 (券收益=shop_predeposit_log
															// 平台云豆变动明细，不包含结算系统奖金)
			merchant.setProfitAmount(profitTotal);// 收益总额

			merchant.setId(uid);

//			merchant.setChargePayAmount(cardAmount);// 扫码总额
			if(StringUtils.isNotBlank(storeInfo.getStoreCoverPath())){
				merchant.setCoverPath(storeInfo.getStoreCoverPath());
			}else{
				AlbumBO albumBO = albumService.getStoreAlbum(uid);
				if (albumBO != null) {
					Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
					if (accessory != null) {
						merchant.setCoverPath(accessory.getPath());
					}
				}
			}
			List<Accessory> accessoryList = albumService.queryAccessories(uid);// 默认相册图片
			if (accessoryList != null) {
				merchant.setTotalPhoto(accessoryList.size());
			}
			// 设置地区
			String area = areaService.fullName(storeInfo.getAreaId());
			if (StringUtils.isNotBlank(area)) {
				merchant.setArea(area);
			}
			merchant.setIsO2o(storeInfo.getIsO2o());
			response.setMerchant(merchant);
		}
		response.setCN(true);
		if (account.findByUid(uid, "8") == null) {
			response.setCN(false);
		}
		return response;
	}

	@RequestMapping(value = "/group/order_online/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商户订单列表")
	public @ResponseBody
	MerchantManageResponse queryMerchantOrder(@Valid @ModelAttribute @Param GroupOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		//清空商户推送消息数
		noticeMessageService.cleanReceiveMoneyMessage(uid);

		MyPage<com.sinco.carnation.o2o.bo.GroupOrderBO> page = new MyPage<com.sinco.carnation.o2o.bo.GroupOrderBO>();
		page.setPageSize(vo.getPageSize());
		page.setPageNumber(vo.getPageNum());

		groupOrderServer.queryMerchantOrderList(uid, vo.getOrderStatus(), vo.getOrderType(),
				vo.getLocalStatus(), page);

		List<com.sinco.carnation.resource.bo.o2o.GroupOrderBO> groupOrderList = MapperUtils.map(mapper,
				page.getContent(), com.sinco.carnation.resource.bo.o2o.GroupOrderBO.class);
		for (com.sinco.carnation.resource.bo.o2o.GroupOrderBO group : groupOrderList) {
			// 判断线上还是线下订单，线下包括优惠买单
			if (group.getOrderType() == 1 || group.getOrderType() == 4 || group.getOrderType() == 5) {
				// 商品信息
				GroupServiceBO serviceBO = JSON.parseObject(group.getGroupInfo(), GroupServiceBO.class);
				group.setService(serviceBO);
			} else {
				GroupServiceBO serviceBO = new GroupServiceBO();
				serviceBO.setGoods_name("");
				serviceBO.setGoods_count(1);
				if (group.getOrderType() != null) {
					if (group.getOrderType() == 1) {
						serviceBO.setGoods_name("线上订单");
					} else if (group.getOrderType() == 2) {
						serviceBO.setGoods_name("扫码支付");
					} else if (group.getOrderType() == 3) {
						serviceBO.setGoods_name("优惠买单");
					} else if (group.getOrderType() == 4) {
						serviceBO.setGoods_name("套餐券");
					} else if (group.getOrderType() == 5) {
						serviceBO.setGoods_name("代金券");
					} else {
						serviceBO.setGoods_name(group.getLocalGroupName());
					}
				}
				group.setService(serviceBO);
				group.setLocalGroupName(serviceBO.getGoods_name());
			}
			/*
			if (StringUtils.isNotBlank(group.getGroupInfo())) {
				// 商品信息
				GroupServiceBO serviceBO = JSON.parseObject(group.getGroupInfo(), GroupServiceBO.class);
				group.setService(serviceBO);
			}else{
				//由于微信扫码支付的订单没有group_info，暂时这样处理
				GroupServiceBO serviceBO = new GroupServiceBO();
				serviceBO.setGoods_name("");
				serviceBO.setGoods_count(1);
				if(group.getLocalGroupName() != null){
					if(group.getLocalGroupName().indexOf("支付宝") != -1){
						serviceBO.setGoods_name("商户专属码【支付宝支付】");
					}else if(group.getLocalGroupName().indexOf("微信") != -1){
						serviceBO.setGoods_name("商户专属码【微信支付】");
					}else{
						serviceBO.setGoods_name(group.getLocalGroupName());
					}
				}
				group.setService(serviceBO);
			}
			*/
		}

		response.setGroupOrderList(groupOrderList);
		return response;
	}
	
	@RequestMapping(value = "/group/order_online/unread_message_count", method = RequestMethod.POST)
	@MethodMapping(desc = "商户消息通知未读数量统计")
	@ResponseBody 
	public MerchantManageResponse queryMerchantNoticeMessageCount() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		int count = noticeMessageService.getReceiveMoneyMessageCount(uid);
		response.setUnreadMessageCount(count);
		return response;
	}

	@RequestMapping(value = "/group/order/details", method = RequestMethod.POST)
	@MethodMapping(desc = "订单详情")
	public @ResponseBody
	MerchantManageResponse orderDetails(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		GroupOrderBO groupBO = groupOrderServer.queryGroupOrderById(orderId);
		com.sinco.carnation.resource.bo.o2o.GroupOrderBO group = mapper.map(groupBO,
				com.sinco.carnation.resource.bo.o2o.GroupOrderBO.class);
		// 判断线上还是线下订单，线下包括优惠买单
		if (groupBO.getOrderType() == 1 || groupBO.getOrderType() == 4 || groupBO.getOrderType() == 5) {
			// 商品信息
			GroupServiceBO serviceBO = JSON.parseObject(group.getGroupInfo(), GroupServiceBO.class);
			group.setService(serviceBO);
		} else {
			GroupServiceBO serviceBO = new GroupServiceBO();
			serviceBO.setGoods_name("");
			serviceBO.setGoods_count(1);
			if (groupBO.getOrderType() != null) {
				if (groupBO.getOrderType() == 1) {
					serviceBO.setGoods_name("线上订单");
				} else if (groupBO.getOrderType() == 2) {
					serviceBO.setGoods_name("扫码支付");
				} else if (groupBO.getOrderType() == 3) {
					serviceBO.setGoods_name("优惠买单");
				} else if (groupBO.getOrderType() == 4) {
					serviceBO.setGoods_name("套餐券");
				} else if (groupBO.getOrderType() == 5) {
					serviceBO.setGoods_name("代金券");
				} else {
					serviceBO.setGoods_name(groupBO.getLocalGroupName());
				}
			}
			group.setService(serviceBO);
			group.setLocalGroupName(serviceBO.getGoods_name());
		}
		// 支付方式
		if (groupBO != null && groupBO.getOrderStatus() > 10) {
			if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(groupBO.getPaymentMark())) {
				group.setPaymentMark("云豆");
			} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(groupBO.getPaymentMark())) {
				group.setPaymentMark("微信");
			} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(groupBO.getPaymentMark())) {
				group.setPaymentMark("支付宝");
			} else if (PaymentConstants.PAYMENT_MARK_YG_WX.equals(groupBO.getPaymentMark())) {
				group.setPaymentMark("云购币+微信");
			} else if (PaymentConstants.PAYMENT_MARK_YG_AL.equals(groupBO.getPaymentMark())) {
				group.setPaymentMark("云购币+支付宝");
			} else {
				group.setPaymentMark("");
			}
		} else {
			group.setPaymentMark("未付款");
		}
		//如果手机号为空，取用户绑定手机号
		if(StringUtils.isBlank(groupBO.getMobile()) && groupBO.getUserId() != null){
			UserAccount user = userAccountService.findUserAccount(groupBO.getUserId(), "2");
			if(user != null){
				group.setMobile(user.getLoginName());
			}
		}
		/*if (StringUtils.isNotBlank(group.getGroupInfo())) {
			// 商品信息
			GroupServiceBO serviceBO = JSON.parseObject(group.getGroupInfo(), GroupServiceBO.class);
			group.setService(serviceBO);
		}*/
		// 券列表
		List<GroupInfoBO> groupInfo = groupInfoService.queryGroupInfoList(groupBO.getId());
		List<OGroupInfoBO> groupInfoBOs = MapperUtils.map(mapper, groupInfo, OGroupInfoBO.class);
		group.setGroupInfoBOs(groupInfoBOs);
		response.setGroupOrderDetails(group);
		return response;
	}

	@RequestMapping(value = "/group/query_goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "服务列表")
	public @ResponseBody
	MerchantManageResponse groupGoodsList(@Valid @ModelAttribute @Param OGroupGoodsVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<GroupGoodsBO> page = new MyPage<GroupGoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		groupGoodsService.queryGroupGoodsPageList(uid, vo.getGoodsType(), vo.getGgStatus(), page);
		List<OGroupGoodsBO> list = MapperUtils.map(mapper, page.getContent(), OGroupGoodsBO.class);
		response.setGroupGoodsBOs(list);
		return response;
	}

	@RequestMapping(value = "/group/query_goods/details", method = RequestMethod.POST)
	@MethodMapping(desc = "服务详情")
	public @ResponseBody
	MerchantManageResponse groupGoodsDetails(
			@Valid @RequestParam(value = "goodsId") @Param(desc = "商品id") Long goodsId) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (goodsId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupGoodsBO goodsBO = groupGoodsService.queryGroupGoodsById(goodsId);
		OGroupGoodsBO groupGoodsBO = mapper.map(goodsBO, OGroupGoodsBO.class);
		if (groupGoodsBO != null) {
			groupGoodsBO.setGroupMobileDesc(JsoupUtils.queryHtml(groupGoodsBO.getGroupMobileDesc()));
		}
		// //主图+获取服务的图片
		// String path=groupGoodsService.getGroupAccessoryByGoodId(goodsId);
		// if(groupGoodsBO != null && StringUtils.isNotBlank(path)){
		// groupGoodsBO.setGroupAccPath(groupGoodsBO.getGroupAccPath()+";"+path);
		// }
		response.setGroupGoodsDetails(groupGoodsBO);
		return response;
	}

	@RequestMapping(value = "/group/query_store/status", method = RequestMethod.POST)
	@MethodMapping(desc = "查询商户审核进度")
	public @ResponseBody
	MerchantManageResponse queryStoreStatus() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		StoreBO store = storeService.queryStoreStatus(uid,true,false);
		if (store != null) {
			ApplyInfoBO applyInfoBO = mapper.map(store, ApplyInfoBO.class);
			// 如果状态为0为提交开店申请，1运营商审批 5平台审核,10第三方支付审核15为正常营业（审核成功），失败原因不返回
			if (applyInfoBO.getStoreStatus() == 0 || applyInfoBO.getStoreStatus() == 1
					|| applyInfoBO.getStoreStatus() == 5 || applyInfoBO.getStoreStatus() == 10
					|| applyInfoBO.getStoreStatus() == 15) {
				applyInfoBO.setFailReseaon("");
			}
			response.setApplyInfo(applyInfoBO);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/voucher/details", method = RequestMethod.POST)
	@MethodMapping(desc = "消费券详情")
	public @ResponseBody
	MerchantManageResponse voucherDetails(
			@Valid @RequestParam(value = "groupSn") @Param(desc = "消费码") String groupSn) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (StringUtils.isBlank(groupSn)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long sellerUid = ActionsUtil.getOwnerUid();
		GroupGoodsBO goodsBO = groupGoodsService.queryGroupDetails(groupSn, sellerUid);
		if (goodsBO == null) {
			response.putErrorMessage("4.group.consumerSure.goods_info_null");
			return response;
		}
		GroupInfoBO infoBO = groupInfoService.queryGroupInfoBySn(sellerUid, groupSn);
		if (infoBO == null) {
			response.putErrorMessage("4.group.consumerSure.goods_info_null");
			return response;
		}
		GroupOrderBO orderBO = groupOrderServer.queryGroupOrderId(infoBO.getOrderId());
		if(orderBO == null){
			response.putErrorMessage("4.group.consumerSure.goods_info_null");
			return response;
		}
//		使用后为1,-1为过期,3申请退款、5退款中、7退款完成
		if(infoBO.getStatus() == 1){
			response.putErrorMessage("4.group.consumerSure.goods_info_used");
			return response;
		}
		if(infoBO.getStatus() == 3){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund_audit");
			return response;
		}
		if(infoBO.getStatus() == 5){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund");
			return response;
		}
		if(infoBO.getStatus() == 7){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund_success");
			return response;
		}
		if(orderBO.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_OVERDUE)){//过期
			response.putErrorMessage("4.group.consumerSure.goods_info_overdue");
			return response;
		}
		if (goodsBO.getStatus() > 0) {

		}
		OGroupGoodsBO groupGoodsBO = mapper.map(goodsBO, OGroupGoodsBO.class);
		response.setGroupGoodsDetails(groupGoodsBO);
		return response;
	}

	@RequestMapping(value = "/group/consumer/sure", method = RequestMethod.POST)
	@MethodMapping(desc = "券消费确认")
	public @ResponseBody
	MerchantManageResponse consumerSure(
			@Valid @RequestParam(value = "groupSn") @Param(desc = "消费码") String groupSn) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (StringUtils.isBlank(groupSn)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		// 检测消费码
		GroupInfoBO infoBO = groupInfoService.queryGroupInfoBySn(uid, groupSn);
		if (infoBO == null) {
			response.putErrorMessage("4.group.consumerSure.goods_info_null");
			return response;
		}
		GroupOrderBO orderBO = groupOrderServer.queryGroupOrderId(infoBO.getOrderId());
		if(orderBO == null){
			response.putErrorMessage("4.group.consumerSure.goods_info_null");
			return response;
		}
//		使用后为1,-1为过期,3申请退款、5退款中、7退款完成
		if(infoBO.getStatus() == 1){
			response.putErrorMessage("4.group.consumerSure.goods_info_used");
			return response;
		}
		if(infoBO.getStatus() == 3){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund_audit");
			return response;
		}
		if(infoBO.getStatus() == 5){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund");
			return response;
		}
		if(infoBO.getStatus() == 7){
			response.putErrorMessage("4.group.consumerSure.goods_info_refund_success");
			return response;
		}
		if(orderBO.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_OVERDUE)){//过期
			response.putErrorMessage("4.group.consumerSure.goods_info_overdue");
			return response;
		}
		try {
			boolean flag = groupInfoService.consumerSure(infoBO);
			if (!flag) {
				this.rebateService.addRebateLog(infoBO.getOrderId(), infoBO.getGroupSn(), "消费返润", false,
						"券消费失败");
				response.putErrorMessage("4.group.consumerSure.goods_info_fail");
				return response;
			}
			// 日志流水
			this.rebateService.addRebateLog(infoBO.getOrderId(), infoBO.getGroupSn(), "消费返润", true, "券消费成功");
		} catch (ServiceException e) {
			this.rebateService.addRebateLog(infoBO.getOrderId(), infoBO.getGroupSn(), "消费返润", false, "券消费失败");
			response.putErrorMessage("4.group.consumerSure.consumersure_fail");
			return response;
		}

		return response;
	}

	/**
	 * 多个消费码
	 * 
	 * @param groupSn
	 * @return
	 */
	@RequestMapping(value = "/group/consumer/sureMulti", method = RequestMethod.POST)
	@MethodMapping(desc = "券消费确认")
	public @ResponseBody
	MerchantManageResponse multiConsumerSure(
			@Valid @RequestParam(value = "multiGroupSn") @Param(desc = "多个消费码") String multiGroupSn) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (StringUtils.isBlank(multiGroupSn)) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		String groupSnArray[] = multiGroupSn.split(",");
		List<String> groupSnList = new ArrayList<String>();
		for (int i = 0, l = groupSnArray.length; i < l; i++) {
			groupSnList.add(groupSnArray[i]);
		}

		List<GroupInfoBO> infoBOList = groupInfoService.queryMultiGroupInfoBySn(uid, groupSnList);

		/*
		 * if (infoBO == null || infoBO.getStatus() != 0) {
		 * response.putErrorMessage("4.group.consumerSure.goods_info_fail");
		 * return response; }
		 */
		// 检测消费码
		if (infoBOList == null || infoBOList.size() < 1) {
			response.putErrorMessage("4.group.consumerSure.goods_info_fail");
			return response;
		}

		for (int i = 0, l = infoBOList.size(); i < l; i++) {
			if (infoBOList.get(i).getStatus() != 0 && infoBOList.get(i).getStatus() != 6) {
				response.putErrorMessage("4.group.consumerSure.goods_info_fail");
				return response;
			}
		}

		for (int i = 0, l = infoBOList.size(); i < l; i++) {
			try {
				boolean flag = groupInfoService.consumerSure(infoBOList.get(i));
				if (!flag) {
					this.rebateService.addRebateLog(infoBOList.get(i).getOrderId(), infoBOList.get(i)
							.getGroupSn(), "消费返润", false, "券消费失败");
					response.putErrorMessage("4.group.consumerSure.goods_info_failMsg");
					return response;
				}
				// 日志流水
				this.rebateService.addRebateLog(infoBOList.get(i).getOrderId(), infoBOList.get(i)
						.getGroupSn(), "消费返润", true, "券消费成功");
				response.setSubMsg("消费成功");
			} catch (ServiceException e) {
				this.rebateService.addRebateLog(infoBOList.get(i).getOrderId(), infoBOList.get(i)
						.getGroupSn(), "消费返润", false, "券消费失败");
				response.putErrorMessage("4.group.consumerSure.consumersure_fail");
				return response;
			}
		}
		return response;
	}

	@RequestMapping(value = "/group/order_cart/pay", method = RequestMethod.POST)
	@MethodMapping(desc = "线下刷卡")
	public @ResponseBody
	MerchantManageResponse payCartOrder(@Valid @ModelAttribute @Param PayCartOrderVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		try {
			Long uid = ActionsUtil.getOwnerUid();
			SysConfigBO config = configService.getSysConfig();
			GroupOrderBO tradeNo = groupOrderServer.linePay(config.getAddress(), vo.getMobile(),
					vo.getGoodsName(), vo.getPrice(), uid);
			if (tradeNo != null && StringUtils.isNotBlank(tradeNo.getTradeNo())) {
				response.setTradeNo(tradeNo.getTradeNo());
				response.setOrderId(tradeNo.getId());
				return response;
			}
			response.putErrorMessage("4.group.payCartOrder.pay_line_not_binding");
		} catch (ServiceException e) {
			response.putErrorMessage("4.group.payCartOrder.pay_line_fail");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/evaluate/list", method = RequestMethod.POST)
	@MethodMapping(desc = "评论列表")
	public @ResponseBody
	MerchantManageResponse evaluate_list(@Valid @ModelAttribute @Param GroupEvaluateVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<GroupEvaluationBO> page = new MyPage<GroupEvaluationBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		GroupEvaluationVO vo1 = new GroupEvaluationVO();
		// 个人
		if (vo.getStoreId() != null) {
			vo1.setStoreId(vo.getStoreId());
		} else {
			// 获取商户的商铺
			StoreBO storeBO = storeService.queryStoreStatus(uid,true,false);
			if (storeBO != null) {
				vo1.setStoreId(storeBO.getId());
			}
		}
		vo1.setStatus(vo.getStatus());

		evaluationService.query(vo1, page);
		List<GroupEvaluateBO> list = MapperUtils.map(mapper, page.getContent(), GroupEvaluateBO.class);
		response.setEvaluateList(list);
		response.setEvaluateTotal(page.getTotalElements());
		return response;
	}

	@RequestMapping(value = "/group/evaluate/save", method = RequestMethod.POST)
	@MethodMapping(desc = "评论保存")
	public @ResponseBody
	MerchantManageResponse saveEvalute(@Valid @ModelAttribute @Param EvaluateVO vo, BindingResult result,
			HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		try {
			evaluationService.reply(uid, vo.getOrderId(), vo.getContext());
		} catch (Exception e) {
			response.putErrorMessage("evaluate save fails");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/consum_share/list", method = RequestMethod.POST)
	@MethodMapping(desc = "消费分润统计总收入")
	public @ResponseBody
	MerchantManageResponse consumptionShare(@Valid @ModelAttribute @Param RebateRecordVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String userType = MoneyUserTypeEnum.O2O.toString();
		if (StringUtils.isNotBlank(vo.getStartTime()) && StringUtils.isNotBlank(vo.getEndTime())) {
			Date startDate = CommUtil.formatDate(vo.getStartTime(), "yyyy-MM-dd HH:mm:ss");
			Date endDate = CommUtil.formatDate(vo.getEndTime(), "yyyy-MM-dd HH:mm:ss");
			if (startDate != null && endDate != null) {
				if (!startDate.before(endDate)) {
					response.putErrorMessage("startTime can't more than endTime!");
					return response;
				}
			}
		}

		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		if (storeBO != null) {
			// RebateRecordBO rebateRecordBO =
			// rebateService.queryrebatesum(storeBO.getId(), vo.getStartTime(),
			// vo.getEndTime());
			RebateRecordBO rebateRecordBO = rebateService.queryrebatesum(uid, vo.getStartTime(),
					vo.getEndTime(), userType);
			if (rebateRecordBO != null) {
				RebateBO rebateBO = mapper.map(rebateRecordBO, RebateBO.class);
				response.setRebateBO(rebateBO);
			}
		}
		return response;
	}

	@RequestMapping(value = "/group/rebate/count", method = RequestMethod.POST)
	@MethodMapping(desc = "消费分润当前年的月统计")
	public @ResponseBody
	MerchantManageResponse queryRebateCount() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String userType = MoneyUserTypeEnum.O2O.toString();
		List<RebateRecordBO> rebateRecordBOs = rebateService.queryRebateCount(uid , userType);
		if (rebateRecordBOs != null && rebateRecordBOs.size() > 0) {
			List<RebateBO> rebateBOs = MapperUtils.map(mapper, rebateRecordBOs, RebateBO.class);
			response.setRebateList(rebateBOs);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/share/details", method = RequestMethod.POST)
	@MethodMapping(desc = "分润明细")
	public @ResponseBody
	MerchantManageResponse queryShareDetails(@Valid @ModelAttribute @Param RebateDetailsVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String userType = MoneyUserTypeEnum.O2O.toString();
		MyPage<RebateRecordBO> page = new MyPage<RebateRecordBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		rebateService.queryShareDetails(uid, null, page, userType);
		List<RebateBO> rebateBOs = MapperUtils.map(mapper, page.getContent(), RebateBO.class);
		for (RebateBO rebateBO : rebateBOs) {
			rebateBO.setRabate(getName(CommUtil.null2Int(rebateBO.getRebateType())));
		}
		response.setRebateList(rebateBOs);
		return response;
	}

	@RequestMapping(value = "/group/order_line/statistics", method = RequestMethod.POST)
	@MethodMapping(desc = "线上服务收入统计")
	public @ResponseBody
	MerchantManageResponse incomeStatistics(@Valid @ModelAttribute @Param RebateRecordVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Date startDate = null;
		Date endDate = null;
		if (StringUtils.isNotBlank(vo.getStartTime()) && StringUtils.isNotBlank(vo.getEndTime())) {
			startDate = CommUtil.formatDate(vo.getStartTime(), "yyyy-MM-dd");
			endDate = CommUtil.formatDate(vo.getEndTime(), "yyyy-MM-dd");
			if (startDate != null && endDate != null) {
				if (!startDate.before(endDate)) {
					response.putErrorMessage("startTime can't more than endTime!");
					return response;
				}
			}
		}

		Long uid = ActionsUtil.getOwnerUid();
		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		if (storeBO != null) {
			BigDecimal goodsProfitAmount = predepService.queryGoodsProfitAmount(UserContants.PD_OP_TYPE_SELL,
					uid, startDate, endDate);// 券收益总额
			// BigDecimal totalPrice =
			// groupOrderServer.queryOrderTotalPrice(vo.getOrderType(),
			// storeBO.getId(), startDate, endDate);
			response.setTotalPrice(goodsProfitAmount);
		}
		return response;
	}

	@RequestMapping(value = "/group/order/statistics", method = RequestMethod.POST)
	@MethodMapping(desc = "线下服务收入统计")
	public @ResponseBody
	MerchantManageResponse incomeOnLimeStatistics(@Valid @ModelAttribute @Param RebateRecordVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Date startDate = null;
		Date endDate = null;
		if (StringUtils.isNotBlank(vo.getStartTime()) && StringUtils.isNotBlank(vo.getEndTime())) {
			startDate = CommUtil.formatDate(vo.getStartTime(), "yyyy-MM-dd HH:mm:ss");
			endDate = CommUtil.formatDate(vo.getEndTime(), "yyyy-MM-dd HH:mm:ss");
			if (startDate != null && endDate != null) {
				if (!startDate.before(endDate)) {
					response.putErrorMessage("startTime can't more than endTime!");
					return response;
				}
			}
		}

		Long uid = ActionsUtil.getOwnerUid();
		// StoreBO storeBO = storeService.queryStoreInfo(uid);
		// if (storeBO != null) {
		// BigDecimal totalPrice =
		// groupOrderServer.queryOrderTotalPrice(vo.getOrderType(),
		// storeBO.getId(), startDate, endDate);
		// response.setTotalPrice(totalPrice);
		// }
		// BigDecimal totalPrice = groupOrderServer.queryPredepositTotal(uid, startDate, endDate);
		// 扫码总额
		// BigDecimal cardAmount = shopQrPayOrderService.findAllPaySuccessMoneyBySellerId(uid
		// ,startDate,null);
		// 统计优惠买单金额
		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		if (storeBO != null) {
			BigDecimal orderAmount = groupOrderServer.staticsDiscountPayAmount(storeBO.getId());
			response.setTotalPrice(orderAmount);
		}
		return response;
	}

	@RequestMapping(value = "/group/order_month/list", method = RequestMethod.POST)
	@MethodMapping(desc = "线上服务月统计")
	public @ResponseBody
	MerchantManageResponse predepMonth() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		String source = ActionsUtil.getOwnerSource();
		List<PredepositLogBO> list = predepService.queryPredeMonth(uid, UserContants.PD_OP_TYPE_SELL,
				UserContant.accountTypeToUserCode(source));
		if (list != null) {
			List<RebateBO> rebateList = MapperUtils.map(mapper, list, RebateBO.class);
			response.setOrderTotalPriceList(rebateList);
		}
		return response;
	}

	@RequestMapping(value = "/group/order_count/list", method = RequestMethod.POST)
	@MethodMapping(desc = "线下服务月统计")
	public @ResponseBody
	MerchantManageResponse queryGroupOrderByMonth(
			@Valid @RequestParam(value = "orderType") @Param(desc = "订单类型") Integer orderType) {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		// StoreBO storeBO = storeService.queryStoreInfo(uid);
		// if (storeBO != null) {
		// List<GroupOrderBO> groupOrderBOs =
		// groupOrderServer.queryGroupOrderByMonth(storeBO.getId(), orderType);
		// if (groupOrderBOs != null && groupOrderBOs.size() > 0) {
		// List<RebateBO> rebateBOs = MapperUtils.map(mapper, groupOrderBOs,
		// RebateBO.class);
		// response.setOrderTotalPriceList(rebateBOs);
		// }
		// }
		List<PredepositPfLogBO> pfLogBOs = groupOrderServer.queryMonthlyPre(uid);
		if (pfLogBOs != null) {
			List<RebateBO> rebateBOs = MapperUtils.map(mapper, pfLogBOs, RebateBO.class);
			response.setOrderTotalPriceList(rebateBOs);
		}
		return response;
	}

	@RequestMapping(value = "/group/order_line/details", method = RequestMethod.POST)
	@MethodMapping(desc = "线上收入明细")
	public @ResponseBody
	MerchantManageResponse groupOrderLineDetails(@Valid @ModelAttribute @Param OrderDetailsVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();
		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		if (storeBO != null) {
			groupOrderServer.groupOrderDetails(storeBO.getId(), vo.getOrderType(), page);
			List<OrderDetailsBO> orderDetailsBOs = MapperUtils.map(mapper, page.getContent(),
					OrderDetailsBO.class);
			for (OrderDetailsBO orderDetailsBO : orderDetailsBOs) {
				if (StringUtils.isNotBlank(orderDetailsBO.getGroupInfo())) {
					// 商品信息
					GroupServiceBO serviceBO = JSON.parseObject(orderDetailsBO.getGroupInfo(),
							GroupServiceBO.class);
					orderDetailsBO.setService(serviceBO);
				}
				// 设置收益价格
				GroupInfoBO infoBO = groupInfoService.findByGroupSN(orderDetailsBO.getGroupSn());
				if (infoBO != null) {
					BigDecimal goodsPrice = orderDetailsBO.getService().getGoods_price();// 服务价格
//					BigDecimal proportionPrice = goodsPrice.multiply(infoBO.getProportion());// 返润金额
					BigDecimal proportionPrice = groupOrderServer.getRebateAmountById(orderDetailsBO.getId(),
							orderDetailsBO.getProportion());// 返润金额
					BigDecimal profitPrice = goodsPrice.subtract(proportionPrice);// 收益价格
					orderDetailsBO.setProfitPrice(profitPrice);
				}
			}
			response.setOrderDetailsList(orderDetailsBOs);
		}

		return response;
	}

	@RequestMapping(value = "/group/order_revenue/details", method = RequestMethod.POST)
	@MethodMapping(desc = "线下收入明细")
	public @ResponseBody
	MerchantManageResponse groupOrderDetails(@Valid @ModelAttribute @Param OrderDetailsVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();
		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		if (storeBO != null) {
			groupOrderServer.queryGroupOrderLineDetails(storeBO.getId(), vo.getOrderType(), page);
			List<OrderDetailsBO> orderDetailsBOs = MapperUtils.map(mapper, page.getContent(),
					OrderDetailsBO.class);
			for (OrderDetailsBO orderDetailsBO : orderDetailsBOs) {
				if (StringUtils.isNotBlank(orderDetailsBO.getGroupInfo())) {
					// 商品信息
					GroupServiceBO serviceBO = JSON.parseObject(orderDetailsBO.getGroupInfo(),
							GroupServiceBO.class);
					orderDetailsBO.setService(serviceBO);
					if (vo.getOrderType() != null) {
						if (vo.getOrderType() == 1) {
							serviceBO.setGoods_name("线上订单");
						} else if (vo.getOrderType() == 2) {
							serviceBO.setGoods_name("扫码支付");
						} else if (vo.getOrderType() == 3) {
							serviceBO.setGoods_name("优惠买单");
						} else if (vo.getOrderType() == 4) {
							serviceBO.setGoods_name("套餐券");
						} else if (vo.getOrderType() == 5) {
							serviceBO.setGoods_name("代金券");
						} else {
							serviceBO.setGoods_name(orderDetailsBO.getLocalGroupName());
						}
					}
				}
				// 设置收益价格
				BigDecimal counterPrice = BigDecimal.ZERO;
				try {
					counterPrice = rebateService.getComissionChargeRebateAmount(orderDetailsBO
							.getTotalPrice());
				} catch (ServiceException e) {
				} // 手续费

				// UserAccount userAccount =
				// account.findByUid(orderDetailsBO.getUserId());
				List<UserAccountBO> userAccount = account.findUserAccountByUid(orderDetailsBO.getUserId());
				BigDecimal profitPrice = BigDecimal.ZERO;
				if (CollectionUtils.isNotEmpty(userAccount)) {
					BigDecimal proportionPrice = groupOrderServer.getRebateAmountById(orderDetailsBO.getId(),
							orderDetailsBO.getProportion());// 返润金额
					// 如果是会员 收益＝订单价格－反润金额－手续费
					if (counterPrice == null) {
						counterPrice = BigDecimal.ZERO;
					}
					if (proportionPrice == null) {
						proportionPrice = BigDecimal.ZERO;
					}
					if (orderDetailsBO.getTotalPrice() == null) {
						orderDetailsBO.setTotalPrice(BigDecimal.ZERO);
					}
//					无论是不是会员 都 无手续费2017.2.27
//					profitPrice = orderDetailsBO.getTotalPrice().subtract(proportionPrice).subtract(counterPrice);
					profitPrice = orderDetailsBO.getTotalPrice().subtract(proportionPrice);
				} else {
					// 如果不是会员 收益＝订单价格－手续费
					if (counterPrice == null) {
						counterPrice = BigDecimal.ZERO;
					}
					if (orderDetailsBO.getTotalPrice() == null) {
						orderDetailsBO.setTotalPrice(BigDecimal.ZERO);
					}
//					profitPrice = orderDetailsBO.getTotalPrice().subtract(counterPrice);
					profitPrice = orderDetailsBO.getTotalPrice();
				}
				// 设置线下订单收益
				orderDetailsBO.setProfitPrice(profitPrice);
			}
			response.setOrderDetailsList(orderDetailsBOs);
		}

		return response;
	}

	@RequestMapping(value = "/group/store_customer/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商户会员")
	public @ResponseBody
	MerchantManageResponse queryStoreCustomer(@Valid @ModelAttribute @Param StoreCustomerVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		MyPage<UserCustomerBO> page = new MyPage<UserCustomerBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		userCustomerService.queryStoreCustomer(uid, vo.getMobile(), page);
		if (page != null && page.getContent().size() > 0) {
			List<StoreCustomerBO> storeCustomerList = MapperUtils.map(mapper, page.getContent(),
					StoreCustomerBO.class);
			response.setStoreCustomerList(storeCustomerList);
		}
		response.setCustomerTotal(page.getTotalElements());
		return response;
	}

	@RequestMapping(value = "/group/store_albun/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商户环境相册")
	public @ResponseBody
	MerchantManageResponse storeAlbum(@Valid @ModelAttribute @Param StoreAccessoryVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<AccessoryBO> page = new MyPage<AccessoryBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		Long sellerUid = ActionsUtil.getOwnerUid();
		// 如果storeId不为空，个人端调用，为空则商会端调用
		if (vo.getStoreId() != null) {
			StoreBO storeBO = storeService.getObjById(vo.getStoreId());
			if (storeBO != null) {
				sellerUid = storeBO.getCreateUserId();
			} else {
				response.putErrorMessage("4.group.storeAlbum.store_find_not");
				return response;
			}
		}

		albumService.getStoreAlbum(sellerUid, page);

		if (page != null && page.getContent().size() > 0) {
			List<StoreAlbumBO> list = MapperUtils.map(mapper, page.getContent(), StoreAlbumBO.class);
			response.setStoreAlbumList(list);
			return response;
		}

		return response;
	}

	@RequestMapping(value = "/group/goods/shelves", method = RequestMethod.POST)
	@MethodMapping(desc = "商品上下架")
	public @ResponseBody
	MerchantManageResponse goodsShelves(
			@Valid @RequestParam(value = "goodsId", required = false) @Param(desc = "商品id") Long goodsId,
			@Valid @RequestParam(value = "goodsStatus") @Param(desc = "状态|0为上架，1为在仓库中，2为定时自动上架，3为店铺过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售") Integer goodsStatus) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (goodsId == null && goodsStatus == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupGoodsBO groupGoodsBO = groupGoodsService.getObjById(goodsId);
		if (groupGoodsBO == null) {
			response.putErrorMessage("goods can't not !");
			return response;
		}
		groupGoodsBO.setGgStatus(goodsStatus);
		groupGoodsService.goodsShelves(groupGoodsBO);
		this.storeSearchService.updateIndex(groupGoodsBO.getStoreId());
		return response;
	}

	// @RequestMapping(value = "/group/line_pay/return", method =
	// RequestMethod.POST)
	// @MethodMapping(desc = "线下支付回调")
	// public @ResponseBody MerchantManageResponse returnLinePay(@Valid
	// @RequestParam(value = "out_trade_no") @Param(desc = "订单号") String
	// out_trade_no) {
	// MerchantManageResponse response = new MerchantManageResponse();
	// if (StringUtils.isBlank(out_trade_no)) {
	// response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
	// return response;
	// }
	// GroupOrderBO groupOrder = groupOrderServer.findByTradeNo(out_trade_no);
	// if (groupOrder != null) {
	// // 更新订单状态
	// groupOrder.setOrderStatus(20);
	// groupOrderServer.save(groupOrder);
	// }
	// return response;
	// }

	@SuppressWarnings("unused")
	@RequestMapping(value = "/group/money/cash", method = RequestMethod.POST)
	@MethodMapping(desc = "提现")
	public @ResponseBody
	MerchantManageResponse cashMoney(@Valid @ModelAttribute @Param CashMoneyVO vo, BindingResult result,
			HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		if(vo == null || null == vo.getCashAmount() ||vo.getCashAmount()<=0){
			response.putErrorMessage("4.operator.cashMoney.money_error");
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		String source = ActionsUtil.getOwnerSource();
		boolean pwdNull = userMoneyService.isPasswordNull(uid, source);
		if (account.findByUid(uid, UserContant.ACCOUNT_TYPE_8) == null) {
			if (pwdNull) {// 密码不为空
				response.putErrorMessage("4.group.cashMoney.cash_passwor_not_exist");
				return response;
			}
		}
		PredepositCashVO preVo = mapper.map(vo, PredepositCashVO.class);

		try {
			String num = userMoneyService.userCashApplyV2(uid, preVo, source);
		} catch (ServiceException e) {
			Map<String, String> param = Maps.newHashMap();
			param.put("msg", e.getErrorCode());
			response.putErrorMessage("4.group.cashMoney.Password_is_wrong", param);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/predeposit/list", method = RequestMethod.POST)
	@MethodMapping(desc = "提现记录")
	public @ResponseBody
	MerchantManageResponse getPredepositLogList(@Valid @ModelAttribute @Param PredepositLogVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<PredepositCashBO> page = new MyPage<PredepositCashBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(page.getPageSize());

		Long uid = ActionsUtil.getOwnerUid();

		predepositCashService.findPredepositPageList(uid, page);

		if (page != null && page.getContent().size() > 0) {
			List<UPrepositCashBO> list = MapperUtils.map(mapper, page.getContent(), UPrepositCashBO.class);
			response.setPreCashList(list);
		}

		return response;
	}

	@RequestMapping(value = "/group/group_class/list", method = RequestMethod.POST)
	@MethodMapping(desc = "店铺主营类目")
	public @ResponseBody
	MerchantManageResponse groupClassList(
			@Valid @RequestParam(value = "parentId", required = false) @Param(desc = "父id") Long parentId,
			@Valid @RequestParam(value = "ret") @Param(desc = "类别1主类目(parentId不用传)2详细类目") Integer ret) {
		MerchantManageResponse response = new MerchantManageResponse();
		MyPage<GroupClassBO> page = new MyPage<GroupClassBO>();
		page.setPageNumber(1);
		page.setPageSize(8);

		if (ret == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		// 主营类目
		if (ret == 1) {
			List<GroupClassBO> classList = groupClassService.findCacheRoot();
			// groupClassService.queryGroupClassList(page);
			// if (page != null && page.getContent().size() > 0) {
			List<com.sinco.carnation.resource.bo.o2o.GroupClassBO> groupClassBOs = MapperUtils.map(mapper,
					classList, com.sinco.carnation.resource.bo.o2o.GroupClassBO.class);
			response.setGroupClassList(groupClassBOs);
			// }
		} else if (ret == 2) {// 详细类目
			List<GroupClassBO> classList = null;
			GroupClassBO selectGc = groupClassService.findTreeCacheById(parentId);
			if (selectGc.getParentId() != null) {
				classList = groupClassService.findCahceByParent(selectGc.getParentId());
			} else {
				classList = Lists.newArrayList(selectGc.getChilds());
			}
			// List<GroupClassBO> classList =
			// groupClassService.findByParent(parentId);
			// if (classList != null && classList.size() > 0) {
			List<com.sinco.carnation.resource.bo.o2o.GroupClassBO> list = MapperUtils.map(mapper, classList,
					com.sinco.carnation.resource.bo.o2o.GroupClassBO.class);
			response.setClassDetails(list);
			// }
		}

		return response;
	}

	@RequestMapping(value = "/group/area/list", method = RequestMethod.POST)
	@MethodMapping(desc = "获取地区")
	public @ResponseBody
	MerchantManageResponse getAreaList(@Valid @RequestParam(value = "ret") @Param(desc = "层级") Integer ret,
			@Valid @RequestParam(value = "ret") @Param(desc = "父级id") Long parentId) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (ret == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		List<Area> list = areaService.getAreaList(ret, parentId);
		if (list != null && list.size() > 0) {
			List<GroupAreaBO> areaBOs = MapperUtils.map(mapper, list, GroupAreaBO.class);
			response.setAreaList(areaBOs);
		}
		return response;
	}
	
	@RequestMapping(value = "/group/checkIn/save", method = RequestMethod.POST)
	@MethodMapping(desc = "商家入驻")
	public @ResponseBody
	MerchantManageResponse groupCheckIn(@Valid @ModelAttribute @Param StoreInfoVO vo, BindingResult result,
			HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		
		//推荐运营商校验 add by yuleijia 2017.4.20
		String recommend = null;
		if (vo.getRecommend() != null) {
			recommend = vo.getRecommend().toUpperCase();
		}
		
		if(null!=recommend && recommend.trim().length() > 0)
		{
			logger.debug("============ recommend->"+recommend);
			OperatorBO operator = null;
			if(recommend.startsWith(UserContant.ACCOUNT_TYPE_CN))
			{
				operator = this.operatorService.selectOperatorByCnUserName(recommend);
				if(operator!=null)
				{
					UserAccount cn_userAccount = this.userAccountService.get_CN_User(operator.getUserId());
					if(cn_userAccount==null)
					{
						response.setErrorCode("404");
						response.putErrorMessage("4.user.operator.non_existent"); //您输入的邀请码不正确！请确认后再重新提交！
						logger.debug("============ 推荐运营商编号有误或不存在 ErrorCode->"+response.getErrorCode());
						return response;
					}
					//运营商级别：1市级运营商，2区级运营商，3VIP经销商，7金卡经销商，9银卡经销商
					String level = operator.getLevel();
					if(level!=null && level.equals(OperatorContants.OPERATOR_LEVEL_9))
					{
						response.setErrorCode("600");
						response.putErrorMessage("4.user.operator.unable_to_sign_business");  //该经销商是银卡级别，不能签约商户
						logger.debug(">>>>>>>>>>>>>> 该经销商是银卡级别，不能签约商户  ErrorCode->"+response.getErrorCode());
						return response;
					}
					else if(level!=null && level.equals(OperatorContants.OPERATOR_LEVEL_3))
					{
						if(this.is_First_Landing(operator.getUserId()))  //推荐运营商未登录过运营商系统 提示推荐运营商还未登录登录完善个人信息
						{
							response.setErrorCode("601");
							response.putErrorMessage("4.user.operator.notLogin");  //VIP卡用户  检查之前是否已有登录过运营商平台系统
							logger.debug(">>>>>>>>>>>>>> VIP卡用户  未完善运营商平台系统信息  ErrorCode->"+response.getErrorCode());
							return response;
						}
					}
					else if(level!=null && level.equals(OperatorContants.OPERATOR_LEVEL_7))
					{
						if(this.is_First_Landing(operator.getUserId()))  //推荐运营商未登录过运营商系统 提示推荐运营商还未登录登录完善个人信息
						{
							response.setErrorCode("602");
							response.putErrorMessage("4.user.operator.notLogin");  //金卡用户  检查之前是否已有登录过运营商平台系统
							logger.debug(">>>>>>>>>>>>>>  金卡用户  未完善运营商平台系统信息   ErrorCode->"+response.getErrorCode());
							return response;
						}
					}
					
				}
			}
			else
			{
				operator = this.operatorService.queryOperatorByOperatorCode(recommend);
			}
			if(operator==null)
			{
				response.setErrorCode("404");
				response.putErrorMessage("4.user.operator.non_existent"); //推荐运营商编号有误或不存在
				logger.debug(">>>>>>>>>>>>>> 推荐运营商编号有误或不存在 ErrorCode->"+response.getErrorCode());
				return response;
			}
			if(operator!=null)
			{
				String level = operator.getLevel();
				if(level==null)
				{
					response.setErrorCode("502");
					response.putErrorMessage("4.operator.not.recommend");
					logger.debug(">>>>>>>>> operator【level is null】");
					return response;
				}
				//运营商所在区域
				String operatorAreaId  = operator.getOperatorAreaId();
				Long operatorAreaIdL = operatorAreaId!=null?Long.parseLong(operatorAreaId):0L;
				Area area = (Area) dicContent.getDic(Area.class, String.valueOf(vo.getAreaId()));
				String cityCode = null;
				if (area != null) {
					cityCode = area.getParentCode();
				}
				if (cityCode == null) {
					response.setErrorCode("502");
					response.putErrorMessage("4.areaID.error"); //运营商只能签约辖区内的商户
					logger.debug(">>>>>> 地域信息为空  ErrorCode->"+response.getErrorCode());
					return response;
				}
				if(operator.getLevel().equals(String.valueOf(UserContants.OPERATOR_LEVEL_SHI)))
				{
					if (!cityCode.equals(operator.getOperatorAreaId()))
					{
						logger.debug(">>>>>> 市级运营商->入驻用户不在推荐运营商辖区内 ");
						response.setErrorCode("502");
						response.putErrorMessage("4.user.operator.cannot_sign"); //运营商只能签约辖区内的商户
						return response;
					}
				}
				else
				{
					Area area001 = (Area) dicContent.getDic(Area.class, String.valueOf(operatorAreaIdL));
					String operatorCityCode = null;
					if(area001!=null)
					{
						operatorCityCode = area001.getParentCode();
					}
					/*OperatorBO parentShi =this.userOwnService.getParentOperator(operatorAreaIdL,UserContants.OPERATOR_LEVEL_SHI);
					if (parentShi != null)
					{*/
						if (!cityCode.equals(operatorCityCode)) {
							logger.debug(">>>>>> 入驻用户推荐运营商不能跨市");
							response.setErrorCode("502");
							response.putErrorMessage("4.user.operator.cannot_sign"); //运营商只能签约辖区内的商户
							return response;
						}
					/*}*/
				}
			}
		}
		StoreApplyVO apply = new StoreApplyVO();
		apply.setLicenseCMobile(vo.getLicenseCMobile());
		apply.setIsEepay(vo.getIsEepay());
		apply.setLicenseLegalIdCardFrontPath(vo.getLicenseLegalIdCardFrontPath());
		apply.setLicenseLegalIdCardBackPath(vo.getLicenseLegalIdCardBackPath());
		apply.setStoreName(vo.getStoreName());
		apply.setLicenseCName(vo.getStoreName());//入驻时候全称LicenseCName  简称StoreName默认为一个值
		apply.setIndustry(vo.getIndustry());
		apply.setLicenseBusinessScope(vo.getLicenseBusinessScope());
		apply.setLicenseCDesc(vo.getLicenseCDesc());
		apply.setGroupMainId(vo.getGcMainId());
		apply.setGroupDetailInfo(vo.getGroupDetailInfo().split(","));
		apply.setAreaId(vo.getAreaId());
		apply.setStoreAddress(vo.getStoreAddress());
		apply.setStoreTelephone(vo.getStoreTelephone());
		BigDecimal v3 = null;
		BigDecimal v1 = new BigDecimal(100);
		if(vo.getCommissionRebate()!=null){
			BigDecimal v2 = new BigDecimal(vo.getCommissionRebate());
			v3 = v2.divide(v1).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		apply.setCommissionRebate(v3);
		apply.setBankAccountName(vo.getBankAccountName());
		apply.setBankCAccount(vo.getBankCAccount());
		apply.setBankName(vo.getBankName());
		apply.setOtherPhotoPath(vo.getOtherPhotoPath());

		apply.setBankCardFrontPath(vo.getBankCardFrontPath());
		apply.setBankCardBackPath(vo.getBankCardBackPath());
		apply.setLicenseImagePath(vo.getLicenseImagePath());
		/*apply.setOperateNumber(vo.getOperateNumber());*/
		apply.setOperateNumber(vo.getRecommend());//推荐运营商
		apply.setStoreLat(new BigDecimal(vo.getStoreLat()));
		apply.setStoreLon(new BigDecimal(vo.getStoreLon()));
		BigDecimal v4 = null;
		if(vo.getGroupDiscount()!=null)
		{
			BigDecimal v2 = new BigDecimal(vo.getGroupDiscount());
			v4 = v2.divide(v1).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		apply.setGroupDiscount(v4);
		apply.setStoreOwerCard(vo.getCardCode());
		apply.setBankAreaId(vo.getBankAreaId());
		if(vo.getLicenseCName()==null || vo.getLicenseCName().trim().length() < 0)
		{
			apply.setLicenseCName(vo.getStoreName());
		}
		else
		{
			apply.setLicenseCName(vo.getLicenseCName());
		}
		apply.setBusinessPlacePhotoPath(vo.getBusinessPlacePhotoPath());
		// 如果有poss机
		if ( vo.getIndustry()!=null && vo.getIsEepay()) {
			if (StringUtils.isBlank(vo.getLicenseLegalIdCardReachPath())) {
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
				return response;
			}
			// else if (StringUtils.isBlank(vo.getBusinessPlacePhotoPath())) {
			// response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			// return response;
			// }
			apply.setLicenseLegalIdCardReachPath(vo.getLicenseLegalIdCardReachPath());
//			apply.setBusinessPlacePhotoPath(vo.getBusinessPlacePhotoPath());
		}
		try {
			StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);//需要修改
			//this.storeService.
			
			boolean flag = false;
			if (storeBO != null)
				flag = storeService.applyStore(apply, uid, storeBO.getId());
			else
				flag = storeService.applyStore(apply, uid);
			response.setStoreCheckIn(flag);
		} catch (ServiceException e) {
			Map<String, String> param = Maps.newHashMap();
			param.put("msg", e.getErrorCode());
			response.putErrorMessage("4.group.groupCheckIn.store_check_in_fails", param);
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/group/goods_refund/list", method = RequestMethod.POST)
	@MethodMapping(desc = "服务退款列表")
	public @ResponseBody
	MerchantManageResponse queryRefundgoodsPageList(@Valid @ModelAttribute @Param GoodsRefundVO vo,
			BindingResult result, HttpServletRequest request) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<GroupGoodsBO> page = new MyPage<GroupGoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		Long uid = ActionsUtil.getOwnerUid();
		StoreBO storeBO = storeService.queryStoreInfo(uid,true,false);
		groupGoodsService.queryRefundgoodsPageList(storeBO.getId(), page);
		if (page != null && page.getContent().size() > 0) {
			List<GoodsRefundBO> refundBOs = MapperUtils.map(mapper, page.getContent(), GoodsRefundBO.class);
			for(GoodsRefundBO bo : refundBOs){
				//app显示折扣价格，免发版本处理
				bo.setCostPrice(bo.getGroupPrice());
			}
			response.setRefundBOs(refundBOs);
		}
		return response;
	}

	@RequestMapping(value = "/group/order_refund/save", method = RequestMethod.POST)
	@MethodMapping(desc = "线下退款")
	public @ResponseBody
	MerchantManageResponse refundLinePay(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupOrderBO orderBO = groupOrderServer.queryGroupOrderById(orderId);
		if (orderBO != null) {
			orderBO.setLocalReturnStatus(2);
			groupOrderServer.save(orderBO);
		}
		return response;
	}

	@RequestMapping(value = "/group/order/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取订单状态")
	public @ResponseBody
	MerchantManageResponse getOrderStatus(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		MerchantManageResponse response = new MerchantManageResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GroupOrderBO orderBO = groupOrderServer.getGroupOrderById(orderId);
		if (orderBO != null) {
			response.setOrderStatus(orderBO.getOrderStatus());
			// TODO
			// 临时处理，app端是根据状态=20来判断是否成功支付
			// 下个版本恢复
			if (orderBO.getOrderStatus() == 30) {
				response.setOrderStatus(20);
			}
		}
		return response;
	}

	@RequestMapping(value = "/group/store_info/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取商户信息")
	public @ResponseBody
	MerchantManageResponse storeInfoGet() {
		MerchantManageResponse response = new MerchantManageResponse();
		Long uid = ActionsUtil.getOwnerUid();
		StoreApplyInfoBO applyInfoBO = storeService.queryStoreApplyInfo(uid,true,false);
		if (applyInfoBO != null) {
			StoreAppInfoBO infoBO = mapper.map(applyInfoBO, StoreAppInfoBO.class);
			// 获取商户地区
			infoBO.setArea(areaService.fullName(applyInfoBO.getAreaId()));
			// 设置主营类目
			GroupClassBO classBO = groupClassService.findTreeCacheById(applyInfoBO.getGroupMainId());
			infoBO.setCategory(classBO.getGcName());
			// 设置开户行地址
			infoBO.setBankAreaName(areaService.areaName(applyInfoBO.getBankAreaId()));
			// 设置详细类目
			String classNames = "";
			if (StringUtils.isNotBlank(applyInfoBO.getGroupDetailInfo())) {
				String[] ids = applyInfoBO.getGroupDetailInfo().split(",");
				for (int i = 0; i < ids.length; i++) {
					GroupClassBO classBO2 = groupClassService.findTreeCacheById(CommUtil.null2Long(ids[i]));
					if (classBO2 != null) {
						if (i == ids.length - 1)
							classNames += classBO2.getGcName();
						else
							classNames += classBO2.getGcName() + ",";
					}
				}
			}
			infoBO.setDetailsInfos(classNames);
			response.setStoreAppInfoBo(infoBO);
		}
		return response;
	}

	public String getName(Integer num) {
		String mesage = null;
		switch (num) {
			case 101:
				mesage = "会员消费返润";
				break;
			case 102:
				mesage = "注册会员返润";
				break;
			case 103:
				mesage = "会员管理返润";
				break;
			case 104:
				mesage = "注册店返润";
				break;
			case 105:
				mesage = "终端管理返润";
				break;
			case 106:
				mesage = "注册关联返润";
				break;
			case 107:
				mesage = "区级管理返润";
				break;
			case 108:
				mesage = "市级管理返润";
				break;
			case 109:
				mesage = "注册店返润";
				break;
			case 110:
				mesage = "终端服务返润";
				break;
			case 111:
				mesage = "区级服务返润";
				break;
			case 112:
				mesage = "市级服务返润";
				break;
			case 201:
				mesage = "终端手续费返润";
				break;
			case 202:
				mesage = "区级手续费返润";
				break;
			case 203:
				mesage = "市级手续费返润";
				break;
			case 204:
				mesage = "推荐人手续费返润";
				break;
			default:
				mesage = "金额";
				break;
		}
		return mesage;
	}
	/**
	 * 判断CN账户是否首次登陆
	 * @param uid
	 * @return false:不是 true:是
	 */
	public boolean is_First_Landing(Long uid) {
		logger.info("<<<<<<<<<<<< uid->" + uid);
		UserAccount cn_userAccount = this.userAccountService.get_CN_User(uid);
		String loginName = cn_userAccount.getLoginName();
		OperatorBO operator = this.operatorService.queryOperatorByLoginName(loginName);
		// 身份证为必填项 CN账户在APP或PC首次登陆时系统会为CN账户初始化YY账户 初始化时 身份证号为空
		String idCard = operator.getIdCard();
		if (null == idCard || idCard.trim().length() <= 0) // 首次登陆
		{
			return true;
		}
		return false;
	}

	// @RequestMapping(value="/group/test",method=RequestMethod.POST)
	// @MethodMapping(desc="收益")
	// public @ResponseBody MerchantManageResponse dd(){
	// MerchantManageResponse response=new MerchantManageResponse();
	// GroupOrderBO groupOrderBO =
	// groupOrderServer.findByOrderNo("2782015092818381825");
	// try {
	// int num = rebateService.lineProfit(1d, groupOrderBO);
	// System.out.println("========"+num);
	// } catch (ServiceException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return response;
	// }
	
	public static void main(String[] args)
	{
		BigDecimal v1 = new BigDecimal(100);
		BigDecimal v2 = new BigDecimal(80);
		BigDecimal v3 = v2.divide(v1).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(v3);
		
		String t = "YY1234565";
		System.out.println(t.startsWith("CN"));
	}
}
