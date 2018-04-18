package com.sinco.carnation.job;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.BalanceExceptionOrderBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.enums.EmShopQrOrderPayStatus;
import com.sinco.carnation.shop.service.BalanceExceptionOrderService;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.service.UserMoneyService;
import com.weixin.utils.Configure;
import com.weixin.utils.HttpsRequest;
import com.weixin.utils.Signature;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 定时同步微信服务器扫码订单状态，修复异常订单<br/>
 * <p>规则</p>
 * 1.当前时间 - 30分钟 > 订单时间  下单超过30分钟<br/>
 * 2.当前时间 - 48小时 < 订单时间 	48小时之内的订单<br/>
 * @author tw
 *
 */
public class WxPayOrderCheckAction {
	protected static final Logger LOGGER = LoggerFactory.getLogger(WxPayOrderCheckAction.class);
	private ShopQrPayOrderService shopQrPayOrderService;
	private GroupOrderService groupOrderService;
	private PaymentService paymentService;
	private BalanceExceptionOrderService balanceExceptionOrderService;
	private UserMoneyService userMoneyService;
	private String isDebug;
	
	public void setShopQrPayOrderService(ShopQrPayOrderService shopQrPayOrderService){
		this.shopQrPayOrderService = shopQrPayOrderService;
	}
	
	public void setGroupOrderService(GroupOrderService groupOrderService){
		this.groupOrderService = groupOrderService;
	}
	
	public void setPaymentService(PaymentService paymentService){
		this.paymentService = paymentService;
	}
	
	public void setBalanceExceptionOrderService(BalanceExceptionOrderService balanceExceptionOrderService){
		this.balanceExceptionOrderService = balanceExceptionOrderService;
	}
	
	public void setUserMoneyService(UserMoneyService userMoneyService){
		this.userMoneyService = userMoneyService;
	}
	
	public void setIsDebug(String isDebug){
		this.isDebug = isDebug;
	}
	
	/**
	 * 修复微信扫码支付异常订单
	 */
	@SuppressWarnings("rawtypes")
	public void fixPcScanOrder() {
		if("1".equals(isDebug)){
			return;
		}
		LOGGER.info("=========扫码支付订单扫描开始[fixPcScanOrder]==========");
		List<ShopQrPayOrderBO> orders = shopQrPayOrderService.queryUnpaySuccessOrder();
		//循环所有订单
		if(orders != null && orders.size() > 0){
			LOGGER.info("查询到" + orders.size() + "条记录");
			PaymentBO payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY);
			for(ShopQrPayOrderBO oo : orders){
				//判断支付状态
				ShopQrPayOrderBO order = shopQrPayOrderService.getOrderByPayOrderNo(oo.getPayOrderNo());
				if (order.getPayStatus() == (byte) EmShopQrOrderPayStatus.NoPay.getValue()) {
					//如果没有支付成功，主动去微信服务器查询
					Map resultMap = getWxOrder(order.getPayOrderNo(), payment.getWxAppid(), payment.getTenpayPartner(), payment.getWxPaysignkey());
					if(resultMap != null){
						if("SUCCESS".equals(resultMap.get("trade_state"))){
							//交易成功,完成支付
							LOGGER.info("问题订单【"+ order.getPayOrderNo() +"】支付成功，开始修复...");
							EmailUtil.send("问题订单【"+ order.getOrderId() +"】", JSONObject.toJSONString(resultMap));
							try{
								shopQrPayOrderService.complateOrderByPayOrderNo(order.getPayOrderNo(), String.valueOf(resultMap.get("transaction_id")));
								LOGGER.info("问题订单【"+ order.getOrderId() +"】修复成功");
								EmailUtil.send("问题订单【"+ order.getOrderId() +"】修复成功", JSONObject.toJSONString(resultMap));
							}catch(Exception e){
								LOGGER.error("问题订单【"+ order.getPayOrderNo() +"】修复失败", e);
								//发送邮件
								EmailUtil.send("问题订单【"+ order.getOrderId() +"】修复失败: " + e.getMessage(), CommUtil.getStackTrace(e));
							}
						}
					}
				}
			}
		}
		LOGGER.info("=========扫码支付订单扫描结束[fixPcScanOrder]==========");
	}
	
	/**
	 * 修复APP扫码支付异常订单
	 */
	@SuppressWarnings("rawtypes")
	public void fixAppScanOrder() {
		if("1".equals(isDebug)){
			return;
		}
		LOGGER.info("=========扫码支付订单扫描开始[fixAppScanOrder]==========");
		List<GroupOrderBO> orders = groupOrderService.queryUnpaySuccessOrder();
		//循环所有订单
		if(orders != null && orders.size() > 0){
			LOGGER.info("查询到" + orders.size() + "条记录");
			PaymentBO payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY);
			for(GroupOrderBO oo : orders){
				//判断支付状态
				GroupOrderBO order = groupOrderService.fetch(oo.getId());
				if (order.getOrderStatus() == GroupOrderConstants.ORDER_STATUS_SUBMIT) {
					//如果没有支付成功，主动去微信服务器查询
					Map resultMap = getWxOrder(order.getOrderId(), payment.getWxAppid(), payment.getTenpayPartner(), payment.getWxPaysignkey());
					if(resultMap != null){
						if("SUCCESS".equals(resultMap.get("trade_state"))){
							//交易成功,完成支付
							LOGGER.info("问题订单【"+ order.getOrderId() +"】支付成功，开始修复...");
							EmailUtil.send("问题订单【"+ order.getOrderId() +"】", JSONObject.toJSONString(resultMap));
							try{
								groupOrderService.generate_groupInfos(String.valueOf(order.getId()), "mch_wxqrpay", "微信扫码支付", String.valueOf(resultMap.get("transaction_id")));
								LOGGER.info("问题订单【"+ order.getOrderId() +"】修复成功");
								EmailUtil.send("问题订单【"+ order.getOrderId() +"】修复成功", JSONObject.toJSONString(resultMap));
							}catch(Exception e){
								LOGGER.error("问题订单【"+ order.getOrderId() +"】修复失败", e);
								//发送邮件
								EmailUtil.send("问题订单【"+ order.getOrderId() +"】修复失败: " + e.getMessage(), CommUtil.getStackTrace(e));
							}
						}
					}
				}
			}
		}
		LOGGER.info("=========扫码支付订单扫描结束[fixAppScanOrder]==========");
	}
	
	/**
	 * 从微信服务器查询订单数据
	 * @param orderNo 订单号
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map getWxOrder(String orderNo, String appid, String mchid, String appkey){
		if(orderNo == null || !orderNo.startsWith("life")){
			return null;
		}
		LOGGER.info("查询订单：" + orderNo);
		Map<String, String> map = new HashMap<String, String>(5);
		map.put("appid", appid);
		map.put("mch_id", mchid);
		map.put("out_trade_no", orderNo);
		map.put("nonce_str", UUID.randomUUID().toString().replace("-", ""));
		//生成签名
		String sign = Signature.generateSign(map, appkey);
		map.put("sign", sign);
		//序列化
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
		try{
			String xmlContent = xmlMapper.writeValueAsString(map);
			//发送服务器请求
			String resultXml = HttpsRequest.sendPost(Configure.PAY_QUERY_API, xmlContent);
			if(StringUtils.isNotBlank(resultXml)){
				Map resultMap = xmlMapper.readValue(resultXml, Map.class);
				if("SUCCESS".equals(resultMap.get("return_code")) && "SUCCESS".equals(resultMap.get("result_code"))){
					//查询成功
					LOGGER.info("订单["+ orderNo +"]: trade_state=" + resultMap.get("trade_state"));
					return resultMap;
				}else{
					LOGGER.info("订单["+ orderNo +"]: return_msg=" + resultMap.get("return_msg") + ",err_code_des=" + resultMap.get("err_code_des"));
				}
			}
		}catch(Exception e){
			LOGGER.error("订单查询失败: " + orderNo, e);
		}
		return null;
	}
	
	public void fixBalanceExceptionOrder() {
		if("1".equals(isDebug)){
			return;
		}
		LOGGER.info("=========修复用户云豆异常订单开始[fixBalanceExceptionOrder]==========");
		List<BalanceExceptionOrderBO> orders = balanceExceptionOrderService.queryExceptionOrder();
		if(orders != null && orders.size() > 0){
			LOGGER.info("查询到" + orders.size() + "条记录");
			for(BalanceExceptionOrderBO order : orders){
				Long sellerId = order.getSellerId();
				BigDecimal amount = order.getAmount();
				if(sellerId != null && amount != null){
					userMoneyService.addMoneyV2(sellerId, amount.doubleValue(), null, UserContants.PD_TYPE_AVAILABLE_MONEY, "线下消费", UserContant.ACCOUNT_TYPE_MERCHANT);
					order.setDeleteStatus(true);
					order.setUpdateTime(new Date());
					balanceExceptionOrderService.update(order);
				}
			}
		}
		LOGGER.info("=========修复用户云豆异常订单结束[fixBalanceExceptionOrder]==========");
	}
	
	static class EmailUtil{
		protected static Properties props = new Properties();
		static{
			props.put("mail.smtp.host", "smtp.163.com");//主机host，跟邮件发送者必须一致
	        props.put("mail.smtp.auth", "true"); // 通过验证
	        props.put("mail.smtp.port", "465");//加密服务端口465
	        props.put("mail.transport.protocol", "smtp");//方式为smtp
	        props.put("mail.smtp.ssl.enable", "true");//加密
		}
		
		public static void send(String subject, String body) {
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			Transport transport = null;
			try{
				msg.setFrom(new InternetAddress("developer123456@163.com")); 
				msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("289124510@qq.com")});
				msg.setSubject(subject); 
				msg.setText(body);
		        msg.setSentDate(new Date());  
		        msg.saveChanges(); 
		        transport = session.getTransport("smtp");  
		        transport.connect("developer123456@163.com", "developer123456");
		        transport.sendMessage(msg,msg.getRecipients(Message.RecipientType.TO));  
			}catch(Exception e){
				LOGGER.error("邮件发送失败: " + e.getMessage());
			}finally{
				try {
					transport.close();
				} catch (MessagingException e) {
				}
			}
		}
	}
	
}
