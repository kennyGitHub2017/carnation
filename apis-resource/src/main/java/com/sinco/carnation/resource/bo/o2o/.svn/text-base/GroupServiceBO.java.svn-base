package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupService", desc = "团购商品信息")
public class GroupServiceBO {
	@JsonProperty("goodsId")
	@FieldMapping(desc = "id")
	private Long goods_id;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goods_name;

	@JsonProperty("goodsEndTime")
	@FieldMapping(desc = "结束时间")
	private Date goods_end_time;

	@JsonProperty("goodBeginTime")
	@FieldMapping(desc = "开始时间")
	private Date goods_begin_time;

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品价格")
	private BigDecimal goods_price;

	@JsonProperty("goodsType")
	@FieldMapping(desc = "商品类型")
	private Integer goods_type;

	@JsonProperty("goodsMainphotoPath")
	@FieldMapping(desc = "图片")
	private String goods_mainphoto_path;

	@JsonProperty("goodsTotalPrice")
	@FieldMapping(desc = "订单总价")
	private BigDecimal goods_total_price;

	@JsonProperty("goodsCount")
	@FieldMapping(desc = "商品数量")
	private Integer goods_count;

	public Long getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Date getGoods_end_time() {
		return goods_end_time;
	}

	public void setGoods_end_time(Date goods_end_time) {
		this.goods_end_time = goods_end_time;
	}

	public Date getGoods_begin_time() {
		return goods_begin_time;
	}

	public void setGoods_begin_time(Date goods_begin_time) {
		this.goods_begin_time = goods_begin_time;
	}

	public BigDecimal getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(Integer goods_type) {
		this.goods_type = goods_type;
	}

	public String getGoods_mainphoto_path() {
		return goods_mainphoto_path;
	}

	public void setGoods_mainphoto_path(String goods_mainphoto_path) {
		this.goods_mainphoto_path = goods_mainphoto_path;
	}

	public BigDecimal getGoods_total_price() {
		return goods_total_price;
	}

	public void setGoods_total_price(BigDecimal goods_total_price) {
		this.goods_total_price = goods_total_price;
	}

	public Integer getGoods_count() {
		return goods_count;
	}

	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}
}
