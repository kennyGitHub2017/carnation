package com.sinco.carnation.goods.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.dao.GoodsBrandCategoryDao;
import com.sinco.carnation.goods.dao.GoodsBrandDao;
import com.sinco.carnation.goods.model.GoodsBrandCategory;

@Service
@Transactional
public class GoodsBrandCategoryService {
	@Autowired
	private GoodsBrandCategoryDao goodsBrandCategoryDao;

	@Autowired
	private GoodsBrandDao goodsBrandDao;

	/**
	 * 查找所有
	 * 
	 * @return
	 */
	public List<GoodsBrandCategoryBO> findAll() {
		return goodsBrandCategoryDao.findAll();
	}

	/**
	 * 查找带品牌的
	 * 
	 * @return
	 */
	public List<GoodsBrandCategoryBO> findBrandAll() {
		List<GoodsBrandCategoryBO> list = goodsBrandCategoryDao.findAll();
		List<GoodsBrandBO> brandAll = goodsBrandDao.findByCategoryIsNotNul();

		// 给品牌分类加载所有品牌
		for (GoodsBrandCategoryBO gbc : list) {
			List<GoodsBrandBO> brands = Lists.newArrayList();

			for (GoodsBrandBO gb : brandAll) {
				if (gb.getCategoryId().equals(gbc.getId())) {
					brands.add(gb);
				}
			}
			gbc.setBrands(brands);
		}
		return list;
	}

	public boolean save(GoodsBrandCategory goodsBrandCategory) {
		/**
		 * init other field here
		 */
		try {
			this.goodsBrandCategoryDao.save(goodsBrandCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoodsBrandCategory getObjById(Long id) {
		GoodsBrandCategory goodsBrandCategory = this.goodsBrandCategoryDao.get(id);
		if (goodsBrandCategory != null) {
			return goodsBrandCategory;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goodsBrandCategoryDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goodsBrandCategoryIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goodsBrandCategoryIds) {
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
//		GenericPageList pList = new GenericPageList(GoodsBrandCategory.class,construct,
//				query, params, this.goodsBrandCategoryDao);
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

	public boolean update(GoodsBrandCategory goodsBrandCategory) {
		try {
			this.goodsBrandCategoryDao.update(goodsBrandCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//	public List<GoodsBrandCategory> query(String query, Map params, int begin,
//			int max) {
//		return this.goodsBrandCategoryDao.query(query, params, begin, max);
//
//	}

//	@Override
//	public GoodsBrandCategory getObjByProperty(String construct,
//			String propertyName, Object value) {
//		// TODO Auto-generated method stub
//		return this.goodsBrandCategoryDao.getBy(construct, propertyName, value);
//	}
}
