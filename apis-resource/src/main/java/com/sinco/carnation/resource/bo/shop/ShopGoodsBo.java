package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Goods", desc = "商品")
public class ShopGoodsBo {

	@JsonProperty("id")
	@FieldMapping(desc = "商品id")
	private Long id;

	@JsonProperty("goodsMainPhotoPath")
	@FieldMapping(desc = "商品图片")
	private String goodsMainPhotoPath;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goodsName;

	@JsonProperty("goodsCurrentPrice")
	@FieldMapping(desc = "商品当前价格")
	private BigDecimal goodsCurrentPrice;

	@JsonProperty("storePrice")
	@FieldMapping(desc = "店铺价格")
	private BigDecimal storePrice;

	@JsonProperty("hasExchangeIntegral")
	@FieldMapping(desc = "是否有积分兑换价格")
	private Boolean hasExchangeIntegral;

	@JsonProperty("goodsIntegralPrice")
	@FieldMapping(desc = "商品积分兑换后的价格，无兑换显示原价")
	private BigDecimal goodsIntegralPrice;

	@JsonProperty("hasMobilePrice")
	@FieldMapping(desc = "是否有手机专享价")
	private Boolean hasMobilePrice;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal goodsMobilePrice;

	/** 详细说明 **/
	@JsonProperty("goodsDetails")
	@FieldMapping(desc = "详细说明")
	private String goodsDetails;

	/** 商品包装清单 **/
	@JsonProperty("packDetails")
	@FieldMapping(desc = "商品包装清单")
	private String packDetails;

	/** 商品描述评分 **/
	@JsonProperty("descriptionEvaluate")
	@FieldMapping(desc = "商品描述评分")
	private Long descriptionEvaluate;

	/** 详细说明app **/
	@JsonProperty("goodsDetailsMobile")
	@FieldMapping(desc = "详细说明app")
	private String goodsDetailsMobile;

	/** 商品运费承担方式 0为买家承担，1为卖家承担 **/
	@JsonProperty("goodsTransfee")
	@FieldMapping(desc = "商品运费承担方式 0为买家承担，1为卖家承担")
	private Integer goodsTransfee;

	/** 商品类型 0为自营商品，1为第三方经销商 **/
	@JsonProperty("goodsType")
	@FieldMapping(desc = "商品类型  0为自营商品，1为第三方经销商")
	private Integer goodsType;

	@JsonProperty("detail")
	@FieldMapping(desc = "商品sq")
	private List<GoodsInventoryDetail> detail;

	@JsonProperty("property")
	@FieldMapping(desc = "商品属性")
	private List<GoodsProperty> property;

	@JsonProperty("cationList")
	@FieldMapping(desc = "将商品属性归类")
	private List<ShopGoodsSpecification> cationList;

	@JsonProperty("ficPropertyList")
	@FieldMapping(desc = "商品规格")
	private List<ShopGoodsSpecProperty> ficPropertyList;

	@JsonProperty("goodsPhotosList")
	@FieldMapping(desc = "商品浏览图片")
	private List<ShopGoodsPhotoBO> goodsPhotosList;

	/** 库存数量 **/
	@JsonProperty("goodsInventory")
	@FieldMapping(desc = "商品库存")
	private Integer goodsInventory;

	@JsonProperty("exchangeIntegral")
	@FieldMapping(desc = "兑换积分值，如果是0的话表示不设置积分兑购")
	private Integer exchangeIntegral;

	/** 是否支持货到付款 0为支持，-1为不支持 **/
	@JsonProperty("goodsCod")
	@FieldMapping(desc = "是否支持货到付款 0为支持，-1为不支持")
	private Integer goodsCod;

	/** 商品是否实体 0实体商品，1为虚拟商品 **/
	@JsonProperty("goodsChoiceType")
	@FieldMapping(desc = "商品是否实体  0实体商品，1为虚拟商品")
	private Integer goodsChoiceType;

	/** 是否支持增值税发票 **/
	@JsonProperty("taxInvoice")
	@FieldMapping(desc = "是否支持增值税发票")
	private Integer taxInvoice;

	@JsonProperty("goodsStoreId")
	@FieldMapping(desc = "店铺id")
	private Long goodsStoreId;

	@JsonProperty("goodsStoreName")
	@FieldMapping(desc = "店铺名称")
	private String goodsStoreName;

	@JsonProperty("storePhoto")
	@FieldMapping(desc = "店铺图片")
	private String storePhoto;

	@JsonProperty("goodsShowPrice")
	@FieldMapping(desc = "商品显示价格-显示的购买价格")
	private BigDecimal goodsShowPrice;

	@JsonProperty("mobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal mobilePrice;

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品原价-灰色划线价格")
	private BigDecimal goodsPrice;

	@JsonProperty("selfAddPrice")
	@FieldMapping(desc = "BV值")
	private BigDecimal selfAddPrice;

	@JsonProperty("expressTransFee")
	@FieldMapping(desc = "快递费")
	private BigDecimal expressTransFee;

	@JsonProperty("discount")
	@FieldMapping(desc = "折扣价")
	private BigDecimal discount;

	@JsonProperty("bv")
	@FieldMapping(desc = "CN商品BV")
	private BigDecimal bv;

	@JsonProperty("yunGouBi")
	@FieldMapping(desc = "云购币")
	private BigDecimal yunGouBi;

	@JsonProperty("cash")
	@FieldMapping(desc = "现金")
	private BigDecimal cash;

	@JsonProperty("storeLogo")
	@FieldMapping(desc = "店铺Logo")
	private String storeLogo;

	@JsonProperty("exPriceFlag")
	@FieldMapping(desc = "是否是支持云购币购买的产品")
	private Integer exPriceFlag;

	@JsonProperty("hasYgb")
	@FieldMapping(desc = "是否是云购币产品")
	private boolean hasYgb;

	@JsonProperty("needIntegral")
	@FieldMapping(desc = "需要的积分-精品专区")
	private BigDecimal needIntegral;

	@JsonProperty("needMoney")
	@FieldMapping(desc = "需要的现金")
	private BigDecimal needMoney;

	@JsonProperty("needYgb")
	@FieldMapping(desc = "需要的云购币")
	private BigDecimal needYgb;

	@JsonProperty("proType")
	@FieldMapping(desc = "商品支付类型 1 重消,2购物积分 3重消+购物积分 4平台积分")
	private Integer proType;
	
	
	/** 卷皮 商品 字段 **/
	@JsonProperty("isJuanpi")
	@FieldMapping(desc = "是否是卷皮0否 1是")
	private Integer isJuanpi;
	
	@JsonProperty("targetUrlM")
	@FieldMapping(desc = "H5卷皮跳转页面路径")
	private String targetUrlM;
	
	@JsonProperty("isTuangou")
	@FieldMapping(desc = "是否团购1是 0否")
	private Integer isTuangou;
	
	
	
	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public BigDecimal getYunGouBi() {
		return yunGouBi;
	}

	public void setYunGouBi(BigDecimal yunGouBi) {
		this.yunGouBi = yunGouBi;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public BigDecimal getBv() {
		return bv;
	}

	public void setBv(BigDecimal bv) {
		this.bv = bv;
	}

	public Long getId() {
		return id;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public BigDecimal getStorePrice() {
		return storePrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	public Boolean getHasExchangeIntegral() {
		return hasExchangeIntegral;
	}

	public BigDecimal getGoodsIntegralPrice() {
		return goodsIntegralPrice;
	}

	public Boolean getHasMobilePrice() {
		return hasMobilePrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public void setHasExchangeIntegral(Boolean hasExchangeIntegral) {
		this.hasExchangeIntegral = hasExchangeIntegral;
	}

	public void setGoodsIntegralPrice(BigDecimal goodsIntegralPrice) {
		this.goodsIntegralPrice = goodsIntegralPrice;
	}

	public void setHasMobilePrice(Boolean hasMobilePrice) {
		this.hasMobilePrice = hasMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public String getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public List<GoodsInventoryDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<GoodsInventoryDetail> detail) {
		this.detail = detail;
	}

	public List<GoodsProperty> getProperty() {
		return property;
	}

	public void setProperty(List<GoodsProperty> property) {
		this.property = property;
	}

	public String getPackDetails() {
		return packDetails;
	}

	public void setPackDetails(String packDetails) {
		this.packDetails = packDetails;
	}

	public Long getDescriptionEvaluate() {
		return descriptionEvaluate;
	}

	public String getGoodsDetailsMobile() {
		return goodsDetailsMobile;
	}

	public void setDescriptionEvaluate(Long descriptionEvaluate) {
		this.descriptionEvaluate = descriptionEvaluate;
	}

	public void setGoodsDetailsMobile(String goodsDetailsMobile) {
		this.goodsDetailsMobile = goodsDetailsMobile;
	}

	public Integer getGoodsTransfee() {
		return goodsTransfee;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsTransfee(Integer goodsTransfee) {
		this.goodsTransfee = goodsTransfee;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public List<ShopGoodsSpecProperty> getFicPropertyList() {
		return ficPropertyList;
	}

	public void setFicPropertyList(List<ShopGoodsSpecProperty> ficPropertyList) {
		this.ficPropertyList = ficPropertyList;
	}

	public List<ShopGoodsPhotoBO> getGoodsPhotosList() {
		return goodsPhotosList;
	}

	public void setGoodsPhotosList(List<ShopGoodsPhotoBO> goodsPhotosList) {
		this.goodsPhotosList = goodsPhotosList;
	}

	public List<ShopGoodsSpecification> getCationList() {
		return cationList;
	}

	public void setCationList(List<ShopGoodsSpecification> cationList) {
		this.cationList = cationList;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public Integer getExchangeIntegral() {
		return exchangeIntegral;
	}

	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}

	public Integer getGoodsCod() {
		return goodsCod;
	}

	public Integer getGoodsChoiceType() {
		return goodsChoiceType;
	}

	public Integer getTaxInvoice() {
		return taxInvoice;
	}

	public void setGoodsCod(Integer goodsCod) {
		this.goodsCod = goodsCod;
	}

	public void setGoodsChoiceType(Integer goodsChoiceType) {
		this.goodsChoiceType = goodsChoiceType;
	}

	public void setTaxInvoice(Integer taxInvoice) {
		this.taxInvoice = taxInvoice;
	}

	public Long getGoodsStoreId() {
		return goodsStoreId;
	}

	public String getGoodsStoreName() {
		return goodsStoreName;
	}

	public void setGoodsStoreId(Long goodsStoreId) {
		this.goodsStoreId = goodsStoreId;
	}

	public void setGoodsStoreName(String goodsStoreName) {
		this.goodsStoreName = goodsStoreName;
	}

	public String getStorePhoto() {
		return storePhoto;
	}

	public void setStorePhoto(String storePhoto) {
		this.storePhoto = storePhoto;
	}

	public BigDecimal getGoodsShowPrice() {
		return goodsShowPrice;
	}

	public void setGoodsShowPrice(BigDecimal goodsShowPrice) {
		this.goodsShowPrice = goodsShowPrice;
	}

	public BigDecimal getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(BigDecimal mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getSelfAddPrice() {
		return selfAddPrice;
	}

	public void setSelfAddPrice(BigDecimal selfAddPrice) {
		this.selfAddPrice = selfAddPrice;
	}

	public BigDecimal getExpressTransFee() {
		return expressTransFee;
	}

	public void setExpressTransFee(BigDecimal expressTransFee) {
		this.expressTransFee = expressTransFee;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getExPriceFlag() {
		return exPriceFlag;
	}

	public void setExPriceFlag(Integer exPriceFlag) {
		this.exPriceFlag = exPriceFlag;
	}

	public boolean isHasYgb() {
		return hasYgb;
	}

	public void setHasYgb(boolean hasYgb) {
		this.hasYgb = hasYgb;
	}

	public BigDecimal getNeedIntegral() {
		return needIntegral;
	}

	public void setNeedIntegral(BigDecimal needIntegral) {
		this.needIntegral = needIntegral;
	}

	public BigDecimal getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}

	public BigDecimal getNeedYgb() {
		return needYgb;
	}

	public void setNeedYgb(BigDecimal needYgb) {
		this.needYgb = needYgb;
	}

	public Integer getProType() {
		return proType;
	}

	public void setProType(Integer proType) {
		this.proType = proType;
	}

	public Integer getIsJuanpi() {
		return isJuanpi;
	}

	public void setIsJuanpi(Integer isJuanpi) {
		this.isJuanpi = isJuanpi;
	}

	public String getTargetUrlM() {
		return targetUrlM;
	}

	public void setTargetUrlM(String targetUrlM) {
		this.targetUrlM = targetUrlM;
	}

	public Integer getIsTuangou() {
		return isTuangou;
	}

	public void setIsTuangou(Integer isTuangou) {
		this.isTuangou = isTuangou;
	}

}
