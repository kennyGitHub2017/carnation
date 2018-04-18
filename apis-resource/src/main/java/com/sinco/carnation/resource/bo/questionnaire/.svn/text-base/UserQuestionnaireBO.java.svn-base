package com.sinco.carnation.resource.bo.questionnaire;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserQuestionnaireBO", desc = "用户问卷调查")
public class UserQuestionnaireBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("totalStore")
	@FieldMapping(desc = "健康分数")
	private Long totalStore;

	@JsonProperty("isChronic")
	@FieldMapping(desc = "是否为慢性病 | 0：n 1:y")
	private Integer isChronic;

	@JsonProperty("isHigh")
	@FieldMapping(desc = "是否为高风险 | 0：n 1:y")
	private Integer isHigh;

	@JsonProperty("isYjk")
	@FieldMapping(desc = "是否为亚健康 | 0：n 1:y")
	private Integer isYjk;

	@JsonProperty("isHealthy")
	@FieldMapping(desc = "是否为健康 | 0：n 1:y")
	private Integer isHealthy;

	@JsonProperty("proposalList")
	@FieldMapping(desc = "建议题目集")
	private List<UserQuestionProposalBO> proposalList;

	@JsonProperty("improveList")
	@FieldMapping(desc = "改进题目集")
	private List<UserQuestionProposalBO> improveList;

	@JsonProperty("result")
	@FieldMapping(desc = "返回结果 | 10：失败，15：当前用户未做问卷调查，20：成功")
	private Integer result;

	@JsonProperty("content")
	@FieldMapping(desc = "返回内容  | faile,null,succ")
	private String content;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalStore() {
		return totalStore;
	}

	public void setTotalStore(Long totalStore) {
		this.totalStore = totalStore;
	}

	public Integer getIsChronic() {
		return isChronic;
	}

	public void setIsChronic(Integer isChronic) {
		this.isChronic = isChronic;
	}

	public Integer getIsHigh() {
		return isHigh;
	}

	public void setIsHigh(Integer isHigh) {
		this.isHigh = isHigh;
	}

	public Integer getIsYjk() {
		return isYjk;
	}

	public void setIsYjk(Integer isYjk) {
		this.isYjk = isYjk;
	}

	public Integer getIsHealthy() {
		return isHealthy;
	}

	public void setIsHealthy(Integer isHealthy) {
		this.isHealthy = isHealthy;
	}

	public List<UserQuestionProposalBO> getProposalList() {
		return proposalList;
	}

	public void setProposalList(List<UserQuestionProposalBO> proposalList) {
		this.proposalList = proposalList;
	}

	public List<UserQuestionProposalBO> getImproveList() {
		return improveList;
	}

	public void setImproveList(List<UserQuestionProposalBO> improveList) {
		this.improveList = improveList;
	}

	/**
	 * 失败
	 */
	public static final int FAIL = 10;
	/**
	 * 当前用户未做问卷调查
	 */
	public static final int ISNULL = 15;
	/**
	 * 成功
	 */
	public static final int SUCC = 20;

	/**
	 * 失败
	 */
	public static final String FAILSTR = "操作失败";
	/**
	 * 当前用户未做问卷调查
	 */
	public static final String ISNULLTR = "当前用户未做问卷调查";
	/**
	 * 成功
	 */
	public static final String SUCCTR = "success";

}
