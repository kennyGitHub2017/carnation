package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CheckResultHistory", desc = "自测结果历史")
public class CheckResultHistoryBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("groupTitle")
	@FieldMapping(desc = "自测套题标题")
	private String groupTitle;

	@JsonProperty("resultDesc")
	@FieldMapping(desc = "自测结果描述")
	private String resultDesc;

	@JsonProperty("createTime")
	@FieldMapping(desc = "自测时间")
	private Date createTime;

	@JsonProperty("desc")
	@FieldMapping(desc = "结果描述|已过滤标签")
	private String desc;

	/** 自测得分 **/
	@JsonProperty("score")
	@FieldMapping(desc = "自测得分")
	private Integer score;

	/** 自测套题id **/
	@JsonProperty("groupId")
	@FieldMapping(desc = "自测套题id")
	private Long groupId;

	@JsonProperty("imgUrl")
	@FieldMapping(desc = "图片路径")
	private String imgUrl;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}