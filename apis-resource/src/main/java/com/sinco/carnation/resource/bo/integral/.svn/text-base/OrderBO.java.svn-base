package com.sinco.carnation.resource.bo.integral;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OrderBO", desc = "订单详情")
public class OrderBO {
	/** 订单ID **/
	@JsonProperty("id")
	@FieldMapping(desc = "订单id")
	private Long id;

	@JsonProperty("goodsId")
	@FieldMapping(desc = "商品id")
	private Long goodsId;

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

	@JsonProperty("goodsImg")
	@FieldMapping(desc = "商品图片")
	private String goodsImg;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goodsName;

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

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}