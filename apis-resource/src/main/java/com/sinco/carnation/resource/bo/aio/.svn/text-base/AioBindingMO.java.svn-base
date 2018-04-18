package com.sinco.carnation.resource.bo.aio;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AioBinding", desc = "一体机绑定表")
public class AioBindingMO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("uid")
	@FieldMapping(desc = "用户ID")
	private Long uid;
	@JsonProperty("idCard")
	@FieldMapping(desc = "身份证ID")
	private String idCard;
	@JsonProperty("updateNum")
	@FieldMapping(desc = "修改次数")
	private Integer updateNum;
	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间")
	private String createTime;
	@JsonProperty("lastUpdateTime")
	@FieldMapping(desc = "最后更新时间")
	private String lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getUpdateNum() {
		return updateNum;
	}

	public void setUpdateNum(Integer updateNum) {
		this.updateNum = updateNum;
	}

}
