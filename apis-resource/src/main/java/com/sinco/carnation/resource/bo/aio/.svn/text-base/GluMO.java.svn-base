package com.sinco.carnation.resource.bo.aio;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AioChol", desc = "一体机血糖表")
public class GluMO {
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("syncTime")
	@FieldMapping(desc = "数据同步时间")
	private String syncTime;
	@JsonProperty("idCard")
	@FieldMapping(desc = "用户身份证号码")
	private String idCard;
	@JsonProperty("glu")
	@FieldMapping(desc = "血糖")
	private String glu;
	@JsonProperty("flag")
	@FieldMapping(desc = "状态标志")
	private String flag;
	@JsonProperty("time")
	@FieldMapping(desc = "测量的日期和时间")
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGlu() {
		return glu;
	}

	public void setGlu(String glu) {
		this.glu = glu;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
