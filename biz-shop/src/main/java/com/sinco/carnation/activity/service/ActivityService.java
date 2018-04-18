package com.sinco.carnation.activity.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.bo.ActivityBO;
import com.sinco.carnation.shop.dao.ActivityDao;
import com.sinco.carnation.shop.model.Activity;
import com.sinco.carnation.shop.vo.ActivityShopVO;

/**
 * 商城活动
 * 
 * @author Administrator
 * 
 */
@Service
@Transactional
public class ActivityService {
	@Autowired
	private ActivityDao activityDao;

	/**
	 * 得到商城活动
	 * 
	 * @param vo
	 * @return
	 */
	public List<ActivityBO> findShopByVO() {
		ActivityShopVO vo = new ActivityShopVO();
		vo.setBeginTime(new Date());
		vo.setEndTime(new Date());
		// vo.setAcStatus(acStatus);

		return null;
	}

	public boolean save(Activity activity) {
		/**
		 * init other field here
		 */
		try {
			this.activityDao.save(activity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Activity getObjById(Long id) {
		Activity activity = this.activityDao.get(id);
		if (activity != null) {
			return activity;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.activityDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> activityIds) {
		// TODO Auto-generated method stub
		for (Serializable id : activityIds) {
			delete((Long) id);
		}
		return true;
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(Activity.class, construct,
//				query, params, this.activityDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(
//						pageObj.getCurrentPage() == null ? 0 : pageObj
//								.getCurrentPage(),
//						pageObj.getPageSize() == null ? 0 : pageObj
//								.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(Activity activity) {
		try {
			this.activityDao.update(activity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<Activity> query(String query, Map params, int begin, int max) {
//		return this.activityDao.query(query, params, begin, max);
//
//	}
}
