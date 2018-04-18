package com.sinco.carnation.goldEgg.bo;

import com.sinco.carnation.goldEgg.model.ActGlodEgg;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class ActGlodEggBO extends ActGlodEgg {
	private ActivityHotSaleBO activityHotSale;

	public ActivityHotSaleBO getActivityHotSale() {
		return activityHotSale;
	}

	public void setActivityHotSale(ActivityHotSaleBO activityHotSale) {
		this.activityHotSale = activityHotSale;
	}

}