package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserFootPoint extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7989846909942774579L;

	/**  **/
	private Long id;

	/**  **/
	private Date addtime;

	/**  **/
	private Integer deletestatus;

	/**  **/
	private Date fpDate;

	/**  **/
	private Integer fpGoodsCount;

	/**  **/
	private Long fpUserId;

	/**  **/
	private String fpUserName;

	/**  **/
	private String fpGoodsContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

	public Date getFpDate() {
		return fpDate;
	}

	public void setFpDate(Date fpDate) {
		this.fpDate = fpDate;
	}

	public Integer getFpGoodsCount() {
		return fpGoodsCount;
	}

	public void setFpGoodsCount(Integer fpGoodsCount) {
		this.fpGoodsCount = fpGoodsCount;
	}

	public Long getFpUserId() {
		return fpUserId;
	}

	public void setFpUserId(Long fpUserId) {
		this.fpUserId = fpUserId;
	}

	public String getFpUserName() {
		return fpUserName;
	}

	public void setFpUserName(String fpUserName) {
		this.fpUserName = fpUserName;
	}

	public String getFpGoodsContent() {
		return fpGoodsContent;
	}

	public void setFpGoodsContent(String fpGoodsContent) {
		this.fpGoodsContent = fpGoodsContent;
	}
}