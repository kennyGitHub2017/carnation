package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopAccessory", desc = "商品图片")
public class ShopAccessoryBO {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/**  **/
	@JsonProperty("info")
	@FieldMapping(desc = "图片")
	private String info;

	/**  **/
	@JsonProperty("name")
	@FieldMapping(desc = "图片名称")
	private String name;

	/**  **/
	@JsonProperty("path")
	@FieldMapping(desc = "图片路径")
	private String path;

	public Long getId() {
		return id;
	}

	public String getInfo() {
		return info;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
