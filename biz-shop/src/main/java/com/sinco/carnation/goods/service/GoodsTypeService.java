package com.sinco.carnation.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;
import com.sinco.carnation.goods.dao.GoodsBrandDao;
import com.sinco.carnation.goods.dao.GoodsTypeBrandDao;
import com.sinco.carnation.goods.dao.GoodsTypeDao;
import com.sinco.carnation.goods.dao.GoodsTypePropertyDao;
import com.sinco.carnation.goods.model.GoodsType;
import com.sinco.carnation.goods.model.GoodsTypeBrand;
import com.sinco.carnation.goods.model.GoodsTypeProperty;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GoodsTypeService {
	@Autowired
	private GoodsTypeDao goodsTypeDao;

	@Autowired
	private GoodsTypeBrandDao gtbDao;

	@Autowired
	private GoodsTypePropertyDao gtpDao;

	@Autowired
	private GoodsBrandDao goodsBrandDao;

	/**
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		return goodsTypeDao.countByName(name, id);
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	public List<GoodsTypeBO> findByPage(MyPage<GoodsTypeBO> page) {
		return goodsTypeDao.findByPage(page);
	}

	public List<GoodsTypeBO> findAll() {
		return goodsTypeDao.findAll();
	}

	public boolean save(GoodsType goodsType, List<Long> brandIds, List<GoodsTypeProperty> gtps) {

		if (goodsType.getId() != null) {
			// 删除品牌关系
			gtbDao.deleteByTypeId(goodsType.getId());
		}

		this.goodsTypeDao.save(goodsType);

		// 保存与品牌关系
		List<GoodsTypeBrand> gtbs = Lists.newArrayList();
		for (Long bid : brandIds) {
			GoodsTypeBrand gtb = new GoodsTypeBrand();
			gtb.setTypeId(goodsType.getId());
			gtb.setBrandId(bid);
			gtbs.add(gtb);
		}
		gtbDao.save(gtbs);

		// 保存属性
		for (GoodsTypeProperty gtp : gtps) {
			gtp.setGoodsTypeId(goodsType.getId());
		}
		gtpDao.save(gtps);

		return true;
	}

	public GoodsType getObjById(Long id) {
		GoodsType goodsType = this.goodsTypeDao.get(id);
		if (goodsType != null) {
			return goodsType;
		}
		return null;
	}

	public GoodsTypeBO getBOById(Long id) {
		GoodsTypeBO goodsType = this.goodsTypeDao.getBO(id);
		if (goodsType != null) {
			List<GoodsBrandBO> gbs = this.goodsBrandDao.findByGoodsType(goodsType.getId());
			goodsType.setGbs(gbs);
			List<GoodsTypePropertyBO> properties = this.gtpDao.findByGoodsType(goodsType.getId());
			goodsType.setProperties(properties);
		}

		return goodsType;
	}

	public boolean delete(Long id) {

		this.goodsTypeDao.remove(id);

		// 删除品牌关系
		this.gtbDao.deleteByTypeId(id);

		// 删除属性
		this.gtpDao.deleteByGoodsTypeId(id);

		return true;
	}

	public boolean batchDelete(List<Long> goodsTypeIds) {
		// TODO Auto-generated method stub
		for (Long id : goodsTypeIds) {
			delete(id);
		}
		return true;
	}

	public boolean update(GoodsType goodsType) {
		try {
			this.goodsTypeDao.update(goodsType);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
