package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 创建订单
 * 
 * @author james
 * 
 */
public class ShopCreateOrderFormVO extends BasicParamVO {
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	@Param(desc = "送货地址")
	private Long addrId;

	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	@Param(desc = "运输方式，类型：平邮、快递、EMS，格式 \"{\"店铺id\":\"平邮\",\"店铺id\":\"快递\"}\" 自营使用self "
			+ "例：{\"self\":\"快递\"}")
	private String transportIds;

	@Param(desc = "订单留言，格式 \"{\"店铺id\":\"留言\"}\" 自营使用self 例：{\"self\":\"加价\"}")
	private String msgs;

	@Param(desc = "优惠劵id，格式 \"{\"店铺id\":优惠劵id}\" 自营使用self 例：{\"self\":1}")
	private String couponIds;

	@Param(desc = "使用积分兑购商品，格式为购物车id \",\"分隔  例：12,13")
	private String integralIds;

	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	@Param(desc = "所提交的购物车商品, 格式为购物车id \",\"分隔  例：12,13")
	private String gcIds;
	
	@Param(desc = "支付方式 1 重消 2积分 0其他")
	private Integer payTypeFlag;

	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}

	public String getTransportIds() {
		return transportIds;
	}

	public void setTransportIds(String transportIds) {
		this.transportIds = transportIds;
	}

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

	public String getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}

	public String getIntegralIds() {
		return integralIds;
	}

	public void setIntegralIds(String integralIds) {
		this.integralIds = integralIds;
	}

	public String getGcIds() {
		return gcIds;
	}

	public void setGcIds(String gcIds) {
		this.gcIds = gcIds;
	}

	public Integer getPayTypeFlag() {
		if (payTypeFlag == null) {
			payTypeFlag = 0;
		}
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}
	
}
