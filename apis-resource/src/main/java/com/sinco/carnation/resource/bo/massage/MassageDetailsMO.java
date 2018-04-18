package com.sinco.carnation.resource.bo.massage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "MassageDetails", desc = "按摩详细数据")
public class MassageDetailsMO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("userId")
	@FieldMapping(desc = "用户ID")
	private Long userId;
	@JsonProperty("date")
	@FieldMapping(desc = "日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
	@JsonProperty("time")
	@FieldMapping(desc = "按摩时长（单位分钟）")
	private Integer time;
	@JsonProperty("allTime")
	@FieldMapping(desc = "按摩总时长（单位分钟）")
	private Integer allTime;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
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

	public Integer getAllTime() {
		return allTime;
	}

	public void setAllTime(Integer allTime) {
		this.allTime = allTime;
	}

}
