package com.sinco.carnation.sns.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class CircleInvitation extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -471381745322479547L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 所属圈子 **/
	private Long circleId;

	/** 所属圈子名称 **/
	private String circleName;

	/** 缩略图 **/
	private String thumbnail;

	/** 帖子是否加精，1为加精，一个圈子中可有多个加精帖子 **/
	private Integer invitaionPerfect;

	/** 帖子是否置顶，1为置顶，一个圈子中只有一个置顶帖子 **/
	private Integer invitaionTop;

	/** 帖子点赞数量 **/
	private Integer praiseCount;

	/** 帖子总回复数量 **/
	private Integer replyCount;

	/** 帖子标题 **/
	private String title;

	/** 帖子类型，分为“原创”、“转载” **/
	private String type;

	/** 发帖人姓名 **/
	private String userName;

	/** 发帖人 **/
	private Long userId;

	/**  **/
	private Integer circleType;

	/** 帖子详情 **/
	private String content;

	/**
	 * 帖子的附加信息，包括附加商品、店铺，使用json管理，一个帖子最多附件7个商品、店铺信息,格式为：[{"item_id":1,"item_type":"goods","item_img":"xxxx",
	 * "item_url":"xxxx"}]
	 **/
	private String itemInfo;

	/**
	 * 帖子图片信息,多图片，使用json管理[{"id":3234,"src":"upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg"},{"id":
	 * 3234,"src":"upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg"},{"id":3234,"src":
	 * "upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg"
	 * },{"id":3234,"src":"upload/store/1/938a670f-081f-4e37-b355-142a551ef0bb.jpg"}]
	 **/
	private String photoInfo;

	/** 帖子点赞用户信息，记录用户id，使用逗号间隔1,2,3,4,5,6,7, **/
	private String praiseInfo;

	/** 最后回复时间 **/
	private Date updateTime;

	/** 最后回复人 **/
	private String replyName;

	/** 帖子收藏用户信息，记录用户id，使用逗号间隔1,2,3,4,5,6,7, **/
	private String favoritesInfo;

	/** 帖子收藏数 **/
	private Integer favoritesCount;

	/** 图片 **/
	private String pic;

	/** 分享时显示的下载图片 */
	private String appDownloadPic;

	private String keyWordIdStr; // 关键字拼接字符串

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

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

	public Long getCircleId() {
		return circleId;
	}

	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public Integer getInvitaionPerfect() {
		return invitaionPerfect;
	}

	public void setInvitaionPerfect(Integer invitaionPerfect) {
		this.invitaionPerfect = invitaionPerfect;
	}

	public Integer getInvitaionTop() {
		return invitaionTop;
	}

	public void setInvitaionTop(Integer invitaionTop) {
		this.invitaionTop = invitaionTop;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCircleType() {
		return circleType;
	}

	public void setCircleType(Integer circleType) {
		this.circleType = circleType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public String getPhotoInfo() {
		return photoInfo;
	}

	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}

	public String getPraiseInfo() {
		return praiseInfo;
	}

	public void setPraiseInfo(String praiseInfo) {
		this.praiseInfo = praiseInfo;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getFavoritesInfo() {
		return favoritesInfo;
	}

	public void setFavoritesInfo(String favoritesInfo) {
		this.favoritesInfo = favoritesInfo;
	}

	public Integer getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(Integer favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public String getAppDownloadPic() {
		return appDownloadPic;
	}

	public void setAppDownloadPic(String appDownloadPic) {
		this.appDownloadPic = appDownloadPic;
	}

	public String getKeyWordIdStr() {
		return keyWordIdStr;
	}

	public void setKeyWordIdStr(String keyWordIdStr) {
		this.keyWordIdStr = keyWordIdStr;
	}

}