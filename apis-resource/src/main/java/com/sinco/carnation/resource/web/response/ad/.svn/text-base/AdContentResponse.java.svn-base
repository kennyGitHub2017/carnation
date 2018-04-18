package com.sinco.carnation.resource.web.response.ad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.ad.AdContentMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AdContentResponse extends BaseJsonResult {

	@JsonProperty("adContent")
	@ReturnMapping(desc = "区域广告")
	private List<AdContentMO> adContentMO;

	@JsonProperty("style")
	@ReturnMapping(desc = "专区样式")
	private String style;

	public List<AdContentMO> getAdContentMO() {
		return adContentMO;
	}

	public void setAdContentMO(List<AdContentMO> adContentMO) {
		this.adContentMO = adContentMO;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
