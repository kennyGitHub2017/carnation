package com.sinco.carnation.resource.vo.chunyu;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class ProblemReplyNoticeVO extends BasicParamVO {
	@Param(desc = "错误码｜0 代表成功,其它代表异常")
	private Integer error;
	@Param(desc = "异常信息")
	private String error_msg;
	@Param(desc = "问题编号")
	private String problem_id;
	@Param(desc = "用户名")
	private String user_id;
	@Param(desc = "医生答复内容")
	private String content;
	@Param(desc = "签名")
	private String sign;
	@Param(desc = "签名时间戳")
	private Long atime;
	@Param(desc = "医生信息")
	private DoctorVO doctor;

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(String problem_id) {
		this.problem_id = problem_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Long getAtime() {
		return atime;
	}

	public void setAtime(Long atime) {
		this.atime = atime;
	}

	public DoctorVO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorVO doctor) {
		this.doctor = doctor;
	}
	
}
