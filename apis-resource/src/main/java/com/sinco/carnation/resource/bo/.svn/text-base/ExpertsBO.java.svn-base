package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserExperts", desc = "专家信息")
public class ExpertsBO {

	/** 用户id **/
	@JsonProperty("uid")
	@FieldMapping(desc = "用户Id")
	private Long uid;

	/** 姓名 **/
	@JsonProperty("name")
	@FieldMapping(desc = "用户名称")
	private String name;

	/** 职称 **/
	@JsonProperty("title")
	@FieldMapping(desc = "职称")
	private String title;

	/** 性别 1，男 2，女 **/
	@JsonProperty("sex")
	@FieldMapping(desc = "性别")
	private Integer sex;

	/** 介绍 **/
	@JsonProperty("description")
	@FieldMapping(desc = "介绍")
	private String description;

	/** 头像路径 **/
	@JsonProperty("headImgPath")
	@FieldMapping(desc = "头像路径")
	private String headImgPath;

	/** 邮箱 **/
	@JsonProperty("email")
	@FieldMapping(desc = "邮箱")
	private String email;

	/** 手机 **/
	@JsonProperty("mobile")
	@FieldMapping(desc = "手机")
	private String mobile;

	/** 状态 **/
	@JsonProperty("status")
	@FieldMapping(desc = "用户状态")
	private String status;

	/** 专家类型 **/
	@JsonProperty("expertType")
	@FieldMapping(desc = "用户Id")
	private Integer expertType;

	/** 点赞用户信息，记录用户id，使用逗号间隔1,2,3,4,5,6,7, **/
	@JsonProperty("praiseInfo")
	@FieldMapping(desc = "点赞用户信息，记录用户id，使用逗号间隔1,2,3,4,5,6,7,")
	private String praiseInfo;

	/** 点赞数量 **/
	@JsonProperty("praiseCount")
	@FieldMapping(desc = "点赞数量")
	private Integer praiseCount;

	/** 收藏数量 **/
	@JsonProperty("favorCount")
	@FieldMapping(desc = "收藏数量")
	private Integer favorCount;

	@JsonProperty("favorInfo")
	@FieldMapping(desc = "收藏用户信息")
	private String favorInfo;

	// 是否收藏
	@JsonProperty("isFavor")
	@FieldMapping(desc = "是否收藏")
	private Boolean isFavor;
	// 是否点赞
	@JsonProperty("isPraise")
	@FieldMapping(desc = "是否点赞")
	private Boolean isPraise;

	@JsonProperty("desc")
	@FieldMapping(desc = "简介|已过滤标签")
	private String desc;

	public String getPraiseInfo() {
		return praiseInfo;
	}

	public void setPraiseInfo(String praiseInfo) {
		this.praiseInfo = praiseInfo;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getExpertType() {
		return expertType;
	}

	public void setExpertType(Integer expertType) {
		this.expertType = expertType;
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

	public Integer getFavorCount() {
		return favorCount;
	}

	public String getFavorInfo() {
		return favorInfo;
	}

	public void setFavorCount(Integer favorCount) {
		this.favorCount = favorCount;
	}

	public void setFavorInfo(String favorInfo) {
		this.favorInfo = favorInfo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
