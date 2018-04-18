package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class StoreNavigation extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3707042378569270559L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 是否显示 **/
	private Boolean display;

	/** 导航序号 **/
	private String sequence;

	/** 导航标题 **/
	private String title;

	/** 导航url **/
	private String url;

	/** 窗口打开方式，分为新窗口new_win和当前页cur_win **/
	private String winType;

	/**  **/
	private Long storeId;

	/** 导航内容 **/
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWinType() {
		return winType;
	}

	public void setWinType(String winType) {
		this.winType = winType;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}