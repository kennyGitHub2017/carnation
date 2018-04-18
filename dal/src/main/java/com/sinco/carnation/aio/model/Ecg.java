package com.sinco.carnation.aio.model;

import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 思创健康一体机 心电图
 */
public class Ecg extends BaseModel {

	private static final long serialVersionUID = 5750269580008517928L;
	private Long id;
	// 设备ID
	private String did;
	// 数据同步时间
	private String syncTime;
	// 用户身份证号码
	private String idCard;
	// 用户ID类型，身份证还是手机号
	private String ctype;
	// RR间期
	private String rr;
	private String pR;
	private String qrs;
	private String qt;
	private String qtc;
	private String pAxis;
	private String qrsAxis;
	private String tAxis;
	private String rv5;
	private String svl;
	private String rv5Svl;
	// 心率
	private String hr;
	// 检测结果
	private String analysisCode;
	// 测量的日期和时间
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
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

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
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

}