package com.sinco.carnation.resource.bo.merch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.carnation.resource.bo.shop.GoodsClassBo;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "店铺分类信息", domainName = "StoreCommonInfo")
public class StoreCommonInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "分类id")
	private Long id;

	@JsonProperty("className")
	@FieldMapping(desc = "分类名称")
	private String className;

	@JsonProperty("appIcon")
	@FieldMapping(desc = "图标")
	private String appIcon;

	@JsonProperty("childs")
	@FieldMapping(desc = "店铺商品分类列表")
	private List<GoodsClassBo> childs;

	public List<GoodsClassBo> getChilds() {
		return childs;
	}

	public void setChilds(List<GoodsClassBo> childs) {
		this.childs = childs;
	}

	public Long getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

}
