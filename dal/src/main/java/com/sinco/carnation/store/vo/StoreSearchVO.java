package com.sinco.carnation.store.vo;

public class StoreSearchVO {

	private Long classId;

	private String keyword;

	private Long cityId;

	private Long areaId;

	/** 经度 **/
	private Double storeLat;

	/** 纬度 **/
	private Double storeLon;

	/**
	 * 距离，米
	 */
	private Integer distance;

	/**
	 * 是否有服务
	 */
	private Boolean isGoods;

	public Boolean getIsGoods() {
		return isGoods;
	}

	public void setIsGoods(Boolean isGoods) {
		this.isGoods = isGoods;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
}
