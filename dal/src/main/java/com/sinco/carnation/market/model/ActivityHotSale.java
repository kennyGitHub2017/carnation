package com.sinco.carnation.market.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class ActivityHotSale extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7410185918670966907L;

	/** id主键 **/
	private Long id;

	/** 活动名称 **/
	private String hotName;

	/** 首页图片 **/
	private String firstImage;

	/** 活动头部图片url **/
	private String headImage;

	/** 活动脚部图片url **/
	private String footImage;

	/** code编码 **/
	private String vcode;

	/** 开始时间 **/
	private Date startTime;

	/** 结束时间 **/
	private Date endTime;

	/** 是否启用 **/
	private Byte isEnabled;

	/** 创建人 **/
	private Long createBy;

	/** 创建时间 **/
	private Date createTime;

	/** 修改人 **/
	private Long modifyBy;

	/** 修改时间 **/
	private Date modifyTime;

	/** 删除状态，0-正常,1-删除 **/
	private Byte deleteStatus;

	/** 活动类型，1其他 0,0元购 **/
	private String actType;

	/** 背景颜色 **/
	private String backgroundcolor;

	/** 广告连接地址 **/
	private String adsUrl;

	/** 图片大小 **/
	private Long imageSize;

	/** 更新标识,每次修改+1 **/
	private Integer updateMark;

	/** 弹框图片 **/
	private String alterPic;

	/** 首次打开APP显示0否1是 **/
	private Boolean firstOpen;

	/** 自定义时间段打开0否1是 **/
	private Boolean customOpen;

	/** 浮动图片 **/
	private String floatPic;

	/** 显示浮动图片0否1是 **/
	private Boolean floatPicShow;

	/** 弹框开始时间（24小时制，分钟） **/
	private Integer openStartTime;

	/** 弹框结束时间（24小时制，分钟） **/
	private Integer openEndTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotName() {
		return hotName;
	}

	public void setHotName(String hotName) {
		this.hotName = hotName;
	}

	public String getFirstImage() {
		return firstImage;
	}

	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getFootImage() {
		return footImage;
	}

	public void setFootImage(String footImage) {
		this.footImage = footImage;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Byte getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Byte isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getBackgroundcolor() {
		return backgroundcolor;
	}

	public void setBackgroundcolor(String backgroundcolor) {
		this.backgroundcolor = backgroundcolor;
	}

	public String getAdsUrl() {
		return adsUrl;
	}

	public void setAdsUrl(String adsUrl) {
		this.adsUrl = adsUrl;
	}

	public Long getImageSize() {
		return imageSize;
	}

	public void setImageSize(Long imageSize) {
		this.imageSize = imageSize;
	}

	public Integer getUpdateMark() {
		return updateMark;
	}

	public void setUpdateMark(Integer updateMark) {
		this.updateMark = updateMark;
	}

	public String getAlterPic() {
		return alterPic;
	}

	public void setAlterPic(String alterPic) {
		this.alterPic = alterPic;
	}

	public Boolean getFirstOpen() {
		return firstOpen;
	}

	public void setFirstOpen(Boolean firstOpen) {
		this.firstOpen = firstOpen;
	}

	public Boolean getCustomOpen() {
		return customOpen;
	}

	public void setCustomOpen(Boolean customOpen) {
		this.customOpen = customOpen;
	}

	public String getFloatPic() {
		return floatPic;
	}

	public void setFloatPic(String floatPic) {
		this.floatPic = floatPic;
	}

	public Boolean getFloatPicShow() {
		return floatPicShow;
	}

	public void setFloatPicShow(Boolean floatPicShow) {
		this.floatPicShow = floatPicShow;
	}

	public Integer getOpenStartTime() {
		return openStartTime;
	}

	public void setOpenStartTime(Integer openStartTime) {
		this.openStartTime = openStartTime;
	}

	public Integer getOpenEndTime() {
		return openEndTime;
	}

	public void setOpenEndTime(Integer openEndTime) {
		this.openEndTime = openEndTime;
	}
}