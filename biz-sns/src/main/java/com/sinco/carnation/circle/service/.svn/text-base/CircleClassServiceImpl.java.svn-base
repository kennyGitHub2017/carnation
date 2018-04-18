package com.sinco.carnation.circle.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sns.dao.CircleClassDao;
import com.sinco.carnation.sns.model.CircleClass;

@Service
@Transactional
public class CircleClassServiceImpl {

	@Autowired
	private CircleClassDao circleClassDao;

	public boolean save(CircleClass circleClass) {
		/**
		 * init other field here
		 */
		try {
			this.circleClassDao.save(circleClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public CircleClass getObjById(Long id) {
		CircleClass circleClass = this.circleClassDao.get(id);
		if (circleClass != null) {
			return circleClass;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.circleClassDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> circleClassIds) {
		// TODO Auto-generated method stub
		for (Serializable id : circleClassIds) {
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
//		GenericPageList pList = new GenericPageList(CircleClass.class,construct, query,
//				params, this.circleClassDao);
//		if (properties != null) {
//			PageObject pageObj = properties.getPageObj();
//			if (pageObj != null)
//				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
//						.getCurrentPage(), pageObj.getPageSize() == null ? 0
//						: pageObj.getPageSize());
//		} else
//			pList.doList(0, -1);
//		return pList;
//	}

	public boolean update(CircleClass circleClass) {
		try {
			this.circleClassDao.update(circleClass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//	public List<CircleClass> query(String query, Map params, int begin, int max){
//		return this.circleClassDao.query(query, params, begin, max);
//		
//	}
}
