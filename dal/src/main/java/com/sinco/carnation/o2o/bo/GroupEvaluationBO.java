package com.sinco.carnation.o2o.bo;

import com.sinco.carnation.o2o.model.GroupEvaluation;

public class GroupEvaluationBO extends GroupEvaluation {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 客户昵称
	 */
	private String nickName;
	/**
	 * 用户头像
	 */
	private String avatarUrl;

	private String groupInfo;

	private Long storeId;
	private String storeName;
	/**
	 * 总数
	 */
	private Integer num;
	/**
	 * 平均分
	 */
	private Long averageScore;
	/**
	 * 合计
	 */
	private Long totalScore;
	// 服务名称
	private String goodsName;
	// 订单号
	private String orderNum;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public Long getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Long averageScore) {
		this.averageScore = averageScore;
	}

	public Long getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
}
