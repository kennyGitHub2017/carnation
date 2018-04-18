package com.sinco.carnation.resource.bo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.carnation.resource.bo.personal.PGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.PStoreInfoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopStoreBO;
import com.sinco.carnation.resource.constant.WebConstant;
import com.sinco.carnation.sns.SNSConstants;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PositionAdvertBO", desc = "广告位的广告信息")
public class PositionAdvertBO {

	@JsonProperty("itemId")
	@FieldMapping(desc = "推荐id")
	private String itemId;

	@JsonProperty("adText")
	@FieldMapping(desc = "广告描述")
	private String adText;

	@JsonProperty("adTitle")
	@FieldMapping(desc = "广告标题")
	private String adTitle;

	@JsonProperty("adUrl")
	@FieldMapping(desc = "广告链接")
	private String adUrl;

	@JsonProperty("adType")
	@FieldMapping(desc = "1:帖子（链接），2商品，3商户，4资讯（云尚项目）（链接）5服务商户 6服务 8卷皮商品" )
	private String adType;

	@JsonProperty("adImgPath")
	@FieldMapping(desc = "广告图片")
	private String adImgPath;

	@JsonProperty("timeStamp")
	@FieldMapping(desc = "查询时间戳")
	private String timeStamp;

	@JsonProperty("invitation")
	@FieldMapping(desc = "附加信息－帖子信息")
	private LookInvitationBO lookInvitationBO;

	@JsonProperty("information")
	@FieldMapping(desc = "附加信息－云尚项目信息")
	private InformationBO informationBO;

	@JsonProperty("shopGoods")
	@FieldMapping(desc = "附加信息－商城商品信息")
	private ShopGoodsBo shopGoodsBo;

	@JsonProperty("shopStore")
	@FieldMapping(desc = "附加信息－商城商家信息")
	private ShopStoreBO shopStoreBO;

	@JsonProperty("pGroupGoods")
	@FieldMapping(desc = "附加信息－商户服务信息")
	private PGroupGoodsBO pGroupGoodsBO;

	@JsonProperty("pStoreInfo")
	@FieldMapping(desc = "附加信息－商户信息")
	private PStoreInfoBO pStoreInfoBO;

	@JsonProperty("nativeType")
	@FieldMapping(desc = "广告显示类型(1:Html5页面,2:原生页面)")
	private Integer nativeType;

	@JsonProperty("goodsCurrentPrice")
	@FieldMapping(desc = "商品当前价格")
	private BigDecimal goodsCurrentPrice;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "商品手机专享价")
	private BigDecimal goodsMobilePrice;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goodsName;

	@JsonProperty("hasMobilePrice")
	@FieldMapping(desc = "是否有手机专享价")
	private boolean hasMobilePrice;

	@JsonProperty("bv")
	@FieldMapping(desc = "商品BV值")
	private BigDecimal bv;
	
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

	public BigDecimal getBv() {
		return bv;
	}

	public void setBv(BigDecimal bv) {
		this.bv = bv;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAdText() {
		return adText;
	}

	public void setAdText(String adText) {
		this.adText = adText;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		if (StringUtils.isNotBlank(adType)) {
			setItemId(adUrl);
			switch (adType) {
				case WebConstant.JG_RECOMMEND_INVITATION:
					this.adUrl = SNSConstants.JG_INVITATION_URL + adUrl;
					break;
				case WebConstant.JG_RECOMMEND_PROJECT:
					this.adUrl = SNSConstants.JG_PROJECT_URL + adUrl;
					break;
				default:
					this.adUrl = adUrl;
					break;
			}
		} else {
			this.adUrl = adUrl;
		}
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getAdImgPath() {
		return adImgPath;
	}

	public void setAdImgPath(String adImgPath) {
		this.adImgPath = adImgPath;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public LookInvitationBO getLookInvitationBO() {
		return lookInvitationBO;
	}

	public void setLookInvitationBO(LookInvitationBO lookInvitationBO) {
		this.lookInvitationBO = lookInvitationBO;
	}

	public InformationBO getInformationBO() {
		return informationBO;
	}

	public void setInformationBO(InformationBO informationBO) {
		this.informationBO = informationBO;
	}

	public ShopGoodsBo getShopGoodsBo() {
		return shopGoodsBo;
	}

	public void setShopGoodsBo(ShopGoodsBo shopGoodsBo) {
		this.shopGoodsBo = shopGoodsBo;
	}

	public ShopStoreBO getShopStoreBO() {
		return shopStoreBO;
	}

	public void setShopStoreBO(ShopStoreBO shopStoreBO) {
		this.shopStoreBO = shopStoreBO;
	}

	public PGroupGoodsBO getpGroupGoodsBO() {
		return pGroupGoodsBO;
	}

	public void setpGroupGoodsBO(PGroupGoodsBO pGroupGoodsBO) {
		this.pGroupGoodsBO = pGroupGoodsBO;
	}

	public PStoreInfoBO getpStoreInfoBO() {
		return pStoreInfoBO;
	}

	public void setpStoreInfoBO(PStoreInfoBO pStoreInfoBO) {
		this.pStoreInfoBO = pStoreInfoBO;
	}

	public Integer getNativeType() {
		return nativeType;
	}

	public void setNativeType(Integer nativeType) {
		this.nativeType = nativeType;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public boolean isHasMobilePrice() {
		return hasMobilePrice;
	}

	public void setHasMobilePrice(boolean hasMobilePrice) {
		this.hasMobilePrice = hasMobilePrice;
	}

	public Integer getVo_is_juanpi() {
		if (vo_is_juanpi != null ) {
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
		return vo_tuangou_price;
	}

	public void setVo_tuangou_price(BigDecimal vo_tuangou_price) {
		this.vo_tuangou_price = vo_tuangou_price;
	}

}