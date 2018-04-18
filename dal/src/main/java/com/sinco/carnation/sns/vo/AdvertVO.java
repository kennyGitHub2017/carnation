package com.sinco.carnation.sns.vo;

import com.sinco.carnation.sns.model.Advert;

/**
 * VO用于页面传值
 * 
 * @author grey
 */
public class AdvertVO extends Advert {

	private static final long serialVersionUID = -665889202989892554L;

	// /** 广告名称 */
	// private String adTitle;
	// /** 广告状态,0为待审核，1为审核通过,-1未审核失败 **/
	// private Integer adStatus;
	//
	// public Integer getAdStatus() {
	// return adStatus;
	// }
	//
	// public void setAdStatus(Integer adStatus) {
	// this.adStatus = adStatus;
	// }
	//
	// public String getAdTitle() {
	// return adTitle;
	// }
	//
	// public void setAdTitle(String adTitle) {
	// this.adTitle = adTitle;
	// }

	private String adApCode;
	private String strAdBeginDate; // 用于接收日期控件传入的String类型的日期
	private String strAdEndDate;// 用于接收日期控件传入的String类型的日期

	public String getAdApCode() {
		return adApCode;
	}

	public void setAdApCode(String adApCode) {
		this.adApCode = adApCode;
	}

	public String getStrAdBeginDate() {
		return strAdBeginDate;
	}

	public void setStrAdBeginDate(String strAdBeginDate) {
		this.strAdBeginDate = strAdBeginDate;
	}

	public String getStrAdEndDate() {
		return strAdEndDate;
	}

	public void setStrAdEndDate(String strAdEndDate) {
		this.strAdEndDate = strAdEndDate;
	}

}