package vc.thinker.b2b2c.model.elong.mo;

public class ElongGeoMO {

	// 地域名称
	private String areaName;
	// 地域编号
	private Long areaCode;
	// 是否热门城市
	private Boolean isGroupHot;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Long areaCode) {
		this.areaCode = areaCode;
	}

	public Boolean getIsGroupHot() {
		return isGroupHot;
	}

	public void setIsGroupHot(Boolean isGroupHot) {
		this.isGroupHot = isGroupHot;
	}

}