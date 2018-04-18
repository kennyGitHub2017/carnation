package com.sinco.carnation.o2o.vo;

/**
 * <p>
 * Title: GroupCaseGoodsQueryCondVO.java
 * </p>
 * 
 * <p>
 * Description: 团购橱窗商品查询条件
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author t2w
 * @date 2015-9-8
 * @version 1.0.1
 */
public class GroupCaseGoodsQueryCondVO {
	private Long catagroyId;// 类别ID
	private Long cityId;// 城市ID
	private String goodsName;// 服务名称

	public Long getCatagroyId() {
		return catagroyId;
	}

	public void setCatagroyId(Long catagroyId) {
		this.catagroyId = catagroyId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
