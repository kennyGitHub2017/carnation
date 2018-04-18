package com.sinco.carnation.sys.bo;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AreaMPBO {
	private long id;
	// 艺龙城市code
	private long elongAreaCityCode;
	// 艺龙城市区域code
	private long elongAreaDistractCode;
	// 云尚code
	private long ysAreaCode;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getElongAreaCityCode() {
		return elongAreaCityCode;
	}

	public void setElongAreaCityCode(long elongAreaCityCode) {
		this.elongAreaCityCode = elongAreaCityCode;
	}

	public long getElongAreaDistractCode() {
		return elongAreaDistractCode;
	}

	public void setElongAreaDistractCode(long elongAreaDistractCode) {
		this.elongAreaDistractCode = elongAreaDistractCode;
	}

	public long getYsAreaCode() {
		return ysAreaCode;
	}

	public void setYsAreaCode(long ysAreaCode) {
		this.ysAreaCode = ysAreaCode;
	}
}