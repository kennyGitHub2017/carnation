package com.sinco.carnation.resource.bo.aio;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.api.annotation.ReturnMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AioChol", desc = "一体机血氧表")
public class AioDataMO {
	@JsonProperty("spo")
	@ReturnMapping(desc = "血氧饱和度")
	private String spo;
	@JsonProperty("spoPr")
	@ReturnMapping(desc = "血氧脉率")
	private String spoPr;
	@JsonProperty("glu")
	@ReturnMapping(desc = "血糖")
	private String glu;
	@JsonProperty("flag")
	@ReturnMapping(desc = "状态标志")
	private String flag;
	@JsonProperty("hr")
	@ReturnMapping(desc = "心率")
	private String hr;
	@JsonProperty("chol")
	@ReturnMapping(desc = "总胆固醇")
	private String chol;
	@JsonProperty("sysDia")
	@ReturnMapping(desc = "收缩压/舒张压")
	private String sysDia;
	@JsonProperty("sysDiaPr")
	@ReturnMapping(desc = "血压脉率")
	private String sysDiaPr;
	@JsonProperty("tp")
	@ReturnMapping(desc = "体温")
	private String tp;
	@JsonProperty("ua")
	@ReturnMapping(desc = "尿酸")
	private String ua;
	@JsonProperty("time")
	@FieldMapping(desc = "测量的日期和时间")
	private String time;
	@JsonProperty("uaUrl")
	@ReturnMapping(desc = "尿酸详情URL")
	private String uaUrl;
	@JsonProperty("spoUrl")
	@ReturnMapping(desc = "血氧饱和度详情URL")
	private String spoUrl;
	@JsonProperty("gluUrl")
	@ReturnMapping(desc = "血糖详情URL")
	private String gluUrl;
	@JsonProperty("hrUrl")
	@ReturnMapping(desc = "心率详情URL")
	private String hrUrl;
	@JsonProperty("cholUrl")
	@ReturnMapping(desc = "总胆固醇详情URL")
	private String cholUrl;
	@JsonProperty("sysDiaUrl")
	@ReturnMapping(desc = "血压详情URL")
	private String sysDiaUrl;
	@JsonProperty("tpUrl")
	@ReturnMapping(desc = "体温详情URL")
	private String tpUrl;

	public String getSpo() {
		return spo;
	}

	public void setSpo(String spo) {
		this.spo = spo;
	}

	public String getSpoPr() {
		return spoPr;
	}

	public void setSpoPr(String spoPr) {
		this.spoPr = spoPr;
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

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getChol() {
		return chol;
	}

	public void setChol(String chol) {
		this.chol = chol;
	}

	public String getSysDia() {
		return sysDia;
	}

	public void setSysDia(String sysDia) {
		this.sysDia = sysDia;
	}

	public String getSysDiaPr() {
		return sysDiaPr;
	}

	public void setSysDiaPr(String sysDiaPr) {
		this.sysDiaPr = sysDiaPr;
	}

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUaUrl() {
		return uaUrl;
	}

	public void setUaUrl(String uaUrl) {
		this.uaUrl = uaUrl;
	}

	public String getSpoUrl() {
		return spoUrl;
	}

	public void setSpoUrl(String spoUrl) {
		this.spoUrl = spoUrl;
	}

	public String getGluUrl() {
		return gluUrl;
	}

	public void setGluUrl(String gluUrl) {
		this.gluUrl = gluUrl;
	}

	public String getHrUrl() {
		return hrUrl;
	}

	public void setHrUrl(String hrUrl) {
		this.hrUrl = hrUrl;
	}

	public String getCholUrl() {
		return cholUrl;
	}

	public void setCholUrl(String cholUrl) {
		this.cholUrl = cholUrl;
	}

	public String getSysDiaUrl() {
		return sysDiaUrl;
	}

	public void setSysDiaUrl(String sysDiaUrl) {
		this.sysDiaUrl = sysDiaUrl;
	}

	public String getTpUrl() {
		return tpUrl;
	}

	public void setTpUrl(String tpUrl) {
		this.tpUrl = tpUrl;
	}

}
