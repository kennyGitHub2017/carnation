package com.sinco.carnation.market.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.market.bo.ActMarketCouponBO;
import com.sinco.carnation.market.dao.ActCouponGetInfoDao;
import com.sinco.carnation.market.dao.ActMarketCouponDao;
import com.sinco.carnation.market.model.ActCouponGetInfo;
import com.sinco.carnation.market.model.ActMarketCoupon;
import com.sinco.carnation.market.vo.ActMarketCouponVO;
import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.model.Coupon;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.dal.common.MyPage;

/**
 * 促销优惠券活动相关Service
 * 
 * @author 任超 , 林补
 * 
 */
@Service
public class ActMarketCouponService {

	@Autowired
	ActMarketCouponDao actMarketCouponDao;

	@Autowired
	ActCouponGetInfoDao actCouponGetInfoDao;

	@Autowired
	private CouponService couponService;

	@Autowired
	private CouponInfoService couponInfoService;

	@Autowired
	private UserCustomerDao userCustomerDao;

	/**
	 * 所有优惠券活动列表
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<ActMarketCouponBO> findAllByPage(ActMarketCouponVO vo, MyPage<ActMarketCouponBO> page) {
		return this.actMarketCouponDao.findAllByPage(vo, page);
	}

	/**
	 * 保存优惠券活动
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActMarketCouponVO vo) {
		this.actMarketCouponDao.save(vo);
	}

	public Object findById(Long id) {
		return this.actMarketCouponDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveOrCreate(HttpServletRequest request, ActMarketCouponVO vo) throws Exception {
		if (vo.getId() <= 0) {
			vo.setId(null);

		} else {
			// 如果查询是否已经领取，如果优惠券被领用了，不能保存
			if (this.actCouponGetInfoDao.existsGetCouponRecord(vo.getId())) {
				throw new Exception("优惠券被人领取，无法重新保存！");
			}

		}

		BigDecimal x = new BigDecimal(vo.getTotalCount().longValue());
		BigDecimal answer = x.multiply(new BigDecimal(vo.getCouponNum().longValue()));

		// 发行总金额
		vo.setTotalMoney(answer);
		vo.setCreateTime(new Date());
		vo.setPerLimitCount(1L);
		ActMarketCoupon record = actMarketCouponDao.save(vo);// 需要关联coupon_id

		// 先创建shop_coupon
		Coupon coupon = new Coupon();
		Date addTime = new Date();
		coupon.setId(vo.getCouponId());
		coupon.setAddTime(addTime);
		coupon.setCouponBeginTime(vo.getUseStart());
		coupon.setCouponEndTime(vo.getUseEnd());
		coupon.setCouponAmount(vo.getCouponNum().longValue());
		coupon.setCouponOrderAmount(vo.getMinMoney().longValue());
		coupon.setCouponName(vo.getSchemeName());
		coupon.setCouponCount(vo.getTotalCount().intValue());
		coupon.setNewYearId(record.getId());
		Coupon c = couponService.save(coupon);

		if (vo.getCouponId() == null) {
			record.setCouponId(c.getId());
			actMarketCouponDao.save(record);// 活动主表保存优惠券id
		}

	}

	@Transactional(readOnly = false)
	public void deleteRecord(ActMarketCouponVO vo) throws Exception {

		if (this.actCouponGetInfoDao.existsGetCouponRecord(vo.getId())) {
			throw new Exception("优惠券已被人领取，无法删除记录！");
		}

		// 1.删除shop_coupon_info
		ActMarketCouponBO bo = actMarketCouponDao.findOne(vo.getId());
		// 删除相关的优惠券记录 shop_coupon / shop_coupon_info
		Coupon coupon = couponService.getObjById(bo.getCouponId());
		coupon.setDeleteStatus(true);
		couponService.update(coupon);
		// couponService.delete(bo.getCouponId());

		CouponInfo couponInfo = new CouponInfo();
		couponInfo.setCouponId(coupon.getId());
		couponInfo.setDeleteStatus(true);
		couponInfoService.update(couponInfo);
		// couponInfoService.deleteByMainCouponId(coupon.getId());
		vo.setDeleteStatus((byte) 1);
		actMarketCouponDao.update(vo);

		// actMarketCouponDao.delete(vo.getId());
	}

	public void handleEnable(Long id, byte isEnabled) {
		ActMarketCoupon record = new ActMarketCoupon();
		record.setId(id);
		record.setIsEnabled(isEnabled);
		this.actMarketCouponDao.update(record);

	}

	/**
	 * 获得权重最大的记录
	 * 
	 * @return
	 */
	public ActMarketCouponBO getActMarketCouponMax() {
		return actMarketCouponDao.getActMarketCouponMax();
	}

	/**
	 * 抢优惠券
	 * 
	 * @return
	 */
	@Transactional(readOnly = false)
	public synchronized Map<String, String> grabCashCoupon(Long actCouponId, Long userId) {
		Map<String, String> map = new HashMap<String, String>();
		String status = "-1";
		UserCustomerBO user = userCustomerDao.findBOByUserId(userId);
		if (user != null) {

			if (actCouponGetInfoDao.existsUserCouponRecord(userId, actCouponId)) {// ||
				status = "2";// 抢过券
			} else {
				ActMarketCouponBO act = actMarketCouponDao.findOne(actCouponId);
				if (act != null) {
					if (act.getIsEnabled() == 0) {
						status = "1"; // 未开启
					} else if (!act.getGetStart().before(new Date()) || !act.getGetEnd().after(new Date())) {
						status = "1"; // 未到抢券时间
					} else if (act.getTotalMoney().compareTo(BigDecimal.valueOf(0.0)) == 0) {
						status = "1";// 金额未设置
					} else if (act.getGetCount() == act.getTotalCount()) {// 领取量<发行量
						status = "4";// 已经抢完
					} else if (act.getEndTime().before(new Date())) {
						status = "4";// 活动已结束
					} else if (act.getIsEnabled() == 1
							&& act.getTotalMoney().compareTo(BigDecimal.valueOf(0.0)) == 1
							&& act.getGetStart().before(new Date()) && act.getGetEnd().after(new Date())) {
						status = generateCouponInfoResult(userId, act);
					}

				} else {
					status = "-1";
				}
			}

		} else {
			status = "-2";
		}
		map.put("status", status);
		return map;
	}

	/**
	 * 生成优惠券
	 * 
	 * @param userId
	 * @param act
	 * @return
	 */
	@Transactional(readOnly = false)
	private synchronized String generateCouponInfoResult(Long userId, ActMarketCouponBO act) {
		String status = "-1";
		// 抢券所有记录数
		Long count = actCouponGetInfoDao.count();
		CouponInfoMyVO vo = new CouponInfoMyVO();
		vo.setId(act.getCouponId());
		// 春节活动下所有优惠券明细
		List<CouponInfoBO> infos = couponInfoService.findMyCoupon(vo, null);
		// 春节活动券
		CouponBO bo = couponService.queryNewYearById(act.getId());
		// 活动券小于发行数量
		if (infos == null || infos.size() < bo.getCouponCount()) {
			ActCouponGetInfo info = new ActCouponGetInfo();
			info.setGetTime(new Date());
			info.setUserId(userId);
			info.setActCouponId(act.getId());
			info.setCouponInfoId(bo.getId());
			// 抢卷概率
			if (count % act.getRate() == 0) {
				info.setIsGet("1");
				status = "0"; // 抢到券了
				// 生成优惠券
				CouponInfo couponInfo = new CouponInfo();
				couponInfo.setAddTime(new Date());
				couponInfo.setCouponId(bo.getId());
				couponInfo.setCouponSn(UUID.randomUUID().toString());
				couponInfo.setUserId(userId);
				couponInfo.setStatus(0);
				couponInfoService.save(couponInfo);
				act.setGetCount(act.getGetCount() + 1);// 领取量叠加
				actMarketCouponDao.update(act);
			} else {
				status = "3";// 未抢到券
				info.setIsGet("0");
			}
			actCouponGetInfoDao.save(info);
		} else {
			status = "4";// 活动结束，券已抢完
		}

		return status;

	}

}
