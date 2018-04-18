package com.sinco.carnation.resource.vo.check;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ReportAddVO extends BasicParamVO {

	@Param(desc = "报告id|添加不用传")
	private Long replyId;

	@Param(desc = "报告名称")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String reportName;

	@Param(desc = "体检时间|yyyy-MM-dd")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String time;

	@Param(desc = "体检机构/医院")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String hospital;

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

}
