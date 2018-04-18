package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsInventoryDetail", desc = "商品squ")
public class GoodsInventoryDetail {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private String id;

	@JsonProperty("integralPrice")
	@FieldMapping(desc = "积分价")
	private BigDecimal integralPrice;

	@JsonProperty("price")
	@FieldMapping(desc = "价格")
	private BigDecimal price;

	@JsonProperty("integralCount")
	@FieldMapping(desc = "积分")
	private Integer integralCount;

	@JsonProperty("count")
	@FieldMapping(desc = "数量")
	private Integer count;

	@JsonProperty("mobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal mobilePrice;

	public String getId() {
		return id;
	}

	public BigDecimal getIntegralPrice() {
		return integralPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getIntegralCount() {
		return integralCount;
	}

	public Integer getCount() {
		return count;
	}

	public BigDecimal getMobilePrice() {
		return mobilePrice;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIntegralPrice(BigDecimal integralPrice) {
		this.integralPrice = integralPrice;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setIntegralCount(Integer integralCount) {
		this.integralCount = integralCount;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setMobilePrice(BigDecimal mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

}
