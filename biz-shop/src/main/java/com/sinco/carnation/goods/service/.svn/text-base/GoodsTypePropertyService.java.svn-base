package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.dao.GoodsTypePropertyDao;
import com.sinco.carnation.goods.model.GoodsTypeProperty;

@Service
@Transactional
public class GoodsTypePropertyService {
	@Autowired
	private GoodsTypePropertyDao goodsTypePropertyDao;

	public boolean save(GoodsTypeProperty goodsTypeProperty) {
		/**
		 * init other field here
		 */
		this.goodsTypePropertyDao.save(goodsTypeProperty);
		return true;
	}

	public GoodsTypeProperty getObjById(Long id) {
		GoodsTypeProperty goodsTypeProperty = this.goodsTypePropertyDao.get(id);
		if (goodsTypeProperty != null) {
			return goodsTypeProperty;
		}
		return null;
	}

	public boolean delete(Long id) {
		this.goodsTypePropertyDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Serializable> goodsTypePropertyIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsTypePropertyIds) {
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
//		GenericPageList pList = new GenericPageList(GoodsTypeProperty.class,construct, query,
//				params, this.goodsTypePropertyDao);
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
//	
	public boolean update(GoodsTypeProperty goodsTypeProperty) {
		this.goodsTypePropertyDao.update(goodsTypeProperty);
		return true;
	}
//	public List<GoodsTypeProperty> query(String query,Map params, int begin, int max){
//		return this.goodsTypePropertyDao.query(query, params, begin, max);
//		
//	}

}
