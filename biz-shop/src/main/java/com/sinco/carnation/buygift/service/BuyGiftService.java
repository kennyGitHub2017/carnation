package com.sinco.carnation.buygift.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.BuygiftDao;
import com.sinco.carnation.shop.model.Buygift;

@Service
@Transactional
public class BuyGiftService {
	@Autowired
	private BuygiftDao buyGiftDao;

	public boolean save(Buygift buyGift) {
		/**
		 * init other field here
		 */
		try {
			this.buyGiftDao.save(buyGift);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Buygift getObjById(Long id) {
		Buygift buyGift = this.buyGiftDao.get(id);
		if (buyGift != null) {
			return buyGift;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.buyGiftDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> buyGiftIds) {
		// TODO Auto-generated method stub
		for (Serializable id : buyGiftIds) {
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
//		GenericPageList pList = new GenericPageList(BuyGift.class, construct,
//				query, params, this.buyGiftDao);
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

	public boolean update(Buygift buyGift) {
		try {
			this.buyGiftDao.update(buyGift);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<BuyGift> query(String query, Map params, int begin, int max) {
//		return this.buyGiftDao.query(query, params, begin, max);
//
//	}
}
