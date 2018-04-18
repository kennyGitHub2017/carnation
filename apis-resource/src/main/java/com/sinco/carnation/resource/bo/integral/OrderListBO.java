package com.sinco.carnation.resource.bo.integral;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OrderListBO", desc = "我的积分兑换列表")
public class OrderListBO {
	/** 订单ID **/
	@JsonProperty("id")
	@FieldMapping(desc = "订单id")
	private Long id;

	/** 订单编号，以igo开头 **/
	@JsonProperty("igoOrderSn")
	@FieldMapping(desc = "订单编号，以igo开头")
	private String igoOrderSn;

	/** 订单状态，0为已提交未付款，20为付款成功，30为已发货，40为已收货完成,-1为已经取消，此时不归还用户积分 **/
	@JsonProperty("igoStatus")
	@FieldMapping(desc = "订单状态，0为已提交未付款，20为付款成功，30为已发货，40为已收货完成,-1为已经取消，此时不归还用户积分")
	private Integer igoStatus;

	/** 总共消费积分 **/
	@JsonProperty("igoTotalIntegral")
	@FieldMapping(desc = "总共消费积分")
	private Integer igoTotalIntegral;

	/** 购物车运费 **/
	@JsonProperty("igoTransFee")
	@FieldMapping(desc = "购物车运费")
	private BigDecimal igoTransFee;

	/** 订单中的商品数量 **/
	@JsonProperty("goodsCount")
	@FieldMapping(desc = "订单中的商品数量")
	private Integer goodsCount;

	@JsonProperty("orderBOList")
	@FieldMapping(desc = "订单中的商品列表")
	private List<OrderBO> orderBOList;;

	// @JsonProperty("goodsList")
	// @FieldMapping(desc = "商品列表")
	// private List<IGoBO> goodsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIgoOrderSn() {
		return igoOrderSn;
	}

	public void setIgoOrderSn(String igoOrderSn) {
		this.igoOrderSn = igoOrderSn;
	}

	public Integer getIgoStatus() {
		return igoStatus;
	}

	public void setIgoStatus(Integer igoStatus) {
		this.igoStatus = igoStatus;
	}

	public Integer getIgoTotalIntegral() {
		return igoTotalIntegral;
	}

	public void setIgoTotalIntegral(Integer igoTotalIntegral) {
		this.igoTotalIntegral = igoTotalIntegral;
	}

	public BigDecimal getIgoTransFee() {
		return igoTransFee;
	}

	public void setIgoTransFee(BigDecimal igoTransFee) {
		this.igoTransFee = igoTransFee;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	private String goodsInfo;

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		JSONArray array = JSON.parseArray(goodsInfo);
		List<OrderBO> list = new ArrayList<>();
		int goodsCount = 0;
		for (Object o : array) {
			JSONObject jo = (JSONObject) o;
			goodsCount += jo.getIntValue("ig_goods_count");
			OrderBO bo = new OrderBO();
			bo.setGoodsImg(jo.getString("ig_goods_img"));
			bo.setGoodsName(jo.getString("ig_goods_name"));
			bo.setIgoTotalIntegral(jo.getIntValue("ig_goods_integral"));
			bo.setGoodsCount(jo.getIntValue("ig_goods_count"));
			bo.setGoodsId(jo.getLongValue("id"));
			list.add(bo);
		}
		setGoodsCount(goodsCount);
		setOrderBOList(list);
		this.goodsInfo = goodsInfo;
	}

	public List<OrderBO> getOrderBOList() {
		return orderBOList;
	}

	public void setOrderBOList(List<OrderBO> orderBOList) {
		this.orderBOList = orderBOList;
	}
}