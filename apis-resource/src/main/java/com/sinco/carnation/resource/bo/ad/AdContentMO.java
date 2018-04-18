package com.sinco.carnation.resource.bo.ad;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 
 * 区域广告返回数据
 * 
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "adContent", desc = "区域广告")
public class AdContentMO {
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("areaAdId")
	@FieldMapping(desc = "专区ID")
	private Long areaAdId;

	@JsonProperty("parentId")
	@FieldMapping(desc = "父级ID")
	private Long parentId;

	@JsonProperty("areaId")
	@FieldMapping(desc = " 地区ID")
	private Long areaId;

	@JsonProperty("name")
	@FieldMapping(desc = "区域名称")
	private String name;

	@JsonProperty("pic")
	@FieldMapping(desc = "区域图片")
	private String pic;

	@JsonProperty("type")
	@FieldMapping(desc = "区域类型")
	private String type;

	@JsonProperty("link")
	@FieldMapping(desc = "区域链接")
	private String link;

	@JsonProperty("orders")
	@FieldMapping(desc = "排序")
	private Integer orders;
	
	@JsonProperty("needLogin")
	@FieldMapping(desc = "是否需要登录")
    private boolean needLogin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAreaAdId() {
		return areaAdId;
	}

	public void setAreaAdId(Long areaAdId) {
		this.areaAdId = areaAdId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public boolean isNeedLogin() {
		return needLogin;
	}

	public void setNeedLogin(boolean needLogin) {
		this.needLogin = needLogin;
	}

}