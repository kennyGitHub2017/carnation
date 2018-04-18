package com.sinco.carnation.operation.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.operation.bo.CouponInfoBO;
import com.sinco.carnation.operation.dao.CouponInfoDao;
import com.sinco.carnation.operation.model.CouponInfo;
import com.sinco.carnation.operation.vo.CouponInfoMyVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class CouponInfoService {
	@Autowired
	private CouponInfoDao couponInfoDao;

	/**
	 * 查找自己的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public List<CouponInfoBO> findMyCoupon(CouponInfoMyVO vo, MyPage<CouponInfoBO> page) {
		return couponInfoDao.findMyCoupon(vo, page);
	}

	/**
	 * 查找自己的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public int countMyCoupon(CouponInfoMyVO vo) {
		return couponInfoDao.countMyCoupon(vo);
	}

	/**
	 * 查找自己的优惠券
	 * 
	 * @param vo
	 * @return
	 */
	public CouponInfoBO findMyById(Long id, Long uid) {
		return couponInfoDao.findMyById(id, uid);
	}

	public boolean save(CouponInfo couponInfo) {
		/**
		 * init other field here
		 */
		try {
			this.couponInfoDao.save(couponInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public CouponInfo getObjById(Long id) {
		CouponInfo couponInfo = this.couponInfoDao.get(id);
		if (couponInfo != null) {
			return couponInfo;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.couponInfoDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> couponInfoIds) {
		// TODO Auto-generated method stub
		for (Serializable id : couponInfoIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(CouponInfo couponInfo) {
		try {
			this.couponInfoDao.update(couponInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void deleteByMainCouponId(Long couponId) {
		this.couponInfoDao.deleteByMainCouponId(couponId);

	}
}
