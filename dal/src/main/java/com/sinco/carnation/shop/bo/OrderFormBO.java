package com.sinco.carnation.shop.bo;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.shop.model.OrderForm;

/**
 * BO 用于返回数据
 */
public class OrderFormBO extends OrderForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 135443349111144405L;

	/**
	 * 所有定单总额
	 */
	public Double allOfPrice;
	private String mark;
	private String beginTime;
	private String endTime;
	private int statusCount;
	private Goods goods;
	private String loginName;
/*	private Integer orderTypeFlag;*/
	private String name;
	private String paymentName;
	private int juanpiOrder;
	private String targetUrlM;
	private boolean isDelete;
	
	//卷皮订单连接
	private static final String target_url_m = "https://m.juanpi.com/order/detail/orderId/";
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Long sellerUserId;

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	/**
	 * 云豆支付的云豆充值记录id
	 */
	private Long cashId;

	public Long getCashId() {
		return cashId;
	}

	public void setCashId(Long cashId) {
		this.cashId = cashId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Double getAllOfPrice() {
		return allOfPrice;
	}

	public void setAllOfPrice(Double allOfPrice) {
		this.allOfPrice = allOfPrice;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStatusCount() {
		return statusCount;
	}

	public void setStatusCount(int statusCount) {
		this.statusCount = statusCount;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

/*	public Integer getOrderTypeFlag() {
		return orderTypeFlag;
	}

	public void setOrderTypeFlag(Integer orderTypeFlag) {
		this.orderTypeFlag = orderTypeFlag;
	}*/

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getTargetUrlM() {
		if(null == targetUrlM) {
			return target_url_m;
		}
		return targetUrlM;
	}

	public void setTargetUrlM(String targetUrlM) {
		this.targetUrlM = targetUrlM;
	}

	public int getJuanpiOrder() {
		return juanpiOrder;
	}

	public void setJuanpiOrder(int juanpiOrder) {
		this.juanpiOrder = juanpiOrder;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}