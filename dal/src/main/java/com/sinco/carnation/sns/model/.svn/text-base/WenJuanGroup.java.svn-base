package com.sinco.carnation.sns.model;

import java.util.Date;
import java.util.List;

import com.sinco.carnation.sns.bo.WenJuanQuestionBO;
import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 问卷调查题组 tableName(wj_group)
 */
public class WenJuanGroup extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3080596041613432550L;

	/**  **/
	private Long id;

	/** 问卷题 **/
	private String groupTitle;

	/**  **/
	private Long updateBy;

	/**  **/
	private Long createBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;
	/**
	 * 问卷自测主题ID
	 */
	private Long wjThemeID;
	/*
	 * 所属组ID
	 */
	private Long pid;
	/**
	 * ID集
	 */
	private List<Long> idList;
	/**
	 * 问卷题目集合
	 */
	private List<WenJuanQuestionBO> questionList;
	/**
	 * 排序
	 */
	private Long groupIndex;

	public Long getGroupIndex() {
		return groupIndex;
	}

	public void setGroupIndex(Long groupIndex) {
		this.groupIndex = groupIndex;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getWjThemeID() {
		return wjThemeID;
	}

	public void setWjThemeID(Long wjThemeID) {
		this.wjThemeID = wjThemeID;
	}

	public List<WenJuanQuestionBO> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<WenJuanQuestionBO> questionList) {
		this.questionList = questionList;
	}

	public List<Long> getIdList() {
		return idList;
	}

	public void setIdList(List<Long> idList) {
		this.idList = idList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}