package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "InvitationClassBO", desc = "帖子分类")
public class InvitationClassBO {

	@JsonProperty("id")
	@FieldMapping(desc = "帖子分类id")
	private Long id;

	@JsonProperty("name")
	@FieldMapping(desc = "分类名称")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}