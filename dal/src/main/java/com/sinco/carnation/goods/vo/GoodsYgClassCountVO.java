package com.sinco.carnation.goods.vo;

public class GoodsYgClassCountVO {

	private Long parentId;

	private Boolean display;

	private Integer count;

	private Boolean recommend;

	private Boolean isyg;

	public Boolean getIsyg() {
		return isyg;
	}

	public void setIsyg(Boolean isyg) {
		this.isyg = isyg;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}
}
