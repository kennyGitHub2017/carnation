package com.sinco.carnation.o2o.bo;

import com.sinco.carnation.o2o.model.GroupInfo;

/**
 * 
 * BO 用于返回数据
 */
@SuppressWarnings("serial")
public class GroupInfoBO extends GroupInfo {
	private String nickname;
	private String storeName;
	private String refundName;
	private GroupOrderBO groupOrderBO;
	private GroupGoodsBO groupGoodsBO;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStoreName() {
		return storeName;
	}

	/** 服务订单号 **/
	private String orderStr;

	/** 服务名 **/
	private String ggName;

	/** 服务详情 JSON **/
	private String groupInfo;

	/** 申请者昵称 **/
	private String userNickName;

	public String getOrderStr() {
		return orderStr;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public GroupOrderBO getGroupOrderBO() {
		return groupOrderBO;
	}

	public void setGroupOrderBO(GroupOrderBO groupOrderBO) {
		this.groupOrderBO = groupOrderBO;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getRefundName() {
		return refundName;
	}

	public void setRefundName(String refundName) {
		this.refundName = refundName;
	}

	public GroupGoodsBO getGroupGoodsBO() {
		return groupGoodsBO;
	}

	public void setGroupGoodsBO(GroupGoodsBO groupGoodsBO) {
		this.groupGoodsBO = groupGoodsBO;
	}

}
