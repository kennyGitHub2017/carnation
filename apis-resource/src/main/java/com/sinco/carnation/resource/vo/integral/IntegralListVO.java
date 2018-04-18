package com.sinco.carnation.resource.vo.integral;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class IntegralListVO extends BasicPageParamVo {

//	/** 举报对象 **/
//	@Param(desc = "举报对象 id")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	private Long targetId;
//
//	/** 举报类型 **/
//	@Param(desc = "举报名称")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	private String tipsType;
//
//	@Param(desc = "举报类型|0帖子1资讯")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	private Integer type;
//
//	public Long getTargetId() {
//		return targetId;
//	}
//
//	public void setTargetId(Long targetId) {
//		this.targetId = targetId;
//	}
//
//	public String getTipsType() {
//		return tipsType;
//	}
//
//	public void setTipsType(String tipsType) {
//		this.tipsType = tipsType;
//	}
//
//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}

	@Param(desc = "积分范围开始")
	private String rangBegin;

	@Param(desc = "积分范围结束")
	private String rangEnd;

	@Param(desc = "手机是否推荐")
	private String mobileRecommend;

	public String getRangBegin() {
		return rangBegin;
	}

	public void setRangBegin(String rangBegin) {
		this.rangBegin = rangBegin;
	}

	public String getRangEnd() {
		return rangEnd;
	}

	public void setRangEnd(String rangEnd) {
		this.rangEnd = rangEnd;
	}

	public String getMobileRecommend() {
		return mobileRecommend;
	}

	public void setMobileRecommend(String mobileRecommend) {
		this.mobileRecommend = mobileRecommend;
	}

}
