package com.sinco.carnation.watermark.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.WatermarkDao;
import com.sinco.carnation.shop.model.Watermark;

@Service
@Transactional
public class WaterMarkService {
	@Autowired
	private WatermarkDao waterMarkDao;

	public boolean save(Watermark waterMark) {
		/**
		 * init other field here
		 */
		try {
			this.waterMarkDao.save(waterMark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Watermark getObjById(Long id) {
		Watermark waterMark = this.waterMarkDao.get(id);
		if (waterMark != null) {
			return waterMark;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.waterMarkDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> waterMarkIds) {
		// TODO Auto-generated method stub
		for (Serializable id : waterMarkIds) {
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
//		GenericPageList pList = new GenericPageList(Watermark.class,construct,  query,
//				params, this.waterMarkDao);
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

	public boolean update(Watermark waterMark) {
		try {
			this.waterMarkDao.update(waterMark);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
//
//	public List<Watermark> query(String query, Map params, int begin, int max) {
//		return this.waterMarkDao.query(query, params, begin, max);
//
//	}

//	@Override
//	public WaterMark getObjByProperty(String construct, String propertyName,
//			Object value) {
//		// TODO Auto-generated method stub
//		return this.waterMarkDao.getBy(construct, propertyName, value);
//	}
}
