package com.sinco.carnation.elong.service.remote.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.api.HotelOrderPayApi;
import com.sinco.carnation.elong.api.ValidateCreditCardApi;
import com.sinco.carnation.elong.model.elong.CreditCard;
import com.sinco.carnation.elong.model.elong.EnumIdType;
import com.sinco.carnation.elong.model.elong.EnumShowStatus;
import com.sinco.carnation.elong.model.elong.OrderPayCondition;
import com.sinco.carnation.elong.model.elong.ValidateCreditCardCondition;
import com.sinco.carnation.elong.model.h5.result.CreditCardValidateResult;
import com.sinco.carnation.elong.model.h5.result.HotelOrderPayResult;
import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.order.OrderDetailViewModel;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.PaySubmitRequest;
import com.sinco.carnation.elong.service.remote.IOrderService;
import com.sinco.carnation.elong.service.remote.IPayService;
import com.sinco.carnation.elong.service.remote.impl.common.CommonService;
import com.sinco.carnation.elong.util.AppConfigUtil;
import com.sinco.carnation.elong.util.Tool;

/**
 * 支付相关业务逻辑
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午4:01:07   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@Service
public class PayService implements IPayService {
	
	@Autowired
	private ValidateCreditCardApi validateCreditCardApi;
	@Autowired
	private HotelOrderPayApi hotelOrderPayApi;
	@Autowired
	private IOrderService orderservice;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 
	 * 提交支付信息
	 *
	 * @param paySubmitReq
	 * @return
	 */
	public ResultInfo<Boolean> submitOrderPay(PaySubmitRequest paySubmitReq){
		ResultInfo<Boolean> result = new ResultInfo<Boolean>();
		
		//获取订单
		OrderDetailViewModel orderDetail;
		ResultInfo<OrderDetailViewModel> orderDetailRet = orderservice.getOrderDetail(paySubmitReq.getOrderId());
		if(orderDetailRet.getIsSuccess() && orderDetailRet.getData() != null){
			orderDetail = orderDetailRet.getData();
		}else {
			result.setMsg(orderDetailRet.getMsg());
			return result;
		}
		
		/**
		 * 订单状态判断
		 * 注：若订单状态变化，则不应该提交支付请求，代理商可以引导用户去订单列表页或者订单详情页
		 */
		if(commonService.isNeedPay(orderDetailRet.getData().getStatus(), orderDetailRet.getData().getShowStatus()) == false){
			result.setMsg("超时的支付，订单状态：" + EnumShowStatus.parseEnumShowStatus(orderDetailRet.getData().getShowStatus()).getDescription());
			return result;
		}
		
		/**
		 * 订单金额确认
		 * 若订单中返回的金额与请求参数中的金额不一致，则需要提示用户
		 */
		if(orderDetail.getTotalPriceExchanged().equals(paySubmitReq.getAmount()) == false){
			result.setMsg("支付金额有误");
			return result;
		}
		
		//整理请求参数
		OrderPayCondition payCondition = new OrderPayCondition();
		payCondition.setOrderId(paySubmitReq.getOrderId());
		payCondition.setAmount(orderDetail.getTotalPriceExchanged());
		payCondition.setIsGuaranteeOrCharged(false);//默认设置为false,代理商可以根据自己的情况设置
		CreditCard cardInfo = new CreditCard();
		cardInfo.setNumber(getEncryptionCardNo(paySubmitReq.getCardNo().trim()));
		cardInfo.setHolderName(paySubmitReq.getHolderName().trim());
		cardInfo.setIdNo(paySubmitReq.getIdNo().trim());
		cardInfo.setIdType(EnumIdType.fromValue(paySubmitReq.getIdType().trim()));
		cardInfo.setExpirationYear(Integer.parseInt(paySubmitReq.getExpiration().substring(0, 4)));
		cardInfo.setExpirationMonth(Integer.parseInt(paySubmitReq.getExpiration().substring(4)));
		if(paySubmitReq.getCvv() != null && !"".equals(paySubmitReq.getCvv().trim())){
			cardInfo.setCVV(paySubmitReq.getCvv().trim());
		}
		payCondition.setCreditCard(cardInfo);
		
		//调用支付API
		HotelOrderPayResult payRet = hotelOrderPayApi.Invoke(payCondition);
		if("0".equals(payRet.getCode()) && payRet.getResult() != null){
			result.setIsSuccess(payRet.getResult().getIsSuccess());
			result.setMsg(payRet.getResult().getNotes());
		}else {
			result.setMsg(payRet.getCode());//此处代理商可以翻译错误码为友好提示
		}
		return result;
	}
	
	/**
	 * 
	 * 验证信用卡号是否有效
	 * Data属性标示是否需要提供CVV
	 *
	 * @param plainCardNo
	 * @return 
	 *
	 * @see com.elong.nb.service.IPayService#validateCreditCard(java.lang.String)
	 */
	public ResultInfo<Boolean> validateCreditCard(String plainCardNo){
		ResultInfo<Boolean> result = new ResultInfo<Boolean>();
		
		//赋值请求参数
		ValidateCreditCardCondition condition = new ValidateCreditCardCondition();
		condition.setCreditCardNo(getEncryptionCardNo(plainCardNo));
		if(condition.getCreditCardNo() == null){
			result.setMsg("信用卡加密失败");
			return result;
		}
		
		//调用接口
		CreditCardValidateResult validateRet = validateCreditCardApi.Invoke(condition);
		if("0".equals(validateRet.getCode()) && validateRet.getResult() != null){
			result.setIsSuccess(validateRet.getResult().isIsValid());
			result.setData(validateRet.getResult().isIsNeedVerifyCode());
			result.setMsg(validateRet.getResult().isIsValid() ? "验证通过" : "卡号不可用");
		}else {
			System.out.println(validateRet.getCode());
			result.setMsg("调用验证API失败");
		}
		
		return result;
	}
	
	/**
	 * 
	 * 加密卡号
	 *
	 * @param plainCardNo
	 * @return
	 */
	private String getEncryptionCardNo(String plainCardNo){
		//获取加密密钥
		String appKey = AppConfigUtil.getCommonConfig("appKey");
		String key = appKey.substring(appKey.length() - 8);
		
		//整理加密字符串
		long epoch = System.currentTimeMillis()/1000;
		String rawString = epoch + "#" + plainCardNo;
		
		//加密
		String desCardNo = null;
		try {
			desCardNo = Tool.encryptDES(rawString, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desCardNo;
	}
}
