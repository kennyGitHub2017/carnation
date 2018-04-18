package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Circle", desc = "圈子")
public class CircleListBO {

	@JsonProperty("id")
	@FieldMapping(desc = "圈子Id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "时间")
	private Date addTime;

	@JsonProperty("attentionCount")
	@FieldMapping(desc = "总关注人数")
	private Integer attentionCount;

	@JsonProperty("classId")
	@FieldMapping(desc = "圈子所属分类id")
	private Long classId;

	@JsonProperty("className")
	@FieldMapping(desc = "圈子所属分类名称")
	private String className;

	@JsonProperty("invitationCount")
	@FieldMapping(desc = "总帖子数量")
	private Integer invitationCount;

	@JsonProperty("recommend")
	@FieldMapping(desc = "1为推荐")
	private Integer recommend;

	@JsonProperty("title")
	@FieldMapping(desc = "圈子标题")
	private String title;

	@JsonProperty("userName")
	@FieldMapping(desc = "圈子创建人姓名")
	private String userName;

	@JsonProperty("content")
	@FieldMapping(desc = "圈子说明 ")
	private String content;

	@JsonProperty("photoInfo")
	@FieldMapping(desc = "圈子图标信息 ")
	private String photoInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAttentionCount() {
		return attentionCount;
	}

	public void setAttentionCount(Integer attentionCount) {
		this.attentionCount = attentionCount;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getInvitationCount() {
		return invitationCount;
	}

	public void setInvitationCount(Integer invitationCount) {
		this.invitationCount = invitationCount;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhotoInfo() {
		return photoInfo;
	}

	public void setPhotoInfo(String photoInfo) {
		this.photoInfo = photoInfo;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}
