package com.sinco.carnation.resource.bo.juanpi;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "JuanpiShareBO", desc = "卷皮分享")
public class JuanpiShareBO {
	@JsonProperty("id")
	@FieldMapping(desc = "id")
    private Long id;

	@JsonProperty("mark")
	@FieldMapping(desc = "juanpi_putong,juanpi_tuangou")
    private String mark;

	@JsonProperty("shareId")
	@FieldMapping(desc = "商品ID")
    private Long shareId;

	@JsonProperty("titleClass")
	@FieldMapping(desc = "1.商品标题 2.自定义 3.自定义+商品")
    private Integer titleClass;

	@JsonProperty("title")
	@FieldMapping(desc = "标题")
    private String title;

	@JsonProperty("imgClass")
	@FieldMapping(desc = "1.商品图片 2.自定义")
    private Integer imgClass;

	@JsonProperty("imgUrl")
	@FieldMapping(desc = "图片路径")
    private String imgUrl;

	@JsonProperty("url")
	@FieldMapping(desc = "跳转链接")
    private String url;
    
	@JsonProperty("context")
	@FieldMapping(desc = "分享内容 ")
    private String context;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Long getShareId() {
		return shareId;
	}

	public void setShareId(Long shareId) {
		this.shareId = shareId;
	}

	public Integer getTitleClass() {
		return titleClass;
	}

	public void setTitleClass(Integer titleClass) {
		this.titleClass = titleClass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getImgClass() {
		return imgClass;
	}

	public void setImgClass(Integer imgClass) {
		this.imgClass = imgClass;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
	
	
}
