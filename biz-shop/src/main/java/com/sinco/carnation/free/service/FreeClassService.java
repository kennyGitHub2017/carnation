package com.sinco.carnation.free.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.FreeClassDao;
import com.sinco.carnation.shop.model.FreeClass;

@Service
@Transactional
public class FreeClassService {
	@Autowired
	private FreeClassDao freeClassDao;

	public boolean save(FreeClass freeClass) {
		/**
		 * init other field here
		 */
		try {
			this.freeClassDao.save(freeClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public FreeClass getObjById(Long id) {
		FreeClass freeClass = this.freeClassDao.get(id);
		if (freeClass != null) {
			return freeClass;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.freeClassDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> freeClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : freeClassIds) {
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
//		GenericPageList pList = new GenericPageList(FreeClass.class, construct,
//				query, params, this.freeClassDao);
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

	public boolean update(FreeClass freeClass) {
		try {
			this.freeClassDao.update(freeClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<FreeClass> query(String query, Map params, int begin, int max) {
//		return this.freeClassDao.query(query, params, begin, max);
//
//	}
}
