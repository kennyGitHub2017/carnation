package com.sinco.carnation.resource.web.response.integral;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.integral.AddressListBO;
import com.sinco.carnation.resource.bo.integral.ComputeOrderBO;
import com.sinco.carnation.resource.bo.integral.IntegralGoodsDetailsBO;
import com.sinco.carnation.resource.bo.integral.IntegralListBO;
import com.sinco.carnation.resource.bo.integral.IntegralOrderDetailsBO;
import com.sinco.carnation.resource.bo.integral.OrderBO;
import com.sinco.carnation.resource.bo.integral.OrderListBO;

@SuppressWarnings("serial")
public class IntegralResponse extends ApiResponse implements Utf8mb4ToJson {
	@JsonProperty("computeOrderBO")
	@ReturnMapping(desc = "返回订单所需的积分与费用等相关信息")
	private ComputeOrderBO computeOrderBO;

	@JsonProperty("orderBO")
	@ReturnMapping(desc = "积分订单详情")
	private OrderBO orderBO;

	@JsonProperty("addressList")
	@ReturnMapping(desc = "收货地址集合")
	private List<AddressListBO> addressList;

	@JsonProperty("orderList")
	@ReturnMapping(desc = "积分兑换订单集合")
	private List<OrderListBO> orderList;

	@JsonProperty("integralList")
	@ReturnMapping(desc = "积分兑换商品集合")
	private List<IntegralListBO> integralList;

	@JsonProperty("totalCount")
	@ReturnMapping(desc = "总记录数")
	private Long totalCount;

	@JsonProperty("integralDetails")
	@ReturnMapping(desc = "积分商品详情")
	private IntegralGoodsDetailsBO integralDetails;

	@JsonProperty("exchangeStatus")
	@ReturnMapping(desc = "立即兑换状态|0成功 1已过期  2等级不够  3积分不够  4库存不足  5超出限制兑换数  6未登录 8:商品库存为零，兑换失败")
	private Integer exchangeStatus;

	@JsonProperty("details")
	@ReturnMapping(desc = "订单详情")
	private IntegralOrderDetailsBO details;

	@JsonProperty("integralGoodsList")
	@ReturnMapping(desc = "商品库存列表")
	private List<IntegralGoodsDetailsBO> integralGoodsList;

	public OrderBO getOrderBO() {
		return orderBO;
	}

	public void setOrderBO(OrderBO orderBO) {
		this.orderBO = orderBO;
	}

	public List<AddressListBO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressListBO> addressList) {
		this.addressList = addressList;
	}

	public List<OrderListBO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderListBO> orderList) {
		this.orderList = orderList;
	}

	public List<IntegralListBO> getIntegralList() {
		return integralList;
	}

	public void setIntegralList(List<IntegralListBO> integralList) {
		this.integralList = integralList;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	// public List getResults() {
	// return results;
	// }
	//
	// public void setResults(List results) {
	// this.results = results;
	// }

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public IntegralGoodsDetailsBO getIntegralDetails() {
		return integralDetails;
	}

	public void setIntegralDetails(IntegralGoodsDetailsBO integralDetails) {
		this.integralDetails = integralDetails;
	}

	public Integer getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(Integer exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}

	public IntegralOrderDetailsBO getDetails() {
		return details;
	}

	public void setDetails(IntegralOrderDetailsBO details) {
		this.details = details;
	}

	public ComputeOrderBO getComputeOrderBO() {
		return computeOrderBO;
	}

	public void setComputeOrderBO(ComputeOrderBO computeOrderBO) {
		this.computeOrderBO = computeOrderBO;
	}

	public List<IntegralGoodsDetailsBO> getIntegralGoodsList() {
		return integralGoodsList;
	}

	public void setIntegralGoodsList(List<IntegralGoodsDetailsBO> integralGoodsList) {
		this.integralGoodsList = integralGoodsList;
	}
}
