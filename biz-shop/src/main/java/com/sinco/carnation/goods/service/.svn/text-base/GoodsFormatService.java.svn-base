package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.bo.GoodsFormatBO;
import com.sinco.carnation.goods.dao.GoodsFormatDao;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GoodsFormatService {
	@Autowired
	private GoodsFormatDao goodsFormatDao;

	public boolean save(GoodsFormat goodsFormat) {
		/**
		 * init other field here
		 */
		try {
			this.goodsFormatDao.save(goodsFormat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoodsFormat getObjById(Long id) {
		GoodsFormat goodsFormat = this.goodsFormatDao.get(id);
		if (goodsFormat != null) {
			return goodsFormat;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goodsFormatDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goodsFormatIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsFormatIds) {
			delete((Long) id);
		}
		return true;
	}

	public void list(MyPage<GoodsFormatBO> page, Integer cat) {
		page.setContent(this.goodsFormatDao.list(page, cat));
	}

	public List<GoodsFormatBO> selectBOPageByStoreId(MyPage<GoodsFormatBO> page, Long storeId) {
		return goodsFormatDao.selectBOPageByStoreId(page, storeId);
	}

//	public IPageList list(IQueryObject properties) {
//		if (properties == null) {
//			return null;
//		}
//		String query = properties.getQuery();
//		String construct = properties.getConstruct();
//		Map params = properties.getParameters();
//		GenericPageList pList = new GenericPageList(GoodsFormat.class,construct, query,
//				params, this.goodsFormatDao);
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

	public boolean update(GoodsFormat goodsFormat) {
		try {
			this.goodsFormatDao.update(goodsFormat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<GoodsFormat> findByGFCat(Integer gfCat) {
		return this.goodsFormatDao.findByGFCat(gfCat);

	}

	public List<GoodsFormat> findByStoreId(Long storeId) {
		return this.goodsFormatDao.findByStoreId(storeId);

	}
//	public List<GoodsFormat> query(String query, Map params, int begin, int max){
//		return this.goodsFormatDao.query(query, params, begin, max);
//		
//	}
}
