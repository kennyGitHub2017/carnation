package com.sinco.carnation.resource.bo.integral;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "IGo", desc = "礼品信息")
public class IGoBO {

	@JsonProperty("images")
	@FieldMapping(desc = "图片")
	private String images;

	@JsonProperty("igoName")
	@FieldMapping(desc = "名称")
	private String igoName;

	@JsonProperty("igoInteral")
	@FieldMapping(desc = "积分")
	private Integer igoInteral;

	@JsonProperty("count")
	@FieldMapping(desc = "数量")
	private Integer count;

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getIgoName() {
		return igoName;
	}

	public void setIgoName(String igoName) {
		this.igoName = igoName;
	}

	public Integer getIgoInteral() {
		return igoInteral;
	}

	public void setIgoInteral(Integer igoInteral) {
		this.igoInteral = igoInteral;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
