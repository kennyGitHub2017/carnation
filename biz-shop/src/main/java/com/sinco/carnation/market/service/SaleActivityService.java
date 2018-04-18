package com.sinco.carnation.market.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.dao.ActivityHotSaleDao;
import com.sinco.carnation.market.model.ActivityHotSale;
import com.sinco.carnation.market.model.ActivityHotSaleExample;
import com.sinco.carnation.market.vo.ActivityHotSaleVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class SaleActivityService {
	@Autowired
	private ActivityHotSaleDao activityHotSaleDao;

	public ActivityHotSaleBO findTop() {
		List<ActivityHotSaleBO> list = activityHotSaleDao.findAllByStartTime();
		if (list != null && list.size() > 0) {
			ActivityHotSaleBO activityHotSaleBO = list.get(0);
			return activityHotSaleBO;
		}
		return null;
	}

	public ActivityHotSaleBO findById(Long id) {
		return activityHotSaleDao.findOne(id);
	}

	public List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsList(Long actHotSaleId, String vcode) {
		List<ActivityHotSaleGoodsInfoBO> list = activityHotSaleDao.findActHotSaleGoodsList(actHotSaleId,
				vcode);
		if (list != null && list.size() > 0) {

			return list;
		}
		return null;
	}

	public List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsListByPage(Long actHotSaleId, String vcode,
			MyPage<ActivityHotSaleGoodsInfoBO> page) {
		List<ActivityHotSaleGoodsInfoBO> list = activityHotSaleDao.findActHotSaleGoodsListByPage(
				actHotSaleId, vcode, page);
		if (list != null && list.size() > 0) {
			// 如果有没有手机专享价就默认设置
			/*
			 * BigDecimal a=BigDecimal.valueOf(0); for(int i = 0 ,l =
			 * list.size(); i < l ; i++){ if(list.get(i).getGoodsMobilePrice()
			 * != null && list.get(i).getGoodsMobilePrice().compareTo(a) == 0){
			 * list.get(i).setGoodsCurrentPrice(list.get(i).getGoodsPrice()); }
			 * }
			 */
			return list;
		}
		return null;
	}

	public List<ActivityHotSaleGoodsInfoBO> queryActHotSaleGoodsListByPage(Long maxId, String actCode,
			Integer start, Integer pageSize) {
		List<ActivityHotSaleGoodsInfoBO> list = activityHotSaleDao.queryActHotSaleGoodsListByPage(maxId,
				actCode, start, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<ActivityHotSaleBO> findAllByPage(ActivityHotSaleVO vo, MyPage<ActivityHotSaleBO> page) {

		return this.activityHotSaleDao.findAllByPage(vo, page);
	}

	public ActivityHotSaleDao getActivityHotSaleDao() {
		return activityHotSaleDao;
	}

	public void setActivityHotSaleDao(ActivityHotSaleDao activityHotSaleDao) {
		this.activityHotSaleDao = activityHotSaleDao;
	}

	/**
	 * 根据vcode查询开启状态活动信息
	 * 
	 * @param actCode
	 * @return
	 */
	public ActivityHotSaleBO findTopByCode(String actCode) {
		List<ActivityHotSaleBO> list = activityHotSaleDao.findByCode(actCode);
		if (list != null && list.size() > 0) {
			ActivityHotSaleBO activityHotSaleBO = list.get(0);
			return activityHotSaleBO;
		}
		return null;
	}

	public ActivityHotSaleBO queryInfoByCode(String actCode) {
		List<ActivityHotSaleBO> list = activityHotSaleDao.queryInfoByCode(actCode);
		if (list != null && list.size() > 0) {
			ActivityHotSaleBO activityHotSaleBO = list.get(0);
			return activityHotSaleBO;
		}
		return null;
	}

	/**
	 * 查询所有有效的活动/推荐
	 * 
	 * @return
	 */
	public List<ActivityHotSaleBO> findAll() {
		ActivityHotSaleExample example = new ActivityHotSaleExample();
		example.createCriteria().andDeleteStatusEqualTo((byte) 0);
		List<ActivityHotSaleBO> list = activityHotSaleDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	List<ActivityHotSaleBO> selectByExample(ActivityHotSaleExample example) {
		return this.activityHotSaleDao.selectByExample(example);
	}

	public List<ActivityHotSale> findByActHotSaleGoodsList(ActivityHotSale obj) {
		return this.activityHotSaleDao.findByActHotSaleGoodsList(obj);
	}

	/**
	 * 查询活动列表
	 * 
	 * @param vcode
	 *            活动标识
	 * @param currentTime
	 *            系统当前时间
	 * @param dayOfMinutes
	 *            系统当前时间在一天经过的分钟数
	 * @return
	 */
	public ActivityHotSaleBO findNewAppHotSaleInfo(String vcode, Date currentTime, Integer dayOfMinutes) {
		return this.activityHotSaleDao.findNewAppHotSaleInfo(vcode, currentTime, dayOfMinutes);
	}

	public void save(ActivityHotSaleVO hotSale) {
		this.activityHotSaleDao.save(hotSale);
	}
}
