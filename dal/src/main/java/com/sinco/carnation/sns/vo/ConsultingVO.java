package com.sinco.carnation.sns.vo;

public class ConsultingVO {

	/**  **/
	private Long id;

	/** 专家用户id **/
	private Long expertsUserId;

	/** 提问用户id **/
	private Long userId;

	/** 提问标题 **/
	private String title;

	/** 提问图片 **/
	private String images;

	/** 是否删除：0未删除，1已删除 **/
	private Boolean isDeleted;

	/** 提问内容 **/
	private String content;

	/** 专家名称 **/
	private String expName;

	private String beginTimeStr;

	private String endTimeStr;

	public Long getId() {
		return id;
	}

	public Long getExpertsUserId() {
		return expertsUserId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getImages() {
		return images;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public String getContent() {
		return content;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setExpertsUserId(Long expertsUserId) {
		this.expertsUserId = expertsUserId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public String getBeginTimeStr() {
		return beginTimeStr;
	}

	public void setBeginTimeStr(String beginTimeStr) {
		this.beginTimeStr = beginTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}
}