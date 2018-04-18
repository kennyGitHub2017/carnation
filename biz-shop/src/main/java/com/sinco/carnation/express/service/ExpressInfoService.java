package com.sinco.carnation.express.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.ExpressInfoDao;
import com.sinco.carnation.shop.model.ExpressInfo;

@Service
@Transactional
public class ExpressInfoService {
	@Autowired
	private ExpressInfoDao expressInfoDao;

	public boolean save(ExpressInfo expressInfo) {
		/**
		 * init other field here
		 */
		try {
			this.expressInfoDao.save(expressInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ExpressInfo getObjById(Long id) {
		ExpressInfo expressInfo = this.expressInfoDao.get(id);
		if (expressInfo != null) {
			return expressInfo;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.expressInfoDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> expressInfoIds) {
		// TODO Auto-generated method stub
		for (Serializable id : expressInfoIds) {
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
//		GenericPageList pList = new GenericPageList(ExpressInfo.class,construct, query,
//				params, this.expressInfoDao);
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

	public boolean update(ExpressInfo expressInfo) {
		try {
			this.expressInfoDao.update(expressInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<ExpressInfo> query(String query, Map params, int begin, int max) {
//		return this.expressInfoDao.query(query, params, begin, max);
//
//	}
//
}
