package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "运送方式", domainName = "SysTrans")
public class SysTrans {

	@JsonProperty("tanBos")
	@FieldMapping(desc = "运送方式")
	private List<TransBO> tanBos;

	public List<TransBO> getTanBos() {
		return tanBos;
	}

	public void setTanBos(List<TransBO> tanBos) {
		this.tanBos = tanBos;
	}

}
