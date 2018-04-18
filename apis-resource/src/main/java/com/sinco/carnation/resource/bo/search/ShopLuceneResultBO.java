package com.sinco.carnation.resource.bo.search;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopLuceneResult", desc = "关键字搜索列表")
public class ShopLuceneResultBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long vo_id;

	@JsonProperty("title")
	@FieldMapping(desc = "商品标题")
	private String vo_title;

	@JsonProperty("mainPhotoUrl")
	@FieldMapping(desc = "商品主图片")
	private String vo_main_photo_url;

	@JsonProperty("photosUrl")
	@FieldMapping(desc = "商品小图片")
	private String vo_photos_url;

	@JsonProperty("storePrice")
	@FieldMapping(desc = "店铺价格")
	private double vo_store_price;

	@JsonProperty("costPrice")
	@FieldMapping(desc = "成本价")
	private double vo_cost_price;

	@JsonProperty("storeUsername")
	@FieldMapping(desc = "店铺名称")
	private String vo_store_username;

	@JsonProperty("hasExchangeIntegral")
	@FieldMapping(desc = "是否有积分价")
	private boolean vo_has_exchange_integral;

	@JsonProperty("hasMobilePrice")
	@FieldMapping(desc = "是否有手机价")
	private boolean vo_has_mobile_price;

	@JsonProperty("mobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal vo_mobile_price;

	@JsonProperty("bv")
	@FieldMapping(desc = "CN商品BV")
	private BigDecimal vo_cn_self_add_price;

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品原价")
	private BigDecimal vo_goods_price;
	
	/** 卷皮 商品 字段 **/
	@JsonProperty("isJuanpi")
	@FieldMapping(desc = "是否是卷皮0否 1是")
	private Integer vo_is_juanpi;
	
	@JsonProperty("isTuangou")
	@FieldMapping(desc = "是否是团购 0否 1是")
	private Integer vo_is_tuangou;
	
	@JsonProperty("targetUrlM")
	@FieldMapping(desc = "H5卷皮跳转页面路径")
	private String vo_target_url_m;
	
	@JsonProperty("tuanCprice")
	@FieldMapping(desc = "拼团价格")
	private BigDecimal vo_tuangou_price;

	public BigDecimal getVo_cn_self_add_price() {
		return vo_cn_self_add_price;
	}

	public void setVo_cn_self_add_price(BigDecimal vo_cn_self_add_price) {
		this.vo_cn_self_add_price = vo_cn_self_add_price;
	}

	public BigDecimal getVo_goods_price() {
		if (null == vo_goods_price) {
			return new BigDecimal(0);
		}
		return vo_goods_price;
	}

	public void setVo_goods_price(BigDecimal vo_goods_price) {
		this.vo_goods_price = vo_goods_price;
	}

	public Long getVo_id() {
		return vo_id;
	}

	public String getVo_title() {
		return vo_title;
	}

	public String getVo_main_photo_url() {
		return vo_main_photo_url;
	}

	public String getVo_photos_url() {
		return vo_photos_url;
	}

	public double getVo_store_price() {
		return vo_store_price;
	}

	public double getVo_cost_price() {
		return vo_cost_price;
	}

	public String getVo_store_username() {
		return vo_store_username;
	}

	public boolean isVo_has_exchange_integral() {
		return vo_has_exchange_integral;
	}

	public boolean isVo_has_mobile_price() {
		return vo_has_mobile_price;
	}

	public void setVo_id(Long vo_id) {
		this.vo_id = vo_id;
	}

	public void setVo_title(String vo_title) {
		this.vo_title = vo_title;
	}

	public void setVo_main_photo_url(String vo_main_photo_url) {
		this.vo_main_photo_url = vo_main_photo_url;
	}

	public void setVo_photos_url(String vo_photos_url) {
		this.vo_photos_url = vo_photos_url;
	}

	public void setVo_store_price(double vo_store_price) {
		this.vo_store_price = vo_store_price;
	}

	public void setVo_cost_price(double vo_cost_price) {
		this.vo_cost_price = vo_cost_price;
	}

	public void setVo_store_username(String vo_store_username) {
		this.vo_store_username = vo_store_username;
	}

	public void setVo_has_exchange_integral(boolean vo_has_exchange_integral) {
		this.vo_has_exchange_integral = vo_has_exchange_integral;
	}

	public void setVo_has_mobile_price(boolean vo_has_mobile_price) {
		this.vo_has_mobile_price = vo_has_mobile_price;
	}

	public BigDecimal getVo_mobile_price() {
		if (null != vo_mobile_price) {
			return new BigDecimal(0);
		}
		return vo_mobile_price;
	}

	public void setVo_mobile_price(BigDecimal vo_mobile_price) {
		this.vo_mobile_price = vo_mobile_price;
	}

	public Integer getVo_is_juanpi() {
		if (null == vo_is_juanpi) {
			return 0;
		}
		return vo_is_juanpi;
	}

	public void setVo_is_juanpi(Integer vo_is_juanpi) {
		this.vo_is_juanpi = vo_is_juanpi;
	}

	public Integer getVo_is_tuangou() {
		return vo_is_tuangou;
	}

	public void setVo_is_tuangou(Integer vo_is_tuangou) {
		this.vo_is_tuangou = vo_is_tuangou;
	}

	public String getVo_target_url_m() {
		return vo_target_url_m;
	}

	public void setVo_target_url_m(String vo_target_url_m) {
		this.vo_target_url_m = vo_target_url_m;
	}

	public BigDecimal getVo_tuangou_price() {
		if (null == vo_tuangou_price) {
			return new BigDecimal(0);
		}
		return vo_tuangou_price;
	}

	public void setVo_tuangou_price(BigDecimal vo_tuangou_price) {
		this.vo_tuangou_price = vo_tuangou_price;
	}
	
	
}
