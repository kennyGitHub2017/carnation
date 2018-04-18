package com.sinco.carnation.healthcircle.vo;

public class PostVO {
	private Integer postType;// 提诶子类型 帖子类型帖子类型：0默认，1热门

	private Long labelId;

	private Long userId;

	private Integer ispush;

	public Integer getIspush() {
		return ispush;
	}

	public void setIspush(Integer ispush) {
		this.ispush = ispush;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLabelId() {
		return labelId;
	}

	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}

	public Integer getPostType() {
		return postType;
	}

	public void setPostType(Integer postType) {
		this.postType = postType;
	}

}