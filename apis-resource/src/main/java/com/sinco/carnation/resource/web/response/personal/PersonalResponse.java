package com.sinco.carnation.resource.web.response.personal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.MyselfGroupOrderBO;
import com.sinco.carnation.resource.bo.personal.MyselfGroupOrderLineBO;
import com.sinco.carnation.resource.bo.personal.PGroupBO;
import com.sinco.carnation.resource.bo.personal.PGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.POrderDetailsBO;
import com.sinco.carnation.resource.bo.personal.PayPageBO;

public class PersonalResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("areaBO")
	@ReturnMapping(desc = "地区")
	private GroupAreaBO areaBO;

	@JsonProperty("groupGoodsBOs")
	@ReturnMapping(desc = "促销推荐")
	private List<PGroupGoodsBO> groupGoodsBOs;

	@JsonProperty("hotCityList")
	@ReturnMapping(desc = "热门城市")
	public List<GroupAreaBO> hotCityList;

	@JsonProperty("storeInfo")
	@ReturnMapping(desc = "店铺详情")
	private PGroupBO storeInfo;

	@JsonProperty("youLikeGoods")
	@ReturnMapping(desc = "服务详情")
	private OGroupGoodsBO goodsDetails;

	@JsonProperty("myselfOrderList")
	@ReturnMapping(desc = "个人线上订单列表")
	private List<MyselfGroupOrderBO> myselfOrderList;

	@JsonProperty("myselfOrderLineList")
	@ReturnMapping(desc = "个人线下订单列表")
	private List<MyselfGroupOrderLineBO> myselfOrderLineList;

	@JsonProperty("orderDetails")
	@ReturnMapping(desc = "订单详情")
	private POrderDetailsBO orderDetails;

	@JsonProperty("groupGoods")
	@ReturnMapping(desc = "立即购买")
	private PGroupGoodsBO groupGoods;

	@JsonProperty("payPage")
	@ReturnMapping(desc = "支付页面")
	private PayPageBO payPage;

	@JsonProperty("isOff")
	@ReturnMapping(desc = "根据发布时间判断是否能购买")
	private boolean isOff;

	public GroupAreaBO getAreaBO() {
		return areaBO;
	}

	public void setAreaBO(GroupAreaBO areaBO) {
		this.areaBO = areaBO;
	}

	public List<PGroupGoodsBO> getGroupGoodsBOs() {
		return groupGoodsBOs;
	}

	public void setGroupGoodsBOs(List<PGroupGoodsBO> groupGoodsBOs) {
		this.groupGoodsBOs = groupGoodsBOs;
	}

	public List<GroupAreaBO> getHotCityList() {
		return hotCityList;
	}

	public void setHotCityList(List<GroupAreaBO> hotCityList) {
		this.hotCityList = hotCityList;
	}

	public PGroupBO getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(PGroupBO storeInfo) {
		this.storeInfo = storeInfo;
	}

	public OGroupGoodsBO getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(OGroupGoodsBO goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public List<MyselfGroupOrderBO> getMyselfOrderList() {
		return myselfOrderList;
	}

	public void setMyselfOrderList(List<MyselfGroupOrderBO> myselfOrderList) {
		this.myselfOrderList = myselfOrderList;
	}

	public List<MyselfGroupOrderLineBO> getMyselfOrderLineList() {
		return myselfOrderLineList;
	}

	public void setMyselfOrderLineList(List<MyselfGroupOrderLineBO> myselfOrderLineList) {
		this.myselfOrderLineList = myselfOrderLineList;
	}

	public POrderDetailsBO getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(POrderDetailsBO orderDetails) {
		this.orderDetails = orderDetails;
	}

	public PGroupGoodsBO getGroupGoods() {
		return groupGoods;
	}

	public void setGroupGoods(PGroupGoodsBO groupGoods) {
		this.groupGoods = groupGoods;
	}

	public PayPageBO getPayPage() {
		return payPage;
	}

	public void setPayPage(PayPageBO payPage) {
		this.payPage = payPage;
	}

	public boolean isOff() {
		return isOff;
	}

	public void setOff(boolean isOff) {
		this.isOff = isOff;
	}

}
