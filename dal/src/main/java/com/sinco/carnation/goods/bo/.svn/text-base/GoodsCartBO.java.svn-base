package com.sinco.carnation.goods.bo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCart;

/**
 * 
 * BO 用于返回数据
 * 
 */@SuppressWarnings("serial")

public class GoodsCartBO extends GoodsCart {

	private Goods goods;

	private Integer storeStatus;

	private String storeSecondDomain;

	private String storeName;// 店铺名称

	private List<GoodsSpecPropertyBO> gsps;// 对应的规格

	/**
	 * 得到根据当前情况的价格
	 * 
	 * @param isIntegral
	 *            是否积分兑购
	 * @param isMobile
	 *            是否手机端
	 * @return
	 */
	public BigDecimal getCurrentPrice(boolean isIntegral, boolean isMobile) {
		if (isIntegral && this.getExchangeIntegral() != null && this.getGoodsIntegralPrice() != null
				&& this.getExchangeIntegral() > 0) {
			return this.getGoodsIntegralPrice();
		}
		if (isMobile && this.getGoodsMobilePrice() != null && this.getGoodsMobilePrice().doubleValue() > 0) {
			return this.getGoodsMobilePrice();
		}
		return this.getPrice();
	}

	/**
	 * 得到规格id array
	 * 
	 * @return
	 */
	public String[] getGspsIdArray() {
		if (gsps != null) {
			String[] array = new String[gsps.size()];
			for (int i = 0; i < array.length; i++) {
				array[i] = String.valueOf(gsps.get(i).getId());
			}
			Arrays.sort(array);
			return array;
		}
		return null;
	}

	/**
	 * 得到规格id array
	 * 
	 * @return
	 */
	public String[] getCartGspsId() {
		if (getCartGsp() != null) {
			return getCartGsp().split(",");
		}
		return null;
	}

	/**
	 * 得到总价
	 * 
	 * @return
	 */
	public Double getTotlePrice() {
		if (getCount() != null && getPrice() != null) {
			return getPrice().multiply(new BigDecimal(getCount())).doubleValue();
		}
		return getPrice().doubleValue();
	}

	public Goods getGoods() {
		if (goods != null) {
			goods.setId(this.getGoodsId());
		}
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreSecondDomain() {
		return storeSecondDomain;
	}

	public void setStoreSecondDomain(String storeSecondDomain) {
		this.storeSecondDomain = storeSecondDomain;
	}

	public List<GoodsSpecPropertyBO> getGsps() {
		return gsps;
	}

	public void setGsps(List<GoodsSpecPropertyBO> gsps) {
		this.gsps = gsps;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}