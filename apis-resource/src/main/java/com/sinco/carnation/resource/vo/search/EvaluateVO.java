package com.sinco.carnation.resource.vo.search;

public class EvaluateVO {
	private Long goodsId;// 商品id

	private Integer description;// 描述相符

	private Integer shipEvaluate;// 发货速度

	private Integer serviceEvaluate;// 服务态度

	private Integer evaluateBuyerVal;// 评价

	private String evaluateInfo;// 评语

	private String imgPath;// 图片路径

	public Integer getDescription() {
		return description;
	}

	public Integer getShipEvaluate() {
		return shipEvaluate;
	}

	public Integer getServiceEvaluate() {
		return serviceEvaluate;
	}

	public Integer getEvaluateBuyerVal() {
		return evaluateBuyerVal;
	}

	public String getEvaluateInfo() {
		return evaluateInfo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setDescription(Integer description) {
		this.description = description;
	}

	public void setShipEvaluate(Integer shipEvaluate) {
		this.shipEvaluate = shipEvaluate;
	}

	public void setServiceEvaluate(Integer serviceEvaluate) {
		this.serviceEvaluate = serviceEvaluate;
	}

	public void setEvaluateBuyerVal(Integer evaluateBuyerVal) {
		this.evaluateBuyerVal = evaluateBuyerVal;
	}

	public void setEvaluateInfo(String evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}
