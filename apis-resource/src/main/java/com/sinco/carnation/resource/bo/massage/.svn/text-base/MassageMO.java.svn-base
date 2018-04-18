package com.sinco.carnation.resource.bo.massage;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Massage", desc = "按摩数据")
public class MassageMO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("userId")
	@FieldMapping(desc = "用户ID")
	private Long userId;
	@JsonProperty("adviceTime")
	@FieldMapping(desc = "建议按摩时长")
	private String adviceTime;
	@JsonProperty("allTime")
	@FieldMapping(desc = "按摩总时长")
	private Long allTime;
	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间")
	private Date createTime;
	@JsonProperty("lastUpdateTime")
	@FieldMapping(desc = "最后更新时间")
	private Date lastUpdateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAdviceTime() {
		return adviceTime;
	}

	public void setAdviceTime(String adviceTime) {
		this.adviceTime = adviceTime;
	}

	public Long getAllTime() {
		return allTime;
	}

	public void setAllTime(Long allTime) {
		this.allTime = allTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
