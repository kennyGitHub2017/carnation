package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsClass", desc = "商品分类")
public class GoodsClassBo {

	@JsonProperty("id")
	@FieldMapping(desc = "分类id")
	private Long id;

	@JsonProperty("className")
	@FieldMapping(desc = "分类名称")
	private String className;

	@JsonProperty("appIcon")
	@FieldMapping(desc = "图标")
	private String appIcon;

	/** 移动端上传图标 **/
	@JsonProperty("mobileIcon")
	@FieldMapping(desc = "移动端上传图标")
	private String mobileIcon;

	@JsonProperty("clickIcon")
	@FieldMapping(desc = "选中图标")
	private String clickIcon;

	@JsonProperty("unClickIcon")
	@FieldMapping(desc = "未选中图标")
	private String unClickIcon;
	
	@JsonProperty("parentId")
	@FieldMapping(desc = "父类ID")
	private Long parentId;
	
	@JsonProperty("level")
	@FieldMapping(desc = "类别等级")
	private Long level;
	
	@JsonProperty("childList")
	@FieldMapping(desc = "子分类列表")
	private List<GoodsClassBo> childList;

	public Long getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getMobileIcon() {
		return mobileIcon;
	}

	public void setMobileIcon(String mobileIcon) {
		this.mobileIcon = mobileIcon;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public String getClickIcon() {
		return clickIcon;
	}

	public void setClickIcon(String clickIcon) {
		this.clickIcon = clickIcon;
	}

	public String getUnClickIcon() {
		return unClickIcon;
	}

	public void setUnClickIcon(String unClickIcon) {
		this.unClickIcon = unClickIcon;
	}

	public List<GoodsClassBo> getChildList() {
		return childList;
	}

	public void setChildList(List<GoodsClassBo> childList) {
		this.childList = childList;
	}
}
