package com.sinco.carnation.resource.web.response.o2o;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.bo.o2o.GroupClassMO;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

/**
 * 商城首页
 * 
 * @author king
 * 
 */
public class GroupClassResponse extends BaseJsonResult {


	@JsonProperty("groupClassList")
	@ReturnMapping(desc = "商品分类列表")
	private List<GroupClassMO> groupClassList;

	public List<GroupClassMO> getGroupClassList() {
		return groupClassList;
	}

	public void setGroupClassList(List<GroupClassMO> groupClassList) {
		this.groupClassList = groupClassList;
	}

}
