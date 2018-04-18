package com.sinco.carnation.combin.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.CombinplanDao;
import com.sinco.carnation.shop.model.Combinplan;

@Service
@Transactional
public class CombinPlanService {
	@Autowired
	private CombinplanDao combinPlanDao;

	public boolean save(Combinplan combinPlan) {
		/**
		 * init other field here
		 */
		try {
			this.combinPlanDao.save(combinPlan);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Combinplan getObjById(Long id) {
		Combinplan combinPlan = this.combinPlanDao.get(id);
		if (combinPlan != null) {
			return combinPlan;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.combinPlanDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> combinPlanIds) {
		// TODO Auto-generated method stub
		for (Serializable id : combinPlanIds) {
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
//		GenericPageList pList = new GenericPageList(CombinPlan.class,
//				construct, query, params, this.combinPlanDao);
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

	public boolean update(Combinplan combinPlan) {
		try {
			this.combinPlanDao.update(combinPlan);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<CombinPlan> query(String query, Map params, int begin, int max) {
//		return this.combinPlanDao.query(query, params, begin, max);
//
//	}
}
