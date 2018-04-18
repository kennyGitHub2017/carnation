package com.sinco.carnation.resource.bo.integral;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "IntegralListBO", desc = "积分商城商品列表")
public class IntegralListBO {
	/** 商品ID **/
	@JsonProperty("id")
	@FieldMapping(desc = "商品id")
	private Long id;

	/** 礼品兑换积分 **/
	@JsonProperty("igGoodsIntegral")
	@FieldMapping(desc = "礼品兑换积分")
	private Integer igGoodsIntegral;

	/** 礼品名称 **/
	@JsonProperty("igGoodsName")
	@FieldMapping(desc = "礼品名称")
	private String igGoodsName;

	/** 礼品图片 **/
	@JsonProperty("igGoodsImg")
	@FieldMapping(desc = "礼品图片")
	private String igGoodsImg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIgGoodsIntegral() {
		return igGoodsIntegral;
	}

	public void setIgGoodsIntegral(Integer igGoodsIntegral) {
		this.igGoodsIntegral = igGoodsIntegral;
	}

	public String getIgGoodsName() {
		return igGoodsName;
	}

	public void setIgGoodsName(String igGoodsName) {
		this.igGoodsName = igGoodsName;
	}

	public String getIgGoodsImg() {
		return igGoodsImg;
	}

	public void setIgGoodsImg(String igGoodsImg) {
		this.igGoodsImg = igGoodsImg;
	}
}