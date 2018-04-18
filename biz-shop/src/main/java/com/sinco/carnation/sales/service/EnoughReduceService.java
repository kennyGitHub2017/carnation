package com.sinco.carnation.sales.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.EnoughReduceDao;
import com.sinco.carnation.shop.model.EnoughReduce;

@Service
@Transactional
public class EnoughReduceService {
	@Autowired
	private EnoughReduceDao enoughReduceDao;

	public boolean save(EnoughReduce enoughReduce) {
		/**
		 * init other field here
		 */
		try {
			this.enoughReduceDao.save(enoughReduce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public EnoughReduce getObjById(Long id) {
		EnoughReduce enoughReduce = this.enoughReduceDao.get(id);
		if (enoughReduce != null) {
			return enoughReduce;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.enoughReduceDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> enoughReduceIds) {
		// TODO Auto-generated method stub
		for (Serializable id : enoughReduceIds) {
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
//		GenericPageList pList = new GenericPageList(EnoughReduce.class,
//				construct, query, params, this.enoughReduceDao);
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

	public boolean update(EnoughReduce enoughReduce) {
		try {
			this.enoughReduceDao.update(enoughReduce);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<EnoughReduce> query(String query, Map params, int begin, int max) {
//		return this.enoughReduceDao.query(query, params, begin, max);
//
//	}
}
