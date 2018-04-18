package com.sinco.carnation.resource.bo.check;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CheckReport", desc = "体检报告信息")
public class CheckReportBO {

	/*
	 * @JsonProperty("id")
	 * 
	 * @FieldMapping(desc = "帖子id") private Long id;
	 * 
	 * @JsonProperty("totalCount")
	 * 
	 * @ReturnMapping(desc="总记录") private Long totalCount;
	 * 
	 * @JsonProperty("times")
	 * 
	 * @ReturnMapping(desc="最后一条记录时间") private Long times;
	 * 
	 * public Long getTotalCount() { return totalCount; }
	 * 
	 * public void setTotalCount(Long totalCount) { this.totalCount =
	 * totalCount; }
	 * 
	 * public Long getTimes() { return times; }
	 * 
	 * public void setTimes(Long times) { this.times = times; }
	 */

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("resultname")
	@FieldMapping(desc = "报告名称")
	private String resultname;

	@JsonProperty("createby")
	@FieldMapping(desc = "用户id")
	private String createby;

	@JsonProperty("createtime")
	@FieldMapping(desc = "体检时间")
	private Date createtime;

	@JsonProperty("hospital")
	@FieldMapping(desc = "机构/医院")
	private String hospital;

	@JsonProperty("status")
	@FieldMapping(desc = "体检报告状态：1未提交、2待处理、3已处理")
	private int status;

	@JsonProperty("result")
	@FieldMapping(desc = "处理结果")
	private String result;

	@JsonProperty("rightCount")
	@FieldMapping(desc = "正常项")
	private Integer rightCount;

	@JsonProperty("wrongCount")
	@FieldMapping(desc = "正常项")
	private Integer wrongCount;

	@JsonProperty("detailsList")
	@FieldMapping(desc = "体检项列表")
	private List<ResultDetailsBO> detailsList;

	/** 体检时间 */
	@JsonProperty("checkTime")
	@FieldMapping(desc = "体检时间")
	private Date checkTime;

	public String getResultname() {
		return resultname;
	}

	public void setResultname(String resultname) {
		this.resultname = resultname;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ResultDetailsBO> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(List<ResultDetailsBO> detailsList) {
		this.detailsList = detailsList;
	}

	public Integer getRightCount() {
		return rightCount;
	}

	public void setRightCount(Integer rightCount) {
		this.rightCount = rightCount;
	}

	public Integer getWrongCount() {
		return wrongCount;
	}

	public void setWrongCount(Integer wrongCount) {
		this.wrongCount = wrongCount;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

}
