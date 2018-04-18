package com.sinco.carnation.resource.bo.aio;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AioChol", desc = "一体机心率表")
public class EcgMO {
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;
	@JsonProperty("syncTime")
	@FieldMapping(desc = "数据同步时间")
	private String syncTime;
	@JsonProperty("idCard")
	@FieldMapping(desc = "用户身份证号码")
	private String idCard;
	@JsonProperty("hr")
	@FieldMapping(desc = "心率")
	private String hr;
	@JsonProperty("analysisCode")
	@FieldMapping(desc = "检测结果")
	private String analysisCode;
	@JsonProperty("time")
	@FieldMapping(desc = "测量的日期和时间")
	private String time;
	@JsonProperty("rr")
	@FieldMapping(desc = "RR间期")
	private String rr;
	@JsonProperty("pR")
	@FieldMapping(desc = "pR")
	private String pR;
	@JsonProperty("qrs")
	@FieldMapping(desc = "qrs")
	private String qrs;
	@JsonProperty("qt")
	@FieldMapping(desc = "qt")
	private String qt;
	@JsonProperty("qtc")
	@FieldMapping(desc = "qtc")
	private String qtc;
	@JsonProperty("pAxis")
	@FieldMapping(desc = "pAxis")
	private String pAxis;
	@JsonProperty("qrsAxis")
	@FieldMapping(desc = "qrsAxis")
	private String qrsAxis;
	@JsonProperty("tAxis")
	@FieldMapping(desc = "tAxis")
	private String tAxis;
	@JsonProperty("rv5")
	@FieldMapping(desc = "rv5")
	private String rv5;
	@JsonProperty("svl")
	@FieldMapping(desc = "svl")
	private String svl;
	@JsonProperty("rv5Svl")
	@FieldMapping(desc = "rv5Svl")
	private String rv5Svl;

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

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getAnalysisCode() {
		return analysisCode;
	}

	public void setAnalysisCode(String analysisCode) {
		this.analysisCode = analysisCode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRr() {
		return rr;
	}

	public void setRr(String rr) {
		this.rr = rr;
	}

	public String getpR() {
		return pR;
	}

	public void setpR(String pR) {
		this.pR = pR;
	}

	public String getQrs() {
		return qrs;
	}

	public void setQrs(String qrs) {
		this.qrs = qrs;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getQtc() {
		return qtc;
	}

	public void setQtc(String qtc) {
		this.qtc = qtc;
	}

	public String getpAxis() {
		return pAxis;
	}

	public void setpAxis(String pAxis) {
		this.pAxis = pAxis;
	}

	public String getQrsAxis() {
		return qrsAxis;
	}

	public void setQrsAxis(String qrsAxis) {
		this.qrsAxis = qrsAxis;
	}

	public String gettAxis() {
		return tAxis;
	}

	public void settAxis(String tAxis) {
		this.tAxis = tAxis;
	}

	public String getRv5() {
		return rv5;
	}

	public void setRv5(String rv5) {
		this.rv5 = rv5;
	}

	public String getSvl() {
		return svl;
	}

	public void setSvl(String svl) {
		this.svl = svl;
	}

	public String getRv5Svl() {
		return rv5Svl;
	}

	public void setRv5Svl(String rv5Svl) {
		this.rv5Svl = rv5Svl;
	}

}
