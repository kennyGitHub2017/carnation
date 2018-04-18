package com.sinco.carnation.goods.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.dao.BrandFindVO;
import com.sinco.carnation.goods.dao.GoodsBrandCategoryDao;
import com.sinco.carnation.goods.dao.GoodsBrandDao;
import com.sinco.carnation.goods.dao.GoodsTypeBrandDao;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.vo.GoodsBrandShowIndexVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.dal.common.MyPage;

@Service
@Transactional
public class GoodsBrandService {
	@Autowired
	private GoodsBrandDao goodsBrandDao;

	@Autowired
	private GoodsBrandCategoryDao goodsBrandCategoryDao;

	@Autowired
	private GoodsTypeBrandDao goodsTypeBrandDao;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	/**
	 * 
	 * @param vo
	 * @return
	 */
	public List<GoodsBrandBO> findByShowIndex(GoodsBrandShowIndexVO vo) {
		return goodsBrandDao.findByShowIndex(vo);
	}

	/**
	 * 根据名称查询数量
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public int countByName(String name, Long id) {
		return goodsBrandDao.countByName(name, id);
	}

	/**
	 * 分页查询
	 * 
	 * @param brandFindVO
	 * @param page
	 * @return
	 */
	public List<GoodsBrandBO> findByPage(BrandFindVO brandFindVO, MyPage<GoodsBrandBO> page) {
		return goodsBrandDao.findByPage(brandFindVO, page);
	}

	/**
	 * 根据商品类型查找品牌
	 * 
	 * @param gcId
	 * @return
	 */
	public List<GoodsBrandBO> findByGoodsClass(Long gcId) {
		return goodsBrandDao.findByGoodsClass(gcId);
	}

	/**
	 * 根据商品类型查找品牌
	 * 
	 * @param gcId
	 * @return
	 */
	public List<GoodsBrandBO> findByGoodsType(Long gtId) {
		return goodsBrandDao.findByGoodsType(gtId);
	}

	public boolean save(HttpServletRequest request, GoodsBrand goodsBrand, String catName) {

		// 上传品牌图片
		String brandLogo = accessoryService.upload(request, "brandLogo", goodsBrand.getBrandLogoId());
		goodsBrand.setBrandLogoId(brandLogo);

		if (goodsBrand.getId() == null) {
			goodsBrand.setAddTime(new Date());
			goodsBrand.setAudit(1);
			goodsBrand.setUserStatus(0);
		}

		/*	GoodsBrandCategory cat = this.goodsBrandCategoryDao.findByName(catName);
			if (cat == null) {
				cat = new GoodsBrandCategory();
				cat.setAddtime(new Date());
				cat.setName(catName);
				this.goodsBrandCategoryDao.save(cat);
			} */
		/*goodsBrand.setCategoryId(cat.getId());*/

		this.goodsBrandDao.save(goodsBrand);

		return true;
	}

	public GoodsBrandBO findBOById(Long id) {
		return this.goodsBrandDao.findBOById(id);
	}

	public GoodsBrand getObjById(Long id) {
		GoodsBrand goodsBrand = this.goodsBrandDao.get(id);
		if (goodsBrand != null) {
			return goodsBrand;
		}
		return null;
	}

	public boolean delete(Long id) {
		GoodsBrand gb = new GoodsBrand();
		gb.setDeleteStatus(true);
		gb.setId(id);
		goodsBrandDao.update(gb);

		return true;
	}

	public boolean batchDelete(List<Long> goodsBrandIds) {
		GoodsBrand gb = new GoodsBrand();

		gb.setDeleteStatus(true);

		goodsBrandDao.updateByIds(gb, goodsBrandIds);

		// 删除与商品类型的关系
		for (Long gbId : goodsBrandIds) {
			goodsTypeBrandDao.deleteByBrandId(gbId);
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
//		GenericPageList pList = new GenericPageList(GoodsBrand.class, construct,query,
//				params, this.goodsBrandDao);
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

	public boolean update(GoodsBrand goodsBrand) {
		this.goodsBrandDao.update(goodsBrand);
		return true;
	}

	public List<GoodsBrand> findAll() {
		return this.goodsBrandDao.findAll();

	}
	
	public List<GoodsBrandBO> selectByAll()
	{
		return this.goodsBrandDao.selectByAll();
	}
	
	public List<GoodsBrandBO> findByVo(GoodsBrand GoodsBrand) {
		return this.goodsBrandDao.findByVo(GoodsBrand);
	}

	/***
	 * 品牌馆,左侧菜单
	 * 
	 * @param goodsBrand
	 * @return
	 */
	public List<GoodsBrandBO> groupGoodsBrand(GoodsBrand goodsBrand) {
		List<GoodsBrandCategoryBO> categoryList = goodsBrandCategoryDao.findAll();
		List<GoodsBrandBO> goodsBrandBoAll = this.findByVo(goodsBrand);

		List<GoodsBrandBO> list = new ArrayList<GoodsBrandBO>();
		GoodsBrandBO setBrandBo = null;
		List<GoodsBrandBO> list1 = null;

		for (GoodsBrandCategoryBO cb : categoryList) {
			list1 = new ArrayList<GoodsBrandBO>();
			setBrandBo = new GoodsBrandBO();
			for (GoodsBrandBO gb : goodsBrandBoAll) {
				if (cb.getName().equals(gb.getCategoryName())) {
					list1.add(gb);
				}
			}
			setBrandBo.setBrandBoList(list1);
			setBrandBo.setCategoryName(cb.getName());
			list.add(setBrandBo);
		}
		return list;
	}
}
