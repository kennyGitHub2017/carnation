package com.sinco.carnation.resource.vo.favorites;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class RecommendVO extends BasicParamVO {

	@Param(desc = "推荐位置Code;由后台人员提供")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String posCode;

	@Param(desc = "查询时间戳")
	private String timeStamp;

	@Param(desc = "城市id,主要用于服务的推荐位")
	private Long cityId;

	@Param(desc = "纬度")
	private Double lon;

	@Param(desc = "经度")
	private Double lat;

	public String getPosCode() {
		return posCode;
	}

	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

}
