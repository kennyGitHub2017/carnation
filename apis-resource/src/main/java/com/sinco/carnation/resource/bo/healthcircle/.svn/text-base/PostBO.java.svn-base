package com.sinco.carnation.resource.bo.healthcircle;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PostBO", desc = "健康圈帖子")
public class PostBO {

	@JsonProperty("currentIndex")
	@FieldMapping(desc = "当前索引状态")
	private String currentIndex;

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	@JsonProperty("id")
	@FieldMapping(desc = "帖子id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	@JsonProperty("title")
	@FieldMapping(desc = "帖子标题")
	private String title;

	@JsonProperty("content")
	@FieldMapping(desc = "帖子内容")
	private String content;

	@JsonProperty("praiseNum")
	@FieldMapping(desc = "帖子点赞数")
	private Integer praiseNum;

	@JsonProperty("evaluateNum")
	@FieldMapping(desc = "帖子评论数")
	private Integer evaluateNum;

	/*@JsonProperty("thumbnail")
	@FieldMapping( desc = "帖子图片路径")
	private String thumbnail;*/

	@JsonProperty("nickname")
	@FieldMapping(desc = "发帖人名称")
	private String nickname;

	@JsonProperty("location")
	@FieldMapping(desc = "发帖人位置信息")
	private String location;

	@JsonProperty("headImgPath")
	@FieldMapping(desc = "用户头像")
	private String headImgPath;

	@JsonProperty("sex")
	@FieldMapping(desc = "用户性别,1:男, 2:女 保密 -1")
	private Integer sex;

	@JsonProperty("level")
	@FieldMapping(desc = "用户等级")
	private Integer level;

	@JsonProperty("ispraise")
	@FieldMapping(desc = "当前用户是否点赞|0没有,1有")
	private Integer ispraise;

	@JsonProperty("images")
	@FieldMapping(desc = "图片集合")
	private String[] imagesList;

	@JsonProperty("praiseList")
	@FieldMapping(desc = "点赞头像集合")
	private List<String> praiseList;

	@JsonProperty("labelIds")
	@FieldMapping(desc = "标签ids:1|2")
	private String labelIds;

	@JsonProperty("uid")
	@FieldMapping(desc = "发帖人uid")
	private Long uid;

	@JsonProperty("evaluateList")
	@FieldMapping(desc = "评论列表")
	private List<PostEvaluateBO> evaluateList;

	public List<PostEvaluateBO> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<PostEvaluateBO> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public List<String> getPraiseList() {
		return praiseList;
	}

	public void setPraiseList(List<String> praiseList) {
		this.praiseList = praiseList;
	}

	public String getLabelIds() {
		return labelIds;
	}

	public void setLabelIds(String labelIds) {
		this.labelIds = labelIds;
	}

	public String[] getImagesList() {
		return imagesList;
	}

	public void setImagesList(String[] imagesList) {
		this.imagesList = imagesList;
	}

	public Integer getIspraise() {
		return ispraise;
	}

	public void setIspraise(Integer ispraise) {
		this.ispraise = ispraise;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/*public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	*/
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getEvaluateNum() {
		return evaluateNum;
	}

	public void setEvaluateNum(Integer evaluateNum) {
		this.evaluateNum = evaluateNum;
	}

}