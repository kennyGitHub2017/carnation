package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CommentVO extends BasicParamVO {

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "评论内容")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	@Param(desc = "评论星级|如1，2，3，4，5，6.....")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer evaluationAverage;

	@Param(desc = "图片|以;号分割，最多6张")
	private String photo;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Integer evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
