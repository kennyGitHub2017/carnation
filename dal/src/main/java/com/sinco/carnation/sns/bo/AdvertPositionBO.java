package com.sinco.carnation.sns.bo;

import java.util.List;

import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class AdvertPositionBO extends AdvertPosition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5765944265560480960L;

	private Long advId;

	private List<Advert> advs;

	public List<Advert> getAdvs() {
		return advs;
	}

	public void setAdvs(List<Advert> advs) {
		this.advs = advs;
	}

	public Long getAdvId() {
		return advId;
	}

	public void setAdvId(Long advId) {
		this.advId = advId;
	}

}