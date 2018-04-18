package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.dao.GoodsReturnDao;
import com.sinco.carnation.goods.dao.ReturnGoodsLogDao;
import com.sinco.carnation.goods.model.GoodsReturn;

@Service
@Transactional
public class GoodsReturnService {
	@Autowired
	private GoodsReturnDao goodsReturnDao;
	@Autowired
	private ReturnGoodsLogDao returnGoodsLogDao;

	public List<ReturnGoodsLogBO> findorderlogByOrderId(Long orderId) {
		List<ReturnGoodsLogBO> returnGoodsloges = returnGoodsLogDao.selectByOrderId(orderId);
		return returnGoodsloges;
	}

	public boolean save(GoodsReturn goodsReturn) {
		/**
		 * init other field here
		 */
		try {
			this.goodsReturnDao.save(goodsReturn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoodsReturn getObjById(Long id) {
		GoodsReturn goodsReturn = this.goodsReturnDao.get(id);
		if (goodsReturn != null) {
			return goodsReturn;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goodsReturnDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goodsReturnIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsReturnIds) {
			delete((Long) id);
		}
		return true;
	}

	// public IPageList list(IQueryObject properties) {
	// if (properties == null) {
	// return null;
	// }
	// String query = properties.getQuery();
	// String construct = properties.getConstruct();
	// Map params = properties.getParameters();
	// GenericPageList pList = new GenericPageList(GoodsReturn.class,
	// construct, query, params, this.goodsReturnDao);
	// if (properties != null) {
	// PageObject pageObj = properties.getPageObj();
	// if (pageObj != null)
	// pList.doList(
	// pageObj.getCurrentPage() == null ? 0 : pageObj
	// .getCurrentPage(),
	// pageObj.getPageSize() == null ? 0 : pageObj
	// .getPageSize());
	// } else
	// pList.doList(0, -1);
	// return pList;
	// }

	public boolean update(GoodsReturn goodsReturn) {
		try {
			this.goodsReturnDao.update(goodsReturn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// public List<GoodsReturn> query(String query, Map params, int begin, int
	// max) {
	// return this.goodsReturnDao.query(query, params, begin, max);
	//
	// }
}
