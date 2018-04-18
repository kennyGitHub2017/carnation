package com.sinco.carnation.resource.bo.o2o;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupClassMO", desc = "商品分类")
public class GroupClassMO {

	@JsonProperty("id")
	@FieldMapping(desc = "分类id")
	private Long id;

	@JsonProperty("gcLevel")
	@FieldMapping(desc = "分类等级")
	private Integer gcLevel;

	@JsonProperty("gcName")
	@FieldMapping(desc = "分类名")
	private String gcName;

	@JsonProperty("gcSequence")
	@FieldMapping(desc = "分类权重")
	private Integer gcSequence;

	@JsonProperty("parentId")
	@FieldMapping(desc = "父类ID")
	private Long parentId;

	@JsonProperty("mobileIcon")
	@FieldMapping(desc = "移动端上传图标")
	private String mobileIcon;

	@JsonProperty("gcType")
	@FieldMapping(desc = "0 原生,10 H5")
    private Integer gcType;

	@JsonProperty("url")
	@FieldMapping(desc = "链接")
    private String url;
    
	@JsonProperty("childs")
	@FieldMapping(desc = "子分类列表")
	private Collection<GroupClassMO> childs;

	@JsonProperty("parent")
	@FieldMapping(desc = "父分类")
	private GroupClassMO parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGcLevel() {
		return gcLevel;
	}

	public void setGcLevel(Integer gcLevel) {
		this.gcLevel = gcLevel;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public Integer getGcSequence() {
		return gcSequence;
	}

	public void setGcSequence(Integer gcSequence) {
		this.gcSequence = gcSequence;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMobileIcon() {
		return mobileIcon;
	}

	public void setMobileIcon(String mobileIcon) {
		this.mobileIcon = mobileIcon;
	}

	public Collection<GroupClassMO> getChilds() {
		return childs;
	}

	public void setChilds(Collection<GroupClassMO> childs) {
		this.childs = childs;
	}

	public GroupClassMO getParent() {
		return parent;
	}

	public void setParent(GroupClassMO parent) {
		this.parent = parent;
	}

	public Integer getGcType() {
		return gcType;
	}

	public void setGcType(Integer gcType) {
		this.gcType = gcType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
