package com.sinco.carnation.shop.vo;

public class ConsultVO {
	
	private Long goodsId;
	
	private String consultType;
	
	private Boolean reply;
private Long consultUserId;
	private String consultUserName;
	private String storeId;
	
	public String getConsultType() {
		return consultType;
	}

	public void setConsultType(String consultType) {
		this.consultType = consultType;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	

	public Boolean getReply() {
		return reply;
	}

	public void setReply(Boolean reply) {
		this.reply = reply;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Long getConsultUserId() {
		return consultUserId;
	}

	public void setConsultUserId(Long consultUserId) {
		this.consultUserId = consultUserId;
	}

	public String getConsultUserName() {
		return consultUserName;
	}

	public void setConsultUserName(String consultUserName) {
		this.consultUserName = consultUserName;
	}
	
	
}