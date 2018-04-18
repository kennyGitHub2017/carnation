package com.sinco.carnation.user.bo;

import java.util.Date;

import com.sinco.carnation.user.model.UserExperts;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserExpertsBO extends UserExperts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer favoritesCount;
	// 专家登录名
	private String loginName;
	// 用户昵称
	private String nickName;
	private Date createTime;
	// 是否收藏
	private Boolean isFavor;
	// 是否点赞
	private Boolean isPraise;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(Integer favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Boolean getIsFavor() {
		return isFavor;
	}

	public Boolean getIsPraise() {
		return isPraise;
	}

	public void setIsFavor(Boolean isFavor) {
		this.isFavor = isFavor;
	}

	public void setIsPraise(Boolean isPraise) {
		this.isPraise = isPraise;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}