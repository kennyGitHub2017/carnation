package com.sinco.carnation.resource.web.response.healthManage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.healthManage.UserCustomerBO;
import com.sinco.carnation.resource.bo.healthTask.TodayHealthTaskBO;
import com.sinco.carnation.resource.bo.healthcircle.HealthCircleBo;
import com.sinco.carnation.resource.bo.questionnaire.UserQuestionnaireBO;

public class HMIndexResponse extends ApiResponse implements Utf8mb4ToJson {

	private static final long serialVersionUID = 8738471092716679138L;

	@JsonProperty("userCustomer")
	@ReturnMapping(desc = "会员信息")
	private UserCustomerBO userCustomerBO;

	@JsonProperty("userQuestionnaire")
	@ReturnMapping(desc = "会员问卷调查")
	private UserQuestionnaireBO questionnaireBO;

	@JsonProperty("todayTaskList")
	@ReturnMapping(desc = "今日健康任务")
	private TodayHealthTaskBO todayHealthTask;

	@JsonProperty("healthCircles")
	@ReturnMapping(desc = "健康圈")
	private HealthCircleBo healthCircles;

	@JsonProperty("jiBingURL")
	@ReturnMapping(desc = "用户未做疾病自测题时，返回疾病自测访问地址")
	private String jiBingURL;

	@JsonProperty("yangShengURL")
	@ReturnMapping(desc = "用户已做疾病自测题时，返回养生访问地址")
	private String yangShengURL;

	@JsonProperty("shanShiURL")
	@ReturnMapping(desc = "用户已做疾病自测题时，返回膳食访问地址")
	private String shanShiURL;

	@JsonProperty("retestURL")
	@ReturnMapping(desc = "重测访问地址")
	private String retestURL;

	public String getRetestURL() {
		return retestURL;
	}

	public void setRetestURL(String retestURL) {
		this.retestURL = retestURL;
	}

	public String getJiBingURL() {
		return jiBingURL;
	}

	public void setJiBingURL(String jiBingURL) {
		this.jiBingURL = jiBingURL;
	}

	public String getYangShengURL() {
		return yangShengURL;
	}

	public void setYangShengURL(String yangShengURL) {
		this.yangShengURL = yangShengURL;
	}

	public String getShanShiURL() {
		return shanShiURL;
	}

	public void setShanShiURL(String shanShiURL) {
		this.shanShiURL = shanShiURL;
	}

	public HealthCircleBo getHealthCircles() {
		return healthCircles;
	}

	public void setHealthCircles(HealthCircleBo healthCircles) {
		this.healthCircles = healthCircles;
	}

	public TodayHealthTaskBO getTodayHealthTask() {
		return todayHealthTask;
	}

	public void setTodayHealthTask(TodayHealthTaskBO todayHealthTask) {
		this.todayHealthTask = todayHealthTask;
	}

	public UserCustomerBO getUserCustomerBO() {
		return userCustomerBO;
	}

	public void setUserCustomerBO(UserCustomerBO userCustomerBO) {
		this.userCustomerBO = userCustomerBO;
	}

	public UserQuestionnaireBO getQuestionnaireBO() {
		return questionnaireBO;
	}

	public void setQuestionnaireBO(UserQuestionnaireBO questionnaireBO) {
		this.questionnaireBO = questionnaireBO;
	}

}
