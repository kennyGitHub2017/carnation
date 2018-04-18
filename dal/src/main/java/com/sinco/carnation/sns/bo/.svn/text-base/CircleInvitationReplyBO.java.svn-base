package com.sinco.carnation.sns.bo;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.sns.model.CircleInvitationReply;
import com.sinco.dal.utils.DateUtils;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class CircleInvitationReplyBO extends CircleInvitationReply {

	/**
	 * 
	 */
	private static final long serialVersionUID = 287743504230078831L;

	public String getAddTimeString() {
		if (getAddTime() != null) {
			return DateUtils.formatTime((new Date().getTime()) - getAddTime().getTime());
		} else {
			return null;
		}
	}

	private String parentName;
	private Integer parentLevelCount;
	private String parentContent;
	private String parentPic;

	public String[] getPicList() {
		if (StringUtils.isNotEmpty(getPic())) {
			return getPic().split("\\|");
		}
		return null;
	}

	public String[] getParentPicList() {
		if (StringUtils.isNotEmpty(getParentPic())) {
			return getParentPic().split("\\|");
		}
		return null;
	}

	public String getParentPic() {
		return parentPic;
	}

	public void setParentPic(String parentPic) {
		this.parentPic = parentPic;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getParentLevelCount() {
		return parentLevelCount;
	}

	public void setParentLevelCount(Integer parentLevelCount) {
		this.parentLevelCount = parentLevelCount;
	}

	public String getParentContent() {
		return parentContent;
	}

	public void setParentContent(String parentContent) {
		this.parentContent = parentContent;
	}

	public String pic;

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}