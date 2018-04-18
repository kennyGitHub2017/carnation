package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class WenJuanProposalDetailed extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5113867362186734767L;

	/**  **/
	private Long id;

	/**  **/
	private String proposalTitle;

	/**  **/
	private String proposalContent;

	/**  **/
	private Long wjProposalId;

	/**  **/
	private Date createTime;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long createBy;

	/**  **/
	private Long updateBy;

	/**  **/
	private Long isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProposalTitle() {
		return proposalTitle;
	}

	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
	}

	public String getProposalContent() {
		return proposalContent;
	}

	public void setProposalContent(String proposalContent) {
		this.proposalContent = proposalContent;
	}

	public Long getWjProposalId() {
		return wjProposalId;
	}

	public void setWjProposalId(Long wjProposalId) {
		this.wjProposalId = wjProposalId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}
}