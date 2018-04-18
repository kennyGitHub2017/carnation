package com.sinco.carnation.resource.web.response.o2o;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.ApplyInfoBO;
import com.sinco.carnation.resource.bo.o2o.GoodsRefundBO;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.GroupClassBO;
import com.sinco.carnation.resource.bo.o2o.GroupEvaluateBO;
import com.sinco.carnation.resource.bo.o2o.GroupOrderBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.o2o.OrderDetailsBO;
import com.sinco.carnation.resource.bo.o2o.RebateBO;
import com.sinco.carnation.resource.bo.o2o.StoreAlbumBO;
import com.sinco.carnation.resource.bo.o2o.StoreAppInfoBO;
import com.sinco.carnation.resource.bo.o2o.StoreCustomerBO;
import com.sinco.carnation.resource.bo.o2o.StoreIndexBO;
import com.sinco.carnation.resource.bo.o2o.UPrepositCashBO;

public class MerchantManageResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("merchant")
	@ReturnMapping(desc = "商户首页")
	private StoreIndexBO merchant;

	@JsonProperty("groupOrderList")
	@ReturnMapping(desc = "订单列表")
	private List<GroupOrderBO> groupOrderList;

	@JsonProperty("groupOrderBO")
	@ReturnMapping(desc = "订单详情")
	private GroupOrderBO groupOrderDetails;

	@JsonProperty("groupGoodsBOs")
	@ReturnMapping(desc = "服务列表")
	private List<OGroupGoodsBO> groupGoodsBOs;

	@JsonProperty("groupGoodsDetails")
	@ReturnMapping(desc = "服务详情")
	private OGroupGoodsBO groupGoodsDetails;

	@JsonProperty("applyInfo")
	@ReturnMapping(desc = "商户申请")
	private ApplyInfoBO applyInfo;

	@JsonProperty("evaluateList")
	@ReturnMapping(desc = "评论列表")
	private List<GroupEvaluateBO> evaluateList;

	@JsonProperty("rebateBO")
	@ReturnMapping(desc = "消费分润")
	private RebateBO rebateBO;

	@JsonProperty("rebateList")
	@ReturnMapping(desc = "当年消费分润统计")
	private List<RebateBO> rebateList;

	@JsonProperty("totalPrice")
	@ReturnMapping(desc = "线上线下收入总额")
	private BigDecimal totalPrice;

	@JsonProperty("orderTotalPriceList")
	@ReturnMapping(desc = "线下收入月统计")
	private List<RebateBO> orderTotalPriceList;

	@JsonProperty("orderDetailsList")
	@ReturnMapping(desc = "线上线下收入明细")
	private List<OrderDetailsBO> orderDetailsList;

	@JsonProperty("storeCustomerList")
	@ReturnMapping(desc = "店铺会员列表")
	private List<StoreCustomerBO> storeCustomerList;

	@JsonProperty("storeAlbumList")
	@ReturnMapping(desc = "商户环境相册")
	private List<StoreAlbumBO> storeAlbumList;

	@JsonProperty("tradeNo")
	@ReturnMapping(desc = "tradeNo")
	private String tradeNo;

	@JsonProperty("preCashList")
	@ReturnMapping(desc = "提现记录")
	private List<UPrepositCashBO> preCashList;

	@JsonProperty("groupClassList")
	@ReturnMapping(desc = "店铺主营类目")
	private List<GroupClassBO> groupClassList;

	@JsonProperty("areaBOs")
	@ReturnMapping(desc = "地区")
	public List<GroupAreaBO> areaList;

	@JsonProperty("classDetails")
	@ReturnMapping(desc = "详细类目")
	private List<GroupClassBO> classDetails;

	@JsonProperty("evaluateTotal")
	@ReturnMapping(desc = "评论总数")
	private Long evaluateTotal;

	@JsonProperty("customerTotal")
	@ReturnMapping(desc = "会员总数")
	private Long customerTotal;

	@JsonProperty("refundBOs")
	@ReturnMapping(desc = "线上服务退款列表")
	private List<GoodsRefundBO> refundBOs;

	@JsonProperty("orderStatus")
	@ReturnMapping(desc = "订单状态|订单状态，0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价")
	private Integer orderStatus;

	@JsonProperty("orderId")
	@ReturnMapping(desc = "订单id")
	private Long orderId;

	@JsonProperty("storeAppInfoBo")
	@ReturnMapping(desc = "商户信息")
	private StoreAppInfoBO storeAppInfoBo;

	@JsonProperty("storeCheckIn")
	@ReturnMapping(desc = "商家入驻")
	private boolean storeCheckIn;

	@JsonProperty("isCN")
	@ReturnMapping(desc = "是否CN账号")
	private boolean isCN;
	
	@JsonProperty("unreadMessage")
	@ReturnMapping(desc = "未读消息数量")
	private Integer unreadMessageCount;

	public List<GroupOrderBO> getGroupOrderList() {
		return groupOrderList;
	}

	public void setGroupOrderList(List<GroupOrderBO> groupOrderList) {
		this.groupOrderList = groupOrderList;
	}

	public GroupOrderBO getGroupOrderDetails() {
		return groupOrderDetails;
	}

	public void setGroupOrderDetails(GroupOrderBO groupOrderDetails) {
		this.groupOrderDetails = groupOrderDetails;
	}

	public List<OGroupGoodsBO> getGroupGoodsBOs() {
		return groupGoodsBOs;
	}

	public void setGroupGoodsBOs(List<OGroupGoodsBO> groupGoodsBOs) {
		this.groupGoodsBOs = groupGoodsBOs;
	}

	public OGroupGoodsBO getGroupGoodsDetails() {
		return groupGoodsDetails;
	}

	public void setGroupGoodsDetails(OGroupGoodsBO groupGoodsDetails) {
		this.groupGoodsDetails = groupGoodsDetails;
	}

	public ApplyInfoBO getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfoBO applyInfo) {
		this.applyInfo = applyInfo;
	}

	public List<GroupEvaluateBO> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<GroupEvaluateBO> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public RebateBO getRebateBO() {
		return rebateBO;
	}

	public void setRebateBO(RebateBO rebateBO) {
		this.rebateBO = rebateBO;
	}

	public List<RebateBO> getRebateList() {
		return rebateList;
	}

	public void setRebateList(List<RebateBO> rebateList) {
		this.rebateList = rebateList;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<RebateBO> getOrderTotalPriceList() {
		return orderTotalPriceList;
	}

	public void setOrderTotalPriceList(List<RebateBO> orderTotalPriceList) {
		this.orderTotalPriceList = orderTotalPriceList;
	}

	public List<OrderDetailsBO> getOrderDetailsList() {
		return orderDetailsList;
	}

	public void setOrderDetailsList(List<OrderDetailsBO> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}

	public List<StoreCustomerBO> getStoreCustomerList() {
		return storeCustomerList;
	}

	public void setStoreCustomerList(List<StoreCustomerBO> storeCustomerList) {
		this.storeCustomerList = storeCustomerList;
	}

	public List<StoreAlbumBO> getStoreAlbumList() {
		return storeAlbumList;
	}

	public void setStoreAlbumList(List<StoreAlbumBO> storeAlbumList) {
		this.storeAlbumList = storeAlbumList;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public List<UPrepositCashBO> getPreCashList() {
		return preCashList;
	}

	public void setPreCashList(List<UPrepositCashBO> preCashList) {
		this.preCashList = preCashList;
	}

	public StoreIndexBO getMerchant() {
		return merchant;
	}

	public void setMerchant(StoreIndexBO merchant) {
		this.merchant = merchant;
	}

	public List<GroupClassBO> getGroupClassList() {
		return groupClassList;
	}

	public void setGroupClassList(List<GroupClassBO> groupClassList) {
		this.groupClassList = groupClassList;
	}

	public List<GroupAreaBO> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<GroupAreaBO> areaList) {
		this.areaList = areaList;
	}

	public List<GroupClassBO> getClassDetails() {
		return classDetails;
	}

	public void setClassDetails(List<GroupClassBO> classDetails) {
		this.classDetails = classDetails;
	}

	public Long getEvaluateTotal() {
		return evaluateTotal;
	}

	public void setEvaluateTotal(Long evaluateTotal) {
		this.evaluateTotal = evaluateTotal;
	}

	public Long getCustomerTotal() {
		return customerTotal;
	}

	public void setCustomerTotal(Long customerTotal) {
		this.customerTotal = customerTotal;
	}

	public List<GoodsRefundBO> getRefundBOs() {
		return refundBOs;
	}

	public void setRefundBOs(List<GoodsRefundBO> refundBOs) {
		this.refundBOs = refundBOs;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public StoreAppInfoBO getStoreAppInfoBo() {
		return storeAppInfoBo;
	}

	public void setStoreAppInfoBo(StoreAppInfoBO storeAppInfoBo) {
		this.storeAppInfoBo = storeAppInfoBo;
	}

	public boolean isStoreCheckIn() {
		return storeCheckIn;
	}

	public void setStoreCheckIn(boolean storeCheckIn) {
		this.storeCheckIn = storeCheckIn;
	}

	public boolean isCN() {
		return isCN;
	}

	public void setCN(boolean isCN) {
		this.isCN = isCN;
	}

	public Integer getUnreadMessageCount() {
		return unreadMessageCount;
	}

	public void setUnreadMessageCount(Integer unreadMessageCount) {
		this.unreadMessageCount = unreadMessageCount;
	}

}
