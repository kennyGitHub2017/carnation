package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsCase", desc = "商城首页橱窗")
public class ShopGoodsCaseBo {

	@JsonProperty("id")
	@FieldMapping(desc = "橱窗id")
	private Long id;

	@JsonProperty("caseName")
	@FieldMapping(desc = "橱窗名称")
	private String caseName;

	@JsonProperty("classList")
	@FieldMapping(desc = "商品二级分类")
	private List<ShopGoodsCaseBo> classList;

	public Long getId() {
		return id;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public List<ShopGoodsCaseBo> getClassList() {
		return classList;
	}

	public void setClassList(List<ShopGoodsCaseBo> classList) {
		this.classList = classList;
	}

}
