package com.sinco.carnation.jiuye.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.utils.httpclient.HttpRequestClient;
import com.sinco.biz.utils.httpclient.Httpclient;
import com.sinco.carnation.jiuye.bo.JiuyeOrderBO;
import com.sinco.carnation.jiuye.bo.JiuyeTotalDataBO;
import com.sinco.carnation.jiuye.config.JiuyeConfig;
import com.sinco.carnation.jiuye.constant.JiuyeContants;
import com.sinco.carnation.jiuye.dao.JiuyeOrderDao;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.utils.IdTypeHandler;
import com.sinco.carnation.jiuye.vo.JiuyeOrderManageVO;
import com.sinco.carnation.jiuye.vo.JiuyeOrderPojectVO;
import com.sinco.carnation.jiuye.vo.JiuyeOrderVO;
import com.sinco.dal.common.MyPage;

/***
 * 酒业订单业务相关
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class JiuyeOrderFormService {
	private static final Logger log = LoggerFactory
			.getLogger(JiuyeOrderFormService.class);
	@Autowired
	private JiuyeOrderDao jiuyeOrderDao;

	/**
	 * 保存酒业订单信息
	 * 
	 * @param record
	 * @throws ServiceException
	 */
	public int save(JiuyeOrderVO jiuyeOrderVO) throws ServiceException {

		if (null == jiuyeOrderVO) {
			return 101;
		}

		JiuyeOrder record = new JiuyeOrder();
		// 对象间转换
		BeanUtils.copyProperties(jiuyeOrderVO, record);

		// 解密订单ID
		long orderId = 0;
		if (null != jiuyeOrderVO.getId()) {
			orderId = IdTypeHandler.decode(jiuyeOrderVO.getId());
		}
		// 封装订单信息
		record.setOrderId(orderId);
		record.setOrderDetailDto(null != jiuyeOrderVO.getOrderDetailDto() ? jiuyeOrderVO
				.getOrderDetailDto().toString() : null);

		// 根据订单ID获取订单详情
		JiuyeOrder jiuyeOrder = jiuyeOrderDao.findByOrderId(orderId);
		if (null == jiuyeOrder) { // 无订单信息则添加
			record.setAddTime(new Date());
			record.setLastUpdateTime(new Date());
			jiuyeOrderDao.save(record);
		} else {// 订单信息已存在则更新
			record.setLastUpdateTime(new Date());
			jiuyeOrderDao.update(record);
		}
		return 100;
	}

	public JiuyeOrder findByOrderId(long orderId) {
		return this.jiuyeOrderDao.findByOrderId(orderId);
	}

	/**
	 * 微信、支付宝支付时需要 设置TradeNo
	 * 
	 * @param orderId
	 * @param paymentId
	 */
	public void updateOrderPayment(Long orderId, Long paymentId) {
		JiuyeOrder res = this.jiuyeOrderDao.findByOrderId(orderId);
		if (res != null) {
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			res.setTradeNo("jyorder-" + trade_no + "-"
					+ res.getOrderId().toString());
			res.setPaymentId(CommUtil.null2Int(paymentId));
			res.setOrderId(orderId);
			res.setLastUpdateTime(new Date());
			jiuyeOrderDao.update(res);
		}
	}

	public JiuyeOrder payStateCheck(long orderId) {
		return this.jiuyeOrderDao.payStateCheck(orderId);
	}

	/***
	 * 酒业支付之后 1- 信息更新
	 * 
	 * @param orderId
	 * @param amount
	 */
	public void orderPayPayHandle(String orderId, double amount) {
		JiuyeOrder jiuyeOrder = this.jiuyeOrderDao.findByOrderId(CommUtil
				.null2Long(orderId));

		if (jiuyeOrder != null && jiuyeOrder.getOrderStatus() >= 2) {
			log.error("orderPayPayHandle jiuyeOrder.getOrderStatus() ERROR {}",
					jiuyeOrder.getOrderStatus());
		}
		if (jiuyeOrder != null && jiuyeOrder.getOrderStatus() < 2) {
			System.out.println("jiuyeOrder.getPaymentId()"
					+ jiuyeOrder.getPaymentId() + "jiuyeOrder.getOrderType()"
					+ jiuyeOrder.getOrderType());
			jiuyeOrder.setOrderStatus(2);
			jiuyeOrder.setLastUpdateTime(new Date());
			jiuyeOrder.setRealPayMoney(CommUtil.null2BigDecimal(amount));
			jiuyeOrder.setPayTime(new Date());
			jiuyeOrder.setOrderId(CommUtil.null2Long(orderId));
			jiuyeOrder.setOrderType(jiuyeOrder.getOrderType());
			jiuyeOrder.setPaymentId(jiuyeOrder.getPaymentId());

			try {
				jiuyeOrderDao.update(jiuyeOrder);
				this.orderPayNotifyJiuye(orderId, amount);
			} catch (Exception e) {
				log.error("orderPayPayHandle jiuyeOrderDao.update ERROR {}",
						orderId);
			}
		}
	}

	/***
	 * 酒业支付之后 2-支付回调后通知酒业
	 * 
	 * @param orderId
	 * @param amount
	 */
	public void orderPayNotifyJiuye(String orderId, double amount) {
		// 组装接口参数
		StringBuffer remoteURL = new StringBuffer();
		remoteURL.append(JiuyeConfig.getRemoteServiceDomain()).append(
				JiuyeContants.ORDER_PAY_NOTIFY);
		Map<String, String> argumentsMap = new HashMap<String, String>();
		argumentsMap.put("orderId", orderId);
		argumentsMap.put("payStatus", "SUCCESS");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(new Date());
		argumentsMap.put("payTime", dateString);
		argumentsMap.put("payPrice", CommUtil.null2String(amount));
		argumentsMap.put("poundage", "0");

		// 远程数据访问
		Httpclient<JiuyeOrderPojectVO> httpClient = new HttpRequestClient<JiuyeOrderPojectVO>();
		JiuyeOrderPojectVO payNotify = null;
		try {
			payNotify = httpClient.post(remoteURL.toString(), argumentsMap,
					JiuyeOrderPojectVO.class);
			if (payNotify != null) {
				log.info("ORDER_PAY_NOTIFY payNotify.getCode() {} {}", orderId,
						payNotify.getCode());
			} else {
				log.info("httpClient.post RETURN NULL orderPayPayHandle{} ",
						orderId);
			}
		} catch (Exception e) {
			log.error("httpClient.post RETURN ERROR orderPayPayHandle{} ",
					orderId);
		}
	}

	public List<String> querySynOrderId(int page, int size) {
		page = page > 1 ? page : 1;
		size = size > 0 ? size : 1;
		return jiuyeOrderDao.querySynOrderId((page - 1) * size, size);
	}

	public int updateOrderStatusByOrderId(String orderId, int orderStatus) {
		return jiuyeOrderDao.updateOrderStatusByOrderId(orderId, orderStatus);
	}

	public Map<String, Object> getRefundOrderByOrderId(String orderId) {
		return jiuyeOrderDao.getRefundOrderByOrderId(orderId);
	}

	/**
	 * 获取酒业订单列表
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<JiuyeOrderBO> getJiuyeOrderList(JiuyeOrderManageVO vo,
			MyPage<JiuyeOrderBO> page) {
		return jiuyeOrderDao.getJiuyeOrderList(vo, page);
	}

	/**
	 * 获取总销售金额
	 * 
	 * @param vo
	 * @return
	 */
	public JiuyeTotalDataBO findOrderTotalPayMoney(JiuyeOrderManageVO vo) {
		return jiuyeOrderDao.findOrderTotalPayMoney(vo);
	}

	/**
	 * 获取总退款金额
	 * 
	 * @param vo
	 * @return
	 */
	public JiuyeTotalDataBO findOrderTotalRefundsMoney(JiuyeOrderManageVO vo) {
		return jiuyeOrderDao.findOrderTotalRefundsMoney(vo);
	}

}
