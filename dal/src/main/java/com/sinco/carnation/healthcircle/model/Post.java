package com.sinco.carnation.healthcircle.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class Post extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 帖子标题 **/
	private String title;

	/** 点赞数 **/
	private Integer praiseNum;

	/** 评论数 **/
	private Integer evaluateNum;

	/** 阅读数 **/
	private Integer readNum;

	/** 发帖位置信息 **/
	private String location;

	/** 帖子内容 **/
	private String content;

	/** 帖子类型帖子类型：0默认，1热门 **/
	private Integer postType;

	/** 发帖人id **/
	private Long userId;

	/** 发帖人姓名 **/
	private String nickname;

	/**
	 * 缩略图地址
	 */
	private String thumbnail;

	/**
	 * 用户头像
	 */
	private String headImgPath;

	/**
	 * 性别
	 * 
	 * @return
	 */
	private Integer sex;

	/**
	 * 帖子前三条评论
	 */
	private String topThirdEvaluate;

	/**
	 * 用户等级
	 * 
	 * @return
	 */
	private Integer level;
	/** 当前用户是否点赞 **/
	private Integer ispraise;
	/** 图片集合 **/
	private String[] imagesList;
	/** 点赞头像集合 **/
	private List<String> praiseList;
	/** label_ids **/
	private String labelIds;
	/** 发帖人uid **/
	private Long uid;
	/** 时间格式显示 **/
	private String addtiemFormat;
	
	/** 是否已添加积分 **/
	private Integer isAddIntegral;

	/** 1:推荐到健康管理首页 **/
	private Integer ispush;

	private List<PostEvaluate> evaluateList;

	public List<PostEvaluate> getEvaluateList() {
		return evaluateList;
	}

	public void setEvaluateList(List<PostEvaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}

	public Integer getIspush() {
		return ispush;
	}

	public void setIspush(Integer ispush) {
		this.ispush = ispush;
	}

	public String getAddtiemFormat() {
		return addtiemFormat;
	}

	public void setAddtiemFormat(String addtiemFormat) {
		this.addtiemFormat = addtiemFormat;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPostType() {
		return postType;
	}

	public void setPostType(Integer postType) {
		this.postType = postType;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopThirdEvaluate() {
		return topThirdEvaluate;
	}

	public void setTopThirdEvaluate(String topThirdEvaluate) {
		this.topThirdEvaluate = topThirdEvaluate;
	}

	public Integer getIsAddIntegral() {
		return isAddIntegral;
	}

	public void setIsAddIntegral(Integer isAddIntegral) {
		this.isAddIntegral = isAddIntegral;
	}
}