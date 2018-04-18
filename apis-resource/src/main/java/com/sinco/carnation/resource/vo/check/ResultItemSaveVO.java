package com.sinco.carnation.resource.vo.check;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ResultItemSaveVO extends BasicParamVO {

	@Param(desc = "体检报告id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long replyId;

	@Param(desc = "体检项id")
	private Long itemId;

	@Param(desc = "具体值")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer value;

	@Param(desc = "报告明细id")
	private Long detailsId;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getReplyId() {
		return replyId;
	}

	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Long getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Long detailsId) {
		this.detailsId = detailsId;
	}

}
