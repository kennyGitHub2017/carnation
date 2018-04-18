package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsInfo", desc = "商品信息")
public class ShopGoodsInfo {

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品价格")
	private BigDecimal goods_price;

	@JsonProperty("goodsSnapshoot")
	@FieldMapping(desc = "商品快照")
	private String goods_snapshoot;

	@JsonProperty("goodsGspVal")
	@FieldMapping(desc = "商品规格")
	private String goods_gsp_val;

	@JsonProperty("goodsAllPrice")
	@FieldMapping(desc = "商品总价")
	private BigDecimal goods_all_price;

	@JsonProperty("goodsId")
	@FieldMapping(desc = "商品id")
	private Long goods_id;

	@JsonProperty("goodsType")
	@FieldMapping(desc = "商品类型")
	private Integer goods_type;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goods_name;

	@JsonProperty("goodsDomainPath")
	@FieldMapping(desc = "商品主图")
	private String goods_domainPath;

	@JsonProperty("goodsChoiceType")
	@FieldMapping(desc = "商品是否实体  0实体商品，1为虚拟商品")
	private String goods_choice_type;

	@JsonProperty("goodsMainphotoPath")
	@FieldMapping(desc = "商品主图片")
	private String goods_mainphoto_path;

	@JsonProperty("goodsGspIds")
	@FieldMapping(desc = "goodsGspIds")
	private String goods_gsp_ids;

	@JsonProperty("goodsPayoffPrice")
	@FieldMapping(desc = "goodsPayoffPrice")
	private String goods_payoff_price;

	@JsonProperty("goodsCommissionPrice")
	@FieldMapping(desc = "goodsCommissionPrice")
	private String goods_commission_price;

	@JsonProperty("goodsCommissionRate")
	@FieldMapping(desc = "goodsCommissionRate")
	private String goods_commission_rate;

	@JsonProperty("storeDomainPath")
	@FieldMapping(desc = "storeDomainPath")
	private String store_domainPath;

	@JsonProperty("goodsCount")
	@FieldMapping(desc = "商品数量")
	private Integer goods_count;

	@JsonProperty("goodsReturnStatus")
	@FieldMapping(desc = "退货商品状态|-2为超过退货时间未能输入退货物流 -1为申请被拒绝，1为可以退货 5为退货申请中 6为审核通过可进行退货 7为退货中，10为退货完成,等待退款，11为平台退款完成")
	private String goods_return_status;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal goods_mobile_price;
	
	@JsonProperty("goodsIntegralPrice")
	@FieldMapping(desc="积分价")
	private BigDecimal goods_integral_price;
	
	@JsonProperty("needYgb")
	@FieldMapping(desc="需要的云购币")
	private BigDecimal needYgb;
	
	@JsonProperty("needMoney")
	@FieldMapping(desc="需要的现金")
	private BigDecimal needMoney;

	@JsonProperty("needIntegral")
	@FieldMapping(desc="需要的积分")
	private BigDecimal needIntegral;
	
	@JsonProperty("cnSelfAddPrice")
	@FieldMapping(desc="CN用户产品BV")
	private BigDecimal cnSelfAddPrice;

	@JsonProperty("hasReturn")
	@FieldMapping(desc = "是否可退货")
	private boolean hasReturn;
	
	@JsonProperty("payTypeFlag")
	@FieldMapping(desc = "支付方式 ，1重消 2积分")
	private Integer payTypeFlag;
	
/*	[{"goodsmoney":"39.20","goodsid":"56593581","status":2,"goodsnumber":1,
		"goodstitle":"韩版薄款休闲百搭夹克","commission":1.37,"brokerageratiocale":"0.0350"}]*/
	//卷皮商品
	@JsonProperty("status")
	@FieldMapping(desc = "卷皮商品的状态")
	private Integer status;
	
	@JsonProperty("goodsmoney")
	@FieldMapping(desc = "卷皮订单商品价格")
	private BigDecimal goodsmoney;
	
	@JsonProperty("goodstitle")
	@FieldMapping(desc = "卷皮订单商品name")
	private String goodstitle;
	
	@JsonProperty("goodsnumber")
	@FieldMapping(desc = "卷皮订单商品数量")
	private Integer goodsnumber;
	
	@JsonProperty("fictionBo")
	private List<ShopGoodsSpecification> fictionBo;
	
	
/*	[{"skuPrice":"39.20","skuIId":"56593581","skuNum":1,
	"skuName":"韩版薄款休闲百搭夹克","skuIcon":"云尚酒业"}]*/
//酒业商品
	@JsonProperty("skuPrice")
	@FieldMapping(desc = "酒业订单商品价格")
	private BigDecimal skuPrice;
	
	@JsonProperty("skuName")
	@FieldMapping(desc = "酒业订单商品name")
	private String skuName;
	
	@JsonProperty("skuNum")
	@FieldMapping(desc = "酒业订单商品数量")
	private Integer skuNum;
	
	@JsonProperty("skuIcon")
	@FieldMapping(desc = "酒业订单商品图片")
	private String skuIcon;
	
	

	public BigDecimal getSkuPrice() {
		return skuPrice;
	}

	public void setSkuPrice(BigDecimal skuPrice) {
		this.skuPrice = skuPrice;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getSkuNum() {
		return skuNum;
	}

	public void setSkuNum(Integer skuNum) {
		this.skuNum = skuNum;
	}

	public String getSkuIcon() {
		return skuIcon;
	}

	public void setSkuIcon(String skuIcon) {
		this.skuIcon = skuIcon;
	}

	public String getGoods_snapshoot() {
		return goods_snapshoot;
	}

	public String getGoods_gsp_val() {
		return goods_gsp_val;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public String getGoods_domainPath() {
		return goods_domainPath;
	}

	public String getGoods_choice_type() {
		return goods_choice_type;
	}

	public String getGoods_mainphoto_path() {
		return goods_mainphoto_path;
	}

	public String getGoods_gsp_ids() {
		return goods_gsp_ids;
	}

	public void setGoods_snapshoot(String goods_snapshoot) {
		this.goods_snapshoot = goods_snapshoot;
	}

	public void setGoods_gsp_val(String goods_gsp_val) {
		this.goods_gsp_val = goods_gsp_val;
	}

	public BigDecimal getGoods_price() {
		return goods_price;
	}

	public BigDecimal getGoods_all_price() {
		return goods_all_price;
	}

	public Long getGoods_id() {
		return goods_id;
	}

	public Integer getGoods_type() {
		return goods_type;
	}

	public List<ShopGoodsSpecification> getFictionBo() {
		return fictionBo;
	}

	public void setGoods_price(BigDecimal goods_price) {
		this.goods_price = goods_price;
	}

	public void setGoods_all_price(BigDecimal goods_all_price) {
		this.goods_all_price = goods_all_price;
	}

	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}

	public void setGoods_type(Integer goods_type) {
		this.goods_type = goods_type;
	}

	public void setFictionBo(List<ShopGoodsSpecification> fictionBo) {
		this.fictionBo = fictionBo;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public void setGoods_domainPath(String goods_domainPath) {
		this.goods_domainPath = goods_domainPath;
	}

	public void setGoods_choice_type(String goods_choice_type) {
		this.goods_choice_type = goods_choice_type;
	}

	public void setGoods_mainphoto_path(String goods_mainphoto_path) {
		this.goods_mainphoto_path = goods_mainphoto_path;
	}

	public void setGoods_gsp_ids(String goods_gsp_ids) {
		this.goods_gsp_ids = goods_gsp_ids;
	}

	public String getGoods_payoff_price() {
		return goods_payoff_price;
	}

	public String getGoods_commission_price() {
		return goods_commission_price;
	}

	public String getGoods_commission_rate() {
		return goods_commission_rate;
	}

	public String getStore_domainPath() {
		return store_domainPath;
	}

	public Integer getGoods_count() {
		return goods_count;
	}

	public void setGoods_payoff_price(String goods_payoff_price) {
		this.goods_payoff_price = goods_payoff_price;
	}

	public void setGoods_commission_price(String goods_commission_price) {
		this.goods_commission_price = goods_commission_price;
	}

	public void setGoods_commission_rate(String goods_commission_rate) {
		this.goods_commission_rate = goods_commission_rate;
	}

	public void setStore_domainPath(String store_domainPath) {
		this.store_domainPath = store_domainPath;
	}

	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}

	public BigDecimal getGoods_mobile_price() {
		return goods_mobile_price;
	}

	public void setGoods_mobile_price(BigDecimal goods_mobile_price) {
		this.goods_mobile_price = goods_mobile_price;
	}

	public BigDecimal getGoods_integral_price() {
		return goods_integral_price;
	}

	public void setGoods_integral_price(BigDecimal goods_integral_price) {
		this.goods_integral_price = goods_integral_price;
	}

	public String getGoods_return_status() {
		return goods_return_status;
	}

	public void setGoods_return_status(String goods_return_status) {
		this.goods_return_status = goods_return_status;
	}

	public BigDecimal getNeedYgb() {
		return needYgb;
	}

	public void setNeedYgb(BigDecimal needYgb) {
		this.needYgb = needYgb;
	}

	public BigDecimal getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}

	public BigDecimal getCnSelfAddPrice() {
		return cnSelfAddPrice;
	}

	public void setCnSelfAddPrice(BigDecimal cnSelfAddPrice) {
		this.cnSelfAddPrice = cnSelfAddPrice;
	}

	public boolean isHasReturn() {
		return hasReturn;
	}

	public void setHasReturn(boolean hasReturn) {
		this.hasReturn = hasReturn;
	}

	public BigDecimal getNeedIntegral() {
		return needIntegral;
	}

	public void setNeedIntegral(BigDecimal needIntegral) {
		this.needIntegral = needIntegral;
	}

	public Integer getPayTypeFlag() {
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getGoodsmoney() {
		return goodsmoney;
	}

	public void setGoodsmoney(BigDecimal goodsmoney) {
		this.goodsmoney = goodsmoney;
	}

	public String getGoodstitle() {
		return goodstitle;
	}

	public void setGoodstitle(String goodstitle) {
		this.goodstitle = goodstitle;
	}

	public Integer getGoodsnumber() {
		return goodsnumber;
	}

	public void setGoodsnumber(Integer goodsnumber) {
		this.goodsnumber = goodsnumber;
	}


}
