package com.sinco.carnation.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.market.bo.ActCouponGetInfoBO;
import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.dao.ActCouponGetInfoDao;
import com.sinco.carnation.market.vo.ActCouponGetInfoVO;
import com.sinco.dal.common.MyPage;

/**
 * 促销优惠券活动相关Service
 * 
 * @author 林补
 * 
 */
@Service
public class ActMarketCouponGetService {

	@Autowired
	ActCouponGetInfoDao actCouponGetInfoDao;

	/**
	 * 所有优惠券活动明细信息列表
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<ActMarketCouponBO> findAllByPage(ActCouponGetInfoVO vo, MyPage<ActCouponGetInfoBO> page) {
		return this.actCouponGetInfoDao.findAllByPage(vo, page);
	}

	/**
	 * 领取优惠券的数量
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public int countGetCouponNum(Long id) {
		return this.actCouponGetInfoDao.countGetCouponNum(id);
	}

}
