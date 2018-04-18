package com.sinco.carnation.sns.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.user.model.UserExperts;
import com.sinco.common.utils.StringUtils;
import com.sinco.dal.utils.DateUtils;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ConsultingBO extends Consulting {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserExperts userExperts;

	private String customerName;

	private Date newRepayTime;

	private String reply;

	private String headPath;

	private String nickname;

	private String ename;

	private List<ConsultingRepayBO> listRepay;

	public List<String> getImageList() {
		if (StringUtils.isNotBlank(getImages())) {
			String[] image = getImages().split("\\|");
			return Lists.newArrayList(image);
		} else {
			return new ArrayList<String>();
		}
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getCreateTimeString() {
		if (createTime != null) {
			return DateUtils.formatTime(new Date().getTime() - createTime.getTime());
		}
		return null;
	}

	public List<ConsultingRepayBO> getListRepay() {
		return listRepay;
	}

	public void setListRepay(List<ConsultingRepayBO> listRepay) {
		this.listRepay = listRepay;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public UserExperts getUserExperts() {
		return userExperts;
	}

	public void setUserExperts(UserExperts userExperts) {
		this.userExperts = userExperts;
	}

	public Date getNewRepayTime() {
		return newRepayTime;
	}

	public void setNewRepayTime(Date newRepayTime) {
		this.newRepayTime = newRepayTime;
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}