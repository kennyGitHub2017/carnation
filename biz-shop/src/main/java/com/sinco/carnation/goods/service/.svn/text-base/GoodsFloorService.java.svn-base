package com.sinco.carnation.goods.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.dao.GoodsFloorDao;
import com.sinco.carnation.goods.model.GoodsFloor;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GoodsFloorService {
	@Autowired
	private GoodsFloorDao goodsFloorDao;

	/**
	 * 查询分级的数据
	 * 
	 * @param parentId
	 * @return
	 */
	public GoodsFloorBO findLevelById(Long id) {
		return goodsFloorDao.findLevelById(id);
	}

	/**
	 * 查询分级的数据
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsFloorBO> findLevelByDisplay(Boolean display) {
		return goodsFloorDao.findLevelByDisplay(display);
	}

	/**
	 * 查询子
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsFloorBO> findByParent(Long parentId) {
		return goodsFloorDao.findByParent(parentId);
	}

	/**
	 * 分布查询
	 * 
	 * @param level
	 * @param page
	 * @return
	 */
	public List<GoodsFloorBO> findByPage(Integer level, MyPage<GoodsFloorBO> page) {
		return goodsFloorDao.findByPage(level, page);
	}

	/**
	 * 根据级别查找
	 * 
	 * @param level
	 * @return
	 */
	public List<GoodsFloorBO> findByLevel(Integer level) {
		return goodsFloorDao.findByLevel(level);
	}

	public GoodsFloorBO findBOById(Long id, boolean isLoadAll) {
		GoodsFloorBO bo = goodsFloorDao.findBOById(id);

		if (bo != null && isLoadAll) {
			bo.setChilds(this.goodsFloorDao.findByParent(bo.getId()));
		}
		return bo;
	}

	public boolean save(GoodsFloor goodsFloor) {
		if (goodsFloor.getId() != null) {
			goodsFloor.setAddTime(new Date());
		}

		this.goodsFloorDao.save(goodsFloor);
		return true;
	}

	public GoodsFloor getObjById(Long id) {
		GoodsFloor goodsFloor = this.goodsFloorDao.get(id);
		if (goodsFloor != null) {
			return goodsFloor;
		}
		return null;
	}

	public boolean delete(Long id) {

		this.goodsFloorDao.deleteByParent(id);

		this.goodsFloorDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Long> goodsFloorIds) {
		// TODO Auto-generated method stub
		for (Long id : goodsFloorIds) {
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
//		GenericPageList pList = new GenericPageList(GoodsFloor.class,construct, query,
//				params, this.goodsFloorDao);
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
	public boolean update(GoodsFloor goodsFloor) {
		try {
			this.goodsFloorDao.update(goodsFloor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
