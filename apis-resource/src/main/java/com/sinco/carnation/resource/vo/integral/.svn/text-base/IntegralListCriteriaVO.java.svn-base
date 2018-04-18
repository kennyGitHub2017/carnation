package com.sinco.carnation.resource.vo.integral;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class IntegralListCriteriaVO extends BasicPageParamVo {

	@Param(desc = "是否查询所有(查询所有：true,否则false)")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private boolean findAll;

	@Param(desc = "积分范围值查询--最小值")
	private String minIntegral;

	@Param(desc = "积分范围值查询--最大值")
	private String maxIntegral;

	@Param(desc = "是否推热门荐到app端2")
	private String mobileRecommend;

	public boolean isFindAll() {
		return findAll;
	}

	public void setFindAll(boolean findAll) {
		this.findAll = findAll;
	}

	public String getMinIntegral() {
		return minIntegral;
	}

	public void setMinIntegral(String minIntegral) {
		this.minIntegral = minIntegral;
	}

	public String getMaxIntegral() {
		return maxIntegral;
	}

	public void setMaxIntegral(String maxIntegral) {
		this.maxIntegral = maxIntegral;
	}

	public String getMobileRecommend() {
		return mobileRecommend;
	}

	public void setMobileRecommend(String mobileRecommend) {
		this.mobileRecommend = mobileRecommend;
	}

}
