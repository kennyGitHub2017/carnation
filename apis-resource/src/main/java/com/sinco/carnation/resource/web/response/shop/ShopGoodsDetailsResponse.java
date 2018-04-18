package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.GoodsConsultBO;
import com.sinco.carnation.resource.bo.shop.ShopEvaluateBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;

/**
 * 商品详情
 * 
 * @author king
 * 
 */
public class ShopGoodsDetailsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("goodsDetails")
	@ReturnMapping(desc = "商品详情")
	private ShopGoodsBo goodsDetails;

	@JsonProperty("shopEvaluateList")
	@ReturnMapping(desc = "商品评价列表")
	private List<ShopEvaluateBO> shopEvaluateList;

	@JsonProperty("goodsConsultList")
	@ReturnMapping(desc = "商品咨询列表")
	private List<GoodsConsultBO> goodsConsultList;

	@JsonProperty("totalSize")
	@ReturnMapping(desc = "总记录数")
	private Long totalSize;

	@JsonProperty("zeroFlag")
	@ReturnMapping(desc = "0元购标识 1标识是0云购")
	private Integer zeroFlag;

	@JsonProperty("isBought")
	@ReturnMapping(desc = "是否买过true买过, false没有")
	private Boolean isBought;
	
	@JsonProperty("warnInfo")
	@ReturnMapping(desc = "提示信息")
	private String warnInfo;

	public ShopGoodsBo getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(ShopGoodsBo goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public List<ShopEvaluateBO> getShopEvaluateList() {
		return shopEvaluateList;
	}

	public void setShopEvaluateList(List<ShopEvaluateBO> shopEvaluateList) {
		this.shopEvaluateList = shopEvaluateList;
	}

	public List<GoodsConsultBO> getGoodsConsultList() {
		return goodsConsultList;
	}

	public void setGoodsConsultList(List<GoodsConsultBO> goodsConsultList) {
		this.goodsConsultList = goodsConsultList;
	}

	public Integer getZeroFlag() {
		return zeroFlag;
	}

	public void setZeroFlag(Integer zeroFlag) {
		this.zeroFlag = zeroFlag;
	}

	public Boolean getIsBought() {
		return isBought;
	}

	public void setIsBought(Boolean isBought) {
		this.isBought = isBought;
	}

	public String getWarnInfo() {
		return warnInfo;
	}

	public void setWarnInfo(String warnInfo) {
		this.warnInfo = warnInfo;
	}

}
