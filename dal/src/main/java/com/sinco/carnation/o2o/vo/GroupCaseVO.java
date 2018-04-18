package com.sinco.carnation.o2o.vo;

import com.sinco.carnation.o2o.model.GroupCase;

public class GroupCaseVO extends GroupCase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8099854991330644070L;

	/** 橱窗信息 **/
	private String caseContent;

	/** 城市ID **/
	private Long groupCaseGoodsCityId;

	/** 团购橱窗商品json数据 */
	private String groupCaseGoods;

	public String getGroupCaseGoods() {
		return groupCaseGoods;
	}

	public void setGroupCaseGoods(String groupCaseGoods) {
		this.groupCaseGoods = groupCaseGoods;
	}

	public Long getGroupCaseGoodsCityId() {
		return groupCaseGoodsCityId;
	}

	public void setGroupCaseGoodsCityId(Long groupCaseGoodsCityId) {
		this.groupCaseGoodsCityId = groupCaseGoodsCityId;
	}

	public String getCaseContent() {
		return caseContent;
	}

	public void setCaseContent(String caseContent) {
		this.caseContent = caseContent;
	}

}
