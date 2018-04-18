package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserShare extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1098153051915263323L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 分享商品的id **/
	private Long shareGoodsId;

	/** 分享商品的名称 **/
	private String shareGoodsName;

	/** 分享商品的主照片 **/
	private String shareGoodsPhoto;

	/** 分享用户的id **/
	private Long userId;

	/** 分享用户的name **/
	private String userName;

	/** 分享的内容 **/
	private String shareContent;

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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getShareGoodsId() {
		return shareGoodsId;
	}

	public void setShareGoodsId(Long shareGoodsId) {
		this.shareGoodsId = shareGoodsId;
	}

	public String getShareGoodsName() {
		return shareGoodsName;
	}

	public void setShareGoodsName(String shareGoodsName) {
		this.shareGoodsName = shareGoodsName;
	}

	public String getShareGoodsPhoto() {
		return shareGoodsPhoto;
	}

	public void setShareGoodsPhoto(String shareGoodsPhoto) {
		this.shareGoodsPhoto = shareGoodsPhoto;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShareContent() {
		return shareContent;
	}

	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
}