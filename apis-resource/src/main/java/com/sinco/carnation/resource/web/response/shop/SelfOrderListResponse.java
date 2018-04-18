package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.search.EvaluatePageBO;
import com.sinco.carnation.resource.bo.self.FavaStoreBO;
import com.sinco.carnation.resource.bo.self.OrderFormDetailBO;
import com.sinco.carnation.resource.bo.self.SelfOrderBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;

/**
 * 个人中心订单列表
 * 
 * @author king
 * 
 */
public class SelfOrderListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("orderList")
	@ReturnMapping(desc = "用户订单列表")
	private List<SelfOrderBO> orderList;

	@JsonProperty("selfOrder")
	@ReturnMapping(desc = "订单详情")
	private OrderFormDetailBO orderFormDetail;

	@JsonProperty("selfEvaluate")
	@ReturnMapping(desc = "我的评价列表")
	private List<EvaluatePageBO> selfEvaluate;

	@JsonProperty("selfFavaGoodsList")
	@ReturnMapping(desc = "我收藏的商品列表")
	private List<ShopGoodsBo> selfFavaGoodsList;

	@JsonProperty("selfStroeList")
	@ReturnMapping(desc = "我收藏的商铺列表")
	private List<FavaStoreBO> selfStroeList;

	public List<SelfOrderBO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<SelfOrderBO> orderList) {
		this.orderList = orderList;
	}

	public OrderFormDetailBO getOrderFormDetail() {
		return orderFormDetail;
	}

	public void setOrderFormDetail(OrderFormDetailBO orderFormDetail) {
		this.orderFormDetail = orderFormDetail;
	}

	public List<EvaluatePageBO> getSelfEvaluate() {
		return selfEvaluate;
	}

	public void setSelfEvaluate(List<EvaluatePageBO> selfEvaluate) {
		this.selfEvaluate = selfEvaluate;
	}

	public List<ShopGoodsBo> getSelfFavaGoodsList() {
		return selfFavaGoodsList;
	}

	public void setSelfFavaGoodsList(List<ShopGoodsBo> selfFavaGoodsList) {
		this.selfFavaGoodsList = selfFavaGoodsList;
	}

	public List<FavaStoreBO> getSelfStroeList() {
		return selfStroeList;
	}

	public void setSelfStroeList(List<FavaStoreBO> selfStroeList) {
		this.selfStroeList = selfStroeList;
	}

}
