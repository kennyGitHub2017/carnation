package com.sinco.carnation.pay.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.dao.PredepositDao;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.user.UserContants;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
@Transactional
public class PredepositService {
	@Autowired
	private PredepositDao predepositDao;

	/**
	 * 根据流水号查询
	 * 
	 * @param id
	 * @return
	 */
	public PredepositBO findByPdSn(String pdSn) {
		return predepositDao.findByPdSn(pdSn);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PredepositBO findBOById(Long id) {
		return predepositDao.findBOById(id);
	}

	/**
	 * 根据用户分页查询
	 * 
	 * @param uid
	 * @param page
	 * @return
	 */
	public MyPage<PredepositBO> findPageByUid(Long uid, MyPage<PredepositBO> page) {
		return predepositDao.findPageByUid(uid, page);
	}

	public List<PredepositBO> queryPredepositPageList(String pdPayment, String pdPayStatus, String pdStatus,
			String pdRemittanceUser, String pdRemittanceBank, String pdUserName, String beginTime,
			String endTime, String pdSn, MyPage<PredepositBO> page) {

		return predepositDao.queryPredepositPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, pdSn, page);
	}

	/**
	 * 创建云豆充值
	 * 
	 * @return
	 */
	public Long save(Long orderId, String orderType, String pdPayment, BigDecimal pdAmount, Long uid) {
		Predeposit obj = new Predeposit();
		obj.setPdOrderId(orderId);
		obj.setPdOrderType(orderType);
		obj.setPdUserId(uid);
		obj.setPdPayStatus(UserContants.PD_PAY_STATUS_0);
		obj.setPdPayment(pdPayment);
		obj.setPdAmount(pdAmount);

		return this.save(obj, uid);
	}

	/**
	 * 创建云豆充值
	 * 
	 * @param predeposit
	 * @param uid
	 * @return
	 */
	public Long save(Predeposit predeposit, Long uid) {

		if (predeposit.getId() == null) {
			predeposit.setPdSn("pd" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + uid);
			predeposit.setAddTime(new Date());
			predeposit.setPdStatus(UserContants.PD_STATUS_0);
		}

		this.predepositDao.save(predeposit);

		// 产生支付id
		String tradeNo = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		predeposit.setPdNo("pd-" + tradeNo + "-" + predeposit.getId().toString());

		this.predepositDao.save(predeposit);
		return predeposit.getId();
	}

	public Predeposit getObjById(Long id) {
		Predeposit predeposit = this.predepositDao.get(id);
		if (predeposit != null) {
			return predeposit;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.predepositDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> predepositIds) {
		// TODO Auto-generated method stub
		for (Serializable id : predepositIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(Predeposit predeposit) {
		try {
			this.predepositDao.update(predeposit);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String pdPayment(String payment)
	{
		String result = "";
		if(null == payment){
			return result;
		}
		if(payment.equals("alipay") || payment.equals("alipay_app") || payment.equals("alipayB"))
		{
			result = "支付宝";
		}
		else if(payment.equals("wxqrpay") || payment.equals("wx_app"))
		{
			result = "微信支付";
		}
		else
		{
			result = payment;
		}
		return result;
	}
	
	
	public String payStatus(int pdPayStatus)
	{
		String result = "";
		if(pdPayStatus==0)
		{
			result = "等待支付";
		}
		else if(pdPayStatus==1)
		{
			result = "等待审核";
		}
		else if(pdPayStatus==2)
		{
			result = "支付完成";
		}
		return result;
	}
	
	
	public String pdStatus(int pdStatus)
	{
		String result = "";
		if(pdStatus==-1)
		{
			result ="已关闭";
		}
		else if(pdStatus==0)
		{
			result ="未完成";
		}
		else if(pdStatus==1)
		{
			result ="已完成";
		}
		return result;
	}
}
