package com.sinco.carnation.sns.bo;

import java.util.Date;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sns.model.Advert;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AdvertBO extends Advert implements Comparable<AdvertBO> {

	private static final long serialVersionUID = -1489606611405551334L;

	/** 所属广告位 */
	private String apTitle;
	/** 广告类别,目前有幻灯slide、滚动scroll、图片img、文字text、背景幻灯bg_slide5种 */
	private String apType;
	/** 0为关闭，1为启用 */
	private Integer apStatus;
	/** 用户名(user_manager表) */
	private String userName;

	private Date nowTime;
	/** 查询时间戳 **/
	private String timeStamp;

	private Integer storeId;
	private Integer stroeCity;
	private Integer goodsId;
	private Integer goodsCity;
	private String apCode;

	/** 广告显示类型(1:Html5页面,2:原生页面) */
	private Integer nativeType;

	public String getApCode() {
		return apCode;
	}

	public void setApCode(String apCode) {
		this.apCode = apCode;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Integer getStroeCity() {
		return stroeCity;
	}

	public void setStroeCity(Integer stroeCity) {
		this.stroeCity = stroeCity;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsCity() {
		return goodsCity;
	}

	public void setGoodsCity(Integer goodsCity) {
		this.goodsCity = goodsCity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getApStatus() {
		return apStatus;
	}

	public void setApStatus(Integer apStatus) {
		this.apStatus = apStatus;
	}

	public String getApTitle() {
		return apTitle;
	}

	public void setApTitle(String apTitle) {
		this.apTitle = apTitle;
	}

	public String getApType() {
		return apType;
	}

	public void setApType(String apType) {
		this.apType = apType;
	}

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public String getTimeStamp() {
		if (null != getNowTime()) {
			return CommUtil.formatLongDate(getNowTime());
		}
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof AdvertBO))
			return false;
		AdvertBO a = (AdvertBO) object;
		return a.getId() != null && (a.getId()).equals(this.getId());
	}

	@Override
	public int compareTo(AdvertBO o) {
		return (this.getAdSlideSequence()).compareTo(o.getAdSlideSequence());
	}

	public Integer getNativeType() {
		return nativeType;
	}

	public void setNativeType(Integer nativeType) {
		this.nativeType = nativeType;
	}

}