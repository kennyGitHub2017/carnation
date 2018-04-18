package com.sinco.carnation.resource.bo.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsType", desc = "商品类型属性")
public class GoodsTypeBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("name")
	@FieldMapping(desc = "name")
	private String name;

	@JsonProperty("sequence")
	@FieldMapping(desc = "sequence")
	private Integer sequence;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
