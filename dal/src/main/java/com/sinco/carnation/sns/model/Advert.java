package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Advert extends BaseModel {

	private static final long serialVersionUID = 3203089819153475779L;

	/**  **/
	private Long id;
	/**  **/
	private Date addTime;
	/**  **/
	private Integer deleteStatus;
	/**  **/
	private Date adBeginTime;
	/** 广告点击数 **/
	private Integer adClickNum;
	/**  **/
	private Date adEndTime;
	/** 广告消耗金币数 **/
	private Integer adGold;
	/** 幻灯图片排序，按照升序 **/
	private Integer adSlideSequence;
	/** 广告状态,0为待审核，1为审核通过,-1未审核失败 **/
	private Integer adStatus;
	/**  **/
	private String adText;
	/** 广告名称 **/
	private String adTitle;
	/** 广告链接 **/
	private String adUrl;
	/** 1:资讯（链接），2商品，3商户，4云尚项目（链接）, 5服务商户 6服务 **/
	private String adType;
	/** 广告图片路径 **/
	private String adImgPath;
	/** 广告位 **/
	private Long adApId;
	/** 广告投放人 **/
	private Long adUserId;
	/** 背景幻灯时背景色 **/
	private String bgColor;
	/** 城市ID **/
	private Long areaId;

	/** 1：默认是html5链接页面，2：app原生页面 **/
	private Integer nativeType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Date getAdBeginTime() {
		return adBeginTime;
	}

	public void setAdBeginTime(Date adBeginTime) {
		this.adBeginTime = adBeginTime;
	}

	public Integer getAdClickNum() {
		return adClickNum;
	}

	public void setAdClickNum(Integer adClickNum) {
		this.adClickNum = adClickNum;
	}

	public Date getAdEndTime() {
		return adEndTime;
	}

	public void setAdEndTime(Date adEndTime) {
		this.adEndTime = adEndTime;
	}

	public Integer getAdGold() {
		return adGold;
	}

	public void setAdGold(Integer adGold) {
		this.adGold = adGold;
	}

	public Integer getAdSlideSequence() {
		return adSlideSequence;
	}

	public void setAdSlideSequence(Integer adSlideSequence) {
		this.adSlideSequence = adSlideSequence;
	}

	public Integer getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(Integer adStatus) {
		this.adStatus = adStatus;
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
		this.adUrl = adUrl;
	}

	public String getAdImgPath() {
		return adImgPath;
	}

	public void setAdImgPath(String adImgPath) {
		this.adImgPath = adImgPath;
	}

	public Long getAdApId() {
		return adApId;
	}

	public void setAdApId(Long adApId) {
		this.adApId = adApId;
	}

	public Long getAdUserId() {
		return adUserId;
	}

	public void setAdUserId(Long adUserId) {
		this.adUserId = adUserId;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getNativeType() {
		return nativeType;
	}

	public void setNativeType(Integer nativeType) {
		this.nativeType = nativeType;
	}

}